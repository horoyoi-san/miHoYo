package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.battle.Battle;
import emu.lunarcore.proto.SceneCastSkillScRspOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketSceneCastSkillScRsp
extends BasePacket {
    public PacketSceneCastSkillScRsp() {
        super(CmdId.SceneCastSkillScRsp);
        SceneCastSkillScRspOuterClass.SceneCastSkillScRsp data = SceneCastSkillScRspOuterClass.SceneCastSkillScRsp.newInstance().setRetcode(1);
        this.setData(data);
    }

    public PacketSceneCastSkillScRsp(int attackedGroupId) {
        super(CmdId.SceneCastSkillScRsp);
        SceneCastSkillScRspOuterClass.SceneCastSkillScRsp data = SceneCastSkillScRspOuterClass.SceneCastSkillScRsp.newInstance().setAttackedGroupId(attackedGroupId);
        this.setData(data);
    }

    public PacketSceneCastSkillScRsp(Battle battle, int attackedGroupId) {
        super(CmdId.SceneCastSkillScRsp);
        SceneCastSkillScRspOuterClass.SceneCastSkillScRsp data = SceneCastSkillScRspOuterClass.SceneCastSkillScRsp.newInstance().setAttackedGroupId(attackedGroupId).setBattleInfo(battle.toProto());
        this.setData(data);
    }
}

