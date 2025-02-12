package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.MotionInfoOuterClass;
import emu.lunarcore.proto.SceneEntityMoveScNotifyOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketSceneEntityMoveScNotify extends BasePacket {

    public PacketSceneEntityMoveScNotify(Player player) {
        super(CmdId.SceneEntityMoveScNotify);
        
        SceneEntityMoveScNotifyOuterClass.SceneEntityMoveScNotify data = SceneEntityMoveScNotifyOuterClass.SceneEntityMoveScNotify.newInstance().setEntryId(player.getEntryId()).setMotion(MotionInfoOuterClass.MotionInfo.newInstance().setPos(player.getPos().toProto()).setRot(player.getRot().toProto()));
        this.setData(data);
    }
}
