use trigger_database::{
    entity::{player_world_info, scene_info},
    prelude::*,
};
use trigger_logic::scene::ESceneType;

use super::NapContext;

pub struct SceneModel {
    context: NapContext,
    player_world_info: player_world_info::Model,
}

impl SceneModel {
    pub async fn init(context: NapContext) -> Self {
        let player_world_info = Self::load_or_create_player_world_info(&context).await;

        Self {
            context,
            player_world_info,
        }
    }

    pub async fn on_leave_scene(&mut self, scene_uid: i64) {
        if self
            .get_scene_by_uid(scene_uid)
            .await
            .map_or(false, |sc| sc.to_be_destroyed)
        {
            scene_info::Entity::delete_by_id(scene_uid)
                .exec(self.context.database)
                .await
                .expect("scene_info::delete_by_id failed");
        }
    }

    pub async fn clear_abandoned_scenes(&self) {
        use scene_info::Column;

        let world = &self.player_world_info;

        scene_info::Entity::delete_many()
            .filter(
                Condition::all()
                    .add(Column::ToBeDestroyed.eq(true))
                    .add(Column::OwnerPlayerUid.eq(self.context.player_uid as i32))
                    .add(Column::SceneUid.is_not_in([
                        world.current_scene_uid,
                        world.back_scene_uid,
                        world.default_scene_uid,
                    ])),
            )
            .exec(self.context.database)
            .await
            .expect("scene_info::delete_many failed");
    }

    pub async fn update_scene_ext(&mut self, scene_uid: i64, ext: String) {
        scene_info::ActiveModel {
            scene_uid: Set(scene_uid),
            ext: Set(ext),
            ..Default::default()
        }
        .update(self.context.database)
        .await
        .expect("scene_info::update failed");
    }

    pub async fn set_default_scene(&mut self, scene: &scene_info::Model) {
        let mut info: player_world_info::ActiveModel = self.player_world_info.clone().into();

        info.default_scene_uid = Set(scene.scene_uid);
        self.player_world_info = info
            .update(self.context.database)
            .await
            .expect("player_world_info::update failed");
    }

    pub async fn set_current_scene(&mut self, scene: &scene_info::Model) {
        let mut info: player_world_info::ActiveModel = self.player_world_info.clone().into();

        info.current_scene_uid = Set(scene.scene_uid);
        self.player_world_info = info
            .update(self.context.database)
            .await
            .expect("player_world_info::update failed");
    }

    pub async fn push_current_scene(&mut self, scene: &scene_info::Model) {
        let mut info: player_world_info::ActiveModel = self.player_world_info.clone().into();

        info.back_scene_uid = Set(self.player_world_info.current_scene_uid);
        info.current_scene_uid = Set(scene.scene_uid);

        self.player_world_info = info
            .update(self.context.database)
            .await
            .expect("player_world_info::update failed");
    }

    pub async fn create_scene_info(&mut self, scene_type: ESceneType) -> scene_info::Model {
        scene_info::Entity::insert(scene_info::ActiveModel {
            scene_uid: NotSet,
            owner_player_uid: Set(self.context.player_uid as i32),
            scene_type: Set(scene_type.into()),
            to_be_destroyed: Set(scene_type != ESceneType::Hall),
            ext: Set(String::with_capacity(0)),
        })
        .exec_with_returning(self.context.database)
        .await
        .expect("scene_basic_info::insert failed")
    }

    #[expect(dead_code)]
    pub async fn get_back_scene(&self) -> Option<scene_info::Model> {
        self.get_scene_by_uid(self.player_world_info.back_scene_uid)
            .await
    }

    pub async fn get_current_scene(&self) -> Option<scene_info::Model> {
        self.get_scene_by_uid(self.player_world_info.current_scene_uid)
            .await
    }

    pub async fn get_default_scene(&self) -> Option<scene_info::Model> {
        self.get_scene_by_uid(self.player_world_info.default_scene_uid)
            .await
    }

    pub async fn get_scene_by_uid(&self, scene_uid: i64) -> Option<scene_info::Model> {
        if scene_uid == 0 {
            return None;
        }

        scene_info::Entity::find_by_id(scene_uid)
            .one(self.context.database)
            .await
            .expect("scene_basic_info::find_by_id failed")
    }

    pub fn last_enter_world_timestamp(&self) -> i64 {
        self.player_world_info.last_enter_world_timestamp
    }

    async fn load_or_create_player_world_info(context: &NapContext) -> player_world_info::Model {
        let player_uid = context.player_uid as i32;

        match player_world_info::Entity::find_by_id(player_uid)
            .one(context.database)
            .await
            .expect("player_world_info::find_by_id failed")
        {
            Some(info) => info,
            None => Self::create_default_player_world_info(player_uid)
                .insert(context.database)
                .await
                .expect("player_world_info::insert failed"),
        }
    }

    fn create_default_player_world_info(player_uid: i32) -> player_world_info::ActiveModel {
        player_world_info::Model {
            player_uid,
            last_enter_world_timestamp: 0,
            default_scene_uid: 0,
            current_scene_uid: 0,
            back_scene_uid: 0,
        }
        .into()
    }
}
