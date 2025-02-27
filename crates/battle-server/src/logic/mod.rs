mod dungeon;

pub use dungeon::*;
pub mod scene;
use scene::{FightScene, RallyScene, Scene, ScenePerform};
use tracing::debug;
use trigger_fileconfig::NapFileCfg;
use trigger_logic::scene::ELocalPlayType;
use trigger_protocol::{EndBattleCsReq, EndBattleScRsp, FightSettle};
use trigger_sv::message::{GameStateCallback, GameStateData};

pub struct GameState {
    #[expect(dead_code)]
    filecfg: &'static NapFileCfg<'static>,
    pub scene: Scene,
    pub dungeon: Dungeon,
}

impl GameState {
    pub fn new(filecfg: &'static NapFileCfg<'static>, data: &GameStateData) -> Option<Self> {
        Some(match data {
            GameStateData::Fight {
                quest_id,
                play_type,
                buddy_id: _,
                avatar_id_list,
                dungeon_equip,
            } => Self {
                filecfg,
                scene: Scene::Fight(FightScene {
                    event_id: Self::get_scene_event_id(filecfg, *quest_id, (*play_type).into()),
                    play_type: (*play_type).into(),
                    perform: ScenePerform {
                        time: String::from("Morning"),
                        weather: String::from("SunShine"),
                    },
                }),
                dungeon: Dungeon {
                    quest_id: *quest_id,
                    avatar_list: avatar_id_list
                        .iter()
                        .map(|&avatar_id| AvatarUnit { avatar_id })
                        .collect(),
                    buddy_list: vec![BuddyUnit {
                        buddy_type: 0,
                        buddy_id: 50001,
                    }],
                    inner_quests: vec![Self::get_scene_event_id(
                        filecfg,
                        *quest_id,
                        (*play_type).into(),
                    )],
                    equip: dungeon_equip.clone(),
                },
            },
            GameStateData::Rally {
                quest_id,
                play_type,
                buddy_id: _,
                avatar_id_list,
                dungeon_equip,
            } => Self {
                scene: Scene::Rally(RallyScene {
                    event_id: Self::get_scene_event_id(filecfg, *quest_id, (*play_type).into()),
                    perform: ScenePerform {
                        time: String::from("Morning"),
                        weather: String::from("SunShine"),
                    },
                }),
                dungeon: Dungeon {
                    quest_id: *quest_id,
                    avatar_list: avatar_id_list
                        .iter()
                        .map(|&avatar_id| AvatarUnit { avatar_id })
                        .collect(),
                    buddy_list: vec![BuddyUnit {
                        buddy_type: 0,
                        buddy_id: 50001,
                    }],
                    inner_quests: vec![Self::get_scene_event_id(
                        filecfg,
                        *quest_id,
                        (*play_type).into(),
                    )],
                    equip: dungeon_equip.clone(),
                },
                filecfg,
            },
            _ => return None,
        })
    }

    fn get_scene_event_id(
        filecfg: &NapFileCfg<'static>,
        quest_id: u32,
        play_type: ELocalPlayType,
    ) -> u32 {
        match play_type {
            ELocalPlayType::TrainingRoom => 19800014,
            ELocalPlayType::ArchiveBattle => filecfg
                .archive_battle_quest_template_tb
                .data()
                .unwrap()
                .iter()
                .find(|tmpl| tmpl.id() == quest_id as i32)
                .map(|tmpl| tmpl.first_battle_event_id() as u32)
                .unwrap_or(0),
            _ => filecfg
                .battle_group_config_template_tb
                .data()
                .unwrap()
                .iter()
                .find(|tmpl| tmpl.quest_id() == quest_id as i32)
                .map(|tmpl| tmpl.battle_event_id() as u32)
                .unwrap_or(0),
        }
    }

    pub fn on_end_battle(
        &self,
        request_id: u32,
        _request: EndBattleCsReq,
    ) -> Vec<GameStateCallback> {
        debug!(
            "the battle is over, quest_id: {}, event_id: {}",
            self.dungeon.quest_id,
            self.scene.get_event_id()
        );

        vec![
            // TODO: battle rewards
            GameStateCallback::PlayerItemsGiven {
                changes: Vec::new(),
            },
            // TODO: FightSettle
            GameStateCallback::ClientCmdProcessed {
                ack_request_id: request_id,
                response: Some(
                    EndBattleScRsp {
                        retcode: 0,
                        fight_settle: Some(FightSettle::default()),
                    }
                    .into(),
                ),
            },
        ]
    }
}
