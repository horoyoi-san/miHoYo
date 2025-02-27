use tokio::sync::mpsc;
use tracing::warn;

use crate::{net::NetPacket, AppState};

#[derive(Clone)]
pub struct MessageHandler(mpsc::UnboundedSender<(u64, NetPacket)>);

impl MessageHandler {
    pub fn new(state: &'static AppState) -> Self {
        let (tx, rx) = mpsc::unbounded_channel();

        tokio::spawn(Self::handler_loop(state, rx));
        Self(tx)
    }

    pub fn enqueue(&self, session_id: u64, packet: NetPacket) {
        let _ = self.0.send((session_id, packet));
    }

    async fn handler_loop(
        state: &'static AppState,
        mut rx: mpsc::UnboundedReceiver<(u64, NetPacket)>,
    ) {
        while let Some((session_id, packet)) = rx.recv().await {
            if let Some(connection) = state.connection_mgr.get(session_id) {
                crate::handlers::client::handle_message(connection.as_ref(), state, packet).await;
            } else {
                warn!("connection with session_id {session_id} doesn't exist");
            }
        }
    }
}
