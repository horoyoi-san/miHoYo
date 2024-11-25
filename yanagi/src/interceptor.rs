use ilhook::x64::{
    CallbackOption, HookFlags, HookPoint, HookType, Hooker, JmpBackRoutine, RetnRoutine,
};

#[derive(Default)]
pub struct Interceptor {
    hooks: Vec<HookPoint>,
}

type Result<T> = std::result::Result<T, ilhook::HookError>;
impl Interceptor {
    pub unsafe fn attach(&mut self, addr: usize, routine: JmpBackRoutine) -> Result<()> {
        let hooker = Hooker::new(
            addr,
            HookType::JmpBack(routine),
            CallbackOption::None,
            0,
            HookFlags::empty(),
        );

        let hook_point = hooker.hook()?;
        self.hooks.push(hook_point);

        Ok(())
    }

    #[expect(dead_code)]
    pub unsafe fn replace(&mut self, addr: usize, routine: RetnRoutine) -> Result<()> {
        let hooker = Hooker::new(
            addr,
            HookType::Retn(routine),
            CallbackOption::None,
            0,
            HookFlags::empty(),
        );

        let hook_point = hooker.hook()?;
        self.hooks.push(hook_point);

        Ok(())
    }
}
