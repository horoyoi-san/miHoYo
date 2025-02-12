package emu.lunarcore.server.packet.send;

import emu.lunarcore.proto.MusicRhythmFinishLevelScRspOuterClass.MusicRhythmFinishLevelScRsp;
import emu.lunarcore.server.packet.BasePacket;

public class PacketMusicRhythmFinishLevelScRsp extends BasePacket {
   public PacketMusicRhythmFinishLevelScRsp(int finishLevel) {
      super(7587);
      MusicRhythmFinishLevelScRsp proto = MusicRhythmFinishLevelScRsp.newInstance().setLevelId(finishLevel);
      this.setData(proto);
   }
}
