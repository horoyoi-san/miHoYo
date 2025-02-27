use trigger_logic::scene::ELocalPlayType;

use super::ScenePerform;

pub struct FightScene {
    pub event_id: u32,
    pub play_type: ELocalPlayType,
    pub perform: ScenePerform,
}

impl FightScene {
    pub fn get_protocol_scene_info(&self) -> trigger_protocol::SceneInfo {
        use trigger_protocol::*;

        SceneInfo {
            scene_type: 3,
            local_play_type: self.play_type.into(),
            event_id: self.event_id, // or maybe it's actually scene_id ?
            fight_scene_info: Some(FightSceneInfo {
                level_perform_info: Some(LevelPerformInfo {
                    time: self.perform.time.clone(),
                    weather: self.perform.weather.clone(),
                }),
                level_reward_info: Some(LevelRewardInfo::default()),
                perform_type: 0,
                end_hollow: true,
            }),
            ..Default::default()
        }
    }
}
