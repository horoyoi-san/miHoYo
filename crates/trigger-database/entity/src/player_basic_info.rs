use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_player_basic_info")]
pub struct Model {
    #[sea_orm(primary_key, auto_increment = false)]
    pub player_uid: i32,
    pub nick_name: String,
    pub level: i32,
    pub exp: i32,
    pub avatar_id: i32,
    pub player_avatar_id: i32,
    pub control_avatar_id: i32,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
