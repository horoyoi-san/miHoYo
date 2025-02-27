use std::sync::{LazyLock, OnceLock};

use config::MuipServerConfig;
use tracing::{error, info};
use trigger_sv::{
    config::{ServerEnvironmentConfiguration, TomlConfig},
    die, logging,
    net::{ServerNetworkManager, ServerType},
    print_banner,
};

mod config;
mod http_server;
mod server_message_handler;

const CONFIG_FILE: &str = "muipserver.toml";
const SERVER_TYPE: ServerType = ServerType::MuipServer;

struct AppState {
    pub config: &'static MuipServerConfig,
    pub network_mgr: ServerNetworkManager,
}

#[tokio::main]
async fn main() {
    static APP_STATE: OnceLock<AppState> = OnceLock::new();
    static CONFIG: LazyLock<MuipServerConfig> =
        LazyLock::new(|| MuipServerConfig::load_or_create(CONFIG_FILE));

    print_banner();
    logging::init_tracing(tracing::Level::DEBUG);

    let environment = ServerEnvironmentConfiguration::load_from_toml("environment.toml")
        .unwrap_or_else(|err| {
            error!("{err}");
            die();
        });

    let network_mgr =
        ServerNetworkManager::new(SERVER_TYPE, CONFIG.node.server_id, &environment.servers);

    let state = APP_STATE.get_or_init(|| AppState {
        config: &CONFIG,
        network_mgr,
    });

    http_server::serve(state).await.unwrap_or_else(|err| {
        error!("http_server::serve failed: {err}");
        die();
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
