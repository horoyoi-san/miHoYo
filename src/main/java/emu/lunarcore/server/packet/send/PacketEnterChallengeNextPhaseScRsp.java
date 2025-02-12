package emu.lunarcore.server.packet.send;

import emu.lunarcore.proto.EnterChallengeNextPhaseScRspOuterClass.EnterChallengeNextPhaseScRsp;
import emu.lunarcore.proto.SceneInfoOuterClass.SceneInfo;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketEnterChallengeNextPhaseScRsp extends BasePacket {

    public PacketEnterChallengeNextPhaseScRsp(SceneInfo scene) {
        super(CmdId.EnterChallengeNextPhaseScRsp);

        if (scene == null) {
            throw new IllegalArgumentException("SceneInfo cannot be null");
        }

        EnterChallengeNextPhaseScRsp response = EnterChallengeNextPhaseScRsp
        .newInstance()
        .setScene(scene);
        this.setData(response);
    }
}
