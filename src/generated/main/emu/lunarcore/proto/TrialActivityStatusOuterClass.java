// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import us.hebi.quickbuf.ProtoEnum;
import us.hebi.quickbuf.ProtoUtil;

public final class TrialActivityStatusOuterClass {
  /**
   * Protobuf enum {@code TrialActivityStatus}
   */
  public enum TrialActivityStatus implements ProtoEnum<TrialActivityStatus> {
    /**
     * <code>TRIAL_ACTIVITY_STATUS_NONE = 0;</code>
     */
    TRIAL_ACTIVITY_STATUS_NONE("TRIAL_ACTIVITY_STATUS_NONE", 0),

    /**
     * <code>TRIAL_ACTIVITY_STATUS_FINISH = 1;</code>
     */
    TRIAL_ACTIVITY_STATUS_FINISH("TRIAL_ACTIVITY_STATUS_FINISH", 1);

    /**
     * <code>TRIAL_ACTIVITY_STATUS_NONE = 0;</code>
     */
    public static final int TRIAL_ACTIVITY_STATUS_NONE_VALUE = 0;

    /**
     * <code>TRIAL_ACTIVITY_STATUS_FINISH = 1;</code>
     */
    public static final int TRIAL_ACTIVITY_STATUS_FINISH_VALUE = 1;

    private final String name;

    private final int number;

    private TrialActivityStatus(String name, int number) {
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
    public static ProtoEnum.EnumConverter<TrialActivityStatus> converter() {
      return TrialActivityStatusConverter.INSTANCE;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value, or null if unknown.
     */
    public static TrialActivityStatus forNumber(int value) {
      return TrialActivityStatusConverter.INSTANCE.forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @param other Fallback value in case the value is not known.
     * @return The enum associated with the given numeric wire value, or the fallback value if unknown.
     */
    public static TrialActivityStatus forNumberOr(int number, TrialActivityStatus other) {
      TrialActivityStatus value = forNumber(number);
      return value == null ? other : value;
    }

    enum TrialActivityStatusConverter implements ProtoEnum.EnumConverter<TrialActivityStatus> {
      INSTANCE;

      private static final TrialActivityStatus[] lookup = new TrialActivityStatus[2];

      static {
        lookup[0] = TRIAL_ACTIVITY_STATUS_NONE;
        lookup[1] = TRIAL_ACTIVITY_STATUS_FINISH;
      }

      @Override
      public final TrialActivityStatus forNumber(final int value) {
        if (value >= 0 && value < lookup.length) {
          return lookup[value];
        }
        return null;
      }

      @Override
      public final TrialActivityStatus forName(final CharSequence value) {
        if (value.length() == 26) {
          if (ProtoUtil.isEqual("TRIAL_ACTIVITY_STATUS_NONE", value)) {
            return TRIAL_ACTIVITY_STATUS_NONE;
          }
        }
        if (value.length() == 28) {
          if (ProtoUtil.isEqual("TRIAL_ACTIVITY_STATUS_FINISH", value)) {
            return TRIAL_ACTIVITY_STATUS_FINISH;
          }
        }
        return null;
      }
    }
  }
}
