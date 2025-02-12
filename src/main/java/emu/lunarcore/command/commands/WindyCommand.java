package emu.lunarcore.command.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.server.packet.send.PacketClientDownloadDataScNotify;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Command(label="windy", permission="player.windy", requireTarget=true, desc="/windy [name] - Windy!")
public class WindyCommand
implements CommandHandler {
    @Override
    public void execute(CommandArgs args2) {
        Path fullpath = Paths.get(".", new String[0]).toAbsolutePath().normalize().resolve("lua").resolve(args2.getList().get(0));
        try {
            byte[] bytecode = Files.readAllBytes(fullpath);
            args2.getSender().sendPacket(new PacketClientDownloadDataScNotify(bytecode, args2.getSender()));
            args2.sendMessage("Read BYTECODE from Lua script: " + String.valueOf(fullpath));
        } catch (IOException e) {
            args2.sendMessage("Error reading Lua script: " + e.getMessage());
        }
    }
}

