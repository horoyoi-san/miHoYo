use rsa::{
    pkcs1v15::SigningKey, sha2::Sha256, signature::RandomizedSigner, Pkcs1v15Encrypt,
    RsaPrivateKey, RsaPublicKey,
};

const RSA_CHUNK_SIZE: usize = 117;

pub fn encrypt(public_key: &[u8], data: &[u8]) -> Vec<u8> {
    let public_key: RsaPublicKey = rsa::pkcs8::DecodePublicKey::from_public_key_der(public_key)
        .expect("Failed to read public key from der");
    let mut rng = rand::thread_rng();

    let mut result: Vec<u8> = Vec::new();
    for chunk in data.chunks(RSA_CHUNK_SIZE) {
        let encrypted_chunk = public_key
            .encrypt(&mut rng, Pkcs1v15Encrypt, chunk)
            .expect("Encryption failed");

        result.extend(encrypted_chunk);
    }

    result
}

pub fn sign(private_key: &[u8], data: &[u8]) -> Box<[u8]> {
    let private_key = rsa::pkcs8::DecodePrivateKey::from_pkcs8_der(private_key)
        .expect("Failed to read pkcs8 private key");
    let signing_key = SigningKey::<Sha256>::new(private_key);

    signing_key
        .sign_with_rng(&mut rand::thread_rng(), data)
        .into()
}

pub fn decrypt(private_key: &[u8], cipher: &[u8]) -> Option<Vec<u8>> {
    let private_key: RsaPrivateKey = rsa::pkcs8::DecodePrivateKey::from_pkcs8_der(private_key)
        .expect("Failed to read pkcs8 private key");

    private_key.decrypt(Pkcs1v15Encrypt, cipher).ok()
}
