use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod vhs_store_module {
    pub async fn on_get_vhs_store_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetVhsStoreDataCsReq,
    ) -> GetVhsStoreDataScRsp {
        GetVhsStoreDataScRsp {
            retcode: 0,
            data: Some(VhsStoreData::default()),
        }
    }
}
