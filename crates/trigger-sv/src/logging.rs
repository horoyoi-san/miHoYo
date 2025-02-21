use tracing::Level;
use tracing_subscriber::EnvFilter;

const SQLX_ERROR_ONLY: &str = "sqlx=error";

pub fn init_tracing(log_level: Level) {
    // TODO: make it more configurable?
    let filter = EnvFilter::builder()
        .with_default_directive(log_level.into())
        .from_env()
        .unwrap()
        .add_directive(SQLX_ERROR_ONLY.parse().unwrap());

    tracing_subscriber::fmt()
        .with_ansi(true)
        .with_env_filter(filter)
        .compact()
        .init()
}
