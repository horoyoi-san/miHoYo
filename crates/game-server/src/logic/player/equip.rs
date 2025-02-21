use std::collections::HashMap;

use trigger_database::{
    entity::{equipment, player_item_uid, weapon},
    prelude::*,
};

use crate::logic::equip_util;

use super::NapContext;

pub struct EquipModel {
    context: NapContext,
    weapons: HashMap<i32, weapon::Model>,
    equipment: HashMap<i32, equipment::Model>,
}

impl EquipModel {
    pub async fn init(context: NapContext) -> Self {
        let weapons = Self::load_weapon_map(&context).await;
        let equipment = Self::load_equipment(&context).await;

        Self {
            context,
            weapons,
            equipment,
        }
    }

    pub fn weapon_exists(&self, uid: i32) -> bool {
        self.weapons.contains_key(&uid)
    }

    pub fn equipment_exists(&self, uid: i32) -> bool {
        self.equipment.contains_key(&uid)
    }

    pub fn get_protocol_weapon_list(&self, filter: &[i32]) -> Vec<trigger_protocol::Weapon> {
        self.weapons
            .values()
            .filter(|weapon| filter.is_empty() || filter.contains(&weapon.weapon_uid))
            .map(|weapon| trigger_protocol::Weapon {
                id: weapon.weapon_id as u32,
                uid: weapon.weapon_uid as u32,
                level: weapon.level as u32,
                exp: weapon.exp as u32,
                star: weapon.star as u32,
                refine_level: weapon.refine_level as u32,
                lock: weapon.lock,
            })
            .collect()
    }

    pub fn get_protocol_equip_list(&self, filter: &[i32]) -> Vec<trigger_protocol::Equip> {
        use trigger_protocol::*;

        self.equipment
            .values()
            .filter(|equip| filter.is_empty() || filter.contains(&equip.equip_uid))
            .map(|equip| Equip {
                id: equip.equip_id as u32,
                uid: equip.equip_uid as u32,
                level: equip.level as u32,
                exp: equip.exp as u32,
                star: equip.star as u32,
                lock: equip.lock,
                propertys: equip
                    .properties
                    .iter()
                    .map(|&prop| EquipProperty {
                        key: (prop >> 32) as u32,
                        add_value: ((prop >> 16) & 0xFFFF) as u32,
                        base_value: (prop & 0xFFFF) as u32,
                    })
                    .collect(),
                sub_propertys: equip
                    .sub_properties
                    .iter()
                    .map(|&prop| EquipProperty {
                        key: (prop >> 32) as u32,
                        add_value: ((prop >> 16) & 0xFFFF) as u32,
                        base_value: (prop & 0xFFFF) as u32,
                    })
                    .collect(),
            })
            .collect()
    }

    pub async fn add_custom_equip(
        &mut self,
        equip_id: i32,
        level: i16,
        star: i16,
        property_params: &[i32],
    ) -> i32 {
        let equip_uid = Self::next_item_uid(&self.context).await;
        let mut params = property_params.into_iter();

        let mut properties = Vec::new();
        let mut sub_properties = Vec::new();

        if let (Some(&key), Some(&add_value), Some(&base_value)) =
            (params.next(), params.next(), params.next())
        {
            properties
                .push(((key as i64) << 32) | ((add_value as i64) << 16) | (base_value as i64));
        }

        while let (Some(&key), Some(&add_value), Some(&base_value)) =
            (params.next(), params.next(), params.next())
        {
            sub_properties
                .push(((key as i64) << 32) | ((add_value as i64) << 16) | (base_value as i64));
        }

        let model = equipment::Model {
            owner_player_uid: self.context.player_uid as i32,
            equip_id,
            equip_uid,
            level,
            exp: 0,
            star,
            lock: false,
            properties,
            sub_properties,
        };

        self.equipment.insert(
            equip_uid,
            equipment::ActiveModel::from(model)
                .insert(self.context.database)
                .await
                .expect("equipment::insert failed"),
        );

        equip_uid
    }

    pub async fn add_equip(&mut self, equip_id_list: &[i32]) -> Vec<i32> {
        let equipment_template_tb = self.context.filecfg.equipment_template_tb.data().unwrap();
        let uids = Self::next_item_uids(&self.context, equip_id_list.len() as u32).await;

        let (uids, models): (Vec<_>, Vec<_>) = equip_id_list
            .iter()
            .map(|id| {
                equipment_template_tb
                    .iter()
                    .find(|tmpl| tmpl.item_id() == *id)
            })
            .flatten()
            .zip(uids)
            .map(|(tmpl, item_uid)| {
                (
                    item_uid,
                    equipment::Model {
                        owner_player_uid: self.context.player_uid as i32,
                        equip_id: tmpl.item_id(),
                        equip_uid: item_uid,
                        level: 1,
                        exp: 0,
                        star: 1,
                        lock: false,
                        properties: vec![equip_util::random_main_property(tmpl.equipment_type())],
                        sub_properties: Vec::new(),
                    },
                )
            })
            .unzip();

        equipment::Entity::insert_many(models.iter().cloned().map(equipment::ActiveModel::from))
            .exec(self.context.database)
            .await
            .expect("equipment::insert_many failed");

        models.into_iter().for_each(|model| {
            self.equipment.insert(model.equip_uid, model);
        });

        uids
    }

    pub async fn add_weapon(&mut self, weapon_id_list: &[i32]) -> Vec<i32> {
        let weapon_template_tb = self.context.filecfg.weapon_template_tb.data().unwrap();
        let uids = Self::next_item_uids(&self.context, weapon_id_list.len() as u32).await;

        let (uids, models): (Vec<_>, Vec<_>) = weapon_id_list
            .iter()
            .map(|id| weapon_template_tb.iter().find(|tmpl| tmpl.item_id() == *id))
            .flatten()
            .zip(uids)
            .map(|(tmpl, item_uid)| {
                (
                    item_uid,
                    weapon::Model {
                        owner_player_uid: self.context.player_uid as i32,
                        weapon_uid: item_uid,
                        weapon_id: tmpl.item_id(),
                        level: 60,
                        exp: 0,
                        star: 1 + tmpl.star_limit() as i16,
                        refine_level: tmpl.refine_limit() as i16,
                        lock: false,
                    },
                )
            })
            .unzip();

        weapon::Entity::insert_many(models.iter().cloned().map(weapon::ActiveModel::from))
            .exec(self.context.database)
            .await
            .expect("equipment::insert_many failed");

        models.into_iter().for_each(|model| {
            self.weapons.insert(model.weapon_uid, model);
        });

        uids
    }

    async fn load_equipment(context: &NapContext) -> HashMap<i32, equipment::Model> {
        equipment::Entity::find()
            .filter(equipment::Column::OwnerPlayerUid.eq(context.player_uid as i32))
            .all(context.database)
            .await
            .expect("equipment::find(all) failed")
            .into_iter()
            .map(|equip| (equip.equip_uid, equip))
            .collect()
    }

    async fn load_weapon_map(context: &NapContext) -> HashMap<i32, weapon::Model> {
        weapon::Entity::find()
            .filter(weapon::Column::OwnerPlayerUid.eq(context.player_uid as i32))
            .all(context.database)
            .await
            .expect("weapon::find(all) failed")
            .into_iter()
            .map(|weapon| (weapon.weapon_uid, weapon))
            .collect()
    }

    async fn next_item_uid(context: &NapContext) -> i32 {
        Self::next_item_uids(context, 1).await.nth(0).unwrap()
    }

    async fn next_item_uids(context: &NapContext, count: u32) -> impl Iterator<Item = i32> {
        let count = count as i32;
        match player_item_uid::Entity::find_by_id(context.player_uid as i32)
            .one(context.database)
            .await
            .expect("player_item_uid::find_by_id failed")
        {
            Some(model) => {
                let last_item_uid = model.last_item_uid;
                player_item_uid::ActiveModel {
                    last_item_uid: Set(last_item_uid + count),
                    ..model.into()
                }
                .update(context.database)
                .await
                .expect("player_item_uid::update failed");

                last_item_uid + 1..=last_item_uid + count
            }
            None => {
                player_item_uid::ActiveModel {
                    player_uid: Set(context.player_uid as i32),
                    last_item_uid: Set(count),
                }
                .insert(context.database)
                .await
                .expect("player_item_uid::insert failed");

                1..=count
            }
        }
    }
}
