pub mod config;
pub mod gm_command;
pub mod logging;
pub mod message;
pub mod net;
pub mod time_util;

pub fn print_banner() {
    eprintln!(
        r#"
          ______     _                             ____  _____
         /_  __/____(_)___ _____ ____  _____      / __ \/ ___/
          / / / ___/ / __ `/ __ `/ _ \/ ___/_____/ /_/ /\__ \ 
         / / / /  / / /_/ / /_/ /  __/ /  /_____/ _, _/___/ / 
        /_/ /_/  /_/\__, /\__, /\___/_/        /_/ |_|/____/  
                   /____//____/                               "#
    );
}

pub fn die() -> ! {
    // Amuse user in a Zenless fashion
    eprintln!(
        r#"
    ______________________________________
    <  Your Server ate an ethereal! Gah! >
    --------------------------------------
            \
             \      /\    /\
              \    /  \__/  \
                  /__________\
                 |  (X)  (X)  |
                /|------------|\
               / |     ||     | \
                  \_   ||   _/
                    \/^^^^\/  
    "#
    );

    // Make sure user will see the error message
    let mut s = String::new();
    let _ = std::io::stdin().read_line(&mut s);

    // Finally die
    std::process::exit(1);
}
