package emu.lunarcore.server.packet.send;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.MusicRhythmSoundEffectExcel;
import emu.lunarcore.proto.MusicRhythmUnlockSongSfxScNotifyOuterClass.MusicRhythmUnlockSongSfxScNotify;
import emu.lunarcore.server.packet.BasePacket;
import it.unimi.dsi.fastutil.objects.ObjectIterator;

public class PacketMusicRhythmUnlockSongSfxScNotify extends BasePacket {
   public PacketMusicRhythmUnlockSongSfxScNotify() {
      super(7580);
      MusicRhythmUnlockSongSfxScNotify data = MusicRhythmUnlockSongSfxScNotify.newInstance();
      ObjectIterator var2 = GameData.getMusicRhythmSoundEffectExcelMap().values().iterator();

      while(var2.hasNext()) {
         MusicRhythmSoundEffectExcel excel = (MusicRhythmSoundEffectExcel)var2.next();
         data.addMusicUnlockList(excel.getId());
      }

      this.setData(data);
   }
}
