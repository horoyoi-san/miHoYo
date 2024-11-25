use std::ffi::CString;

use std::ptr::null_mut;
use windows::core::{s, PCSTR, PSTR};
use windows::Win32::Foundation::{CloseHandle, GetLastError, HANDLE};
use windows::Win32::System::Diagnostics::Debug::WriteProcessMemory;
use windows::Win32::System::LibraryLoader::{GetModuleHandleA, GetProcAddress};
use windows::Win32::System::Memory::{
    VirtualAllocEx, VirtualFreeEx, MEM_COMMIT, MEM_RELEASE, MEM_RESERVE, PAGE_READWRITE,
};
use windows::Win32::System::Threading::{
    CreateProcessA, CreateRemoteThread, ResumeThread, WaitForSingleObject, CREATE_SUSPENDED,
    PROCESS_INFORMATION, STARTUPINFOA,
};

const GAME_EXECUTABLE: PCSTR = s!("ZenlessZoneZeroBeta.exe");
const INJECT_DLL: &str = "ext.dll";

fn inject_standard(h_target: HANDLE, dll_path: &str) -> bool {
    unsafe {
        let loadlib = GetProcAddress(
            GetModuleHandleA(s!("kernel32.dll")).unwrap(),
            s!("LoadLibraryA"),
        )
        .unwrap();

        let dll_path_cstr = CString::new(dll_path).unwrap();
        let dll_path_addr = VirtualAllocEx(
            h_target,
            None,
            dll_path_cstr.to_bytes_with_nul().len(),
            MEM_COMMIT | MEM_RESERVE,
            PAGE_READWRITE,
        );

        if dll_path_addr.is_null() {
            println!("VirtualAllocEx failed. Last error: {:?}", GetLastError());
            return false;
        }

        WriteProcessMemory(
            h_target,
            dll_path_addr,
            dll_path_cstr.as_ptr() as _,
            dll_path_cstr.to_bytes_with_nul().len(),
            None,
        )
        .unwrap();

        let h_thread = CreateRemoteThread(
            h_target,
            None,
            0,
            Some(std::mem::transmute(loadlib)),
            Some(dll_path_addr),
            0,
            None,
        )
        .unwrap();

        WaitForSingleObject(h_thread, 0xFFFFFFFF);

        VirtualFreeEx(h_target, dll_path_addr, 0, MEM_RELEASE).unwrap();
        CloseHandle(h_thread).unwrap();
        true
    }
}

fn main() {
    let current_dir = std::env::current_dir().unwrap();
    let dll_path = current_dir.join(INJECT_DLL);
    if !dll_path.is_file() {
        println!("{INJECT_DLL} not found");
        return;
    }

    let mut proc_info = PROCESS_INFORMATION::default();
    let mut startup_info = STARTUPINFOA::default();

    unsafe {
        CreateProcessA(
            GAME_EXECUTABLE,
            PSTR(null_mut()),
            None,
            None,
            false,
            CREATE_SUSPENDED,
            None,
            None,
            &mut startup_info,
            &mut proc_info,
        )
        .unwrap();

        if inject_standard(proc_info.hProcess, dll_path.to_str().unwrap()) {
            ResumeThread(proc_info.hThread);
        }

        CloseHandle(proc_info.hThread).unwrap();
        CloseHandle(proc_info.hProcess).unwrap();
    }
}
