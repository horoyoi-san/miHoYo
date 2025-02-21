use bevy_ecs::{prelude::*, query::QueryData};
use tracing::debug;
use trigger_logic::scene::{Transform, Vector3f};

use crate::logic::{message::SwitchRoleEvent, save::MainCityPositionSave};

#[derive(Component, Clone)]
pub enum MainCityPosition {
    Predefined(String),
    Transform(Transform),
}

#[derive(Component)]
pub struct ControlledAvatar {
    pub player_avatar_id: u32,
    pub control_avatar_id: u32,
}

#[derive(Bundle)]
pub struct PlayerBundle {
    pub position: MainCityPosition,
    pub avatar: ControlledAvatar,
}

#[derive(QueryData)]
pub struct PlayerQuery {
    pub position: &'static MainCityPosition,
    pub avatar: &'static ControlledAvatar,
}

pub fn process_switch_role(
    mut events: EventReader<SwitchRoleEvent>,
    mut avatar: Query<&mut ControlledAvatar>,
) {
    for event in events.read() {
        debug!("{event:?}");
        let mut avatar = avatar.single_mut();

        avatar.player_avatar_id = event.player_avatar_id;
        avatar.control_avatar_id = event.control_avatar_id;
    }
}

impl From<MainCityPositionSave> for MainCityPosition {
    fn from(value: MainCityPositionSave) -> Self {
        match value {
            MainCityPositionSave::Predefined { transform_id } => {
                MainCityPosition::Predefined(transform_id)
            }
            MainCityPositionSave::Transform {
                pos_x,
                pos_y,
                pos_z,
                rot_y,
            } => MainCityPosition::Transform(Transform {
                position: Vector3f {
                    x: pos_x,
                    y: pos_y,
                    z: pos_z,
                },
                rotation: Vector3f {
                    y: rot_y,
                    ..Default::default()
                },
            }),
        }
    }
}
