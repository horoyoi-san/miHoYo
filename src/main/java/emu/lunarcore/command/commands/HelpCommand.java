package emu.lunarcore.command.commands;

import emu.lunarcore.LunarCore;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;

@Command(label = "help", permission = "player.help", desc = "/help. 显示可用命令列表")
public class HelpCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        args.sendMessage("显示命令列表：");
        
        // Sort command names
        var labels = LunarCore.getCommandManager().getLabels().keySet().stream().sorted().toList();
        for (var label : labels) {
            // Get command
            Command command = LunarCore.getCommandManager().getLabels().get(label).getClass().getAnnotation(Command.class);
            if (command == null) continue;
            
            // Only send command description if the sender has permission to use the command
            if (LunarCore.getCommandManager().checkPermission(args.getSender(), command)) {
                args.sendMessage(command.desc());
            }
        }
    }

}
