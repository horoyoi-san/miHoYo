use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod shop_module {
    pub async fn on_get_fashion_store_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetFashionStoreDataCsReq,
    ) -> GetFashionStoreDataScRsp {
        GetFashionStoreDataScRsp {
            retcode: 0,
            data: Some(FashionStoreData::default()),
        }
    }

    pub async fn on_get_shopping_mall_info(
        _context: &mut MessageContext<'_, '_>,
        _request: GetShoppingMallInfoCsReq,
    ) -> GetShoppingMallInfoScRsp {
        GetShoppingMallInfoScRsp {
            retcode: 0,
            shopping_mall_info: Some(ShoppingMallInfo::default()),
        }
    }

    pub async fn on_recharge_get_item_list(
        _context: &mut MessageContext<'_, '_>,
        _request: RechargeGetItemListCsReq,
    ) -> RechargeGetItemListScRsp {
        RechargeGetItemListScRsp { retcode: 0 }
    }
}
