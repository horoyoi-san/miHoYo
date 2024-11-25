use std::marker::PhantomData;

use crate::{interceptor::Interceptor, util};

pub mod crypto;
pub mod network;

#[derive(thiserror::Error, Debug)]
pub enum ModuleInitError {
    #[error("{0}")]
    HookFail(#[from] ilhook::HookError),
}

pub struct NapModuleContext<T> {
    base: usize,
    interceptor: Interceptor,
    _module_type: PhantomData<T>,
}

impl<T> NapModuleContext<T> {
    fn new(base: usize) -> Self {
        Self {
            base,
            interceptor: Interceptor::default(),
            _module_type: PhantomData,
        }
    }
}

pub trait NapModule {
    unsafe fn init(&mut self) -> Result<(), ModuleInitError>;
}

#[derive(Default)]
pub struct NapModuleManager {
    modules: Vec<Box<dyn NapModule>>,
}

impl NapModuleManager {
    pub fn add<T: 'static>(&mut self)
    where
        NapModuleContext<T>: NapModule,
    {
        self.modules.push(Box::new(NapModuleContext::<T>::new(
            *util::GAME_ASSEMBLY_BASE,
        )));
    }

    pub unsafe fn init(&mut self) -> Result<(), ModuleInitError> {
        for module in self.modules.iter_mut() {
            module.init()?;
        }

        Ok(())
    }
}
