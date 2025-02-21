use super::MessageContext;
use trigger_codegen::handlers;

#[handlers]
mod photo_wall_module {
    pub async fn on_get_photo_wall_data(
        _context: &mut MessageContext<'_, '_>,
        _request: GetPhotoWallDataCsReq,
    ) -> GetPhotoWallDataScRsp {
        GetPhotoWallDataScRsp { retcode: 0 }
    }
}
