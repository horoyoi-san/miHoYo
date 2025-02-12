package emu.lunarcore.command.commands;

import emu.lunarcore.util.Utils;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;

@Command(label = "setlevel", aliases = {"level"}, permission = "player.setlevel", requireTarget = true, desc = "/setlevel [level] - 设置目标玩家的开拓者等级")
public class SetLevelCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        int targetLevel = Utils.parseSafeInt(args.get(0));
        
        args.getTarget().setLevel(targetLevel);
        args.sendMessage("设置等级为 " + args.getTarget().getLevel());
    }

}
