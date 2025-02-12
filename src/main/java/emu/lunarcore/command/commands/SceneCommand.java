package emu.lunarcore.command.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.config.AnchorInfo;
import emu.lunarcore.data.config.FloorInfo;
import emu.lunarcore.data.excel.MazePlaneExcel;
import emu.lunarcore.util.Utils;

@Command(label = "scene", aliases = {"sc"}, permission = "player.scene", requireTarget = true, desc = "/scene [场景ID] [楼层ID]。将玩家传送到指定的场景。")
public class SceneCommand implements CommandHandler {

    @Override
    public void execute(CommandArgs args) {
        // Get arguments
        int planeId = Utils.parseSafeInt(args.get(0));
        int floorId = Utils.parseSafeInt(args.get(1));
        
        // Get maze plane
        MazePlaneExcel excel = GameData.getMazePlaneExcelMap().get(planeId);
        if (excel == null) {
            args.sendMessage("错误：迷宫平面未找到");
            return;
        }
        
        if (floorId <= 0) {
            floorId = excel.getStartFloorID();
        }
        
        // Get floor info
        FloorInfo floor = GameData.getFloorInfo(planeId, floorId);
        if (floor == null) {
            args.sendMessage("错误：楼层信息未找到");
            return;
        }
        
        AnchorInfo anchor = floor.getStartAnchorInfo();
        if (anchor == null) {
            args.sendMessage("错误：楼层信息未找到");
            return;
        }
        
        // Move player to scene
        boolean success = args.getTarget().loadScene(planeId, floorId, 0, anchor.getPos(), anchor.getRot(), true);
        
        // Send packet
        if (success) {
            args.sendMessage("已将玩家传送到 " + planeId);
        }
    }

}
