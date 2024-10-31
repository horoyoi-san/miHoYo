use super::{MhyContext, MhyModule, ModuleType};
use anyhow::Result;
use ilhook::x64::Registers;

pub struct Misc;

const SET_CUSTOM_PROPERTY_FLOAT: usize = 0x12199F0;

impl MhyModule for MhyContext<Misc> {
    unsafe fn init(&mut self) -> Result<()> {
        // Dither
        self.interceptor.replace(
            self.assembly_base + SET_CUSTOM_PROPERTY_FLOAT,
            set_custom_property_float_replacement,
        )
    }

    unsafe fn de_init(&mut self) -> Result<()> {
        Ok(())
    }

    fn get_module_type(&self) -> super::ModuleType {
        ModuleType::Misc
    }
}

unsafe extern "win64" fn set_custom_property_float_replacement(
    _: *mut Registers,
    _: usize,
    _: usize,
) -> usize {
    0
}
