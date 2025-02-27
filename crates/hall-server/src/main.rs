use std::{
    process::ExitCode,
    sync::{LazyLock, OnceLock},
};

use config::HallServerConfig;
use dashmap::DashMap;
use logic::{GameRunner, NapResources};
use session::HallSession;
use tracing::{error, info};
use trigger_fileconfig::{main_city_script::MainCityConfig, ArchiveFile, NapFileCfg};
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

const BLK_ASSET_FILE: &str = "3271423389.blk";
const MAIN_CITY_SCRIPT_PATH: &str = "ConfigScript/MainCity_1.json";
const CONFIG_FILE: &str = "hallserver.toml";
const SERVER_TYPE: ServerType = ServerType::HallServer;

struct AppState {
    #[expect(unused)]
    pub config: &'static HallServerConfig,
    pub filecfg: NapFileCfg<'static>,
    pub main_city_config: &'static MainCityConfig,
    pub network_mgr: ServerNetworkManager,
    pub sessions: DashMap<u64, HallSession>,
    pub game_runner: GameRunner,
}

#[tokio::main]
async fn main() -> ExitCode {
    static APP_STATE: OnceLock<AppState> = OnceLock::new();
    static DESIGN_DATA_BLK: OnceLock<ArchiveFile> = OnceLock::new();
    static MAIN_CITY_CONFIG: OnceLock<MainCityConfig> = OnceLock::new();
    static CONFIG: LazyLock<HallServerConfig> =
        LazyLock::new(|| HallServerConfig::load_or_create(CONFIG_FILE));

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

    let main_city_config = load_json_config(MAIN_CITY_SCRIPT_PATH, "MainCityConfig");
    let main_city_config = MAIN_CITY_CONFIG.get_or_init(|| main_city_config);

    let network_mgr =
        ServerNetworkManager::new(SERVER_TYPE, CONFIG.node.server_id, &environment.servers);

    let state = APP_STATE.get_or_init(|| AppState {
        config: &CONFIG,
        filecfg: NapFileCfg::new(design_data_blk),
        main_city_config,
        network_mgr,
        sessions: DashMap::new(),
        game_runner: GameRunner::spawn(NapResources { main_city_config }),
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
