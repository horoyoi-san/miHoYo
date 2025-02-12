package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.battle.Battle;
import emu.lunarcore.proto.QuickStartCocoonStageScRspOuterClass.QuickStartCocoonStageScRsp;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketQuickStartCocoonStageScRsp extends BasePacket {

    public PacketQuickStartCocoonStageScRsp() {
        super(CmdId.QuickStartCocoonStageScRsp);
        
        var data = QuickStartCocoonStageScRsp.newInstance()
                .setRetcode(1);
        
        this.setData(data);
    }
    
    public PacketQuickStartCocoonStageScRsp(Battle battle, int cocoonId, int wave) {
        super(CmdId.QuickStartCocoonStageScRsp);
        
        var data = QuickStartCocoonStageScRsp.newInstance()
                .setBattleInfo(battle.toProto())
                .setCocoonId(cocoonId);
        
        this.setData(data);
    }
}