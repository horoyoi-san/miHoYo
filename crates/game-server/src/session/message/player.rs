use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod player_module {
    use tracing::debug;
    use trigger_sv::{net::ServerType, time_util};

    use crate::logic::avatar_util;

    pub async fn on_get_player_basic_info(
        context: &mut MessageContext<'_, '_>,
        _request: GetPlayerBasicInfoCsReq,
    ) -> GetPlayerBasicInfoScRsp {
        GetPlayerBasicInfoScRsp {
            retcode: 0,
            basic_info: Some(context.player.get_protocol_player_basic_info()),
        }
    }

    pub async fn on_get_server_timestamp(
        _context: &mut MessageContext<'_, '_>,
        _request: GetServerTimestampCsReq,
    ) -> GetServerTimestampScRsp {
        GetServerTimestampScRsp {
            retcode: 0,
            utc_offset: 3, // TODO
            timestamp: time_util::cur_timestamp_seconds() as u64,
        }
    }

    pub async fn on_get_player_transaction(
        context: &mut MessageContext<'_, '_>,
        _request: GetPlayerTransactionCsReq,
    ) -> GetPlayerTransactionScRsp {
        GetPlayerTransactionScRsp {
            retcode: 0,
            transaction: format!("{}-{}", context.session.player_uid, 100),
        }
    }

    pub async fn on_get_authkey(
        context: &mut MessageContext<'_, '_>,
        request: GetAuthkeyCsReq,
    ) -> GetAuthkeyScRsp {
        debug!("{request:?}");

        let offline_verify_value = context.session.calc_offline_verify_value(0);
        if request.offline_verify_value != offline_verify_value {
            debug!(
                "offline verify value mismatch! Expected: {}, got: {}",
                offline_verify_value, request.offline_verify_value
            );
            return GetAuthkeyScRsp {
                retcode: 1,
                ..Default::default()
            };
        }

        GetAuthkeyScRsp {
            retcode: 0,
            auth_appid: request.auth_appid,
            authkey_ver: request.authkey_ver,
            authkey: String::from("TODO_Authkey"),
        }
    }

    pub async fn on_switch_role(
        context: &mut MessageContext<'_, '_>,
        request: SwitchRoleCsReq,
    ) -> SwitchRoleScRsp {
        if avatar_util::is_player_avatar(request.player_avatar_id)
            && (avatar_util::is_player_avatar(request.control_avatar_id)
                || context
                    .player
                    .role_model
                    .is_avatar_unlocked(request.control_avatar_id))
        {
            context
                .player
                .set_control_avatars(request.player_avatar_id, request.control_avatar_id)
                .await;

            // hall-server also should know controlled avatar
            // (for predicates in EventGraph such as 'Share.CConfigEventByMainCharacter')
            context
                .session
                .forward_client_message(request, ServerType::HallServer, 0)
                .await;

            context.add_notify(PlayerSyncScNotify {
                basic_info: Some(context.player.get_protocol_player_basic_info()),
                ..Default::default()
            });

            SwitchRoleScRsp { retcode: 0 }
        } else {
            debug!("invalid avatars specified: {request:?}");
            SwitchRoleScRsp { retcode: 1 }
        }
    }

    pub async fn on_player_logout(
        context: &mut MessageContext<'_, '_>,
        _request: PlayerLogoutCsReq,
    ) -> PlayerLogoutScRsp {
        context.session.unbind_all_servers(true).await;

        PlayerLogoutScRsp { retcode: 0 }
    }
}
