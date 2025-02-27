use bevy_ecs::system::Resource;
use trigger_encoding::Encodeable;
use trigger_protocol::{util::ProtocolUnit, ClientCmdID};
use trigger_sv::{
    message::{GameStateCallback, GameStateCallbackMessage},
    net::{ServerNetworkManager, ServerType},
};

use super::save::HallSceneSaveData;

// *listens* for events (such as notifies and callbacks) emitted by ECS.
#[derive(Resource)]
pub struct GameStateListener {
    session_id: u64,
    game_server_id: u32,
    network_mgr: &'static ServerNetworkManager,
    scene_save_data: Option<String>,
    units: Vec<ProtocolUnit>,
}

impl GameStateListener {
    pub fn new(
        session_id: u64,
        game_server_id: u32,
        network_mgr: &'static ServerNetworkManager,
    ) -> Self {
        Self {
            session_id,
            game_server_id,
            network_mgr,
            scene_save_data: None,
            units: Vec::new(),
        }
    }

    pub fn add<Message: ClientCmdID + Encodeable>(&mut self, message: Message) {
        self.units.push(message.into());
    }

    pub fn set_save_data(&mut self, hall_save_data: HallSceneSaveData) {
        self.scene_save_data = Some(serde_json::to_string(&hall_save_data).unwrap());
    }

    pub fn emit_callback(&mut self, callback: GameStateCallback) {
        self.network_mgr.blocking_send_to(
            ServerType::GameServer,
            self.game_server_id,
            GameStateCallbackMessage {
                session_id: self.session_id,
                protocol_units: std::mem::take(&mut self.units),
                scene_save_data: self.scene_save_data.take(),
                callback,
            },
        );
    }
}
