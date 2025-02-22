use std::{
    process::ExitCode,
    sync::{LazyLock, OnceLock},
};

use axum::Router;
use config::SdkConfig;
use database::DbContext;
use handlers::{combo_granter, mdk_shield_api, register, risky_api};
use tokio::net::TcpListener;
use tracing::error;

mod config;
mod database;
mod handlers;
mod util;

struct AppState {
    db: DbContext,
    #[expect(dead_code)]
    config: &'static SdkConfig,
}

type AppStateRef = &'static AppState;

#[tokio::main]
async fn main() -> ExitCode {
    static CONFIG: LazyLock<SdkConfig> =
        LazyLock::new(|| config::load_or_create("sdk_server.toml"));
    static STATE: OnceLock<AppState> = OnceLock::new();

println!("
██╗  ██╗ ██████╗ ██████╗  ██████╗ ██╗   ██╗ ██████╗ ██╗      ███████╗ █████╗ ███╗   ██╗
██║  ██║██╔═══██╗██╔══██╗██╔═══██╗╚██╗ ██╔╝██╔═══██╗██║      ██╔════╝██╔══██╗████╗  ██║
███████║██║   ██║██████╔╝██║   ██║ ╚████╔╝ ██║   ██║██║█████╗███████╗███████║██╔██╗ ██║
██╔══██║██║   ██║██╔══██╗██║   ██║  ╚██╔╝  ██║   ██║██║╚════╝╚════██║██╔══██║██║╚██╗██║
██║  ██║╚██████╔╝██║  ██║╚██████╔╝   ██║   ╚██████╔╝██║      ███████║██║  ██║██║ ╚████║
╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝ ╚═════╝    ╚═╝    ╚═════╝ ╚═╝      ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝
");
    init_tracing();
    let db = match DbContext::connect(&CONFIG.db_file).await {
        Ok(db) => db,
        Err(err) => {
            error!("Failed to open SQLite database. Error: {err}");
            return ExitCode::FAILURE;
        }
    };

    let _ = STATE.set(AppState {
        db,
        config: &CONFIG,
    });

    let router = Router::new()
        .merge(risky_api::routes())
        .merge(register::routes())
        .merge(mdk_shield_api::routes())
        .merge(combo_granter::routes())
        .with_state(STATE.get().unwrap());

    let listener = TcpListener::bind(&CONFIG.http_addr)
        .await
        .expect("TcpListener::bind failed. Is another instance of this server already running?");

    axum::serve(listener, router).await.unwrap();

    ExitCode::SUCCESS
}

fn init_tracing() {
    tracing_subscriber::fmt().without_time().init();
}
