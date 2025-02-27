use std::{
    process::ExitCode,
    sync::{Arc, LazyLock, OnceLock},
};

use config::{GMBlackList, GMScript, GameServerConfig};
use dashmap::DashMap;
use logic::NapPlayer;
use session::GameSession;
use tokio::sync::Mutex;
use tracing::{error, info};
use trigger_database::DatabaseConnection;
use trigger_fileconfig::{ArchiveFile, NapFileCfg};
use trigger_sv::{
    config::{load_json_config, ServerEnvironmentConfiguration, TomlConfig},
    die, logging,
    net::{ServerNetworkManager, ServerType},
    print_banner,
};

mod config;
mod logic;
mod server_message_handler;
mod session;

const GM_DEMO_SCRIPT_PATH: &str = "ConfigScript/GMGroupDemo.json";
const GM_BLACKLIST_PATH: &str = "ConfigScript/Gm_Item_Black_List.json";
const BLK_ASSET_FILE: &str = "3271423389.blk";
const CONFIG_FILE: &str = "gameserver.toml";
const SERVER_TYPE: ServerType = ServerType::GameServer;

struct AppState {
    #[expect(unused)]
    pub config: &'static GameServerConfig,
    pub filecfg: NapFileCfg<'static>,
    pub gm_autoexec: GMScript,
    pub gm_blacklist: GMBlackList,
    pub network_mgr: ServerNetworkManager,
    pub sessions: DashMap<u64, Arc<GameSession>>,
    pub players: DashMap<u32, Arc<Mutex<NapPlayer>>>,
    pub database: DatabaseConnection,
}

#[tokio::main]
async fn main() -> ExitCode {
    static APP_STATE: OnceLock<AppState> = OnceLock::new();
    static DESIGN_DATA_BLK: OnceLock<ArchiveFile> = OnceLock::new();
    static CONFIG: LazyLock<GameServerConfig> =
        LazyLock::new(|| GameServerConfig::load_or_create(CONFIG_FILE));

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

    let gm_autoexec = load_json_config(GM_DEMO_SCRIPT_PATH, "GMDemo");
    let gm_blacklist = load_json_config(GM_BLACKLIST_PATH, "GMBlackList");

    let Ok(database) = trigger_database::connect(&environment.database).await else {
        die();
    };

    let network_mgr =
        ServerNetworkManager::new(SERVER_TYPE, CONFIG.node.server_id, &environment.servers);

    let state = APP_STATE.get_or_init(|| AppState {
        config: &CONFIG,
        filecfg: NapFileCfg::new(design_data_blk),
        gm_autoexec,
        gm_blacklist,
        network_mgr,
        sessions: DashMap::new(),
        players: DashMap::new(),
        database,
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

    ExitCode::SUCCESS
}
