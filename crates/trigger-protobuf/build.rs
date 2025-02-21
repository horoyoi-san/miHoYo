use std::{
    collections::HashSet,
    fs::{self, File},
    io::{BufRead, BufReader},
    path::Path,
};

use quote::{quote, ToTokens};
use syn::{Field, GenericArgument, Item, PathArguments, Type, TypePath};

fn main() {
    let proto_file = "nap.proto";
    if Path::new(&proto_file).exists() {
        println!("cargo:rerun-if-changed={proto_file}");
        let _ = fs::create_dir("out/");

        prost_build::Config::new()
            .out_dir("out/")
            .type_attribute(".", "#[derive(trigger_protobuf_derive::CmdID)]")
            .type_attribute(".", "#[derive(trigger_protobuf_derive::XorFields)]")
            .compile_protos(&[proto_file], &["."])
            .unwrap();

        let pb_out = Path::new("out/_.rs");
        remove_obfuscated_messages(pb_out, Path::new("nap.proto")).unwrap();
        apply_message_attributes(pb_out).unwrap();
        impl_struct_conversions(
            pb_out,
            Path::new("../trigger-protocol/src/lib.rs"),
            Path::new("out/protocol_map.rs"),
        )
        .unwrap();
    }
}

fn impl_struct_conversions(
    protobuf_codegen_path: &Path,
    protocol_structures_path: &Path,
    output_path: &Path,
) -> std::io::Result<()> {
    let pb_gen = syn::parse_file(&fs::read_to_string(protobuf_codegen_path)?).unwrap();
    let custom_structs = syn::parse_file(&fs::read_to_string(protocol_structures_path)?).unwrap();

    let mut from_impls = proc_macro2::TokenStream::new();
    let mut pb_to_cp_unit_match_arms = proc_macro2::TokenStream::new();
    let mut cp_unit_to_pb_match_arms = proc_macro2::TokenStream::new();

    for item in pb_gen.items.iter() {
        let Item::Struct(pb) = item else {
            continue;
        };

        let ident = &pb.ident;

        // if it has cmdid, then we want a PB <-> Common Protocol Unit conversion
        if pb.attrs.iter().any(|attr| {
            attr.meta
                .path()
                .get_ident()
                .map(|i| i == "cmdid")
                .unwrap_or(false)
            // Should be also defined in list of custom Common Protocol structures
        }) && custom_structs.items.iter().any(|st| {
            if let Item::Struct(cst) = st {
                &cst.ident == ident
            } else {
                false
            }
        }) {
            pb_to_cp_unit_match_arms.extend(quote! {
                #ident::CMD_ID => {
                    let mut pb_message = #ident::decode(pb)?;
                    pb_message.xor_fields();

                    let common_protocol_message = ::trigger_protocol::#ident::from(pb_message);
                    Ok(Some(common_protocol_message.into()))
                }
            });

            cp_unit_to_pb_match_arms.extend(quote! {
                ::trigger_protocol::#ident::CMD_ID => {
                    let common_protocol_message = ::trigger_protocol::#ident::decode(&mut ::std::io::Cursor::new(&unit.blob))?;
                    let mut pb_message = #ident::from(common_protocol_message);
                    pb_message.xor_fields();

                    Ok(Some((#ident::CMD_ID, pb_message.encode_to_vec())))
                }
            });
        }

        let Some(Item::Struct(c_struct)) = custom_structs.items.iter().find(|i| {
            if let Item::Struct(s) = i {
                &s.ident == ident
            } else {
                false
            }
        }) else {
            continue;
        };

        let mut assignments = proc_macro2::TokenStream::new();

        pb
            .fields
            .iter()
            .filter(|pb_field| c_struct.fields.iter().any(|c_field| c_field.ident == pb_field.ident))
            .map(|f| (f, f.ident.as_ref().unwrap()))
            .for_each(|(f, ident)| {
                if field_is_optional(f) {
                    assignments.extend(quote! {
                        #ident: value.#ident.map(|v| v.into()),
                    });
                }
                else if field_is_vector(f) {
                    assignments.extend(quote! {
                        #ident: value.#ident.into_iter().map(|v| v.into()).collect(),
                    });
                }
                else if field_is_hash_map(f) {
                    assignments.extend(quote! {
                        #ident: value.#ident.into_iter().map(|(k, v)| (k.into(), v.into())).collect(),
                    });
                }
                else {
                    assignments.extend(quote! {
                        #ident: value.#ident.into(),
                    });
                }
            });

        from_impls.extend(quote! {
            #[allow(unused)]
            impl From<#ident> for ::trigger_protocol::#ident {
                fn from(value: #ident) -> Self {
                    Self {
                        #assignments
                        ..Default::default()
                    }
                }
            }

            #[allow(unused)]
            impl From<::trigger_protocol::#ident> for #ident {
                fn from(value: ::trigger_protocol::#ident) -> Self {
                    Self {
                        #assignments
                        ..Default::default()
                    }
                }
            }
        });
    }

    let generated_code = quote! {
        pub fn pb_to_common_protocol_unit(pb_cmd_id: u16, pb: &[u8]) -> Result<Option<::trigger_protocol::util::ProtocolUnit>, crate::ProtobufDecodeError> {
            match pb_cmd_id {
                #pb_to_cp_unit_match_arms
                _ => Ok(None),
            }
        }

        pub fn common_protocol_unit_to_pb(unit: &::trigger_protocol::util::ProtocolUnit) -> ::std::io::Result<Option<(u16, Vec<u8>)>> {
            use ::trigger_encoding::Decodeable;
            use ::trigger_protocol::ClientCmdID;

            match unit.cmd_id {
                #cp_unit_to_pb_match_arms
                _ => Ok(None),
            }
        }

        #from_impls
    };

    std::fs::write(
        output_path,
        &prettyplease::unparse(&syn::parse2(generated_code).unwrap()),
    )?;

    Ok(())
}

fn remove_obfuscated_messages(codegen_path: &Path, proto_path: &Path) -> std::io::Result<()> {
    // Remove unused obfuscated messages to reduce compilation time

    let mut obfuscated_names = HashSet::new();

    let proto_file = File::open(proto_path)?;
    let reader = BufReader::new(proto_file);

    for line in reader.lines() {
        let line = line?;
        let name = if line.starts_with("message ") {
            line.split(' ').nth(1).unwrap()
        } else if line.contains('=') {
            let split = line.trim().split('=').nth(0).unwrap().trim().split(' ');
            split.last().unwrap()
        } else {
            continue;
        };

        // length=11 & uppercase => obfuscated name
        if name.len() == 11 && !name.chars().fold(false, |b, ch| b || ch.is_lowercase()) {
            obfuscated_names.insert(name.to_string());
        }
    }

    let codegen = syn::parse_file(&std::fs::read_to_string(codegen_path).unwrap()).unwrap();
    let mut optimized = proc_macro2::TokenStream::new();

    for item in codegen.items.iter() {
        match item {
            syn::Item::Struct(st) => {
                let name = &st.ident;
                let attrs = &st.attrs;
                if obfuscated_names.contains(&name.to_string().to_uppercase()) {
                    continue;
                }

                let mut struct_fields = proc_macro2::TokenStream::new();
                for field in st.fields.iter() {
                    if obfuscated_names
                        .contains(&field.ident.as_ref().unwrap().to_string().to_uppercase())
                    {
                        continue;
                    }

                    let ft = extract_type(&field.ty);
                    if !obfuscated_names.contains(&ft.to_uppercase()) {
                        struct_fields.extend(quote::quote! {
                            #field,
                        });
                    }
                }

                optimized.extend(quote::quote! {
                    #(#attrs)*
                    pub struct #name {
                        #struct_fields
                    }
                });
            }
            syn::Item::Mod(module) => {
                if obfuscated_names.contains(&module.ident.to_string().to_uppercase()) {
                    continue;
                }

                let mod_name = &module.ident;
                let mut mod_items = proc_macro2::TokenStream::new();
                for item in module.content.as_ref().unwrap().1.iter() {
                    if let Item::Enum(en) = &item {
                        let attrs = &en.attrs;
                        let name = &en.ident;
                        let mut variants = Vec::new();
                        for variant in en.variants.iter() {
                            let field = variant.fields.iter().next().unwrap();
                            if !obfuscated_names.contains(&extract_type(&field.ty).to_uppercase()) {
                                variants.push(variant);
                            }
                        }

                        mod_items.extend(quote::quote! {
                            #(#attrs)*
                            pub enum #name {
                                #(#variants),*
                            }
                        });
                    }
                }

                optimized.extend(quote::quote! {
                    pub mod #mod_name {
                        #mod_items
                    }
                });
            }
            _ => {
                optimized.extend(item.to_token_stream());
            }
        }
    }

    std::fs::write(
        codegen_path,
        prettyplease::unparse(&syn::parse2(optimized).unwrap()),
    )?;

    Ok(())
}

fn apply_message_attributes(path: &Path) -> std::io::Result<()> {
    let file = File::open(path)?;
    let reader = BufReader::new(file);
    let mut output = Vec::new();

    let mut cmd_id_attr = None;
    for line in reader.lines() {
        let line = line?;
        if line.contains("xor const: ") {
            if !line.contains("xor const: 0") {
                output.push(make_xor_attr(&line).unwrap());
            }
        } else if line.contains("CmdID: ") {
            cmd_id_attr = Some(make_cmd_id_attr(&line).unwrap());
        } else {
            output.push(line);
            if let Some(attr) = cmd_id_attr.take() {
                output.push(attr);
            }
        }
    }

    fs::write(path, output.join("\n").as_bytes())?;
    Ok(())
}

#[must_use]
fn field_is_optional(field: &Field) -> bool {
    match &field.ty {
        Type::Path(TypePath { path, .. }) => {
            let last_segment = path.segments.last().unwrap();
            last_segment.ident == "Option"
        }
        _ => panic!("Unsupported field type"),
    }
}

#[must_use]
fn field_is_vector(field: &Field) -> bool {
    match &field.ty {
        Type::Path(TypePath { path, .. }) => {
            let last_segment = path.segments.last().unwrap();
            last_segment.ident == "Vec"
        }
        _ => panic!("Unsupported field type"),
    }
}

#[must_use]
fn field_is_hash_map(field: &Field) -> bool {
    match &field.ty {
        Type::Path(TypePath { path, .. }) => {
            let last_segment = path.segments.last().unwrap();
            last_segment.ident == "HashMap"
        }
        _ => panic!("Unsupported field type"),
    }
}

fn make_xor_attr(line: &str) -> Option<String> {
    let xor_value = line.split("xor const: ").nth(1)?.parse::<u32>().ok()?;
    Some(format!("    #[xor({xor_value})]"))
}

fn make_cmd_id_attr(line: &str) -> Option<String> {
    let cmd_id = line.split("CmdID: ").nth(1)?.parse::<u16>().ok()?;
    Some(format!("#[cmdid({cmd_id})]"))
}

#[must_use]
fn get_type_name(path: &syn::Path) -> String {
    path.segments.last().unwrap().ident.to_string()
}

#[must_use]
fn extract_type(ty: &Type) -> String {
    match &ty {
        Type::Path(TypePath { path, .. }) => {
            let last_segment = path.segments.last().unwrap();
            match &last_segment.arguments {
                PathArguments::AngleBracketed(args) => {
                    if let Some(GenericArgument::Type(Type::Path(TypePath { path, .. }))) =
                        args.args.last()
                    {
                        get_type_name(path)
                    } else {
                        get_type_name(path)
                    }
                }
                _ => get_type_name(path),
            }
        }
        _ => panic!("Unsupported field type"),
    }
}
