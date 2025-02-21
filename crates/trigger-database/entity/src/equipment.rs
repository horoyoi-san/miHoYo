use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_equipment_data")]
pub struct Model {
    #[sea_orm(primary_key)]
    pub owner_player_uid: i32,
    #[sea_orm(primary_key)]
    pub equip_uid: i32,
    pub equip_id: i32,
    pub level: i16,
    pub exp: i32,
    pub star: i16,
    pub lock: bool,
    pub properties: Vec<i64>,
    pub sub_properties: Vec<i64>,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
