use std::collections::HashMap;

use trigger_logic::scene::ELocalPlayType;

use super::ScenePerform;

pub struct RallyScene {
    pub event_id: u32,
    pub perform: ScenePerform,
}

impl RallyScene {
    pub fn get_protocol_scene_info(&self) -> trigger_protocol::SceneInfo {
        use trigger_protocol::*;

        SceneInfo {
            scene_type: 7,
            local_play_type: ELocalPlayType::RallyLongFight.into(),
            event_id: self.event_id, // or maybe it's actually scene_id ?
            rally_scene_info: Some(RallySceneInfo {
                level_perform_info: Some(LevelPerformInfo {
                    time: self.perform.time.clone(),
                    weather: self.perform.weather.clone(),
                }),
                level_reward_info: Some(LevelRewardInfo::default()),
                cur_check_point: Some(HollowCheckPoint {
                    quest_cond_progress: Some(QuestCondProgress {
                        public_variables: HashMap::new(),
                    }),
                }),
            }),
            ..Default::default()
        }
    }
}
