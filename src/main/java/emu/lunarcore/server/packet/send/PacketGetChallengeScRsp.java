package emu.lunarcore.server.packet.send;

import emu.lunarcore.LunarCore;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.ChallengeExcel;
import emu.lunarcore.game.challenge.ChallengeGroupReward;
import emu.lunarcore.game.challenge.ChallengeHistory;
import emu.lunarcore.game.enums.ChallengeType;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.ChallengeBossInfoOuterClass;
import emu.lunarcore.proto.ChallengeHistoryMaxLevelOuterClass;
import emu.lunarcore.proto.ChallengeOuterClass;
import emu.lunarcore.proto.GetChallengeScRspOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketGetChallengeScRsp
extends BasePacket {
    public PacketGetChallengeScRsp(Player player) {
        super(CmdId.GetChallengeScRsp);
        GetChallengeScRspOuterClass.GetChallengeScRsp data = GetChallengeScRspOuterClass.GetChallengeScRsp.newInstance();
        if (LunarCore.getConfig().getServerOptions().unlockAllChallenges) {
            for (ChallengeExcel challengeExcel : GameData.getChallengeExcelMap().values()) {
                ChallengeHistory history = (ChallengeHistory)player.getChallengeManager().getHistory().get(challengeExcel.getId());
                if (history != null) {
                    data.addChallengeList(history.toProto(player));
                    continue;
                }
                ChallengeOuterClass.Challenge challenge = ChallengeOuterClass.Challenge.newInstance().setChallengeId(challengeExcel.getId());
                if (challengeExcel.getType() == ChallengeType.Boss) {
                    ChallengeBossInfoOuterClass.ChallengeBossInfo boss = challenge.getMutableExtInfo().getMutableBossInfo();
                    boss.getMutableSecondNode();
                    boss.getMutableFirstNode();
                }
                data.addAllChallengeList(challenge);
            }
        } else {
            for (ChallengeHistory history : player.getChallengeManager().getHistory().values()) {
                data.addChallengeList(history.toProto(player));
            }
        }
        for (ChallengeGroupReward reward : player.getChallengeManager().getTakenRewards().values()) {
            data.addChallengeRewardList(reward.toProto());
        }
        for (ChallengeType type2 : ChallengeType.values()) {
            if (type2.getVal() == 0) continue;
            data.addMaxLevelList(ChallengeHistoryMaxLevelOuterClass.ChallengeHistoryMaxLevel.newInstance().setLevel(type2.getVal() > 1 ? 4 : 12).setOrderingIndex(type2.getVal()));
        }
        this.setData(data);
    }
}