use std::process::ExitCode;

use clap::Parser;
use serde::Deserialize;

/// CLI tool to communicate with trigger-muip-server
#[derive(Parser)]
#[command(about, long_about = None)]
struct Args {
    /// Player UID
    #[arg(short, long)]
    uid: u32,
    /// GM command
    #[arg(short, long)]
    command: String,
}

#[derive(Deserialize)]
struct Response {
    pub retcode: i32,
    pub message: Option<String>,
}

fn main() -> ExitCode {
    dotenvy::dotenv().ok();

    let Ok(token) = dotenvy::var("GM_TOKEN") else {
        eprintln!("ERROR: environment variable 'GM_TOKEN' is not set!");
        return ExitCode::FAILURE;
    };

    let Ok(url) = dotenvy::var("MUIP_URL") else {
        eprintln!("ERROR: environment variable 'MUIP_URL' is not set!");
        return ExitCode::FAILURE;
    };

    let args = Args::parse();

    let mut result = ureq::get(format!("{url}/api/gm"))
        .query("token", token)
        .query("player_uid", args.uid.to_string())
        .query("command", args.command)
        .call()
        .expect("GET request failed, is MUIP_URL correct and the server is running?");

    let response = result
        .body_mut()
        .read_json::<Response>()
        .expect("failed to deserialize api response");

    if response.retcode != 0 {
        if let Some(message) = response.message {
            eprintln!(
                "MUIP server returned error: {message} (retcode: {})",
                response.retcode
            );
        } else {
            eprintln!("MUIP server returned error, retcode: {}", response.retcode);
        }

        ExitCode::FAILURE
    } else {
        eprintln!("MUIP server successfully processed GM command");
        ExitCode::SUCCESS
    }
}
