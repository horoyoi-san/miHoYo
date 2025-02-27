use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod fairy_module {
    pub async fn on_get_fairy_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetFairyDataCsReq,
    ) -> GetFairyDataScRsp {
        GetFairyDataScRsp {
            retcode: 0,
            data: Some(FairyData::default()),
        }
    }
}
