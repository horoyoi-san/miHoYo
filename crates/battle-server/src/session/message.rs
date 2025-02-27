use trigger_encoding::Decodeable;
use trigger_protocol::{util::ProtocolUnit, ClientCmdID, EndBattleCsReq};
use trigger_sv::message::GameStateCallback;

use super::BattleSession;

pub fn handle_client_message(
    session: &mut BattleSession,
    request_id: u32,
    message: ProtocolUnit,
) -> Vec<GameStateCallback> {
    let mut callbacks = Vec::new();

    match message.cmd_id {
        EndBattleCsReq::CMD_ID if session.game_state.is_some() => {
            if let Ok(message) = EndBattleCsReq::decode(&mut std::io::Cursor::new(&message.blob)) {
                callbacks.extend(
                    session
                        .game_state
                        .as_ref()
                        .unwrap()
                        .on_end_battle(request_id, message),
                );
            }
        }
        _ => (),
    }

    callbacks
}
