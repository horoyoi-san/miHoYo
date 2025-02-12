package emu.lunarcore.server.packet.send;

import emu.lunarcore.proto.AcceptMainMissionScRspOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketAcceptMainMissionScRsp
extends BasePacket {
    public PacketAcceptMainMissionScRsp(int mainMissionId) {
        super(CmdId.AcceptMainMissionScRsp);
        AcceptMainMissionScRspOuterClass.AcceptMainMissionScRsp data = AcceptMainMissionScRspOuterClass.AcceptMainMissionScRsp.newInstance().setMainMissionId(mainMissionId);
        this.setData(data);
    }
}

