package emu.lunarcore.command.commands;


import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;

@Command(label = "stop",
    aliases = {"exit"},
    permission = "admin.stop",
    requireTarget = false,
    desc = "/stop - 停止服务器")
public class StopCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        args.sendMessage("正在停止服务器");
        System.exit(1000);
    }
}
