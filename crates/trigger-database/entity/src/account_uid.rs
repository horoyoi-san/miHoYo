use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_account_uid")]
pub struct Model {
    #[sea_orm(primary_key)]
    pub player_uid: i32,
    #[sea_orm(unique)]
    pub account_uid: String,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
