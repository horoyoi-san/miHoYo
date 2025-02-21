use crate::message::opcode;
use trigger_codegen::{Decodeable, Encodeable};
use trigger_protocol::{util::ProtocolUnit, DungeonEquipInfo};

#[derive(Debug, Encodeable, Decodeable)]
pub struct BindClientSessionMessage {
    pub session_id: u64,
    pub player_uid: u32,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct BindClientSessionOkMessage {
    pub session_id: u64,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct BindClientSessionFailedMessage {
    pub session_id: u64,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct UnbindClientSessionMessage {
    pub session_id: u64,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct ForwardClientProtocolMessage {
    pub session_id: u64,
    pub request_id: u32,
    pub message: ProtocolUnit,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct AvailableServerProtocolMessage {
    pub session_id: u64,
    pub ack_request_id: u32,
    pub notifies: Vec<ProtocolUnit>,
    pub response: Option<ProtocolUnit>,
}

#[derive(Debug, Encodeable, Decodeable)]
#[repr(u16)]
pub enum GameStateData {
    Hall {
        player_avatar_id: u32,
        control_avatar_id: u32,
        ext: Option<String>,
    } = 1,
    Fight {
        quest_id: u32,
        play_type: u32,
        buddy_id: u32,
        avatar_id_list: Vec<u32>,
        dungeon_equip: DungeonEquipInfo,
    } = 2,
    Rally {
        quest_id: u32,
        play_type: u32,
        buddy_id: u32,
        avatar_id_list: Vec<u32>,
        dungeon_equip: DungeonEquipInfo,
    } = 3,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct ChangeGameStateMessage {
    pub session_id: u64,
    pub scene_uid: i64,
    pub data: GameStateData,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct PlayerInventoryChange {
    pub id: i32,
    pub num: i32,
}

#[derive(Debug, Encodeable, Decodeable)]
#[repr(u16)]
pub enum GameStateCallback {
    Loaded = 1,
    ClientCmdProcessed {
        ack_request_id: u32,
        response: Option<ProtocolUnit>,
    } = 2,
    PlayerItemsGiven {
        changes: Vec<PlayerInventoryChange>,
    } = 3,
}

#[derive(Debug, Encodeable, Decodeable)]
pub struct GameStateCallbackMessage {
    pub session_id: u64,
    pub protocol_units: Vec<ProtocolUnit>,
    pub scene_save_data: Option<String>,
    pub callback: GameStateCallback,
}

opcode! {
    Session,
    BindClientSessionMessage = 1,
    BindClientSessionOkMessage = 2,
    BindClientSessionFailedMessage = 3,
    UnbindClientSessionMessage = 4,
    ForwardClientProtocolMessage = 5,
    AvailableServerProtocolMessage = 6,
    ChangeGameStateMessage = 10,
    GameStateCallbackMessage = 11
}
