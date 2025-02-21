mod listener;
mod socket;

use std::{collections::HashMap, io::Cursor, net::SocketAddr};

pub use listener::{listen, RecvCallback};
use num_enum::{IntoPrimitive, TryFromPrimitive};
pub use socket::ServerSocket;

use serde::Deserialize;
use tokio::task::JoinHandle;
use tracing::error;
use trigger_encoding::Encodeable;
use zeromq::ZmqError;

use crate::{
    config::ServerConfigurationEntry,
    message::{Header, NetworkPacket, WithOpcode},
};

#[repr(u8)]
#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash, Deserialize, IntoPrimitive, TryFromPrimitive)]
#[serde(rename_all = "kebab-case")]
pub enum ServerType {
    GateServer = 1,
    GameServer = 2,
    HallServer = 3,
    BattleServer = 4,
    MuipServer = 5,
}

pub type ServerID = u32;

pub struct ServerNetworkManager {
    pub own_server_type: ServerType,
    pub own_server_id: ServerID,
    pub own_socket_addr: SocketAddr,
    pub server_sockets: HashMap<(ServerType, u32), ServerSocket>,
}

impl ServerNetworkManager {
    pub fn new(
        server_type: ServerType,
        server_id: ServerID,
        server_list: &[ServerConfigurationEntry],
    ) -> Self {
        let Some(own_entry) = server_list
            .iter()
            .find(|entry| entry.server_type == server_type && entry.server_id == server_id)
        else {
            panic!("can't find this instance ({server_type:?}-{server_id}) in server list")
        };

        Self {
            own_server_type: server_type,
            own_server_id: server_id,
            own_socket_addr: own_entry.addr,
            server_sockets: server_list
                .iter()
                .filter(|entry| entry.server_type != server_type || entry.server_id != server_id)
                .map(|entry| {
                    (
                        (entry.server_type, entry.server_id),
                        ServerSocket::new(entry.addr),
                    )
                })
                .collect(),
        }
    }

    pub async fn send_to<M: Encodeable + WithOpcode>(
        &self,
        server_type: ServerType,
        server_id: ServerID,
        message: M,
    ) {
        if let Some(socket) = self.server_sockets.get(&(server_type, server_id)) {
            socket.send(self.build_network_packet(message)).await;
        } else {
            error!("ServerSocket for {server_type:?}-{server_id} does not exist");
        }
    }

    pub fn blocking_send_to<M: Encodeable + WithOpcode>(
        &self,
        server_type: ServerType,
        server_id: ServerID,
        message: M,
    ) {
        if let Some(socket) = self.server_sockets.get(&(server_type, server_id)) {
            socket.blocking_send(self.build_network_packet(message));
        } else {
            error!("ServerSocket for {server_type:?}-{server_id} does not exist");
        }
    }

    fn build_network_packet<M: Encodeable + WithOpcode>(&self, message: M) -> NetworkPacket {
        let mut payload = Vec::with_capacity(message.encoding_length());
        message.encode(&mut Cursor::new(&mut payload)).unwrap();

        NetworkPacket {
            opcode: message.opcode(),
            header: Header {
                sender_type: self.own_server_type.into(),
                sender_id: self.own_server_id,
            },
            payload,
        }
    }

    pub async fn start_listener<S: Send + Sync + Clone + 'static>(
        &self,
        state: S,
        callback: impl RecvCallback<S> + 'static,
    ) -> Result<JoinHandle<()>, ZmqError> {
        listener::listen(self.own_socket_addr, state, callback).await
    }
}
