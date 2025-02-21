use std::collections::HashMap;

use trigger_codegen::{ClientCmdID, Decodeable, Encodeable};
use trigger_encoding::Encodeable;
use util::ProtocolUnit;

pub mod util;

pub trait ClientCmdID {
    const CMD_ID: u16;

    fn get_client_cmd_id(&self) -> u16 {
        Self::CMD_ID
    }
}

impl<T> From<T> for ProtocolUnit
where
    T: ClientCmdID + Encodeable,
{
    fn from(value: T) -> Self {
        ProtocolUnit {
            cmd_id: value.get_client_cmd_id(),
            blob: value.encode_to_vec(),
        }
    }
}

// Player

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1)]
pub struct GetPlayerBasicInfoCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct PlayerBasicInfo {
    pub nick_name: String,
    pub level: u32,
    pub exp: u32,
    pub avatar_id: u32,
    pub player_avatar_id: u32,
    pub control_avatar_id: u32,
    pub last_enter_world_timestamp: i64,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2)]
pub struct GetPlayerBasicInfoScRsp {
    pub retcode: i32,
    pub basic_info: Option<PlayerBasicInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3)]
pub struct GetServerTimestampCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(4)]
pub struct GetServerTimestampScRsp {
    pub retcode: i32,
    pub timestamp: u64,
    pub utc_offset: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(5)]
pub struct GetPlayerTransactionCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(6)]
pub struct GetPlayerTransactionScRsp {
    pub retcode: i32,
    pub transaction: String,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(7)]
pub struct PlayerLogoutCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(8)]
pub struct PlayerLogoutScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(80)]
pub struct SwitchRoleCsReq {
    pub avatar_id: u32,
    pub player_avatar_id: u32,
    pub control_avatar_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(81)]
pub struct SwitchRoleScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(91)]
pub struct GetAuthkeyCsReq {
    pub auth_appid: String,
    pub authkey_ver: u32,
    pub sign_type: u32,
    pub offline_verify_value: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(92)]
pub struct GetAuthkeyScRsp {
    pub retcode: i32,
    pub auth_appid: String,
    pub authkey_ver: u32,
    pub authkey: String,
}

// Sync

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AvatarSync {
    pub avatar_list: Vec<Avatar>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct ItemSync {
    pub weapon_list: Vec<Weapon>,
    pub equip_list: Vec<Equip>,
    pub material_list: Vec<Material>,
    pub auto_recovery_info: HashMap<u32, AutoRecoveryInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct RamenSync {
    pub is_full_update: bool,
    pub cur_ramen: u32,
    pub eat_ramen_times: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct CafeSync {
    pub cafe_data: Option<CafeData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(100)]
pub struct PlayerSyncScNotify {
    pub basic_info: Option<PlayerBasicInfo>,
    pub avatar_sync: Option<AvatarSync>,
    pub item_sync: Option<ItemSync>,
    pub ramen_sync: Option<RamenSync>,
    pub cafe_sync: Option<CafeSync>,
}

// Mail

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(200)]
pub struct GetPlayerMailsCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(201)]
pub struct GetPlayerMailsScRsp {
    pub retcode: i32,
}

// Social

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(300)]
pub struct GetFriendListCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(301)]
pub struct GetFriendListScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(302)]
pub struct GetOnlineFriendsListCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(303)]
pub struct GetOnlineFriendsListScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(304)]
pub struct GetRoleCardDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct RoleCardData {
    pub signature: String,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(305)]
pub struct GetRoleCardDataScRsp {
    pub retcode: i32,
    pub role_card_data: Option<RoleCardData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(306)]
pub struct GetChatEmojiListCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(307)]
pub struct GetChatEmojiListScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(308)]
pub struct GetDisplayCaseDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(309)]
pub struct GetDisplayCaseDataScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(310)]
pub struct GetPlayerDisplayDataCsReq {
    pub tag: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct DisplayItemGroup {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AvatarDataPackage {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct PhotoWallNetworkData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct PlayerDisplayData {
    pub signature: String,
    pub display_item_group: Option<DisplayItemGroup>,
    pub avatar_data_package: Option<AvatarDataPackage>,
    pub photo_wall_network_data: Option<PhotoWallNetworkData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(311)]
pub struct GetPlayerDisplayDataScRsp {
    pub retcode: i32,
    pub player_display_data: Option<PlayerDisplayData>,
}

// Scene

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct Transform {
    pub position: Vec<f64>,
    pub rotation: Vec<f64>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct SceneInfo {
    pub scene_type: u32,
    pub event_id: u32,
    pub local_play_type: u32,
    pub hall_scene_info: Option<HallSceneInfo>,
    pub fight_scene_info: Option<FightSceneInfo>,
    pub rally_scene_info: Option<RallySceneInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct InteractInfo {
    pub name: String,
    pub tag_id: i32,
    pub scale_x: f64,
    pub scale_y: f64,
    pub scale_z: f64,
    pub scale_w: f64,
    pub scale_r: f64,
    pub interact_target_list: Vec<i32>,
    pub participators: HashMap<u32, String>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct SceneUnitProtocolInfo {
    pub npc_id: u32,
    pub is_interactable: bool,
    pub interacts_info: HashMap<u32, InteractInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct HallSceneInfo {
    pub section_id: u32,
    pub position: Option<Transform>,
    pub scene_unit_list: Vec<SceneUnitProtocolInfo>,
    pub time_of_day: u32,
    pub bgm_id: u32,
    pub day_of_week: u32,
    pub player_avatar_id: u32,
    pub control_avatar_id: u32,
    pub transform_id: String,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct LevelRewardInfo {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct LevelPerformInfo {
    pub time: String,
    pub weather: String,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct FightSceneInfo {
    pub perform_type: i32,
    pub end_hollow: bool,
    pub level_perform_info: Option<LevelPerformInfo>,
    pub level_reward_info: Option<LevelRewardInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct PublicVariable {
    pub r#type: u32,
    pub var_int: i64,
    pub var_number: f64,
    pub var_str: String,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct QuestCondProgress {
    pub public_variables: HashMap<String, PublicVariable>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct HollowCheckPoint {
    pub quest_cond_progress: Option<QuestCondProgress>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct RallySceneInfo {
    pub level_perform_info: Option<LevelPerformInfo>,
    pub level_reward_info: Option<LevelRewardInfo>,
    pub cur_check_point: Option<HollowCheckPoint>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct DungeonEquipInfo {
    pub avatar_list: Vec<Avatar>,
    pub weapon_list: Vec<Weapon>,
    pub equip_list: Vec<Equip>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AvatarUnitInfo {
    pub avatar_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct BuddyUnitInfo {
    pub buddy_id: u32,
    pub r#type: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct DungeonQuestInfo {
    pub inner_quest_id_list: Vec<u32>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct DungeonInfo {
    pub quest_id: u32,
    pub dungeon_equip_info: Option<DungeonEquipInfo>,
    pub dungeon_quest_info: Option<DungeonQuestInfo>,
    pub avatar_list: Vec<AvatarUnitInfo>,
    pub buddy_list: Vec<BuddyUnitInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(450)]
pub struct EnterWorldCsReq {
    pub is_reenter: bool,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(451)]
pub struct EnterWorldScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(452)]
pub struct EnterSceneScNotify {
    pub scene_info: Option<SceneInfo>,
    pub dungeon_info: Option<DungeonInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(453)]
pub struct PostEnterWorldCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(454)]
pub struct PostEnterWorldScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(455)]
pub struct SceneTransitionCsReq {
    pub section_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(456)]
pub struct SceneTransitionScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(457)]
pub struct EnterSectionCompleteCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(458)]
pub struct EnterSectionCompleteScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(459)]
pub struct SavePosInMainCityCsReq {
    pub section_id: u32,
    pub position: Option<Transform>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(460)]
pub struct SavePosInMainCityScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(461)]
pub struct InteractWithUnitCsReq {
    pub interact_id: i32,
    pub npc_tag_id: i32,
    pub r#type: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(462)]
pub struct InteractWithUnitScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct ActionInfo {
    pub action_type: i32,
    pub body: Vec<u8>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(463)]
pub struct SyncEventInfoScNotify {
    pub owner_id: u32,
    pub owner_type: i32,
    pub tag: u32,
    pub event_graph_uid: u32,
    pub npc_interaction: String,
    pub action_list: Vec<ActionInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(464)]
pub struct UpdateEventGraphScNotify {
    pub tag: u32,
    pub event_graph_owner_uid: u32,
    pub owner_type: i32,
    pub npc_interaction: String,
    pub is_event_success: bool,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(465)]
pub struct RunEventGraphCsReq {
    pub section_id: u32,
    pub event_graph_uid: u32,
    pub owner_id: u32,
    pub owner_type: i32,
    pub tag: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(466)]
pub struct RunEventGraphScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(467)]
pub struct RefreshSectionCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(468)]
pub struct RefreshSectionScRsp {
    pub retcode: i32,
    pub refresh_status: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(469)]
pub struct EnterSectionCsReq {
    pub section_id: u32,
    pub transform_id: String,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(470)]
pub struct EnterSectionScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(471)]
pub struct EndBattleCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct FightSettle {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(472)]
pub struct EndBattleScRsp {
    pub retcode: i32,
    pub fight_settle: Option<FightSettle>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(473)]
pub struct LeaveCurSceneCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(474)]
pub struct LeaveCurSceneScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(475)]
pub struct ActiveHollowCheckPointCsReq {
    pub check_point: Option<HollowCheckPoint>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(476)]
pub struct ActiveHollowCheckPointScRsp {
    pub retcode: i32,
}

// Quest

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct QuestInfo {
    pub id: u32,
    pub unlock_time: i64,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct QuestCollection {
    pub quest_type: u32,
    pub finished_quest_id_list: Vec<u32>,
    pub quest_list: Vec<QuestInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct QuestData {
    pub quest_collection_list: Vec<QuestCollection>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(550)]
pub struct GetQuestDataCsReq {
    pub quest_type: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(551)]
pub struct GetQuestDataScRsp {
    pub retcode: i32,
    pub quest_type: u32,
    pub quest_data: Option<QuestData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct VideotapeInfo {
    pub archive_file_id: u32,
    pub finished: bool,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct ArchiveData {
    pub hollow_archive_id_list: Vec<u32>,
    pub videotaps_info: Vec<VideotapeInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(571)]
pub struct GetArchiveDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(572)]
pub struct GetArchiveDataScRsp {
    pub retcode: i32,
    pub archive_data: Option<ArchiveData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct HollowStatistics {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct HollowInfo {
    pub hollow_quest_id: u32,
    pub hollow_statistics: Option<HollowStatistics>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct HollowData {
    pub unlock_hollow_group_list: Vec<u32>,
    pub hollow_group_list: Vec<u32>,
    pub unlock_hollow_id_list: Vec<u32>,
    pub unlock_hollow_quest_list: Vec<u32>,
    pub hollow_info_list: Vec<HollowInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(601)]
pub struct GetHollowDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(602)]
pub struct GetHollowDataScRsp {
    pub retcode: i32,
    pub hollow_data: Option<HollowData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(603)]
pub struct HollowDataRefreshCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(604)]
pub struct HollowDataRefreshScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(605)]
pub struct StartHollowQuestCsReq {
    pub is_story: bool,
    pub avatar_id_list: Vec<u32>,
    pub quest_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(606)]
pub struct StartHollowQuestScRsp {
    pub retcode: i32,
    pub quest_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(607)]
pub struct ClickHollowSystemCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(608)]
pub struct ClickHollowSystemScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(621)]
pub struct GetPrivateMessageDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct PrivateMessageData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(622)]
pub struct GetPrivateMessageDataScRsp {
    pub retcode: i32,
    pub private_message_data: Option<PrivateMessageData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(640)]
pub struct BeginTrainingCourseBattleCsReq {
    pub quest_id: u32,
    pub buddy_id: u32,
    pub avatar_id_list: Vec<u32>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(641)]
pub struct BeginTrainingCourseBattleScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(642)]
pub struct BeginArchiveBattleQuestCsReq {
    pub is_story: bool,
    pub quest_id: u32,
    pub buddy_id: u32,
    pub avatar_id_list: Vec<u32>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(643)]
pub struct BeginArchiveBattleQuestScRsp {
    pub retcode: i32,
    pub quest_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(644)]
pub struct FinishArchivePerformCsReq {
    pub quest_id: u32,
    pub sub_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(645)]
pub struct FinishArchivePerformScRsp {
    pub retcode: i32,
    pub quest_id: u32,
    pub sub_id: u32,
}

// Inventory

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct Weapon {
    pub id: u32,
    pub uid: u32,
    pub level: u32,
    pub exp: u32,
    pub star: u32,
    pub refine_level: u32,
    pub lock: bool,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(701)]
pub struct GetWeaponDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(702)]
pub struct GetWeaponDataScRsp {
    pub retcode: i32,
    pub weapon_list: Vec<Weapon>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct EquipProperty {
    pub key: u32,
    pub add_value: u32,
    pub base_value: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct Equip {
    pub id: u32,
    pub uid: u32,
    pub level: u32,
    pub exp: u32,
    pub star: u32,
    pub lock: bool,
    pub propertys: Vec<EquipProperty>,
    pub sub_propertys: Vec<EquipProperty>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(721)]
pub struct GetEquipDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(722)]
pub struct GetEquipDataScRsp {
    pub retcode: i32,
    pub equip_list: Vec<Equip>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(751)]
pub struct GetResourceDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct Material {
    pub id: u32,
    pub num: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AutoRecoveryInfo {
    pub buy_times: u32,
    pub last_recovery_timestamp: i64,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(752)]
pub struct GetResourceDataScRsp {
    pub retcode: i32,
    pub material_list: Vec<Material>,
    pub auto_recovery_info: HashMap<u32, AutoRecoveryInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(791)]
pub struct GetWishlistDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(792)]
pub struct GetWishlistDataScRsp {
    pub retcode: i32,
}

// Avatar

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AvatarSkillLevel {
    pub skill_type: u32,
    pub level: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct DressedEquip {
    pub equip_uid: u32,
    pub index: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct Avatar {
    pub id: u32,
    pub level: u32,
    pub exp: u32,
    pub rank: u32,
    pub passive_skill_level: u32,
    pub skill_type_level: Vec<AvatarSkillLevel>,
    pub unlocked_talent_num: u32,
    pub talent_switch_list: Vec<bool>,
    pub first_get_time: i64,
    pub cur_weapon_uid: u32,
    pub taken_rank_up_reward_list: Vec<u32>,
    pub dressed_equip_list: Vec<DressedEquip>,
    pub show_weapon_type: i32,
    pub avatar_skin_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(801)]
pub struct GetAvatarDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(802)]
pub struct GetAvatarDataScRsp {
    pub retcode: i32,
    pub avatar_list: Vec<Avatar>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(803)]
pub struct WeaponDressCsReq {
    pub avatar_id: u32,
    pub weapon_uid: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(804)]
pub struct WeaponDressScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(805)]
pub struct WeaponUnDressCsReq {
    pub avatar_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(806)]
pub struct WeaponUnDressScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(807)]
pub struct TalentSwitchCsReq {
    pub avatar_id: u32,
    pub talent_switch_list: Vec<bool>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(808)]
pub struct TalentSwitchScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(809)]
pub struct DressEquipmentCsReq {
    pub avatar_id: u32,
    pub equip_uid: u32,
    pub dress_index: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(810)]
pub struct DressEquipmentScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(811)]
pub struct UndressEquipmentCsReq {
    pub avatar_id: u32,
    pub undress_index_list: Vec<u32>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(812)]
pub struct UndressEquipmentScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct DressEquipmentParam {
    pub equip_uid: u32,
    pub dress_index: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(813)]
pub struct DressEquipmentSuitCsReq {
    pub avatar_id: u32,
    pub param_list: Vec<DressEquipmentParam>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(814)]
pub struct DressEquipmentSuitScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(840)]
pub struct GetAvatarRecommendEquipCsReq {
    pub avatar_id: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(841)]
pub struct GetAvatarRecommendEquipScRsp {
    pub retcode: i32,
}

// Bangboo

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(851)]
pub struct GetBuddyDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(852)]
pub struct GetBuddyDataScRsp {
    pub retcode: i32,
}

// Gacha

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1001)]
pub struct GetGachaDataCsReq {
    pub gacha_type: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1002)]
pub struct GetGachaDataScRsp {
    pub retcode: i32,
    pub gacha_type: u32,
}

// Ramen
#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1200)]
pub struct GetRamenDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct RamenData {
    pub unlock_ramen_list: Vec<u32>,
    pub cur_ramen: u32,
    pub eat_ramen_times: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1201)]
pub struct GetRamenDataScRsp {
    pub retcode: i32,
    pub ramen_data: Option<RamenData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1202)]
pub struct DelNewRamenCsReq {
    // unsure tbh
    pub has_mystical_spice: bool,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1203)]
pub struct DelNewRamenScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1204)]
pub struct EatRamenCsReq {
    pub ramen: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1205)]
pub struct EatRamenScRsp {
    pub retcode: i32,
}

// Client systems

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct UnlockData {
    pub unlocked_list: Vec<i32>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct PostGirlItem {
    pub id: u32,
    pub unlock_time: i64,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct PostGirlData {
    pub post_girl_item_list: Vec<PostGirlItem>,
    pub selected_post_girl_id_list: Vec<u32>,
    pub show_random_selected: bool,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct MusicPlayerItem {
    pub id: u32,
    pub unlock_time: i64,
    pub seen_time: i64,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct MusicPlayerData {
    pub music_list: Vec<MusicPlayerItem>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct ClientSystemsData {
    pub unlock_data: Option<UnlockData>,
    pub post_girl_data: Option<PostGirlData>,
    pub music_player_data: Option<MusicPlayerData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1301)]
pub struct VideoGetInfoCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1302)]
pub struct VideoGetInfoScRsp {
    pub retcode: i32,
    pub video_key_map: HashMap<u32, u64>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1303)]
pub struct SavePlayerSystemSettingCsReq {
    pub params: u32,
    pub r#type: u32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1304)]
pub struct SavePlayerSystemSettingScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1305)]
pub struct GetTipsInfoCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct TipsInfo {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1306)]
pub struct GetTipsInfoScRsp {
    pub retcode: i32,
    pub tips_info: Option<TipsInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1307)]
pub struct GetClientSystemsDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1308)]
pub struct GetClientSystemsDataScRsp {
    pub retcode: i32,
    pub data: Option<ClientSystemsData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1309)]
pub struct ReportUiLayoutPlatformCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1310)]
pub struct ReportUiLayoutPlatformScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1311)]
pub struct PlayerOperationCsReq {
    pub param: i32,
    pub data: Vec<u8>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1312)]
pub struct PlayerOperationScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1313)]
pub struct TriggerInteractCsReq {
    pub interact_id: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1314)]
pub struct TriggerInteractScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1315)]
pub struct BattleReportCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1316)]
pub struct BattleReportScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1317)]
pub struct PlaySongCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1318)]
pub struct PlaySongScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1319)]
pub struct SetMusicPlayerModeCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1320)]
pub struct SetMusicPlayerModeScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1321)]
pub struct GetNewsStandDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct NewsStandData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1322)]
pub struct GetNewsStandDataScRsp {
    pub retcode: i32,
    pub news_stand_data: Option<NewsStandData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1340)]
pub struct GetTrashbinHermitDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct TrashbinHermitData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1341)]
pub struct GetTrashbinHermitDataScRsp {
    pub retcode: i32,
    pub trashbin_hermit_data: Option<TrashbinHermitData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1370)]
pub struct GetExplorationDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1371)]
pub struct GetExplorationDataScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1380)]
pub struct GetJourneyDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct JourneyData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1381)]
pub struct GetJourneyDataScRsp {
    pub retcode: i32,
    pub journey_data: Option<JourneyData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1390)]
pub struct GetRedDotListCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1391)]
pub struct GetRedDotListScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1392)]
pub struct GameLogReportCsReq {
    pub stack_trace: Vec<String>,
    pub log_report_type: u32,
    pub value: String,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1393)]
pub struct GameLogReportScRsp {
    pub retcode: i32,
}

// DailyChallenge

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1450)]
pub struct GetDailyChallengeDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct DailyChallengeData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1451)]
pub struct GetDailyChallengeDataScRsp {
    pub retcode: i32,
    pub data: Option<DailyChallengeData>,
}

// Fairy

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1601)]
pub struct GetFairyDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct FairyData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1602)]
pub struct GetFairyDataScRsp {
    pub retcode: i32,
    pub data: Option<FairyData>,
}

// Activity

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1700)]
pub struct GetActivityDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1701)]
pub struct GetActivityDataScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1800)]
pub struct GetWebActivityDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1801)]
pub struct GetWebActivityDataScRsp {
    pub retcode: i32,
}

// Cafe

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1900)]
pub struct GetCafeDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct CafeData {
    pub cafe_item_list: Vec<i32>,
    pub cur_cafe_item: i32,
    pub today_drink_times: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1901)]
pub struct GetCafeDataScRsp {
    pub retcode: i32,
    pub cafe_data: Option<CafeData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1902)]
pub struct DrinkCafeCsReq {
    pub cafe_item_id: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1903)]
pub struct DrinkCafeScRsp {
    pub retcode: i32,
}

// LandRevive

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1970)]
pub struct GetMainCityRevivalDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct MainCityRevivalData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(1971)]
pub struct GetMainCityRevivalDataScRsp {
    pub retcode: i32,
    pub main_city_revival_data: Option<MainCityRevivalData>,
}

// Collections

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2001)]
pub struct GetCollectMapCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct CollectMap {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2002)]
pub struct GetCollectMapScRsp {
    pub retcode: i32,
    pub collect_map: Option<CollectMap>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2021)]
pub struct WorkbenchGetDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct WorkbenchData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2022)]
pub struct WorkbenchGetDataScRsp {
    pub retcode: i32,
    pub workbench_data: Option<WorkbenchData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2041)]
pub struct GetAbyssRewardDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AbyssRewardData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2042)]
pub struct GetAbyssRewardDataScRsp {
    pub retcode: i32,
    pub abyss_reward_data: Option<AbyssRewardData>,
}

// RewardBuff

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2201)]
pub struct GetRewardBuffDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct RewardBuffData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2202)]
pub struct GetRewardBuffDataScRsp {
    pub retcode: i32,
    pub data: Option<RewardBuffData>,
}

// Arcade

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2220)]
pub struct GetArcadeDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2221)]
pub struct GetArcadeDataScRsp {
    pub retcode: i32,
}

// Perform

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2400)]
pub struct PerformTriggerCsReq {
    pub perform_id: i32,
    pub perform_type: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2401)]
pub struct PerformTriggerScRsp {
    pub retcode: i32,
    pub perform_uid: i64,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2402)]
pub struct PerformJumpCsReq {
    pub perform_id: i32,
    pub perform_type: i32,
    pub perform_uid: i64,
    pub comic_index: i32,
    pub furthest_chapter: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2403)]
pub struct PerformJumpScRsp {
    pub retcode: i32,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2404)]
pub struct PerformEndCsReq {
    pub perform_id: i32,
    pub perform_type: i32,
    pub perform_uid: i64,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2405)]
pub struct PerformEndScRsp {
    pub retcode: i32,
}

// BattleEvent

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2450)]
pub struct GetBattleEventInfoCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct BattleEventInfo {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2451)]
pub struct GetBattleEventInfoScRsp {
    pub retcode: i32,
    pub event_info: Option<BattleEventInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2452)]
pub struct ReportBattleTeamCsReq {
    pub avatar_list: Vec<i32>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2453)]
pub struct ReportBattleTeamScRsp {
    pub retcode: i32,
}

// VhsStore

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2500)]
pub struct GetVhsStoreDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct VhsStoreData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2501)]
pub struct GetVhsStoreDataScRsp {
    pub retcode: i32,
    pub data: Option<VhsStoreData>,
}

// MonthCard

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2550)]
pub struct GetMonthCardRewardListCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2551)]
pub struct GetMonthCardRewardListScRsp {
    pub retcode: i32,
}

// BattlePass

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2800)]
pub struct GetBattlePassDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2801)]
pub struct GetBattlePassDataScRsp {
    pub retcode: i32,
}

// HadalZone

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2830)]
pub struct GetHadalZoneDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2831)]
pub struct GetHadalZoneDataScRsp {
    pub retcode: i32,
}

// Abyss

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AbyssData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AbyssGroup {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct AbyssDungeon {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2871)]
pub struct AbyssGetDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2872)]
pub struct AbyssGetDataScRsp {
    pub retcode: i32,
    pub abyss_data: Option<AbyssData>,
    pub abyss_group_list: Vec<AbyssGroup>,
    pub abyss_dungeon_list: Vec<AbyssDungeon>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2873)]
pub struct AbyssArpeggioGetDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(2874)]
pub struct AbyssArpeggioGetDataScRsp {
    pub retcode: i32,
}

// PhotoWall (3100-3129)

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3100)]
pub struct GetPhotoWallDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3101)]
pub struct GetPhotoWallDataScRsp {
    pub retcode: i32,
}

// CharacterQuest (?) maybe MainCityNPC

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3270)]
pub struct GetCharacterQuestListCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3271)]
pub struct GetCharacterQuestListScRsp {
    pub retcode: i32,
}

// Shop

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3400)]
pub struct GetFashionStoreDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct FashionStoreData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3401)]
pub struct GetFashionStoreDataScRsp {
    pub retcode: i32,
    pub data: Option<FashionStoreData>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3402)]
pub struct GetShoppingMallInfoCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct ShoppingMallInfo {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3403)]
pub struct GetShoppingMallInfoScRsp {
    pub retcode: i32,
    pub shopping_mall_info: Option<ShoppingMallInfo>,
}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3404)]
pub struct RechargeGetItemListCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3405)]
pub struct RechargeGetItemListScRsp {
    pub retcode: i32,
}

// BabelTower

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3500)]
pub struct GetBabelTowerDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3501)]
pub struct GetBabelTowerDataScRsp {
    pub retcode: i32,
}

// CampIdle

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3600)]
pub struct GetCampIdleDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable)]
pub struct CampIdleData {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3601)]
pub struct GetCampIdleDataScRsp {
    pub retcode: i32,
    pub camp_idle_data: Option<CampIdleData>,
}

// MiniscapeEntrust

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3650)]
pub struct GetMiniscapeEntrustDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3651)]
pub struct GetMiniscapeEntrustDataScRsp {
    pub retcode: i32,
}

// FishingContest

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3700)]
pub struct GetFishingContestDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3701)]
pub struct GetFishingContestDataScRsp {
    pub retcode: i32,
}

// RidusGotBoo (actually no, it has 2 events now, need to think of more generic name)

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3800)]
pub struct GetRidusGotBooDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3801)]
pub struct GetRidusGotBooDataScRsp {
    pub retcode: i32,
}

// QA Game

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3850)]
pub struct GetQuestionsAnswerGameDataCsReq {}

#[derive(Default, Debug, Clone, Encodeable, Decodeable, ClientCmdID)]
#[id(3851)]
pub struct GetQuestionsAnswerGameDataScRsp {
    pub retcode: i32,
}
