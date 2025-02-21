use std::collections::{HashMap, HashSet};

use trigger_database::{
    entity::{hollow_data, hollow_info},
    prelude::*,
};

use super::NapContext;

pub struct YorozuyaModel {
    context: NapContext,
    hollow_data: hollow_data::Model,
    hollow_map: HashMap<u32, hollow_info::Model>,
}

impl YorozuyaModel {
    pub async fn init(context: NapContext) -> Self {
        let hollow_data = Self::load_hollow_data(&context).await;
        let hollow_map = Self::load_hollows(&context).await;

        Self {
            context,
            hollow_data,
            hollow_map,
        }
    }

    pub async fn unlock_hollow(&mut self, hollow_list: &[i32]) {
        let mut hollow_group_list = std::mem::take(&mut self.hollow_data.unlock_hollow_group_list);
        let mut hollow_id_list = std::mem::take(&mut self.hollow_data.unlock_hollow_id_list);

        hollow_list.iter().for_each(|id| {
            if !hollow_id_list.contains(id) {
                hollow_id_list.push(*id);

                if let Some(hollow_template) = self
                    .context
                    .filecfg
                    .hollow_config_template_tb
                    .data()
                    .unwrap()
                    .iter()
                    .find(|tmpl| tmpl.id() == *id)
                {
                    if !hollow_group_list.contains(&hollow_template.hollow_group()) {
                        hollow_group_list.push(hollow_template.hollow_group());
                    }
                }
            }
        });

        self.hollow_data = hollow_data::ActiveModel {
            unlock_hollow_group_list: Set(hollow_group_list),
            unlock_hollow_id_list: Set(hollow_id_list),
            ..self.hollow_data.clone().into()
        }
        .update(self.context.database)
        .await
        .expect("hollow_data::update failed");
    }

    pub async fn add_hollow_quest(&mut self, hollow_quest_list: &[i32]) {
        let models = hollow_quest_list
            .iter()
            .filter(|id| !self.hollow_map.contains_key(&(**id as u32)))
            .collect::<HashSet<_>>()
            .into_iter()
            .map(|id| {
                self.context
                    .filecfg
                    .hollow_quest_template_tb
                    .data()
                    .unwrap()
                    .iter()
                    .find(|tmpl| tmpl.id() == *id)
            })
            .flatten()
            .map(|tmpl| hollow_info::Model {
                owner_player_uid: self.context.player_uid as i32,
                hollow_id: tmpl.id(),
            })
            .collect::<Vec<_>>();

        models.iter().for_each(|hollow| {
            self.hollow_map
                .insert(hollow.hollow_id as u32, hollow.clone());
        });

        hollow_info::Entity::insert_many(
            models
                .into_iter()
                .map(|hollow| hollow_info::ActiveModel {
                    owner_player_uid: Set(self.context.player_uid as i32),
                    hollow_id: Set(hollow.hollow_id),
                })
                .collect::<Vec<_>>(),
        )
        .exec(self.context.database)
        .await
        .expect("hollow_info::insert_many failed");
    }

    pub fn get_protocol_hollow_data(&self) -> trigger_protocol::HollowData {
        use trigger_protocol::*;

        HollowData {
            unlock_hollow_group_list: self
                .hollow_data
                .unlock_hollow_group_list
                .iter()
                .map(|&group| group as u32)
                .collect(),
            unlock_hollow_id_list: self
                .hollow_data
                .unlock_hollow_id_list
                .iter()
                .map(|&id| id as u32)
                .collect(),
            hollow_info_list: self
                .hollow_map
                .values()
                .map(|hollow| HollowInfo {
                    hollow_quest_id: hollow.hollow_id as u32,
                    hollow_statistics: Some(HollowStatistics::default()),
                })
                .collect(),
            ..Default::default()
        }
    }

    async fn load_hollow_data(context: &NapContext) -> hollow_data::Model {
        if let Some(data) = hollow_data::Entity::find_by_id(context.player_uid as i32)
            .one(context.database)
            .await
            .expect("hollow_data::find_by_id failed")
        {
            return data;
        }

        hollow_data::Entity::insert(hollow_data::ActiveModel {
            owner_player_uid: Set(context.player_uid as i32),
            unlock_hollow_group_list: Set(Vec::new()),
            unlock_hollow_id_list: Set(Vec::new()),
        })
        .exec_with_returning(context.database)
        .await
        .expect("hollow_data::insert failed")
    }

    async fn load_hollows(context: &NapContext) -> HashMap<u32, hollow_info::Model> {
        hollow_info::Entity::find()
            .filter(hollow_info::Column::OwnerPlayerUid.eq(context.player_uid as i32))
            .all(context.database)
            .await
            .expect("hollow_info::find failed")
            .into_iter()
            .map(|hollow| (hollow.hollow_id as u32, hollow))
            .collect()
    }
}
