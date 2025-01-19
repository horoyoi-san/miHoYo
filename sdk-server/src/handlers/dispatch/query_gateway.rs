use axum::{extract::Query, http::StatusCode};
use cfg_utility::hotfix::GameVersion;
use cfg_utility::server::ServerConfig;
use sr_proto::MsgTrait;
use sr_proto::pb::GateServer;

use serde::Deserialize;

#[derive(Deserialize)]
pub struct Gateway {
    pub version: Option<String>,
    // t: Option<String>,
    // uid: Option<String>,
    // language_type: Option<i32>,
    // platform_type: Option<i32>,
    // dispatch_seed: Option<String>,
    // channel_id: Option<i32>,
    // sub_channel_id: Option<i32>,
    // is_need_url: Option<i32>,
    // game_version: Option<String>,
    // account_type: Option<i32>,
    // account_uid: Option<i64>,
}

pub async fn handle(Query(q): Query<Gateway>) -> (StatusCode, String) {
    let server_config = ServerConfig::from_file("_cfg/server.toml");
    let game_version = GameVersion::from_file("_cfg/hotfix.json");
    let hotfix = game_version.get_hotfix_by_version(&q.version);

    let rsp = rbase64::encode(
        &GateServer {
            // hotfix
            le_tp_hk_e: hotfix.lua_url,
            lpet1he: hotfix.lua_version,
            lgethye: hotfix.ex_resource_url,
            l2etohe: hotfix.asset_bundle_url,

            // we're not using kcp.
            //use_tcp
            lbelthe: true,
            ip: server_config.game_server_host,
            port: server_config.game_server_port,

            // let's just bruteforce the bool fields.
            lx_ethje: true,
            le_tt_h5e: true,
            lv_e_te_he: true,
            le6thne: true,
            leg_tn_he: true,
            lxetqhe: true,
            lhe_tz_he: true,
            ..Default::default()
        }
        .encode_to_vec(),
    );

    (StatusCode::OK, rsp)
}
