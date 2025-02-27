use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod bangboo_module {
    pub async fn on_get_buddy_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetBuddyDataCsReq,
    ) -> GetBuddyDataScRsp {
        GetBuddyDataScRsp { retcode: 0 }
    }
}
