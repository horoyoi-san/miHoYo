use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_ramen_data")]
pub struct Model {
    #[sea_orm(primary_key, auto_increment = false)]
    pub player_uid: i32,
    pub unlock_ramen_list: Vec<i32>,
    pub cur_ramen: i32,
    pub eat_ramen_times: i32,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
