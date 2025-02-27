mod authentication;
mod avatar;
mod battle;
mod chat;
mod gacha;
mod inventory;
mod lineup;
mod mail;
mod mission;
mod player;
mod scene;

use anyhow::Result;
use paste::paste;
use proto::*;

use super::PlayerSession;
use crate::net::NetPacket;

pub use authentication::*;
pub use avatar::*;
pub use battle::*;
pub use chat::*;
pub use gacha::*;
pub use inventory::*;
pub use lineup::*;
pub use mail::*;
pub use mission::*;
pub use player::*;
pub use scene::*;

#[allow(unused_imports)]
use proto::{
    CmdActivityType::*, CmdAdventureType::*, CmdAetherDivideType::*, CmdAlleyType::*,
    CmdArchiveType::*, CmdAvatarType::*, CmdBattleCollegeType::*, CmdBattlePassType::*,
    CmdBattleType::*, CmdBoxingClubType::*, CmdChallengeType::*, CmdChatType::*,
    CmdChessRogueType::*, CmdClockParkType::*, CmdContentPackageType::*, CmdDailyActiveType::*,
    CmdDrinkMakerType::*, CmdExpeditionType::*, CmdFantasticStoryActivityType::*,
    CmdFeverTimeActivityType::*, CmdFightActivityType::*, CmdFightMathc3Type::*, CmdFightType::*,
    CmdFriendType::*, CmdGachaType::*, CmdHeartdialType::*, CmdHeliobusType::*, CmdItemType::*,
    CmdJukeboxType::*, CmdLineupType::*, CmdLobbyType::*, CmdMailType::*, CmdMapRotationType::*,
    CmdMatchThreeModuleType::*, CmdMatchType::*, CmdMessageType::*, CmdMiscModuleType::*,
    CmdMissionType::*, CmdMonopolyType::*, CmdMultiplayerType::*, CmdMultipleDropType::*,
    CmdMuseumType::*, CmdOfferingType::*, CmdPamMissionType::*, CmdPhoneType::*,
    CmdPlayerBoardType::*, CmdPlayerReturnType::*, CmdPlayerSync::*, CmdPlayerType::*,
    CmdPlotType::*, CmdPunkLordType::*, CmdQuestType::*, CmdRaidCollectionType::*, CmdRaidType::*,
    CmdRechargeGiftType::*, CmdRecommendType::*, CmdRedDotType::*, CmdReplayType::*,
    CmdRndOptionType::*, CmdRogueCommonType::*, CmdRogueEndless::*, CmdRogueModifierType::*,
    CmdRogueTournType::*, CmdRogueType::*, CmdRollShopType::*, CmdSceneType::*,
    CmdServerPrefsType::*, CmdShopType::*, CmdSpaceZooType::*, CmdStarFightType::*,
    CmdStoryLineType::*, CmdStrongChallengeActivityType::*, CmdTalkRewardType::*,
    CmdTelevisionActivityType::*, CmdTextJoinType::*, CmdTrainVisitorType::*,
    CmdTreasureDungeonType::*, CmdTutorialType::*, CmdWaypointType::*, CmdWolfBroType::*,
};

macro_rules! dummy {
    ($($cmd:ident),* $(,)*) => {
        paste! {
            impl PlayerSession {
                pub const fn should_send_dummy_rsp(cmd_id: u16) -> bool {
                    match cmd_id {
                        $(
                            x if x == [<Cmd $cmd CsReq>] as u16 => true,
                        )*
                        _ => false,
                    }
                }

                pub async fn send_dummy_response(&mut self, req_id: u16) -> Result<()> {
                    let cmd_type = match req_id {
                        $(
                            x if x == [<Cmd $cmd CsReq>] as u16 => [<Cmd $cmd ScRsp>] as u16,
                        )*
                        _ => return Err(anyhow::anyhow!("Invalid request id {req_id:?}")),
                    };

                    self.send_raw(NetPacket {
                        cmd_type,
                        head: Vec::new(),
                        body: Vec::new(),
                    }).await?;

                    Ok(())
                }
            }
        }
    };
}

dummy! {
    // SceneEntityMove,
    GetLevelRewardTakenList,
    GetRogueScoreRewardInfo,
    // GetGachaInfo,
    QueryProductInfo,
    GetQuestData,
    GetQuestRecord,
    // GetFriendListInfo,
    // GetFriendApplyListInfo,
    GetCurAssist,
    GetRogueHandbookData,
    GetDailyActiveInfo,
    GetFightActivityData,
    GetMultipleDropInfo,
    GetPlayerReturnMultiDropInfo,
    GetShareData,
    GetTreasureDungeonActivityData,
    PlayerReturnInfoQuery,
    // GetBag,
    GetPlayerBoardData,
    GetActivityScheduleConfig,
    GetMissionData,
    GetChallenge,
    GetCurChallenge,
    GetRogueInfo,
    GetExpeditionData,
    // GetRogueDialogueEventData,
    GetJukeboxData,
    SyncClientResVersion,
    DailyFirstMeetPam,
    GetMuseumInfo,
    GetLoginActivity,
    GetRaidInfo,
    GetTrialActivityData,
    GetBoxingClubInfo,
    GetNpcStatus,
    TextJoinQuery,
    // GetSpringRecoverData, // Removed 2.7.51
    // GetChatFriendHistory,
    GetSecretKeyInfo,
    GetVideoVersionKey,
    GetCurBattleInfo,
    GetPhoneData,
    // PlayerLoginFinish,
    InteractProp,
    FinishTalkMission,
    GetRechargeGiftInfo
    // RelicRecommend
}
