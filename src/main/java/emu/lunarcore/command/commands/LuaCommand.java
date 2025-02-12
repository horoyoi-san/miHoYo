package emu.lunarcore.command.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.server.packet.send.PacketClientDownloadDataScNotify;
import emu.lunarcore.util.FileUtils;
import java.io.File;
import java.util.stream.IntStream;

@Command(label="lua", permission="player.lua", aliases={"l"}, requireTarget=true, desc="/lua - \u4ecescripts\u6587\u4ef6\u5939\u4e2d\u9009\u62e9lua\u4ee3\u7801\u6267\u884c.")
public class LuaCommand
implements CommandHandler {
    @Override
    public void execute(CommandArgs args2) {
        File scriptsFolder = new File("./scripts/");
        File[] luaFiles = scriptsFolder.listFiles((dir, name) -> name.endsWith(".lua"));
        if (luaFiles == null || luaFiles.length == 0) {
            args2.sendMessage("\u6ca1\u6709\u627e\u5230\u4efb\u4f55.lua\u6587\u4ef6.");
            return;
        }
        if (args2.size() == 0) {
            args2.sendMessage("\u53ef\u7528\u7684.lua\u6587\u4ef6:");
            IntStream.range(0, luaFiles.length).forEach(i -> args2.sendMessage(i + 1 + ". " + luaFiles[i].getName()));
            args2.sendMessage("\u8bf7\u8f93\u5165 /lua [\u5217\u8868\u6570\u5b57] \u6765\u9009\u62e9\u6267\u884c\u54ea\u4e00\u4e2a.");
        } else {
            try {
                int index = Integer.parseInt(args2.get(0)) - 1;
                if (index < 0 || index >= luaFiles.length) {
                    args2.sendMessage("\u65e0\u6548\u7684\u6570\u5b57\uff0c\u8bf7\u8f93\u5165\u6709\u6548\u7684\u6570\u5b57\u6765\u9009\u62e9\u6587\u4ef6.");
                    return;
                }
                byte[] bytes = FileUtils.read(luaFiles[index].getAbsolutePath());
                Player player = args2.getTarget();
                player.sendPacket(new PacketClientDownloadDataScNotify(bytes, player));
                args2.sendMessage("\u6210\u529f\u6267\u884c\u4e86\u6587\u4ef6: " + luaFiles[index].getName());
            } catch (NumberFormatException e) {
                args2.sendMessage("\u65e0\u6548\u7684\u8f93\u5165\uff0c\u8bf7\u8f93\u5165\u4e00\u4e2a\u6570\u5b57.");
            }
        }
    }
}

