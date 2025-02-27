use trigger_protocol::DungeonEquipInfo;

pub struct AvatarUnit {
    pub avatar_id: u32,
}

pub struct BuddyUnit {
    pub buddy_id: u32,
    pub buddy_type: i32,
}

pub struct Dungeon {
    pub quest_id: u32,
    pub avatar_list: Vec<AvatarUnit>,
    pub buddy_list: Vec<BuddyUnit>,
    pub inner_quests: Vec<u32>,
    pub equip: DungeonEquipInfo,
}

impl Dungeon {
    pub fn get_protocol_dungeon_info(&self) -> trigger_protocol::DungeonInfo {
        use trigger_protocol::*;

        DungeonInfo {
            quest_id: self.quest_id,
            dungeon_equip_info: Some(self.equip.clone()),
            avatar_list: self
                .avatar_list
                .iter()
                .map(|unit| AvatarUnitInfo {
                    avatar_id: unit.avatar_id,
                })
                .collect(),
            buddy_list: self
                .buddy_list
                .iter()
                .map(|unit| BuddyUnitInfo {
                    buddy_id: unit.buddy_id,
                    r#type: unit.buddy_type,
                })
                .collect(),
            dungeon_quest_info: Some(DungeonQuestInfo {
                inner_quest_id_list: self.inner_quests.clone(),
            }),
            ..Default::default()
        }
    }
}
