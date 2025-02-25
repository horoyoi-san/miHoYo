use proto::*;

use crate::net::{tools::FreesrData, PlayerSession};

pub async fn on_get_bag_cs_req(
    _session: &mut PlayerSession,
    _req: &GetBagCsReq,
    res: &mut GetBagScRsp,
) {
    let player = FreesrData::load().await;

    res.equipment_list = player
        .lightcones
        .iter()
        .map(|v| v.to_equipment_proto())
        .collect();
    res.relic_list = player.relics.iter().map(|v| v.to_relic_proto()).collect();
    res.material_list = vec![
        Material {
            tid: 101, // Normal Pass
            num: 999999,
            ..Default::default()
        },
        Material {
            tid: 102, // Special Pass
            num: 999999,
            ..Default::default()
        },
    ];
}

pub async fn on_get_archive_data_cs_req(
    _session: &mut PlayerSession,
    _: &GetArchiveDataCsReq,
    res: &mut GetArchiveDataScRsp,
) {
    res.archive_data = Some(ArchiveData::default());
}

pub async fn on_dress_relic_avatar_cs_req(
    _session: &mut PlayerSession,
    _req: &DressRelicAvatarCsReq,
    _res: &mut DressRelicAvatarScRsp,
) {
}

pub async fn on_take_off_relic_cs_req(
    _session: &mut PlayerSession,
    _req: &TakeOffRelicCsReq,
    _res: &mut TakeOffRelicScRsp,
) {
}

pub async fn on_dress_avatar_cs_req(
    _session: &mut PlayerSession,
    _req: &DressAvatarCsReq,
    _res: &mut DressAvatarScRsp,
) {
}

pub async fn on_take_off_equipment_cs_req(
    _session: &mut PlayerSession,
    _req: &TakeOffEquipmentCsReq,
    _res: &mut TakeOffEquipmentScRsp,
) {
}

// pub async fn on_relic_recommend_cs_req(
//     _: &mut PlayerSession,
//     req: &RelicRecommendCsReq,
//     res: &mut RelicRecommendScRsp,
// ) {
//     res.avatar_id = req.avatar_id
// }
