package emu.lunarcore.data;

import emu.lunarcore.GameConstants;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.custom.ActivityScheduleData;
import emu.lunarcore.data.excel.AvatarExpItemExcel;
import emu.lunarcore.data.excel.ChallengeRewardExcel;
import emu.lunarcore.data.excel.EquipmentExpItemExcel;
import emu.lunarcore.data.excel.RelicExpItemExcel;
import emu.lunarcore.data.excel.RelicMainAffixExcel;
import emu.lunarcore.data.excel.RelicSubAffixExcel;
import emu.lunarcore.data.excel.RogueBonusExcel;
import emu.lunarcore.data.excel.RogueBuffExcel;
import emu.lunarcore.data.excel.RogueManagerExcel;
import emu.lunarcore.data.excel.RogueMapExcel;
import emu.lunarcore.data.excel.RogueMiracleExcel;
import emu.lunarcore.data.excel.RogueNPCExcel;
import emu.lunarcore.util.Utils;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.ArrayList;
import java.util.List;

public class GameDepot {
    private static List<ActivityScheduleData> activityScheduleExcels = new ArrayList<ActivityScheduleData>();
    private static List<AvatarExpItemExcel> avatarExpExcels = new ArrayList<AvatarExpItemExcel>();
    private static List<EquipmentExpItemExcel> equipmentExpExcels = new ArrayList<EquipmentExpItemExcel>();
    private static List<RelicExpItemExcel> relicExpExcels = new ArrayList<RelicExpItemExcel>();
    private static Int2ObjectMap<List<RelicMainAffixExcel>> relicMainAffixDepot = new Int2ObjectOpenHashMap<List<RelicMainAffixExcel>>();
    private static Int2ObjectMap<List<RelicSubAffixExcel>> relicSubAffixDepot = new Int2ObjectOpenHashMap<List<RelicSubAffixExcel>>();
    private static Int2ObjectMap<List<ChallengeRewardExcel>> challengeRewardLines = new Int2ObjectOpenHashMap<List<ChallengeRewardExcel>>();
    private static Int2ObjectMap<int[]> rogueMapGen = new Int2ObjectOpenHashMap<int[]>();
    private static Int2ObjectMap<RogueBuffExcel> rogueAeonBuffs = new Int2ObjectOpenHashMap<RogueBuffExcel>();
    private static Int2ObjectMap<List<RogueBuffExcel>> rogueAeonEnhanceBuffs = new Int2ObjectOpenHashMap<List<RogueBuffExcel>>();
    private static List<RogueBuffExcel> rogueRandomBuffList = new ArrayList<RogueBuffExcel>();
    private static List<RogueBonusExcel> rogueRandomCommonBonusList = new ArrayList<RogueBonusExcel>();
    private static List<RogueMiracleExcel> rogueRandomMiracleList = new ArrayList<RogueMiracleExcel>();
    private static List<RogueNPCExcel> rogueRandomNpcList = new ArrayList<RogueNPCExcel>();
    private static Int2ObjectMap<List<RogueMapExcel>> rogueMapDepot = new Int2ObjectOpenHashMap<List<RogueMapExcel>>();

    public static void addRelicMainAffix(RelicMainAffixExcel affix) {
        relicMainAffixDepot.computeIfAbsent(affix.getGroupID(), k -> new ArrayList()).add(affix);
    }

    public static void addRelicSubAffix(RelicSubAffixExcel affix) {
        relicSubAffixDepot.computeIfAbsent(affix.getGroupID(), k -> new ArrayList()).add(affix);
    }

    public static RelicMainAffixExcel getRandomRelicMainAffix(int groupId) {
        List list = (List)relicMainAffixDepot.get(groupId);
        if (list == null) {
            return null;
        }
        return (RelicMainAffixExcel)list.get(Utils.randomRange(0, list.size() - 1));
    }

    public static List<RelicSubAffixExcel> getRelicSubAffixList(int groupId) {
        return (List)relicSubAffixDepot.get(groupId);
    }

    public static RogueManagerExcel getCurrentRogueSchedule() {
        long time = System.currentTimeMillis() - (long)(GameConstants.CURRENT_ZONEOFFSET.getTotalSeconds() * 1000);
        for (RogueManagerExcel schedule : GameData.getRogueManagerExcelMap().values()) {
            if (time < schedule.getBeginTime() || time >= schedule.getEndTime()) continue;
            return schedule;
        }
        return null;
    }

    public static List<RogueMapExcel> getRogueMapsById(int mapId) {
        return rogueMapDepot.computeIfAbsent(mapId, id -> new ArrayList());
    }

    public static List<ActivityScheduleData> getActivityScheduleExcels() {
        return activityScheduleExcels;
    }

    public static List<AvatarExpItemExcel> getAvatarExpExcels() {
        return avatarExpExcels;
    }

    public static List<EquipmentExpItemExcel> getEquipmentExpExcels() {
        return equipmentExpExcels;
    }

    public static List<RelicExpItemExcel> getRelicExpExcels() {
        return relicExpExcels;
    }

    public static Int2ObjectMap<List<ChallengeRewardExcel>> getChallengeRewardLines() {
        return challengeRewardLines;
    }

    public static Int2ObjectMap<int[]> getRogueMapGen() {
        return rogueMapGen;
    }

    public static Int2ObjectMap<RogueBuffExcel> getRogueAeonBuffs() {
        return rogueAeonBuffs;
    }

    public static Int2ObjectMap<List<RogueBuffExcel>> getRogueAeonEnhanceBuffs() {
        return rogueAeonEnhanceBuffs;
    }

    public static List<RogueBuffExcel> getRogueRandomBuffList() {
        return rogueRandomBuffList;
    }

    public static List<RogueBonusExcel> getRogueRandomCommonBonusList() {
        return rogueRandomCommonBonusList;
    }

    public static List<RogueMiracleExcel> getRogueRandomMiracleList() {
        return rogueRandomMiracleList;
    }

    public static List<RogueNPCExcel> getRogueRandomNpcList() {
        return rogueRandomNpcList;
    }
}

