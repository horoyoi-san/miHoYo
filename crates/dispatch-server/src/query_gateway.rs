use axum::{
    extract::{Query, State},
    response::IntoResponse,
    Json,
};
use base64::{display::Base64Display, engine::general_purpose::STANDARD, Engine};
use serde::{Deserialize, Serialize, Serializer};
use tracing::debug;
use trigger_cryptography::rsa;
use trigger_sv::config::RsaSetting;

use crate::{
    data::{
        CdnConfExt, CdnDesignData, CdnGameRes, CdnSilenceData, RegionExtension, RegionSwitchFunc,
        ServerDispatchData, ServerGateway,
    },
    AppState,
};

pub const ROUTE_ENDPOINT: &str = "/query_gateway";

pub struct Response {
    pub data: ServerDispatchData<'static, 'static, 'static>,
    pub rsa: Option<&'static RsaSetting>,
}

#[derive(Debug, thiserror::Error)]
pub enum QueryGatewayError {
    #[error("invalid rsa version specified: {0}")]
    InvalidRsaVer(u32),
    #[error("invalid dispatch seed, expected: {0}, got: {1}")]
    InvalidDispatchSeed(&'static str, String),
}

impl QueryGatewayError {
    pub fn retcode(&self) -> i32 {
        match self {
            Self::InvalidRsaVer(_) => 74,
            Self::InvalidDispatchSeed(_, _) => 75,
        }
    }

    pub fn message(&self) -> String {
        String::with_capacity(0)
    }
}

#[derive(Serialize)]
struct EncryptedAndSignedData {
    #[serde(serialize_with = "to_base64")]
    pub content: Vec<u8>,
    #[serde(serialize_with = "to_base64")]
    pub sign: Vec<u8>,
}

impl IntoResponse for Response {
    fn into_response(self) -> axum::response::Response {
        let Some(rsa) = self.rsa else {
            return Json(self.data).into_response();
        };

        let json = serde_json::to_string(&self.data).unwrap();

        Json(EncryptedAndSignedData {
            content: rsa::encrypt(&rsa.client_public_key, json.as_bytes()),
            sign: rsa::sign(&rsa.server_private_key, json.as_bytes()).into(),
        })
        .into_response()
    }
}

#[derive(Deserialize)]
pub struct QueryGatewayParam {
    pub rsa_ver: u32,
    pub seed: String,
}

pub async fn process(
    State(state): State<&'static AppState>,
    Query(param): Query<QueryGatewayParam>,
) -> Response {
    match internal_process(&state, param) {
        Ok(response) => response,
        Err((rsa, err)) => {
            debug!("query_gateway failed: {err}");

            Response {
                rsa,
                data: ServerDispatchData {
                    retcode: err.retcode(),
                    msg: err.message(),
                    ..Default::default()
                },
            }
        }
    }
}

fn internal_process(
    state: &'static AppState,
    param: QueryGatewayParam,
) -> Result<Response, (Option<&'static RsaSetting>, QueryGatewayError)> {
    use std::borrow::Cow::{Borrowed, Owned};

    let rsa = state
        .environment
        .security
        .get_rsa_setting_by_version(param.rsa_ver);

    if rsa.is_none() {
        return Err((None, QueryGatewayError::InvalidRsaVer(param.rsa_ver)));
    };

    (param.seed == state.config.bound_server.seed)
        .then_some(())
        .ok_or((
            rsa,
            QueryGatewayError::InvalidDispatchSeed(&state.config.bound_server.seed, param.seed),
        ))?;

    let server = &state.config.bound_server;

    Ok(Response {
        rsa,
        data: ServerDispatchData {
            retcode: 0,
            msg: String::with_capacity(0),
            region_name: Borrowed(&server.name),
            title: Borrowed(&server.title),
            client_secret_key: Owned(base64::engine::general_purpose::STANDARD.encode(&state.environment.security.static_key.seed_buf)),
            cdn_check_url: String::with_capacity(0),
            gateway: Some(ServerGateway {
                ip: Borrowed(&server.addr),
                port: server.port,
            }),
            oaserver_url: String::new(),
            force_update_url: String::new(),
            stop_jump_url: String::new(),
            cdn_conf_ext: Some(CdnConfExt {
                // TODO: unhardcode this
                design_data: CdnDesignData {
                    base_url: Borrowed("https://autopatchcn.juequling.com/design_data/beta_live/output_6898716_37ab305294/client/"),
                    data_revision: Borrowed("6898716"),
                    md5_files: Borrowed(r#"[{"fileName": "data_version", "fileSize": 4309, "fileMD5": "3201644681691708675"}]"#),
                },
                game_res: CdnGameRes {
                    audio_revision: Borrowed("6867652"),
                    base_url: Borrowed("https://autopatchcn.juequling.com/game_res/beta_live/output_6898716_37ab305294/client/"),
                    branch: Borrowed("beta_live"),
                    md5_files: Borrowed(r#"[{"fileName": "res_version", "fileSize": 2364164, "fileMD5": "14977183523459896145"}, {"fileName": "audio_version", "fileSize": 30439, "fileMD5": "12961491308958500450"}, {"fileName": "base_revision", "fileSize": 18, "fileMD5": "2380106343152280666"}]"#),
                    res_revision: Borrowed("6898716"),
                },
                silence_data: CdnSilenceData {
                    base_url: Borrowed("https://autopatchcn.juequling.com/design_data/beta_live/output_6898716_37ab305294/client_silence/"),
                    md5_files: Borrowed(r#"[{"fileName": "silence_version", "fileSize": 232, "fileMD5": "17401509085851157138"}]"#),
                    silence_revision: Borrowed("6867652"),
                },
                pre_download: None,
            }),
            region_ext: Some(RegionExtension {
                exchange_url: String::new(),
                feedback_url: String::new(),
                func_switch: RegionSwitchFunc {
                    disable_frequent_attempts: 1,
                    enable_gacha_mobile_console: 1,
                    enable_notice_mobile_console: 1,
                    enable_performance_log: 1,
                    is_kcp: server.is_kcp as i32,
                    ..Default::default()
                },
                mtr_nap: String::new(),
                mtr_sdk: String::new(),
                pgc_webview_method: 1,
                url_check_nap: String::new(),
                url_check_sdk: String::new(),
            }),
        }
    })
}

pub fn to_base64<S>(bytes: &[u8], serializer: S) -> Result<S::Ok, S::Error>
where
    S: Serializer,
{
    serializer.collect_str(&Base64Display::new(bytes, &STANDARD))
}
