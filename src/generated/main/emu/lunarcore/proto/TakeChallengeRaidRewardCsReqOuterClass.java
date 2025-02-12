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

public final class TakeChallengeRaidRewardCsReqOuterClass {
  /**
   * Protobuf type {@code TakeChallengeRaidRewardCsReq}
   */
  public static final class TakeChallengeRaidRewardCsReq extends ProtoMessage<TakeChallengeRaidRewardCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 reward_id = 1;</code>
     */
    private int rewardId;

    private TakeChallengeRaidRewardCsReq() {
    }

    /**
     * @return a new empty instance of {@code TakeChallengeRaidRewardCsReq}
     */
    public static TakeChallengeRaidRewardCsReq newInstance() {
      return new TakeChallengeRaidRewardCsReq();
    }

    /**
     * <code>optional uint32 reward_id = 1;</code>
     * @return whether the rewardId field is set
     */
    public boolean hasRewardId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 reward_id = 1;</code>
     * @return this
     */
    public TakeChallengeRaidRewardCsReq clearRewardId() {
      bitField0_ &= ~0x00000001;
      rewardId = 0;
      return this;
    }

    /**
     * <code>optional uint32 reward_id = 1;</code>
     * @return the rewardId
     */
    public int getRewardId() {
      return rewardId;
    }

    /**
     * <code>optional uint32 reward_id = 1;</code>
     * @param value the rewardId to set
     * @return this
     */
    public TakeChallengeRaidRewardCsReq setRewardId(final int value) {
      bitField0_ |= 0x00000001;
      rewardId = value;
      return this;
    }

    @Override
    public TakeChallengeRaidRewardCsReq copyFrom(final TakeChallengeRaidRewardCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        rewardId = other.rewardId;
      }
      return this;
    }

    @Override
    public TakeChallengeRaidRewardCsReq mergeFrom(final TakeChallengeRaidRewardCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRewardId()) {
        setRewardId(other.rewardId);
      }
      return this;
    }

    @Override
    public TakeChallengeRaidRewardCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      rewardId = 0;
      return this;
    }

    @Override
    public TakeChallengeRaidRewardCsReq clearQuick() {
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
      if (!(o instanceof TakeChallengeRaidRewardCsReq)) {
        return false;
      }
      TakeChallengeRaidRewardCsReq other = (TakeChallengeRaidRewardCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasRewardId() || rewardId == other.rewardId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 8);
        output.writeUInt32NoTag(rewardId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(rewardId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public TakeChallengeRaidRewardCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 8: {
            // rewardId
            rewardId = input.readUInt32();
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
        output.writeUInt32(FieldNames.rewardId, rewardId);
      }
      output.endObject();
    }

    @Override
    public TakeChallengeRaidRewardCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -239581014:
          case 1162944555: {
            if (input.isAtField(FieldNames.rewardId)) {
              if (!input.trySkipNullValue()) {
                rewardId = input.readUInt32();
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
    public TakeChallengeRaidRewardCsReq clone() {
      return new TakeChallengeRaidRewardCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static TakeChallengeRaidRewardCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new TakeChallengeRaidRewardCsReq(), data).checkInitialized();
    }

    public static TakeChallengeRaidRewardCsReq parseFrom(final ProtoSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new TakeChallengeRaidRewardCsReq(), input).checkInitialized();
    }

    public static TakeChallengeRaidRewardCsReq parseFrom(final JsonSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new TakeChallengeRaidRewardCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating TakeChallengeRaidRewardCsReq messages
     */
    public static MessageFactory<TakeChallengeRaidRewardCsReq> getFactory() {
      return TakeChallengeRaidRewardCsReqFactory.INSTANCE;
    }

    private enum TakeChallengeRaidRewardCsReqFactory implements MessageFactory<TakeChallengeRaidRewardCsReq> {
      INSTANCE;

      @Override
      public TakeChallengeRaidRewardCsReq create() {
        return TakeChallengeRaidRewardCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName rewardId = FieldName.forField("rewardId", "reward_id");
    }
  }
}
