use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod arcade_module {
    pub async fn on_get_arcade_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetArcadeDataCsReq,
    ) -> GetArcadeDataScRsp {
        GetArcadeDataScRsp { retcode: 0 }
    }
}
