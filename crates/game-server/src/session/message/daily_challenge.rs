use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod daily_challenge_module {
    pub async fn on_get_daily_challenge_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetDailyChallengeDataCsReq,
    ) -> GetDailyChallengeDataScRsp {
        GetDailyChallengeDataScRsp {
            retcode: 0,
            data: Some(DailyChallengeData::default()),
        }
    }
}
