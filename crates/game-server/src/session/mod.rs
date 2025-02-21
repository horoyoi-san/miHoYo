use std::{
    collections::HashMap,
    sync::{Mutex, RwLock},
};

use tracing::warn;
use trigger_database::entity::scene_info;
use trigger_logic::scene::ESceneType;
use trigger_protocol::util::ProtocolUnit;
use trigger_sv::{
    message::{
        AvailableServerProtocolMessage, BindClientSessionMessage, ChangeGameStateMessage,
        ForwardClientProtocolMessage, GameStateData, UnbindClientSessionMessage,
    },
    net::{ServerNetworkManager, ServerType},
};

use crate::logic::{scene_util, NapPlayer};

pub mod message;

pub struct GameSession {
    network_mgr: &'static ServerNetworkManager,
    bound_server_map: RwLock<HashMap<ServerType, u32>>,
    pub id: u64,
    pub player_uid: u32,
    pub current_state: Mutex<Option<SessionGameStateInfo>>,
}

pub struct SessionGameStateInfo {
    pub scene_uid: i64,
    pub state_server: ServerType,
    pub prepared_game_state_data: Option<GameStateData>,
    pub state_confirm_response: Option<AvailableServerProtocolMessage>,
}

impl GameSession {
    pub fn new(
        network_mgr: &'static ServerNetworkManager,
        id: u64,
        player_uid: u32,
        gate_id: u32,
    ) -> Self {
        Self {
            network_mgr,
            bound_server_map: RwLock::new(HashMap::from([(ServerType::GateServer, gate_id)])),
            id,
            player_uid,
            current_state: Mutex::new(None),
        }
    }

    pub async fn change_game_state(
        &self,
        ack_request_id: u32,
        response: impl Into<ProtocolUnit>,
        game_state_data: GameStateData,
        scene: &scene_info::Model,
        player: &mut NapPlayer,
        set_back_scene: bool,
    ) {
        self.unload_current_game_state().await;

        let scene_type = ESceneType::try_from(scene.scene_type).expect("invalid scene type");
        let state_server = scene_util::get_scene_logic_simulation_server_type(scene_type)
            .unwrap_or_else(|| todo!("scene type {scene_type:?}"));

        let response = AvailableServerProtocolMessage {
            session_id: self.id,
            ack_request_id,
            notifies: Vec::new(),
            response: Some(response.into()),
        };

        *self.current_state.lock().unwrap() = Some(SessionGameStateInfo {
            scene_uid: scene.scene_uid,
            state_server,
            prepared_game_state_data: Some(game_state_data),
            state_confirm_response: Some(response),
        });

        if set_back_scene {
            player.scene_model.push_current_scene(&scene).await;
        } else {
            player.scene_model.set_current_scene(&scene).await;
        }

        self.bind_server(state_server, 0).await;
    }

    pub async fn on_game_state_loaded(&self, notifies: Vec<ProtocolUnit>) {
        if let Some(mut response) = self.get_awaiting_state_response() {
            response.notifies = notifies;
            self.network_mgr
                .send_to(ServerType::GateServer, 0, response)
                .await;
        }
    }

    fn get_awaiting_state_response(&self) -> Option<AvailableServerProtocolMessage> {
        self.current_state
            .lock()
            .unwrap()
            .as_mut()
            .map(|state| state.state_confirm_response.take())
            .flatten()
    }

    pub fn get_cur_scene_uid(&self) -> Option<i64> {
        self.current_state
            .lock()
            .unwrap()
            .as_ref()
            .map(|state| state.scene_uid)
    }

    pub fn get_cur_state_server(&self) -> Option<ServerType> {
        self.current_state
            .lock()
            .unwrap()
            .as_ref()
            .map(|state| state.state_server)
    }

    async fn unload_current_game_state(&self) {
        if let Some(server_type) = self.get_cur_state_server() {
            self.unbind_server(server_type).await;
        }
    }

    async fn on_game_state_server_bound(&self) {
        if let Some(state_server) = self.get_cur_state_server() {
            if let Some(message) = self.build_change_game_state_message() {
                self.network_mgr
                    .send_to(
                        state_server,
                        self.get_bound_server_of_type(state_server).unwrap(),
                        message,
                    )
                    .await;
            }
        }
    }

    fn build_change_game_state_message(&self) -> Option<ChangeGameStateMessage> {
        let mut current_state = self.current_state.lock().unwrap();
        let Some(state) = current_state.as_mut() else {
            return None;
        };

        let data = match state.prepared_game_state_data.take() {
            Some(data) => data,
            None => {
                panic!(
                    "simulation server {:?} is bound, but game state data is not set!",
                    state.state_server
                )
            }
        };

        Some(ChangeGameStateMessage {
            session_id: self.id,
            scene_uid: state.scene_uid,
            data,
        })
    }

    pub async fn bind_server(&self, server_type: ServerType, server_id: u32) {
        self.network_mgr
            .send_to(
                server_type,
                server_id,
                BindClientSessionMessage {
                    session_id: self.id,
                    player_uid: self.player_uid,
                },
            )
            .await;
    }

    pub async fn unbind_server(&self, server_type: ServerType) {
        if let Some(server_id) = self.get_bound_server_of_type(server_type) {
            self.bound_server_map.write().unwrap().remove(&server_type);
            self.network_mgr
                .send_to(
                    server_type,
                    server_id,
                    UnbindClientSessionMessage {
                        session_id: self.id,
                    },
                )
                .await;
        }
    }

    pub async fn unbind_all_servers(&self, unbind_gateway: bool) {
        let server_map = std::mem::take(&mut *self.bound_server_map.write().unwrap());
        for (server_type, server_id) in server_map.into_iter() {
            if server_type != ServerType::GateServer || unbind_gateway {
                self.network_mgr
                    .send_to(
                        server_type,
                        server_id,
                        UnbindClientSessionMessage {
                            session_id: self.id,
                        },
                    )
                    .await;
            }
        }
    }

    pub async fn on_server_bound(&self, server_type: ServerType, server_id: u32) {
        self.bound_server_map
            .write()
            .unwrap()
            .insert(server_type, server_id);

        if let Some(state_server) = self.get_cur_state_server() {
            if state_server == server_type {
                self.on_game_state_server_bound().await;
            }
        }
    }

    pub async fn forward_client_message<Message: Into<ProtocolUnit>>(
        &self,
        message: Message,
        destination: ServerType,
        request_id: u32,
    ) {
        let server_id = self
            .bound_server_map
            .read()
            .unwrap()
            .get(&destination)
            .copied();

        if let Some(server_id) = server_id {
            self.network_mgr
                .send_to(
                    destination,
                    server_id,
                    ForwardClientProtocolMessage {
                        session_id: self.id,
                        request_id,
                        message: message.into(),
                    },
                )
                .await;
        } else {
            warn!(
                "forward_client_message: server {:?} is not bound! session_id: {}, request_id: {}",
                destination, self.id, request_id
            );
        }
    }

    pub fn calc_offline_verify_value(&self, login_random: u32) -> u32 {
        5_u32
            .wrapping_mul(rotate_right(
                self.player_uid ^ login_random,
                2 * (self.player_uid & 1) + 17,
            ))
            .wrapping_sub(430675100)
    }

    pub fn get_bound_server_of_type(&self, server_type: ServerType) -> Option<u32> {
        self.bound_server_map
            .read()
            .unwrap()
            .get(&server_type)
            .copied()
    }
}

#[inline(always)]
const fn rotate_right(value: u32, count: u32) -> u32 {
    (value >> count) | (value << (32 - count))
}
