mod fight;
mod rally;
pub use fight::FightScene;
pub use rally::RallyScene;
use trigger_logic::scene::ELocalPlayType;

pub struct ScenePerform {
    pub time: String,
    pub weather: String,
}

pub enum Scene {
    Fight(FightScene),
    Rally(RallyScene),
}

impl Scene {
    pub fn get_protocol_scene_info(&self) -> trigger_protocol::SceneInfo {
        match self {
            Self::Fight(scene) => scene.get_protocol_scene_info(),
            Self::Rally(scene) => scene.get_protocol_scene_info(),
        }
    }

    pub fn get_event_id(&self) -> u32 {
        match self {
            Self::Fight(scene) => scene.event_id,
            Self::Rally(scene) => scene.event_id,
        }
    }

    pub fn get_play_type(&self) -> ELocalPlayType {
        match self {
            Self::Fight(scene) => scene.play_type,
            Self::Rally(_) => ELocalPlayType::RallyLongFight,
        }
    }
}
