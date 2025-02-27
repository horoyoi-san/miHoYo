use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_cafe_data")]
pub struct Model {
    #[sea_orm(primary_key, auto_increment = false)]
    pub player_uid: i32,
    pub cafe_item_list: Vec<i32>,
    pub cur_cafe_item: i32,
    pub last_drink_timestamp: i64,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
