use std::ffi::CString;

use ilhook::x64::Registers;

use crate::util::{self, import, read_csharp_string};

use super::{ModuleInitError, NapModule, NapModuleContext};

const MAKE_INITIAL_URL: usize = 0x605A190;

pub struct Network;

impl NapModule for NapModuleContext<Network> {
    unsafe fn init(&mut self) -> Result<(), ModuleInitError> {
        self.interceptor.attach(
            self.base.wrapping_add(MAKE_INITIAL_URL),
            Network::on_make_initial_url,
        )?;

        self.interceptor
            .attach(self.base.wrapping_add(0x17627E10), on_set_url)?;

        Ok(())
    }
}

unsafe extern "win64" fn on_set_url(reg: *mut Registers, _: usize) {
    let s = read_csharp_string((*reg).rcx as usize);
    if s.contains("StandaloneWindows64/cn/") {
        let s = s.replace("StandaloneWindows64/cn/", "StandaloneWindows64/oversea/");
        println!("replaced: {s}");
        (*reg).rcx =
            il2cpp_string_new(CString::new(s).unwrap().to_bytes_with_nul().as_ptr()) as u64;
    }
}

import!(il2cpp_string_new(cstr: *const u8) -> usize = 0x72540);

impl Network {
    const SDK_URL: &str = "http://127.0.0.1:10001";
    const DISPATCH_URL: &str = "http://127.0.0.1:10002";
    const REDIRECT_SDK: bool = true;
    const REDIRECT_DISPATCH: bool = true;

    unsafe extern "win64" fn on_make_initial_url(reg: *mut Registers, _: usize) {
        let url = util::read_csharp_string((*reg).rcx as usize);

        let mut new_url = match url.as_str() {
            s if (s.contains("mihoyo.com") || s.contains("hoyoverse.com"))
                && Self::REDIRECT_SDK =>
            {
                Self::SDK_URL.to_string()
            }
            s if (s.contains("globaldp-prod-os01.zenlesszonezero.com")
                || s.contains("globaldp-prod-cn01.juequling.com"))
                && Self::REDIRECT_DISPATCH =>
            {
                Self::DISPATCH_URL.to_string()
            }
            s => {
                println!("Leaving request as-is: {s}");
                return;
            }
        };

        url.split('/').skip(3).for_each(|s| {
            new_url.push_str("/");
            new_url.push_str(s);
        });

        println!("UnityWebRequest: \"{url}\", replacing with \"{new_url}\"");
        (*reg).rcx = il2cpp_string_new(
            CString::new(new_url.as_str())
                .unwrap()
                .to_bytes_with_nul()
                .as_ptr(),
        ) as u64;
    }
}
