use std::borrow::Cow;

use axum::{
    extract::{Query, State},
    routing::get,
    Json, Router,
};
use serde::{Deserialize, Serialize};
use tokio::net::TcpListener;
use tracing::info;
use trigger_sv::{
    gm_command::{GMCommand, GMInput},
    message::PlayerGmCommandMessage,
    net::ServerType,
};

use crate::AppState;

pub async fn serve(state: &'static AppState) -> std::io::Result<()> {
    let listener = TcpListener::bind(state.config.http_addr).await?;
    let router = Router::new()
        .route("/api/gm", get(gm_api))
        .with_state(state);

    info!("HTTP API is listening at http://{}", state.config.http_addr);

    tokio::spawn(async move {
        axum::serve(listener, router.into_make_service())
            .await
            .expect("axum::serve failed");
    });

    Ok(())
}

#[derive(Serialize)]
struct Response {
    pub retcode: i32,
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message: Option<Cow<'static, str>>,
}

#[derive(Deserialize, Debug)]
struct GmQuery {
    pub player_uid: u32,
    pub command: String,
    pub token: String,
}

async fn gm_api(
    Query(query): Query<GmQuery>,
    State(state): State<&'static AppState>,
) -> Json<Response> {
    if !state.config.tokens.contains(&query.token) {
        return Json(Response {
            retcode: 1,
            message: Some(Cow::Borrowed("invalid GM token")),
        });
    }

    let command = match GMCommand::from_str(&query.command) {
        Ok(command) => command,
        Err(err) => {
            return Json(Response {
                retcode: 2,
                message: Some(Cow::Owned(format!("invalid command format: {err}"))),
            })
        }
    };

    state
        .network_mgr
        .send_to(
            ServerType::GameServer,
            0,
            PlayerGmCommandMessage {
                player_uid: query.player_uid,
                command,
            },
        )
        .await;

    Json(Response {
        retcode: 0,
        message: None,
    })
}
