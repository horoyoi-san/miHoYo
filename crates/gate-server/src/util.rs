use base64::Engine;

pub trait BinExt {
    fn to_base64(&self) -> String;
}

impl<T> BinExt for T
where
    T: AsRef<[u8]>,
{
    fn to_base64(&self) -> String {
        base64::engine::general_purpose::STANDARD.encode(self)
    }
}
