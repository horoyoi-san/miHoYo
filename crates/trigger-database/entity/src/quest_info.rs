use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_quest_info")]
pub struct Model {
    #[sea_orm(primary_key)]
    pub owner_player_uid: i32,
    #[sea_orm(primary_key)]
    pub quest_type: i32,
    #[sea_orm(primary_key)]
    pub quest_id: i32,
    pub unlock_time: i64,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
