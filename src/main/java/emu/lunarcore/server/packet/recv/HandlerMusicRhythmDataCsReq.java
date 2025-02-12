package emu.lunarcore.server.packet.recv;

import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketMusicRhythmDataScRsp;
import emu.lunarcore.server.packet.send.PacketMusicRhythmUnlockSongNotify;
import emu.lunarcore.server.packet.send.PacketMusicRhythmUnlockSongSfxScNotify;
import emu.lunarcore.server.packet.send.PacketMusicRhythmUnlockTrackScNotify;

@Opcodes(7591)
public class HandlerMusicRhythmDataCsReq extends PacketHandler {
   public void handle(GameSession session, byte[] data) throws Exception {
      session.send((BasePacket)(new PacketMusicRhythmDataScRsp()));
      session.send((BasePacket)(new PacketMusicRhythmUnlockSongNotify()));
      session.send((BasePacket)(new PacketMusicRhythmUnlockSongSfxScNotify()));
      session.send((BasePacket)(new PacketMusicRhythmUnlockTrackScNotify()));
      session.send(7575);
   }
}
