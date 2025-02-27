use std::{
    process::ExitCode,
    sync::{LazyLock, OnceLock},
};

use axum::{routing::get, Router};
use config::DispatchConfig;
use tokio::net::TcpListener;
use tracing::error;
use trigger_sv::{
    config::{ServerEnvironmentConfiguration, TomlConfig},
    die, logging, print_banner,
};

mod config;
mod data;
mod ping;
mod query_dispatch;
mod query_gateway;

const CONFIG_FILE: &str = "dispatch.toml";

#[derive(Clone)]
struct AppState {
    pub config: &'static DispatchConfig,
    pub environment: &'static ServerEnvironmentConfiguration,
}

#[tokio::main]
async fn main() -> ExitCode {
    static APP_STATE: OnceLock<AppState> = OnceLock::new();
    static ENVIRONMENT: LazyLock<ServerEnvironmentConfiguration> = LazyLock::new(|| {
        ServerEnvironmentConfiguration::load_from_toml("environment.toml").unwrap_or_else(|err| {
            error!("{err}");
            die();
        })
    });
    static CONFIG: LazyLock<DispatchConfig> =
        LazyLock::new(|| DispatchConfig::load_or_create(CONFIG_FILE));

    print_banner();
    logging::init_tracing(tracing::Level::DEBUG);

    let state = APP_STATE.get_or_init(|| AppState {
        config: &CONFIG,
        environment: &ENVIRONMENT,
    });

    let app = Router::new()
        .route(ping::ROUTE_ENDPOINT, get(ping::process))
        .route(query_dispatch::ROUTE_ENDPOINT, get(query_dispatch::process))
        .route(query_gateway::ROUTE_ENDPOINT, get(query_gateway::process))
        .with_state(state);

    let Ok(listener) = TcpListener::bind(CONFIG.network.http_addr).await.inspect_err(|err| {
        error!("TcpListener::bind failed. Is another instance of the server already running? Error: {err}");
    }) else {
        die();
    };

    axum::serve(listener, app).await.unwrap_or_else(|err| {
        error!("axum::serve failed: {err}");
        die();
    });

    ExitCode::SUCCESS
}
