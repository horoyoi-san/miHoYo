use std::collections::HashMap;

use rand::Rng;
use rogue_magic_battle_unit_info::Item;

use crate::{
    net::tools::{self, BattleType, Monster},
    tools::resources::GAME_RES,
};

use super::*;

pub async fn on_start_cocoon_stage_cs_req(
    _session: &mut PlayerSession,
    req: &StartCocoonStageCsReq,
    res: &mut StartCocoonStageScRsp,
) {
    let battle_info = create_battle_info(0, 0).await;

    res.prop_entity_id = req.prop_entity_id;
    res.cocoon_id = req.cocoon_id;
    res.wave = req.wave;
    res.battle_info = Some(battle_info);
}

pub async fn on_quick_start_cocoon_stage_cs_req(
    _session: &mut PlayerSession,
    req: &QuickStartCocoonStageCsReq,
    res: &mut QuickStartCocoonStageScRsp,
) {
    let mut battle_info = create_battle_info(0, 0).await;

    battle_info.world_level = req.world_level;
    res.cocoon_id = req.cocoon_id;
    res.wave = req.wave;
    res.battle_info = Some(battle_info);
}

pub async fn on_pve_battle_result_cs_req(
    _session: &mut PlayerSession,
    req: &PveBattleResultCsReq,
    res: &mut PveBattleResultScRsp,
) {
    res.end_status = req.end_status;
    res.battle_id = req.battle_id;
}

pub async fn on_scene_cast_skill_cs_req(
    _session: &mut PlayerSession,
    req: &SceneCastSkillCsReq,
    res: &mut SceneCastSkillScRsp,
) {
    res.attacked_group_id = req.attacked_group_id;

    let targets = req
        .hit_target_entity_id_list
        .iter()
        .filter(|id| **id > 30_000 || **id < 1_000)
        .collect::<Vec<_>>();

    if targets.is_empty() {
        return;
    }

    let battle_info = create_battle_info(req.caster_id, req.skill_index).await;

    res.battle_info = Some(battle_info);
}

async fn create_battle_info(caster_id: u32, skill_index: u32) -> SceneBattleInfo {
    let player = tools::FreesrData::load().await;

    let mut battle_info = SceneBattleInfo {
        stage_id: player.battle_config.stage_id,
        logic_random_seed: rand::thread_rng().gen::<u32>(),
        battle_id: 1,
        rounds_limit: player.battle_config.cycle_count,
        world_level: 6,
        ..Default::default()
    };

    // avatars
    for (avatar_index, avatar_id) in player.lineups.iter() {
        let is_trailblazer = *avatar_id == 8001;
        let is_march = *avatar_id == 1001;

        let avatar_id = if is_trailblazer {
            player.main_character as u32
        } else if is_march {
            player.march_type as u32
        } else {
            *avatar_id
        };

        if let Some(avatar) = player.avatars.get(&avatar_id) {
            let (battle_avatar, techs) = avatar.to_battle_avatar_proto(
                *avatar_index,
                player
                    .lightcones
                    .iter()
                    .find(|v| v.equip_avatar == avatar.avatar_id),
                player
                    .relics
                    .iter()
                    .filter(|v| v.equip_avatar == avatar.avatar_id)
                    .collect::<Vec<_>>(),
            );
            for tech in techs {
                battle_info.buff_list.push(tech);
            }

            if caster_id > 0
                && *avatar_index == (caster_id - 1)
                && let Some(avatar_config) = GAME_RES.avatar_configs.get(&avatar_id)
                && !avatar.techniques.contains(&1000119)
            {
                battle_info.buff_list.push(BattleBuff {
                    id: avatar_config.weakness_buff_id,
                    level: 1,
                    owner_id: *avatar_index,
                    wave_flag: 0xffffffff,
                    dynamic_values: HashMap::from([(
                        String::from("SkillIndex"),
                        skill_index as f32,
                    )]),
                    ..Default::default()
                });
            }

            battle_info.battle_avatar_list.push(battle_avatar);

            // hardcoded march
            if avatar.avatar_id == 1224 {
                let buffs = BattleBuff {
                    id: 122401,
                    level: 3,
                    wave_flag: 0xffffffff,
                    owner_id: *avatar_index,
                    dynamic_values: HashMap::from([
                        (String::from("#ADF_1"), 3f32),
                        (String::from("#ADF_2"), 3f32),
                    ]),
                    target_index_list: vec![0],
                };

                battle_info.buff_list.push(buffs);
            }
        };
    }

    // custom stats for avatars
    for stat in &player.battle_config.custom_stats {
        for avatar in &mut battle_info.battle_avatar_list {
            if avatar.relic_list.is_empty() {
                avatar.relic_list.push(BattleRelic {
                    id: 61011,
                    main_affix_id: 1,
                    level: 1,
                    ..Default::default()
                })
            }

            if let Some(sub_affix) = avatar.relic_list[0]
                .sub_affix_list
                .iter_mut()
                .find(|v| v.affix_id == stat.sub_affix_id)
            {
                sub_affix.cnt = stat.count;
            } else {
                avatar.relic_list[0].sub_affix_list.push(RelicAffix {
                    affix_id: stat.sub_affix_id,
                    cnt: stat.count,
                    step: stat.step,
                })
            }
        }
    }

    // blessings
    for blessing in &player.battle_config.blessings {
        let mut buffs = BattleBuff {
            id: blessing.id,
            level: blessing.level,
            wave_flag: 0xffffffff,
            owner_id: 0xffffffff,
            ..Default::default()
        };

        if let Some(dynamic_value) = &blessing.dynamic_key {
            buffs
                .dynamic_values
                .insert(dynamic_value.key.clone(), dynamic_value.value as f32);
        };

        for dynamic_value in &blessing.dynamic_values {
            if buffs.dynamic_values.contains_key(&dynamic_value.key) {
                continue;
            };
            buffs
                .dynamic_values
                .insert(dynamic_value.key.clone(), dynamic_value.value as f32);
        }

        battle_info.buff_list.push(buffs);
    }

    // pf score object
    if player.battle_config.battle_type == BattleType::PF {
        if battle_info.stage_id >= 30309011 {
            battle_info.battle_target_info.insert(
                1,
                BattleTargetList {
                    battle_target_list: vec![BattleTarget {
                        id: 10003,
                        progress: 0,
                        ..Default::default()
                    }],
                },
            );
        } else {
            battle_info.battle_target_info.insert(
                1,
                BattleTargetList {
                    battle_target_list: vec![BattleTarget {
                        id: 10002,
                        progress: 0,
                        ..Default::default()
                    }],
                },
            );
        }

        for i in 2..=4 {
            battle_info
                .battle_target_info
                .insert(i, BattleTargetList::default());
        }

        battle_info.battle_target_info.insert(
            5,
            BattleTargetList {
                battle_target_list: vec![
                    BattleTarget {
                        id: 2001,
                        progress: 0,
                        ..Default::default()
                    },
                    BattleTarget {
                        id: 2002,
                        progress: 0,
                        ..Default::default()
                    },
                ],
            },
        );
    }

    // Apocalyptic Shadow
    if player.battle_config.battle_type == BattleType::AS {
        battle_info.battle_target_info.insert(
            1,
            BattleTargetList {
                battle_target_list: vec![BattleTarget {
                    id: 90005,
                    progress: 0,
                    ..Default::default()
                }],
            },
        );
    }

    //  SU
    if player.battle_config.battle_type == BattleType::SU {
        battle_info
            .event_battle_info_list
            .push(BattleEventBattleInfo {
                battle_event_id: player.battle_config.path_resonance_id,
                status: Some(BattleEventInitedData {
                    sp_bar: Some(SpBarInfo {
                        cur_sp: 10_000,
                        max_sp: 10_000,
                    }),
                }),
                skill_info: Vec::with_capacity(0),
            })
    }

    // Monsters
    battle_info.monster_wave_list = Monster::to_scene_monster_waves(&player.battle_config.monsters);

    // Rogue Magic
    if !player.battle_config.scepters.is_empty() {
        battle_info.rogue_magic_battle_info = Some(RogueMagicBattleInfo {
            player_detail_info: Some(RogueMagicBattleUnitInfo {
                item: Some(Item::BattleRogueMagicData(BattleRogueMagicData {
                    round_cnt: Some(BattleRogueMagicRoundCount {
                        gpojenhaiba: 3,
                        kljklbmlefo: 0,
                    }),
                    battle_scepter_list: player
                        .battle_config
                        .scepters
                        .iter()
                        .map(|scepter| {
                            let mut battle_scepter = BattleRogueMagicScepter {
                                level: scepter.level,
                                scepter_id: scepter.id,
                                magic_list: Vec::new(),
                                trench_count: HashMap::from([(3, 0), (4, 0), (5, 0)]),
                            };

                            let mut index = [0u32; 3];

                            for component in &scepter.components {
                                let (slot_type, locked) = match component.component_type {
                                    tools::RogueMagicComponentType::Passive => (3u32, false),
                                    tools::RogueMagicComponentType::Active => (4, true),
                                    tools::RogueMagicComponentType::Attach => (5, false),
                                };

                                let slot_index = &mut index[slot_type as usize - 3];
                                battle_scepter.magic_list.push(BattleRogueMagicUnit {
                                    level: component.level,
                                    unit_id: component.id,
                                    slot_id: *slot_index,
                                    locked,
                                    counter_map: Default::default(),
                                });
                                *slot_index += 1;
                                *battle_scepter.trench_count.get_mut(&slot_type).unwrap() += 1;
                            }

                            battle_scepter
                        })
                        .collect(),
                })),
            }),
            scepter: Some(Plgjihifpag { egmebanhhnf: 5 }),
        });
    }

    battle_info
}
