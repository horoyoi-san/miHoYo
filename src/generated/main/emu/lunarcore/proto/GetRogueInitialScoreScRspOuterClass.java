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

public final class GetRogueInitialScoreScRspOuterClass {
  /**
   * Protobuf type {@code GetRogueInitialScoreScRsp}
   */
  public static final class GetRogueInitialScoreScRsp extends ProtoMessage<GetRogueInitialScoreScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 14;</code>
     */
    private int retcode;

    /**
     * <code>optional .RogueScoreRewardInfo rogue_score_info = 4;</code>
     */
    private final RogueScoreRewardInfoOuterClass.RogueScoreRewardInfo rogueScoreInfo = RogueScoreRewardInfoOuterClass.RogueScoreRewardInfo.newInstance();

    private GetRogueInitialScoreScRsp() {
    }

    /**
     * @return a new empty instance of {@code GetRogueInitialScoreScRsp}
     */
    public static GetRogueInitialScoreScRsp newInstance() {
      return new GetRogueInitialScoreScRsp();
    }

    /**
     * <code>optional uint32 retcode = 14;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 retcode = 14;</code>
     * @return this
     */
    public GetRogueInitialScoreScRsp clearRetcode() {
      bitField0_ &= ~0x00000001;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 14;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 14;</code>
     * @param value the retcode to set
     * @return this
     */
    public GetRogueInitialScoreScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>optional .RogueScoreRewardInfo rogue_score_info = 4;</code>
     * @return whether the rogueScoreInfo field is set
     */
    public boolean hasRogueScoreInfo() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .RogueScoreRewardInfo rogue_score_info = 4;</code>
     * @return this
     */
    public GetRogueInitialScoreScRsp clearRogueScoreInfo() {
      bitField0_ &= ~0x00000002;
      rogueScoreInfo.clear();
      return this;
    }

    /**
     * <code>optional .RogueScoreRewardInfo rogue_score_info = 4;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableRogueScoreInfo()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RogueScoreRewardInfoOuterClass.RogueScoreRewardInfo getRogueScoreInfo() {
      return rogueScoreInfo;
    }

    /**
     * <code>optional .RogueScoreRewardInfo rogue_score_info = 4;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RogueScoreRewardInfoOuterClass.RogueScoreRewardInfo getMutableRogueScoreInfo() {
      bitField0_ |= 0x00000002;
      return rogueScoreInfo;
    }

    /**
     * <code>optional .RogueScoreRewardInfo rogue_score_info = 4;</code>
     * @param value the rogueScoreInfo to set
     * @return this
     */
    public GetRogueInitialScoreScRsp setRogueScoreInfo(
        final RogueScoreRewardInfoOuterClass.RogueScoreRewardInfo value) {
      bitField0_ |= 0x00000002;
      rogueScoreInfo.copyFrom(value);
      return this;
    }

    @Override
    public GetRogueInitialScoreScRsp copyFrom(final GetRogueInitialScoreScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        rogueScoreInfo.copyFrom(other.rogueScoreInfo);
      }
      return this;
    }

    @Override
    public GetRogueInitialScoreScRsp mergeFrom(final GetRogueInitialScoreScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasRogueScoreInfo()) {
        getMutableRogueScoreInfo().mergeFrom(other.rogueScoreInfo);
      }
      return this;
    }

    @Override
    public GetRogueInitialScoreScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      rogueScoreInfo.clear();
      return this;
    }

    @Override
    public GetRogueInitialScoreScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      rogueScoreInfo.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof GetRogueInitialScoreScRsp)) {
        return false;
      }
      GetRogueInitialScoreScRsp other = (GetRogueInitialScoreScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasRogueScoreInfo() || rogueScoreInfo.equals(other.rogueScoreInfo));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 112);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 34);
        output.writeMessageNoTag(rogueScoreInfo);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(rogueScoreInfo);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public GetRogueInitialScoreScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 112: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 34) {
              break;
            }
          }
          case 34: {
            // rogueScoreInfo
            input.readMessage(rogueScoreInfo);
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
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeMessage(FieldNames.rogueScoreInfo, rogueScoreInfo);
      }
      output.endObject();
    }

    @Override
    public GetRogueInitialScoreScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1097936398: {
            if (input.isAtField(FieldNames.retcode)) {
              if (!input.trySkipNullValue()) {
                retcode = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 2078217638:
          case -208816704: {
            if (input.isAtField(FieldNames.rogueScoreInfo)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(rogueScoreInfo);
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
    public GetRogueInitialScoreScRsp clone() {
      return new GetRogueInitialScoreScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static GetRogueInitialScoreScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new GetRogueInitialScoreScRsp(), data).checkInitialized();
    }

    public static GetRogueInitialScoreScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetRogueInitialScoreScRsp(), input).checkInitialized();
    }

    public static GetRogueInitialScoreScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetRogueInitialScoreScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating GetRogueInitialScoreScRsp messages
     */
    public static MessageFactory<GetRogueInitialScoreScRsp> getFactory() {
      return GetRogueInitialScoreScRspFactory.INSTANCE;
    }

    private enum GetRogueInitialScoreScRspFactory implements MessageFactory<GetRogueInitialScoreScRsp> {
      INSTANCE;

      @Override
      public GetRogueInitialScoreScRsp create() {
        return GetRogueInitialScoreScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName rogueScoreInfo = FieldName.forField("rogueScoreInfo", "rogue_score_info");
    }
  }
}
