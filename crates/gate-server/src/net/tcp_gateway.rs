use std::{io, net::SocketAddr};

use tokio::net::TcpListener;
use tracing::info;

use crate::{message_handler::MessageHandler, AppState};

pub async fn serve(
    addr: SocketAddr,
    state: &'static AppState,
    message_handler: MessageHandler,
) -> io::Result<()> {
    let listener = TcpListener::bind(addr).await?;
    info!("listening at tcp://{addr}");

    loop {
        let Ok((stream, addr)) = listener.accept().await else {
            continue;
        };

        let connection = state.connection_mgr.create(
            &state.network_mgr,
            addr,
            &state.environment.security.static_key.xorpad,
        );

        connection.start(stream, message_handler.clone());
        info!("new connection from {addr}");
    }
}
