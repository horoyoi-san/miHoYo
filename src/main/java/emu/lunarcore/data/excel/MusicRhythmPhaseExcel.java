package emu.lunarcore.data.excel;

import emu.lunarcore.data.GameResource;
import emu.lunarcore.data.ResourceType;

@ResourceType(
   name = {"MusicRhythmPhase.json"}
)
public class MusicRhythmPhaseExcel extends GameResource {
   private int Phase;
   private int SongID;

   public int getId() {
      return this.Phase;
   }

   public int getPhase() {
      return this.Phase;
   }

   public int getSongID() {
      return this.SongID;
   }
}
