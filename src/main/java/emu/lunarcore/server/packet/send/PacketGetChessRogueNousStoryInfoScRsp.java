package emu.lunarcore.server.packet.send;

import emu.lunarcore.data.GameData;
import emu.lunarcore.proto.ChessRogueNousMainStoryInfoOuterClass;
import emu.lunarcore.proto.ChessRogueNousSubStoryInfoOuterClass;
import emu.lunarcore.proto.GetChessRogueNousStoryInfoScRspOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketGetChessRogueNousStoryInfoScRsp extends BasePacket {
    public PacketGetChessRogueNousStoryInfoScRsp() {
        super(CmdId.GetChessRogueNousStoryInfoScRsp);
        
        GetChessRogueNousStoryInfoScRspOuterClass.GetChessRogueNousStoryInfoScRsp proto = GetChessRogueNousStoryInfoScRspOuterClass.GetChessRogueNousStoryInfoScRsp.newInstance();

        for (var entry : GameData.getRogueNousMainStoryExcelMap().keySet()) {
        proto.addMainStartInfo(ChessRogueNousMainStoryInfoOuterClass.ChessRogueNousMainStoryInfo.newInstance().setStoryId(entry).setStatus(2));
        }

        for (var entry : GameData.getRogueNousSubStoryExcelMap().keySet()) {
            proto.addSubStartInfo(ChessRogueNousSubStoryInfoOuterClass.ChessRogueNousSubStoryInfo.newInstance().setSubStoryId(entry));
        }
        
        this.setData(proto);
    }
}
