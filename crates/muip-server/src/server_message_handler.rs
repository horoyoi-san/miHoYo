use tracing::warn;

use crate::AppState;

pub async fn handle_message(_state: &'static AppState, packet: trigger_sv::message::NetworkPacket) {
    match packet.opcode {
        opcode => warn!("unhandled server message, opcode: {opcode}"),
    }
}
