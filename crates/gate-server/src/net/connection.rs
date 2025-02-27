use std::{
    io,
    net::SocketAddr,
    sync::{
        atomic::{AtomicU32, Ordering::SeqCst},
        Arc, OnceLock,
    },
    time::Duration,
};

use dashmap::DashMap;
use tokio::{io::AsyncReadExt, net::TcpStream, select, sync::mpsc};
use tokio::{
    io::{AsyncRead, AsyncWriteExt},
    net::tcp::{OwnedReadHalf, OwnedWriteHalf},
};
use tokio_util::sync::CancellationToken;
use tracing::debug;
use trigger_protobuf::{CmdID, NapMessage, PacketHead, PlayerGetTokenScRsp};
use trigger_sv::net::ServerNetworkManager;

use crate::{message_handler::MessageHandler, session::ClientSession};

use super::packet::NetPacket;

pub struct Connection {
    pub session: ClientSession,
    send_packet_tx: OnceLock<mpsc::Sender<NetPacket>>,
    net_variables: Arc<NetVariables>,
    io_cancellation: OnceLock<CancellationToken>,
}

#[derive(Debug, thiserror::Error)]
enum RecvError {
    #[error("{0}")]
    Io(#[from] io::Error),
    #[error("packet magic const mismatch, stream is corrupted")]
    MagicMismatch,
}

struct NetVariables {
    pub addr: SocketAddr,
    pub session_id: u64,
    pub incremental_packet_id: AtomicU32,
    pub initial_key: &'static [u8],
    pub secret_key: OnceLock<[u8; 4096]>,
    pub recv_loop_exited: OnceLock<()>,
}

impl NetVariables {
    pub fn key(&self) -> &[u8] {
        self.secret_key.get().map_or(self.initial_key, |v| v)
    }
}

impl Connection {
    pub fn new(
        network_mgr: &'static ServerNetworkManager,
        session_id: u64,
        initial_key: &'static [u8],
        addr: SocketAddr,
    ) -> Self {
        Self {
            session: ClientSession::new(network_mgr, session_id),
            send_packet_tx: OnceLock::new(),
            io_cancellation: OnceLock::new(),
            net_variables: Arc::new(NetVariables {
                addr,
                session_id,
                initial_key,
                secret_key: OnceLock::new(),
                incremental_packet_id: AtomicU32::new(0),
                recv_loop_exited: OnceLock::new(),
            }),
        }
    }

    pub fn is_connected(&self) -> bool {
        self.net_variables.recv_loop_exited.get().is_none() && self.session.is_alive()
    }

    pub fn addr(&self) -> SocketAddr {
        self.net_variables.addr
    }

    pub fn start(&self, stream: TcpStream, message_handler: MessageHandler) {
        let (r, w) = stream.into_split();
        let (tx, rx) = mpsc::channel(32);

        let _ = self.send_packet_tx.set(tx);
        let io_cancellation = CancellationToken::new();

        tokio::spawn(Self::send_loop(w, rx, io_cancellation.clone()));
        tokio::spawn(Self::recv_loop(
            r,
            Arc::clone(&self.net_variables),
            message_handler,
            io_cancellation.clone(),
        ));

        let _ = self.io_cancellation.set(io_cancellation);
    }

    pub fn next_packet_id(&self) -> u32 {
        self.net_variables
            .incremental_packet_id
            .fetch_add(1, SeqCst)
            + 1
    }

    pub fn set_secret_key(&self, seed: u64) {
        let _ = self
            .net_variables
            .secret_key
            .set(trigger_cryptography::gen_xorpad(seed));
    }

    pub async fn send_pb(&self, head: PacketHead, mut message: impl NapMessage) {
        use trigger_protobuf::ProtobufMessage;

        message.xor_fields();
        self.internal_send(NetPacket {
            cmd_id: message.get_cmd_id(),
            head: head.encode_to_vec(),
            body: message.encode_to_vec(),
        })
        .await;
    }

    pub async fn send(&self, head: PacketHead, cmd_id: u16, body: Vec<u8>) {
        use trigger_protobuf::ProtobufMessage;

        self.internal_send(NetPacket {
            cmd_id,
            head: head.encode_to_vec(),
            body,
        })
        .await;
    }

    async fn internal_send(&self, mut packet: NetPacket) {
        if packet.cmd_id == PlayerGetTokenScRsp::CMD_ID {
            packet.xor(&self.net_variables.initial_key);
        } else {
            packet.xor(self.net_variables.key());
        }

        let _ = self.send_packet_tx.get().unwrap().send(packet).await;
    }

    async fn send_loop(
        mut w: OwnedWriteHalf,
        mut rx: mpsc::Receiver<NetPacket>,
        io_cancellation: CancellationToken,
    ) {
        loop {
            select! {
                packet = rx.recv() => {
                    match packet {
                        Some(packet) => w.write_all(&Vec::from(packet)).await.unwrap(),
                        None => break,
                    }
                },
                _ = io_cancellation.cancelled() => break,
            }
        }
    }

    async fn recv_loop(
        mut r: OwnedReadHalf,
        variables: Arc<NetVariables>,
        message_handler: MessageHandler,
        io_cancellation: CancellationToken,
    ) {
        while let Ok(mut packet) = Self::recv(&mut r).await {
            packet.xor(variables.key());
            message_handler.enqueue(variables.session_id, packet);
        }

        let _ = variables.recv_loop_exited.set(());
        io_cancellation.cancel();

        debug!("client from {} disconnected", variables.addr);
    }

    async fn recv<R: AsyncRead + Unpin>(r: &mut R) -> Result<NetPacket, RecvError> {
        let mut buf = [0u8; 12];
        r.read_exact(&mut buf).await?;

        (buf[0..4] == NetPacket::HEAD_MAGIC)
            .then_some(())
            .ok_or(RecvError::MagicMismatch)?;

        let cmd_id = u16::from_be_bytes(buf[4..6].try_into().unwrap());
        let head_len = u16::from_be_bytes(buf[6..8].try_into().unwrap()) as usize;
        let body_len = u32::from_be_bytes(buf[8..12].try_into().unwrap()) as usize;

        let mut payload = vec![0u8; head_len + body_len + 4];
        r.read_exact(&mut payload).await?;

        (payload[payload.len() - 4..payload.len()] == NetPacket::TAIL_MAGIC)
            .then_some(())
            .ok_or(RecvError::MagicMismatch)?;

        Ok(NetPacket {
            cmd_id,
            head: payload[..head_len].to_vec(),
            body: payload[head_len..head_len + body_len].to_vec(),
        })
    }

    pub fn shutdown(&self) {
        if let Some(io_cancellation) = self.io_cancellation.get() {
            io_cancellation.cancel();
        }
    }
}

pub struct ConnectionManager {
    connections: Arc<DashMap<u64, Arc<Connection>>>,
    counter: AtomicU32,
    server_id: u32,
}

impl ConnectionManager {
    pub fn new(server_id: u32) -> Self {
        let connections = Arc::new(DashMap::new());
        tokio::spawn(Self::alive_check_loop(Arc::clone(&connections)));

        Self {
            connections,
            counter: AtomicU32::default(),
            server_id,
        }
    }

    pub fn create(
        &self,
        network_mgr: &'static ServerNetworkManager,
        addr: SocketAddr,
        initial_key: &'static [u8],
    ) -> Arc<Connection> {
        let session_id =
            ((self.server_id as u64) << 32) | ((self.counter.fetch_add(1, SeqCst) + 1) as u64);

        let connection = Arc::new(Connection::new(network_mgr, session_id, initial_key, addr));
        self.connections.insert(session_id, Arc::clone(&connection));

        connection
    }

    pub fn get(&self, session_id: u64) -> Option<Arc<Connection>> {
        self.connections
            .get(&session_id)
            .map(|kv| Arc::clone(&kv.value()))
    }

    async fn alive_check_loop(connections: Arc<DashMap<u64, Arc<Connection>>>) {
        loop {
            let to_remove = connections
                .iter()
                .filter(|pair| !pair.value().is_connected())
                .map(|pair| *pair.key())
                .collect::<Vec<_>>();

            for id in to_remove {
                if let Some((_, connection)) = connections.remove(&id) {
                    connection.session.stop().await;
                    connection.shutdown();
                }
            }

            tokio::time::sleep(Duration::from_secs(5)).await;
        }
    }
}
