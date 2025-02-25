use scene_entity_info::Entity;
use scene_entity_refresh_info::RefreshType;

use crate::net::tools::{self, AvatarJson, FreesrData};

use super::*;

pub async fn on_get_all_lineup_data_cs_req(
    _session: &mut PlayerSession,
    _body: &GetAllLineupDataCsReq,
    res: &mut GetAllLineupDataScRsp,
) {
    let player = tools::FreesrData::load().await;
    res.lineup_list = vec![LineupInfo {
        extra_lineup_type: ExtraLineupType::LineupNone.into(),
        name: "Squad 1".to_string(),
        mp: 5,
        max_mp: 5,
        avatar_list: AvatarJson::to_lineup_avatars(&player),
        ..Default::default()
    }];
}

pub async fn on_get_cur_lineup_data_cs_req(
    _session: &mut PlayerSession,
    _body: &GetCurLineupDataCsReq,
    res: &mut GetCurLineupDataScRsp,
) {
    let player = tools::FreesrData::load().await;
    let lineup = LineupInfo {
        extra_lineup_type: ExtraLineupType::LineupNone.into(),
        name: "Squad 1".to_string(),
        mp: 5,
        max_mp: 5,
        avatar_list: AvatarJson::to_lineup_avatars(&player),
        is_virtual: false,
        plane_id: 0,
        ..Default::default()
    };

    res.lineup = Some(lineup)
}

pub async fn on_join_lineup_cs_req(
    session: &mut PlayerSession,
    body: &JoinLineupCsReq,
    _res: &mut JoinLineupScRsp,
) {
    let mut player = tools::FreesrData::load().await;
    let lineups = &mut player.lineups;
    lineups.insert(body.slot, body.base_avatar_id);
    player.save_lineup().await;
    refresh_lineup(session, &player).await;
}

pub async fn on_replace_lineup_cs_req(
    _session: &mut PlayerSession,
    req: &ReplaceLineupCsReq,
    _res: &mut ReplaceLineupScRsp,
) {
    let mut player = tools::FreesrData::load().await;

    let lineups = &mut player.lineups;
    for (slot, avatar_id) in &mut *lineups {
        if let Some(lineup) = req.slots.get(*slot as usize) {
            *avatar_id = lineup.id;
        } else {
            *avatar_id = 0;
        }
    }
    player.save_lineup().await;
    refresh_lineup(_session, &player).await;
}

pub async fn on_quit_lineup_cs_req(
    _session: &mut PlayerSession,
    _: &QuitLineupCsReq,
    _res: &mut QuitLineupScRsp,
) {
}

async fn refresh_lineup(session: &mut PlayerSession, player: &FreesrData) {
    let lineup = LineupInfo {
        extra_lineup_type: ExtraLineupType::LineupNone.into(),
        name: "Squad 1".to_string(),
        avatar_list: AvatarJson::to_lineup_avatars(player),
        max_mp: 5,
        mp: 5,
        ..Default::default()
    };

    session
        .send(SceneGroupRefreshScNotify {
            group_refresh_info: vec![SceneGroupRefreshInfo {
                group_id: 0,
                state: 0,
                group_refresh_type: 0,
                refresh_entity: player
                    .lineups
                    .iter()
                    .map(|(idx, v)| SceneEntityRefreshInfo {
                        refresh_type: Some(RefreshType::AddEntity(SceneEntityInfo {
                            entity: Some(Entity::Actor(SceneActorInfo {
                                avatar_type: AvatarType::AvatarFormalType.into(),
                                base_avatar_id: *v,
                                map_layer: 0,
                                uid: 25,
                            })),
                            entity_id: idx + 1,
                            group_id: 0,
                            inst_id: 0,
                            ..Default::default()
                        })),
                    })
                    .collect(),
                bccgjihncdn: Vec::with_capacity(0),
            }],
            floor_id: 0, // TODO!
            gfhglffhfbd: 0,
        })
        .await
        .unwrap();

    session
        .send(SyncLineupNotify {
            lineup: Some(lineup),
            reason_list: vec![],
        })
        .await
        .unwrap();
}

pub async fn on_change_lineup_leader_cs_req(
    _session: &mut PlayerSession,
    body: &ChangeLineupLeaderCsReq,
    res: &mut ChangeLineupLeaderScRsp,
) {
    res.slot = body.slot;
}
