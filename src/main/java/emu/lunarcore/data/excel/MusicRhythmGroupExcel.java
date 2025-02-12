package emu.lunarcore.data.excel;

import emu.lunarcore.data.GameResource;
import emu.lunarcore.data.ResourceType;

@ResourceType(
   name = {"MusicRhythmGroup.json"}
)
public class MusicRhythmGroupExcel extends GameResource {
   private int ID;
   private int Index;
   private int Phase;

   public int getId() {
      return this.ID;
   }

   public int getIndex() {
      return this.Index;
   }

   public int getPhase() {
      return this.Phase;
   }
}
