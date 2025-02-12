package emu.lunarcore.server.packet.recv;

import emu.lunarcore.proto.UnlockBackGroundMusicCsReqOuterClass;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import java.util.List;
import java.util.ArrayList;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketUnlockBackGroundMusicScRsp;

@Opcodes(CmdId.UnlockBackGroundMusicCsReq)
public class HandlerUnlockBackGroundMusicCsReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        UnlockBackGroundMusicCsReqOuterClass.UnlockBackGroundMusicCsReq req = UnlockBackGroundMusicCsReqOuterClass.UnlockBackGroundMusicCsReq.parseFrom(data);

        var unlockIds = req.getReqUnlockIds();
        List<Integer> unlockIdsList = new ArrayList<>();
        for (int unlockId : unlockIds) {
            unlockIdsList.add(unlockId);
        }
        if (unlockIdsList.isEmpty()) {
            session.send(new PacketUnlockBackGroundMusicScRsp());
        }
        else {
            session.send(new PacketUnlockBackGroundMusicScRsp(unlockIdsList)); 
        }
    }
}
