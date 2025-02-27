use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod cafe_module {
    use tracing::debug;
    use trigger_logic::item::ItemStatic;

    pub async fn on_get_cafe_data(
        context: &mut MessageContext<'_, '_>,
        _request: GetCafeDataCsReq,
    ) -> GetCafeDataScRsp {
        GetCafeDataScRsp {
            retcode: 0,
            cafe_data: Some(context.player.cafe_model.get_protocol_cafe_data()),
        }
    }

    pub async fn on_drink_cafe(
        context: &mut MessageContext<'_, '_>,
        request: DrinkCafeCsReq,
    ) -> DrinkCafeScRsp {
        debug!("{request:?}");

        let item_model = &mut context.player.item_model;
        let cafe_model = &mut context.player.cafe_model;

        let price = cafe_model.get_cafe_item_price(request.cafe_item_id);

        if item_model.has_enough_material(ItemStatic::FrontendGold.into(), price) {
            if let Some((add_energy, cafe_sync)) =
                cafe_model.try_drink_cafe(request.cafe_item_id).await
            {
                item_model.add_energy(add_energy).await;
                item_model
                    .use_material(ItemStatic::FrontendGold.into(), price)
                    .await;

                // TODO: RewardBuff

                let material_list = item_model.get_protocol_material_list();

                context.add_notify(PlayerSyncScNotify {
                    cafe_sync: Some(cafe_sync),
                    item_sync: Some(ItemSync {
                        material_list,
                        ..Default::default()
                    }),
                    ..Default::default()
                });

                return DrinkCafeScRsp { retcode: 0 };
            }
        }

        DrinkCafeScRsp { retcode: 1 }
    }
}
