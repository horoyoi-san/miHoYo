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

public final class LeaveTrialActivityCsReqOuterClass {
  /**
   * Protobuf type {@code LeaveTrialActivityCsReq}
   */
  public static final class LeaveTrialActivityCsReq extends ProtoMessage<LeaveTrialActivityCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 stage_id = 15;</code>
     */
    private int stageId;

    private LeaveTrialActivityCsReq() {
    }

    /**
     * @return a new empty instance of {@code LeaveTrialActivityCsReq}
     */
    public static LeaveTrialActivityCsReq newInstance() {
      return new LeaveTrialActivityCsReq();
    }

    /**
     * <code>optional uint32 stage_id = 15;</code>
     * @return whether the stageId field is set
     */
    public boolean hasStageId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 stage_id = 15;</code>
     * @return this
     */
    public LeaveTrialActivityCsReq clearStageId() {
      bitField0_ &= ~0x00000001;
      stageId = 0;
      return this;
    }

    /**
     * <code>optional uint32 stage_id = 15;</code>
     * @return the stageId
     */
    public int getStageId() {
      return stageId;
    }

    /**
     * <code>optional uint32 stage_id = 15;</code>
     * @param value the stageId to set
     * @return this
     */
    public LeaveTrialActivityCsReq setStageId(final int value) {
      bitField0_ |= 0x00000001;
      stageId = value;
      return this;
    }

    @Override
    public LeaveTrialActivityCsReq copyFrom(final LeaveTrialActivityCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        stageId = other.stageId;
      }
      return this;
    }

    @Override
    public LeaveTrialActivityCsReq mergeFrom(final LeaveTrialActivityCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasStageId()) {
        setStageId(other.stageId);
      }
      return this;
    }

    @Override
    public LeaveTrialActivityCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      stageId = 0;
      return this;
    }

    @Override
    public LeaveTrialActivityCsReq clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof LeaveTrialActivityCsReq)) {
        return false;
      }
      LeaveTrialActivityCsReq other = (LeaveTrialActivityCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasStageId() || stageId == other.stageId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(stageId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(stageId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public LeaveTrialActivityCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 120: {
            // stageId
            stageId = input.readUInt32();
            bitField0_ |= 0x00000001;
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
        output.writeUInt32(FieldNames.stageId, stageId);
      }
      output.endObject();
    }

    @Override
    public LeaveTrialActivityCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1897528135:
          case 1306191356: {
            if (input.isAtField(FieldNames.stageId)) {
              if (!input.trySkipNullValue()) {
                stageId = input.readUInt32();
                bitField0_ |= 0x00000001;
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
    public LeaveTrialActivityCsReq clone() {
      return new LeaveTrialActivityCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static LeaveTrialActivityCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new LeaveTrialActivityCsReq(), data).checkInitialized();
    }

    public static LeaveTrialActivityCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new LeaveTrialActivityCsReq(), input).checkInitialized();
    }

    public static LeaveTrialActivityCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new LeaveTrialActivityCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating LeaveTrialActivityCsReq messages
     */
    public static MessageFactory<LeaveTrialActivityCsReq> getFactory() {
      return LeaveTrialActivityCsReqFactory.INSTANCE;
    }

    private enum LeaveTrialActivityCsReqFactory implements MessageFactory<LeaveTrialActivityCsReq> {
      INSTANCE;

      @Override
      public LeaveTrialActivityCsReq create() {
        return LeaveTrialActivityCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName stageId = FieldName.forField("stageId", "stage_id");
    }
  }
}
