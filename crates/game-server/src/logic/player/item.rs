use std::collections::HashMap;

use trigger_database::entity::{auto_recovery_data, material};
use trigger_database::prelude::*;
use trigger_logic::item::ItemStatic;

use super::NapContext;

pub struct ItemModel {
    context: NapContext,
    material_map: HashMap<u32, i32>,
    auto_recovery_map: HashMap<u32, auto_recovery_data::Model>,
}

pub struct MaterialDelta {
    pub id: u32,
    pub num: i32,
}

impl ItemModel {
    const MAX_ENERGY: i32 = 1000;
    const MAX_AUTO_RECOVERY_ENERGY: i32 = 240;

    const DEFAULT_MATERIALS: &[(ItemStatic, i32)] = &[
        (ItemStatic::FrontendGold, 10_000_000),
        (ItemStatic::GameDiamond, 10_000_000),
        (ItemStatic::Energy, Self::MAX_AUTO_RECOVERY_ENERGY),
    ];

    pub async fn init(context: NapContext) -> Self {
        let material_map = match Self::load_material_map(&context).await {
            map if map.len() == 0 => Self::create_default_material_map(&context).await,
            map => map,
        };

        let auto_recovery_map = Self::load_auto_recovery_map(&context).await;

        Self {
            context,
            material_map,
            auto_recovery_map,
        }
    }

    pub async fn add_energy(&mut self, amount: i32) {
        let cur_energy = self
            .material_map
            .get(&ItemStatic::Energy.into())
            .copied()
            .unwrap_or(0);

        let new_energy = std::cmp::min(cur_energy + amount, Self::MAX_ENERGY);

        self.add_or_use_materials(&[MaterialDelta {
            id: ItemStatic::Energy.into(),
            num: new_energy - cur_energy,
        }])
        .await;
    }

    pub fn has_enough_material(&self, id: u32, amount: i32) -> bool {
        self.material_map.get(&id).copied().unwrap_or(0) >= amount
    }

    pub fn has_enough_materials(&self, use_materials: &[MaterialDelta]) -> bool {
        use_materials.iter().fold(true, |is_enough, delta| {
            is_enough && self.has_enough_material(delta.id, -delta.num)
        })
    }

    pub async fn use_material(&mut self, id: u32, amount: i32) -> bool {
        self.add_or_use_materials(&[MaterialDelta { id, num: -amount }])
            .await
    }

    pub async fn add_or_use_materials(&mut self, use_materials: &[MaterialDelta]) -> bool {
        if !self.has_enough_materials(&use_materials) {
            return false;
        }

        let updated_models = use_materials
            .iter()
            .filter(|delta| delta.num != 0)
            .map(|delta| {
                let num = *self
                    .material_map
                    .entry(delta.id)
                    .and_modify(|num| *num += delta.num)
                    .or_insert(delta.num);

                material::ActiveModel {
                    owner_player_uid: Set(self.context.player_uid as i32),
                    id: Set(delta.id as i32),
                    num: Set(num),
                }
            })
            .collect::<Vec<_>>();

        self.context
            .database
            .transaction::<_, (), DbErr>(|txn| {
                Box::pin(async move {
                    for model in updated_models {
                        model.update(txn).await?;
                    }

                    Ok(())
                })
            })
            .await
            .expect("use_materials: update transaction failed");

        true
    }

    pub fn get_protocol_material_list(&self) -> Vec<trigger_protocol::Material> {
        self.material_map
            .iter()
            .map(|(&id, &num)| trigger_protocol::Material { id, num })
            .collect()
    }

    pub fn get_protocol_auto_recovery_info(
        &self,
    ) -> HashMap<u32, trigger_protocol::AutoRecoveryInfo> {
        self.auto_recovery_map
            .iter()
            .map(|(&id, data)| {
                (
                    id,
                    trigger_protocol::AutoRecoveryInfo {
                        last_recovery_timestamp: data.last_recovery_timestamp,
                        buy_times: data.buy_times as u32,
                    },
                )
            })
            .collect()
    }

    async fn load_material_map(context: &NapContext) -> HashMap<u32, i32> {
        material::Entity::find()
            .filter(material::Column::OwnerPlayerUid.eq(context.player_uid as i32))
            .all(context.database)
            .await
            .expect("material::find(all) failed")
            .into_iter()
            .map(|material| (material.id as u32, material.num))
            .collect()
    }

    async fn load_auto_recovery_map(
        context: &NapContext,
    ) -> HashMap<u32, auto_recovery_data::Model> {
        auto_recovery_data::Entity::find()
            .filter(auto_recovery_data::Column::OwnerPlayerUid.eq(context.player_uid as i32))
            .all(context.database)
            .await
            .expect("auto_recovery_data::find(all) failed")
            .into_iter()
            .map(|auto_recovery_data| (auto_recovery_data.id as u32, auto_recovery_data))
            .collect()
    }

    async fn create_default_material_map(context: &NapContext) -> HashMap<u32, i32> {
        let materials = Self::DEFAULT_MATERIALS
            .into_iter()
            .map(|(id, num)| {
                material::Model {
                    owner_player_uid: context.player_uid as i32,
                    id: (*id).into(),
                    num: *num,
                }
                .into()
            })
            .collect::<Vec<material::ActiveModel>>();

        material::Entity::insert_many(materials)
            .exec(context.database)
            .await
            .expect("material::insert_many(default) failed");

        Self::DEFAULT_MATERIALS
            .into_iter()
            .map(|(id, num)| ((*id).into(), *num))
            .collect()
    }
}
