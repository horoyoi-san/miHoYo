use std::collections::HashMap;

use bevy_derive::{Deref, DerefMut};
use bevy_ecs::{prelude::*, query::QueryData};
use trigger_fileconfig::main_city_script::{
    ActionChangeInteractCfg, ActionCreateNpcCfg, ConfigInteractScale,
};
use trigger_logic::scene::EInteractTarget;
use trigger_protocol::{InteractInfo, SceneUnitProtocolInfo};

#[derive(Bundle)]
pub struct SceneUnitBundle {
    pub npc_id: NpcConfigId,
    pub tag_id: SceneUnitTag,
    pub interact_container: InteractContainer,
}

#[derive(QueryData)]
pub struct SceneUnitQuery {
    pub npc_id: &'static NpcConfigId,
    pub tag_id: &'static SceneUnitTag,
    pub interact_container: &'static InteractContainer,
}

#[derive(Component, Deref)]
pub struct NpcConfigId(u32);

#[derive(Component, Deref, DerefMut)]
pub struct SceneUnitTag(i32);

pub struct InteractScale(f64, f64, f64, f64, f64);

pub struct AttachedInteract {
    pub name: String,
    pub participators: HashMap<u32, String>,
    pub scale: InteractScale,
    pub target_list: Vec<EInteractTarget>,
    pub listen_events: &'static HashMap<String, String>,
}

#[derive(Component, Default)]
pub struct InteractContainer {
    interacts: HashMap<u32, AttachedInteract>,
    ongoing_interaction_id: i32,
}

impl SceneUnitBundle {
    pub fn build_by_action(action: &ActionCreateNpcCfg) -> Self {
        Self {
            npc_id: NpcConfigId(action.tag_id as u32),
            tag_id: SceneUnitTag(action.tag_id),
            interact_container: InteractContainer::default(),
        }
    }
}

impl InteractContainer {
    pub fn attach_by_action(&mut self, action: &'static ActionChangeInteractCfg) {
        self.interacts.insert(
            action.interact_id as u32,
            AttachedInteract {
                name: String::from("A"), // TODO
                scale: InteractScale::from_config(&action.interact_scale),
                participators: action.participators.clone(),
                target_list: vec![EInteractTarget::TriggerBox],
                listen_events: &action.section_listen_events,
            },
        );
    }

    pub fn try_interact(&mut self, interact_id: i32) -> Option<&'static str> {
        if let Some(interact) = self.interacts.get(&(interact_id as u32)) {
            self.ongoing_interaction_id = interact_id;
            return interact.listen_events.get("OnInteract").map(|s| s.as_str());
        }

        None
    }

    pub fn is_interaction_allowed_in_current_state(&self, interact_id: i32) -> bool {
        // TODO: check if interaction is already in progress
        self.interacts.contains_key(&(interact_id as u32))
    }

    pub fn cur_interaction(&self) -> i32 {
        self.ongoing_interaction_id
    }

    pub fn finish_interaction(&mut self) {
        self.ongoing_interaction_id = 0;
    }
}

impl InteractScale {
    pub fn from_config(config: &ConfigInteractScale) -> Self {
        Self(config.x, config.y, config.z, 0.0, 0.0)
    }
}

impl<'lt> SceneUnitQueryItem<'lt> {
    pub fn to_protocol(&self) -> SceneUnitProtocolInfo {
        SceneUnitProtocolInfo {
            npc_id: self.npc_id.0,
            is_interactable: true,
            interacts_info: self
                .interact_container
                .interacts
                .iter()
                .map(|(k, v)| {
                    (
                        *k,
                        InteractInfo {
                            name: v.name.clone(),
                            tag_id: *k as i32,
                            scale_x: v.scale.0,
                            scale_y: v.scale.1,
                            scale_z: v.scale.2,
                            scale_w: v.scale.3,
                            scale_r: v.scale.4,
                            participators: v.participators.clone(),
                            interact_target_list: v
                                .target_list
                                .iter()
                                .copied()
                                .map(i32::from)
                                .collect(),
                        },
                    )
                })
                .collect(),
        }
    }
}
