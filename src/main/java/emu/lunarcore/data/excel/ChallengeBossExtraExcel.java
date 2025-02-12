package emu.lunarcore.data.excel;

import emu.lunarcore.data.GameData;
import emu.lunarcore.data.GameResource;
import emu.lunarcore.data.ResourceType;
import emu.lunarcore.data.excel.ChallengeExcel;
import it.unimi.dsi.fastutil.ints.IntArrayList;

@ResourceType(name={"ChallengeBossMazeExtra.json"}, loadPriority=ResourceType.LoadPriority.LOW)
public class ChallengeBossExtraExcel
extends GameResource {
    private int ID;
    private int TurnLimit;
    private int ClearScore;
    private IntArrayList BattleTargetID;

    @Override
    public int getId() {
        return this.ID;
    }

    @Override
    public void onLoad() {
        ChallengeExcel challengeExcel = (ChallengeExcel)GameData.getChallengeExcelMap().get(this.getId());
        if (challengeExcel != null) {
            challengeExcel.setBossExcel(this);
        }
    }

    public int getTurnLimit() {
        return this.TurnLimit;
    }

    public int getClearScore() {
        return this.ClearScore;
    }

    public IntArrayList getBattleTargetID() {
        return this.BattleTargetID;
    }
}

