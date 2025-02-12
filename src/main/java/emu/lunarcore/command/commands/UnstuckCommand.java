package emu.lunarcore.command.commands;

import emu.lunarcore.LunarCore;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.game.player.Player;

@Command(label = "unstuck", permission = "admin.unstuck", desc = "/unstuck @[玩家ID]. 解救那些因为所在场景不加载而无法登入的玩家")
public class UnstuckCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        // Make sure were on the game server
        if (LunarCore.getGameDatabase() == null) {
            args.sendMessage("错误：游戏数据库未连接");
            return;
        }
        
        // TODO add some logic to handle unstucking the target if theyre online
        if (args.getTarget() != null) {
            args.sendMessage("错误：目标玩家在线");
            return;
        }
        
        // Get player from the database
        Player player = LunarCore.getGameDatabase().getObjectByField(Player.class, "_id", args.getTargetUid());
        
        if (player != null) {
            // Reset position for the player
            player.resetPosition();
            player.save();
            
            // Done
            args.sendMessage("玩家成功重载位置");
        } else {
            // Done
            args.sendMessage("错误：游戏数据库未连接");
        }
    }

}
