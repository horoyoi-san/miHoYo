package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.challenge.ChallengeInstance;
import emu.lunarcore.proto.ChallengeBossPhaseSettleNotifyOuterClass.ChallengeBossPhaseSettleNotify;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketChallengeBossPhaseSettleNotify extends BasePacket {
    public PacketChallengeBossPhaseSettleNotify(ChallengeInstance challenge) {
        super(CmdId.ChallengeBossPhaseSettleNotify);

        var data = ChallengeBossPhaseSettleNotify
           .newInstance()
               .setChallengeId(challenge.getExcel().getId())
               .setPhase(challenge.getCurrentStage())
               .setChallengeScore(challenge.getScoreStage1())
               .setScoreTwo(challenge.getScoreStage2())
               .setIsWin(challenge.isWin())
               .setStars(challenge.getStars())
               .setIsRemainingAction(challenge.getCurrentStage() == 2)
               .setIsReward(true);
        
        if (challenge.getBattleTarget1()!= null && challenge.getCurrentStage() == 1) {
            for (var target: challenge.getBattleTarget1().values()) {
                data.addChallengeBattleTargetList(target);
            }
        }

        if (challenge.getBattleTarget2()!= null) {
            for (var target: challenge.getBattleTarget2().values()) {
                data.addChallengeBattleTargetList(target);
            }
        }

        this.setData(data);
    }
}