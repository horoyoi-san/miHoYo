use super::NapContext;
use trigger_database::entity::ramen_data;
use trigger_database::prelude::*;

pub struct RamenModel {
    context: NapContext,
    ramen_data: ramen_data::Model,
}

impl RamenModel {
    pub async fn init(context: NapContext) -> Self {
        let ramen_data = Self::load_or_create_ramen_data(&context).await;

        Self {
            context,
            ramen_data,
        }
    }

    pub async fn try_eat_ramen(&mut self, ramen: i32) -> Option<trigger_protocol::RamenSync> {
        if !self.ramen_data.unlock_ramen_list.contains(&ramen) {
            return None;
        }

        let model = ramen_data::ActiveModel {
            cur_ramen: Set(ramen),
            eat_ramen_times: Set(self.ramen_data.eat_ramen_times + 1),
            ..self.ramen_data.clone().into()
        };

        self.ramen_data = model
            .update(self.context.database)
            .await
            .expect("ramen_data::update failed");

        Some(self.get_protocol_ramen_sync(false))
    }

    pub async fn unlock_ramen(&mut self, unlock_id_list: &[i32]) {
        let mut unlock_ramen_list = std::mem::take(&mut self.ramen_data.unlock_ramen_list);

        unlock_id_list.iter().for_each(|id| {
            if !unlock_ramen_list.contains(id) {
                unlock_ramen_list.push(*id);
            }
        });

        let model = ramen_data::ActiveModel {
            unlock_ramen_list: Set(unlock_ramen_list),
            ..self.ramen_data.clone().into()
        };

        self.ramen_data = model
            .update(self.context.database)
            .await
            .expect("ramen_data::update failed");
    }

    pub fn get_ramen_price(&self, ramen: i32) -> i32 {
        self.context
            .filecfg
            .hollow_buff_template_tb
            .data()
            .unwrap()
            .iter()
            .find(|tmpl| tmpl.id() == ramen)
            .map(|tmpl| tmpl.price())
            .unwrap_or(0)
    }

    pub fn get_protocol_ramen_data(&self) -> trigger_protocol::RamenData {
        trigger_protocol::RamenData {
            cur_ramen: self.ramen_data.cur_ramen as u32,
            eat_ramen_times: self.ramen_data.eat_ramen_times as u32,
            unlock_ramen_list: self
                .ramen_data
                .unlock_ramen_list
                .iter()
                .map(|&id| id as u32)
                .collect(),
        }
    }

    pub fn get_protocol_ramen_sync(&self, full_update: bool) -> trigger_protocol::RamenSync {
        trigger_protocol::RamenSync {
            is_full_update: full_update,
            cur_ramen: self.ramen_data.cur_ramen as u32,
            eat_ramen_times: self.ramen_data.eat_ramen_times as u32,
        }
    }

    async fn load_or_create_ramen_data(context: &NapContext) -> ramen_data::Model {
        let player_uid = context.player_uid as i32;

        match ramen_data::Entity::find_by_id(player_uid)
            .one(context.database)
            .await
            .expect("ramen_data::find_by_id failed")
        {
            Some(info) => info,
            None => Self::create_default_ramen_data(context)
                .insert(context.database)
                .await
                .expect("ramen_data::insert failed"),
        }
    }

    fn create_default_ramen_data(context: &NapContext) -> ramen_data::ActiveModel {
        ramen_data::Model {
            player_uid: context.player_uid as i32,
            unlock_ramen_list: Vec::new(),
            cur_ramen: 0,
            eat_ramen_times: 0,
        }
        .into()
    }
}
