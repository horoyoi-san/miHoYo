package emu.lunarcore.server.packet.recv;

import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketMusicRhythmFinishLevelScRsp;

@Opcodes(7578)
public class HandlerMusicRhythmFinishLevelCsReq extends PacketHandler {
   public void handle(GameSession session, byte[] data) throws Exception {
      session.send((BasePacket)(new PacketMusicRhythmFinishLevelScRsp(session.getPlayer().getCurMusicId())));
   }
}
