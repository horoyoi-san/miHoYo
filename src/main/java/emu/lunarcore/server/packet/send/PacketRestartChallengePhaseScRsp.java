package emu.lunarcore.server.packet.send;

import emu.lunarcore.proto.EnterChallengeNextPhaseScRspOuterClass;
import emu.lunarcore.proto.SceneInfoOuterClass;
import emu.lunarcore.server.packet.BasePacket;

public class PacketRestartChallengePhaseScRsp extends BasePacket {

    public PacketRestartChallengePhaseScRsp(SceneInfoOuterClass.SceneInfo scene) {
        super(1752);
        this.setData(EnterChallengeNextPhaseScRspOuterClass.EnterChallengeNextPhaseScRsp.newInstance().setScene(scene));
    }
}
