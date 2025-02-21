use super::NapContext;
use trigger_database::{entity::cafe_data, prelude::*};
use trigger_fileconfig::CafeConfigTemplate;
use trigger_sv::time_util;

pub struct CafeModel {
    context: NapContext,
    cafe_data: cafe_data::Model,
}

impl CafeModel {
    pub async fn init(context: NapContext) -> Self {
        let cafe_data = Self::load_or_create_cafe_data(&context).await;

        Self { context, cafe_data }
    }

    pub async fn try_drink_cafe(
        &mut self,
        cafe_item_id: i32,
    ) -> Option<(i32, trigger_protocol::CafeSync)> {
        if !self.cafe_data.cafe_item_list.contains(&cafe_item_id) {
            return None;
        }

        let Some(config) = self.get_cafe_config(cafe_item_id) else {
            return None;
        };

        // TODO: time check and limits?

        let model = cafe_data::ActiveModel {
            cur_cafe_item: Set(cafe_item_id),
            last_drink_timestamp: Set(time_util::cur_timestamp_seconds()),
            ..self.cafe_data.clone().into()
        };

        self.cafe_data = model
            .update(self.context.database)
            .await
            .expect("cafe_data::update failed");

        Some((
            config.energy_amount(),
            trigger_protocol::CafeSync {
                cafe_data: Some(self.get_protocol_cafe_data()),
            },
        ))
    }

    pub async fn unlock_cafe_item(&mut self, cafe_item_id_list: &[i32]) {
        let mut cafe_item_list = std::mem::take(&mut self.cafe_data.cafe_item_list);

        cafe_item_id_list.iter().for_each(|id| {
            if !cafe_item_list.contains(id) {
                cafe_item_list.push(*id);
            }
        });

        let model = cafe_data::ActiveModel {
            cafe_item_list: Set(cafe_item_list),
            ..self.cafe_data.clone().into()
        };

        self.cafe_data = model
            .update(self.context.database)
            .await
            .expect("cafe_data::update failed");
    }

    pub fn get_cafe_item_price(&self, cafe_item_id: i32) -> i32 {
        self.get_cafe_config(cafe_item_id)
            .map(|tmpl| tmpl.price())
            .unwrap_or(0)
    }

    pub fn get_protocol_cafe_data(&self) -> trigger_protocol::CafeData {
        trigger_protocol::CafeData {
            cafe_item_list: self.cafe_data.cafe_item_list.clone(),
            cur_cafe_item: self.cafe_data.cur_cafe_item,
            today_drink_times: 0,
        }
    }

    async fn load_or_create_cafe_data(context: &NapContext) -> cafe_data::Model {
        let player_uid = context.player_uid as i32;

        match cafe_data::Entity::find_by_id(player_uid)
            .one(context.database)
            .await
            .expect("cafe_data::find_by_id failed")
        {
            Some(info) => info,
            None => Self::create_default_cafe_data(context)
                .insert(context.database)
                .await
                .expect("cafe_data::insert failed"),
        }
    }

    fn get_cafe_config(&self, cafe_item_id: i32) -> Option<CafeConfigTemplate<'static>> {
        self.context
            .filecfg
            .cafe_config_template_tb
            .data()
            .unwrap()
            .iter()
            .find(|tmpl| tmpl.id() == cafe_item_id)
    }

    fn create_default_cafe_data(context: &NapContext) -> cafe_data::ActiveModel {
        cafe_data::Model {
            player_uid: context.player_uid as i32,
            cafe_item_list: Vec::new(),
            cur_cafe_item: 0,
            last_drink_timestamp: 0,
        }
        .into()
    }
}
