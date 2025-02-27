use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_player_world_info")]
pub struct Model {
    #[sea_orm(primary_key, auto_increment = false)]
    pub player_uid: i32,
    pub last_enter_world_timestamp: i64,
    pub default_scene_uid: i64,
    pub current_scene_uid: i64,
    pub back_scene_uid: i64,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
