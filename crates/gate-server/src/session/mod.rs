use std::sync::{
    atomic::{AtomicI64, Ordering::SeqCst},
    OnceLock,
};

use atomic_enum::atomic_enum;
use trigger_protobuf::{PacketHead, PlayerLoginScRsp};
use trigger_sv::{
    message::UnbindClientSessionMessage,
    net::{ServerNetworkManager, ServerType},
    time_util,
};

use crate::net::Connection;

#[atomic_enum]
#[derive(PartialEq, Eq)]
pub enum SessionState {
    LoginFailed,
    GetToken,
    Login,
    LoggedIn,
}

pub struct ClientSession {
    pub id: u64,
    network_mgr: &'static ServerNetworkManager,
    player_uid: OnceLock<u32>,
    state: AtomicSessionState,
    logged_in: OnceLock<()>,
    last_keep_alive: AtomicI64,
}

impl ClientSession {
    const ALIVE_TIMEOUT_SECONDS: i64 = 30;

    pub fn new(network_mgr: &'static ServerNetworkManager, id: u64) -> Self {
        Self {
            id,
            network_mgr,
            player_uid: OnceLock::new(),
            state: AtomicSessionState::new(SessionState::GetToken),
            logged_in: OnceLock::new(),
            last_keep_alive: AtomicI64::new(time_util::cur_timestamp_seconds()),
        }
    }

    pub fn refresh_keep_alive_time(&self) {
        self.last_keep_alive
            .store(time_util::cur_timestamp_seconds(), SeqCst);
    }

    pub fn is_alive(&self) -> bool {
        (time_util::cur_timestamp_seconds() - self.last_keep_alive.load(SeqCst))
            < Self::ALIVE_TIMEOUT_SECONDS
    }

    pub fn state(&self) -> SessionState {
        self.state.load(SeqCst)
    }

    pub fn is_logged_in(&self) -> bool {
        self.logged_in.get().is_some()
    }

    pub fn player_uid(&self) -> u32 {
        self.player_uid.get().copied().unwrap_or_default()
    }

    pub fn set_login_failed(&self) {
        self.state.store(SessionState::LoginFailed, SeqCst);
    }

    pub fn on_player_get_token_ok(&self, player_uid: u32) {
        let _ = self
            .player_uid
            .set(player_uid)
            .inspect_err(|_| panic!("on_player_get_token_ok: player_uid already set!"));

        assert_eq!(
            self.state.swap(SessionState::Login, SeqCst),
            SessionState::GetToken
        );

        let _ = self.logged_in.set(());
    }

    pub async fn on_game_server_bound(&self, active_connection: &Connection) {
        assert_eq!(
            self.state.swap(SessionState::LoggedIn, SeqCst),
            SessionState::Login
        );

        // Login finished, client will now start BasicDataSync procedure
        active_connection
            .send_pb(
                PacketHead {
                    packet_id: active_connection.next_packet_id(),
                    request_id: 1, // always '1' for PlayerLoginCsReq/ScRsp request pair
                    ..Default::default()
                },
                PlayerLoginScRsp::default(),
            )
            .await;
    }

    pub async fn stop(&self) {
        if self.state() == SessionState::LoggedIn {
            self.network_mgr
                .send_to(
                    ServerType::GameServer,
                    0,
                    UnbindClientSessionMessage {
                        session_id: self.id,
                    },
                )
                .await;
        }
    }
}
