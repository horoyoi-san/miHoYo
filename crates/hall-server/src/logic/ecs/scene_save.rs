use bevy_ecs::prelude::*;

use crate::logic::{
    save::{HallSceneSaveData, MainCityPositionSave},
    GameStateListener,
};

use super::{
    hall::{BGMusic, Clock, HallQuery, MainCitySection},
    player::{MainCityPosition, PlayerQuery},
};

pub fn should_save_data(
    detected_changes: Query<
        Entity,
        (
            Or<(
                Changed<MainCitySection>,
                Changed<MainCityPosition>,
                Changed<Clock>,
                Changed<BGMusic>,
            )>,
        ),
    >,
) -> bool {
    !detected_changes.is_empty()
}

pub fn refresh_save_data(
    mut listener: ResMut<GameStateListener>,
    hall: Query<HallQuery>,
    player: Query<PlayerQuery>,
) {
    // TODO: at some point, we'll have to save SceneUnits for each section
    // For example when actual NPC interaction/quests will be implemented
    // and units will be spawned dynamically

    let hall = hall.single();
    let player = player.single();

    listener.set_save_data(HallSceneSaveData {
        section_id: hall.section.0,
        bgm_id: hall.bgm.0,
        day_of_week: hall.clock.day_of_week as u32,
        time_of_day: hall.clock.time_of_day as u32,
        player_position: match &*player.position {
            MainCityPosition::Transform(t) => MainCityPositionSave::Transform {
                pos_x: t.position.x,
                pos_y: t.position.y,
                pos_z: t.position.z,
                rot_y: t.rotation.y,
            },
            MainCityPosition::Predefined(id) => MainCityPositionSave::Predefined {
                transform_id: id.clone(),
            },
        },
    });
}
