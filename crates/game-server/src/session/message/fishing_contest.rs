use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod fishing_contest_module {
    pub async fn on_get_fishing_contest_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetFishingContestDataCsReq,
    ) -> GetFishingContestDataScRsp {
        GetFishingContestDataScRsp { retcode: 0 }
    }
}
