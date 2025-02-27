use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_scene_info")]
pub struct Model {
    #[sea_orm(primary_key)]
    pub scene_uid: i64,
    pub owner_player_uid: i32,
    pub scene_type: i16,
    pub to_be_destroyed: bool,
    pub ext: String,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
