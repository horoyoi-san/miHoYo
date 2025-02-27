use proc_macro2::TokenStream;
use quote::quote;
use syn::{parse_macro_input, Data, DeriveInput, Fields, Ident};

pub fn impl_decodeable(item: proc_macro::TokenStream) -> proc_macro::TokenStream {
    let input = parse_macro_input!(item as DeriveInput);
    let input_name = &input.ident;

    match &input.data {
        Data::Struct(st) => {
            let decode_calls = impl_decode_calls_for_fields(&st.fields);

            quote! {
                impl ::trigger_encoding::Decodeable for #input_name {
                    fn decode<R: ::std::io::Read>(r: &mut R) -> ::std::io::Result<Self> {
                        Ok(Self {
                            #decode_calls
                        })
                    }
                }
            }
            .into()
        }
        Data::Enum(enumeration) => {
            let repr = input
                .attrs
                .iter()
                .find(|attr| attr.path().is_ident("repr"))
                .expect("#[derive(Decodeable)] requires #[repr(ty)] attribute for enums")
                .parse_args::<Ident>()
                .unwrap();

            let mut decode_match_arms = TokenStream::new();

            for variant in enumeration.variants.iter() {
                let variant_name = &variant.ident;
                let (_, discriminant) = variant.discriminant.as_ref().expect(
                    "#[derive(Decodeable)] requires explicit enum discriminant declaration",
                );

                let decode_calls = impl_decode_calls_for_fields(&variant.fields);

                decode_match_arms.extend(quote! {
                    #discriminant => Self::#variant_name {
                        #decode_calls
                    },
                });
            }

            quote! {
                impl ::trigger_encoding::Decodeable for #input_name {
                    fn decode<R: ::std::io::Read>(r: &mut R) -> ::std::io::Result<Self> {
                        Ok(match #repr::decode(r)? {
                            #decode_match_arms
                            unk => panic!("{}::decode: unknown discriminant encountered: {}", stringify!(#input_name), unk),
                        })
                    }
                }
            }.into()
        }
        Data::Union(_) => panic!("#[derive(Decodeable)] doesn't support unions"),
    }
}

fn impl_decode_calls_for_fields(fields: &Fields) -> TokenStream {
    let mut decode_calls = TokenStream::new();

    fields.iter().for_each(|field| {
        let name = field.ident.as_ref().unwrap();
        decode_calls.extend(quote! {
            #name: ::trigger_encoding::Decodeable::decode(r)?,
        });
    });

    decode_calls
}
