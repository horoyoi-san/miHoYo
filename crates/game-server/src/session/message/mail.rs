use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod mail_module {
    pub async fn on_get_player_mails(
        _context: &mut MessageContext<'_, '_>,
        _request: GetPlayerMailsCsReq,
    ) -> GetPlayerMailsScRsp {
        GetPlayerMailsScRsp { retcode: 0 }
    }
}
