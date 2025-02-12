package emu.lunarcore.server.packet.send;

import emu.lunarcore.proto.SceneEntityTeleportCsReqOuterClass;
import emu.lunarcore.proto.SceneEntityTeleportScRspOuterClass;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.BasePacket;

public class PacketSceneEntityTeleportScRsp
extends BasePacket {
    public PacketSceneEntityTeleportScRsp(SceneEntityTeleportCsReqOuterClass.SceneEntityTeleportCsReq req) {
        super(CmdId.SceneEntityTeleportScRsp);
        SceneEntityTeleportScRspOuterClass.SceneEntityTeleportScRsp data = SceneEntityTeleportScRspOuterClass.SceneEntityTeleportScRsp.newInstance().setEntityMotion(req.getMutableEntityMotion());
        this.setData(data);
    }
}

