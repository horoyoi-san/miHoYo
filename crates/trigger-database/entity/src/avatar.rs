use sea_orm::entity::prelude::*;

#[derive(Clone, Debug, PartialEq, Eq, DeriveEntityModel)]
#[sea_orm(table_name = "t_avatar_data")]
pub struct Model {
    #[sea_orm(primary_key)]
    pub owner_player_uid: i32,
    #[sea_orm(primary_key)]
    pub avatar_id: i32,
    pub level: i16,
    pub exp: i32,
    pub rank: i16,
    pub passive_skill_level: i16,
    pub skill_type_level: Vec<i16>,
    pub unlocked_talent_num: i16,
    pub talent_switch: i16,
    pub cur_weapon_uid: i32,
    pub equip_slot_list: Vec<i64>,
    pub taken_rank_up_reward_list: Vec<i32>,
    pub first_get_time: i64,
    pub show_weapon_type: i16,
    pub avatar_skin_id: i32,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {}

impl ActiveModelBehavior for ActiveModel {}
