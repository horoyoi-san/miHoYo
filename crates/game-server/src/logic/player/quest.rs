use std::collections::HashMap;

use trigger_database::{
    entity::{quest_collection, quest_info},
    prelude::*,
};
use trigger_logic::quest::EQuestType;
use trigger_sv::time_util;

use super::NapContext;

pub struct QuestModel {
    context: NapContext,
    quest_collections: HashMap<EQuestType, quest_collection::Model>,
    quest_map: HashMap<EQuestType, Vec<quest_info::Model>>,
}

impl QuestModel {
    pub async fn init(context: NapContext) -> Self {
        let quest_collections = Self::load_quest_collections(&context).await;
        let quest_map = Self::load_quests(&context).await;

        Self {
            context,
            quest_collections,
            quest_map,
        }
    }

    #[expect(dead_code)]
    pub async fn finish_quest(&mut self, quest_type: EQuestType, quest_id: i32) {
        self.finish_quests(quest_type, &[quest_id]).await
    }

    pub async fn add_quest(&mut self, quest_type: EQuestType, quest_id: i32) {
        if !self.quest_collections.contains_key(&quest_type) {
            self.quest_collections.insert(
                quest_type,
                quest_collection::ActiveModel {
                    owner_player_uid: Set(self.context.player_uid as i32),
                    quest_type: Set(quest_type.into()),
                    finished_quest_id_list: Set(Vec::new()),
                }
                .insert(self.context.database)
                .await
                .expect("quest_collection::insert failed"),
            );
        }

        if !self
            .quest_map
            .get(&quest_type)
            .map(|list| list.iter().any(|quest| quest.quest_id == quest_id))
            .unwrap_or(false)
        {
            self.quest_map.entry(quest_type).or_default().push(
                quest_info::ActiveModel {
                    owner_player_uid: Set(self.context.player_uid as i32),
                    quest_type: Set(quest_type.into()),
                    quest_id: Set(quest_id),
                    unlock_time: Set(time_util::cur_timestamp_seconds()),
                }
                .insert(self.context.database)
                .await
                .expect("quest_info::insert failed"),
            );
        }
    }

    pub async fn finish_quests(&mut self, quest_type: EQuestType, quest_id_list: &[i32]) {
        let (existed, mut collection) = self
            .quest_collections
            .remove(&quest_type)
            .map(|qc| (true, qc))
            .unwrap_or_else(|| {
                (
                    false,
                    quest_collection::Model {
                        owner_player_uid: self.context.player_uid as i32,
                        quest_type: quest_type.into(),
                        finished_quest_id_list: Vec::with_capacity(quest_id_list.len()),
                    },
                )
            });

        if let Some(list) = self.quest_map.get_mut(&quest_type) {
            list.retain(|q| !quest_id_list.contains(&q.quest_id));

            quest_info::Entity::delete_many()
                .filter(quest_info::Column::QuestId.is_not_in(quest_id_list.iter().copied()))
                .exec(self.context.database)
                .await
                .expect("quest_info::delete_many failed");
        }

        let mut finished_quest_id_list = std::mem::take(&mut collection.finished_quest_id_list);

        for quest_id in quest_id_list {
            if !finished_quest_id_list.contains(quest_id) {
                finished_quest_id_list.push(*quest_id);
            }
        }

        let model = quest_collection::ActiveModel {
            finished_quest_id_list: Set(finished_quest_id_list),
            ..collection.into()
        };

        if existed {
            self.quest_collections.insert(
                quest_type,
                model
                    .update(self.context.database)
                    .await
                    .expect("quest_collection::update failed"),
            );
        } else {
            self.quest_collections.insert(
                quest_type,
                model
                    .insert(self.context.database)
                    .await
                    .expect("quest_collection::insert failed"),
            );
        }
    }

    pub fn get_protocol_quest_data(&self, query_quest_type: u32) -> trigger_protocol::QuestData {
        use trigger_protocol::*;

        match EQuestType::try_from(query_quest_type as i32) {
            Ok(quest_type) => QuestData {
                quest_collection_list: vec![self.get_protocol_quest_collection(quest_type)],
            },
            _ => QuestData {
                quest_collection_list: {
                    let mut list = self
                        .quest_collections
                        .keys()
                        .map(|&ty| self.get_protocol_quest_collection(ty))
                        .collect::<Vec<_>>();

                    list.sort_by_key(|qc| qc.quest_type);
                    list
                },
            },
        }
    }

    fn get_protocol_quest_collection(&self, ty: EQuestType) -> trigger_protocol::QuestCollection {
        use trigger_protocol::*;

        self.quest_collections
            .get(&ty)
            .map(|qc| QuestCollection {
                quest_type: qc.quest_type as u32,
                finished_quest_id_list: qc
                    .finished_quest_id_list
                    .iter()
                    .map(|id| *id as u32)
                    .collect(),
                quest_list: self
                    .quest_map
                    .get(&ty)
                    .map(|list| {
                        list.iter()
                            .map(|quest| QuestInfo {
                                id: quest.quest_id as u32,
                                unlock_time: quest.unlock_time,
                            })
                            .collect()
                    })
                    .unwrap_or_default(),
            })
            .unwrap_or_default()
    }

    async fn load_quests(context: &NapContext) -> HashMap<EQuestType, Vec<quest_info::Model>> {
        let mut map: HashMap<EQuestType, Vec<quest_info::Model>> = HashMap::new();

        quest_info::Entity::find()
            .filter(quest_info::Column::OwnerPlayerUid.eq(context.player_uid as i32))
            .all(context.database)
            .await
            .expect("quest_info::find failed")
            .into_iter()
            .for_each(|quest| {
                map.entry(EQuestType::try_from(quest.quest_type).unwrap())
                    .or_default()
                    .push(quest);
            });

        map
    }

    async fn load_quest_collections(
        context: &NapContext,
    ) -> HashMap<EQuestType, quest_collection::Model> {
        quest_collection::Entity::find()
            .filter(quest_collection::Column::OwnerPlayerUid.eq(context.player_uid as i32))
            .all(context.database)
            .await
            .expect("quest_collection::find failed")
            .into_iter()
            .map(|qc| (qc.quest_type.try_into().expect("invalid quest_type"), qc))
            .collect()
    }
}
