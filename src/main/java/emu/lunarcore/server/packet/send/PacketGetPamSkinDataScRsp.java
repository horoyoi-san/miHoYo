package emu.lunarcore.server.packet.send;

import java.util.List;

import emu.lunarcore.LunarCore;
import emu.lunarcore.server.game.GameServerPacketHandler;
import emu.lunarcore.data.GameData;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.GetPamSkinDataScRspOuterClass.GetPamSkinDataScRsp;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketGetPamSkinDataScRsp extends BasePacket {
    public PacketGetPamSkinDataScRsp(Player player) {
        super(CmdId.GetPamSkinDataScRsp);

        var data = GetPamSkinDataScRsp.newInstance()
            .setCurPamSkinId(252001);
            data.addPamSkinList(252000);
            data.addPamSkinList(252001);

        this.setData(data);
    }
}

