use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod ramen_module {
    use tracing::debug;
    use trigger_logic::item::ItemStatic;

    pub async fn on_get_ramen_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetRamenDataCsReq,
    ) -> GetRamenDataScRsp {
        GetRamenDataScRsp {
            retcode: 0,
            ramen_data: Some(context.player.ramen_model.get_protocol_ramen_data()),
        }
    }

    pub async fn on_eat_ramen(
        context: &mut MessageContext<'_, '_>,
        request: EatRamenCsReq,
    ) -> EatRamenScRsp {
        debug!("{request:?}");

        let item_model = &mut context.player.item_model;
        let ramen_model = &mut context.player.ramen_model;

        let price = ramen_model.get_ramen_price(request.ramen);

        if item_model.has_enough_material(ItemStatic::FrontendGold.into(), price) {
            if let Some(ramen_sync) = ramen_model.try_eat_ramen(request.ramen).await {
                item_model
                    .use_material(ItemStatic::FrontendGold.into(), price)
                    .await;

                let material_list = item_model.get_protocol_material_list();

                context.add_notify(PlayerSyncScNotify {
                    ramen_sync: Some(ramen_sync),
                    item_sync: Some(ItemSync {
                        material_list,
                        ..Default::default()
                    }),
                    ..Default::default()
                });

                return EatRamenScRsp { retcode: 0 };
            }
        }

        EatRamenScRsp { retcode: 1 }
    }

    pub async fn on_del_new_ramen(
        _context: &mut MessageContext<'_, '_>,
        request: DelNewRamenCsReq,
    ) -> DelNewRamenScRsp {
        debug!("{request:?}");

        DelNewRamenScRsp { retcode: 0 }
    }
}
