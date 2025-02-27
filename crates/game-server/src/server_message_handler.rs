use std::sync::Arc;

use crate::{
    logic::{gm_util, NapPlayer},
    session::GameSession,
    AppState,
};
use tokio::sync::Mutex;
use tracing::{debug, info, warn};
use trigger_sv::{message::*, net::ServerType};

pub async fn handle_message(state: &'static AppState, packet: trigger_sv::message::NetworkPacket) {
    match packet.opcode {
        BindClientSessionMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_bind_client_session(state, packet.header, message).await;
            }
        }
        UnbindClientSessionMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_unbind_client_session(state, packet.header, message).await;
            }
        }
        BindClientSessionOkMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_bind_client_session_ok(state, packet.header, message).await;
            }
        }
        ForwardClientProtocolMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_forward_client_protocol_message(state, packet.header, message).await;
            }
        }
        GameStateCallbackMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_game_state_callback(state, packet.header, message).await;
            }
        }
        PlayerGmCommandMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_player_gm_command(state, packet.header, message).await;
            }
        }
        opcode => warn!("unhandled server message, opcode: {opcode}"),
    }
}

#[tracing::instrument(skip_all)]
async fn on_player_gm_command(
    state: &'static AppState,
    _header: Header,
    message: PlayerGmCommandMessage,
) {
    if let Some(player) = state
        .players
        .get(&message.player_uid)
        .map(|pl| Arc::clone(&pl))
    {
        debug!(
            "player with uid {} is online, emitted notifies will be sent to client after execution",
            message.player_uid
        );

        let mut player = player.lock().await;
        let mut context = gm_util::CommandContext::new(&mut *player, state);

        gm_util::execute_command(&mut context, &message.command).await;
        let notifies = context.remove_notifies();

        if let Some(session_id) = player.active_session_id {
            state
                .network_mgr
                .send_to(
                    ServerType::GateServer,
                    0,
                    AvailableServerProtocolMessage {
                        session_id,
                        ack_request_id: 0,
                        notifies,
                        response: None,
                    },
                )
                .await;
        }
    } else if let Some(mut player) =
        NapPlayer::load(message.player_uid, false, &state.database, &state.filecfg).await
    {
        debug!(
            "player with uid {} is offline, changes will be committed to the database",
            message.player_uid
        );

        let mut context = gm_util::CommandContext::new(&mut player, state);
        gm_util::execute_command(&mut context, &message.command).await;
    } else {
        debug!("player with uid {} doesn't exist", message.player_uid);
    }
}

#[tracing::instrument(skip_all)]
async fn on_game_state_callback(
    state: &'static AppState,
    _header: Header,
    message: GameStateCallbackMessage,
) {
    let Some(session) = state
        .sessions
        .get(&message.session_id)
        .map(|s| Arc::clone(&s))
    else {
        return;
    };

    let Some(player) = state
        .players
        .get(&session.player_uid)
        .map(|p| Arc::clone(&p))
    else {
        return;
    };

    let mut player = player.lock().await;

    info!(
        "emitted notifies: {}, callback: {:?}",
        message.protocol_units.len(),
        message.callback
    );

    if let Some(ext) = message.scene_save_data {
        let cur_scene = player.scene_model.get_current_scene().await.unwrap();

        player
            .scene_model
            .update_scene_ext(cur_scene.scene_uid, ext)
            .await;
    }

    match message.callback {
        GameStateCallback::Loaded => {
            session.on_game_state_loaded(message.protocol_units).await;
        }
        GameStateCallback::ClientCmdProcessed {
            ack_request_id,
            response,
        } => {
            if ack_request_id != 0 && response.is_some() {
                state
                    .network_mgr
                    .send_to(
                        ServerType::GateServer,
                        0,
                        AvailableServerProtocolMessage {
                            session_id: session.id,
                            ack_request_id,
                            notifies: message.protocol_units,
                            response,
                        },
                    )
                    .await;
            }
        }
        GameStateCallback::PlayerItemsGiven { changes: _ } => (), // TODO
    }
}

async fn on_bind_client_session_ok(
    state: &'static AppState,
    header: Header,
    message: BindClientSessionOkMessage,
) {
    if let Some(session) = state
        .sessions
        .get(&message.session_id)
        .map(|s| Arc::clone(&s))
    {
        session
            .on_server_bound(header.sender_type.try_into().unwrap(), header.sender_id)
            .await;
    }
}

async fn on_forward_client_protocol_message(
    state: &'static AppState,
    header: Header,
    message: ForwardClientProtocolMessage,
) {
    if header.sender_type != u8::from(ServerType::GateServer) {
        // Client messages should be forwarded only from the gateway.
        return;
    }

    let Some(session) = state
        .sessions
        .get(&message.session_id)
        .map(|s| Arc::clone(&s))
    else {
        debug!(
            "ForwardClientProtocolMessage: received message for unregistered session with id: {}",
            message.session_id
        );
        return;
    };

    let Some(player) = state
        .players
        .get(&session.player_uid)
        .map(|p| Arc::clone(&p))
    else {
        return;
    };

    let mut player = player.lock().await;
    if let Some(available_server_protocol) =
        { crate::session::message::handle_message(state, &session, &mut *player, message).await }
    {
        state
            .network_mgr
            .send_to(
                ServerType::GateServer,
                header.sender_id,
                available_server_protocol,
            )
            .await;
    }
}

async fn on_unbind_client_session(
    state: &'static AppState,
    header: Header,
    message: UnbindClientSessionMessage,
) {
    if ServerType::GateServer == ServerType::try_from(header.sender_type).unwrap() {
        if let Some((id, session)) = state.sessions.remove(&message.session_id) {
            session.unbind_all_servers(false).await;
            debug!("session with id {id} unregistered");
        }
    }
}

async fn on_bind_client_session(
    state: &'static AppState,
    header: Header,
    message: BindClientSessionMessage,
) {
    if header.sender_type != u8::from(ServerType::GateServer) {
        // Only gate server is allowed to request session creation on game server.
        return;
    }

    let mut player = NapPlayer::load(message.player_uid, true, &state.database, &state.filecfg)
        .await
        .unwrap();

    if player.is_new_player {
        // Run GM auto-exec commands on first login to unlock items
        let mut command_context = gm_util::CommandContext::new(&mut player, state);
        for command in state.gm_autoexec.commands.iter() {
            gm_util::execute_command(&mut command_context, command).await;
        }
    }

    player.active_session_id = Some(message.session_id);

    state.sessions.insert(
        message.session_id,
        Arc::new(GameSession::new(
            &state.network_mgr,
            message.session_id,
            message.player_uid,
            header.sender_id,
        )),
    );

    state
        .players
        .insert(message.player_uid, Arc::new(Mutex::new(player)));

    debug!(
        "registered new session, id: {}, player uid: {}",
        message.session_id, message.player_uid
    );

    state
        .network_mgr
        .send_to(
            ServerType::GateServer,
            header.sender_id,
            BindClientSessionOkMessage {
                session_id: message.session_id,
            },
        )
        .await;
}
