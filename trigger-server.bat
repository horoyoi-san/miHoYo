@echo off
start cmd /k "cargo run --bin trigger-dispatch-server"
start cmd /k "cargo run --bin trigger-gate-server"
start cmd /k "cargo run --bin trigger-game-server"
start cmd /k "cargo run --bin trigger-hall-server"
start cmd /k "cargo run --bin trigger-battle-server"
start cmd /k "cargo run --bin trigger-muip-server"