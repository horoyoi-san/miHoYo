use cafe::CafeModel;
use equip::EquipModel;
use item::ItemModel;
use main_story::MainStoryModel;
use quest::QuestModel;
use ramen::RamenModel;
use role::RoleModel;
use scene::SceneModel;
use trigger_database::{entity::*, prelude::*, DatabaseConnection};
use trigger_fileconfig::NapFileCfg;
use trigger_logic::scene::ESceneType;
use trigger_protocol::PlayerBasicInfo;
use trigger_sv::message::GameStateData;
use yorozuya::YorozuyaModel;

mod cafe;
mod equip;
mod item;
mod main_story;
pub mod player_util;
mod quest;
mod ramen;
mod role;
mod scene;
mod yorozuya;

pub use role::AvatarPropertyChanges;

#[derive(Clone)]
pub struct NapContext {
    pub database: &'static DatabaseConnection,
    pub filecfg: &'static NapFileCfg<'static>,
    pub player_uid: u32,
}

pub struct NapPlayer {
    context: NapContext,
    player_basic_info: player_basic_info::Model,
    pub is_new_player: bool,
    pub active_session_id: Option<u64>,
    pub role_model: RoleModel,
    pub item_model: ItemModel,
    pub equip_model: EquipModel,
    pub scene_model: SceneModel,
    pub quest_model: QuestModel,
    pub yorozuya_model: YorozuyaModel,
    pub main_story_model: MainStoryModel,
    pub ramen_model: RamenModel,
    pub cafe_model: CafeModel,
}

impl NapPlayer {
    pub async fn load(
        player_uid: u32,
        create_if_not_exists: bool,
        database: &'static DatabaseConnection,
        filecfg: &'static NapFileCfg<'static>,
    ) -> Option<Self> {
        let context = NapContext {
            database,
            filecfg,
            player_uid,
        };

        let Some((player_basic_info, is_new_player)) =
            player_util::load_player_basic_info(database, player_uid, create_if_not_exists).await
        else {
            return None;
        };

        let role_model = RoleModel::init(context.clone()).await;
        let item_model = ItemModel::init(context.clone()).await;
        let equip_model = EquipModel::init(context.clone()).await;
        let scene_model = SceneModel::init(context.clone()).await;
        let quest_model = QuestModel::init(context.clone()).await;
        let yorozuya_model = YorozuyaModel::init(context.clone()).await;
        let main_story_model = MainStoryModel::init(context.clone()).await;
        let ramen_model = RamenModel::init(context.clone()).await;
        let cafe_model = CafeModel::init(context.clone()).await;

        Some(Self {
            active_session_id: None,
            context,
            player_basic_info,
            is_new_player,
            role_model,
            item_model,
            equip_model,
            scene_model,
            quest_model,
            yorozuya_model,
            main_story_model,
            ramen_model,
            cafe_model,
        })
    }

    pub fn build_state_reentrant_data(&self, scene: &scene_info::Model) -> Option<GameStateData> {
        match ESceneType::try_from(scene.scene_type).unwrap() {
            ESceneType::Hall => Some(GameStateData::Hall {
                player_avatar_id: self.player_basic_info.player_avatar_id as u32,
                control_avatar_id: self.player_basic_info.control_avatar_id as u32,
                ext: (!scene.ext.is_empty()).then(|| scene.ext.clone()),
            }),
            _ => None, // only hall reentrance is supported for now
        }
    }

    pub async fn set_control_avatars(&mut self, player_avatar_id: u32, control_avatar_id: u32) {
        let mut active_model: player_basic_info::ActiveModel =
            self.player_basic_info.clone().into();

        active_model.set(
            player_basic_info::Column::PlayerAvatarId,
            (player_avatar_id as i32).into(),
        );

        active_model.set(
            player_basic_info::Column::ControlAvatarId,
            (control_avatar_id as i32).into(),
        );

        self.player_basic_info = active_model
            .update(self.context.database)
            .await
            .expect("player_basic_info::update failed");
    }

    pub fn get_protocol_player_basic_info(&self) -> PlayerBasicInfo {
        PlayerBasicInfo {
            nick_name: self.player_basic_info.nick_name.clone(),
            level: self.player_basic_info.level as u32,
            exp: self.player_basic_info.exp as u32,
            avatar_id: self.player_basic_info.avatar_id as u32,
            player_avatar_id: self.player_basic_info.player_avatar_id as u32,
            control_avatar_id: self.player_basic_info.control_avatar_id as u32,
            last_enter_world_timestamp: self.scene_model.last_enter_world_timestamp(),
        }
    }

    pub fn player_uid(&self) -> u32 {
        self.context.player_uid
    }
}
