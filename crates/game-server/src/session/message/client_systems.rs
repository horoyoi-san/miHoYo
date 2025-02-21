use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod client_systems_module {
    use std::collections::HashMap;

    use tracing::debug;

    pub async fn on_video_get_info(
        _context: &mut MessageContext<'_, '_>,
        _request: VideoGetInfoCsReq,
    ) -> VideoGetInfoScRsp {
        VideoGetInfoScRsp {
            retcode: 0,
            video_key_map: HashMap::default(),
        }
    }

    pub async fn on_save_player_system_setting(
        _context: &mut MessageContext<'_, '_>,
        _request: SavePlayerSystemSettingCsReq,
    ) -> SavePlayerSystemSettingScRsp {
        SavePlayerSystemSettingScRsp { retcode: 0 }
    }

    pub async fn on_player_operation(
        _context: &mut MessageContext<'_, '_>,
        _request: PlayerOperationCsReq,
    ) -> PlayerOperationScRsp {
        PlayerOperationScRsp { retcode: 0 }
    }

    pub async fn on_get_tips_info(
        _context: &mut MessageContext<'_, '_>,
        _request: GetTipsInfoCsReq,
    ) -> GetTipsInfoScRsp {
        GetTipsInfoScRsp {
            retcode: 0,
            tips_info: Some(TipsInfo::default()),
        }
    }

    pub async fn on_get_client_systems_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetClientSystemsDataCsReq,
    ) -> GetClientSystemsDataScRsp {
        GetClientSystemsDataScRsp {
            retcode: 0,
            data: Some(ClientSystemsData {
                unlock_data: Some(UnlockData {
                    unlocked_list: context
                        .state
                        .filecfg
                        .unlock_config_template_tb
                        .data()
                        .unwrap()
                        .iter()
                        .map(|tmpl| tmpl.id())
                        .collect(),
                    ..Default::default()
                }),
                post_girl_data: Some(PostGirlData {
                    post_girl_item_list: context
                        .state
                        .filecfg
                        .post_girl_config_template_tb
                        .data()
                        .unwrap()
                        .iter()
                        .map(|tmpl| PostGirlItem {
                            id: tmpl.id() as u32,
                            unlock_time: 0,
                        })
                        .collect(),
                    selected_post_girl_id_list: vec![3510027],
                    show_random_selected: false,
                }),
                music_player_data: Some(MusicPlayerData {
                    music_list: context
                        .state
                        .filecfg
                        .music_player_config_template_tb
                        .data()
                        .unwrap()
                        .iter()
                        .map(|tmpl| MusicPlayerItem {
                            id: tmpl.id() as u32,
                            unlock_time: 1,
                            seen_time: 2,
                        })
                        .collect(),
                }),
                ..Default::default()
            }),
        }
    }

    pub async fn on_get_news_stand_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetNewsStandDataCsReq,
    ) -> GetNewsStandDataScRsp {
        GetNewsStandDataScRsp {
            retcode: 0,
            news_stand_data: Some(NewsStandData::default()),
        }
    }

    pub async fn on_get_trashbin_hermit_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetTrashbinHermitDataCsReq,
    ) -> GetTrashbinHermitDataScRsp {
        GetTrashbinHermitDataScRsp {
            retcode: 0,
            trashbin_hermit_data: Some(TrashbinHermitData::default()),
        }
    }

    pub async fn on_get_exploration_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetExplorationDataCsReq,
    ) -> GetExplorationDataScRsp {
        GetExplorationDataScRsp { retcode: 0 }
    }

    pub async fn on_get_journey_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetJourneyDataCsReq,
    ) -> GetJourneyDataScRsp {
        GetJourneyDataScRsp {
            retcode: 0,
            journey_data: Some(JourneyData::default()),
        }
    }

    pub async fn on_get_red_dot_list(
        _context: &mut MessageContext<'_, '_>,
        _request: GetRedDotListCsReq,
    ) -> GetRedDotListScRsp {
        GetRedDotListScRsp { retcode: 0 }
    }

    pub async fn on_report_ui_layout_platform(
        _context: &mut MessageContext<'_, '_>,
        _request: ReportUiLayoutPlatformCsReq,
    ) -> ReportUiLayoutPlatformScRsp {
        ReportUiLayoutPlatformScRsp { retcode: 0 }
    }

    pub async fn on_game_log_report(
        _context: &mut MessageContext<'_, '_>,
        request: GameLogReportCsReq,
    ) -> GameLogReportScRsp {
        debug!("{request:?}");
        GameLogReportScRsp { retcode: 0 }
    }

    pub async fn on_trigger_interact(
        _context: &mut MessageContext<'_, '_>,
        _request: TriggerInteractCsReq,
    ) -> TriggerInteractScRsp {
        TriggerInteractScRsp { retcode: 0 }
    }

    pub async fn on_battle_report(
        _context: &mut MessageContext<'_, '_>,
        _request: BattleReportCsReq,
    ) -> BattleReportScRsp {
        BattleReportScRsp { retcode: 0 }
    }

    pub async fn on_play_song(
        _context: &mut MessageContext<'_, '_>,
        _request: PlaySongCsReq,
    ) -> PlaySongScRsp {
        PlaySongScRsp { retcode: 0 }
    }

    pub async fn on_set_music_player_mode(
        _context: &mut MessageContext<'_, '_>,
        _request: SetMusicPlayerModeCsReq,
    ) -> SetMusicPlayerModeScRsp {
        SetMusicPlayerModeScRsp { retcode: 0 }
    }
}
