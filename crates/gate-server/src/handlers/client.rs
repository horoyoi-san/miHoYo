use base64::Engine;
use rand::RngCore;
use tracing::{debug, error, info, warn};
use trigger_protobuf::{
    CmdID, KeepAliveNotify, PacketHead, PlayerGetTokenCsReq, PlayerGetTokenScRsp, PlayerLoginCsReq,
    ProtobufMessage, XorFields,
};
use trigger_sv::{
    config::RsaSetting,
    message::{BindClientSessionMessage, ForwardClientProtocolMessage},
    net::ServerType,
};

use crate::{
    net::{Connection, NetPacket},
    session::SessionState,
    util::BinExt,
    AppState,
};

pub async fn handle_message(connection: &Connection, state: &'static AppState, packet: NetPacket) {
    let head = packet.decode_head();
    match packet.cmd_id {
        PlayerGetTokenCsReq::CMD_ID => {
            on_player_get_token(
                connection,
                state,
                PlayerGetTokenCsReq::decode(&*packet.body).unwrap_or_default(),
            )
            .await
        }
        PlayerLoginCsReq::CMD_ID => {
            on_player_login(
                connection,
                state,
                PlayerLoginCsReq::decode(&*packet.body).unwrap_or_default(),
            )
            .await
        }
        KeepAliveNotify::CMD_ID => {
            on_keep_alive(
                connection,
                state,
                KeepAliveNotify::decode(&*packet.body).unwrap_or_default()
            ).await
        }
        cmd_id if connection.session.is_logged_in() => {
            match trigger_protobuf::pb_to_common_protocol_unit(cmd_id, &packet.body) {
                Ok(Some(unit)) => state.network_mgr.send_to(ServerType::GameServer, 0, ForwardClientProtocolMessage {
                    session_id: connection.session.id,
                    request_id: head.packet_id,
                    message: unit,
                }).await,
                Ok(None) => warn!("ignoring message with unknown cmd_id: {cmd_id}"),
                Err(err) => error!(
                    "failed to decode a message with cmd_id: {} from {} (player_uid: {}), error: {}",
                    cmd_id, connection.addr(), connection.session.player_uid(), err
                ),
            }
        }
        unknown => warn!("received unknown cmd_id and not yet logged in: {unknown}"),
    }
}

async fn on_keep_alive(
    connection: &Connection,
    _state: &'static AppState,
    _notify: KeepAliveNotify,
) {
    connection.session.refresh_keep_alive_time();
}

async fn on_player_login(
    connection: &Connection,
    state: &'static AppState,
    mut req: PlayerLoginCsReq,
) {
    if connection.session.state() != SessionState::Login {
        return;
    }

    req.xor_fields();

    // TODO: check client capabilities. Asset version and etc.
    info!("PlayerLogin: {req:?}");

    state
        .network_mgr
        .send_to(
            ServerType::GameServer,
            0,
            BindClientSessionMessage {
                session_id: connection.session.id,
                player_uid: connection.session.player_uid(),
            },
        )
        .await;
}

async fn on_player_get_token(
    connection: &Connection,
    state: &'static AppState,
    mut req: PlayerGetTokenCsReq,
) {
    if connection.session.state() != SessionState::GetToken {
        return;
    }

    req.xor_fields();
    info!(
        "PlayerGetToken: account_uid: {}, rsa_ver: {}, client_rand_key: {}",
        req.account_uid, req.rsa_ver, req.client_rand_key
    );

    let Some(rsa) = state
        .environment
        .security
        .get_rsa_setting_by_version(req.rsa_ver)
    else {
        debug!(
            "client from {} (account_uid: {}) tries to login with unsupported rsa version ({})",
            connection.addr(),
            req.account_uid,
            req.rsa_ver
        );
        login_failed!(connection, PlayerGetTokenScRsp, 1);
        return;
    };

    let Some(client_rand_key) = decrypt_client_rand_key(&req.client_rand_key, rsa) else {
        debug!(
            "failed to decrypt client_rand_key given by peer at {} (account_uid: {})",
            connection.addr(),
            req.account_uid
        );
        login_failed!(connection, PlayerGetTokenScRsp, 1);
        return;
    };

    let server_rand_key = rand::thread_rng().next_u64();
    connection.set_secret_key(client_rand_key ^ server_rand_key);

    let server_rand_key = server_rand_key.to_le_bytes();

    // TODO: account_uid-token pair verification via http request to sdk.

    let Some(player_uid) = fetch_player_uid(state, &req.account_uid).await else {
        login_failed!(connection, PlayerGetTokenScRsp, 1);
        return;
    };

    connection.session.on_player_get_token_ok(player_uid);
    connection
        .send_pb(
            PacketHead::default(),
            PlayerGetTokenScRsp {
                uid: player_uid,
                server_rand_key: trigger_cryptography::rsa::encrypt(
                    &rsa.client_public_key,
                    &server_rand_key,
                )
                .to_base64(),
                sign: trigger_cryptography::rsa::sign(&rsa.server_private_key, &server_rand_key)
                    .to_base64(),
                ..Default::default()
            },
        )
        .await;
}

async fn fetch_player_uid(state: &'static AppState, account_uid: &str) -> Option<u32> {
    use trigger_database::entity::*;
    use trigger_database::prelude::*;

    match account_uid::Entity::find()
        .filter(account_uid::Column::AccountUid.eq(account_uid))
        .one(&state.database)
        .await
    {
        Ok(Some(uid)) => return Some(uid.player_uid as u32),
        Err(err) => {
            error!("account_uid::find() failed: {err}");
            return None;
        }
        Ok(None) => (),
    }

    match account_uid::Entity::insert(account_uid::ActiveModel {
        account_uid: Set(account_uid.to_string()),
        ..Default::default()
    })
    .exec(&state.database)
    .await
    {
        Ok(result) => Some(result.last_insert_id as u32),
        Err(err) => {
            error!("account_uid::insert() failed: {err}");
            None
        }
    }
}

fn decrypt_client_rand_key(client_rand_key: &str, rsa_setting: &RsaSetting) -> Option<u64> {
    let cipher = base64::engine::general_purpose::STANDARD
        .decode(client_rand_key)
        .ok()?;

    Some(u64::from_le_bytes(
        trigger_cryptography::rsa::decrypt(&rsa_setting.server_private_key, &cipher)?
            .try_into()
            .ok()?,
    ))
}

macro_rules! login_failed {
    ($conn:expr, $rsp:ident, $retcode:expr) => {
        $conn.session.set_login_failed();
        $conn
            .send_pb(
                PacketHead::default(),
                $rsp {
                    retcode: $retcode,
                    ..Default::default()
                },
            )
            .await;
    };
}

use login_failed;
