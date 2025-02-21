use byteorder::{BigEndian, ByteOrder};
use rand_mt::Mt64;

pub mod mhy;
pub mod rsa;

pub fn gen_xorpad(seed: u64) -> [u8; 4096] {
    let mut buf = [0u8; 4096];
    let mut rng = Mt64::new(seed);
    (0..(buf.len() >> 3)).for_each(|i| BigEndian::write_u64(&mut buf[i * 8..], rng.next_u64()));

    buf
}
