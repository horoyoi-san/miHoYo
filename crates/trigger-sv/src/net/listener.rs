use std::{future::Future, net::SocketAddr, time::Duration};

use futures::future::BoxFuture;
use tokio::task::JoinHandle;
use tracing::warn;
use trigger_encoding::Decodeable;
use zeromq::{prelude::*, PullSocket, ZmqError};

use crate::message::NetworkPacket;

pub trait RecvCallback<S>: Send + Sync {
    fn call(&self, state: S, data: NetworkPacket) -> BoxFuture<'static, ()>;
}

impl<T, F, S> RecvCallback<S> for T
where
    T: Fn(S, NetworkPacket) -> F + Send + Sync,
    F: Future<Output = ()> + 'static + Send,
    S: Send + Sync,
{
    fn call(&self, state: S, data: NetworkPacket) -> BoxFuture<'static, ()> {
        Box::pin(self(state, data))
    }
}

pub async fn listen<S: Send + Sync + Clone + 'static>(
    addr: SocketAddr,
    state: S,
    callback: impl RecvCallback<S> + 'static,
) -> Result<JoinHandle<()>, ZmqError> {
    let mut socket = PullSocket::new();
    socket.bind(&format!("tcp://{addr}")).await?;
    Ok(tokio::spawn(socket_recv_loop(socket, state, callback)))
}

async fn socket_recv_loop<S: Send + Sync + Clone>(
    mut socket: PullSocket,
    state: S,
    callback: impl RecvCallback<S>,
) {
    loop {
        // We should timeout on recv() due to bug in zmq.rs
        // it may stuck while one message is available and it still awaiting message from another server
        let Ok(mut message) = tokio::time::timeout(Duration::from_millis(50), socket.recv())
            .await
            .map(|m| m.unwrap().into_vecdeque())
        else {
            continue;
        };

        while let Some(data) = message.pop_front() {
            match NetworkPacket::decode(&mut iter_read::IterRead::new(data.iter())) {
                Ok(packet) => {
                    let _ = tokio::spawn(callback.call(state.clone(), packet));
                }
                Err(err) => warn!("failed to decode incoming packet: {err}"),
            }
        }
    }
}
