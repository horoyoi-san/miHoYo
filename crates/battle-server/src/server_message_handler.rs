use tokio::sync::Mutex;
use tracing::{debug, error, warn};
use trigger_protocol::EnterSceneScNotify;
use trigger_sv::{
    message::{
        BindClientSessionMessage, BindClientSessionOkMessage, ChangeGameStateMessage,
        ForwardClientProtocolMessage, GameStateCallback, GameStateCallbackMessage, Header,
        UnbindClientSessionMessage, WithOpcode,
    },
    net::ServerType,
};

use crate::{logic::GameState, session::BattleSession, AppState};

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
                on_forward_client_message(state, packet.header, message).await;
            }
        }
        opcode => warn!("unhandled server message, opcode: {opcode}"),
    }
}

async fn on_change_game_state(
    state: &'static AppState,
    _header: Header,
    message: ChangeGameStateMessage,
) {
    let Some(session) = state.sessions.get(&message.session_id) else {
        return;
    };

    let mut session = session.lock().await;

    debug!(
        "changing game state for player with uid {}, request: {:?}",
        session.player_uid, message
    );

    let Some(game_state) = GameState::new(&state.filecfg, &message.data) else {
        error!("unsupported game state data received: {:?}", message.data);
        return;
    };

    debug!(
        "created fight scene for player with uid {}: quest_id: {}, play_type: {:?}",
        session.player_uid,
        game_state.dungeon.quest_id,
        game_state.scene.get_play_type()
    );

    let enter_scene_notify = EnterSceneScNotify {
        scene_info: Some(game_state.scene.get_protocol_scene_info()),
        dungeon_info: Some(game_state.dungeon.get_protocol_dungeon_info()),
    };

    session.game_state = Some(game_state);

    state
        .network_mgr
        .send_to(
            ServerType::GameServer,
            0,
            GameStateCallbackMessage {
                session_id: session.id,
                protocol_units: vec![enter_scene_notify.into()],
                scene_save_data: None,
                callback: GameStateCallback::Loaded,
            },
        )
        .await;
}

async fn on_forward_client_message(
    state: &'static AppState,
    _header: Header,
    message: ForwardClientProtocolMessage,
) {
    let Some(session) = state.sessions.get(&message.session_id) else {
        return;
    };

    let mut session = session.lock().await;

    for callback in crate::session::message::handle_client_message(
        &mut session,
        message.request_id,
        message.message,
    ) {
        state
            .network_mgr
            .send_to(
                ServerType::GameServer,
                0,
                GameStateCallbackMessage {
                    session_id: session.id,
                    protocol_units: Vec::new(),
                    scene_save_data: None,
                    callback,
                },
            )
            .await;
    }
}

async fn on_unbind_client_session(
    state: &'static AppState,
    _header: Header,
    message: UnbindClientSessionMessage,
) {
    if let Some((_, session)) = state.sessions.remove(&message.session_id) {
        let session = session.lock().await;
        debug!(
            "unregistered session with id {} (player_uid: {})",
            session.id, session.player_uid
        );
    }
}

async fn on_bind_client_session(
    state: &'static AppState,
    header: Header,
    message: BindClientSessionMessage,
) {
    state.sessions.insert(
        message.session_id,
        Mutex::new(BattleSession {
            id: message.session_id,
            player_uid: message.player_uid,
            game_state: None,
        }),
    );

    debug!(
        "registered new session, id: {}, player_uid: {}",
        message.session_id, message.player_uid
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
