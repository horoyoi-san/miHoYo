use std::collections::HashMap;

use crate::net::tools::FreesrData;

use super::*;

pub async fn on_get_basic_info_cs_req(
    _session: &mut PlayerSession,
    _body: &GetBasicInfoCsReq,
    res: &mut GetBasicInfoScRsp,
) {
    res.player_setting_info = Some(PlayerSettingInfo::default());
    res.gender = Gender::Woman as u32;
    res.is_gender_set = true;
}

pub async fn on_player_heart_beat_cs_req(
    _session: &mut PlayerSession,
    body: &PlayerHeartBeatCsReq,
    res: &mut PlayerHeartBeatScRsp,
) {
    res.client_time_ms = body.client_time_ms;
    res.server_time_ms = body.client_time_ms;
    res.download_data = Some(ClientDownloadData {
        version: 51,
        time: res.server_time_ms as i64,
        data: rbase64::decode("bG9jYWwgZnVuY3Rpb24gYmV0YV90ZXh0KG9iaikKICAgIGxvY2FsIGdhbWVPYmplY3QgPSBDUy5Vbml0eUVuZ2luZS5HYW1lT2JqZWN0LkZpbmQoIlVJUm9vdC9BYm92ZURpYWxvZy9CZXRhSGludERpYWxvZyhDbG9uZSkiKQogICAgaWYgZ2FtZU9iamVjdCB0aGVuCiAgICAgICAgbG9jYWwgdGV4dENvbXBvbmVudCA9IGdhbWVPYmplY3Q6R2V0Q29tcG9uZW50SW5DaGlsZHJlbih0eXBlb2YoQ1MuUlBHLkNsaWVudC5Mb2NhbGl6ZWRUZXh0KSkKICAgICAgICBpZiB0ZXh0Q29tcG9uZW50IHRoZW4KICAgICAgICAgICAgdGV4dENvbXBvbmVudC50ZXh0ID0gIjxzaXplPTE2PiA8Y29sb3I9I2ZmMDQwMD5UPC9jb2xvcj48Y29sb3I9I2ZmMDQwMD5oPC9jb2xvcj48Y29sb3I9I2ZmZmZmZj5hPC9jb2xvcj48Y29sb3I9IzAwMGRmZj5pPC9jb2xvcj48Y29sb3I9IzAwMGRmZj5sPC9jb2xvcj4gPGNvbG9yPSNmZmZmZmY+YTwvY29sb3I+PGNvbG9yPSNmZjA0MDA+bjwvY29sb3I+PGNvbG9yPSNmZjA0MDA+ZDwvY29sb3I+fDxjb2xvcj0jZmYwMDAwPkhvcm95b2ktc2FuIFNSPC9jb2xvcj48L3NpemU+IgogICAgICAgIGVuZAogICAgZW5kCmVuZAoKdmVyc2lvbl90ZXh0KCkKYmV0YV90ZXh0KCk=").unwrap(),
        haehhcpoapp: 0
    });
}

pub async fn on_player_login_finish_cs_req(
    session: &mut PlayerSession,
    _req: &PlayerLoginFinishCsReq,
    _res: &mut PlayerLoginFinishScRsp,
) -> Result<()> {
    session
        .send(ContentPackageSyncDataScNotify {
            data: Some(PackageData {
                info_list: [
                    200001, 200002, 200003, 200004, 150017, 150015, 150021, 150018, 130011, 130012,
                    130013,
                ]
                .iter()
                .map(|v| ContentInfo {
                    status: ContentPackageStatus::Finished.into(),
                    content_id: *v,
                })
                .collect(),
                ..Default::default()
            }),
        })
        .await?;

    Ok(())
}

pub async fn on_get_multi_path_avatar_info_cs_req(
    _session: &mut PlayerSession,
    _req: &GetMultiPathAvatarInfoCsReq,
    res: &mut GetMultiPathAvatarInfoScRsp,
) {
    let json = FreesrData::load().await;

    res.current_multi_path_avatar_id = HashMap::from([
        (8001, json.main_character.get_type().into()),
        (1001, json.march_type.get_type().into()),
    ]);

    res.multi_path_avatar_type_info_list = json.get_multi_path_info();
}
