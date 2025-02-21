use proc_macro2::TokenStream;
use quote::{quote, ToTokens};
use syn::{parse_macro_input, FnArg, Item, ItemMod, ReturnType};

pub fn imp(input: proc_macro::TokenStream) -> proc_macro::TokenStream {
    const INVALID_FUNCTION_SIGNATURE_MSG: &str = "functions in message handler module should have following signature: fn(&mut MessageContext<'_>, CsReq) -> ScRsp";

    let module = parse_macro_input!(input as ItemMod);
    let mod_name = &module.ident;

    let (_, items) = module
        .content
        .as_ref()
        .expect("#[handlers] module should contain message handler functions");

    let mut output_module = TokenStream::new();
    let mut handler_match_arms = TokenStream::new();
    let mut supports_message_expressions = TokenStream::new();

    for item in items.iter() {
        let Item::Fn(func) = item else {
            output_module.extend(item.to_token_stream());
            continue;
        };

        let sig = &func.sig;
        let name = &sig.ident;

        assert_eq!(sig.inputs.len(), 2, "{}", INVALID_FUNCTION_SIGNATURE_MSG);

        let argument = match sig.inputs.get(1).as_ref().unwrap() {
            FnArg::Typed(argument) => argument,
            FnArg::Receiver(_) => unreachable!(),
        };

        output_module.extend(quote! {
            #[::tracing::instrument(skip_all)]
            #func
        });

        let request_type = argument.ty.as_ref();
        supports_message_expressions.extend(quote! {
            if cmd_id == #request_type::CMD_ID {
                return true;
            }
        });

        let has_return_message = ReturnType::Default != sig.output;

        if has_return_message {
            handler_match_arms.extend(quote! {
            #request_type::CMD_ID => {
                let request = match #request_type::decode(&mut ::std::io::Cursor::new(&message.message.blob)) {
                    Ok(request) => request,
                    Err(err) => {
                        ::tracing::error!("failed to decode message {}: {}", stringify!(#request_type), err);
                        return None;
                    }
                };

                let mut context = super::MessageContext::new(state, session, player, message.request_id);
                let response = #mod_name::#name(&mut context, request).await;

                ::tracing::debug!("client message {} was handled", stringify!(#request_type));
                Some(::trigger_sv::message::AvailableServerProtocolMessage {
                    session_id: context.session.id,
                    ack_request_id: message.request_id,
                    response: Some(response.into()),
                    notifies: context.remove_notifies(),
                })
            }
        });
        } else {
            handler_match_arms.extend(quote! {
            #request_type::CMD_ID => {
                let request = match #request_type::decode(&mut ::std::io::Cursor::new(&message.message.blob)) {
                    Ok(request) => request,
                    Err(err) => {
                        ::tracing::error!("failed to decode message {}: {}", stringify!(#request_type), err);
                        return None;
                    }
                };

                let mut context = super::MessageContext::new(state, session, player, message.request_id);
                #mod_name::#name(&mut context, request).await;

                ::tracing::debug!("client message {} was handled", stringify!(#request_type));
                Some(::trigger_sv::message::AvailableServerProtocolMessage {
                    session_id: context.session.id,
                    ack_request_id: message.request_id,
                    response: None,
                    notifies: context.remove_notifies(),
                })
            }
        });
        }
    }

    quote! {
        pub fn supports_message(cmd_id: u16) -> bool {
            use ::trigger_protocol::*;

            #supports_message_expressions
            false
        }

        pub async fn handle_message(state: &'static crate::AppState, session: &crate::session::GameSession, player: &mut crate::NapPlayer, message: ::trigger_sv::message::ForwardClientProtocolMessage) -> Option<::trigger_sv::message::AvailableServerProtocolMessage> {
            use ::trigger_protocol::*;
            use ::trigger_encoding::{Encodeable, Decodeable};

            match message.message.cmd_id {
                #handler_match_arms
                _ => None,
            }
        }

        mod #mod_name {
            use super::MessageContext;
            use ::trigger_protocol::*;

            #output_module
        }
    }
    .into()
}
