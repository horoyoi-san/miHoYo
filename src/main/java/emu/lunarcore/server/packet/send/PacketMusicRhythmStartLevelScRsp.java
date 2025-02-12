package emu.lunarcore.server.packet.send;

import emu.lunarcore.proto.MusicRhythmStartLevelScRspOuterClass.MusicRhythmStartLevelScRsp;
import emu.lunarcore.server.packet.BasePacket;

public class PacketMusicRhythmStartLevelScRsp extends BasePacket {
   public PacketMusicRhythmStartLevelScRsp(int startLevel) {
      super(7571);
      MusicRhythmStartLevelScRsp proto = MusicRhythmStartLevelScRsp.newInstance().setLevelId(startLevel);
      this.setData(proto);
   }
}
