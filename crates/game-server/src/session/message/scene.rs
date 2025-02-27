use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod scene_module {
    use tracing::debug;
    use trigger_logic::scene::ESceneType;

    use crate::logic::scene_util;

    pub async fn on_enter_world(context: &mut MessageContext<'_, '_>, _request: EnterWorldCsReq) {
        let scene_model = &mut context.player.scene_model;

        let scene_to_enter = match scene_model.get_current_scene().await {
            Some(current_scene)
                if scene_util::persists_on_relogin(
                    ESceneType::try_from(current_scene.scene_type).unwrap(),
                ) =>
            {
                Some(current_scene)
            }
            _ => scene_model.get_default_scene().await,
        };

        let scene_to_enter = if scene_to_enter.is_none() {
            // TODO: first scene to be created should be the 'Fresh' scene (beginner procedure)
            debug!(
                "player with uid {} has no scene to enter, default hall scene will be created",
                context.session.player_uid
            );

            let scene = scene_model.create_scene_info(ESceneType::Hall).await;
            scene_model.set_default_scene(&scene).await;

            scene
        } else {
            scene_to_enter.unwrap()
        };

        context
            .session
            .change_game_state(
                context.request_id,
                EnterWorldScRsp { retcode: 0 },
                context
                    .player
                    .build_state_reentrant_data(&scene_to_enter)
                    .unwrap(),
                &scene_to_enter,
                context.player,
                false,
            )
            .await;

        context.player.scene_model.clear_abandoned_scenes().await;
    }

    pub async fn on_post_enter_world(
        _context: &mut MessageContext<'_, '_>,
        _request: PostEnterWorldCsReq,
    ) -> PostEnterWorldScRsp {
        PostEnterWorldScRsp { retcode: 0 }
    }

    pub async fn on_scene_transition(
        _context: &mut MessageContext<'_, '_>,
        request: SceneTransitionCsReq,
    ) -> SceneTransitionScRsp {
        debug!("{request:?}");

        SceneTransitionScRsp { retcode: 0 }
    }

    pub async fn on_enter_section_complete(
        _context: &mut MessageContext<'_, '_>,
        _request: EnterSectionCompleteCsReq,
    ) -> EnterSectionCompleteScRsp {
        EnterSectionCompleteScRsp { retcode: 0 }
    }

    pub async fn on_refresh_section(
        _context: &mut MessageContext<'_, '_>,
        _request: RefreshSectionCsReq,
    ) -> RefreshSectionScRsp {
        RefreshSectionScRsp {
            retcode: 0,
            refresh_status: 0,
        }
    }

    pub async fn on_leave_cur_scene(
        context: &mut MessageContext<'_, '_>,
        _request: LeaveCurSceneCsReq,
    ) {
        if let Some(scene_uid) = context.session.get_cur_scene_uid() {
            context.player.scene_model.on_leave_scene(scene_uid).await;
        }

        let default_scene = context
            .player
            .scene_model
            .get_default_scene()
            .await
            .unwrap();

        context
            .session
            .change_game_state(
                context.request_id,
                LeaveCurSceneScRsp { retcode: 0 },
                context
                    .player
                    .build_state_reentrant_data(&default_scene)
                    .unwrap(),
                &default_scene,
                context.player,
                false,
            )
            .await;
    }

    pub async fn on_active_hollow_check_point(
        _context: &mut MessageContext<'_, '_>,
        request: ActiveHollowCheckPointCsReq,
    ) -> ActiveHollowCheckPointScRsp {
        // TODO: forward it to battle-server and actually handle

        debug!("{:?}", request.check_point);
        ActiveHollowCheckPointScRsp { retcode: 0 }
    }
}
