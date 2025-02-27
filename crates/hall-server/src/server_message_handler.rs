use tracing::{debug, error, warn};
use trigger_sv::message::{
    BindClientSessionMessage, BindClientSessionOkMessage, ChangeGameStateMessage,
    ForwardClientProtocolMessage, GameStateData, Header, UnbindClientSessionMessage, WithOpcode,
};

use crate::{
    logic::{GameStateListener, HallInitData},
    session::HallSession,
    AppState,
};

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
        ChangeGameStateMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_change_game_state(state, packet.header, message).await;
            }
        }
        ForwardClientProtocolMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_forward_client_protocol_message(state, packet.header, message).await;
            }
        }
        opcode => warn!("unhandled server message, opcode: {opcode}"),
    }
}

async fn on_forward_client_protocol_message(
    state: &'static AppState,
    _header: Header,
    message: ForwardClientProtocolMessage,
) {
    if let Some(session) = state.sessions.get(&message.session_id) {
        state
            .game_runner
            .client_input(session.player_uid, message.request_id, message.message);
    }
}

async fn on_change_game_state(
    state: &'static AppState,
    header: Header,
    message: ChangeGameStateMessage,
) {
    let Some(session) = state.sessions.get(&message.session_id) else {
        return;
    };

    debug!(
        "changing game state for player with uid {}, request: {:?}",
        session.player_uid, message
    );

    if let GameStateData::Hall {
        player_avatar_id,
        control_avatar_id,
        ext,
    } = message.data
    {
        let hall_init_data = HallInitData::load_from_save(player_avatar_id, control_avatar_id, ext)
            .unwrap_or_else(|| {
                HallInitData::create_default_init_data(
                    &state.filecfg,
                    &state.main_city_config,
                    player_avatar_id,
                    control_avatar_id,
                )
            });

        state.game_runner.create_scene(
            session.player_uid,
            hall_init_data,
            GameStateListener::new(session.id, header.sender_id, &state.network_mgr),
        );
    } else {
        error!("unsupported game state data received: {:?}", message.data);
    }
}

async fn on_unbind_client_session(
    state: &'static AppState,
    _header: Header,
    message: UnbindClientSessionMessage,
) {
    if let Some((_, session)) = state.sessions.remove(&message.session_id) {
        state.game_runner.destroy_scene(session.player_uid);
    }
}

async fn on_bind_client_session(
    state: &'static AppState,
    header: Header,
    message: BindClientSessionMessage,
) {
    state.sessions.insert(
        message.session_id,
        HallSession {
            id: message.session_id,
            player_uid: message.player_uid,
        },
    );

    state
        .network_mgr
        .send_to(
            header.sender_type.try_into().unwrap(),
            header.sender_id,
            BindClientSessionOkMessage {
                session_id: message.session_id,
            },
        )
        .await;
}
