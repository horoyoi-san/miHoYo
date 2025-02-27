use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod qa_game_module {
    pub async fn on_get_questions_answer_game_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetQuestionsAnswerGameDataCsReq,
    ) -> GetQuestionsAnswerGameDataScRsp {
        GetQuestionsAnswerGameDataScRsp { retcode: 0 }
    }
}
