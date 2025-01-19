use sr_proto::pb::{GetSceneMapInfoCsReq, GetSceneMapInfoScRsp, SceneMapInfo};
use sr_proto::{MsgTrait, dec};

pub async fn handle(req: &[u8]) -> Vec<u8> {
    let req = dec!(GetSceneMapInfoCsReq, req);

    GetSceneMapInfoScRsp {
        scene_map_info: req
            .entry_id_list
            .iter()
            .map(|i| SceneMapInfo {
                entry_id: *i,
                ..Default::default()
            })
            .collect(),
        ..Default::default()
    }
    .encode_to_vec()
}
