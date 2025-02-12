// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import java.io.IOException;
import us.hebi.quickbuf.FieldName;
import us.hebi.quickbuf.InvalidProtocolBufferException;
import us.hebi.quickbuf.JsonSink;
import us.hebi.quickbuf.JsonSource;
import us.hebi.quickbuf.MessageFactory;
import us.hebi.quickbuf.ProtoMessage;
import us.hebi.quickbuf.ProtoSink;
import us.hebi.quickbuf.ProtoSource;

public final class GetBasicInfoScRspOuterClass {
  /**
   * Protobuf type {@code GetBasicInfoScRsp}
   */
  public static final class GetBasicInfoScRsp extends ProtoMessage<GetBasicInfoScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional int64 NextRecoverTime = 4;</code>
     */
    private long nextRecoverTime;

    /**
     * <code>optional int64 LastSetNicknameTime = 14;</code>
     */
    private long lastSetNicknameTime;

    /**
     * <code>optional uint32 GameplayBirthday = 1;</code>
     */
    private int gameplayBirthday;

    /**
     * <code>optional uint32 Gender = 2;</code>
     */
    private int gender;

    /**
     * <code>optional uint32 Retcode = 6;</code>
     */
    private int retcode;

    /**
     * <code>optional uint32 ExchangeTimes = 8;</code>
     */
    private int exchangeTimes;

    /**
     * <code>optional uint32 WeekCocoonFinishedCount = 11;</code>
     */
    private int weekCocoonFinishedCount;

    /**
     * <code>optional uint32 CurDay = 12;</code>
     */
    private int curDay;

    /**
     * <code>optional bool IsGenderSet = 3;</code>
     */
    private boolean isGenderSet;

    /**
     * <code>optional .PlayerSettingInfo PlayerSettingInfo = 15;</code>
     */
    private final PlayerSettingInfoOuterClass.PlayerSettingInfo playerSettingInfo = PlayerSettingInfoOuterClass.PlayerSettingInfo.newInstance();

    private GetBasicInfoScRsp() {
    }

    /**
     * @return a new empty instance of {@code GetBasicInfoScRsp}
     */
    public static GetBasicInfoScRsp newInstance() {
      return new GetBasicInfoScRsp();
    }

    /**
     * <code>optional int64 NextRecoverTime = 4;</code>
     * @return whether the nextRecoverTime field is set
     */
    public boolean hasNextRecoverTime() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional int64 NextRecoverTime = 4;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearNextRecoverTime() {
      bitField0_ &= ~0x00000001;
      nextRecoverTime = 0L;
      return this;
    }

    /**
     * <code>optional int64 NextRecoverTime = 4;</code>
     * @return the nextRecoverTime
     */
    public long getNextRecoverTime() {
      return nextRecoverTime;
    }

    /**
     * <code>optional int64 NextRecoverTime = 4;</code>
     * @param value the nextRecoverTime to set
     * @return this
     */
    public GetBasicInfoScRsp setNextRecoverTime(final long value) {
      bitField0_ |= 0x00000001;
      nextRecoverTime = value;
      return this;
    }

    /**
     * <code>optional int64 LastSetNicknameTime = 14;</code>
     * @return whether the lastSetNicknameTime field is set
     */
    public boolean hasLastSetNicknameTime() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional int64 LastSetNicknameTime = 14;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearLastSetNicknameTime() {
      bitField0_ &= ~0x00000002;
      lastSetNicknameTime = 0L;
      return this;
    }

    /**
     * <code>optional int64 LastSetNicknameTime = 14;</code>
     * @return the lastSetNicknameTime
     */
    public long getLastSetNicknameTime() {
      return lastSetNicknameTime;
    }

    /**
     * <code>optional int64 LastSetNicknameTime = 14;</code>
     * @param value the lastSetNicknameTime to set
     * @return this
     */
    public GetBasicInfoScRsp setLastSetNicknameTime(final long value) {
      bitField0_ |= 0x00000002;
      lastSetNicknameTime = value;
      return this;
    }

    /**
     * <code>optional uint32 GameplayBirthday = 1;</code>
     * @return whether the gameplayBirthday field is set
     */
    public boolean hasGameplayBirthday() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 GameplayBirthday = 1;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearGameplayBirthday() {
      bitField0_ &= ~0x00000004;
      gameplayBirthday = 0;
      return this;
    }

    /**
     * <code>optional uint32 GameplayBirthday = 1;</code>
     * @return the gameplayBirthday
     */
    public int getGameplayBirthday() {
      return gameplayBirthday;
    }

    /**
     * <code>optional uint32 GameplayBirthday = 1;</code>
     * @param value the gameplayBirthday to set
     * @return this
     */
    public GetBasicInfoScRsp setGameplayBirthday(final int value) {
      bitField0_ |= 0x00000004;
      gameplayBirthday = value;
      return this;
    }

    /**
     * <code>optional uint32 Gender = 2;</code>
     * @return whether the gender field is set
     */
    public boolean hasGender() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional uint32 Gender = 2;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearGender() {
      bitField0_ &= ~0x00000008;
      gender = 0;
      return this;
    }

    /**
     * <code>optional uint32 Gender = 2;</code>
     * @return the gender
     */
    public int getGender() {
      return gender;
    }

    /**
     * <code>optional uint32 Gender = 2;</code>
     * @param value the gender to set
     * @return this
     */
    public GetBasicInfoScRsp setGender(final int value) {
      bitField0_ |= 0x00000008;
      gender = value;
      return this;
    }

    /**
     * <code>optional uint32 Retcode = 6;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>optional uint32 Retcode = 6;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearRetcode() {
      bitField0_ &= ~0x00000010;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 Retcode = 6;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 Retcode = 6;</code>
     * @param value the retcode to set
     * @return this
     */
    public GetBasicInfoScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000010;
      retcode = value;
      return this;
    }

    /**
     * <code>optional uint32 ExchangeTimes = 8;</code>
     * @return whether the exchangeTimes field is set
     */
    public boolean hasExchangeTimes() {
      return (bitField0_ & 0x00000020) != 0;
    }

    /**
     * <code>optional uint32 ExchangeTimes = 8;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearExchangeTimes() {
      bitField0_ &= ~0x00000020;
      exchangeTimes = 0;
      return this;
    }

    /**
     * <code>optional uint32 ExchangeTimes = 8;</code>
     * @return the exchangeTimes
     */
    public int getExchangeTimes() {
      return exchangeTimes;
    }

    /**
     * <code>optional uint32 ExchangeTimes = 8;</code>
     * @param value the exchangeTimes to set
     * @return this
     */
    public GetBasicInfoScRsp setExchangeTimes(final int value) {
      bitField0_ |= 0x00000020;
      exchangeTimes = value;
      return this;
    }

    /**
     * <code>optional uint32 WeekCocoonFinishedCount = 11;</code>
     * @return whether the weekCocoonFinishedCount field is set
     */
    public boolean hasWeekCocoonFinishedCount() {
      return (bitField0_ & 0x00000040) != 0;
    }

    /**
     * <code>optional uint32 WeekCocoonFinishedCount = 11;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearWeekCocoonFinishedCount() {
      bitField0_ &= ~0x00000040;
      weekCocoonFinishedCount = 0;
      return this;
    }

    /**
     * <code>optional uint32 WeekCocoonFinishedCount = 11;</code>
     * @return the weekCocoonFinishedCount
     */
    public int getWeekCocoonFinishedCount() {
      return weekCocoonFinishedCount;
    }

    /**
     * <code>optional uint32 WeekCocoonFinishedCount = 11;</code>
     * @param value the weekCocoonFinishedCount to set
     * @return this
     */
    public GetBasicInfoScRsp setWeekCocoonFinishedCount(final int value) {
      bitField0_ |= 0x00000040;
      weekCocoonFinishedCount = value;
      return this;
    }

    /**
     * <code>optional uint32 CurDay = 12;</code>
     * @return whether the curDay field is set
     */
    public boolean hasCurDay() {
      return (bitField0_ & 0x00000080) != 0;
    }

    /**
     * <code>optional uint32 CurDay = 12;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearCurDay() {
      bitField0_ &= ~0x00000080;
      curDay = 0;
      return this;
    }

    /**
     * <code>optional uint32 CurDay = 12;</code>
     * @return the curDay
     */
    public int getCurDay() {
      return curDay;
    }

    /**
     * <code>optional uint32 CurDay = 12;</code>
     * @param value the curDay to set
     * @return this
     */
    public GetBasicInfoScRsp setCurDay(final int value) {
      bitField0_ |= 0x00000080;
      curDay = value;
      return this;
    }

    /**
     * <code>optional bool IsGenderSet = 3;</code>
     * @return whether the isGenderSet field is set
     */
    public boolean hasIsGenderSet() {
      return (bitField0_ & 0x00000100) != 0;
    }

    /**
     * <code>optional bool IsGenderSet = 3;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearIsGenderSet() {
      bitField0_ &= ~0x00000100;
      isGenderSet = false;
      return this;
    }

    /**
     * <code>optional bool IsGenderSet = 3;</code>
     * @return the isGenderSet
     */
    public boolean getIsGenderSet() {
      return isGenderSet;
    }

    /**
     * <code>optional bool IsGenderSet = 3;</code>
     * @param value the isGenderSet to set
     * @return this
     */
    public GetBasicInfoScRsp setIsGenderSet(final boolean value) {
      bitField0_ |= 0x00000100;
      isGenderSet = value;
      return this;
    }

    /**
     * <code>optional .PlayerSettingInfo PlayerSettingInfo = 15;</code>
     * @return whether the playerSettingInfo field is set
     */
    public boolean hasPlayerSettingInfo() {
      return (bitField0_ & 0x00000200) != 0;
    }

    /**
     * <code>optional .PlayerSettingInfo PlayerSettingInfo = 15;</code>
     * @return this
     */
    public GetBasicInfoScRsp clearPlayerSettingInfo() {
      bitField0_ &= ~0x00000200;
      playerSettingInfo.clear();
      return this;
    }

    /**
     * <code>optional .PlayerSettingInfo PlayerSettingInfo = 15;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutablePlayerSettingInfo()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public PlayerSettingInfoOuterClass.PlayerSettingInfo getPlayerSettingInfo() {
      return playerSettingInfo;
    }

    /**
     * <code>optional .PlayerSettingInfo PlayerSettingInfo = 15;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public PlayerSettingInfoOuterClass.PlayerSettingInfo getMutablePlayerSettingInfo() {
      bitField0_ |= 0x00000200;
      return playerSettingInfo;
    }

    /**
     * <code>optional .PlayerSettingInfo PlayerSettingInfo = 15;</code>
     * @param value the playerSettingInfo to set
     * @return this
     */
    public GetBasicInfoScRsp setPlayerSettingInfo(
        final PlayerSettingInfoOuterClass.PlayerSettingInfo value) {
      bitField0_ |= 0x00000200;
      playerSettingInfo.copyFrom(value);
      return this;
    }

    @Override
    public GetBasicInfoScRsp copyFrom(final GetBasicInfoScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        nextRecoverTime = other.nextRecoverTime;
        lastSetNicknameTime = other.lastSetNicknameTime;
        gameplayBirthday = other.gameplayBirthday;
        gender = other.gender;
        retcode = other.retcode;
        exchangeTimes = other.exchangeTimes;
        weekCocoonFinishedCount = other.weekCocoonFinishedCount;
        curDay = other.curDay;
        isGenderSet = other.isGenderSet;
        playerSettingInfo.copyFrom(other.playerSettingInfo);
      }
      return this;
    }

    @Override
    public GetBasicInfoScRsp mergeFrom(final GetBasicInfoScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasNextRecoverTime()) {
        setNextRecoverTime(other.nextRecoverTime);
      }
      if (other.hasLastSetNicknameTime()) {
        setLastSetNicknameTime(other.lastSetNicknameTime);
      }
      if (other.hasGameplayBirthday()) {
        setGameplayBirthday(other.gameplayBirthday);
      }
      if (other.hasGender()) {
        setGender(other.gender);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasExchangeTimes()) {
        setExchangeTimes(other.exchangeTimes);
      }
      if (other.hasWeekCocoonFinishedCount()) {
        setWeekCocoonFinishedCount(other.weekCocoonFinishedCount);
      }
      if (other.hasCurDay()) {
        setCurDay(other.curDay);
      }
      if (other.hasIsGenderSet()) {
        setIsGenderSet(other.isGenderSet);
      }
      if (other.hasPlayerSettingInfo()) {
        getMutablePlayerSettingInfo().mergeFrom(other.playerSettingInfo);
      }
      return this;
    }

    @Override
    public GetBasicInfoScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      nextRecoverTime = 0L;
      lastSetNicknameTime = 0L;
      gameplayBirthday = 0;
      gender = 0;
      retcode = 0;
      exchangeTimes = 0;
      weekCocoonFinishedCount = 0;
      curDay = 0;
      isGenderSet = false;
      playerSettingInfo.clear();
      return this;
    }

    @Override
    public GetBasicInfoScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      playerSettingInfo.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof GetBasicInfoScRsp)) {
        return false;
      }
      GetBasicInfoScRsp other = (GetBasicInfoScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasNextRecoverTime() || nextRecoverTime == other.nextRecoverTime)
        && (!hasLastSetNicknameTime() || lastSetNicknameTime == other.lastSetNicknameTime)
        && (!hasGameplayBirthday() || gameplayBirthday == other.gameplayBirthday)
        && (!hasGender() || gender == other.gender)
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasExchangeTimes() || exchangeTimes == other.exchangeTimes)
        && (!hasWeekCocoonFinishedCount() || weekCocoonFinishedCount == other.weekCocoonFinishedCount)
        && (!hasCurDay() || curDay == other.curDay)
        && (!hasIsGenderSet() || isGenderSet == other.isGenderSet)
        && (!hasPlayerSettingInfo() || playerSettingInfo.equals(other.playerSettingInfo));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 32);
        output.writeInt64NoTag(nextRecoverTime);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 112);
        output.writeInt64NoTag(lastSetNicknameTime);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 8);
        output.writeUInt32NoTag(gameplayBirthday);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 16);
        output.writeUInt32NoTag(gender);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRawByte((byte) 48);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(exchangeTimes);
      }
      if ((bitField0_ & 0x00000040) != 0) {
        output.writeRawByte((byte) 88);
        output.writeUInt32NoTag(weekCocoonFinishedCount);
      }
      if ((bitField0_ & 0x00000080) != 0) {
        output.writeRawByte((byte) 96);
        output.writeUInt32NoTag(curDay);
      }
      if ((bitField0_ & 0x00000100) != 0) {
        output.writeRawByte((byte) 24);
        output.writeBoolNoTag(isGenderSet);
      }
      if ((bitField0_ & 0x00000200) != 0) {
        output.writeRawByte((byte) 122);
        output.writeMessageNoTag(playerSettingInfo);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeInt64SizeNoTag(nextRecoverTime);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeInt64SizeNoTag(lastSetNicknameTime);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(gameplayBirthday);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(gender);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(exchangeTimes);
      }
      if ((bitField0_ & 0x00000040) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(weekCocoonFinishedCount);
      }
      if ((bitField0_ & 0x00000080) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(curDay);
      }
      if ((bitField0_ & 0x00000100) != 0) {
        size += 2;
      }
      if ((bitField0_ & 0x00000200) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(playerSettingInfo);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public GetBasicInfoScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 32: {
            // nextRecoverTime
            nextRecoverTime = input.readInt64();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 112) {
              break;
            }
          }
          case 112: {
            // lastSetNicknameTime
            lastSetNicknameTime = input.readInt64();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 8) {
              break;
            }
          }
          case 8: {
            // gameplayBirthday
            gameplayBirthday = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 16) {
              break;
            }
          }
          case 16: {
            // gender
            gender = input.readUInt32();
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 48) {
              break;
            }
          }
          case 48: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000010;
            tag = input.readTag();
            if (tag != 64) {
              break;
            }
          }
          case 64: {
            // exchangeTimes
            exchangeTimes = input.readUInt32();
            bitField0_ |= 0x00000020;
            tag = input.readTag();
            if (tag != 88) {
              break;
            }
          }
          case 88: {
            // weekCocoonFinishedCount
            weekCocoonFinishedCount = input.readUInt32();
            bitField0_ |= 0x00000040;
            tag = input.readTag();
            if (tag != 96) {
              break;
            }
          }
          case 96: {
            // curDay
            curDay = input.readUInt32();
            bitField0_ |= 0x00000080;
            tag = input.readTag();
            if (tag != 24) {
              break;
            }
          }
          case 24: {
            // isGenderSet
            isGenderSet = input.readBool();
            bitField0_ |= 0x00000100;
            tag = input.readTag();
            if (tag != 122) {
              break;
            }
          }
          case 122: {
            // playerSettingInfo
            input.readMessage(playerSettingInfo);
            bitField0_ |= 0x00000200;
            tag = input.readTag();
            if (tag != 0) {
              break;
            }
          }
          case 0: {
            return this;
          }
          default: {
            if (!input.skipField(tag)) {
              return this;
            }
            tag = input.readTag();
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeInt64(FieldNames.nextRecoverTime, nextRecoverTime);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeInt64(FieldNames.lastSetNicknameTime, lastSetNicknameTime);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.gameplayBirthday, gameplayBirthday);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeUInt32(FieldNames.gender, gender);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000020) != 0) {
        output.writeUInt32(FieldNames.exchangeTimes, exchangeTimes);
      }
      if ((bitField0_ & 0x00000040) != 0) {
        output.writeUInt32(FieldNames.weekCocoonFinishedCount, weekCocoonFinishedCount);
      }
      if ((bitField0_ & 0x00000080) != 0) {
        output.writeUInt32(FieldNames.curDay, curDay);
      }
      if ((bitField0_ & 0x00000100) != 0) {
        output.writeBool(FieldNames.isGenderSet, isGenderSet);
      }
      if ((bitField0_ & 0x00000200) != 0) {
        output.writeMessage(FieldNames.playerSettingInfo, playerSettingInfo);
      }
      output.endObject();
    }

    @Override
    public GetBasicInfoScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1333801278: {
            if (input.isAtField(FieldNames.nextRecoverTime)) {
              if (!input.trySkipNullValue()) {
                nextRecoverTime = input.readInt64();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1763064761: {
            if (input.isAtField(FieldNames.lastSetNicknameTime)) {
              if (!input.trySkipNullValue()) {
                lastSetNicknameTime = input.readInt64();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -156232989: {
            if (input.isAtField(FieldNames.gameplayBirthday)) {
              if (!input.trySkipNullValue()) {
                gameplayBirthday = input.readUInt32();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 2129321697: {
            if (input.isAtField(FieldNames.gender)) {
              if (!input.trySkipNullValue()) {
                gender = input.readUInt32();
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1532377618: {
            if (input.isAtField(FieldNames.retcode)) {
              if (!input.trySkipNullValue()) {
                retcode = input.readUInt32();
                bitField0_ |= 0x00000010;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -2124867901: {
            if (input.isAtField(FieldNames.exchangeTimes)) {
              if (!input.trySkipNullValue()) {
                exchangeTimes = input.readUInt32();
                bitField0_ |= 0x00000020;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 209639058: {
            if (input.isAtField(FieldNames.weekCocoonFinishedCount)) {
              if (!input.trySkipNullValue()) {
                weekCocoonFinishedCount = input.readUInt32();
                bitField0_ |= 0x00000040;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 2029669724: {
            if (input.isAtField(FieldNames.curDay)) {
              if (!input.trySkipNullValue()) {
                curDay = input.readUInt32();
                bitField0_ |= 0x00000080;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1201883209: {
            if (input.isAtField(FieldNames.isGenderSet)) {
              if (!input.trySkipNullValue()) {
                isGenderSet = input.readBool();
                bitField0_ |= 0x00000100;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 260023645: {
            if (input.isAtField(FieldNames.playerSettingInfo)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(playerSettingInfo);
                bitField0_ |= 0x00000200;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          default: {
            input.skipUnknownField();
            break;
          }
        }
      }
      input.endObject();
      return this;
    }

    @Override
    public GetBasicInfoScRsp clone() {
      return new GetBasicInfoScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static GetBasicInfoScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new GetBasicInfoScRsp(), data).checkInitialized();
    }

    public static GetBasicInfoScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetBasicInfoScRsp(), input).checkInitialized();
    }

    public static GetBasicInfoScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetBasicInfoScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating GetBasicInfoScRsp messages
     */
    public static MessageFactory<GetBasicInfoScRsp> getFactory() {
      return GetBasicInfoScRspFactory.INSTANCE;
    }

    private enum GetBasicInfoScRspFactory implements MessageFactory<GetBasicInfoScRsp> {
      INSTANCE;

      @Override
      public GetBasicInfoScRsp create() {
        return GetBasicInfoScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName nextRecoverTime = FieldName.forField("NextRecoverTime");

      static final FieldName lastSetNicknameTime = FieldName.forField("LastSetNicknameTime");

      static final FieldName gameplayBirthday = FieldName.forField("GameplayBirthday");

      static final FieldName gender = FieldName.forField("Gender");

      static final FieldName retcode = FieldName.forField("Retcode");

      static final FieldName exchangeTimes = FieldName.forField("ExchangeTimes");

      static final FieldName weekCocoonFinishedCount = FieldName.forField("WeekCocoonFinishedCount");

      static final FieldName curDay = FieldName.forField("CurDay");

      static final FieldName isGenderSet = FieldName.forField("IsGenderSet");

      static final FieldName playerSettingInfo = FieldName.forField("PlayerSettingInfo");
    }
  }
}
