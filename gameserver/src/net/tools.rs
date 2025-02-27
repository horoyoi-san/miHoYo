use proto::*;
use serde::{Deserialize, Serialize};
use std::collections::{BTreeMap, HashMap};

// AVATAR
#[derive(Serialize, Deserialize, Debug, Clone)]
pub struct AvatarJson {
    #[serde(alias = "ownerUid")]
    pub owner_uid: u32,
    #[serde(alias = "avatarId")]
    pub avatar_id: u32,
    pub data: AvatarData,
    pub level: u32,
    pub promotion: u32,
    #[serde(alias = "use_technique")]
    #[serde(alias = "useTechnique")]
    pub techniques: Vec<u32>,
    #[serde(alias = "spValue")]
    pub sp_value: Option<u32>,
    #[serde(alias = "spMax")]
    pub sp_max: Option<u32>,
}

#[derive(Serialize, Deserialize, Debug, Clone)]
pub struct AvatarData {
    pub rank: u32,
    pub skills: HashMap<u32, u32>,
}

impl AvatarJson {
    pub fn to_avatar_proto(&self, lightcone: Option<&Lightcone>, relics: Vec<&Relic>) -> Avatar {
        // TODO: HARDCODED
        let base_avatar_id = if self.avatar_id > 8000 {
            8001
        } else if self.avatar_id == 1001 || self.avatar_id == 1224 {
            1001
        } else {
            self.avatar_id
        };

        Avatar {
            base_avatar_id,
            level: self.level,
            promotion: self.promotion,
            rank: self.data.rank,
            skilltree_list: self
                .data
                .skills
                .iter()
                .map(|v| AvatarSkillTree {
                    point_id: *v.0,
                    level: *v.1,
                })
                .collect::<Vec<_>>(),
            equipment_unique_id: if let Some(lc) = lightcone {
                // TODO: HARDCODED LIGHTCONE ID
                2000 + lc.internal_uid
            } else {
                0
            },
            first_met_timestamp: 1712924677,
            equip_relic_list: relics
                .iter()
                .map(|v| v.to_equipment_relic_proto())
                .collect::<Vec<_>>(),
            ..Default::default()
        }
    }

    pub fn to_battle_avatar_proto(
        &self,
        index: u32,
        lightcone: Option<&Lightcone>,
        relics: Vec<&Relic>,
    ) -> (BattleAvatar, Vec<BattleBuff>) {
        let battle_avatar = BattleAvatar {
            index,
            avatar_type: AvatarType::AvatarUpgradeAvailableType.into(),
            id: self.avatar_id,
            level: self.level,
            rank: self.data.rank,
            skilltree_list: self
                .data
                .skills
                .iter()
                .map(|v| AvatarSkillTree {
                    point_id: *v.0,
                    level: *v.1,
                })
                .collect::<Vec<_>>(),
            equipment_list: if let Some(lc) = lightcone {
                vec![lc.to_battle_equipment_proto()]
            } else {
                vec![]
            },
            hp: 10_000,
            promotion: self.promotion,
            relic_list: relics
                .iter()
                .map(|v| v.to_battle_relic_proto())
                .collect::<Vec<_>>(),
            world_level: 6,
            sp_bar: Some(SpBarInfo {
                cur_sp: self.sp_value.unwrap_or(10_000),
                max_sp: self.sp_max.unwrap_or(10_000),
            }),
            ..Default::default()
        };

        let mut battle_buff = Vec::<BattleBuff>::new();
        for buff_id in &self.techniques {
            battle_buff.push(BattleBuff {
                wave_flag: 0xffffffff,
                owner_id: index,
                level: 1,
                id: *buff_id,
                dynamic_values: HashMap::from([(String::from("SkillIndex"), 2.0)]),
                ..Default::default()
            });
        }

        (battle_avatar, battle_buff)
    }

    pub fn to_lineup_avatar_proto(&self, slot: u32) -> LineupAvatar {
        LineupAvatar {
            id: self.avatar_id,
            hp: 10_000,
            satiety: 100,
            avatar_type: AvatarType::AvatarFormalType.into(),
            sp_bar: Some(SpBarInfo {
                cur_sp: self.sp_value.unwrap_or(10_000),
                max_sp: self.sp_max.unwrap_or(10_000),
            }),
            slot,
        }
    }

    pub fn to_lineup_avatars(player: &FreesrData) -> Vec<LineupAvatar> {
        let avatar_ids = player
            .avatars
            .values()
            .map(|v| &v.avatar_id)
            .collect::<Vec<_>>();

        player
            .lineups
            .iter()
            .filter(|(slot, v)| **slot < 4 && v > &&0 && avatar_ids.contains(v))
            .map(|(slot, avatar_id)| {
                player
                    .avatars
                    .get(avatar_id)
                    .unwrap()
                    .to_lineup_avatar_proto(*slot)
            })
            .collect::<Vec<LineupAvatar>>()
    }

    pub fn to_lineup_info(lineups: &BTreeMap<u32, u32>) -> LineupInfo {
        let mut lineup_info = LineupInfo {
            extra_lineup_type: ExtraLineupType::LineupNone.into(),
            name: "Squad 1".to_string(),
            mp: 5,
            max_mp: 5,
            ..Default::default()
        };

        for id in lineups.values() {
            if *id == 0 {
                continue;
            }
            lineup_info.avatar_list.push(LineupAvatar {
                id: *id,
                hp: 10_000,
                satiety: 100,
                avatar_type: AvatarType::AvatarFormalType.into(),
                sp_bar: Some(SpBarInfo {
                    cur_sp: 10_000,
                    max_sp: 10_000,
                }),
                slot: lineup_info.avatar_list.len() as u32,
            });
        }

        lineup_info
    }
}

// LIGHTCONE
#[derive(Serialize, Deserialize, Debug, Clone)]
pub struct Lightcone {
    pub level: u32,
    #[serde(alias = "itemId")]
    pub item_id: u32,
    #[serde(alias = "equipAvatar")]
    pub equip_avatar: u32,
    pub rank: u32,
    pub promotion: u32,
    #[serde(alias = "internalUid")]
    pub internal_uid: u32,
}

impl Lightcone {
    pub fn to_equipment_proto(&self) -> Equipment {
        Equipment {
            equip_avatar_id: self.equip_avatar,
            exp: 0,
            is_protected: false,
            level: self.level,
            promotion: self.promotion,
            rank: self.rank,
            tid: self.item_id,
            // ?
            unique_id: 2000 + self.internal_uid,
        }
    }

    pub fn to_battle_equipment_proto(&self) -> BattleEquipment {
        BattleEquipment {
            id: self.item_id,
            level: self.level,
            promotion: self.promotion,
            rank: self.rank,
        }
    }
}

// RELIC
#[derive(Debug, Serialize, Deserialize, Clone)]
pub struct Relic {
    pub level: u32,
    #[serde(alias = "relicId")]
    pub relic_id: u32,
    #[serde(alias = "relicSetId")]
    pub relic_set_id: u32,
    #[serde(alias = "mainAffixId")]
    pub main_affix_id: u32,
    #[serde(alias = "subAffixes")]
    pub sub_affixes: Vec<SubAffix>,
    #[serde(alias = "internalUid")]
    pub internal_uid: u32,
    #[serde(alias = "equipAvatar")]
    pub equip_avatar: u32,
}

#[derive(Debug, Serialize, Deserialize, Default, Clone)]
pub struct SubAffix {
    #[serde(alias = "subAffixId")]
    pub sub_affix_id: u32,
    pub count: u32,
    pub step: u32,
}

impl Relic {
    pub fn to_relic_proto(&self) -> proto::Relic {
        proto::Relic {
            equip_avatar_id: self.equip_avatar,
            exp: 0,
            is_protected: false,
            level: self.level,
            main_affix_id: self.main_affix_id,
            tid: self.relic_id,
            // ?
            unique_id: 1 + self.internal_uid,
            sub_affix_list: self
                .sub_affixes
                .iter()
                .map(|v| RelicAffix {
                    affix_id: v.sub_affix_id,
                    cnt: v.count,
                    step: v.step,
                })
                .collect::<Vec<_>>(),
            ..Default::default()
        }
    }

    pub fn to_battle_relic_proto(&self) -> BattleRelic {
        BattleRelic {
            id: self.relic_id,
            level: self.level,
            main_affix_id: self.main_affix_id,
            unique_id: self.internal_uid,
            sub_affix_list: self
                .sub_affixes
                .iter()
                .map(|v| RelicAffix {
                    affix_id: v.sub_affix_id,
                    cnt: v.count,
                    step: v.step,
                })
                .collect::<Vec<_>>(),
            ..Default::default()
        }
    }

    pub fn to_equipment_relic_proto(&self) -> EquipRelic {
        EquipRelic {
            slot: self.relic_id % 10,
            // ?
            relic_unique_id: 1 + self.internal_uid,
        }
    }
}

// MONSTER
#[derive(Debug, Serialize, Deserialize, Clone, Default)]
pub struct Monster {
    pub level: u32,
    #[serde(alias = "monsterId")]
    pub monster_id: u32,
    #[serde(default)]
    pub max_hp: u32,
}

impl Monster {
    fn to_scene_monster_info(&self) -> SceneMonster {
        SceneMonster {
            monster_id: self.monster_id,
            max_hp: self.max_hp,
            cur_hp: self.max_hp,
        }
    }

    pub fn to_scene_monster_wave(wave_index: u32, monsters: &[Self]) -> SceneMonsterWave {
        let mut wave_index = wave_index;
        if wave_index < 1 {
            wave_index += 1;
        }

        SceneMonsterWave {
            wave_id: wave_index, // wave indexx??

            wave_param: Some(SceneMonsterWaveParam {
                // monster param
                level: monsters.iter().map(|v| v.level).max().unwrap_or(95),
                ..Default::default()
            }),

            monster_list: monsters
                .iter()
                .map(|v| v.to_scene_monster_info())
                .collect::<Vec<_>>(),
            ..Default::default()
        }
    }

    pub fn to_scene_monster_waves(monsters: &[Vec<Self>]) -> Vec<SceneMonsterWave> {
        monsters
            .iter()
            .enumerate()
            .map(|(i, v)| Self::to_scene_monster_wave(i as u32, v))
            .collect::<_>()
    }
}

// BATTLE CONFIG
#[derive(Debug, Serialize, Deserialize, Clone)]
pub struct BattleConfig {
    pub battle_type: BattleType,
    pub monsters: Vec<Vec<Monster>>,
    pub blessings: Vec<BattleBuffJson>,
    pub stage_id: u32,
    pub cycle_count: u32,
    pub path_resonance_id: u32,
    pub custom_stats: Vec<SubAffix>,
    #[serde(default)]
    pub scepters: Vec<RogueMagicScepter>,
}

impl Default for BattleConfig {
    fn default() -> Self {
        Self {
            battle_type: Default::default(),
            monsters: vec![vec![Monster {
                level: 60,
                monster_id: 3014022,
                max_hp: 0,
            }]],
            stage_id: 201012311,
            blessings: Default::default(),
            cycle_count: Default::default(),
            path_resonance_id: Default::default(),
            custom_stats: Default::default(),
            scepters: Default::default(),
        }
    }
}

#[derive(Debug, Serialize, Deserialize, Clone, PartialEq)]
pub enum BattleType {
    #[serde(alias = "DEFAULT")]
    Default = 0,
    #[serde(alias = "MOC")]
    Moc = 1,
    PF = 2,
    SU = 3,
    AS = 4,
}

impl Default for BattleType {
    fn default() -> Self {
        Self::Default
    }
}

// BATTLE BUFFS
#[derive(Debug, Serialize, Deserialize, Clone, Default)]
pub struct BattleBuffJson {
    pub level: u32,
    pub id: u32,
    pub dynamic_key: Option<DynamicKey>,
    #[serde(default)]
    pub dynamic_values: Vec<DynamicKey>,
}

#[derive(Debug, Serialize, Deserialize, Clone, Default)]
pub struct DynamicKey {
    pub key: String,
    pub value: u32,
}

#[allow(dead_code)]
impl BattleBuffJson {
    pub fn to_battle_buff_proto(&self) -> proto::BattleBuff {
        proto::BattleBuff {
            id: self.id,
            level: self.level,
            wave_flag: 0xffffffff,
            owner_id: 0xffffffff,
            dynamic_values: if let Some(dyn_key) = &self.dynamic_key {
                HashMap::from([(dyn_key.key.clone(), dyn_key.value as f32)])
            } else {
                Default::default()
            },
            ..Default::default()
        }
    }
}

#[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, Default)]
#[repr(u32)]
pub enum RogueMagicComponentType {
    Passive = 3,
    #[default]
    Active = 4,
    Attach = 5,
}

#[derive(Debug, Serialize, Deserialize, Clone, Default)]
pub struct RogueMagicScepter {
    pub level: u32,
    pub id: u32,
    pub components: Vec<RogueMagicComponent>,
}

#[derive(Debug, Serialize, Deserialize, Clone, Default)]
pub struct RogueMagicComponent {
    pub id: u32,
    pub level: u32,
    pub component_type: RogueMagicComponentType,
}

// SCENE
#[derive(Serialize, Deserialize, Debug, Clone)]
pub struct Scene {
    pub plane_id: u32,
    pub floor_id: u32,
    pub entry_id: u32,
}

impl Default for Scene {
    fn default() -> Self {
        Self {
            entry_id: 2032101,
            plane_id: 20321,
            floor_id: 20321001,
        }
    }
}

// Position
#[derive(Debug, Serialize, Deserialize, Clone, Default)]
pub struct Position {
    pub x: i32,
    pub y: i32,
    pub z: i32,
    pub rot_y: i32,
}

impl Position {
    #[allow(unused)]
    pub fn is_empty(&self) -> bool {
        self.x == 0 && self.y == 0 && self.z == 0
    }

    pub fn to_motion(&self) -> MotionInfo {
        MotionInfo {
            rot: Some(Vector {
                x: 0,
                y: self.rot_y,
                z: 0,
            }),
            pos: Some(Vector {
                x: self.x,
                y: self.y,
                z: self.z,
            }),
        }
    }
}

// FREESR-DATA.json
#[derive(Debug, Serialize, Deserialize)]
pub struct FreesrData {
    pub lightcones: Vec<Lightcone>,
    pub relics: Vec<Relic>,
    pub avatars: HashMap<u32, AvatarJson>,
    #[serde(default)]
    pub battle_config: BattleConfig,

    #[serde(default, skip_serializing)]
    pub lineups: BTreeMap<u32, u32>,
    #[serde(default, skip_serializing)]
    pub position: Position,
    #[serde(default, skip_serializing)]
    pub scene: Scene,

    #[serde(skip_serializing, skip_deserializing)]
    pub main_character: MultiPathAvatar,
    #[serde(skip_serializing, skip_deserializing)]
    pub march_type: MultiPathAvatar,
}

#[derive(Debug, Serialize, Deserialize)]
pub struct Persistent {
    #[serde(default)]
    pub lineups: BTreeMap<u32, u32>,
    #[serde(default)]
    pub position: Position,
    #[serde(default)]
    pub scene: Scene,
    pub main_character: MultiPathAvatar,
    pub march_type: MultiPathAvatar,
}

impl Default for Persistent {
    fn default() -> Self {
        let mut lineups = BTreeMap::<u32, u32>::new();
        lineups.insert(0, 8001);
        lineups.insert(1, 0);
        lineups.insert(2, 0);
        lineups.insert(3, 0);

        Self {
            lineups,
            position: Default::default(),
            main_character: MultiPathAvatar::FemaleRememberance,
            scene: Default::default(),
            march_type: MultiPathAvatar::MarchHunt,
        }
    }
}

#[derive(Serialize, Deserialize, Clone, Debug, Copy, PartialEq, Eq, Default)]
#[repr(u32)]
pub enum MultiPathAvatar {
    MalePyhsical = 8001,
    FemalePhysical = 8002,
    MalePreservation = 8003,
    FemalePreservation = 8004,
    MaleHarmony = 8005,
    FemaleHarmony = 8006,
    MaleRememberance = 8007,
    FemaleRememberance = 8008,
    MarchHunt = 1224,
    MarchPreservation = 1001,
    #[default]
    Unk = 0,
}

impl From<u32> for MultiPathAvatar {
    fn from(value: u32) -> Self {
        match value {
            8001 => Self::MalePyhsical,
            8002 => Self::FemalePhysical,
            8003 => Self::MalePreservation,
            8004 => Self::FemalePreservation,
            8005 => Self::MaleHarmony,
            8006 => Self::FemaleHarmony,
            8007 => Self::MaleRememberance,
            8008 => Self::FemaleRememberance,
            1224 => Self::MarchHunt,
            1001 => Self::MarchPreservation,
            _ => Self::Unk,
        }
    }
}

impl From<MultiPathAvatar> for u32 {
    fn from(value: MultiPathAvatar) -> Self {
        match value {
            MultiPathAvatar::MalePyhsical => 8001,
            MultiPathAvatar::FemalePhysical => 8002,
            MultiPathAvatar::MalePreservation => 8003,
            MultiPathAvatar::FemalePreservation => 8004,
            MultiPathAvatar::MaleHarmony => 8005,
            MultiPathAvatar::FemaleHarmony => 8006,
            MultiPathAvatar::MaleRememberance => 8007,
            MultiPathAvatar::FemaleRememberance => 8008,
            MultiPathAvatar::MarchHunt => 1224,
            MultiPathAvatar::MarchPreservation => 1001,
            _ => 8006,
        }
    }
}

impl MultiPathAvatar {
    #[allow(unused)]
    pub fn get_gender(&self) -> Gender {
        if (*self as u32) < 8000 {
            Gender::None
        } else if *self as u32 % 2 == 1 {
            Gender::Man
        } else {
            Gender::Woman
        }
    }

    pub fn get_type(&self) -> MultiPathAvatarType {
        match *self {
            MultiPathAvatar::MalePyhsical => MultiPathAvatarType::BoyWarriorType,
            MultiPathAvatar::FemalePhysical => MultiPathAvatarType::GirlWarriorType,
            MultiPathAvatar::MalePreservation => MultiPathAvatarType::BoyKnightType,
            MultiPathAvatar::FemalePreservation => MultiPathAvatarType::GirlKnightType,
            MultiPathAvatar::MaleHarmony => MultiPathAvatarType::BoyShamanType,
            MultiPathAvatar::FemaleHarmony => MultiPathAvatarType::GirlShamanType,
            MultiPathAvatar::MarchHunt => MultiPathAvatarType::Mar7thRogueType,
            MultiPathAvatar::MarchPreservation => MultiPathAvatarType::Mar7thKnightType,
            MultiPathAvatar::Unk => MultiPathAvatarType::None,
            MultiPathAvatar::MaleRememberance => MultiPathAvatarType::BoyMemoryType,
            MultiPathAvatar::FemaleRememberance => MultiPathAvatarType::GirlMemoryType,
        }
    }

    pub fn is_mc(&self) -> bool {
        (*self as u32) > 8000
    }

    pub fn to_vec() -> Vec<MultiPathAvatar> {
        vec![
            Self::MalePyhsical,
            Self::FemalePhysical,
            Self::MalePreservation,
            Self::FemalePreservation,
            Self::MaleHarmony,
            Self::FemaleHarmony,
            Self::MaleRememberance,
            Self::FemaleRememberance,
            Self::MarchHunt,
            Self::MarchPreservation,
        ]
    }
}

impl FreesrData {
    pub async fn load() -> Self {
        let mut json: FreesrData = tokio::fs::read_to_string("freesr-data.json")
            .await
            .map(|v| {
                serde_json::from_str::<FreesrData>(&v)
                    .expect("freesr-data.json is broken, pls redownload")
            })
            .expect("failed to read freesr-data.json");

        let json2: Persistent = serde_json::from_str(
            &tokio::fs::read_to_string("persistent")
                .await
                .unwrap_or_default(),
        )
        .unwrap_or_default();

        json.lineups = json2.lineups;
        json.position = json2.position;
        json.scene = json2.scene;
        json.main_character = json2.main_character;
        json.march_type = json2.march_type;

        json.verify_lineup().await;

        if json.march_type as u32 > 8000 {
            json.march_type = MultiPathAvatar::MarchHunt;
        }

        json
    }

    async fn verify_lineup(&mut self) {
        if self.lineups.is_empty() {
            self.lineups = BTreeMap::<u32, u32>::from([(0, 8001), (1, 0), (2, 0), (3, 0)])
        } else if self.lineups.len() < 4 {
            for i in self.lineups.len()..4 {
                self.lineups.insert(i as u32, 0);
            }
        }
        self.save().await;
    }

    pub async fn save_lineup(&self) {
        self.save().await;
    }

    pub async fn save(&self) {
        let json = serde_json::to_string_pretty(&self).unwrap();
        let _ = tokio::fs::write("freesr-data.json", json.as_bytes()).await;
        let _ = tokio::fs::write(
            "persistent",
            serde_json::to_string_pretty(&Persistent {
                lineups: self.lineups.clone(),
                main_character: self.main_character,
                position: self.position.clone(),
                scene: self.scene.clone(),
                march_type: self.march_type,
            })
            .unwrap()
            .as_bytes(),
        )
        .await;
    }

    pub fn get_multi_path_info(&self) -> Vec<MultiPathAvatarTypeInfo> {
        MultiPathAvatar::to_vec()
            .iter()
            .filter_map(|mp_type| {
                if mp_type.is_mc() && mp_type.get_gender() != self.main_character.get_gender() {
                    return Option::None;
                }

                let avatar_info = self.avatars.get(&((*mp_type) as u32))?;
                Some(MultiPathAvatarTypeInfo {
                    avatar_id: *mp_type as i32,
                    rank: avatar_info.data.rank,
                    equip_relic_list: self
                        .relics
                        .iter()
                        .filter(|relic| relic.equip_avatar == *mp_type as u32)
                        .map(|relic| relic.to_equipment_relic_proto())
                        .collect(),
                    skilltree_list: avatar_info
                        .data
                        .skills
                        .iter()
                        .map(|(point_id, level)| AvatarSkillTree {
                            point_id: *point_id,
                            level: *level,
                        })
                        .collect(),
                    path_equipment_id: self
                        .lightcones
                        .iter()
                        .find(|v| v.equip_avatar == *mp_type as u32)
                        .map(|v| {
                            // TODO: HARDCODED LIGHTCONE ID
                            2000 + v.internal_uid
                        })
                        .unwrap_or_default(),
                    dressed_skin_id: 0,
                })
            })
            .collect()
    }
}
