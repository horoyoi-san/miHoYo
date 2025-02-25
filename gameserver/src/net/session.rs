use std::{
    io::Error,
    net::SocketAddr,
    pin::Pin,
    sync::Arc,
    task::{Context, Poll},
};

use anyhow::Result;
use mhy_kcp::Kcp;
use prost::Message;
use proto::{CmdID, CmdPlayerType};
use tokio::{io::AsyncWrite, net::UdpSocket, sync::Mutex};

use crate::util;

use super::{packet::CommandHandler, NetPacket};

struct RemoteEndPoint {
    socket: Arc<UdpSocket>,
    addr: SocketAddr,
}

#[derive(Clone)]
pub struct PlayerSession {
    pub token: u32,
    kcp: Arc<Mutex<Kcp<RemoteEndPoint>>>,
    start_time: u64,
    pub is_destroyed: bool,
}

impl PlayerSession {
    pub fn new(socket: Arc<UdpSocket>, addr: SocketAddr, conv: u32, token: u32) -> Self {
        Self {
            token,
            kcp: Arc::new(Mutex::new(Kcp::new(
                conv,
                token,
                false,
                RemoteEndPoint { socket, addr },
            ))),
            start_time: util::cur_timestamp_secs(),
            is_destroyed: false,
        }
    }

    pub async fn consume(&mut self, buffer: &[u8]) -> Result<()> {
        {
            let mut kcp = self.kcp.lock().await;
            kcp.input(buffer)?;
            kcp.async_update(self.session_time() as u32).await?;
            kcp.async_flush().await?;
        }

        let mut packets = Vec::new();
        let mut buf = [0; 24756];
        while let Ok(length) = self.kcp.lock().await.recv(&mut buf) {
            packets.push(NetPacket::from(&buf[..length]));
        }

        for packet in packets {
            // TODO: Temporary fix
            if packet.cmd_type == CmdPlayerType::CmdPlayerLogoutCsReq as u16 {
                self.is_destroyed = true;
                return Ok(());
            };
            Self::on_message(self, packet.cmd_type, packet.body).await?;
        }

        self.kcp
            .lock()
            .await
            .async_update(self.session_time() as u32)
            .await?;
        Ok(())
    }

    pub async fn send(&self, body: impl Message + CmdID) -> Result<()> {
        let mut buf = Vec::new();
        body.encode(&mut buf)?;

        let payload: Vec<u8> = NetPacket {
            cmd_type: body.get_cmd_id(),
            head: Vec::new(),
            body: buf,
        }
        .into();

        let mut kcp = self.kcp.lock().await;
        kcp.send(&payload)?;
        kcp.async_flush().await?;
        kcp.async_update(self.session_time() as u32).await?;

        Ok(())
    }

    pub async fn send_raw(&self, payload: NetPacket) -> Result<()> {
        let mut kcp = self.kcp.lock().await;
        let payload: Vec<u8> = payload.into();
        kcp.send(&payload)?;
        kcp.async_flush().await?;
        kcp.async_update(self.session_time() as u32).await?;

        Ok(())
    }

    fn session_time(&self) -> u64 {
        util::cur_timestamp_secs() - self.start_time
    }
}

// Auto implemented
impl CommandHandler for PlayerSession {}

impl AsyncWrite for RemoteEndPoint {
    fn poll_write(
        self: Pin<&mut Self>,
        cx: &mut Context<'_>,
        buf: &[u8],
    ) -> Poll<Result<usize, Error>> {
        self.socket.poll_send_to(cx, buf, self.addr)
    }

    fn poll_flush(self: Pin<&mut Self>, _cx: &mut Context<'_>) -> Poll<Result<(), Error>> {
        Poll::Ready(Ok(()))
    }

    fn poll_shutdown(self: Pin<&mut Self>, _cx: &mut Context<'_>) -> Poll<Result<(), Error>> {
        Poll::Ready(Ok(()))
    }
}
