package emu.lunarcore.server.packet.send;

import emu.lunarcore.proto.PickRogueAvatarScRspOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

import java.util.HashSet;

public class PacketPickRogueAvatarScRsp extends BasePacket {
    public PacketPickRogueAvatarScRsp(HashSet<Integer> avatarIds) {
        super(CmdId.PickRogueAvatarScRsp);
        
        PickRogueAvatarScRspOuterClass.PickRogueAvatarScRsp proto = PickRogueAvatarScRspOuterClass.PickRogueAvatarScRsp.newInstance();
        
        for (var avatarId : avatarIds) {
            proto.addBaseAvatarIdList(avatarId);
        }
        
        this.setData(proto);
    }
}
