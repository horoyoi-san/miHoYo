use tracing::{debug, warn};
use trigger_logic::quest::EQuestType;
use trigger_protocol::{util::ProtocolUnit, AvatarSync, CafeSync, ItemSync, PlayerSyncScNotify};
use trigger_sv::gm_command::GMCommand;

use crate::AppState;

use super::{player::AvatarPropertyChanges, NapPlayer};

pub struct CommandContext<'player> {
    pub player: &'player mut NapPlayer,
    pub state: &'static AppState,
    notifies: Vec<ProtocolUnit>,
}

impl<'player> CommandContext<'player> {
    pub fn new(player: &'player mut NapPlayer, state: &'static AppState) -> Self {
        Self {
            player,
            state,
            notifies: Vec::new(),
        }
    }

    pub fn add_notify<Notify: Into<ProtocolUnit>>(&mut self, notify: Notify) {
        self.notifies.push(notify.into());
    }

    pub fn remove_notifies(&mut self) -> Vec<ProtocolUnit> {
        std::mem::take(&mut self.notifies)
    }
}

pub async fn execute_command(context: &mut CommandContext<'_>, command: &GMCommand) {
    debug!(
        "executing {command:?} for player with uid {}",
        context.player.player_uid()
    );

    match command {
        GMCommand::AddAvatar { id } => gm_add_avatar(context, *id).await,
        GMCommand::SetAvatarLevel { id, level } => {
            gm_modify_avatar_properties(context, *id, Some(*level), None, None).await
        }
        GMCommand::SetAvatarRank { id, rank } => {
            gm_modify_avatar_properties(context, *id, None, Some(*rank), None).await
        }
        GMCommand::SetAvatarTalent { id, talent } => {
            gm_modify_avatar_properties(context, *id, None, None, Some(*talent)).await
        }
        GMCommand::AddAllWeapon => gm_add_all_weapon(context).await,
        GMCommand::AddAllEquip => gm_add_all_equip(context).await,
        GMCommand::AddEquip {
            equip_id,
            level,
            star,
            property_params,
        } => gm_add_equip(context, *equip_id, *level, *star, property_params).await,
        GMCommand::AddQuest {
            quest_type,
            quest_id,
        } => gm_add_quest(context, *quest_type, *quest_id).await,
        GMCommand::FinishQuest {
            quest_type,
            quest_id,
        } => {
            gm_finish_quest(context, *quest_type, *quest_id).await;
        }
        GMCommand::AddItemByType { .. } => {
            warn!("AddItemByType is not implemented yet");
        }
        GMCommand::UnlockAllHollow => gm_unlock_all_hollow(context).await,
        GMCommand::UnlockAllHollowBuff => gm_unlock_all_hollow_buff(context).await,
        GMCommand::UnlockAllCafeItem => gm_unlock_all_cafe_item(context).await,
    }
}

async fn gm_unlock_all_hollow(context: &mut CommandContext<'_>) {
    context
        .player
        .yorozuya_model
        .unlock_hollow(
            &context
                .state
                .filecfg
                .hollow_config_template_tb
                .data()
                .unwrap()
                .iter()
                .map(|tmpl| tmpl.id())
                .collect::<Vec<_>>(),
        )
        .await;

    context.add_notify(PlayerSyncScNotify {
        // TODO: HollowData sync!
        ..Default::default()
    });
}

async fn gm_unlock_all_cafe_item(context: &mut CommandContext<'_>) {
    context
        .player
        .cafe_model
        .unlock_cafe_item(
            &context
                .state
                .filecfg
                .cafe_config_template_tb
                .data()
                .unwrap()
                .iter()
                .map(|tmpl| tmpl.id())
                .collect::<Vec<_>>(),
        )
        .await;

    context.add_notify(PlayerSyncScNotify {
        cafe_sync: Some(CafeSync {
            cafe_data: Some(context.player.cafe_model.get_protocol_cafe_data()),
        }),
        ..Default::default()
    });
}

async fn gm_unlock_all_hollow_buff(context: &mut CommandContext<'_>) {
    context
        .player
        .ramen_model
        .unlock_ramen(
            &context
                .state
                .filecfg
                .hollow_buff_template_tb
                .data()
                .unwrap()
                .iter()
                .map(|tmpl| tmpl.id())
                .collect::<Vec<_>>(),
        )
        .await;

    context.add_notify(PlayerSyncScNotify {
        ramen_sync: Some(context.player.ramen_model.get_protocol_ramen_sync(false)),
        ..Default::default()
    });
}

async fn gm_add_quest(context: &mut CommandContext<'_>, quest_type: i32, quest_id: i32) {
    if let Ok(ty) = EQuestType::try_from(quest_type) {
        match ty {
            EQuestType::ArchiveFile => {
                context
                    .player
                    .main_story_model
                    .add_archive_files(&[quest_id])
                    .await;
            }
            EQuestType::Hollow => {
                context
                    .player
                    .yorozuya_model
                    .add_hollow_quest(&[quest_id])
                    .await;
            }
            EQuestType::MainCity => {}
            _ => {
                warn!("quest type {quest_type:?} is not implemented yet");
                return;
            }
        };

        context.player.quest_model.add_quest(ty, quest_id).await;
    } else {
        warn!("gm_add_quest: invalid quest type: {quest_type}");
    }
}

async fn gm_finish_quest(context: &mut CommandContext<'_>, quest_type: i32, quest_id: i32) {
    if let Ok(quest_type) = EQuestType::try_from(quest_type) {
        let quest_id_list = match quest_type {
            EQuestType::ArchiveFile => {
                let quest_id_list = if quest_id != 0 {
                    vec![quest_id]
                } else {
                    context
                        .state
                        .filecfg
                        .archive_file_quest_template_tb
                        .data()
                        .unwrap()
                        .iter()
                        .map(|tmpl| tmpl.id())
                        .collect::<Vec<_>>()
                };

                context
                    .player
                    .main_story_model
                    .add_archive_files(&quest_id_list)
                    .await;

                quest_id_list
            }
            EQuestType::Hollow => {
                let quest_id_list = if quest_id != 0 {
                    vec![quest_id]
                } else {
                    context
                        .state
                        .filecfg
                        .hollow_quest_template_tb
                        .data()
                        .unwrap()
                        .iter()
                        .map(|tmpl| tmpl.id())
                        .collect::<Vec<_>>()
                };

                context
                    .player
                    .yorozuya_model
                    .add_hollow_quest(&quest_id_list)
                    .await;

                quest_id_list
            }
            _ => {
                warn!("quest type {quest_type:?} is not implemented yet");
                return;
            }
        };

        context
            .player
            .quest_model
            .finish_quests(quest_type, &quest_id_list)
            .await;
    } else {
        warn!("gm_add_quest: invalid quest type: {quest_type}");
    }
}

async fn gm_add_equip(
    context: &mut CommandContext<'_>,
    equip_id: i32,
    level: i16,
    star: i16,
    params: &[i32],
) {
    let equip_uid = context
        .player
        .equip_model
        .add_custom_equip(equip_id, level, star, params)
        .await;

    context.add_notify(PlayerSyncScNotify {
        item_sync: Some(ItemSync {
            equip_list: context
                .player
                .equip_model
                .get_protocol_equip_list(&[equip_uid]),
            ..Default::default()
        }),
        ..Default::default()
    });
}

async fn gm_add_all_equip(context: &mut CommandContext<'_>) {
    let added_equip_uid_list = context
        .player
        .equip_model
        .add_equip(
            &context
                .state
                .filecfg
                .equipment_template_tb
                .data()
                .unwrap()
                .iter()
                .map(|tmpl| tmpl.item_id())
                .collect::<Vec<_>>(),
        )
        .await;

    context.add_notify(PlayerSyncScNotify {
        item_sync: Some(ItemSync {
            equip_list: context
                .player
                .equip_model
                .get_protocol_equip_list(&added_equip_uid_list),
            ..Default::default()
        }),
        ..Default::default()
    });
}

async fn gm_add_all_weapon(context: &mut CommandContext<'_>) {
    let added_weapon_uid_list = context
        .player
        .equip_model
        .add_weapon(
            &context
                .state
                .filecfg
                .weapon_template_tb
                .data()
                .unwrap()
                .iter()
                .map(|tmpl| tmpl.item_id())
                .collect::<Vec<_>>(),
        )
        .await;

    context.add_notify(PlayerSyncScNotify {
        item_sync: Some(ItemSync {
            weapon_list: context
                .player
                .equip_model
                .get_protocol_weapon_list(&added_weapon_uid_list),
            ..Default::default()
        }),
        ..Default::default()
    });
}

async fn gm_modify_avatar_properties(
    context: &mut CommandContext<'_>,
    id: i32,
    level: Option<i16>,
    rank: Option<i16>,
    talent_num: Option<i16>,
) {
    if let Some(updated_avatars) = context
        .player
        .role_model
        .change_avatar_properties(AvatarPropertyChanges {
            avatar_id: id as u32,
            level,
            rank,
            talent_num,
        })
        .await
    {
        context.add_notify(PlayerSyncScNotify {
            avatar_sync: Some(AvatarSync {
                avatar_list: context
                    .player
                    .role_model
                    .get_protocol_avatar_list(&updated_avatars),
            }),
            ..Default::default()
        });
    }
}

async fn gm_add_avatar(context: &mut CommandContext<'_>, id: i32) {
    if id == 0 {
        let added_avatars = context
            .player
            .role_model
            .unlock_avatars(
                &context
                    .state
                    .filecfg
                    .avatar_base_template_tb
                    .data()
                    .unwrap()
                    .iter()
                    .map(|tmpl| tmpl.id())
                    .filter(|id| {
                        !context
                            .state
                            .gm_blacklist
                            .black_item_list
                            .iter()
                            .any(|item| item.id == *id)
                    })
                    .collect::<Vec<_>>(),
            )
            .await;

        context.add_notify(PlayerSyncScNotify {
            avatar_sync: Some(AvatarSync {
                avatar_list: context
                    .player
                    .role_model
                    .get_protocol_avatar_list(&added_avatars),
            }),
            ..Default::default()
        });
    } else {
        context.player.role_model.unlock_avatars(&[id]).await;

        context.add_notify(PlayerSyncScNotify {
            avatar_sync: Some(AvatarSync {
                avatar_list: context
                    .player
                    .role_model
                    .get_protocol_avatar_list(&[id as u32]),
            }),
            ..Default::default()
        });
    }
}
