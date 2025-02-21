use bevy_ecs::event::Event;
use trigger_encoding::Decodeable;
use trigger_logic::scene::Transform;
use trigger_protocol::{
    util::ProtocolUnit, ClientCmdID, EnterSectionCsReq, InteractWithUnitCsReq, RunEventGraphCsReq,
    SavePosInMainCityCsReq, SwitchRoleCsReq,
};

use super::ecs::NapEcs;

pub trait ProtocolEventHandler {
    fn push_protocol_event(&mut self, request_id: u32, protocol_unit: ProtocolUnit);
}

#[derive(Event, Debug)]
pub struct PlayerMoveEvent {
    pub request_id: u32,
    pub position: Transform,
    pub section_id: u32,
}

#[derive(Event, Debug)]
pub struct InteractWithUnitEvent {
    pub request_id: u32,
    pub interact_id: i32,
    pub trigger_type: i32,
    pub npc_tag_id: i32,
}

#[derive(Event, Debug)]
pub struct RunEventGraphEvent {
    pub request_id: u32,
    pub event_graph_uid: u32,
    #[expect(dead_code)]
    pub section_id: u32,
    pub owner_id: u32,
    pub owner_type: i32,
    pub tag: u32,
}

#[derive(Event, Debug)]
pub struct EnterSectionEvent {
    pub request_id: u32,
    pub section_id: u32,
    pub transform_id: String,
}

#[derive(Event, Debug)]
pub struct SwitchRoleEvent {
    pub player_avatar_id: u32,
    pub control_avatar_id: u32,
}

impl ProtocolEventHandler for NapEcs {
    fn push_protocol_event(&mut self, request_id: u32, protocol_unit: ProtocolUnit) {
        match protocol_unit.cmd_id {
            SavePosInMainCityCsReq::CMD_ID => {
                if let Ok(cmd) =
                    SavePosInMainCityCsReq::decode(&mut ::std::io::Cursor::new(&protocol_unit.blob))
                {
                    self.0.world_mut().send_event(PlayerMoveEvent {
                        request_id,
                        section_id: cmd.section_id,
                        position: cmd
                            .position
                            .map(|t| Transform {
                                position: t.position.into(),
                                rotation: t.rotation.into(),
                            })
                            .unwrap_or_default(),
                    });
                }
            }
            InteractWithUnitCsReq::CMD_ID => {
                if let Ok(cmd) =
                    InteractWithUnitCsReq::decode(&mut ::std::io::Cursor::new(&protocol_unit.blob))
                {
                    self.0.world_mut().send_event(InteractWithUnitEvent {
                        request_id,
                        interact_id: cmd.interact_id,
                        npc_tag_id: cmd.npc_tag_id,
                        trigger_type: cmd.r#type,
                    });
                }
            }
            RunEventGraphCsReq::CMD_ID => {
                if let Ok(cmd) =
                    RunEventGraphCsReq::decode(&mut ::std::io::Cursor::new(&protocol_unit.blob))
                {
                    self.0.world_mut().send_event(RunEventGraphEvent {
                        request_id,
                        event_graph_uid: cmd.event_graph_uid,
                        owner_type: cmd.owner_type,
                        owner_id: cmd.owner_id,
                        section_id: cmd.section_id,
                        tag: cmd.tag,
                    });
                }
            }
            EnterSectionCsReq::CMD_ID => {
                if let Ok(cmd) =
                    EnterSectionCsReq::decode(&mut ::std::io::Cursor::new(&protocol_unit.blob))
                {
                    self.0.world_mut().send_event(EnterSectionEvent {
                        request_id,
                        section_id: cmd.section_id,
                        transform_id: cmd.transform_id,
                    });
                }
            }
            SwitchRoleCsReq::CMD_ID => {
                if let Ok(cmd) =
                    SwitchRoleCsReq::decode(&mut ::std::io::Cursor::new(&protocol_unit.blob))
                {
                    self.0.world_mut().send_event(SwitchRoleEvent {
                        player_avatar_id: cmd.player_avatar_id,
                        control_avatar_id: cmd.control_avatar_id,
                    });
                }
            }
            _ => (),
        }
    }
}
