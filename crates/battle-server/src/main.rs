use std::sync::{LazyLock, OnceLock};

use config::BattleServerConfig;
use dashmap::DashMap;
use session::BattleSession;
use tokio::sync::Mutex;
use tracing::{error, info};
use trigger_fileconfig::{ArchiveFile, NapFileCfg};
use trigger_sv::{
    config::{ServerEnvironmentConfiguration, TomlConfig},
    die, logging,
    net::{ServerNetworkManager, ServerType},
    print_banner,
};

mod config;
mod logic;
mod server_message_handler;
mod session;

const BLK_ASSET_FILE: &str = "3271423389.blk";
const CONFIG_FILE: &str = "battleserver.toml";
const SERVER_TYPE: ServerType = ServerType::BattleServer;

struct AppState {
    #[expect(unused)]
    pub config: &'static BattleServerConfig,
    pub filecfg: NapFileCfg<'static>,
    pub network_mgr: ServerNetworkManager,
    pub sessions: DashMap<u64, Mutex<BattleSession>>,
}

#[tokio::main]
async fn main() {
    static APP_STATE: OnceLock<AppState> = OnceLock::new();
    static DESIGN_DATA_BLK: OnceLock<ArchiveFile> = OnceLock::new();
    static CONFIG: LazyLock<BattleServerConfig> =
        LazyLock::new(|| BattleServerConfig::load_or_create(CONFIG_FILE));

    print_banner();
    logging::init_tracing(tracing::Level::DEBUG);

    let environment = ServerEnvironmentConfiguration::load_from_toml("environment.toml")
        .unwrap_or_else(|err| {
            error!("{err}");
            die();
        });

    let design_data_blk = trigger_fileconfig::read_archive_file(&mut ::std::io::Cursor::new(
        &std::fs::read(BLK_ASSET_FILE).unwrap_or_else(|err| {
            error!("failed to open design data blk file: {err}");
            die();
        }),
    ))
    .expect("failed to unpack design data blk file");

    let design_data_blk = DESIGN_DATA_BLK.get_or_init(|| design_data_blk);

    let network_mgr =
        ServerNetworkManager::new(SERVER_TYPE, CONFIG.node.server_id, &environment.servers);

    let state = APP_STATE.get_or_init(|| AppState {
        config: &CONFIG,
        filecfg: NapFileCfg::new(design_data_blk),
        network_mgr,
        sessions: DashMap::new(),
    });

    state
        .network_mgr
        .start_listener(state, server_message_handler::handle_message)
        .await
        .inspect(|_| {
            info!(
                "successfully started service {:?}:{}",
                SERVER_TYPE, CONFIG.node.server_id
            )
        })
        .unwrap_or_else(|err| {
            error!("failed to start network manager: {err}");
            die();
        })
        .await // this will await for entirety of the ServerNetworkManager work (forever)
        .unwrap_or_else(|err| {
            error!("{err}");
            die();
        });
}
