package emu.lunarcore.command.commands;

import emu.lunarcore.GameConstants;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;

@Command(label = "refill", aliases = {"rf"}, permission = "player.refill", requireTarget = true, desc = "/refill - 补充你在开放世界中的技能点")
public class RefillMPCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        args.getTarget().getCurrentLineup().addMp(GameConstants.MAX_MP);
        args.sendMessage("成功补充了技能点给 " + args.getTarget().getName());
    }

}
