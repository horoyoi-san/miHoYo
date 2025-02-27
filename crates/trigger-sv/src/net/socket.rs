use std::io::Cursor;
use std::net::SocketAddr;
use std::time::Duration;

use tokio::sync::mpsc;
use tracing::warn;
use trigger_encoding::Encodeable;
use zeromq::prelude::*;
use zeromq::PushSocket;

use crate::message::NetworkPacket;

#[derive(Clone)]
pub struct ServerSocket(mpsc::Sender<Box<[u8]>>);

impl ServerSocket {
    const CONNECT_REPEAT_TIMEOUT: Duration = Duration::from_millis(500);

    pub fn new(addr: SocketAddr) -> Self {
        let (tx, rx) = mpsc::channel(64);
        tokio::spawn(Self::worker_loop(format!("tcp://{addr}"), rx));

        Self(tx)
    }

    pub async fn send(&self, data: NetworkPacket) {
        let mut buf = Vec::with_capacity(data.encoding_length());
        data.encode(&mut Cursor::new(&mut buf)).unwrap();

        let _ = self.0.send(buf.into_boxed_slice()).await;
    }

    pub fn blocking_send(&self, data: NetworkPacket) {
        let mut buf = Vec::with_capacity(data.encoding_length());
        data.encode(&mut Cursor::new(&mut buf)).unwrap();

        let _ = self.0.blocking_send(buf.into_boxed_slice());
    }

    async fn worker_loop(endpoint: String, mut rx: mpsc::Receiver<Box<[u8]>>) {
        let mut socket = Self::connect_to(&endpoint).await;

        while let Some(buf) = rx.recv().await {
            while socket
                .send(buf.to_vec().into())
                .await
                .inspect_err(|err| warn!("zmq::socket::send failed: {err}"))
                .is_err()
            {
                socket = Self::connect_to(&endpoint).await;
            }
        }
    }

    async fn connect_to(endpoint: &str) -> PushSocket {
        let mut socket = PushSocket::new();

        while socket.connect(endpoint).await.is_err() {
            tokio::time::sleep(Self::CONNECT_REPEAT_TIMEOUT).await;
        }

        socket
    }
}
