use tracing::{debug, info, warn};
use trigger_protobuf::{CmdID, PacketHead};
use trigger_sv::{
    message::{
        AvailableServerProtocolMessage, BindClientSessionOkMessage, Header,
        UnbindClientSessionMessage, WithOpcode,
    },
    net::ServerType,
};

use crate::AppState;

pub async fn handle_message(state: &'static AppState, packet: trigger_sv::message::NetworkPacket) {
    match packet.opcode {
        BindClientSessionOkMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_bind_client_session_ok(state, packet.header, message).await;
            }
        }
        AvailableServerProtocolMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_available_server_protocol(state, packet.header, message).await;
            }
        }
        UnbindClientSessionMessage::OPCODE => {
            if let Some(message) = packet.get_message() {
                on_unbind_client_session(state, packet.header, message).await;
            }
        }
        opcode => warn!("unhandled server message, opcode: {opcode}"),
    }
}

async fn on_unbind_client_session(
    state: &'static AppState,
    header: Header,
    message: UnbindClientSessionMessage,
) {
    if ServerType::GameServer == ServerType::try_from(header.sender_type).unwrap() {
        if let Some(connection) = state.connection_mgr.get(message.session_id) {
            connection.shutdown();
        }
    }
}

async fn on_available_server_protocol(
    state: &'static AppState,
    _header: Header,
    message: AvailableServerProtocolMessage,
) {
    if let Some(connection) = state.connection_mgr.get(message.session_id) {
        for notify in message.notifies {
            if let Ok(Some((cmd_id, body))) = trigger_protobuf::common_protocol_unit_to_pb(&notify)
            {
                let head = PacketHead {
                    packet_id: connection.next_packet_id(),
                    ..Default::default()
                };

                debug!("sending notify (cmd_id: {cmd_id})");
                connection.send(head, cmd_id, body).await;
            }
        }

        if let Some(response) = message.response {
            if let Ok(Some((cmd_id, body))) =
                trigger_protobuf::common_protocol_unit_to_pb(&response)
            {
                let head = PacketHead {
                    packet_id: connection.next_packet_id(),
                    request_id: message.ack_request_id,
                    ..Default::default()
                };

                debug!(
                    "sending response (ack_request_id: {}, rsp_cmd_id: {})",
                    message.ack_request_id, cmd_id
                );

                connection.send(head, cmd_id, body).await;
            } else {
                let head = PacketHead {
                    packet_id: connection.next_packet_id(),
                    request_id: message.ack_request_id,
                    ..Default::default()
                };

                debug!(
                    "sending response (using fallback, ack_request_id: {}, common_protocol_cmd_id: {})",
                    message.ack_request_id, response.cmd_id
                );

                connection
                    .send(
                        head,
                        trigger_protobuf::FallbackRsp::CMD_ID,
                        Vec::with_capacity(0),
                    )
                    .await;
            }
        }
    }
}

async fn on_bind_client_session_ok(
    state: &'static AppState,
    header: Header,
    message: BindClientSessionOkMessage,
) {
    if header.sender_type != u8::from(ServerType::GameServer) {
        return;
    }

    if let Some(connection) = state.connection_mgr.get(message.session_id) {
        info!(
            "successfully bound Game Server to client with session id {}",
            message.session_id
        );

        connection.session.on_game_server_bound(&connection).await;
    }
}
