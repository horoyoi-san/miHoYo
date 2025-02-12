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

public final class ChallengeBuffInfoOuterClass {
  /**
   * Protobuf type {@code ChallengeBuffInfo}
   */
  public static final class ChallengeBuffInfo extends ProtoMessage<ChallengeBuffInfo> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional .StartChallengeBossBuffInfo boss_info = 8;</code>
     */
    private final StartChallengeBossBuffInfoOuterClass.StartChallengeBossBuffInfo bossInfo = StartChallengeBossBuffInfoOuterClass.StartChallengeBossBuffInfo.newInstance();

    /**
     * <code>optional .StartChallengeStoryBuffInfo story_buff_info = 11;</code>
     */
    private final StartChallengeStoryBuffInfoOuterClass.StartChallengeStoryBuffInfo storyBuffInfo = StartChallengeStoryBuffInfoOuterClass.StartChallengeStoryBuffInfo.newInstance();

    private ChallengeBuffInfo() {
    }

    /**
     * @return a new empty instance of {@code ChallengeBuffInfo}
     */
    public static ChallengeBuffInfo newInstance() {
      return new ChallengeBuffInfo();
    }

    public boolean hasChallengeInfoCase() {
      return (((bitField0_ & 0x00000003)) != 0);
    }

    public ChallengeBuffInfo clearChallengeInfoCase() {
      if (hasChallengeInfoCase()) {
        clearBossInfo();
        clearStoryBuffInfo();
      }
      return this;
    }

    private void clearChallengeInfoCaseOtherBossInfo() {
      if ((((bitField0_ & 0x00000002)) != 0)) {
        clearStoryBuffInfo();
      }
    }

    private void clearChallengeInfoCaseOtherStoryBuffInfo() {
      if ((((bitField0_ & 0x00000001)) != 0)) {
        clearBossInfo();
      }
    }

    /**
     * <code>optional .StartChallengeBossBuffInfo boss_info = 8;</code>
     * @return whether the bossInfo field is set
     */
    public boolean hasBossInfo() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional .StartChallengeBossBuffInfo boss_info = 8;</code>
     * @return this
     */
    public ChallengeBuffInfo clearBossInfo() {
      bitField0_ &= ~0x00000001;
      bossInfo.clear();
      return this;
    }

    /**
     * <code>optional .StartChallengeBossBuffInfo boss_info = 8;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableBossInfo()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public StartChallengeBossBuffInfoOuterClass.StartChallengeBossBuffInfo getBossInfo() {
      return bossInfo;
    }

    /**
     * <code>optional .StartChallengeBossBuffInfo boss_info = 8;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public StartChallengeBossBuffInfoOuterClass.StartChallengeBossBuffInfo getMutableBossInfo() {
      clearChallengeInfoCaseOtherBossInfo();
      bitField0_ |= 0x00000001;
      return bossInfo;
    }

    /**
     * <code>optional .StartChallengeBossBuffInfo boss_info = 8;</code>
     * @param value the bossInfo to set
     * @return this
     */
    public ChallengeBuffInfo setBossInfo(
        final StartChallengeBossBuffInfoOuterClass.StartChallengeBossBuffInfo value) {
      clearChallengeInfoCaseOtherBossInfo();
      bitField0_ |= 0x00000001;
      bossInfo.copyFrom(value);
      return this;
    }

    /**
     * <code>optional .StartChallengeStoryBuffInfo story_buff_info = 11;</code>
     * @return whether the storyBuffInfo field is set
     */
    public boolean hasStoryBuffInfo() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .StartChallengeStoryBuffInfo story_buff_info = 11;</code>
     * @return this
     */
    public ChallengeBuffInfo clearStoryBuffInfo() {
      bitField0_ &= ~0x00000002;
      storyBuffInfo.clear();
      return this;
    }

    /**
     * <code>optional .StartChallengeStoryBuffInfo story_buff_info = 11;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableStoryBuffInfo()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public StartChallengeStoryBuffInfoOuterClass.StartChallengeStoryBuffInfo getStoryBuffInfo() {
      return storyBuffInfo;
    }

    /**
     * <code>optional .StartChallengeStoryBuffInfo story_buff_info = 11;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public StartChallengeStoryBuffInfoOuterClass.StartChallengeStoryBuffInfo getMutableStoryBuffInfo(
        ) {
      clearChallengeInfoCaseOtherStoryBuffInfo();
      bitField0_ |= 0x00000002;
      return storyBuffInfo;
    }

    /**
     * <code>optional .StartChallengeStoryBuffInfo story_buff_info = 11;</code>
     * @param value the storyBuffInfo to set
     * @return this
     */
    public ChallengeBuffInfo setStoryBuffInfo(
        final StartChallengeStoryBuffInfoOuterClass.StartChallengeStoryBuffInfo value) {
      clearChallengeInfoCaseOtherStoryBuffInfo();
      bitField0_ |= 0x00000002;
      storyBuffInfo.copyFrom(value);
      return this;
    }

    @Override
    public ChallengeBuffInfo copyFrom(final ChallengeBuffInfo other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        bossInfo.copyFrom(other.bossInfo);
        storyBuffInfo.copyFrom(other.storyBuffInfo);
      }
      return this;
    }

    @Override
    public ChallengeBuffInfo mergeFrom(final ChallengeBuffInfo other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasBossInfo()) {
        getMutableBossInfo().mergeFrom(other.bossInfo);
      }
      if (other.hasStoryBuffInfo()) {
        getMutableStoryBuffInfo().mergeFrom(other.storyBuffInfo);
      }
      return this;
    }

    @Override
    public ChallengeBuffInfo clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      bossInfo.clear();
      storyBuffInfo.clear();
      return this;
    }

    @Override
    public ChallengeBuffInfo clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      bossInfo.clearQuick();
      storyBuffInfo.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ChallengeBuffInfo)) {
        return false;
      }
      ChallengeBuffInfo other = (ChallengeBuffInfo) o;
      return bitField0_ == other.bitField0_
        && (!hasBossInfo() || bossInfo.equals(other.bossInfo))
        && (!hasStoryBuffInfo() || storyBuffInfo.equals(other.storyBuffInfo));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 66);
        output.writeMessageNoTag(bossInfo);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 90);
        output.writeMessageNoTag(storyBuffInfo);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(bossInfo);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(storyBuffInfo);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public ChallengeBuffInfo mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 66: {
            // bossInfo
            clearChallengeInfoCaseOtherBossInfo();
            input.readMessage(bossInfo);
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 90) {
              break;
            }
          }
          case 90: {
            // storyBuffInfo
            clearChallengeInfoCaseOtherStoryBuffInfo();
            input.readMessage(storyBuffInfo);
            bitField0_ |= 0x00000002;
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
        output.writeMessage(FieldNames.bossInfo, bossInfo);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeMessage(FieldNames.storyBuffInfo, storyBuffInfo);
      }
      output.endObject();
    }

    @Override
    public ChallengeBuffInfo mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 2126222779:
          case 1508572736: {
            if (input.isAtField(FieldNames.bossInfo)) {
              if (!input.trySkipNullValue()) {
                clearChallengeInfoCaseOtherBossInfo();
                input.readMessage(bossInfo);
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1230610506:
          case -1733882288: {
            if (input.isAtField(FieldNames.storyBuffInfo)) {
              if (!input.trySkipNullValue()) {
                clearChallengeInfoCaseOtherStoryBuffInfo();
                input.readMessage(storyBuffInfo);
                bitField0_ |= 0x00000002;
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
    public ChallengeBuffInfo clone() {
      return new ChallengeBuffInfo().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static ChallengeBuffInfo parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new ChallengeBuffInfo(), data).checkInitialized();
    }

    public static ChallengeBuffInfo parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChallengeBuffInfo(), input).checkInitialized();
    }

    public static ChallengeBuffInfo parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChallengeBuffInfo(), input).checkInitialized();
    }

    /**
     * @return factory for creating ChallengeBuffInfo messages
     */
    public static MessageFactory<ChallengeBuffInfo> getFactory() {
      return ChallengeBuffInfoFactory.INSTANCE;
    }

    private enum ChallengeBuffInfoFactory implements MessageFactory<ChallengeBuffInfo> {
      INSTANCE;

      @Override
      public ChallengeBuffInfo create() {
        return ChallengeBuffInfo.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName bossInfo = FieldName.forField("bossInfo", "boss_info");

      static final FieldName storyBuffInfo = FieldName.forField("storyBuffInfo", "story_buff_info");
    }
  }
}
