use byteorder::{ReadBytesExt, WriteBytesExt, BE};
use std::collections::HashMap;
use std::io::{self, Read, Write};

pub trait Encodeable {
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()>;
    fn encoding_length(&self) -> usize;

    fn encode_to_vec(&self) -> Vec<u8> {
        let mut buf = Vec::with_capacity(self.encoding_length());
        self.encode(&mut std::io::Cursor::new(&mut buf)).unwrap();

        buf
    }
}

pub trait Decodeable: Sized {
    fn decode<R: Read>(r: &mut R) -> io::Result<Self>;
}

macro_rules! impl_primitives {
    ($($ty:ident),*) => {
        $(impl Encodeable for $ty {
            fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
                paste::paste!(w.[<write_ $ty>]::<BE>(*self))
            }

            fn encoding_length(&self) -> usize {
                $ty::BITS as usize / 8
            }
        }

        impl Decodeable for $ty {
            fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
                paste::paste!(r.[<read_ $ty>]::<BE>())
            }
        })*
    };
}

impl_primitives! {
    u16, u32, u64,
    i16, i32, i64
}

// u8
impl Encodeable for u8 {
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        w.write_u8(*self)
    }

    fn encoding_length(&self) -> usize {
        1
    }
}

impl Decodeable for u8 {
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        r.read_u8()
    }
}

// i8
impl Encodeable for i8 {
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        w.write_i8(*self)
    }

    fn encoding_length(&self) -> usize {
        1
    }
}

impl Decodeable for i8 {
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        r.read_i8()
    }
}

// bool
impl Encodeable for bool {
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        (*self as u8).encode(w)
    }

    fn encoding_length(&self) -> usize {
        1
    }
}

impl Decodeable for bool {
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        Ok(u8::decode(r)? != 0)
    }
}

// f32

impl Encodeable for f32 {
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        self.to_bits().encode(w)
    }

    fn encoding_length(&self) -> usize {
        4
    }
}

impl Decodeable for f32 {
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        Ok(Self::from_bits(Decodeable::decode(r)?))
    }
}

// f64

impl Encodeable for f64 {
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        self.to_bits().encode(w)
    }

    fn encoding_length(&self) -> usize {
        8
    }
}

impl Decodeable for f64 {
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        Ok(Self::from_bits(Decodeable::decode(r)?))
    }
}

// String
impl Encodeable for String {
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        (self.len() as u32).encode(w)?;
        w.write_all(self.as_bytes())
    }

    fn encoding_length(&self) -> usize {
        4 + self.len()
    }
}

impl Decodeable for String {
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        let length = u32::decode(r)?;
        let mut data = vec![0u8; length as usize];
        r.read_exact(&mut data)?;

        // TODO: maybe we want custom error type to combine io error and this one?
        Ok(String::from_utf8(data).expect("failed to decode string as UTF-8"))
    }
}

// Vec<T>
impl<T> Encodeable for Vec<T>
where
    T: Encodeable,
{
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        (self.len() as u32).encode(w)?;
        self.iter().try_for_each(|item| item.encode(w))
    }

    fn encoding_length(&self) -> usize {
        self.iter()
            .fold(4, |length, item| length + item.encoding_length())
    }
}

impl<T> Decodeable for Vec<T>
where
    T: Decodeable,
{
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        (0..u32::decode(r)?)
            .map(|_| T::decode(r))
            .collect::<Result<Vec<_>, _>>()
    }
}

// Option<T>
impl<T> Encodeable for Option<T>
where
    T: Encodeable,
{
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        self.is_some().encode(w)?;
        self.as_ref().map(|item| item.encode(w)).unwrap_or(Ok(()))
    }

    fn encoding_length(&self) -> usize {
        self.as_ref()
            .iter()
            .fold(1, |length, item| length + item.encoding_length())
    }
}

impl<T> Decodeable for Option<T>
where
    T: Decodeable,
{
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        (bool::decode(r)?).then(|| T::decode(r)).transpose()
    }
}

// HashMap<K, V>
impl<K, V> Encodeable for HashMap<K, V>
where
    K: Encodeable,
    V: Encodeable,
{
    fn encode<W: Write>(&self, w: &mut W) -> io::Result<()> {
        (self.len() as u32).encode(w)?;
        self.iter().try_for_each(|(k, v)| {
            k.encode(w)?;
            v.encode(w)
        })
    }

    fn encoding_length(&self) -> usize {
        self.iter()
            .fold((self.len() as u32).encoding_length(), |len, (k, v)| {
                len + k.encoding_length() + v.encoding_length()
            })
    }
}

impl<K, V> Decodeable for HashMap<K, V>
where
    K: Decodeable + Eq + std::hash::Hash,
    V: Decodeable,
{
    fn decode<R: Read>(r: &mut R) -> io::Result<Self> {
        let len = u32::decode(r)?;
        let mut map = HashMap::with_capacity(len as usize);
        for _ in 0..len {
            map.insert(K::decode(r)?, V::decode(r)?);
        }

        Ok(map)
    }
}
