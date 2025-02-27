use std::{
    process::ExitCode,
    sync::{LazyLock, OnceLock},
};

use config::GateServerConfig;
use message_handler::MessageHandler;
use net::ConnectionManager;
use tracing::{error, info};
use trigger_database::DatabaseConnection;
use trigger_sv::{
    config::{ServerEnvironmentConfiguration, TomlConfig},
    die, logging,
    net::{ServerNetworkManager, ServerType},
    print_banner,
};

mod config;
mod handlers;
mod message_handler;
mod net;
mod session;
mod util;

const CONFIG_FILE: &str = "gateserver.toml";
const SERVER_TYPE: ServerType = ServerType::GateServer;

struct AppState {
    pub environment: ServerEnvironmentConfiguration,
    pub connection_mgr: ConnectionManager,
    pub network_mgr: ServerNetworkManager,
    pub database: DatabaseConnection,
}

#[tokio::main]
async fn main() -> ExitCode {
    static APP_STATE: OnceLock<AppState> = OnceLock::new();
    static CONFIG: LazyLock<GateServerConfig> =
        LazyLock::new(|| GateServerConfig::load_or_create(CONFIG_FILE));

    print_banner();
    logging::init_tracing(tracing::Level::DEBUG);

    let environment = ServerEnvironmentConfiguration::load_from_toml("environment.toml")
        .unwrap_or_else(|err| {
            error!("{err}");
            die();
        });

    let Ok(database) = trigger_database::connect(&environment.database).await else {
        die();
    };

    let network_mgr =
        ServerNetworkManager::new(SERVER_TYPE, CONFIG.node.server_id, &environment.servers);

    let connection_mgr = ConnectionManager::new(CONFIG.node.server_id);
    let state = APP_STATE.get_or_init(|| AppState {
        environment,
        connection_mgr,
        network_mgr,
        database,
    });

    state
        .network_mgr
        .start_listener(state, handlers::server::handle_message)
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
        });

    let message_handler = MessageHandler::new(state);
    if let Err(err) = net::serve(CONFIG.network.tcp_addr, state, message_handler).await {
        error!(
            "failed to serve at tcp://{}. Is another instance of server already running? Error: {}",
            CONFIG.network.tcp_addr, err
        );
        die();
    }

    ExitCode::SUCCESS
}
