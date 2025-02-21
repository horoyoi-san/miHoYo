use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod activity_module {
    pub async fn on_get_activity_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetActivityDataCsReq,
    ) -> GetActivityDataScRsp {
        GetActivityDataScRsp { retcode: 0 }
    }

    pub async fn on_get_web_activity_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetWebActivityDataCsReq,
    ) -> GetWebActivityDataScRsp {
        GetWebActivityDataScRsp { retcode: 0 }
    }
}
