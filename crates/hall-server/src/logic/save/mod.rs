use serde::{Deserialize, Serialize};

#[derive(Debug, Serialize, Deserialize)]
pub struct HallSceneSaveData {
    pub section_id: u32,
    pub day_of_week: u32,
    pub time_of_day: u32,
    pub bgm_id: u32,
    pub player_position: MainCityPositionSave,
}

#[derive(Debug, Serialize, Deserialize)]
#[serde(tag = "$type")]
pub enum MainCityPositionSave {
    Predefined {
        transform_id: String,
    },
    Transform {
        pos_x: f64,
        pos_y: f64,
        pos_z: f64,
        rot_y: f64,
    },
}
