#![feature(let_chains)]
use anyhow::Result;

mod logging;
mod net;
mod tools;
mod util;

use logging::init_tracing;
use net::gateway::Gateway;

#[tokio::main]
async fn main() -> Result<()> {
    init_tracing();
    let mut gateway = Gateway::new("0.0.0.0", 23301).await?;
    Box::pin(gateway.listen()).await
}
