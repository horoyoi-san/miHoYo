use std::ffi::CString;

use ilhook::x64::Registers;

use crate::{
    interceptor::Interceptor,
    util::{import, read_csharp_string, GAME_ASSEMBLY_BASE},
};

import!(rsa_create() -> usize = 0x163AEC10);
import!(rsa_from_xml_string(instance: usize, xml_string: usize) -> usize = 0x163AEE50);
import!(il2cpp_string_new(cstr: *const u8) -> usize = 0x72540);

pub unsafe fn initialize_rsa_public_key() {
    const SERVER_PUBLIC_KEY: &str = include_str!("../../server_public_key.xml");
    let rsa_public_key_backdoor_field =
        ((*(GAME_ASSEMBLY_BASE.wrapping_add(0x44949B0) as *const usize)) + 204776) as *mut usize;

    let rsa = rsa_create();
    rsa_from_xml_string(
        rsa,
        il2cpp_string_new(
            CString::new(SERVER_PUBLIC_KEY)
                .unwrap()
                .to_bytes_with_nul()
                .as_ptr(),
        ),
    );

    *rsa_public_key_backdoor_field = rsa;
}

pub unsafe fn replace_sdk_public_key_string_literal() {
    const SDK_PUBLIC_KEY: &str = include_str!("../../sdk_public_key.xml");

    *(GAME_ASSEMBLY_BASE.wrapping_add(0x475FB40) as *mut usize) = il2cpp_string_new(
        CString::new(SDK_PUBLIC_KEY)
            .unwrap()
            .to_bytes_with_nul()
            .as_ptr(),
    ) as usize;
}

pub unsafe fn monitor_network_state(interceptor: &mut Interceptor) {
    interceptor
        .attach(
            GAME_ASSEMBLY_BASE.wrapping_add(0xA27D650),
            on_network_state_change,
        )
        .unwrap();

    interceptor
        .attach(
            GAME_ASSEMBLY_BASE.wrapping_add(0x97DA670),
            download_data_slave,
        )
        .unwrap();
}

unsafe extern "win64" fn download_data_slave(reg: *mut Registers, _: usize) {
    let data = read_csharp_string((*reg).rcx as usize);
    println!("{data}");
}

unsafe extern "win64" fn on_network_state_change(reg: *mut Registers, _: usize) {
    let net_state = NetworkState::from((*reg).rcx);
    println!("network state change: {net_state:?}");

    if net_state == NetworkState::PlayerLoginCsReq {
        // public key rsa gets reset to null after successful PlayerGetTokenScRsp
        initialize_rsa_public_key();
    }
}

#[repr(u64)]
#[derive(num_enum::FromPrimitive, Debug, Default, PartialEq)]
pub enum NetworkState {
    CloudCmdLine = 21,
    CloudDispatch = 20,
    StartBasicsReq = 17,
    LoadShaderEnd = 9,
    PlayerLoginCsReq = 15,
    EndBasicsReq = 18,
    LoadResourcesEnd = 10,
    GlobalDispatch = 1,
    ConnectGameServer = 12,
    ChooseServer = 2,
    DoFileVerifyEnd = 7,
    PlayerLoginScRsp = 16,
    DispatchResult = 4,
    PlayerGetTokenScRsp = 14,
    DownloadResourcesEnd = 6,
    AccountLogin = 3,
    LoadAssetEnd = 8,
    StartEnterGameWorld = 11,
    #[default]
    None = 0,
    EnterWorldScRsp = 19,
    PlayerGetTokenCsReq = 13,
    StartDownLoad = 5,
}
