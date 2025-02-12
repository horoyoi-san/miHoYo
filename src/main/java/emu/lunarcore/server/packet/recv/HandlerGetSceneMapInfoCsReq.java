package emu.lunarcore.server.packet.recv;

import emu.lunarcore.proto.GetSceneMapInfoCsReqOuterClass.GetSceneMapInfoCsReq;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketGetSceneMapInfoScRsp;
import us.hebi.quickbuf.RepeatedInt; // import required classes

@Opcodes(CmdId.GetSceneMapInfoCsReq)
public class HandlerGetSceneMapInfoCsReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        var req = GetSceneMapInfoCsReq.parseFrom(data);
        
        // Get the EntryIdList
        RepeatedInt entryIdList = req.getEntryIdList();
        
        // Get FloorIdList
        RepeatedInt floorIdList = req.getFloorIdList();

        // Create and send the Packet
        session.send(new PacketGetSceneMapInfoScRsp(entryIdList, floorIdList));
    }
}