pub fn pb_to_common_protocol_unit(
    pb_cmd_id: u16,
    pb: &[u8],
) -> Result<Option<::trigger_protocol::util::ProtocolUnit>, crate::ProtobufDecodeError> {
    match pb_cmd_id {
        DrinkCafeScRsp::CMD_ID => {
            let mut pb_message = DrinkCafeScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::DrinkCafeScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        InteractWithUnitCsReq::CMD_ID => {
            let mut pb_message = InteractWithUnitCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::InteractWithUnitCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EndBattleScRsp::CMD_ID => {
            let mut pb_message = EndBattleScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EndBattleScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        BattleReportCsReq::CMD_ID => {
            let mut pb_message = BattleReportCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::BattleReportCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetAvatarDataCsReq::CMD_ID => {
            let mut pb_message = GetAvatarDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetAvatarDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        SavePosInMainCityCsReq::CMD_ID => {
            let mut pb_message = SavePosInMainCityCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::SavePosInMainCityCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        ActiveHollowCheckPointCsReq::CMD_ID => {
            let mut pb_message = ActiveHollowCheckPointCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::ActiveHollowCheckPointCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        DelNewRamenCsReq::CMD_ID => {
            let mut pb_message = DelNewRamenCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::DelNewRamenCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        SwitchRoleCsReq::CMD_ID => {
            let mut pb_message = SwitchRoleCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::SwitchRoleCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetChatEmojiListScRsp::CMD_ID => {
            let mut pb_message = GetChatEmojiListScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetChatEmojiListScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetAvatarDataScRsp::CMD_ID => {
            let mut pb_message = GetAvatarDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetAvatarDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetWishlistDataCsReq::CMD_ID => {
            let mut pb_message = GetWishlistDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetWishlistDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetBattleEventInfoCsReq::CMD_ID => {
            let mut pb_message = GetBattleEventInfoCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetBattleEventInfoCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetEquipDataScRsp::CMD_ID => {
            let mut pb_message = GetEquipDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetEquipDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        ReportUiLayoutPlatformCsReq::CMD_ID => {
            let mut pb_message = ReportUiLayoutPlatformCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::ReportUiLayoutPlatformCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetCollectMapCsReq::CMD_ID => {
            let mut pb_message = GetCollectMapCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetCollectMapCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        AbyssArpeggioGetDataCsReq::CMD_ID => {
            let mut pb_message = AbyssArpeggioGetDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::AbyssArpeggioGetDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetFriendListCsReq::CMD_ID => {
            let mut pb_message = GetFriendListCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetFriendListCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        RunEventGraphScRsp::CMD_ID => {
            let mut pb_message = RunEventGraphScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::RunEventGraphScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPrivateMessageDataCsReq::CMD_ID => {
            let mut pb_message = GetPrivateMessageDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPrivateMessageDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetBabelTowerDataCsReq::CMD_ID => {
            let mut pb_message = GetBabelTowerDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetBabelTowerDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        ClickHollowSystemCsReq::CMD_ID => {
            let mut pb_message = ClickHollowSystemCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::ClickHollowSystemCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        BeginArchiveBattleQuestScRsp::CMD_ID => {
            let mut pb_message = BeginArchiveBattleQuestScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::BeginArchiveBattleQuestScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetFishingContestDataCsReq::CMD_ID => {
            let mut pb_message = GetFishingContestDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetFishingContestDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetMiniscapeEntrustDataCsReq::CMD_ID => {
            let mut pb_message = GetMiniscapeEntrustDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetMiniscapeEntrustDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetCafeDataScRsp::CMD_ID => {
            let mut pb_message = GetCafeDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetCafeDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetBattlePassDataScRsp::CMD_ID => {
            let mut pb_message = GetBattlePassDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetBattlePassDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EatRamenCsReq::CMD_ID => {
            let mut pb_message = EatRamenCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EatRamenCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetExplorationDataScRsp::CMD_ID => {
            let mut pb_message = GetExplorationDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetExplorationDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetFriendListScRsp::CMD_ID => {
            let mut pb_message = GetFriendListScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetFriendListScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GameLogReportCsReq::CMD_ID => {
            let mut pb_message = GameLogReportCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GameLogReportCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetVhsStoreDataCsReq::CMD_ID => {
            let mut pb_message = GetVhsStoreDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetVhsStoreDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetResourceDataScRsp::CMD_ID => {
            let mut pb_message = GetResourceDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetResourceDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPlayerMailsCsReq::CMD_ID => {
            let mut pb_message = GetPlayerMailsCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPlayerMailsCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetOnlineFriendsListScRsp::CMD_ID => {
            let mut pb_message = GetOnlineFriendsListScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetOnlineFriendsListScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetFashionStoreDataScRsp::CMD_ID => {
            let mut pb_message = GetFashionStoreDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetFashionStoreDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetArcadeDataScRsp::CMD_ID => {
            let mut pb_message = GetArcadeDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetArcadeDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EnterWorldCsReq::CMD_ID => {
            let mut pb_message = EnterWorldCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EnterWorldCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        UndressEquipmentCsReq::CMD_ID => {
            let mut pb_message = UndressEquipmentCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::UndressEquipmentCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetDisplayCaseDataCsReq::CMD_ID => {
            let mut pb_message = GetDisplayCaseDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetDisplayCaseDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PlayerOperationCsReq::CMD_ID => {
            let mut pb_message = PlayerOperationCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PlayerOperationCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetHollowDataScRsp::CMD_ID => {
            let mut pb_message = GetHollowDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetHollowDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetClientSystemsDataCsReq::CMD_ID => {
            let mut pb_message = GetClientSystemsDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetClientSystemsDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetCharacterQuestListScRsp::CMD_ID => {
            let mut pb_message = GetCharacterQuestListScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetCharacterQuestListScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetCampIdleDataScRsp::CMD_ID => {
            let mut pb_message = GetCampIdleDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetCampIdleDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRewardBuffDataScRsp::CMD_ID => {
            let mut pb_message = GetRewardBuffDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRewardBuffDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        RechargeGetItemListScRsp::CMD_ID => {
            let mut pb_message = RechargeGetItemListScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::RechargeGetItemListScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EndBattleCsReq::CMD_ID => {
            let mut pb_message = EndBattleCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EndBattleCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        TalentSwitchCsReq::CMD_ID => {
            let mut pb_message = TalentSwitchCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::TalentSwitchCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        ReportBattleTeamCsReq::CMD_ID => {
            let mut pb_message = ReportBattleTeamCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::ReportBattleTeamCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PostEnterWorldCsReq::CMD_ID => {
            let mut pb_message = PostEnterWorldCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PostEnterWorldCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetResourceDataCsReq::CMD_ID => {
            let mut pb_message = GetResourceDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetResourceDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPhotoWallDataCsReq::CMD_ID => {
            let mut pb_message = GetPhotoWallDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPhotoWallDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetDailyChallengeDataScRsp::CMD_ID => {
            let mut pb_message = GetDailyChallengeDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetDailyChallengeDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetCharacterQuestListCsReq::CMD_ID => {
            let mut pb_message = GetCharacterQuestListCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetCharacterQuestListCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetTipsInfoCsReq::CMD_ID => {
            let mut pb_message = GetTipsInfoCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetTipsInfoCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetAvatarRecommendEquipCsReq::CMD_ID => {
            let mut pb_message = GetAvatarRecommendEquipCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetAvatarRecommendEquipCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        BeginTrainingCourseBattleCsReq::CMD_ID => {
            let mut pb_message = BeginTrainingCourseBattleCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::BeginTrainingCourseBattleCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PerformTriggerScRsp::CMD_ID => {
            let mut pb_message = PerformTriggerScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PerformTriggerScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetArchiveDataScRsp::CMD_ID => {
            let mut pb_message = GetArchiveDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetArchiveDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetArchiveDataCsReq::CMD_ID => {
            let mut pb_message = GetArchiveDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetArchiveDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRamenDataCsReq::CMD_ID => {
            let mut pb_message = GetRamenDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRamenDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetBattlePassDataCsReq::CMD_ID => {
            let mut pb_message = GetBattlePassDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetBattlePassDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetFairyDataCsReq::CMD_ID => {
            let mut pb_message = GetFairyDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetFairyDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetCollectMapScRsp::CMD_ID => {
            let mut pb_message = GetCollectMapScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetCollectMapScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        FinishArchivePerformCsReq::CMD_ID => {
            let mut pb_message = FinishArchivePerformCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::FinishArchivePerformCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPrivateMessageDataScRsp::CMD_ID => {
            let mut pb_message = GetPrivateMessageDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPrivateMessageDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetJourneyDataScRsp::CMD_ID => {
            let mut pb_message = GetJourneyDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetJourneyDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetTipsInfoScRsp::CMD_ID => {
            let mut pb_message = GetTipsInfoScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetTipsInfoScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetFashionStoreDataCsReq::CMD_ID => {
            let mut pb_message = GetFashionStoreDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetFashionStoreDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetNewsStandDataCsReq::CMD_ID => {
            let mut pb_message = GetNewsStandDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetNewsStandDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPlayerTransactionScRsp::CMD_ID => {
            let mut pb_message = GetPlayerTransactionScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPlayerTransactionScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetWebActivityDataScRsp::CMD_ID => {
            let mut pb_message = GetWebActivityDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetWebActivityDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetBuddyDataCsReq::CMD_ID => {
            let mut pb_message = GetBuddyDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetBuddyDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetCampIdleDataCsReq::CMD_ID => {
            let mut pb_message = GetCampIdleDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetCampIdleDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetAuthkeyCsReq::CMD_ID => {
            let mut pb_message = GetAuthkeyCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetAuthkeyCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetQuestionsAnswerGameDataScRsp::CMD_ID => {
            let mut pb_message = GetQuestionsAnswerGameDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetQuestionsAnswerGameDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRedDotListCsReq::CMD_ID => {
            let mut pb_message = GetRedDotListCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRedDotListCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetHadalZoneDataCsReq::CMD_ID => {
            let mut pb_message = GetHadalZoneDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetHadalZoneDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        AbyssGetDataCsReq::CMD_ID => {
            let mut pb_message = AbyssGetDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::AbyssGetDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetCafeDataCsReq::CMD_ID => {
            let mut pb_message = GetCafeDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetCafeDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        BattleReportScRsp::CMD_ID => {
            let mut pb_message = BattleReportScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::BattleReportScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRidusGotBooDataCsReq::CMD_ID => {
            let mut pb_message = GetRidusGotBooDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRidusGotBooDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        DressEquipmentSuitCsReq::CMD_ID => {
            let mut pb_message = DressEquipmentSuitCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::DressEquipmentSuitCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetQuestionsAnswerGameDataCsReq::CMD_ID => {
            let mut pb_message = GetQuestionsAnswerGameDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetQuestionsAnswerGameDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPlayerTransactionCsReq::CMD_ID => {
            let mut pb_message = GetPlayerTransactionCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPlayerTransactionCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetDailyChallengeDataCsReq::CMD_ID => {
            let mut pb_message = GetDailyChallengeDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetDailyChallengeDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PerformTriggerCsReq::CMD_ID => {
            let mut pb_message = PerformTriggerCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PerformTriggerCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        DressEquipmentCsReq::CMD_ID => {
            let mut pb_message = DressEquipmentCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::DressEquipmentCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PlayerLogoutCsReq::CMD_ID => {
            let mut pb_message = PlayerLogoutCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PlayerLogoutCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetGachaDataCsReq::CMD_ID => {
            let mut pb_message = GetGachaDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetGachaDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetJourneyDataCsReq::CMD_ID => {
            let mut pb_message = GetJourneyDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetJourneyDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EnterSectionCompleteScRsp::CMD_ID => {
            let mut pb_message = EnterSectionCompleteScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EnterSectionCompleteScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetWebActivityDataCsReq::CMD_ID => {
            let mut pb_message = GetWebActivityDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetWebActivityDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetOnlineFriendsListCsReq::CMD_ID => {
            let mut pb_message = GetOnlineFriendsListCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetOnlineFriendsListCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetServerTimestampScRsp::CMD_ID => {
            let mut pb_message = GetServerTimestampScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetServerTimestampScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetAuthkeyScRsp::CMD_ID => {
            let mut pb_message = GetAuthkeyScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetAuthkeyScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetShoppingMallInfoScRsp::CMD_ID => {
            let mut pb_message = GetShoppingMallInfoScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetShoppingMallInfoScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetAbyssRewardDataScRsp::CMD_ID => {
            let mut pb_message = GetAbyssRewardDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetAbyssRewardDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PerformEndCsReq::CMD_ID => {
            let mut pb_message = PerformEndCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PerformEndCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRedDotListScRsp::CMD_ID => {
            let mut pb_message = GetRedDotListScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRedDotListScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetClientSystemsDataScRsp::CMD_ID => {
            let mut pb_message = GetClientSystemsDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetClientSystemsDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EnterWorldScRsp::CMD_ID => {
            let mut pb_message = EnterWorldScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EnterWorldScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRamenDataScRsp::CMD_ID => {
            let mut pb_message = GetRamenDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRamenDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetWeaponDataScRsp::CMD_ID => {
            let mut pb_message = GetWeaponDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetWeaponDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetMiniscapeEntrustDataScRsp::CMD_ID => {
            let mut pb_message = GetMiniscapeEntrustDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetMiniscapeEntrustDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetArcadeDataCsReq::CMD_ID => {
            let mut pb_message = GetArcadeDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetArcadeDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetTrashbinHermitDataCsReq::CMD_ID => {
            let mut pb_message = GetTrashbinHermitDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetTrashbinHermitDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetVhsStoreDataScRsp::CMD_ID => {
            let mut pb_message = GetVhsStoreDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetVhsStoreDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetActivityDataScRsp::CMD_ID => {
            let mut pb_message = GetActivityDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetActivityDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetServerTimestampCsReq::CMD_ID => {
            let mut pb_message = GetServerTimestampCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetServerTimestampCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRoleCardDataCsReq::CMD_ID => {
            let mut pb_message = GetRoleCardDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRoleCardDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        SavePlayerSystemSettingCsReq::CMD_ID => {
            let mut pb_message = SavePlayerSystemSettingCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::SavePlayerSystemSettingCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PerformJumpCsReq::CMD_ID => {
            let mut pb_message = PerformJumpCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PerformJumpCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetQuestDataCsReq::CMD_ID => {
            let mut pb_message = GetQuestDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetQuestDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetChatEmojiListCsReq::CMD_ID => {
            let mut pb_message = GetChatEmojiListCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetChatEmojiListCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetQuestDataScRsp::CMD_ID => {
            let mut pb_message = GetQuestDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetQuestDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetHollowDataCsReq::CMD_ID => {
            let mut pb_message = GetHollowDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetHollowDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetMainCityRevivalDataScRsp::CMD_ID => {
            let mut pb_message = GetMainCityRevivalDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetMainCityRevivalDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PlayerSyncScNotify::CMD_ID => {
            let mut pb_message = PlayerSyncScNotify::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PlayerSyncScNotify::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EnterSectionCsReq::CMD_ID => {
            let mut pb_message = EnterSectionCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EnterSectionCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EnterSceneScNotify::CMD_ID => {
            let mut pb_message = EnterSceneScNotify::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EnterSceneScNotify::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetTrashbinHermitDataScRsp::CMD_ID => {
            let mut pb_message = GetTrashbinHermitDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetTrashbinHermitDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetWeaponDataCsReq::CMD_ID => {
            let mut pb_message = GetWeaponDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetWeaponDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        VideoGetInfoCsReq::CMD_ID => {
            let mut pb_message = VideoGetInfoCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::VideoGetInfoCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        VideoGetInfoScRsp::CMD_ID => {
            let mut pb_message = VideoGetInfoScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::VideoGetInfoScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        WeaponDressCsReq::CMD_ID => {
            let mut pb_message = WeaponDressCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::WeaponDressCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EnterSectionCompleteCsReq::CMD_ID => {
            let mut pb_message = EnterSectionCompleteCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EnterSectionCompleteCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetFishingContestDataScRsp::CMD_ID => {
            let mut pb_message = GetFishingContestDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetFishingContestDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        PlaySongCsReq::CMD_ID => {
            let mut pb_message = PlaySongCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::PlaySongCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        WorkbenchGetDataCsReq::CMD_ID => {
            let mut pb_message = WorkbenchGetDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::WorkbenchGetDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        RunEventGraphCsReq::CMD_ID => {
            let mut pb_message = RunEventGraphCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::RunEventGraphCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetMonthCardRewardListCsReq::CMD_ID => {
            let mut pb_message = GetMonthCardRewardListCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetMonthCardRewardListCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        RefreshSectionScRsp::CMD_ID => {
            let mut pb_message = RefreshSectionScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::RefreshSectionScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetBattleEventInfoScRsp::CMD_ID => {
            let mut pb_message = GetBattleEventInfoScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetBattleEventInfoScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetWishlistDataScRsp::CMD_ID => {
            let mut pb_message = GetWishlistDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetWishlistDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        LeaveCurSceneCsReq::CMD_ID => {
            let mut pb_message = LeaveCurSceneCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::LeaveCurSceneCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        UpdateEventGraphScNotify::CMD_ID => {
            let mut pb_message = UpdateEventGraphScNotify::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::UpdateEventGraphScNotify::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetShoppingMallInfoCsReq::CMD_ID => {
            let mut pb_message = GetShoppingMallInfoCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetShoppingMallInfoCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPlayerBasicInfoCsReq::CMD_ID => {
            let mut pb_message = GetPlayerBasicInfoCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPlayerBasicInfoCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        DrinkCafeCsReq::CMD_ID => {
            let mut pb_message = DrinkCafeCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::DrinkCafeCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        SetMusicPlayerModeCsReq::CMD_ID => {
            let mut pb_message = SetMusicPlayerModeCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::SetMusicPlayerModeCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        TriggerInteractCsReq::CMD_ID => {
            let mut pb_message = TriggerInteractCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::TriggerInteractCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetFairyDataScRsp::CMD_ID => {
            let mut pb_message = GetFairyDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetFairyDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetActivityDataCsReq::CMD_ID => {
            let mut pb_message = GetActivityDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetActivityDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPlayerBasicInfoScRsp::CMD_ID => {
            let mut pb_message = GetPlayerBasicInfoScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPlayerBasicInfoScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        RechargeGetItemListCsReq::CMD_ID => {
            let mut pb_message = RechargeGetItemListCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::RechargeGetItemListCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        AbyssGetDataScRsp::CMD_ID => {
            let mut pb_message = AbyssGetDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::AbyssGetDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        SyncEventInfoScNotify::CMD_ID => {
            let mut pb_message = SyncEventInfoScNotify::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::SyncEventInfoScNotify::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRewardBuffDataCsReq::CMD_ID => {
            let mut pb_message = GetRewardBuffDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRewardBuffDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPlayerDisplayDataCsReq::CMD_ID => {
            let mut pb_message = GetPlayerDisplayDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPlayerDisplayDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRoleCardDataScRsp::CMD_ID => {
            let mut pb_message = GetRoleCardDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRoleCardDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        StartHollowQuestCsReq::CMD_ID => {
            let mut pb_message = StartHollowQuestCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::StartHollowQuestCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetRidusGotBooDataScRsp::CMD_ID => {
            let mut pb_message = GetRidusGotBooDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetRidusGotBooDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        FinishArchivePerformScRsp::CMD_ID => {
            let mut pb_message = FinishArchivePerformScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::FinishArchivePerformScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        SceneTransitionCsReq::CMD_ID => {
            let mut pb_message = SceneTransitionCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::SceneTransitionCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        EatRamenScRsp::CMD_ID => {
            let mut pb_message = EatRamenScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::EatRamenScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetExplorationDataCsReq::CMD_ID => {
            let mut pb_message = GetExplorationDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetExplorationDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        StartHollowQuestScRsp::CMD_ID => {
            let mut pb_message = StartHollowQuestScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::StartHollowQuestScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetAbyssRewardDataCsReq::CMD_ID => {
            let mut pb_message = GetAbyssRewardDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetAbyssRewardDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        RefreshSectionCsReq::CMD_ID => {
            let mut pb_message = RefreshSectionCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::RefreshSectionCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetNewsStandDataScRsp::CMD_ID => {
            let mut pb_message = GetNewsStandDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetNewsStandDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        WeaponUnDressCsReq::CMD_ID => {
            let mut pb_message = WeaponUnDressCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::WeaponUnDressCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetEquipDataCsReq::CMD_ID => {
            let mut pb_message = GetEquipDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetEquipDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetMainCityRevivalDataCsReq::CMD_ID => {
            let mut pb_message = GetMainCityRevivalDataCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetMainCityRevivalDataCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        BeginArchiveBattleQuestCsReq::CMD_ID => {
            let mut pb_message = BeginArchiveBattleQuestCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::BeginArchiveBattleQuestCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetPlayerDisplayDataScRsp::CMD_ID => {
            let mut pb_message = GetPlayerDisplayDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetPlayerDisplayDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        WorkbenchGetDataScRsp::CMD_ID => {
            let mut pb_message = WorkbenchGetDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::WorkbenchGetDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        GetBuddyDataScRsp::CMD_ID => {
            let mut pb_message = GetBuddyDataScRsp::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::GetBuddyDataScRsp::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        HollowDataRefreshCsReq::CMD_ID => {
            let mut pb_message = HollowDataRefreshCsReq::decode(pb)?;
            pb_message.xor_fields();
            let common_protocol_message = ::trigger_protocol::HollowDataRefreshCsReq::from(
                pb_message,
            );
            Ok(Some(common_protocol_message.into()))
        }
        _ => Ok(None),
    }
}
pub fn common_protocol_unit_to_pb(
    unit: &::trigger_protocol::util::ProtocolUnit,
) -> ::std::io::Result<Option<(u16, Vec<u8>)>> {
    use ::trigger_encoding::Decodeable;
    use ::trigger_protocol::ClientCmdID;
    match unit.cmd_id {
        ::trigger_protocol::DrinkCafeScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::DrinkCafeScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = DrinkCafeScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((DrinkCafeScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::InteractWithUnitCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::InteractWithUnitCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = InteractWithUnitCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((InteractWithUnitCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EndBattleScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EndBattleScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EndBattleScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((EndBattleScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::BattleReportCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::BattleReportCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = BattleReportCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((BattleReportCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetAvatarDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetAvatarDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetAvatarDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetAvatarDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::SavePosInMainCityCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::SavePosInMainCityCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = SavePosInMainCityCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((SavePosInMainCityCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::ActiveHollowCheckPointCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::ActiveHollowCheckPointCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = ActiveHollowCheckPointCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((ActiveHollowCheckPointCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::DelNewRamenCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::DelNewRamenCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = DelNewRamenCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((DelNewRamenCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::SwitchRoleCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::SwitchRoleCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = SwitchRoleCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((SwitchRoleCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetChatEmojiListScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetChatEmojiListScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetChatEmojiListScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetChatEmojiListScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetAvatarDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetAvatarDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetAvatarDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetAvatarDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetWishlistDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetWishlistDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetWishlistDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetWishlistDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetBattleEventInfoCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetBattleEventInfoCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetBattleEventInfoCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetBattleEventInfoCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetEquipDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetEquipDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetEquipDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetEquipDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::ReportUiLayoutPlatformCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::ReportUiLayoutPlatformCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = ReportUiLayoutPlatformCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((ReportUiLayoutPlatformCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetCollectMapCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetCollectMapCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetCollectMapCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetCollectMapCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::AbyssArpeggioGetDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::AbyssArpeggioGetDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = AbyssArpeggioGetDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((AbyssArpeggioGetDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetFriendListCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetFriendListCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetFriendListCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetFriendListCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::RunEventGraphScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::RunEventGraphScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = RunEventGraphScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((RunEventGraphScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPrivateMessageDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPrivateMessageDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPrivateMessageDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetPrivateMessageDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetBabelTowerDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetBabelTowerDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetBabelTowerDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetBabelTowerDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::ClickHollowSystemCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::ClickHollowSystemCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = ClickHollowSystemCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((ClickHollowSystemCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::BeginArchiveBattleQuestScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::BeginArchiveBattleQuestScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = BeginArchiveBattleQuestScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((BeginArchiveBattleQuestScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetFishingContestDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetFishingContestDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetFishingContestDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetFishingContestDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetMiniscapeEntrustDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetMiniscapeEntrustDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetMiniscapeEntrustDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetMiniscapeEntrustDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetCafeDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetCafeDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetCafeDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetCafeDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetBattlePassDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetBattlePassDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetBattlePassDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetBattlePassDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EatRamenCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EatRamenCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EatRamenCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((EatRamenCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetExplorationDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetExplorationDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetExplorationDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetExplorationDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetFriendListScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetFriendListScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetFriendListScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetFriendListScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GameLogReportCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GameLogReportCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GameLogReportCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GameLogReportCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetVhsStoreDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetVhsStoreDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetVhsStoreDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetVhsStoreDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetResourceDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetResourceDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetResourceDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetResourceDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPlayerMailsCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPlayerMailsCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPlayerMailsCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetPlayerMailsCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetOnlineFriendsListScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetOnlineFriendsListScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetOnlineFriendsListScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetOnlineFriendsListScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetFashionStoreDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetFashionStoreDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetFashionStoreDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetFashionStoreDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetArcadeDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetArcadeDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetArcadeDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetArcadeDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EnterWorldCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EnterWorldCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EnterWorldCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((EnterWorldCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::UndressEquipmentCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::UndressEquipmentCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = UndressEquipmentCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((UndressEquipmentCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetDisplayCaseDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetDisplayCaseDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetDisplayCaseDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetDisplayCaseDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::PlayerOperationCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PlayerOperationCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PlayerOperationCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PlayerOperationCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetHollowDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetHollowDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetHollowDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetHollowDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetClientSystemsDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetClientSystemsDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetClientSystemsDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetClientSystemsDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetCharacterQuestListScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetCharacterQuestListScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetCharacterQuestListScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetCharacterQuestListScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetCampIdleDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetCampIdleDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetCampIdleDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetCampIdleDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRewardBuffDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRewardBuffDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRewardBuffDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRewardBuffDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::RechargeGetItemListScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::RechargeGetItemListScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = RechargeGetItemListScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((RechargeGetItemListScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EndBattleCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EndBattleCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EndBattleCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((EndBattleCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::TalentSwitchCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::TalentSwitchCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = TalentSwitchCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((TalentSwitchCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::ReportBattleTeamCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::ReportBattleTeamCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = ReportBattleTeamCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((ReportBattleTeamCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::PostEnterWorldCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PostEnterWorldCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PostEnterWorldCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PostEnterWorldCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetResourceDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetResourceDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetResourceDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetResourceDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPhotoWallDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPhotoWallDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPhotoWallDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetPhotoWallDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetDailyChallengeDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetDailyChallengeDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetDailyChallengeDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetDailyChallengeDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetCharacterQuestListCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetCharacterQuestListCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetCharacterQuestListCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetCharacterQuestListCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetTipsInfoCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetTipsInfoCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetTipsInfoCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetTipsInfoCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetAvatarRecommendEquipCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetAvatarRecommendEquipCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetAvatarRecommendEquipCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetAvatarRecommendEquipCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::BeginTrainingCourseBattleCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::BeginTrainingCourseBattleCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = BeginTrainingCourseBattleCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(
                Some((
                    BeginTrainingCourseBattleCsReq::CMD_ID,
                    pb_message.encode_to_vec(),
                )),
            )
        }
        ::trigger_protocol::PerformTriggerScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PerformTriggerScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PerformTriggerScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PerformTriggerScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetArchiveDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetArchiveDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetArchiveDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetArchiveDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetArchiveDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetArchiveDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetArchiveDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetArchiveDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRamenDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRamenDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRamenDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRamenDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetBattlePassDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetBattlePassDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetBattlePassDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetBattlePassDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetFairyDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetFairyDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetFairyDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetFairyDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetCollectMapScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetCollectMapScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetCollectMapScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetCollectMapScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::FinishArchivePerformCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::FinishArchivePerformCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = FinishArchivePerformCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((FinishArchivePerformCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPrivateMessageDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPrivateMessageDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPrivateMessageDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetPrivateMessageDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetJourneyDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetJourneyDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetJourneyDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetJourneyDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetTipsInfoScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetTipsInfoScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetTipsInfoScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetTipsInfoScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetFashionStoreDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetFashionStoreDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetFashionStoreDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetFashionStoreDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetNewsStandDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetNewsStandDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetNewsStandDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetNewsStandDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPlayerTransactionScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPlayerTransactionScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPlayerTransactionScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetPlayerTransactionScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetWebActivityDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetWebActivityDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetWebActivityDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetWebActivityDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetBuddyDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetBuddyDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetBuddyDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetBuddyDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetCampIdleDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetCampIdleDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetCampIdleDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetCampIdleDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetAuthkeyCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetAuthkeyCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetAuthkeyCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetAuthkeyCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetQuestionsAnswerGameDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetQuestionsAnswerGameDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetQuestionsAnswerGameDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(
                Some((
                    GetQuestionsAnswerGameDataScRsp::CMD_ID,
                    pb_message.encode_to_vec(),
                )),
            )
        }
        ::trigger_protocol::GetRedDotListCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRedDotListCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRedDotListCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRedDotListCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetHadalZoneDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetHadalZoneDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetHadalZoneDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetHadalZoneDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::AbyssGetDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::AbyssGetDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = AbyssGetDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((AbyssGetDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetCafeDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetCafeDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetCafeDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetCafeDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::BattleReportScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::BattleReportScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = BattleReportScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((BattleReportScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRidusGotBooDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRidusGotBooDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRidusGotBooDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRidusGotBooDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::DressEquipmentSuitCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::DressEquipmentSuitCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = DressEquipmentSuitCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((DressEquipmentSuitCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetQuestionsAnswerGameDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetQuestionsAnswerGameDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetQuestionsAnswerGameDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(
                Some((
                    GetQuestionsAnswerGameDataCsReq::CMD_ID,
                    pb_message.encode_to_vec(),
                )),
            )
        }
        ::trigger_protocol::GetPlayerTransactionCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPlayerTransactionCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPlayerTransactionCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetPlayerTransactionCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetDailyChallengeDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetDailyChallengeDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetDailyChallengeDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetDailyChallengeDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::PerformTriggerCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PerformTriggerCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PerformTriggerCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PerformTriggerCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::DressEquipmentCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::DressEquipmentCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = DressEquipmentCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((DressEquipmentCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::PlayerLogoutCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PlayerLogoutCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PlayerLogoutCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PlayerLogoutCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetGachaDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetGachaDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetGachaDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetGachaDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetJourneyDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetJourneyDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetJourneyDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetJourneyDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EnterSectionCompleteScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EnterSectionCompleteScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EnterSectionCompleteScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((EnterSectionCompleteScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetWebActivityDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetWebActivityDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetWebActivityDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetWebActivityDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetOnlineFriendsListCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetOnlineFriendsListCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetOnlineFriendsListCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetOnlineFriendsListCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetServerTimestampScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetServerTimestampScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetServerTimestampScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetServerTimestampScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetAuthkeyScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetAuthkeyScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetAuthkeyScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetAuthkeyScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetShoppingMallInfoScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetShoppingMallInfoScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetShoppingMallInfoScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetShoppingMallInfoScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetAbyssRewardDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetAbyssRewardDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetAbyssRewardDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetAbyssRewardDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::PerformEndCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PerformEndCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PerformEndCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PerformEndCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRedDotListScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRedDotListScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRedDotListScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRedDotListScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetClientSystemsDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetClientSystemsDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetClientSystemsDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetClientSystemsDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EnterWorldScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EnterWorldScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EnterWorldScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((EnterWorldScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRamenDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRamenDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRamenDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRamenDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetWeaponDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetWeaponDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetWeaponDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetWeaponDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetMiniscapeEntrustDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetMiniscapeEntrustDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetMiniscapeEntrustDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetMiniscapeEntrustDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetArcadeDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetArcadeDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetArcadeDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetArcadeDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetTrashbinHermitDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetTrashbinHermitDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetTrashbinHermitDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetTrashbinHermitDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetVhsStoreDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetVhsStoreDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetVhsStoreDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetVhsStoreDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetActivityDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetActivityDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetActivityDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetActivityDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetServerTimestampCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetServerTimestampCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetServerTimestampCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetServerTimestampCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRoleCardDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRoleCardDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRoleCardDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRoleCardDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::SavePlayerSystemSettingCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::SavePlayerSystemSettingCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = SavePlayerSystemSettingCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((SavePlayerSystemSettingCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::PerformJumpCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PerformJumpCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PerformJumpCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PerformJumpCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetQuestDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetQuestDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetQuestDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetQuestDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetChatEmojiListCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetChatEmojiListCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetChatEmojiListCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetChatEmojiListCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetQuestDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetQuestDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetQuestDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetQuestDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetHollowDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetHollowDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetHollowDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetHollowDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetMainCityRevivalDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetMainCityRevivalDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetMainCityRevivalDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetMainCityRevivalDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::PlayerSyncScNotify::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PlayerSyncScNotify::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PlayerSyncScNotify::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PlayerSyncScNotify::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EnterSectionCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EnterSectionCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EnterSectionCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((EnterSectionCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EnterSceneScNotify::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EnterSceneScNotify::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EnterSceneScNotify::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((EnterSceneScNotify::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetTrashbinHermitDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetTrashbinHermitDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetTrashbinHermitDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetTrashbinHermitDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetWeaponDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetWeaponDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetWeaponDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetWeaponDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::VideoGetInfoCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::VideoGetInfoCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = VideoGetInfoCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((VideoGetInfoCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::VideoGetInfoScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::VideoGetInfoScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = VideoGetInfoScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((VideoGetInfoScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::WeaponDressCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::WeaponDressCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = WeaponDressCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((WeaponDressCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EnterSectionCompleteCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EnterSectionCompleteCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EnterSectionCompleteCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((EnterSectionCompleteCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetFishingContestDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetFishingContestDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetFishingContestDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetFishingContestDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::PlaySongCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::PlaySongCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = PlaySongCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((PlaySongCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::WorkbenchGetDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::WorkbenchGetDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = WorkbenchGetDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((WorkbenchGetDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::RunEventGraphCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::RunEventGraphCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = RunEventGraphCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((RunEventGraphCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetMonthCardRewardListCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetMonthCardRewardListCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetMonthCardRewardListCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetMonthCardRewardListCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::RefreshSectionScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::RefreshSectionScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = RefreshSectionScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((RefreshSectionScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetBattleEventInfoScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetBattleEventInfoScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetBattleEventInfoScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetBattleEventInfoScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetWishlistDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetWishlistDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetWishlistDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetWishlistDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::LeaveCurSceneCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::LeaveCurSceneCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = LeaveCurSceneCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((LeaveCurSceneCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::UpdateEventGraphScNotify::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::UpdateEventGraphScNotify::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = UpdateEventGraphScNotify::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((UpdateEventGraphScNotify::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetShoppingMallInfoCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetShoppingMallInfoCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetShoppingMallInfoCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetShoppingMallInfoCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPlayerBasicInfoCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPlayerBasicInfoCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPlayerBasicInfoCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetPlayerBasicInfoCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::DrinkCafeCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::DrinkCafeCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = DrinkCafeCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((DrinkCafeCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::SetMusicPlayerModeCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::SetMusicPlayerModeCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = SetMusicPlayerModeCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((SetMusicPlayerModeCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::TriggerInteractCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::TriggerInteractCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = TriggerInteractCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((TriggerInteractCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetFairyDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetFairyDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetFairyDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetFairyDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetActivityDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetActivityDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetActivityDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetActivityDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPlayerBasicInfoScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPlayerBasicInfoScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPlayerBasicInfoScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetPlayerBasicInfoScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::RechargeGetItemListCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::RechargeGetItemListCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = RechargeGetItemListCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((RechargeGetItemListCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::AbyssGetDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::AbyssGetDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = AbyssGetDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((AbyssGetDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::SyncEventInfoScNotify::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::SyncEventInfoScNotify::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = SyncEventInfoScNotify::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((SyncEventInfoScNotify::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRewardBuffDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRewardBuffDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRewardBuffDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRewardBuffDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPlayerDisplayDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPlayerDisplayDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPlayerDisplayDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetPlayerDisplayDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRoleCardDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRoleCardDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRoleCardDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRoleCardDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::StartHollowQuestCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::StartHollowQuestCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = StartHollowQuestCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((StartHollowQuestCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetRidusGotBooDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetRidusGotBooDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetRidusGotBooDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetRidusGotBooDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::FinishArchivePerformScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::FinishArchivePerformScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = FinishArchivePerformScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((FinishArchivePerformScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::SceneTransitionCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::SceneTransitionCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = SceneTransitionCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((SceneTransitionCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::EatRamenScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::EatRamenScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = EatRamenScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((EatRamenScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetExplorationDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetExplorationDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetExplorationDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetExplorationDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::StartHollowQuestScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::StartHollowQuestScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = StartHollowQuestScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((StartHollowQuestScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetAbyssRewardDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetAbyssRewardDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetAbyssRewardDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetAbyssRewardDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::RefreshSectionCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::RefreshSectionCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = RefreshSectionCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((RefreshSectionCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetNewsStandDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetNewsStandDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetNewsStandDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetNewsStandDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::WeaponUnDressCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::WeaponUnDressCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = WeaponUnDressCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((WeaponUnDressCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetEquipDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetEquipDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetEquipDataCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetEquipDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetMainCityRevivalDataCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetMainCityRevivalDataCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetMainCityRevivalDataCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetMainCityRevivalDataCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::BeginArchiveBattleQuestCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::BeginArchiveBattleQuestCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = BeginArchiveBattleQuestCsReq::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((BeginArchiveBattleQuestCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetPlayerDisplayDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetPlayerDisplayDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetPlayerDisplayDataScRsp::from(
                common_protocol_message,
            );
            pb_message.xor_fields();
            Ok(Some((GetPlayerDisplayDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::WorkbenchGetDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::WorkbenchGetDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = WorkbenchGetDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((WorkbenchGetDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::GetBuddyDataScRsp::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::GetBuddyDataScRsp::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = GetBuddyDataScRsp::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((GetBuddyDataScRsp::CMD_ID, pb_message.encode_to_vec())))
        }
        ::trigger_protocol::HollowDataRefreshCsReq::CMD_ID => {
            let common_protocol_message = ::trigger_protocol::HollowDataRefreshCsReq::decode(
                &mut ::std::io::Cursor::new(&unit.blob),
            )?;
            let mut pb_message = HollowDataRefreshCsReq::from(common_protocol_message);
            pb_message.xor_fields();
            Ok(Some((HollowDataRefreshCsReq::CMD_ID, pb_message.encode_to_vec())))
        }
        _ => Ok(None),
    }
}
#[allow(unused)]
impl From<DrinkCafeScRsp> for ::trigger_protocol::DrinkCafeScRsp {
    fn from(value: DrinkCafeScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DrinkCafeScRsp> for DrinkCafeScRsp {
    fn from(value: ::trigger_protocol::DrinkCafeScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<InteractWithUnitCsReq> for ::trigger_protocol::InteractWithUnitCsReq {
    fn from(value: InteractWithUnitCsReq) -> Self {
        Self {
            interact_id: value.interact_id.into(),
            r#type: value.r#type.into(),
            npc_tag_id: value.npc_tag_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::InteractWithUnitCsReq> for InteractWithUnitCsReq {
    fn from(value: ::trigger_protocol::InteractWithUnitCsReq) -> Self {
        Self {
            interact_id: value.interact_id.into(),
            r#type: value.r#type.into(),
            npc_tag_id: value.npc_tag_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EndBattleScRsp> for ::trigger_protocol::EndBattleScRsp {
    fn from(value: EndBattleScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            fight_settle: value.fight_settle.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EndBattleScRsp> for EndBattleScRsp {
    fn from(value: ::trigger_protocol::EndBattleScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            fight_settle: value.fight_settle.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<DungeonInfo> for ::trigger_protocol::DungeonInfo {
    fn from(value: DungeonInfo) -> Self {
        Self {
            dungeon_equip_info: value.dungeon_equip_info.map(|v| v.into()),
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            dungeon_quest_info: value.dungeon_quest_info.map(|v| v.into()),
            quest_id: value.quest_id.into(),
            buddy_list: value.buddy_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DungeonInfo> for DungeonInfo {
    fn from(value: ::trigger_protocol::DungeonInfo) -> Self {
        Self {
            dungeon_equip_info: value.dungeon_equip_info.map(|v| v.into()),
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            dungeon_quest_info: value.dungeon_quest_info.map(|v| v.into()),
            quest_id: value.quest_id.into(),
            buddy_list: value.buddy_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<BattleReportCsReq> for ::trigger_protocol::BattleReportCsReq {
    fn from(value: BattleReportCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::BattleReportCsReq> for BattleReportCsReq {
    fn from(value: ::trigger_protocol::BattleReportCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetAvatarDataCsReq> for ::trigger_protocol::GetAvatarDataCsReq {
    fn from(value: GetAvatarDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetAvatarDataCsReq> for GetAvatarDataCsReq {
    fn from(value: ::trigger_protocol::GetAvatarDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<SavePosInMainCityCsReq> for ::trigger_protocol::SavePosInMainCityCsReq {
    fn from(value: SavePosInMainCityCsReq) -> Self {
        Self {
            section_id: value.section_id.into(),
            position: value.position.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::SavePosInMainCityCsReq> for SavePosInMainCityCsReq {
    fn from(value: ::trigger_protocol::SavePosInMainCityCsReq) -> Self {
        Self {
            section_id: value.section_id.into(),
            position: value.position.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<ActiveHollowCheckPointCsReq>
for ::trigger_protocol::ActiveHollowCheckPointCsReq {
    fn from(value: ActiveHollowCheckPointCsReq) -> Self {
        Self {
            check_point: value.check_point.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ActiveHollowCheckPointCsReq>
for ActiveHollowCheckPointCsReq {
    fn from(value: ::trigger_protocol::ActiveHollowCheckPointCsReq) -> Self {
        Self {
            check_point: value.check_point.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<RamenData> for ::trigger_protocol::RamenData {
    fn from(value: RamenData) -> Self {
        Self {
            unlock_ramen_list: value
                .unlock_ramen_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            eat_ramen_times: value.eat_ramen_times.into(),
            cur_ramen: value.cur_ramen.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RamenData> for RamenData {
    fn from(value: ::trigger_protocol::RamenData) -> Self {
        Self {
            unlock_ramen_list: value
                .unlock_ramen_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            eat_ramen_times: value.eat_ramen_times.into(),
            cur_ramen: value.cur_ramen.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<DelNewRamenCsReq> for ::trigger_protocol::DelNewRamenCsReq {
    fn from(value: DelNewRamenCsReq) -> Self {
        Self {
            has_mystical_spice: value.has_mystical_spice.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DelNewRamenCsReq> for DelNewRamenCsReq {
    fn from(value: ::trigger_protocol::DelNewRamenCsReq) -> Self {
        Self {
            has_mystical_spice: value.has_mystical_spice.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<SwitchRoleCsReq> for ::trigger_protocol::SwitchRoleCsReq {
    fn from(value: SwitchRoleCsReq) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            control_avatar_id: value.control_avatar_id.into(),
            player_avatar_id: value.player_avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::SwitchRoleCsReq> for SwitchRoleCsReq {
    fn from(value: ::trigger_protocol::SwitchRoleCsReq) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            control_avatar_id: value.control_avatar_id.into(),
            player_avatar_id: value.player_avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetChatEmojiListScRsp> for ::trigger_protocol::GetChatEmojiListScRsp {
    fn from(value: GetChatEmojiListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetChatEmojiListScRsp> for GetChatEmojiListScRsp {
    fn from(value: ::trigger_protocol::GetChatEmojiListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetAvatarDataScRsp> for ::trigger_protocol::GetAvatarDataScRsp {
    fn from(value: GetAvatarDataScRsp) -> Self {
        Self {
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetAvatarDataScRsp> for GetAvatarDataScRsp {
    fn from(value: ::trigger_protocol::GetAvatarDataScRsp) -> Self {
        Self {
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetWishlistDataCsReq> for ::trigger_protocol::GetWishlistDataCsReq {
    fn from(value: GetWishlistDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetWishlistDataCsReq> for GetWishlistDataCsReq {
    fn from(value: ::trigger_protocol::GetWishlistDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetBattleEventInfoCsReq> for ::trigger_protocol::GetBattleEventInfoCsReq {
    fn from(value: GetBattleEventInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetBattleEventInfoCsReq> for GetBattleEventInfoCsReq {
    fn from(value: ::trigger_protocol::GetBattleEventInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetEquipDataScRsp> for ::trigger_protocol::GetEquipDataScRsp {
    fn from(value: GetEquipDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            equip_list: value.equip_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetEquipDataScRsp> for GetEquipDataScRsp {
    fn from(value: ::trigger_protocol::GetEquipDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            equip_list: value.equip_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<ReportUiLayoutPlatformCsReq>
for ::trigger_protocol::ReportUiLayoutPlatformCsReq {
    fn from(value: ReportUiLayoutPlatformCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ReportUiLayoutPlatformCsReq>
for ReportUiLayoutPlatformCsReq {
    fn from(value: ::trigger_protocol::ReportUiLayoutPlatformCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetCollectMapCsReq> for ::trigger_protocol::GetCollectMapCsReq {
    fn from(value: GetCollectMapCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetCollectMapCsReq> for GetCollectMapCsReq {
    fn from(value: ::trigger_protocol::GetCollectMapCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<AbyssArpeggioGetDataCsReq> for ::trigger_protocol::AbyssArpeggioGetDataCsReq {
    fn from(value: AbyssArpeggioGetDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AbyssArpeggioGetDataCsReq> for AbyssArpeggioGetDataCsReq {
    fn from(value: ::trigger_protocol::AbyssArpeggioGetDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetFriendListCsReq> for ::trigger_protocol::GetFriendListCsReq {
    fn from(value: GetFriendListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetFriendListCsReq> for GetFriendListCsReq {
    fn from(value: ::trigger_protocol::GetFriendListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<RunEventGraphScRsp> for ::trigger_protocol::RunEventGraphScRsp {
    fn from(value: RunEventGraphScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RunEventGraphScRsp> for RunEventGraphScRsp {
    fn from(value: ::trigger_protocol::RunEventGraphScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<NewsStandData> for ::trigger_protocol::NewsStandData {
    fn from(value: NewsStandData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::NewsStandData> for NewsStandData {
    fn from(value: ::trigger_protocol::NewsStandData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetPrivateMessageDataCsReq>
for ::trigger_protocol::GetPrivateMessageDataCsReq {
    fn from(value: GetPrivateMessageDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPrivateMessageDataCsReq>
for GetPrivateMessageDataCsReq {
    fn from(value: ::trigger_protocol::GetPrivateMessageDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<Avatar> for ::trigger_protocol::Avatar {
    fn from(value: Avatar) -> Self {
        Self {
            taken_rank_up_reward_list: value
                .taken_rank_up_reward_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            talent_switch_list: value
                .talent_switch_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            passive_skill_level: value.passive_skill_level.into(),
            dressed_equip_list: value
                .dressed_equip_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            first_get_time: value.first_get_time.into(),
            skill_type_level: value
                .skill_type_level
                .into_iter()
                .map(|v| v.into())
                .collect(),
            id: value.id.into(),
            level: value.level.into(),
            cur_weapon_uid: value.cur_weapon_uid.into(),
            rank: value.rank.into(),
            unlocked_talent_num: value.unlocked_talent_num.into(),
            avatar_skin_id: value.avatar_skin_id.into(),
            show_weapon_type: value.show_weapon_type.into(),
            exp: value.exp.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::Avatar> for Avatar {
    fn from(value: ::trigger_protocol::Avatar) -> Self {
        Self {
            taken_rank_up_reward_list: value
                .taken_rank_up_reward_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            talent_switch_list: value
                .talent_switch_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            passive_skill_level: value.passive_skill_level.into(),
            dressed_equip_list: value
                .dressed_equip_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            first_get_time: value.first_get_time.into(),
            skill_type_level: value
                .skill_type_level
                .into_iter()
                .map(|v| v.into())
                .collect(),
            id: value.id.into(),
            level: value.level.into(),
            cur_weapon_uid: value.cur_weapon_uid.into(),
            rank: value.rank.into(),
            unlocked_talent_num: value.unlocked_talent_num.into(),
            avatar_skin_id: value.avatar_skin_id.into(),
            show_weapon_type: value.show_weapon_type.into(),
            exp: value.exp.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<HollowInfo> for ::trigger_protocol::HollowInfo {
    fn from(value: HollowInfo) -> Self {
        Self {
            hollow_statistics: value.hollow_statistics.map(|v| v.into()),
            hollow_quest_id: value.hollow_quest_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::HollowInfo> for HollowInfo {
    fn from(value: ::trigger_protocol::HollowInfo) -> Self {
        Self {
            hollow_statistics: value.hollow_statistics.map(|v| v.into()),
            hollow_quest_id: value.hollow_quest_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<BattleEventInfo> for ::trigger_protocol::BattleEventInfo {
    fn from(value: BattleEventInfo) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::BattleEventInfo> for BattleEventInfo {
    fn from(value: ::trigger_protocol::BattleEventInfo) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetBabelTowerDataCsReq> for ::trigger_protocol::GetBabelTowerDataCsReq {
    fn from(value: GetBabelTowerDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetBabelTowerDataCsReq> for GetBabelTowerDataCsReq {
    fn from(value: ::trigger_protocol::GetBabelTowerDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<ClickHollowSystemCsReq> for ::trigger_protocol::ClickHollowSystemCsReq {
    fn from(value: ClickHollowSystemCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ClickHollowSystemCsReq> for ClickHollowSystemCsReq {
    fn from(value: ::trigger_protocol::ClickHollowSystemCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<BeginArchiveBattleQuestScRsp>
for ::trigger_protocol::BeginArchiveBattleQuestScRsp {
    fn from(value: BeginArchiveBattleQuestScRsp) -> Self {
        Self {
            quest_id: value.quest_id.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::BeginArchiveBattleQuestScRsp>
for BeginArchiveBattleQuestScRsp {
    fn from(value: ::trigger_protocol::BeginArchiveBattleQuestScRsp) -> Self {
        Self {
            quest_id: value.quest_id.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetFishingContestDataCsReq>
for ::trigger_protocol::GetFishingContestDataCsReq {
    fn from(value: GetFishingContestDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetFishingContestDataCsReq>
for GetFishingContestDataCsReq {
    fn from(value: ::trigger_protocol::GetFishingContestDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetMiniscapeEntrustDataCsReq>
for ::trigger_protocol::GetMiniscapeEntrustDataCsReq {
    fn from(value: GetMiniscapeEntrustDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetMiniscapeEntrustDataCsReq>
for GetMiniscapeEntrustDataCsReq {
    fn from(value: ::trigger_protocol::GetMiniscapeEntrustDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetCafeDataScRsp> for ::trigger_protocol::GetCafeDataScRsp {
    fn from(value: GetCafeDataScRsp) -> Self {
        Self {
            cafe_data: value.cafe_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetCafeDataScRsp> for GetCafeDataScRsp {
    fn from(value: ::trigger_protocol::GetCafeDataScRsp) -> Self {
        Self {
            cafe_data: value.cafe_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetBattlePassDataScRsp> for ::trigger_protocol::GetBattlePassDataScRsp {
    fn from(value: GetBattlePassDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetBattlePassDataScRsp> for GetBattlePassDataScRsp {
    fn from(value: ::trigger_protocol::GetBattlePassDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EatRamenCsReq> for ::trigger_protocol::EatRamenCsReq {
    fn from(value: EatRamenCsReq) -> Self {
        Self {
            ramen: value.ramen.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EatRamenCsReq> for EatRamenCsReq {
    fn from(value: ::trigger_protocol::EatRamenCsReq) -> Self {
        Self {
            ramen: value.ramen.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetExplorationDataScRsp> for ::trigger_protocol::GetExplorationDataScRsp {
    fn from(value: GetExplorationDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetExplorationDataScRsp> for GetExplorationDataScRsp {
    fn from(value: ::trigger_protocol::GetExplorationDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetFriendListScRsp> for ::trigger_protocol::GetFriendListScRsp {
    fn from(value: GetFriendListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetFriendListScRsp> for GetFriendListScRsp {
    fn from(value: ::trigger_protocol::GetFriendListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GameLogReportCsReq> for ::trigger_protocol::GameLogReportCsReq {
    fn from(value: GameLogReportCsReq) -> Self {
        Self {
            stack_trace: value.stack_trace.into_iter().map(|v| v.into()).collect(),
            log_report_type: value.log_report_type.into(),
            value: value.value.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GameLogReportCsReq> for GameLogReportCsReq {
    fn from(value: ::trigger_protocol::GameLogReportCsReq) -> Self {
        Self {
            stack_trace: value.stack_trace.into_iter().map(|v| v.into()).collect(),
            log_report_type: value.log_report_type.into(),
            value: value.value.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetVhsStoreDataCsReq> for ::trigger_protocol::GetVhsStoreDataCsReq {
    fn from(value: GetVhsStoreDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetVhsStoreDataCsReq> for GetVhsStoreDataCsReq {
    fn from(value: ::trigger_protocol::GetVhsStoreDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetResourceDataScRsp> for ::trigger_protocol::GetResourceDataScRsp {
    fn from(value: GetResourceDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            auto_recovery_info: value
                .auto_recovery_info
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            material_list: value.material_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetResourceDataScRsp> for GetResourceDataScRsp {
    fn from(value: ::trigger_protocol::GetResourceDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            auto_recovery_info: value
                .auto_recovery_info
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            material_list: value.material_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<LevelPerformInfo> for ::trigger_protocol::LevelPerformInfo {
    fn from(value: LevelPerformInfo) -> Self {
        Self {
            time: value.time.into(),
            weather: value.weather.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::LevelPerformInfo> for LevelPerformInfo {
    fn from(value: ::trigger_protocol::LevelPerformInfo) -> Self {
        Self {
            time: value.time.into(),
            weather: value.weather.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<RamenSync> for ::trigger_protocol::RamenSync {
    fn from(value: RamenSync) -> Self {
        Self {
            is_full_update: value.is_full_update.into(),
            eat_ramen_times: value.eat_ramen_times.into(),
            cur_ramen: value.cur_ramen.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RamenSync> for RamenSync {
    fn from(value: ::trigger_protocol::RamenSync) -> Self {
        Self {
            is_full_update: value.is_full_update.into(),
            eat_ramen_times: value.eat_ramen_times.into(),
            cur_ramen: value.cur_ramen.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetPlayerMailsCsReq> for ::trigger_protocol::GetPlayerMailsCsReq {
    fn from(value: GetPlayerMailsCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPlayerMailsCsReq> for GetPlayerMailsCsReq {
    fn from(value: ::trigger_protocol::GetPlayerMailsCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetOnlineFriendsListScRsp> for ::trigger_protocol::GetOnlineFriendsListScRsp {
    fn from(value: GetOnlineFriendsListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetOnlineFriendsListScRsp> for GetOnlineFriendsListScRsp {
    fn from(value: ::trigger_protocol::GetOnlineFriendsListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<HollowData> for ::trigger_protocol::HollowData {
    fn from(value: HollowData) -> Self {
        Self {
            unlock_hollow_group_list: value
                .unlock_hollow_group_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            unlock_hollow_quest_list: value
                .unlock_hollow_quest_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            hollow_info_list: value
                .hollow_info_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            unlock_hollow_id_list: value
                .unlock_hollow_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            hollow_group_list: value
                .hollow_group_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::HollowData> for HollowData {
    fn from(value: ::trigger_protocol::HollowData) -> Self {
        Self {
            unlock_hollow_group_list: value
                .unlock_hollow_group_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            unlock_hollow_quest_list: value
                .unlock_hollow_quest_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            hollow_info_list: value
                .hollow_info_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            unlock_hollow_id_list: value
                .unlock_hollow_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            hollow_group_list: value
                .hollow_group_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetFashionStoreDataScRsp> for ::trigger_protocol::GetFashionStoreDataScRsp {
    fn from(value: GetFashionStoreDataScRsp) -> Self {
        Self {
            data: value.data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetFashionStoreDataScRsp> for GetFashionStoreDataScRsp {
    fn from(value: ::trigger_protocol::GetFashionStoreDataScRsp) -> Self {
        Self {
            data: value.data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetArcadeDataScRsp> for ::trigger_protocol::GetArcadeDataScRsp {
    fn from(value: GetArcadeDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetArcadeDataScRsp> for GetArcadeDataScRsp {
    fn from(value: ::trigger_protocol::GetArcadeDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EnterWorldCsReq> for ::trigger_protocol::EnterWorldCsReq {
    fn from(value: EnterWorldCsReq) -> Self {
        Self {
            is_reenter: value.is_reenter.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EnterWorldCsReq> for EnterWorldCsReq {
    fn from(value: ::trigger_protocol::EnterWorldCsReq) -> Self {
        Self {
            is_reenter: value.is_reenter.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<UndressEquipmentCsReq> for ::trigger_protocol::UndressEquipmentCsReq {
    fn from(value: UndressEquipmentCsReq) -> Self {
        Self {
            undress_index_list: value
                .undress_index_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::UndressEquipmentCsReq> for UndressEquipmentCsReq {
    fn from(value: ::trigger_protocol::UndressEquipmentCsReq) -> Self {
        Self {
            undress_index_list: value
                .undress_index_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetDisplayCaseDataCsReq> for ::trigger_protocol::GetDisplayCaseDataCsReq {
    fn from(value: GetDisplayCaseDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetDisplayCaseDataCsReq> for GetDisplayCaseDataCsReq {
    fn from(value: ::trigger_protocol::GetDisplayCaseDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<PlayerOperationCsReq> for ::trigger_protocol::PlayerOperationCsReq {
    fn from(value: PlayerOperationCsReq) -> Self {
        Self {
            param: value.param.into(),
            data: value.data.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PlayerOperationCsReq> for PlayerOperationCsReq {
    fn from(value: ::trigger_protocol::PlayerOperationCsReq) -> Self {
        Self {
            param: value.param.into(),
            data: value.data.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<Transform> for ::trigger_protocol::Transform {
    fn from(value: Transform) -> Self {
        Self {
            position: value.position.into_iter().map(|v| v.into()).collect(),
            rotation: value.rotation.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::Transform> for Transform {
    fn from(value: ::trigger_protocol::Transform) -> Self {
        Self {
            position: value.position.into_iter().map(|v| v.into()).collect(),
            rotation: value.rotation.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<DisplayItemGroup> for ::trigger_protocol::DisplayItemGroup {
    fn from(value: DisplayItemGroup) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DisplayItemGroup> for DisplayItemGroup {
    fn from(value: ::trigger_protocol::DisplayItemGroup) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetHollowDataScRsp> for ::trigger_protocol::GetHollowDataScRsp {
    fn from(value: GetHollowDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            hollow_data: value.hollow_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetHollowDataScRsp> for GetHollowDataScRsp {
    fn from(value: ::trigger_protocol::GetHollowDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            hollow_data: value.hollow_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PhotoWallNetworkData> for ::trigger_protocol::PhotoWallNetworkData {
    fn from(value: PhotoWallNetworkData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PhotoWallNetworkData> for PhotoWallNetworkData {
    fn from(value: ::trigger_protocol::PhotoWallNetworkData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetClientSystemsDataCsReq> for ::trigger_protocol::GetClientSystemsDataCsReq {
    fn from(value: GetClientSystemsDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetClientSystemsDataCsReq> for GetClientSystemsDataCsReq {
    fn from(value: ::trigger_protocol::GetClientSystemsDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetCharacterQuestListScRsp>
for ::trigger_protocol::GetCharacterQuestListScRsp {
    fn from(value: GetCharacterQuestListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetCharacterQuestListScRsp>
for GetCharacterQuestListScRsp {
    fn from(value: ::trigger_protocol::GetCharacterQuestListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<LevelRewardInfo> for ::trigger_protocol::LevelRewardInfo {
    fn from(value: LevelRewardInfo) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::LevelRewardInfo> for LevelRewardInfo {
    fn from(value: ::trigger_protocol::LevelRewardInfo) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<HollowStatistics> for ::trigger_protocol::HollowStatistics {
    fn from(value: HollowStatistics) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::HollowStatistics> for HollowStatistics {
    fn from(value: ::trigger_protocol::HollowStatistics) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetCampIdleDataScRsp> for ::trigger_protocol::GetCampIdleDataScRsp {
    fn from(value: GetCampIdleDataScRsp) -> Self {
        Self {
            camp_idle_data: value.camp_idle_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetCampIdleDataScRsp> for GetCampIdleDataScRsp {
    fn from(value: ::trigger_protocol::GetCampIdleDataScRsp) -> Self {
        Self {
            camp_idle_data: value.camp_idle_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRewardBuffDataScRsp> for ::trigger_protocol::GetRewardBuffDataScRsp {
    fn from(value: GetRewardBuffDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            data: value.data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRewardBuffDataScRsp> for GetRewardBuffDataScRsp {
    fn from(value: ::trigger_protocol::GetRewardBuffDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            data: value.data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<RechargeGetItemListScRsp> for ::trigger_protocol::RechargeGetItemListScRsp {
    fn from(value: RechargeGetItemListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RechargeGetItemListScRsp> for RechargeGetItemListScRsp {
    fn from(value: ::trigger_protocol::RechargeGetItemListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EndBattleCsReq> for ::trigger_protocol::EndBattleCsReq {
    fn from(value: EndBattleCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EndBattleCsReq> for EndBattleCsReq {
    fn from(value: ::trigger_protocol::EndBattleCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<MusicPlayerItem> for ::trigger_protocol::MusicPlayerItem {
    fn from(value: MusicPlayerItem) -> Self {
        Self {
            id: value.id.into(),
            seen_time: value.seen_time.into(),
            unlock_time: value.unlock_time.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::MusicPlayerItem> for MusicPlayerItem {
    fn from(value: ::trigger_protocol::MusicPlayerItem) -> Self {
        Self {
            id: value.id.into(),
            seen_time: value.seen_time.into(),
            unlock_time: value.unlock_time.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<TalentSwitchCsReq> for ::trigger_protocol::TalentSwitchCsReq {
    fn from(value: TalentSwitchCsReq) -> Self {
        Self {
            talent_switch_list: value
                .talent_switch_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::TalentSwitchCsReq> for TalentSwitchCsReq {
    fn from(value: ::trigger_protocol::TalentSwitchCsReq) -> Self {
        Self {
            talent_switch_list: value
                .talent_switch_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<ReportBattleTeamCsReq> for ::trigger_protocol::ReportBattleTeamCsReq {
    fn from(value: ReportBattleTeamCsReq) -> Self {
        Self {
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ReportBattleTeamCsReq> for ReportBattleTeamCsReq {
    fn from(value: ::trigger_protocol::ReportBattleTeamCsReq) -> Self {
        Self {
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PostEnterWorldCsReq> for ::trigger_protocol::PostEnterWorldCsReq {
    fn from(value: PostEnterWorldCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PostEnterWorldCsReq> for PostEnterWorldCsReq {
    fn from(value: ::trigger_protocol::PostEnterWorldCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetResourceDataCsReq> for ::trigger_protocol::GetResourceDataCsReq {
    fn from(value: GetResourceDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetResourceDataCsReq> for GetResourceDataCsReq {
    fn from(value: ::trigger_protocol::GetResourceDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetPhotoWallDataCsReq> for ::trigger_protocol::GetPhotoWallDataCsReq {
    fn from(value: GetPhotoWallDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPhotoWallDataCsReq> for GetPhotoWallDataCsReq {
    fn from(value: ::trigger_protocol::GetPhotoWallDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetDailyChallengeDataScRsp>
for ::trigger_protocol::GetDailyChallengeDataScRsp {
    fn from(value: GetDailyChallengeDataScRsp) -> Self {
        Self {
            data: value.data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetDailyChallengeDataScRsp>
for GetDailyChallengeDataScRsp {
    fn from(value: ::trigger_protocol::GetDailyChallengeDataScRsp) -> Self {
        Self {
            data: value.data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<Material> for ::trigger_protocol::Material {
    fn from(value: Material) -> Self {
        Self {
            id: value.id.into(),
            num: value.num.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::Material> for Material {
    fn from(value: ::trigger_protocol::Material) -> Self {
        Self {
            id: value.id.into(),
            num: value.num.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<AvatarDataPackage> for ::trigger_protocol::AvatarDataPackage {
    fn from(value: AvatarDataPackage) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AvatarDataPackage> for AvatarDataPackage {
    fn from(value: ::trigger_protocol::AvatarDataPackage) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<QuestCollection> for ::trigger_protocol::QuestCollection {
    fn from(value: QuestCollection) -> Self {
        Self {
            finished_quest_id_list: value
                .finished_quest_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            quest_list: value.quest_list.into_iter().map(|v| v.into()).collect(),
            quest_type: value.quest_type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::QuestCollection> for QuestCollection {
    fn from(value: ::trigger_protocol::QuestCollection) -> Self {
        Self {
            finished_quest_id_list: value
                .finished_quest_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            quest_list: value.quest_list.into_iter().map(|v| v.into()).collect(),
            quest_type: value.quest_type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetCharacterQuestListCsReq>
for ::trigger_protocol::GetCharacterQuestListCsReq {
    fn from(value: GetCharacterQuestListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetCharacterQuestListCsReq>
for GetCharacterQuestListCsReq {
    fn from(value: ::trigger_protocol::GetCharacterQuestListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetTipsInfoCsReq> for ::trigger_protocol::GetTipsInfoCsReq {
    fn from(value: GetTipsInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetTipsInfoCsReq> for GetTipsInfoCsReq {
    fn from(value: ::trigger_protocol::GetTipsInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetAvatarRecommendEquipCsReq>
for ::trigger_protocol::GetAvatarRecommendEquipCsReq {
    fn from(value: GetAvatarRecommendEquipCsReq) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetAvatarRecommendEquipCsReq>
for GetAvatarRecommendEquipCsReq {
    fn from(value: ::trigger_protocol::GetAvatarRecommendEquipCsReq) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<BeginTrainingCourseBattleCsReq>
for ::trigger_protocol::BeginTrainingCourseBattleCsReq {
    fn from(value: BeginTrainingCourseBattleCsReq) -> Self {
        Self {
            buddy_id: value.buddy_id.into(),
            quest_id: value.quest_id.into(),
            avatar_id_list: value.avatar_id_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::BeginTrainingCourseBattleCsReq>
for BeginTrainingCourseBattleCsReq {
    fn from(value: ::trigger_protocol::BeginTrainingCourseBattleCsReq) -> Self {
        Self {
            buddy_id: value.buddy_id.into(),
            quest_id: value.quest_id.into(),
            avatar_id_list: value.avatar_id_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PerformTriggerScRsp> for ::trigger_protocol::PerformTriggerScRsp {
    fn from(value: PerformTriggerScRsp) -> Self {
        Self {
            perform_uid: value.perform_uid.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PerformTriggerScRsp> for PerformTriggerScRsp {
    fn from(value: ::trigger_protocol::PerformTriggerScRsp) -> Self {
        Self {
            perform_uid: value.perform_uid.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetArchiveDataScRsp> for ::trigger_protocol::GetArchiveDataScRsp {
    fn from(value: GetArchiveDataScRsp) -> Self {
        Self {
            archive_data: value.archive_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetArchiveDataScRsp> for GetArchiveDataScRsp {
    fn from(value: ::trigger_protocol::GetArchiveDataScRsp) -> Self {
        Self {
            archive_data: value.archive_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetArchiveDataCsReq> for ::trigger_protocol::GetArchiveDataCsReq {
    fn from(value: GetArchiveDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetArchiveDataCsReq> for GetArchiveDataCsReq {
    fn from(value: ::trigger_protocol::GetArchiveDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<PlayerDisplayData> for ::trigger_protocol::PlayerDisplayData {
    fn from(value: PlayerDisplayData) -> Self {
        Self {
            display_item_group: value.display_item_group.map(|v| v.into()),
            avatar_data_package: value.avatar_data_package.map(|v| v.into()),
            photo_wall_network_data: value.photo_wall_network_data.map(|v| v.into()),
            signature: value.signature.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PlayerDisplayData> for PlayerDisplayData {
    fn from(value: ::trigger_protocol::PlayerDisplayData) -> Self {
        Self {
            display_item_group: value.display_item_group.map(|v| v.into()),
            avatar_data_package: value.avatar_data_package.map(|v| v.into()),
            photo_wall_network_data: value.photo_wall_network_data.map(|v| v.into()),
            signature: value.signature.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRamenDataCsReq> for ::trigger_protocol::GetRamenDataCsReq {
    fn from(value: GetRamenDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRamenDataCsReq> for GetRamenDataCsReq {
    fn from(value: ::trigger_protocol::GetRamenDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetBattlePassDataCsReq> for ::trigger_protocol::GetBattlePassDataCsReq {
    fn from(value: GetBattlePassDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetBattlePassDataCsReq> for GetBattlePassDataCsReq {
    fn from(value: ::trigger_protocol::GetBattlePassDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetFairyDataCsReq> for ::trigger_protocol::GetFairyDataCsReq {
    fn from(value: GetFairyDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetFairyDataCsReq> for GetFairyDataCsReq {
    fn from(value: ::trigger_protocol::GetFairyDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<MusicPlayerData> for ::trigger_protocol::MusicPlayerData {
    fn from(value: MusicPlayerData) -> Self {
        Self {
            music_list: value.music_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::MusicPlayerData> for MusicPlayerData {
    fn from(value: ::trigger_protocol::MusicPlayerData) -> Self {
        Self {
            music_list: value.music_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetCollectMapScRsp> for ::trigger_protocol::GetCollectMapScRsp {
    fn from(value: GetCollectMapScRsp) -> Self {
        Self {
            collect_map: value.collect_map.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetCollectMapScRsp> for GetCollectMapScRsp {
    fn from(value: ::trigger_protocol::GetCollectMapScRsp) -> Self {
        Self {
            collect_map: value.collect_map.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EquipProperty> for ::trigger_protocol::EquipProperty {
    fn from(value: EquipProperty) -> Self {
        Self {
            base_value: value.base_value.into(),
            key: value.key.into(),
            add_value: value.add_value.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EquipProperty> for EquipProperty {
    fn from(value: ::trigger_protocol::EquipProperty) -> Self {
        Self {
            base_value: value.base_value.into(),
            key: value.key.into(),
            add_value: value.add_value.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<FinishArchivePerformCsReq> for ::trigger_protocol::FinishArchivePerformCsReq {
    fn from(value: FinishArchivePerformCsReq) -> Self {
        Self {
            quest_id: value.quest_id.into(),
            sub_id: value.sub_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::FinishArchivePerformCsReq> for FinishArchivePerformCsReq {
    fn from(value: ::trigger_protocol::FinishArchivePerformCsReq) -> Self {
        Self {
            quest_id: value.quest_id.into(),
            sub_id: value.sub_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<ActionInfo> for ::trigger_protocol::ActionInfo {
    fn from(value: ActionInfo) -> Self {
        Self {
            body: value.body.into_iter().map(|v| v.into()).collect(),
            action_type: value.action_type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ActionInfo> for ActionInfo {
    fn from(value: ::trigger_protocol::ActionInfo) -> Self {
        Self {
            body: value.body.into_iter().map(|v| v.into()).collect(),
            action_type: value.action_type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetPrivateMessageDataScRsp>
for ::trigger_protocol::GetPrivateMessageDataScRsp {
    fn from(value: GetPrivateMessageDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPrivateMessageDataScRsp>
for GetPrivateMessageDataScRsp {
    fn from(value: ::trigger_protocol::GetPrivateMessageDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<AvatarSkillLevel> for ::trigger_protocol::AvatarSkillLevel {
    fn from(value: AvatarSkillLevel) -> Self {
        Self {
            skill_type: value.skill_type.into(),
            level: value.level.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AvatarSkillLevel> for AvatarSkillLevel {
    fn from(value: ::trigger_protocol::AvatarSkillLevel) -> Self {
        Self {
            skill_type: value.skill_type.into(),
            level: value.level.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<ClientSystemsData> for ::trigger_protocol::ClientSystemsData {
    fn from(value: ClientSystemsData) -> Self {
        Self {
            music_player_data: value.music_player_data.map(|v| v.into()),
            post_girl_data: value.post_girl_data.map(|v| v.into()),
            unlock_data: value.unlock_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ClientSystemsData> for ClientSystemsData {
    fn from(value: ::trigger_protocol::ClientSystemsData) -> Self {
        Self {
            music_player_data: value.music_player_data.map(|v| v.into()),
            post_girl_data: value.post_girl_data.map(|v| v.into()),
            unlock_data: value.unlock_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetJourneyDataScRsp> for ::trigger_protocol::GetJourneyDataScRsp {
    fn from(value: GetJourneyDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetJourneyDataScRsp> for GetJourneyDataScRsp {
    fn from(value: ::trigger_protocol::GetJourneyDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetTipsInfoScRsp> for ::trigger_protocol::GetTipsInfoScRsp {
    fn from(value: GetTipsInfoScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetTipsInfoScRsp> for GetTipsInfoScRsp {
    fn from(value: ::trigger_protocol::GetTipsInfoScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetFashionStoreDataCsReq> for ::trigger_protocol::GetFashionStoreDataCsReq {
    fn from(value: GetFashionStoreDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetFashionStoreDataCsReq> for GetFashionStoreDataCsReq {
    fn from(value: ::trigger_protocol::GetFashionStoreDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<AvatarUnitInfo> for ::trigger_protocol::AvatarUnitInfo {
    fn from(value: AvatarUnitInfo) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AvatarUnitInfo> for AvatarUnitInfo {
    fn from(value: ::trigger_protocol::AvatarUnitInfo) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetNewsStandDataCsReq> for ::trigger_protocol::GetNewsStandDataCsReq {
    fn from(value: GetNewsStandDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetNewsStandDataCsReq> for GetNewsStandDataCsReq {
    fn from(value: ::trigger_protocol::GetNewsStandDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetPlayerTransactionScRsp> for ::trigger_protocol::GetPlayerTransactionScRsp {
    fn from(value: GetPlayerTransactionScRsp) -> Self {
        Self {
            transaction: value.transaction.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPlayerTransactionScRsp> for GetPlayerTransactionScRsp {
    fn from(value: ::trigger_protocol::GetPlayerTransactionScRsp) -> Self {
        Self {
            transaction: value.transaction.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetWebActivityDataScRsp> for ::trigger_protocol::GetWebActivityDataScRsp {
    fn from(value: GetWebActivityDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetWebActivityDataScRsp> for GetWebActivityDataScRsp {
    fn from(value: ::trigger_protocol::GetWebActivityDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<AutoRecoveryInfo> for ::trigger_protocol::AutoRecoveryInfo {
    fn from(value: AutoRecoveryInfo) -> Self {
        Self {
            buy_times: value.buy_times.into(),
            last_recovery_timestamp: value.last_recovery_timestamp.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AutoRecoveryInfo> for AutoRecoveryInfo {
    fn from(value: ::trigger_protocol::AutoRecoveryInfo) -> Self {
        Self {
            buy_times: value.buy_times.into(),
            last_recovery_timestamp: value.last_recovery_timestamp.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetBuddyDataCsReq> for ::trigger_protocol::GetBuddyDataCsReq {
    fn from(value: GetBuddyDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetBuddyDataCsReq> for GetBuddyDataCsReq {
    fn from(value: ::trigger_protocol::GetBuddyDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetCampIdleDataCsReq> for ::trigger_protocol::GetCampIdleDataCsReq {
    fn from(value: GetCampIdleDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetCampIdleDataCsReq> for GetCampIdleDataCsReq {
    fn from(value: ::trigger_protocol::GetCampIdleDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetAuthkeyCsReq> for ::trigger_protocol::GetAuthkeyCsReq {
    fn from(value: GetAuthkeyCsReq) -> Self {
        Self {
            auth_appid: value.auth_appid.into(),
            authkey_ver: value.authkey_ver.into(),
            sign_type: value.sign_type.into(),
            offline_verify_value: value.offline_verify_value.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetAuthkeyCsReq> for GetAuthkeyCsReq {
    fn from(value: ::trigger_protocol::GetAuthkeyCsReq) -> Self {
        Self {
            auth_appid: value.auth_appid.into(),
            authkey_ver: value.authkey_ver.into(),
            sign_type: value.sign_type.into(),
            offline_verify_value: value.offline_verify_value.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetQuestionsAnswerGameDataScRsp>
for ::trigger_protocol::GetQuestionsAnswerGameDataScRsp {
    fn from(value: GetQuestionsAnswerGameDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetQuestionsAnswerGameDataScRsp>
for GetQuestionsAnswerGameDataScRsp {
    fn from(value: ::trigger_protocol::GetQuestionsAnswerGameDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRedDotListCsReq> for ::trigger_protocol::GetRedDotListCsReq {
    fn from(value: GetRedDotListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRedDotListCsReq> for GetRedDotListCsReq {
    fn from(value: ::trigger_protocol::GetRedDotListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetHadalZoneDataCsReq> for ::trigger_protocol::GetHadalZoneDataCsReq {
    fn from(value: GetHadalZoneDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetHadalZoneDataCsReq> for GetHadalZoneDataCsReq {
    fn from(value: ::trigger_protocol::GetHadalZoneDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<AbyssGetDataCsReq> for ::trigger_protocol::AbyssGetDataCsReq {
    fn from(value: AbyssGetDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AbyssGetDataCsReq> for AbyssGetDataCsReq {
    fn from(value: ::trigger_protocol::AbyssGetDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<BuddyUnitInfo> for ::trigger_protocol::BuddyUnitInfo {
    fn from(value: BuddyUnitInfo) -> Self {
        Self {
            r#type: value.r#type.into(),
            buddy_id: value.buddy_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::BuddyUnitInfo> for BuddyUnitInfo {
    fn from(value: ::trigger_protocol::BuddyUnitInfo) -> Self {
        Self {
            r#type: value.r#type.into(),
            buddy_id: value.buddy_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<DungeonQuestInfo> for ::trigger_protocol::DungeonQuestInfo {
    fn from(value: DungeonQuestInfo) -> Self {
        Self {
            inner_quest_id_list: value
                .inner_quest_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DungeonQuestInfo> for DungeonQuestInfo {
    fn from(value: ::trigger_protocol::DungeonQuestInfo) -> Self {
        Self {
            inner_quest_id_list: value
                .inner_quest_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetCafeDataCsReq> for ::trigger_protocol::GetCafeDataCsReq {
    fn from(value: GetCafeDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetCafeDataCsReq> for GetCafeDataCsReq {
    fn from(value: ::trigger_protocol::GetCafeDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<BattleReportScRsp> for ::trigger_protocol::BattleReportScRsp {
    fn from(value: BattleReportScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::BattleReportScRsp> for BattleReportScRsp {
    fn from(value: ::trigger_protocol::BattleReportScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<ItemSync> for ::trigger_protocol::ItemSync {
    fn from(value: ItemSync) -> Self {
        Self {
            weapon_list: value.weapon_list.into_iter().map(|v| v.into()).collect(),
            auto_recovery_info: value
                .auto_recovery_info
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            material_list: value.material_list.into_iter().map(|v| v.into()).collect(),
            equip_list: value.equip_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ItemSync> for ItemSync {
    fn from(value: ::trigger_protocol::ItemSync) -> Self {
        Self {
            weapon_list: value.weapon_list.into_iter().map(|v| v.into()).collect(),
            auto_recovery_info: value
                .auto_recovery_info
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            material_list: value.material_list.into_iter().map(|v| v.into()).collect(),
            equip_list: value.equip_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<DungeonEquipInfo> for ::trigger_protocol::DungeonEquipInfo {
    fn from(value: DungeonEquipInfo) -> Self {
        Self {
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            weapon_list: value.weapon_list.into_iter().map(|v| v.into()).collect(),
            equip_list: value.equip_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DungeonEquipInfo> for DungeonEquipInfo {
    fn from(value: ::trigger_protocol::DungeonEquipInfo) -> Self {
        Self {
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            weapon_list: value.weapon_list.into_iter().map(|v| v.into()).collect(),
            equip_list: value.equip_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRidusGotBooDataCsReq> for ::trigger_protocol::GetRidusGotBooDataCsReq {
    fn from(value: GetRidusGotBooDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRidusGotBooDataCsReq> for GetRidusGotBooDataCsReq {
    fn from(value: ::trigger_protocol::GetRidusGotBooDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<DressEquipmentSuitCsReq> for ::trigger_protocol::DressEquipmentSuitCsReq {
    fn from(value: DressEquipmentSuitCsReq) -> Self {
        Self {
            param_list: value.param_list.into_iter().map(|v| v.into()).collect(),
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DressEquipmentSuitCsReq> for DressEquipmentSuitCsReq {
    fn from(value: ::trigger_protocol::DressEquipmentSuitCsReq) -> Self {
        Self {
            param_list: value.param_list.into_iter().map(|v| v.into()).collect(),
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<RewardBuffData> for ::trigger_protocol::RewardBuffData {
    fn from(value: RewardBuffData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RewardBuffData> for RewardBuffData {
    fn from(value: ::trigger_protocol::RewardBuffData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<TrashbinHermitData> for ::trigger_protocol::TrashbinHermitData {
    fn from(value: TrashbinHermitData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::TrashbinHermitData> for TrashbinHermitData {
    fn from(value: ::trigger_protocol::TrashbinHermitData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<CollectMap> for ::trigger_protocol::CollectMap {
    fn from(value: CollectMap) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::CollectMap> for CollectMap {
    fn from(value: ::trigger_protocol::CollectMap) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetQuestionsAnswerGameDataCsReq>
for ::trigger_protocol::GetQuestionsAnswerGameDataCsReq {
    fn from(value: GetQuestionsAnswerGameDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetQuestionsAnswerGameDataCsReq>
for GetQuestionsAnswerGameDataCsReq {
    fn from(value: ::trigger_protocol::GetQuestionsAnswerGameDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<PlayerBasicInfo> for ::trigger_protocol::PlayerBasicInfo {
    fn from(value: PlayerBasicInfo) -> Self {
        Self {
            last_enter_world_timestamp: value.last_enter_world_timestamp.into(),
            control_avatar_id: value.control_avatar_id.into(),
            avatar_id: value.avatar_id.into(),
            exp: value.exp.into(),
            level: value.level.into(),
            nick_name: value.nick_name.into(),
            player_avatar_id: value.player_avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PlayerBasicInfo> for PlayerBasicInfo {
    fn from(value: ::trigger_protocol::PlayerBasicInfo) -> Self {
        Self {
            last_enter_world_timestamp: value.last_enter_world_timestamp.into(),
            control_avatar_id: value.control_avatar_id.into(),
            avatar_id: value.avatar_id.into(),
            exp: value.exp.into(),
            level: value.level.into(),
            nick_name: value.nick_name.into(),
            player_avatar_id: value.player_avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetPlayerTransactionCsReq> for ::trigger_protocol::GetPlayerTransactionCsReq {
    fn from(value: GetPlayerTransactionCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPlayerTransactionCsReq> for GetPlayerTransactionCsReq {
    fn from(value: ::trigger_protocol::GetPlayerTransactionCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetDailyChallengeDataCsReq>
for ::trigger_protocol::GetDailyChallengeDataCsReq {
    fn from(value: GetDailyChallengeDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetDailyChallengeDataCsReq>
for GetDailyChallengeDataCsReq {
    fn from(value: ::trigger_protocol::GetDailyChallengeDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<PerformTriggerCsReq> for ::trigger_protocol::PerformTriggerCsReq {
    fn from(value: PerformTriggerCsReq) -> Self {
        Self {
            perform_type: value.perform_type.into(),
            perform_id: value.perform_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PerformTriggerCsReq> for PerformTriggerCsReq {
    fn from(value: ::trigger_protocol::PerformTriggerCsReq) -> Self {
        Self {
            perform_type: value.perform_type.into(),
            perform_id: value.perform_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<DressEquipmentCsReq> for ::trigger_protocol::DressEquipmentCsReq {
    fn from(value: DressEquipmentCsReq) -> Self {
        Self {
            equip_uid: value.equip_uid.into(),
            dress_index: value.dress_index.into(),
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DressEquipmentCsReq> for DressEquipmentCsReq {
    fn from(value: ::trigger_protocol::DressEquipmentCsReq) -> Self {
        Self {
            equip_uid: value.equip_uid.into(),
            dress_index: value.dress_index.into(),
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PlayerLogoutCsReq> for ::trigger_protocol::PlayerLogoutCsReq {
    fn from(value: PlayerLogoutCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PlayerLogoutCsReq> for PlayerLogoutCsReq {
    fn from(value: ::trigger_protocol::PlayerLogoutCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetGachaDataCsReq> for ::trigger_protocol::GetGachaDataCsReq {
    fn from(value: GetGachaDataCsReq) -> Self {
        Self {
            gacha_type: value.gacha_type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetGachaDataCsReq> for GetGachaDataCsReq {
    fn from(value: ::trigger_protocol::GetGachaDataCsReq) -> Self {
        Self {
            gacha_type: value.gacha_type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetJourneyDataCsReq> for ::trigger_protocol::GetJourneyDataCsReq {
    fn from(value: GetJourneyDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetJourneyDataCsReq> for GetJourneyDataCsReq {
    fn from(value: ::trigger_protocol::GetJourneyDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<EnterSectionCompleteScRsp> for ::trigger_protocol::EnterSectionCompleteScRsp {
    fn from(value: EnterSectionCompleteScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EnterSectionCompleteScRsp> for EnterSectionCompleteScRsp {
    fn from(value: ::trigger_protocol::EnterSectionCompleteScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetWebActivityDataCsReq> for ::trigger_protocol::GetWebActivityDataCsReq {
    fn from(value: GetWebActivityDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetWebActivityDataCsReq> for GetWebActivityDataCsReq {
    fn from(value: ::trigger_protocol::GetWebActivityDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetOnlineFriendsListCsReq> for ::trigger_protocol::GetOnlineFriendsListCsReq {
    fn from(value: GetOnlineFriendsListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetOnlineFriendsListCsReq> for GetOnlineFriendsListCsReq {
    fn from(value: ::trigger_protocol::GetOnlineFriendsListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetServerTimestampScRsp> for ::trigger_protocol::GetServerTimestampScRsp {
    fn from(value: GetServerTimestampScRsp) -> Self {
        Self {
            timestamp: value.timestamp.into(),
            utc_offset: value.utc_offset.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetServerTimestampScRsp> for GetServerTimestampScRsp {
    fn from(value: ::trigger_protocol::GetServerTimestampScRsp) -> Self {
        Self {
            timestamp: value.timestamp.into(),
            utc_offset: value.utc_offset.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetAuthkeyScRsp> for ::trigger_protocol::GetAuthkeyScRsp {
    fn from(value: GetAuthkeyScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            authkey_ver: value.authkey_ver.into(),
            authkey: value.authkey.into(),
            auth_appid: value.auth_appid.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetAuthkeyScRsp> for GetAuthkeyScRsp {
    fn from(value: ::trigger_protocol::GetAuthkeyScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            authkey_ver: value.authkey_ver.into(),
            authkey: value.authkey.into(),
            auth_appid: value.auth_appid.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetShoppingMallInfoScRsp> for ::trigger_protocol::GetShoppingMallInfoScRsp {
    fn from(value: GetShoppingMallInfoScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            shopping_mall_info: value.shopping_mall_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetShoppingMallInfoScRsp> for GetShoppingMallInfoScRsp {
    fn from(value: ::trigger_protocol::GetShoppingMallInfoScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            shopping_mall_info: value.shopping_mall_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetAbyssRewardDataScRsp> for ::trigger_protocol::GetAbyssRewardDataScRsp {
    fn from(value: GetAbyssRewardDataScRsp) -> Self {
        Self {
            abyss_reward_data: value.abyss_reward_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetAbyssRewardDataScRsp> for GetAbyssRewardDataScRsp {
    fn from(value: ::trigger_protocol::GetAbyssRewardDataScRsp) -> Self {
        Self {
            abyss_reward_data: value.abyss_reward_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PerformEndCsReq> for ::trigger_protocol::PerformEndCsReq {
    fn from(value: PerformEndCsReq) -> Self {
        Self {
            perform_uid: value.perform_uid.into(),
            perform_type: value.perform_type.into(),
            perform_id: value.perform_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PerformEndCsReq> for PerformEndCsReq {
    fn from(value: ::trigger_protocol::PerformEndCsReq) -> Self {
        Self {
            perform_uid: value.perform_uid.into(),
            perform_type: value.perform_type.into(),
            perform_id: value.perform_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRedDotListScRsp> for ::trigger_protocol::GetRedDotListScRsp {
    fn from(value: GetRedDotListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRedDotListScRsp> for GetRedDotListScRsp {
    fn from(value: ::trigger_protocol::GetRedDotListScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<DailyChallengeData> for ::trigger_protocol::DailyChallengeData {
    fn from(value: DailyChallengeData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DailyChallengeData> for DailyChallengeData {
    fn from(value: ::trigger_protocol::DailyChallengeData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetClientSystemsDataScRsp> for ::trigger_protocol::GetClientSystemsDataScRsp {
    fn from(value: GetClientSystemsDataScRsp) -> Self {
        Self {
            data: value.data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetClientSystemsDataScRsp> for GetClientSystemsDataScRsp {
    fn from(value: ::trigger_protocol::GetClientSystemsDataScRsp) -> Self {
        Self {
            data: value.data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EnterWorldScRsp> for ::trigger_protocol::EnterWorldScRsp {
    fn from(value: EnterWorldScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EnterWorldScRsp> for EnterWorldScRsp {
    fn from(value: ::trigger_protocol::EnterWorldScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<HallSceneInfo> for ::trigger_protocol::HallSceneInfo {
    fn from(value: HallSceneInfo) -> Self {
        Self {
            scene_unit_list: value
                .scene_unit_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            player_avatar_id: value.player_avatar_id.into(),
            transform_id: value.transform_id.into(),
            day_of_week: value.day_of_week.into(),
            bgm_id: value.bgm_id.into(),
            position: value.position.map(|v| v.into()),
            time_of_day: value.time_of_day.into(),
            section_id: value.section_id.into(),
            control_avatar_id: value.control_avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::HallSceneInfo> for HallSceneInfo {
    fn from(value: ::trigger_protocol::HallSceneInfo) -> Self {
        Self {
            scene_unit_list: value
                .scene_unit_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            player_avatar_id: value.player_avatar_id.into(),
            transform_id: value.transform_id.into(),
            day_of_week: value.day_of_week.into(),
            bgm_id: value.bgm_id.into(),
            position: value.position.map(|v| v.into()),
            time_of_day: value.time_of_day.into(),
            section_id: value.section_id.into(),
            control_avatar_id: value.control_avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRamenDataScRsp> for ::trigger_protocol::GetRamenDataScRsp {
    fn from(value: GetRamenDataScRsp) -> Self {
        Self {
            ramen_data: value.ramen_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRamenDataScRsp> for GetRamenDataScRsp {
    fn from(value: ::trigger_protocol::GetRamenDataScRsp) -> Self {
        Self {
            ramen_data: value.ramen_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetWeaponDataScRsp> for ::trigger_protocol::GetWeaponDataScRsp {
    fn from(value: GetWeaponDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            weapon_list: value.weapon_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetWeaponDataScRsp> for GetWeaponDataScRsp {
    fn from(value: ::trigger_protocol::GetWeaponDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            weapon_list: value.weapon_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<FightSettle> for ::trigger_protocol::FightSettle {
    fn from(value: FightSettle) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::FightSettle> for FightSettle {
    fn from(value: ::trigger_protocol::FightSettle) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<VhsStoreData> for ::trigger_protocol::VhsStoreData {
    fn from(value: VhsStoreData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::VhsStoreData> for VhsStoreData {
    fn from(value: ::trigger_protocol::VhsStoreData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetMiniscapeEntrustDataScRsp>
for ::trigger_protocol::GetMiniscapeEntrustDataScRsp {
    fn from(value: GetMiniscapeEntrustDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetMiniscapeEntrustDataScRsp>
for GetMiniscapeEntrustDataScRsp {
    fn from(value: ::trigger_protocol::GetMiniscapeEntrustDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetArcadeDataCsReq> for ::trigger_protocol::GetArcadeDataCsReq {
    fn from(value: GetArcadeDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetArcadeDataCsReq> for GetArcadeDataCsReq {
    fn from(value: ::trigger_protocol::GetArcadeDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<RallySceneInfo> for ::trigger_protocol::RallySceneInfo {
    fn from(value: RallySceneInfo) -> Self {
        Self {
            level_perform_info: value.level_perform_info.map(|v| v.into()),
            cur_check_point: value.cur_check_point.map(|v| v.into()),
            level_reward_info: value.level_reward_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RallySceneInfo> for RallySceneInfo {
    fn from(value: ::trigger_protocol::RallySceneInfo) -> Self {
        Self {
            level_perform_info: value.level_perform_info.map(|v| v.into()),
            cur_check_point: value.cur_check_point.map(|v| v.into()),
            level_reward_info: value.level_reward_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetTrashbinHermitDataCsReq>
for ::trigger_protocol::GetTrashbinHermitDataCsReq {
    fn from(value: GetTrashbinHermitDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetTrashbinHermitDataCsReq>
for GetTrashbinHermitDataCsReq {
    fn from(value: ::trigger_protocol::GetTrashbinHermitDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<DressEquipmentParam> for ::trigger_protocol::DressEquipmentParam {
    fn from(value: DressEquipmentParam) -> Self {
        Self {
            equip_uid: value.equip_uid.into(),
            dress_index: value.dress_index.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DressEquipmentParam> for DressEquipmentParam {
    fn from(value: ::trigger_protocol::DressEquipmentParam) -> Self {
        Self {
            equip_uid: value.equip_uid.into(),
            dress_index: value.dress_index.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetVhsStoreDataScRsp> for ::trigger_protocol::GetVhsStoreDataScRsp {
    fn from(value: GetVhsStoreDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            data: value.data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetVhsStoreDataScRsp> for GetVhsStoreDataScRsp {
    fn from(value: ::trigger_protocol::GetVhsStoreDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            data: value.data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetActivityDataScRsp> for ::trigger_protocol::GetActivityDataScRsp {
    fn from(value: GetActivityDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetActivityDataScRsp> for GetActivityDataScRsp {
    fn from(value: ::trigger_protocol::GetActivityDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<CafeSync> for ::trigger_protocol::CafeSync {
    fn from(value: CafeSync) -> Self {
        Self {
            cafe_data: value.cafe_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::CafeSync> for CafeSync {
    fn from(value: ::trigger_protocol::CafeSync) -> Self {
        Self {
            cafe_data: value.cafe_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<QuestData> for ::trigger_protocol::QuestData {
    fn from(value: QuestData) -> Self {
        Self {
            quest_collection_list: value
                .quest_collection_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::QuestData> for QuestData {
    fn from(value: ::trigger_protocol::QuestData) -> Self {
        Self {
            quest_collection_list: value
                .quest_collection_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<FightSceneInfo> for ::trigger_protocol::FightSceneInfo {
    fn from(value: FightSceneInfo) -> Self {
        Self {
            perform_type: value.perform_type.into(),
            level_reward_info: value.level_reward_info.map(|v| v.into()),
            end_hollow: value.end_hollow.into(),
            level_perform_info: value.level_perform_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::FightSceneInfo> for FightSceneInfo {
    fn from(value: ::trigger_protocol::FightSceneInfo) -> Self {
        Self {
            perform_type: value.perform_type.into(),
            level_reward_info: value.level_reward_info.map(|v| v.into()),
            end_hollow: value.end_hollow.into(),
            level_perform_info: value.level_perform_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<SceneInfo> for ::trigger_protocol::SceneInfo {
    fn from(value: SceneInfo) -> Self {
        Self {
            scene_type: value.scene_type.into(),
            local_play_type: value.local_play_type.into(),
            hall_scene_info: value.hall_scene_info.map(|v| v.into()),
            rally_scene_info: value.rally_scene_info.map(|v| v.into()),
            event_id: value.event_id.into(),
            fight_scene_info: value.fight_scene_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::SceneInfo> for SceneInfo {
    fn from(value: ::trigger_protocol::SceneInfo) -> Self {
        Self {
            scene_type: value.scene_type.into(),
            local_play_type: value.local_play_type.into(),
            hall_scene_info: value.hall_scene_info.map(|v| v.into()),
            rally_scene_info: value.rally_scene_info.map(|v| v.into()),
            event_id: value.event_id.into(),
            fight_scene_info: value.fight_scene_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetServerTimestampCsReq> for ::trigger_protocol::GetServerTimestampCsReq {
    fn from(value: GetServerTimestampCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetServerTimestampCsReq> for GetServerTimestampCsReq {
    fn from(value: ::trigger_protocol::GetServerTimestampCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<WorkbenchData> for ::trigger_protocol::WorkbenchData {
    fn from(value: WorkbenchData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::WorkbenchData> for WorkbenchData {
    fn from(value: ::trigger_protocol::WorkbenchData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetRoleCardDataCsReq> for ::trigger_protocol::GetRoleCardDataCsReq {
    fn from(value: GetRoleCardDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRoleCardDataCsReq> for GetRoleCardDataCsReq {
    fn from(value: ::trigger_protocol::GetRoleCardDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<SavePlayerSystemSettingCsReq>
for ::trigger_protocol::SavePlayerSystemSettingCsReq {
    fn from(value: SavePlayerSystemSettingCsReq) -> Self {
        Self {
            r#type: value.r#type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::SavePlayerSystemSettingCsReq>
for SavePlayerSystemSettingCsReq {
    fn from(value: ::trigger_protocol::SavePlayerSystemSettingCsReq) -> Self {
        Self {
            r#type: value.r#type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<UnlockData> for ::trigger_protocol::UnlockData {
    fn from(value: UnlockData) -> Self {
        Self {
            unlocked_list: value.unlocked_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::UnlockData> for UnlockData {
    fn from(value: ::trigger_protocol::UnlockData) -> Self {
        Self {
            unlocked_list: value.unlocked_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PerformJumpCsReq> for ::trigger_protocol::PerformJumpCsReq {
    fn from(value: PerformJumpCsReq) -> Self {
        Self {
            perform_uid: value.perform_uid.into(),
            perform_type: value.perform_type.into(),
            perform_id: value.perform_id.into(),
            comic_index: value.comic_index.into(),
            furthest_chapter: value.furthest_chapter.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PerformJumpCsReq> for PerformJumpCsReq {
    fn from(value: ::trigger_protocol::PerformJumpCsReq) -> Self {
        Self {
            perform_uid: value.perform_uid.into(),
            perform_type: value.perform_type.into(),
            perform_id: value.perform_id.into(),
            comic_index: value.comic_index.into(),
            furthest_chapter: value.furthest_chapter.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<QuestCondProgress> for ::trigger_protocol::QuestCondProgress {
    fn from(value: QuestCondProgress) -> Self {
        Self {
            public_variables: value
                .public_variables
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::QuestCondProgress> for QuestCondProgress {
    fn from(value: ::trigger_protocol::QuestCondProgress) -> Self {
        Self {
            public_variables: value
                .public_variables
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetQuestDataCsReq> for ::trigger_protocol::GetQuestDataCsReq {
    fn from(value: GetQuestDataCsReq) -> Self {
        Self {
            quest_type: value.quest_type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetQuestDataCsReq> for GetQuestDataCsReq {
    fn from(value: ::trigger_protocol::GetQuestDataCsReq) -> Self {
        Self {
            quest_type: value.quest_type.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetChatEmojiListCsReq> for ::trigger_protocol::GetChatEmojiListCsReq {
    fn from(value: GetChatEmojiListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetChatEmojiListCsReq> for GetChatEmojiListCsReq {
    fn from(value: ::trigger_protocol::GetChatEmojiListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<PostGirlItem> for ::trigger_protocol::PostGirlItem {
    fn from(value: PostGirlItem) -> Self {
        Self {
            id: value.id.into(),
            unlock_time: value.unlock_time.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PostGirlItem> for PostGirlItem {
    fn from(value: ::trigger_protocol::PostGirlItem) -> Self {
        Self {
            id: value.id.into(),
            unlock_time: value.unlock_time.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetQuestDataScRsp> for ::trigger_protocol::GetQuestDataScRsp {
    fn from(value: GetQuestDataScRsp) -> Self {
        Self {
            quest_type: value.quest_type.into(),
            retcode: value.retcode.into(),
            quest_data: value.quest_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetQuestDataScRsp> for GetQuestDataScRsp {
    fn from(value: ::trigger_protocol::GetQuestDataScRsp) -> Self {
        Self {
            quest_type: value.quest_type.into(),
            retcode: value.retcode.into(),
            quest_data: value.quest_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetHollowDataCsReq> for ::trigger_protocol::GetHollowDataCsReq {
    fn from(value: GetHollowDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetHollowDataCsReq> for GetHollowDataCsReq {
    fn from(value: ::trigger_protocol::GetHollowDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetMainCityRevivalDataScRsp>
for ::trigger_protocol::GetMainCityRevivalDataScRsp {
    fn from(value: GetMainCityRevivalDataScRsp) -> Self {
        Self {
            main_city_revival_data: value.main_city_revival_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetMainCityRevivalDataScRsp>
for GetMainCityRevivalDataScRsp {
    fn from(value: ::trigger_protocol::GetMainCityRevivalDataScRsp) -> Self {
        Self {
            main_city_revival_data: value.main_city_revival_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PlayerSyncScNotify> for ::trigger_protocol::PlayerSyncScNotify {
    fn from(value: PlayerSyncScNotify) -> Self {
        Self {
            avatar_sync: value.avatar_sync.map(|v| v.into()),
            cafe_sync: value.cafe_sync.map(|v| v.into()),
            item_sync: value.item_sync.map(|v| v.into()),
            ramen_sync: value.ramen_sync.map(|v| v.into()),
            basic_info: value.basic_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PlayerSyncScNotify> for PlayerSyncScNotify {
    fn from(value: ::trigger_protocol::PlayerSyncScNotify) -> Self {
        Self {
            avatar_sync: value.avatar_sync.map(|v| v.into()),
            cafe_sync: value.cafe_sync.map(|v| v.into()),
            item_sync: value.item_sync.map(|v| v.into()),
            ramen_sync: value.ramen_sync.map(|v| v.into()),
            basic_info: value.basic_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EnterSectionCsReq> for ::trigger_protocol::EnterSectionCsReq {
    fn from(value: EnterSectionCsReq) -> Self {
        Self {
            transform_id: value.transform_id.into(),
            section_id: value.section_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EnterSectionCsReq> for EnterSectionCsReq {
    fn from(value: ::trigger_protocol::EnterSectionCsReq) -> Self {
        Self {
            transform_id: value.transform_id.into(),
            section_id: value.section_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EnterSceneScNotify> for ::trigger_protocol::EnterSceneScNotify {
    fn from(value: EnterSceneScNotify) -> Self {
        Self {
            dungeon_info: value.dungeon_info.map(|v| v.into()),
            scene_info: value.scene_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EnterSceneScNotify> for EnterSceneScNotify {
    fn from(value: ::trigger_protocol::EnterSceneScNotify) -> Self {
        Self {
            dungeon_info: value.dungeon_info.map(|v| v.into()),
            scene_info: value.scene_info.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetTrashbinHermitDataScRsp>
for ::trigger_protocol::GetTrashbinHermitDataScRsp {
    fn from(value: GetTrashbinHermitDataScRsp) -> Self {
        Self {
            trashbin_hermit_data: value.trashbin_hermit_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetTrashbinHermitDataScRsp>
for GetTrashbinHermitDataScRsp {
    fn from(value: ::trigger_protocol::GetTrashbinHermitDataScRsp) -> Self {
        Self {
            trashbin_hermit_data: value.trashbin_hermit_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetWeaponDataCsReq> for ::trigger_protocol::GetWeaponDataCsReq {
    fn from(value: GetWeaponDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetWeaponDataCsReq> for GetWeaponDataCsReq {
    fn from(value: ::trigger_protocol::GetWeaponDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<VideoGetInfoCsReq> for ::trigger_protocol::VideoGetInfoCsReq {
    fn from(value: VideoGetInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::VideoGetInfoCsReq> for VideoGetInfoCsReq {
    fn from(value: ::trigger_protocol::VideoGetInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<VideoGetInfoScRsp> for ::trigger_protocol::VideoGetInfoScRsp {
    fn from(value: VideoGetInfoScRsp) -> Self {
        Self {
            video_key_map: value
                .video_key_map
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::VideoGetInfoScRsp> for VideoGetInfoScRsp {
    fn from(value: ::trigger_protocol::VideoGetInfoScRsp) -> Self {
        Self {
            video_key_map: value
                .video_key_map
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<WeaponDressCsReq> for ::trigger_protocol::WeaponDressCsReq {
    fn from(value: WeaponDressCsReq) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            weapon_uid: value.weapon_uid.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::WeaponDressCsReq> for WeaponDressCsReq {
    fn from(value: ::trigger_protocol::WeaponDressCsReq) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            weapon_uid: value.weapon_uid.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<ArchiveData> for ::trigger_protocol::ArchiveData {
    fn from(value: ArchiveData) -> Self {
        Self {
            videotaps_info: value.videotaps_info.into_iter().map(|v| v.into()).collect(),
            hollow_archive_id_list: value
                .hollow_archive_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ArchiveData> for ArchiveData {
    fn from(value: ::trigger_protocol::ArchiveData) -> Self {
        Self {
            videotaps_info: value.videotaps_info.into_iter().map(|v| v.into()).collect(),
            hollow_archive_id_list: value
                .hollow_archive_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<EnterSectionCompleteCsReq> for ::trigger_protocol::EnterSectionCompleteCsReq {
    fn from(value: EnterSectionCompleteCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EnterSectionCompleteCsReq> for EnterSectionCompleteCsReq {
    fn from(value: ::trigger_protocol::EnterSectionCompleteCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetFishingContestDataScRsp>
for ::trigger_protocol::GetFishingContestDataScRsp {
    fn from(value: GetFishingContestDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetFishingContestDataScRsp>
for GetFishingContestDataScRsp {
    fn from(value: ::trigger_protocol::GetFishingContestDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<SceneUnitProtocolInfo> for ::trigger_protocol::SceneUnitProtocolInfo {
    fn from(value: SceneUnitProtocolInfo) -> Self {
        Self {
            npc_id: value.npc_id.into(),
            is_interactable: value.is_interactable.into(),
            interacts_info: value
                .interacts_info
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::SceneUnitProtocolInfo> for SceneUnitProtocolInfo {
    fn from(value: ::trigger_protocol::SceneUnitProtocolInfo) -> Self {
        Self {
            npc_id: value.npc_id.into(),
            is_interactable: value.is_interactable.into(),
            interacts_info: value
                .interacts_info
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PublicVariable> for ::trigger_protocol::PublicVariable {
    fn from(value: PublicVariable) -> Self {
        Self {
            r#type: value.r#type.into(),
            var_int: value.var_int.into(),
            var_number: value.var_number.into(),
            var_str: value.var_str.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PublicVariable> for PublicVariable {
    fn from(value: ::trigger_protocol::PublicVariable) -> Self {
        Self {
            r#type: value.r#type.into(),
            var_int: value.var_int.into(),
            var_number: value.var_number.into(),
            var_str: value.var_str.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<PlaySongCsReq> for ::trigger_protocol::PlaySongCsReq {
    fn from(value: PlaySongCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PlaySongCsReq> for PlaySongCsReq {
    fn from(value: ::trigger_protocol::PlaySongCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<WorkbenchGetDataCsReq> for ::trigger_protocol::WorkbenchGetDataCsReq {
    fn from(value: WorkbenchGetDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::WorkbenchGetDataCsReq> for WorkbenchGetDataCsReq {
    fn from(value: ::trigger_protocol::WorkbenchGetDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<AvatarSync> for ::trigger_protocol::AvatarSync {
    fn from(value: AvatarSync) -> Self {
        Self {
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AvatarSync> for AvatarSync {
    fn from(value: ::trigger_protocol::AvatarSync) -> Self {
        Self {
            avatar_list: value.avatar_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<RunEventGraphCsReq> for ::trigger_protocol::RunEventGraphCsReq {
    fn from(value: RunEventGraphCsReq) -> Self {
        Self {
            section_id: value.section_id.into(),
            tag: value.tag.into(),
            event_graph_uid: value.event_graph_uid.into(),
            owner_type: value.owner_type.into(),
            owner_id: value.owner_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RunEventGraphCsReq> for RunEventGraphCsReq {
    fn from(value: ::trigger_protocol::RunEventGraphCsReq) -> Self {
        Self {
            section_id: value.section_id.into(),
            tag: value.tag.into(),
            event_graph_uid: value.event_graph_uid.into(),
            owner_type: value.owner_type.into(),
            owner_id: value.owner_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetMonthCardRewardListCsReq>
for ::trigger_protocol::GetMonthCardRewardListCsReq {
    fn from(value: GetMonthCardRewardListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetMonthCardRewardListCsReq>
for GetMonthCardRewardListCsReq {
    fn from(value: ::trigger_protocol::GetMonthCardRewardListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<RefreshSectionScRsp> for ::trigger_protocol::RefreshSectionScRsp {
    fn from(value: RefreshSectionScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            refresh_status: value.refresh_status.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RefreshSectionScRsp> for RefreshSectionScRsp {
    fn from(value: ::trigger_protocol::RefreshSectionScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            refresh_status: value.refresh_status.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetBattleEventInfoScRsp> for ::trigger_protocol::GetBattleEventInfoScRsp {
    fn from(value: GetBattleEventInfoScRsp) -> Self {
        Self {
            event_info: value.event_info.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetBattleEventInfoScRsp> for GetBattleEventInfoScRsp {
    fn from(value: ::trigger_protocol::GetBattleEventInfoScRsp) -> Self {
        Self {
            event_info: value.event_info.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetWishlistDataScRsp> for ::trigger_protocol::GetWishlistDataScRsp {
    fn from(value: GetWishlistDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetWishlistDataScRsp> for GetWishlistDataScRsp {
    fn from(value: ::trigger_protocol::GetWishlistDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<MainCityRevivalData> for ::trigger_protocol::MainCityRevivalData {
    fn from(value: MainCityRevivalData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::MainCityRevivalData> for MainCityRevivalData {
    fn from(value: ::trigger_protocol::MainCityRevivalData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<LeaveCurSceneCsReq> for ::trigger_protocol::LeaveCurSceneCsReq {
    fn from(value: LeaveCurSceneCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::LeaveCurSceneCsReq> for LeaveCurSceneCsReq {
    fn from(value: ::trigger_protocol::LeaveCurSceneCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<UpdateEventGraphScNotify> for ::trigger_protocol::UpdateEventGraphScNotify {
    fn from(value: UpdateEventGraphScNotify) -> Self {
        Self {
            owner_type: value.owner_type.into(),
            is_event_success: value.is_event_success.into(),
            tag: value.tag.into(),
            event_graph_owner_uid: value.event_graph_owner_uid.into(),
            npc_interaction: value.npc_interaction.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::UpdateEventGraphScNotify> for UpdateEventGraphScNotify {
    fn from(value: ::trigger_protocol::UpdateEventGraphScNotify) -> Self {
        Self {
            owner_type: value.owner_type.into(),
            is_event_success: value.is_event_success.into(),
            tag: value.tag.into(),
            event_graph_owner_uid: value.event_graph_owner_uid.into(),
            npc_interaction: value.npc_interaction.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<ShoppingMallInfo> for ::trigger_protocol::ShoppingMallInfo {
    fn from(value: ShoppingMallInfo) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::ShoppingMallInfo> for ShoppingMallInfo {
    fn from(value: ::trigger_protocol::ShoppingMallInfo) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetShoppingMallInfoCsReq> for ::trigger_protocol::GetShoppingMallInfoCsReq {
    fn from(value: GetShoppingMallInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetShoppingMallInfoCsReq> for GetShoppingMallInfoCsReq {
    fn from(value: ::trigger_protocol::GetShoppingMallInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<CafeData> for ::trigger_protocol::CafeData {
    fn from(value: CafeData) -> Self {
        Self {
            cur_cafe_item: value.cur_cafe_item.into(),
            cafe_item_list: value.cafe_item_list.into_iter().map(|v| v.into()).collect(),
            today_drink_times: value.today_drink_times.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::CafeData> for CafeData {
    fn from(value: ::trigger_protocol::CafeData) -> Self {
        Self {
            cur_cafe_item: value.cur_cafe_item.into(),
            cafe_item_list: value.cafe_item_list.into_iter().map(|v| v.into()).collect(),
            today_drink_times: value.today_drink_times.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetPlayerBasicInfoCsReq> for ::trigger_protocol::GetPlayerBasicInfoCsReq {
    fn from(value: GetPlayerBasicInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPlayerBasicInfoCsReq> for GetPlayerBasicInfoCsReq {
    fn from(value: ::trigger_protocol::GetPlayerBasicInfoCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<DrinkCafeCsReq> for ::trigger_protocol::DrinkCafeCsReq {
    fn from(value: DrinkCafeCsReq) -> Self {
        Self {
            cafe_item_id: value.cafe_item_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DrinkCafeCsReq> for DrinkCafeCsReq {
    fn from(value: ::trigger_protocol::DrinkCafeCsReq) -> Self {
        Self {
            cafe_item_id: value.cafe_item_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<SetMusicPlayerModeCsReq> for ::trigger_protocol::SetMusicPlayerModeCsReq {
    fn from(value: SetMusicPlayerModeCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::SetMusicPlayerModeCsReq> for SetMusicPlayerModeCsReq {
    fn from(value: ::trigger_protocol::SetMusicPlayerModeCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<Equip> for ::trigger_protocol::Equip {
    fn from(value: Equip) -> Self {
        Self {
            exp: value.exp.into(),
            star: value.star.into(),
            propertys: value.propertys.into_iter().map(|v| v.into()).collect(),
            uid: value.uid.into(),
            level: value.level.into(),
            id: value.id.into(),
            lock: value.lock.into(),
            sub_propertys: value.sub_propertys.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::Equip> for Equip {
    fn from(value: ::trigger_protocol::Equip) -> Self {
        Self {
            exp: value.exp.into(),
            star: value.star.into(),
            propertys: value.propertys.into_iter().map(|v| v.into()).collect(),
            uid: value.uid.into(),
            level: value.level.into(),
            id: value.id.into(),
            lock: value.lock.into(),
            sub_propertys: value.sub_propertys.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<TriggerInteractCsReq> for ::trigger_protocol::TriggerInteractCsReq {
    fn from(value: TriggerInteractCsReq) -> Self {
        Self {
            interact_id: value.interact_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::TriggerInteractCsReq> for TriggerInteractCsReq {
    fn from(value: ::trigger_protocol::TriggerInteractCsReq) -> Self {
        Self {
            interact_id: value.interact_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<JourneyData> for ::trigger_protocol::JourneyData {
    fn from(value: JourneyData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::JourneyData> for JourneyData {
    fn from(value: ::trigger_protocol::JourneyData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetFairyDataScRsp> for ::trigger_protocol::GetFairyDataScRsp {
    fn from(value: GetFairyDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            data: value.data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetFairyDataScRsp> for GetFairyDataScRsp {
    fn from(value: ::trigger_protocol::GetFairyDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            data: value.data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetActivityDataCsReq> for ::trigger_protocol::GetActivityDataCsReq {
    fn from(value: GetActivityDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetActivityDataCsReq> for GetActivityDataCsReq {
    fn from(value: ::trigger_protocol::GetActivityDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<RoleCardData> for ::trigger_protocol::RoleCardData {
    fn from(value: RoleCardData) -> Self {
        Self {
            signature: value.signature.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RoleCardData> for RoleCardData {
    fn from(value: ::trigger_protocol::RoleCardData) -> Self {
        Self {
            signature: value.signature.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetPlayerBasicInfoScRsp> for ::trigger_protocol::GetPlayerBasicInfoScRsp {
    fn from(value: GetPlayerBasicInfoScRsp) -> Self {
        Self {
            basic_info: value.basic_info.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPlayerBasicInfoScRsp> for GetPlayerBasicInfoScRsp {
    fn from(value: ::trigger_protocol::GetPlayerBasicInfoScRsp) -> Self {
        Self {
            basic_info: value.basic_info.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<RechargeGetItemListCsReq> for ::trigger_protocol::RechargeGetItemListCsReq {
    fn from(value: RechargeGetItemListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RechargeGetItemListCsReq> for RechargeGetItemListCsReq {
    fn from(value: ::trigger_protocol::RechargeGetItemListCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<AbyssGroup> for ::trigger_protocol::AbyssGroup {
    fn from(value: AbyssGroup) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AbyssGroup> for AbyssGroup {
    fn from(value: ::trigger_protocol::AbyssGroup) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<AbyssGetDataScRsp> for ::trigger_protocol::AbyssGetDataScRsp {
    fn from(value: AbyssGetDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            abyss_data: value.abyss_data.map(|v| v.into()),
            abyss_group_list: value
                .abyss_group_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            abyss_dungeon_list: value
                .abyss_dungeon_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AbyssGetDataScRsp> for AbyssGetDataScRsp {
    fn from(value: ::trigger_protocol::AbyssGetDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            abyss_data: value.abyss_data.map(|v| v.into()),
            abyss_group_list: value
                .abyss_group_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            abyss_dungeon_list: value
                .abyss_dungeon_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<QuestInfo> for ::trigger_protocol::QuestInfo {
    fn from(value: QuestInfo) -> Self {
        Self {
            id: value.id.into(),
            unlock_time: value.unlock_time.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::QuestInfo> for QuestInfo {
    fn from(value: ::trigger_protocol::QuestInfo) -> Self {
        Self {
            id: value.id.into(),
            unlock_time: value.unlock_time.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<SyncEventInfoScNotify> for ::trigger_protocol::SyncEventInfoScNotify {
    fn from(value: SyncEventInfoScNotify) -> Self {
        Self {
            tag: value.tag.into(),
            event_graph_uid: value.event_graph_uid.into(),
            owner_type: value.owner_type.into(),
            npc_interaction: value.npc_interaction.into(),
            owner_id: value.owner_id.into(),
            action_list: value.action_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::SyncEventInfoScNotify> for SyncEventInfoScNotify {
    fn from(value: ::trigger_protocol::SyncEventInfoScNotify) -> Self {
        Self {
            tag: value.tag.into(),
            event_graph_uid: value.event_graph_uid.into(),
            owner_type: value.owner_type.into(),
            npc_interaction: value.npc_interaction.into(),
            owner_id: value.owner_id.into(),
            action_list: value.action_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRewardBuffDataCsReq> for ::trigger_protocol::GetRewardBuffDataCsReq {
    fn from(value: GetRewardBuffDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRewardBuffDataCsReq> for GetRewardBuffDataCsReq {
    fn from(value: ::trigger_protocol::GetRewardBuffDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetPlayerDisplayDataCsReq> for ::trigger_protocol::GetPlayerDisplayDataCsReq {
    fn from(value: GetPlayerDisplayDataCsReq) -> Self {
        Self {
            tag: value.tag.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPlayerDisplayDataCsReq> for GetPlayerDisplayDataCsReq {
    fn from(value: ::trigger_protocol::GetPlayerDisplayDataCsReq) -> Self {
        Self {
            tag: value.tag.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRoleCardDataScRsp> for ::trigger_protocol::GetRoleCardDataScRsp {
    fn from(value: GetRoleCardDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            role_card_data: value.role_card_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRoleCardDataScRsp> for GetRoleCardDataScRsp {
    fn from(value: ::trigger_protocol::GetRoleCardDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            role_card_data: value.role_card_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<AbyssDungeon> for ::trigger_protocol::AbyssDungeon {
    fn from(value: AbyssDungeon) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AbyssDungeon> for AbyssDungeon {
    fn from(value: ::trigger_protocol::AbyssDungeon) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<StartHollowQuestCsReq> for ::trigger_protocol::StartHollowQuestCsReq {
    fn from(value: StartHollowQuestCsReq) -> Self {
        Self {
            is_story: value.is_story.into(),
            avatar_id_list: value.avatar_id_list.into_iter().map(|v| v.into()).collect(),
            quest_id: value.quest_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::StartHollowQuestCsReq> for StartHollowQuestCsReq {
    fn from(value: ::trigger_protocol::StartHollowQuestCsReq) -> Self {
        Self {
            is_story: value.is_story.into(),
            avatar_id_list: value.avatar_id_list.into_iter().map(|v| v.into()).collect(),
            quest_id: value.quest_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetRidusGotBooDataScRsp> for ::trigger_protocol::GetRidusGotBooDataScRsp {
    fn from(value: GetRidusGotBooDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetRidusGotBooDataScRsp> for GetRidusGotBooDataScRsp {
    fn from(value: ::trigger_protocol::GetRidusGotBooDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<FinishArchivePerformScRsp> for ::trigger_protocol::FinishArchivePerformScRsp {
    fn from(value: FinishArchivePerformScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            sub_id: value.sub_id.into(),
            quest_id: value.quest_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::FinishArchivePerformScRsp> for FinishArchivePerformScRsp {
    fn from(value: ::trigger_protocol::FinishArchivePerformScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            sub_id: value.sub_id.into(),
            quest_id: value.quest_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<SceneTransitionCsReq> for ::trigger_protocol::SceneTransitionCsReq {
    fn from(value: SceneTransitionCsReq) -> Self {
        Self {
            section_id: value.section_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::SceneTransitionCsReq> for SceneTransitionCsReq {
    fn from(value: ::trigger_protocol::SceneTransitionCsReq) -> Self {
        Self {
            section_id: value.section_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<CampIdleData> for ::trigger_protocol::CampIdleData {
    fn from(value: CampIdleData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::CampIdleData> for CampIdleData {
    fn from(value: ::trigger_protocol::CampIdleData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<EatRamenScRsp> for ::trigger_protocol::EatRamenScRsp {
    fn from(value: EatRamenScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::EatRamenScRsp> for EatRamenScRsp {
    fn from(value: ::trigger_protocol::EatRamenScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<Weapon> for ::trigger_protocol::Weapon {
    fn from(value: Weapon) -> Self {
        Self {
            lock: value.lock.into(),
            uid: value.uid.into(),
            refine_level: value.refine_level.into(),
            id: value.id.into(),
            exp: value.exp.into(),
            star: value.star.into(),
            level: value.level.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::Weapon> for Weapon {
    fn from(value: ::trigger_protocol::Weapon) -> Self {
        Self {
            lock: value.lock.into(),
            uid: value.uid.into(),
            refine_level: value.refine_level.into(),
            id: value.id.into(),
            exp: value.exp.into(),
            star: value.star.into(),
            level: value.level.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetExplorationDataCsReq> for ::trigger_protocol::GetExplorationDataCsReq {
    fn from(value: GetExplorationDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetExplorationDataCsReq> for GetExplorationDataCsReq {
    fn from(value: ::trigger_protocol::GetExplorationDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<StartHollowQuestScRsp> for ::trigger_protocol::StartHollowQuestScRsp {
    fn from(value: StartHollowQuestScRsp) -> Self {
        Self {
            quest_id: value.quest_id.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::StartHollowQuestScRsp> for StartHollowQuestScRsp {
    fn from(value: ::trigger_protocol::StartHollowQuestScRsp) -> Self {
        Self {
            quest_id: value.quest_id.into(),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<AbyssData> for ::trigger_protocol::AbyssData {
    fn from(value: AbyssData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AbyssData> for AbyssData {
    fn from(value: ::trigger_protocol::AbyssData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetAbyssRewardDataCsReq> for ::trigger_protocol::GetAbyssRewardDataCsReq {
    fn from(value: GetAbyssRewardDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetAbyssRewardDataCsReq> for GetAbyssRewardDataCsReq {
    fn from(value: ::trigger_protocol::GetAbyssRewardDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<DressedEquip> for ::trigger_protocol::DressedEquip {
    fn from(value: DressedEquip) -> Self {
        Self {
            equip_uid: value.equip_uid.into(),
            index: value.index.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::DressedEquip> for DressedEquip {
    fn from(value: ::trigger_protocol::DressedEquip) -> Self {
        Self {
            equip_uid: value.equip_uid.into(),
            index: value.index.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<FashionStoreData> for ::trigger_protocol::FashionStoreData {
    fn from(value: FashionStoreData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::FashionStoreData> for FashionStoreData {
    fn from(value: ::trigger_protocol::FashionStoreData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<RefreshSectionCsReq> for ::trigger_protocol::RefreshSectionCsReq {
    fn from(value: RefreshSectionCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::RefreshSectionCsReq> for RefreshSectionCsReq {
    fn from(value: ::trigger_protocol::RefreshSectionCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<PostGirlData> for ::trigger_protocol::PostGirlData {
    fn from(value: PostGirlData) -> Self {
        Self {
            post_girl_item_list: value
                .post_girl_item_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            selected_post_girl_id_list: value
                .selected_post_girl_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::PostGirlData> for PostGirlData {
    fn from(value: ::trigger_protocol::PostGirlData) -> Self {
        Self {
            post_girl_item_list: value
                .post_girl_item_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            selected_post_girl_id_list: value
                .selected_post_girl_id_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetNewsStandDataScRsp> for ::trigger_protocol::GetNewsStandDataScRsp {
    fn from(value: GetNewsStandDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            news_stand_data: value.news_stand_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetNewsStandDataScRsp> for GetNewsStandDataScRsp {
    fn from(value: ::trigger_protocol::GetNewsStandDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            news_stand_data: value.news_stand_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<WeaponUnDressCsReq> for ::trigger_protocol::WeaponUnDressCsReq {
    fn from(value: WeaponUnDressCsReq) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::WeaponUnDressCsReq> for WeaponUnDressCsReq {
    fn from(value: ::trigger_protocol::WeaponUnDressCsReq) -> Self {
        Self {
            avatar_id: value.avatar_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<VideotapeInfo> for ::trigger_protocol::VideotapeInfo {
    fn from(value: VideotapeInfo) -> Self {
        Self {
            finished: value.finished.into(),
            archive_file_id: value.archive_file_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::VideotapeInfo> for VideotapeInfo {
    fn from(value: ::trigger_protocol::VideotapeInfo) -> Self {
        Self {
            finished: value.finished.into(),
            archive_file_id: value.archive_file_id.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<FairyData> for ::trigger_protocol::FairyData {
    fn from(value: FairyData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::FairyData> for FairyData {
    fn from(value: ::trigger_protocol::FairyData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetEquipDataCsReq> for ::trigger_protocol::GetEquipDataCsReq {
    fn from(value: GetEquipDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetEquipDataCsReq> for GetEquipDataCsReq {
    fn from(value: ::trigger_protocol::GetEquipDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetMainCityRevivalDataCsReq>
for ::trigger_protocol::GetMainCityRevivalDataCsReq {
    fn from(value: GetMainCityRevivalDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetMainCityRevivalDataCsReq>
for GetMainCityRevivalDataCsReq {
    fn from(value: ::trigger_protocol::GetMainCityRevivalDataCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<InteractInfo> for ::trigger_protocol::InteractInfo {
    fn from(value: InteractInfo) -> Self {
        Self {
            participators: value
                .participators
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            interact_target_list: value
                .interact_target_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            name: value.name.into(),
            scale_y: value.scale_y.into(),
            scale_x: value.scale_x.into(),
            scale_w: value.scale_w.into(),
            scale_r: value.scale_r.into(),
            tag_id: value.tag_id.into(),
            scale_z: value.scale_z.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::InteractInfo> for InteractInfo {
    fn from(value: ::trigger_protocol::InteractInfo) -> Self {
        Self {
            participators: value
                .participators
                .into_iter()
                .map(|(k, v)| (k.into(), v.into()))
                .collect(),
            interact_target_list: value
                .interact_target_list
                .into_iter()
                .map(|v| v.into())
                .collect(),
            name: value.name.into(),
            scale_y: value.scale_y.into(),
            scale_x: value.scale_x.into(),
            scale_w: value.scale_w.into(),
            scale_r: value.scale_r.into(),
            tag_id: value.tag_id.into(),
            scale_z: value.scale_z.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<BeginArchiveBattleQuestCsReq>
for ::trigger_protocol::BeginArchiveBattleQuestCsReq {
    fn from(value: BeginArchiveBattleQuestCsReq) -> Self {
        Self {
            quest_id: value.quest_id.into(),
            buddy_id: value.buddy_id.into(),
            is_story: value.is_story.into(),
            avatar_id_list: value.avatar_id_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::BeginArchiveBattleQuestCsReq>
for BeginArchiveBattleQuestCsReq {
    fn from(value: ::trigger_protocol::BeginArchiveBattleQuestCsReq) -> Self {
        Self {
            quest_id: value.quest_id.into(),
            buddy_id: value.buddy_id.into(),
            is_story: value.is_story.into(),
            avatar_id_list: value.avatar_id_list.into_iter().map(|v| v.into()).collect(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<GetPlayerDisplayDataScRsp> for ::trigger_protocol::GetPlayerDisplayDataScRsp {
    fn from(value: GetPlayerDisplayDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            player_display_data: value.player_display_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetPlayerDisplayDataScRsp> for GetPlayerDisplayDataScRsp {
    fn from(value: ::trigger_protocol::GetPlayerDisplayDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            player_display_data: value.player_display_data.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<WorkbenchGetDataScRsp> for ::trigger_protocol::WorkbenchGetDataScRsp {
    fn from(value: WorkbenchGetDataScRsp) -> Self {
        Self {
            workbench_data: value.workbench_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::WorkbenchGetDataScRsp> for WorkbenchGetDataScRsp {
    fn from(value: ::trigger_protocol::WorkbenchGetDataScRsp) -> Self {
        Self {
            workbench_data: value.workbench_data.map(|v| v.into()),
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<AbyssRewardData> for ::trigger_protocol::AbyssRewardData {
    fn from(value: AbyssRewardData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::AbyssRewardData> for AbyssRewardData {
    fn from(value: ::trigger_protocol::AbyssRewardData) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<GetBuddyDataScRsp> for ::trigger_protocol::GetBuddyDataScRsp {
    fn from(value: GetBuddyDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::GetBuddyDataScRsp> for GetBuddyDataScRsp {
    fn from(value: ::trigger_protocol::GetBuddyDataScRsp) -> Self {
        Self {
            retcode: value.retcode.into(),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<HollowCheckPoint> for ::trigger_protocol::HollowCheckPoint {
    fn from(value: HollowCheckPoint) -> Self {
        Self {
            quest_cond_progress: value.quest_cond_progress.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::HollowCheckPoint> for HollowCheckPoint {
    fn from(value: ::trigger_protocol::HollowCheckPoint) -> Self {
        Self {
            quest_cond_progress: value.quest_cond_progress.map(|v| v.into()),
            ..Default::default()
        }
    }
}
#[allow(unused)]
impl From<HollowDataRefreshCsReq> for ::trigger_protocol::HollowDataRefreshCsReq {
    fn from(value: HollowDataRefreshCsReq) -> Self {
        Self { ..Default::default() }
    }
}
#[allow(unused)]
impl From<::trigger_protocol::HollowDataRefreshCsReq> for HollowDataRefreshCsReq {
    fn from(value: ::trigger_protocol::HollowDataRefreshCsReq) -> Self {
        Self { ..Default::default() }
    }
}
