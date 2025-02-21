use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_material_data")]
pub struct Model {
    #[sea_orm(primary_key)]
    pub owner_player_uid: i32,
    #[sea_orm(primary_key)]
    pub id: i32,
    pub num: i32,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
