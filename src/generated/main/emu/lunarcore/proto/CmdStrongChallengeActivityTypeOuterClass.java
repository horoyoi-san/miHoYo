// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import us.hebi.quickbuf.ProtoEnum;
import us.hebi.quickbuf.ProtoUtil;

public final class CmdStrongChallengeActivityTypeOuterClass {
  /**
   * Protobuf enum {@code CmdStrongChallengeActivityType}
   */
  public enum CmdStrongChallengeActivityType implements ProtoEnum<CmdStrongChallengeActivityType> {
    /**
     * <code>CmdStrongChallengeActivityTypeNone = 0;</code>
     */
    CmdStrongChallengeActivityTypeNone("CmdStrongChallengeActivityTypeNone", 0),

    /**
     * <code>CmdEnterStrongChallengeActivityStageCsReq = 6658;</code>
     */
    CmdEnterStrongChallengeActivityStageCsReq("CmdEnterStrongChallengeActivityStageCsReq", 6658),

    /**
     * <code>CmdEnterStrongChallengeActivityStageScRsp = 6624;</code>
     */
    CmdEnterStrongChallengeActivityStageScRsp("CmdEnterStrongChallengeActivityStageScRsp", 6624),

    /**
     * <code>CmdGetStrongChallengeActivityDataCsReq = 6601;</code>
     */
    CmdGetStrongChallengeActivityDataCsReq("CmdGetStrongChallengeActivityDataCsReq", 6601),

    /**
     * <code>CmdGetStrongChallengeActivityDataScRsp = 6668;</code>
     */
    CmdGetStrongChallengeActivityDataScRsp("CmdGetStrongChallengeActivityDataScRsp", 6668),

    /**
     * <code>CmdStrongChallengeActivityBattleEndScNotify = 6630;</code>
     */
    CmdStrongChallengeActivityBattleEndScNotify("CmdStrongChallengeActivityBattleEndScNotify", 6630);

    /**
     * <code>CmdStrongChallengeActivityTypeNone = 0;</code>
     */
    public static final int CmdStrongChallengeActivityTypeNone_VALUE = 0;

    /**
     * <code>CmdEnterStrongChallengeActivityStageCsReq = 6658;</code>
     */
    public static final int CmdEnterStrongChallengeActivityStageCsReq_VALUE = 6658;

    /**
     * <code>CmdEnterStrongChallengeActivityStageScRsp = 6624;</code>
     */
    public static final int CmdEnterStrongChallengeActivityStageScRsp_VALUE = 6624;

    /**
     * <code>CmdGetStrongChallengeActivityDataCsReq = 6601;</code>
     */
    public static final int CmdGetStrongChallengeActivityDataCsReq_VALUE = 6601;

    /**
     * <code>CmdGetStrongChallengeActivityDataScRsp = 6668;</code>
     */
    public static final int CmdGetStrongChallengeActivityDataScRsp_VALUE = 6668;

    /**
     * <code>CmdStrongChallengeActivityBattleEndScNotify = 6630;</code>
     */
    public static final int CmdStrongChallengeActivityBattleEndScNotify_VALUE = 6630;

    private final String name;

    private final int number;

    private CmdStrongChallengeActivityType(String name, int number) {
      this.name = name;
      this.number = number;
    }

    /**
     * @return the string representation of enum entry
     */
    @Override
    public String getName() {
      return name;
    }

    /**
     * @return the numeric wire value of this enum entry
     */
    @Override
    public int getNumber() {
      return number;
    }

    /**
     * @return a converter that maps between this enum's numeric and text representations
     */
    public static ProtoEnum.EnumConverter<CmdStrongChallengeActivityType> converter() {
      return CmdStrongChallengeActivityTypeConverter.INSTANCE;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value, or null if unknown.
     */
    public static CmdStrongChallengeActivityType forNumber(int value) {
      return CmdStrongChallengeActivityTypeConverter.INSTANCE.forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @param other Fallback value in case the value is not known.
     * @return The enum associated with the given numeric wire value, or the fallback value if unknown.
     */
    public static CmdStrongChallengeActivityType forNumberOr(int number,
        CmdStrongChallengeActivityType other) {
      CmdStrongChallengeActivityType value = forNumber(number);
      return value == null ? other : value;
    }

    enum CmdStrongChallengeActivityTypeConverter implements ProtoEnum.EnumConverter<CmdStrongChallengeActivityType> {
      INSTANCE;

      @Override
      public final CmdStrongChallengeActivityType forNumber(final int value) {
        switch(value) {
          case 0: return CmdStrongChallengeActivityTypeNone;
          case 6658: return CmdEnterStrongChallengeActivityStageCsReq;
          case 6624: return CmdEnterStrongChallengeActivityStageScRsp;
          case 6601: return CmdGetStrongChallengeActivityDataCsReq;
          case 6668: return CmdGetStrongChallengeActivityDataScRsp;
          case 6630: return CmdStrongChallengeActivityBattleEndScNotify;
          default: return null;
        }
      }

      @Override
      public final CmdStrongChallengeActivityType forName(final CharSequence value) {
        switch (value.length()) {
          case 34: {
            if (ProtoUtil.isEqual("CmdStrongChallengeActivityTypeNone", value)) {
              return CmdStrongChallengeActivityTypeNone;
            }
            break;
          }
          case 38: {
            if (ProtoUtil.isEqual("CmdGetStrongChallengeActivityDataCsReq", value)) {
              return CmdGetStrongChallengeActivityDataCsReq;
            }
            if (ProtoUtil.isEqual("CmdGetStrongChallengeActivityDataScRsp", value)) {
              return CmdGetStrongChallengeActivityDataScRsp;
            }
            break;
          }
          case 41: {
            if (ProtoUtil.isEqual("CmdEnterStrongChallengeActivityStageCsReq", value)) {
              return CmdEnterStrongChallengeActivityStageCsReq;
            }
            if (ProtoUtil.isEqual("CmdEnterStrongChallengeActivityStageScRsp", value)) {
              return CmdEnterStrongChallengeActivityStageScRsp;
            }
            break;
          }
          case 43: {
            if (ProtoUtil.isEqual("CmdStrongChallengeActivityBattleEndScNotify", value)) {
              return CmdStrongChallengeActivityBattleEndScNotify;
            }
            break;
          }
        }
        return null;
      }
    }
  }
}
