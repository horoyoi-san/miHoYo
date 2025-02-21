use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod miniscape_entrust_module {
    pub async fn on_get_miniscape_entrust_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetMiniscapeEntrustDataCsReq,
    ) -> GetMiniscapeEntrustDataScRsp {
        GetMiniscapeEntrustDataScRsp { retcode: 0 }
    }
}
