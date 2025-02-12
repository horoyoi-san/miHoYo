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

public final class StrongChallengeActivityDataOuterClass {
  /**
   * Protobuf type {@code StrongChallengeActivityData}
   */
  public static final class StrongChallengeActivityData extends ProtoMessage<StrongChallengeActivityData> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 stage_score = 3;</code>
     */
    private int stageScore;

    /**
     * <code>optional uint32 panel_id = 5;</code>
     */
    private int panelId;

    /**
     * <code>optional uint32 stage_id = 8;</code>
     */
    private int stageId;

    /**
     * <code>optional uint32 JGBAINFDBAN = 9;</code>
     */
    private int jGBAINFDBAN;

    /**
     * <code>optional .StrongChallengeAvatarData AHINPCKGKJG = 1;</code>
     */
    private final StrongChallengeAvatarDataOuterClass.StrongChallengeAvatarData aHINPCKGKJG = StrongChallengeAvatarDataOuterClass.StrongChallengeAvatarData.newInstance();

    private StrongChallengeActivityData() {
    }

    /**
     * @return a new empty instance of {@code StrongChallengeActivityData}
     */
    public static StrongChallengeActivityData newInstance() {
      return new StrongChallengeActivityData();
    }

    /**
     * <code>optional uint32 stage_score = 3;</code>
     * @return whether the stageScore field is set
     */
    public boolean hasStageScore() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 stage_score = 3;</code>
     * @return this
     */
    public StrongChallengeActivityData clearStageScore() {
      bitField0_ &= ~0x00000001;
      stageScore = 0;
      return this;
    }

    /**
     * <code>optional uint32 stage_score = 3;</code>
     * @return the stageScore
     */
    public int getStageScore() {
      return stageScore;
    }

    /**
     * <code>optional uint32 stage_score = 3;</code>
     * @param value the stageScore to set
     * @return this
     */
    public StrongChallengeActivityData setStageScore(final int value) {
      bitField0_ |= 0x00000001;
      stageScore = value;
      return this;
    }

    /**
     * <code>optional uint32 panel_id = 5;</code>
     * @return whether the panelId field is set
     */
    public boolean hasPanelId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 panel_id = 5;</code>
     * @return this
     */
    public StrongChallengeActivityData clearPanelId() {
      bitField0_ &= ~0x00000002;
      panelId = 0;
      return this;
    }

    /**
     * <code>optional uint32 panel_id = 5;</code>
     * @return the panelId
     */
    public int getPanelId() {
      return panelId;
    }

    /**
     * <code>optional uint32 panel_id = 5;</code>
     * @param value the panelId to set
     * @return this
     */
    public StrongChallengeActivityData setPanelId(final int value) {
      bitField0_ |= 0x00000002;
      panelId = value;
      return this;
    }

    /**
     * <code>optional uint32 stage_id = 8;</code>
     * @return whether the stageId field is set
     */
    public boolean hasStageId() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 stage_id = 8;</code>
     * @return this
     */
    public StrongChallengeActivityData clearStageId() {
      bitField0_ &= ~0x00000004;
      stageId = 0;
      return this;
    }

    /**
     * <code>optional uint32 stage_id = 8;</code>
     * @return the stageId
     */
    public int getStageId() {
      return stageId;
    }

    /**
     * <code>optional uint32 stage_id = 8;</code>
     * @param value the stageId to set
     * @return this
     */
    public StrongChallengeActivityData setStageId(final int value) {
      bitField0_ |= 0x00000004;
      stageId = value;
      return this;
    }

    /**
     * <code>optional uint32 JGBAINFDBAN = 9;</code>
     * @return whether the jGBAINFDBAN field is set
     */
    public boolean hasJGBAINFDBAN() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional uint32 JGBAINFDBAN = 9;</code>
     * @return this
     */
    public StrongChallengeActivityData clearJGBAINFDBAN() {
      bitField0_ &= ~0x00000008;
      jGBAINFDBAN = 0;
      return this;
    }

    /**
     * <code>optional uint32 JGBAINFDBAN = 9;</code>
     * @return the jGBAINFDBAN
     */
    public int getJGBAINFDBAN() {
      return jGBAINFDBAN;
    }

    /**
     * <code>optional uint32 JGBAINFDBAN = 9;</code>
     * @param value the jGBAINFDBAN to set
     * @return this
     */
    public StrongChallengeActivityData setJGBAINFDBAN(final int value) {
      bitField0_ |= 0x00000008;
      jGBAINFDBAN = value;
      return this;
    }

    /**
     * <code>optional .StrongChallengeAvatarData AHINPCKGKJG = 1;</code>
     * @return whether the aHINPCKGKJG field is set
     */
    public boolean hasAHINPCKGKJG() {
      return (bitField0_ & 0x00000010) != 0;
    }

    /**
     * <code>optional .StrongChallengeAvatarData AHINPCKGKJG = 1;</code>
     * @return this
     */
    public StrongChallengeActivityData clearAHINPCKGKJG() {
      bitField0_ &= ~0x00000010;
      aHINPCKGKJG.clear();
      return this;
    }

    /**
     * <code>optional .StrongChallengeAvatarData AHINPCKGKJG = 1;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableAHINPCKGKJG()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public StrongChallengeAvatarDataOuterClass.StrongChallengeAvatarData getAHINPCKGKJG() {
      return aHINPCKGKJG;
    }

    /**
     * <code>optional .StrongChallengeAvatarData AHINPCKGKJG = 1;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public StrongChallengeAvatarDataOuterClass.StrongChallengeAvatarData getMutableAHINPCKGKJG() {
      bitField0_ |= 0x00000010;
      return aHINPCKGKJG;
    }

    /**
     * <code>optional .StrongChallengeAvatarData AHINPCKGKJG = 1;</code>
     * @param value the aHINPCKGKJG to set
     * @return this
     */
    public StrongChallengeActivityData setAHINPCKGKJG(
        final StrongChallengeAvatarDataOuterClass.StrongChallengeAvatarData value) {
      bitField0_ |= 0x00000010;
      aHINPCKGKJG.copyFrom(value);
      return this;
    }

    @Override
    public StrongChallengeActivityData copyFrom(final StrongChallengeActivityData other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        stageScore = other.stageScore;
        panelId = other.panelId;
        stageId = other.stageId;
        jGBAINFDBAN = other.jGBAINFDBAN;
        aHINPCKGKJG.copyFrom(other.aHINPCKGKJG);
      }
      return this;
    }

    @Override
    public StrongChallengeActivityData mergeFrom(final StrongChallengeActivityData other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasStageScore()) {
        setStageScore(other.stageScore);
      }
      if (other.hasPanelId()) {
        setPanelId(other.panelId);
      }
      if (other.hasStageId()) {
        setStageId(other.stageId);
      }
      if (other.hasJGBAINFDBAN()) {
        setJGBAINFDBAN(other.jGBAINFDBAN);
      }
      if (other.hasAHINPCKGKJG()) {
        getMutableAHINPCKGKJG().mergeFrom(other.aHINPCKGKJG);
      }
      return this;
    }

    @Override
    public StrongChallengeActivityData clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      stageScore = 0;
      panelId = 0;
      stageId = 0;
      jGBAINFDBAN = 0;
      aHINPCKGKJG.clear();
      return this;
    }

    @Override
    public StrongChallengeActivityData clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      aHINPCKGKJG.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof StrongChallengeActivityData)) {
        return false;
      }
      StrongChallengeActivityData other = (StrongChallengeActivityData) o;
      return bitField0_ == other.bitField0_
        && (!hasStageScore() || stageScore == other.stageScore)
        && (!hasPanelId() || panelId == other.panelId)
        && (!hasStageId() || stageId == other.stageId)
        && (!hasJGBAINFDBAN() || jGBAINFDBAN == other.jGBAINFDBAN)
        && (!hasAHINPCKGKJG() || aHINPCKGKJG.equals(other.aHINPCKGKJG));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 24);
        output.writeUInt32NoTag(stageScore);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 40);
        output.writeUInt32NoTag(panelId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(stageId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 72);
        output.writeUInt32NoTag(jGBAINFDBAN);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeRawByte((byte) 10);
        output.writeMessageNoTag(aHINPCKGKJG);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(stageScore);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(panelId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(stageId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(jGBAINFDBAN);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(aHINPCKGKJG);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public StrongChallengeActivityData mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 24: {
            // stageScore
            stageScore = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 40) {
              break;
            }
          }
          case 40: {
            // panelId
            panelId = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 64) {
              break;
            }
          }
          case 64: {
            // stageId
            stageId = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 72) {
              break;
            }
          }
          case 72: {
            // jGBAINFDBAN
            jGBAINFDBAN = input.readUInt32();
            bitField0_ |= 0x00000008;
            tag = input.readTag();
            if (tag != 10) {
              break;
            }
          }
          case 10: {
            // aHINPCKGKJG
            input.readMessage(aHINPCKGKJG);
            bitField0_ |= 0x00000010;
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
        output.writeUInt32(FieldNames.stageScore, stageScore);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.panelId, panelId);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.stageId, stageId);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeUInt32(FieldNames.jGBAINFDBAN, jGBAINFDBAN);
      }
      if ((bitField0_ & 0x00000010) != 0) {
        output.writeMessage(FieldNames.aHINPCKGKJG, aHINPCKGKJG);
      }
      output.endObject();
    }

    @Override
    public StrongChallengeActivityData mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1108195892:
          case 352300561: {
            if (input.isAtField(FieldNames.stageScore)) {
              if (!input.trySkipNullValue()) {
                stageScore = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -797072833:
          case 1060567350: {
            if (input.isAtField(FieldNames.panelId)) {
              if (!input.trySkipNullValue()) {
                panelId = input.readUInt32();
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1897528135:
          case 1306191356: {
            if (input.isAtField(FieldNames.stageId)) {
              if (!input.trySkipNullValue()) {
                stageId = input.readUInt32();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 50743984: {
            if (input.isAtField(FieldNames.jGBAINFDBAN)) {
              if (!input.trySkipNullValue()) {
                jGBAINFDBAN = input.readUInt32();
                bitField0_ |= 0x00000008;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1868695757: {
            if (input.isAtField(FieldNames.aHINPCKGKJG)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(aHINPCKGKJG);
                bitField0_ |= 0x00000010;
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
    public StrongChallengeActivityData clone() {
      return new StrongChallengeActivityData().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static StrongChallengeActivityData parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new StrongChallengeActivityData(), data).checkInitialized();
    }

    public static StrongChallengeActivityData parseFrom(final ProtoSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new StrongChallengeActivityData(), input).checkInitialized();
    }

    public static StrongChallengeActivityData parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new StrongChallengeActivityData(), input).checkInitialized();
    }

    /**
     * @return factory for creating StrongChallengeActivityData messages
     */
    public static MessageFactory<StrongChallengeActivityData> getFactory() {
      return StrongChallengeActivityDataFactory.INSTANCE;
    }

    private enum StrongChallengeActivityDataFactory implements MessageFactory<StrongChallengeActivityData> {
      INSTANCE;

      @Override
      public StrongChallengeActivityData create() {
        return StrongChallengeActivityData.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName stageScore = FieldName.forField("stageScore", "stage_score");

      static final FieldName panelId = FieldName.forField("panelId", "panel_id");

      static final FieldName stageId = FieldName.forField("stageId", "stage_id");

      static final FieldName jGBAINFDBAN = FieldName.forField("JGBAINFDBAN");

      static final FieldName aHINPCKGKJG = FieldName.forField("AHINPCKGKJG");
    }
  }
}
