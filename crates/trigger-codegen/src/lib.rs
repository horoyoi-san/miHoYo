use proc_macro::TokenStream;
use quote::{quote, ToTokens};
use syn::{parse_macro_input, DeriveInput, Meta, MetaList};

mod commands;
mod decodeable;
mod encodeable;
mod handler_module_attribute;

#[proc_macro_derive(Encodeable)]
pub fn derive_encodeable(item: TokenStream) -> TokenStream {
    encodeable::impl_encodeable(item)
}

#[proc_macro_derive(Decodeable)]
pub fn derive_decodeable(item: TokenStream) -> TokenStream {
    decodeable::impl_decodeable(item)
}

#[proc_macro_derive(GMInput)]
pub fn derive_commands(item: TokenStream) -> TokenStream {
    commands::impl_gm_input(item)
}

#[proc_macro_attribute]
pub fn handlers(_attr: TokenStream, input: TokenStream) -> TokenStream {
    handler_module_attribute::imp(input)
}

#[proc_macro_derive(ClientCmdID, attributes(id))]
pub fn derive_client_cmd_id(item: TokenStream) -> TokenStream {
    let input = parse_macro_input!(item as DeriveInput);
    let struct_name = input.ident;

    let id = match input.attrs.iter().find(|attr| attr.path().is_ident("id")) {
        Some(attr) => match attr.meta {
            Meta::List(MetaList { ref tokens, .. }) => tokens.into_token_stream(),
            _ => panic!("Invalid cmdid attribute value"),
        },
        _ => 0u16.into_token_stream(),
    };

    TokenStream::from(quote! {
        impl crate::ClientCmdID for #struct_name {
            const CMD_ID: u16 = #id;
        }
    })
}
