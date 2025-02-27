use std::{
    collections::HashMap,
    net::SocketAddr,
    sync::{
        atomic::{AtomicU32, Ordering},
        Arc,
    },
};

use anyhow::Result;
use rand::RngCore;

use crate::net::PlayerSession;

use tokio::{
    net::UdpSocket,
    sync::{Mutex, RwLock},
};

use crate::net::packet::NetOperation;

const MAX_PACKET_SIZE: usize = 1400;

pub struct Gateway {
    socket: Arc<UdpSocket>,
    id_counter: AtomicU32,
    sessions: Mutex<HashMap<u32, Arc<RwLock<PlayerSession>>>>,
}

impl Gateway {
    pub async fn new(host: &str, port: u16) -> Result<Self> {
        let socket = Arc::new(UdpSocket::bind(format!("{host}:{port}")).await?);

        Ok(Self {
            socket,
            id_counter: AtomicU32::new(0),
            sessions: Mutex::new(HashMap::new()),
        })
    }

    pub async fn listen(&mut self) -> Result<()> {
        tracing::info!(
            "KCP Gateway is listening at {}",
            self.socket.local_addr().unwrap()
        );

        let mut buf = [0; MAX_PACKET_SIZE];
        loop {
            let Ok((len, addr)) = self.socket.recv_from(&mut buf).await else {
                continue;
            };

            match len {
                20 => self.process_net_operation(buf[..len].into(), addr).await?,
                28.. => self.process_kcp_payload(buf[..len].into(), addr).await,
                _ => {
                    tracing::warn!("unk data len {len}")
                }
            }
        }
    }

    async fn process_net_operation(&mut self, op: NetOperation, addr: SocketAddr) -> Result<()> {
        match (op.head, op.tail) {
            (0xFF, 0xFFFFFFFF) => self.establish_kcp_session(op.data, addr).await?,
            (0x194, 0x19419494) => self.drop_kcp_session(op.param1, op.param2, addr).await,
            _ => tracing::warn!("Unknown magic pair received {:X}-{:X}", op.head, op.tail),
        }

        Ok(())
    }

    async fn establish_kcp_session(&mut self, data: u32, addr: SocketAddr) -> Result<()> {
        let (conv_id, session_token) = self.next_conv_pair();
        tracing::info!("New connection from addr: {addr} with conv_id: {conv_id}");

        self.sessions.lock().await.insert(
            conv_id,
            Arc::new(RwLock::new(PlayerSession::new(
                self.socket.clone(),
                addr,
                conv_id,
                session_token,
            ))),
        );

        self.socket
            .send_to(
                &Vec::from(NetOperation {
                    head: 0x145,
                    param1: conv_id,
                    param2: session_token,
                    data,
                    tail: 0x14514545,
                }),
                addr,
            )
            .await?;

        Ok(())
    }

    async fn drop_kcp_session(&mut self, conv_id: u32, token: u32, addr: SocketAddr) {
        tracing::info!("drop_kcp_session {conv_id} {token}");
        let Some(session) = self.sessions.lock().await.get(&conv_id).cloned() else {
            tracing::warn!("drop_kcp_session failed, no session with conv_id {conv_id} was found");
            return;
        };

        if session.read().await.token == token {
            self.sessions.lock().await.remove(&conv_id);
            tracing::info!("Client from {addr} disconnected");
        }
    }

    async fn process_kcp_payload(&mut self, data: Box<[u8]>, addr: SocketAddr) {
        let conv_id = mhy_kcp::get_conv(&data);

        let Some(session) = self
            .sessions
            .lock()
            .await
            .get_mut(&conv_id)
            .map(|s| s.clone())
        else {
            tracing::warn!("Session with conv_id {conv_id} not found!");
            return;
        };

        // TODO: Temporary fix
        if session.read().await.is_destroyed {
            drop(session);
            self.sessions.lock().await.remove(&conv_id);
            return;
        }

        tokio::spawn(async move {
            if let Err(err) = Box::pin(session.write().await.consume(&data)).await {
                tracing::error!("An error occurred while processing session ({addr}): {err}");
            }
        });
    }

    fn next_conv_pair(&mut self) -> (u32, u32) {
        (
            self.id_counter.fetch_add(1, Ordering::SeqCst) + 1,
            rand::rng().next_u32(),
        )
    }
}
