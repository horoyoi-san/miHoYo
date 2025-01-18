# GatoSR Lite

Ever wanted a private server that is quick to update when the game updates, but doesn't sacrifice too much features?

A server that's modular enough and feature complete-ish for battle simulation?

You're in the right place!

## Join the Discord

https://discord.gg/hAC47nUAqN

## Tutorial

This tutorial assumes you have basic knowledge of a terminal and traffic redirection with a proxy.

Also, if config files are missing, the server will fallback to default config. This means you can delete all files in `_config` folder.

You only have to worry about `config.json` because that's the config file for battle. It's obtainable from https://srtools.pages.dev/

### Use Prebuilt (Windows only)

1. Download the prebuilt that matches your SR version in https://github.com/nightkoneko/gatosr-lite/releases
2. Extract the zip
3. Edit config files in `_config` if necessary (check the README in that folder)
4. Open `run.bat` (Click yes if it asks you to install a certificate)
    - Alternatively, if the .bat isn't working, you can manually run `net-game.exe`, `net-sdk.exe`
5. Run `FireflySR.Tool.Proxy.exe` (in the FireflySR-Proxy folder) and open the game
6. Enter the Calyx to enter battle

#### How to configure:

1. Go to https://srtools.pages.dev/
2. Configure the team, character builds, and enemies you want to fight and stuff
3. Press the "config.json" button at the top, put the team you want to use and the enemies you want to fight and download the config.json
4. Go to the _config folder and put your new config.json there. If there is already one there, overwrite it.

### Build From Source

1. Install Rust
2. Clone this repository
3. `cd` into `main`
5. Edit config files in `_config` if necessary (check the README in that folder)
6. `cargo run --release --bin net-game`
7. `cargo run --release --bin net-sdk`

### How to Start Localhosted PS using cultivation:
1. Download [Cultivation](https://github.com/NotThorny/Cultivation/releases/download/1.5.4/Cultivation.zip) extract anywhere you like it
2. Open Cultivation, turn on connect to Grasscutter. Put 127.0.0.1 on Server Address and 21000 for Port
3. Click the gear icon on top-right and set game install path to StarRail.exe (Your beta client)
4. Now, open robinsr/gatosr/qqsr/whatever folder **DO NOT CLICK RUN.BAT**, just open the gameserver.exe and sdkserver.exe
5. Click Launch in Cultivation

## Credits

Based on https://github.com/DevilProMT/sr

- Eli
- Gatokeeper: :3
- Naruse
- Yulian: QingqueSR Developer
- amizing25: SrTools Author
