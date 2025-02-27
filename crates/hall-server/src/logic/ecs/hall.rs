use bevy_ecs::{prelude::*, query::QueryData};
use tracing::warn;
use trigger_fileconfig::{main_city_script::MainCityConfig, NapFileCfg};

use crate::logic::save::HallSceneSaveData;

use super::player::MainCityPosition;

#[derive(Component)]
pub struct MainCitySection(pub u32);

#[derive(Component)]
pub struct Clock {
    pub time_of_day: u16,
    pub day_of_week: u8,
}

#[derive(Component)]
pub struct BGMusic(pub u32);

#[derive(Bundle)]
pub struct HallBundle {
    pub section: MainCitySection,
    pub clock: Clock,
    pub bgm: BGMusic,
}

#[derive(QueryData)]
pub struct HallQuery {
    pub section: &'static MainCitySection,
    pub clock: &'static Clock,
    pub bgm: &'static BGMusic,
}

#[derive(Resource)]
pub struct HallInitData {
    pub section_id: u32,
    pub player_avatar_id: u32,
    pub control_avatar_id: u32,
    pub initial_position: MainCityPosition,
    pub day_of_week: u32,
    pub time_of_day: u32,
    pub bgm_id: u32,
}

impl HallInitData {
    pub fn load_from_save(
        player_avatar_id: u32,
        control_avatar_id: u32,
        ext: Option<String>,
    ) -> Option<Self> {
        ext.map(|data| {
            serde_json::from_str::<HallSceneSaveData>(&data)
                .inspect_err(|err| {
                    warn!("failed to deserialize HallSceneSaveData: {err}, data: {data}")
                })
                .ok()
        })
        .flatten()
        .map(|data| HallInitData {
            section_id: data.section_id,
            player_avatar_id,
            control_avatar_id,
            initial_position: data.player_position.into(),
            day_of_week: data.day_of_week,
            time_of_day: data.time_of_day,
            bgm_id: data.bgm_id,
        })
    }

    pub fn create_default_init_data(
        filecfg: &NapFileCfg<'static>,
        main_city_config: &MainCityConfig,
        player_avatar_id: u32,
        control_avatar_id: u32,
    ) -> Self {
        let section_id = main_city_config.default_section_id;
        let section_config = filecfg
            .section_config_template_tb
            .data()
            .unwrap()
            .iter()
            .find(|cfg| cfg.section_id() == section_id as i32)
            .unwrap();

        HallInitData {
            section_id,
            player_avatar_id,
            control_avatar_id,
            bgm_id: 1005,
            day_of_week: 5,
            time_of_day: 360,
            initial_position: MainCityPosition::Predefined(
                section_config.born_transform().unwrap().to_string(),
            ),
        }
    }
}
