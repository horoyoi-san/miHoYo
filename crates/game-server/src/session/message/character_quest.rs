use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod character_quest_module {
    pub async fn on_get_character_quest_list(
        _context: &mut MessageContext<'_, '_>,
        _request: GetCharacterQuestListCsReq,
    ) -> GetCharacterQuestListScRsp {
        GetCharacterQuestListScRsp { retcode: 0 }
    }
}
