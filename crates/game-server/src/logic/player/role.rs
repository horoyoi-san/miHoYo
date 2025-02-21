use std::collections::{HashMap, HashSet};

use trigger_database::entity::avatar;
use trigger_database::prelude::*;
use trigger_protocol::{Avatar, AvatarSkillLevel, DressedEquip};
use trigger_sv::time_util;

use crate::logic::{avatar_util, bit_util::BitSetExt};

use super::NapContext;

pub struct RoleModel {
    context: NapContext,
    avatar_map: HashMap<u32, avatar::Model>,
}

pub struct AvatarPropertyChanges {
    pub avatar_id: u32,
    pub level: Option<i16>,
    pub rank: Option<i16>,
    pub talent_num: Option<i16>,
}

impl RoleModel {
    pub async fn init(context: NapContext) -> Self {
        let avatar_map = Self::load_or_create_avatar_map(&context).await;

        Self {
            context,
            avatar_map,
        }
    }

    pub async fn weapon_dress(&mut self, avatar_id: u32, weapon_uid: i32) -> Option<[u32; 2]> {
        if !self.avatar_map.contains_key(&avatar_id) {
            return None;
        }

        let mut updated_avatars = [0xFFFFFFFF_u32; 2];

        let prev_avatar = if let Some(prev_avatar) = (weapon_uid != 0)
            .then(|| {
                self.avatar_map
                    .values_mut()
                    .find(|avatar| avatar.cur_weapon_uid == weapon_uid)
            })
            .flatten()
        {
            prev_avatar.cur_weapon_uid = 0;
            prev_avatar.avatar_id as u32
        } else {
            0
        };

        let avatar = self.avatar_map.remove(&avatar_id).unwrap();
        let prev_weapon = avatar.cur_weapon_uid;
        updated_avatars[0] = avatar.avatar_id as u32;

        self.avatar_map.insert(
            avatar.avatar_id as u32,
            avatar::ActiveModel {
                cur_weapon_uid: Set(weapon_uid),
                ..avatar.into()
            }
            .update(self.context.database)
            .await
            .expect("avatar::update failed"),
        );

        if prev_avatar != 0 && prev_weapon != 0 {
            if let Some(avatar) = self.avatar_map.remove(&prev_avatar) {
                updated_avatars[1] = avatar.avatar_id as u32;
                self.avatar_map.insert(
                    avatar.avatar_id as u32,
                    avatar::ActiveModel {
                        cur_weapon_uid: Set(prev_weapon),
                        ..avatar.into()
                    }
                    .update(self.context.database)
                    .await
                    .expect("avatar::update failed"),
                );
            }
        }

        Some(updated_avatars)
    }

    pub async fn dress_equipment(
        &mut self,
        avatar_id: u32,
        params: &[(u32, u32)],
    ) -> Option<Vec<u32>> {
        if !self.avatar_map.contains_key(&avatar_id) {
            return None;
        }

        let mut updated_avatars = HashSet::new();

        for &(equip_uid, _) in params.iter() {
            if let Some(avatar_id) = (equip_uid != 0)
                .then(|| {
                    self.avatar_map.values_mut().find(|avatar| {
                        avatar
                            .equip_slot_list
                            .iter()
                            .any(|slot| ((slot & 0xFFFFFFFF) as u32) == equip_uid)
                    })
                })
                .flatten()
                .map(|avatar| avatar.avatar_id)
            {
                if let Some(mut avatar) = self.avatar_map.remove(&(avatar_id as u32)) {
                    updated_avatars.insert(avatar_id as u32);
                    avatar
                        .equip_slot_list
                        .retain(|slot| ((slot & 0xFFFFFFFF) as u32) != equip_uid);

                    self.avatar_map.insert(
                        avatar_id as u32,
                        avatar::ActiveModel {
                            equip_slot_list: Set(avatar.equip_slot_list.clone()),
                            ..avatar.into()
                        }
                        .update(self.context.database)
                        .await
                        .expect("avatar::update failed"),
                    );
                }
            }
        }

        let mut avatar = self.avatar_map.remove(&avatar_id).unwrap();
        updated_avatars.insert(avatar.avatar_id as u32);

        for &(equip_uid, dress_index) in params.iter() {
            let slot = ((dress_index as i64) << 32) | (equip_uid as i64);
            if let Some(old_slot) = avatar
                .equip_slot_list
                .iter_mut()
                .find(|slot| ((**slot >> 32) as u32) == dress_index)
            {
                *old_slot = slot;
            } else {
                avatar.equip_slot_list.push(slot);
            }
        }

        self.avatar_map.insert(
            avatar.avatar_id as u32,
            avatar::ActiveModel {
                equip_slot_list: Set(avatar.equip_slot_list.clone()),
                ..avatar.into()
            }
            .update(self.context.database)
            .await
            .expect("avatar::update failed"),
        );

        Some(updated_avatars.into_iter().collect())
    }

    pub async fn undress_equipment(&mut self, avatar_id: u32, undress_indexes: &[u32]) -> bool {
        let Some(mut avatar) = self.avatar_map.remove(&avatar_id) else {
            return false;
        };

        avatar
            .equip_slot_list
            .retain(|slot| !undress_indexes.contains(&((*slot >> 32) as u32)));

        self.avatar_map.insert(
            avatar_id,
            avatar::ActiveModel {
                equip_slot_list: Set(avatar.equip_slot_list.clone()),
                ..avatar.into()
            }
            .update(self.context.database)
            .await
            .expect("avatar::update failed"),
        );

        true
    }

    pub async fn talent_switch(&mut self, avatar_id: u32, talent_switch: Vec<bool>) -> bool {
        if avatar_util::is_valid_talent_switch(&talent_switch) {
            let required_talent_num = talent_switch
                .iter()
                .enumerate()
                .filter(|(_, b)| **b)
                .max_by_key(|(i, _)| *i)
                .map(|(i, _)| (i + 1) as i16)
                .unwrap_or(0);

            if self
                .avatar_map
                .get(&avatar_id)
                .map(|avatar| avatar.unlocked_talent_num >= required_talent_num)
                .unwrap_or(false)
            {
                if let Some(avatar) = self.avatar_map.remove(&avatar_id) {
                    self.avatar_map.insert(
                        avatar.avatar_id as u32,
                        avatar::ActiveModel {
                            talent_switch: Set(BitSetExt::from_vec(talent_switch)),
                            ..avatar.into()
                        }
                        .update(self.context.database)
                        .await
                        .expect("avatar::update failed"),
                    );

                    return true;
                }
            }
        }

        false
    }

    pub async fn change_avatar_properties(
        &mut self,
        changes: AvatarPropertyChanges,
    ) -> Option<Vec<u32>> {
        if changes.avatar_id == 0 {
            // applies to all
            let (updated_models, updated_avatar_ids): (Vec<avatar::ActiveModel>, Vec<u32>) = self
                .avatar_map
                .iter_mut()
                .map(|(id, avatar)| {
                    let mut model = avatar::ActiveModel::from(avatar.clone());

                    changes.level.inspect(|&level| {
                        avatar.level = level;
                        model.level = Set(level);
                    });

                    changes.rank.inspect(|&rank| {
                        avatar.rank = rank;
                        model.rank = Set(rank);
                    });

                    changes.talent_num.inspect(|&num| {
                        avatar.unlocked_talent_num = num;
                        model.unlocked_talent_num = Set(num)
                    });

                    (model, *id)
                })
                .unzip();

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
                .expect("change_avatar_properties: update transaction failed");

            Some(updated_avatar_ids)
        } else {
            if let Some(avatar) = self.avatar_map.remove(&changes.avatar_id) {
                let model = avatar::ActiveModel {
                    level: changes.level.map(|level| Set(level)).unwrap_or_default(),
                    rank: changes.rank.map(|rank| Set(rank)).unwrap_or_default(),
                    unlocked_talent_num: changes.talent_num.map(|num| Set(num)).unwrap_or_default(),
                    ..avatar.into()
                };

                self.avatar_map.insert(
                    changes.avatar_id,
                    model
                        .update(self.context.database)
                        .await
                        .expect("avatar::update failed"),
                );

                Some(vec![changes.avatar_id])
            } else {
                None
            }
        }
    }

    pub fn is_avatar_unlocked(&self, avatar_id: u32) -> bool {
        self.avatar_map.contains_key(&avatar_id)
    }

    pub async fn unlock_avatars(&mut self, avatar_id_list: &[i32]) -> Vec<u32> {
        let models = avatar_id_list
            .iter()
            .filter(|id| !self.is_avatar_unlocked(**id as u32))
            .map(|id| {
                self.context
                    .filecfg
                    .avatar_base_template_tb
                    .data()
                    .unwrap()
                    .iter()
                    .find(|tmpl| tmpl.id() == *id)
            })
            .flatten()
            .map(|tmpl| avatar::Model {
                owner_player_uid: self.context.player_uid as i32,
                avatar_id: tmpl.id(),
                level: 60,
                exp: 0,
                rank: 6,
                passive_skill_level: 6,
                skill_type_level: (0..=6).map(|_| 12).collect(),
                unlocked_talent_num: 6,
                talent_switch: 0b111000,
                cur_weapon_uid: 0,
                taken_rank_up_reward_list: Vec::with_capacity(0),
                first_get_time: time_util::cur_timestamp_seconds(),
                show_weapon_type: 0,
                avatar_skin_id: 0,
                equip_slot_list: Vec::with_capacity(0),
            })
            .collect::<Vec<_>>();

        avatar::Entity::insert_many(
            models
                .iter()
                .map(|model| model.clone().into())
                .collect::<Vec<avatar::ActiveModel>>(),
        )
        .exec(self.context.database)
        .await
        .expect("avatar::insert_many failed");

        let mut added_avatars = Vec::with_capacity(models.len());
        for model in models {
            added_avatars.push(model.avatar_id as u32);
            self.avatar_map.insert(model.avatar_id as u32, model);
        }

        added_avatars
    }

    pub fn get_protocol_avatar_list(&self, filter: &[u32]) -> Vec<Avatar> {
        self.avatar_map
            .values()
            .filter(|avatar| filter.is_empty() || filter.contains(&(avatar.avatar_id as u32)))
            .map(|avatar| Avatar {
                id: avatar.avatar_id as u32,
                level: avatar.level as u32,
                exp: avatar.exp as u32,
                rank: avatar.rank as u32,
                passive_skill_level: avatar.passive_skill_level as u32,
                unlocked_talent_num: avatar.unlocked_talent_num as u32,
                cur_weapon_uid: avatar.cur_weapon_uid as u32,
                first_get_time: avatar.first_get_time,
                show_weapon_type: avatar.show_weapon_type as i32,
                avatar_skin_id: avatar.avatar_skin_id as u32,
                talent_switch_list: avatar.talent_switch.to_vec(6),
                taken_rank_up_reward_list: avatar
                    .taken_rank_up_reward_list
                    .iter()
                    .map(|&i| i as u32)
                    .collect(),
                dressed_equip_list: avatar
                    .equip_slot_list
                    .iter()
                    .map(|&slot| DressedEquip {
                        index: (slot >> 32) as u32,
                        equip_uid: (slot & 0xFFFFFFFF) as u32,
                    })
                    .collect(),
                skill_type_level: avatar
                    .skill_type_level
                    .iter()
                    .enumerate()
                    .map(|(st, level)| AvatarSkillLevel {
                        skill_type: st as u32,
                        level: *level as u32,
                    })
                    .collect(),
            })
            .collect()
    }

    async fn load_or_create_avatar_map(context: &NapContext) -> HashMap<u32, avatar::Model> {
        let player_uid = context.player_uid as i32;

        match avatar::Entity::find()
            .filter(avatar::Column::OwnerPlayerUid.eq(player_uid))
            .all(context.database)
            .await
            .expect("avatar::find(all) failed")
        {
            list if list.is_empty() => {
                let initial_map = Self::create_initial_avatar_map(context);

                avatar::Entity::insert_many(
                    initial_map
                        .values()
                        .cloned()
                        .map(avatar::ActiveModel::from)
                        .collect::<Vec<_>>(),
                )
                .exec(context.database)
                .await
                .expect("avatar::insert_many(initial_list) failed");

                initial_map
            }
            list => list
                .into_iter()
                .map(|avatar| (avatar.avatar_id as u32, avatar))
                .collect(),
        }
    }

    fn create_initial_avatar_map(context: &NapContext) -> HashMap<u32, avatar::Model> {
        HashMap::from([(
            1011,
            avatar::Model {
                owner_player_uid: context.player_uid as i32,
                avatar_id: 1011,
                level: 60,
                exp: 0,
                rank: 6,
                passive_skill_level: 6,
                skill_type_level: (0..=6).map(|_| 12).collect(),
                unlocked_talent_num: 6,
                talent_switch: 0b111000,
                cur_weapon_uid: 0,
                taken_rank_up_reward_list: Vec::with_capacity(0),
                first_get_time: time_util::cur_timestamp_seconds(),
                show_weapon_type: 0,
                avatar_skin_id: 0,
                equip_slot_list: Vec::with_capacity(0),
            },
        )])
    }
}
