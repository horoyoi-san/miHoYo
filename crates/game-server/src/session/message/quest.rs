use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod quest_module {
    use trigger_logic::{
        quest::EHollowQuestType,
        scene::{ELocalPlayType, ESceneType},
    };
    use trigger_sv::message::GameStateData;

    use crate::logic::dungeon_util;

    pub async fn on_get_quest_data(
        context: &mut MessageContext<'_, '_>,
        request: GetQuestDataCsReq,
    ) -> GetQuestDataScRsp {
        GetQuestDataScRsp {
            retcode: 0,
            quest_type: request.quest_type,
            quest_data: Some(
                context
                    .player
                    .quest_model
                    .get_protocol_quest_data(request.quest_type),
            ),
        }
    }

    pub async fn on_get_archive_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetArchiveDataCsReq,
    ) -> GetArchiveDataScRsp {
        GetArchiveDataScRsp {
            retcode: 0,
            archive_data: Some(context.player.main_story_model.get_protocol_archive_data()),
        }
    }

    pub async fn on_get_hollow_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetHollowDataCsReq,
    ) -> GetHollowDataScRsp {
        GetHollowDataScRsp {
            retcode: 0,
            hollow_data: Some(context.player.yorozuya_model.get_protocol_hollow_data()),
        }
    }

    pub async fn on_get_private_message_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetPrivateMessageDataCsReq,
    ) -> GetPrivateMessageDataScRsp {
        GetPrivateMessageDataScRsp {
            retcode: 0,
            private_message_data: Some(PrivateMessageData::default()),
        }
    }

    pub async fn on_hollow_data_refresh(
        _context: &mut MessageContext<'_, '_>,
        _request: HollowDataRefreshCsReq,
    ) -> HollowDataRefreshScRsp {
        HollowDataRefreshScRsp { retcode: 0 }
    }

    pub async fn on_finish_archive_perform(
        _context: &mut MessageContext<'_, '_>,
        request: FinishArchivePerformCsReq,
    ) -> FinishArchivePerformScRsp {
        FinishArchivePerformScRsp {
            retcode: 0,
            quest_id: request.quest_id,
            sub_id: request.sub_id,
        }
    }

    pub async fn on_begin_training_course_battle(
        context: &mut MessageContext<'_, '_>,
        request: BeginTrainingCourseBattleCsReq,
    ) {
        let scene_model = &mut context.player.scene_model;
        let scene_info = scene_model.create_scene_info(ESceneType::Fight).await;

        let dungeon_equip =
            dungeon_util::build_dungeon_equip_info(&context.player, &request.avatar_id_list);

        context
            .session
            .change_game_state(
                context.request_id,
                BeginTrainingCourseBattleScRsp { retcode: 0 },
                GameStateData::Fight {
                    play_type: ELocalPlayType::TrainingRoom.into(),
                    quest_id: request.quest_id,
                    buddy_id: request.buddy_id,
                    avatar_id_list: request.avatar_id_list,
                    dungeon_equip,
                },
                &scene_info,
                context.player,
                true,
            )
            .await;
    }

    pub async fn on_begin_archive_battle_quest(
        context: &mut MessageContext<'_, '_>,
        request: BeginArchiveBattleQuestCsReq,
    ) {
        let scene_model = &mut context.player.scene_model;
        let scene_info = scene_model.create_scene_info(ESceneType::Fight).await;

        let dungeon_equip =
            dungeon_util::build_dungeon_equip_info(&context.player, &request.avatar_id_list);

        context
            .session
            .change_game_state(
                context.request_id,
                BeginArchiveBattleQuestScRsp {
                    retcode: 0,
                    quest_id: request.quest_id,
                },
                GameStateData::Fight {
                    play_type: ELocalPlayType::ArchiveBattle.into(),
                    quest_id: request.quest_id,
                    buddy_id: request.buddy_id,
                    avatar_id_list: request.avatar_id_list,
                    dungeon_equip,
                },
                &scene_info,
                context.player,
                true,
            )
            .await;
    }

    pub async fn on_start_hollow_quest(
        context: &mut MessageContext<'_, '_>,
        request: StartHollowQuestCsReq,
    ) {
        let scene_model = &mut context.player.scene_model;
        let scene_info = scene_model.create_scene_info(ESceneType::Fight).await;

        let dungeon_equip =
            dungeon_util::build_dungeon_equip_info(&context.player, &request.avatar_id_list);

        let quest_template = context
            .state
            .filecfg
            .hollow_quest_template_tb
            .data()
            .unwrap()
            .iter()
            .find(|quest| quest.id() == request.quest_id as i32)
            .unwrap();

        let game_state_data =
            match EHollowQuestType::try_from(quest_template.hollow_quest_type()).unwrap() {
                EHollowQuestType::RallyBattle => GameStateData::Rally {
                    play_type: ELocalPlayType::RallyLongFight.into(),
                    quest_id: request.quest_id,
                    buddy_id: 0,
                    avatar_id_list: request.avatar_id_list,
                    dungeon_equip,
                },
                _ => GameStateData::Fight {
                    play_type: ELocalPlayType::PureHollowBattle.into(),
                    quest_id: request.quest_id,
                    buddy_id: 0,
                    avatar_id_list: request.avatar_id_list,
                    dungeon_equip,
                },
            };

        context
            .session
            .change_game_state(
                context.request_id,
                StartHollowQuestScRsp {
                    retcode: 0,
                    quest_id: request.quest_id,
                },
                game_state_data,
                &scene_info,
                context.player,
                true,
            )
            .await;
    }

    pub async fn on_click_hollow_system(
        _context: &mut MessageContext<'_, '_>,
        _request: ClickHollowSystemCsReq,
    ) -> ClickHollowSystemScRsp {
        ClickHollowSystemScRsp { retcode: 0 }
    }
}
