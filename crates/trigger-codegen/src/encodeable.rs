use proc_macro2::TokenStream;
use quote::quote;
use syn::{parse_macro_input, Data, DeriveInput, Fields, Ident};

pub fn impl_encodeable(item: proc_macro::TokenStream) -> proc_macro::TokenStream {
    let input = parse_macro_input!(item as DeriveInput);
    let input_name = &input.ident;

    match &input.data {
        Data::Struct(st) => {
            let encode_calls = impl_encode_calls_for_fields(&st.fields, true);
            let encoding_length_calls = impl_encoding_length_calls_for_fields(&st.fields, true);

            quote! {
                impl ::trigger_encoding::Encodeable for #input_name {
                    fn encode<W: ::std::io::Write>(&self, w: &mut W) -> ::std::io::Result<()> {
                        #encode_calls
                        Ok(())
                    }

                    fn encoding_length(&self) -> usize {
                        let mut length = 0;
                        #encoding_length_calls
                        length
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
                .expect("#[derive(Encodeable)] requires #[repr(ty)] attribute for enums")
                .parse_args::<Ident>()
                .unwrap();

            let mut encode_match_arms = TokenStream::new();
            let mut encoding_length_match_arms = TokenStream::new();

            for variant in enumeration.variants.iter() {
                let variant_name = &variant.ident;
                let (_, discriminant) = variant.discriminant.as_ref().expect(
                    "#[derive(Encodeable)] requires explicit enum discriminant declaration",
                );

                let fields_pat = pat_fields(&variant.fields);
                let encode_calls = impl_encode_calls_for_fields(&variant.fields, false);
                let encoding_length_calls =
                    impl_encoding_length_calls_for_fields(&variant.fields, false);

                encode_match_arms.extend(quote! {
                    Self::#variant_name #fields_pat => {
                        #repr::encode(&#discriminant, w)?;
                        #encode_calls
                    },
                });

                encoding_length_match_arms.extend(quote! {
                    Self::#variant_name #fields_pat => {
                        let mut length = #repr::encoding_length(&#discriminant);
                        #encoding_length_calls
                        length
                    },
                });
            }

            quote! {
                impl ::trigger_encoding::Encodeable for #input_name {
                    fn encode<W: ::std::io::Write>(&self, w: &mut W) -> ::std::io::Result<()> {
                        match self {
                            #encode_match_arms
                        }

                        Ok(())
                    }

                    fn encoding_length(&self) -> usize {
                        match self {
                            #encoding_length_match_arms
                        }
                    }
                }
            }
            .into()
        }
        Data::Union(_) => panic!("#[derive(Encodeable)] doesn't support unions"),
    }
}

fn impl_encode_calls_for_fields(fields: &Fields, dot_notation: bool) -> TokenStream {
    let mut encode_calls = TokenStream::new();

    fields.iter().for_each(|field| {
        let name = field.ident.as_ref().unwrap();

        if !dot_notation {
            encode_calls.extend(quote! {
                ::trigger_encoding::Encodeable::encode(#name, w)?;
            });
        } else {
            encode_calls.extend(quote! {
                ::trigger_encoding::Encodeable::encode(&self.#name, w)?;
            });
        }
    });

    encode_calls
}

fn impl_encoding_length_calls_for_fields(fields: &Fields, dot_notation: bool) -> TokenStream {
    let mut encoding_length_calls = TokenStream::new();

    fields.iter().for_each(|field| {
        let name = field.ident.as_ref().unwrap();

        if !dot_notation {
            encoding_length_calls.extend(quote! {
                length += #name.encoding_length();
            });
        } else {
            encoding_length_calls.extend(quote! {
                length += self.#name.encoding_length();
            });
        }
    });

    encoding_length_calls
}

fn pat_fields(fields: &Fields) -> TokenStream {
    match fields {
        Fields::Named(fields) => {
            let fields = fields
                .named
                .iter()
                .map(|field| field.ident.as_ref().unwrap());

            quote!({ #(#fields),* })
        }
        Fields::Unnamed(_) => panic!("#[derive(Encodeable)] doesn't support unnamed fields"),
        Fields::Unit => quote!(),
    }
}
