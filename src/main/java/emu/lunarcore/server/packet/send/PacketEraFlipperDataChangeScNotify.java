package emu.lunarcore.server.packet.send;

import emu.lunarcore.LunarCore;
import emu.lunarcore.server.game.GameServerPacketHandler;
import emu.lunarcore.data.GameData;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.EraFlipperDataChangeScNotifyOuterClass.EraFlipperDataChangeScNotify;
import emu.lunarcore.proto.EraFlipperDataTypeInfoOuterClass.EraFlipperDataTypeInfo;
import emu.lunarcore.proto.EraFlipperDataTypeOuterClass.EraFlipperDataType;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketEraFlipperDataChangeScNotify extends BasePacket {
    public PacketEraFlipperDataChangeScNotify(EraFlipperDataTypeInfo data1, int floorId) {
        super(CmdId.EraFlipperDataChangeScNotify);

        var data = EraFlipperDataChangeScNotify.newInstance()
		.setData(data1)
		.setFloorId(floorId);

        this.setData(data);
    }
}

