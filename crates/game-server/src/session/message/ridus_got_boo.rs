use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod ridus_got_module {
    pub async fn on_get_ridus_got_boo_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetRidusGotBooDataCsReq,
    ) -> GetRidusGotBooDataScRsp {
        GetRidusGotBooDataScRsp { retcode: 0 }
    }
}
