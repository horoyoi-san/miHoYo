package emu.lunarcore.server.packet.recv;

import emu.lunarcore.proto.MusicRhythmStartLevelCsReqOuterClass.MusicRhythmStartLevelCsReq;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketMusicRhythmStartLevelScRsp;

@Opcodes(7599)
public class HandlerMusicRhythmStartLevelCsReq extends PacketHandler {
   public void handle(GameSession session, byte[] data) throws Exception {
      MusicRhythmStartLevelCsReq req = MusicRhythmStartLevelCsReq.parseFrom(data);
      int musicId = req.getLevelId();
      session.getPlayer().setCurMusicId(musicId);
      session.send((BasePacket)(new PacketMusicRhythmStartLevelScRsp(musicId)));
   }
}
