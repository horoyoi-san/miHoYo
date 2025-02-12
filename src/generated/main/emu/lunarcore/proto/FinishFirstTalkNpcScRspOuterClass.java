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

public final class FinishFirstTalkNpcScRspOuterClass {
  /**
   * Protobuf type {@code FinishFirstTalkNpcScRsp}
   */
  public static final class FinishFirstTalkNpcScRsp extends ProtoMessage<FinishFirstTalkNpcScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 first_npc_id = 1;</code>
     */
    private int firstNpcId;

    /**
     * <code>optional uint32 retcode = 12;</code>
     */
    private int retcode;

    private FinishFirstTalkNpcScRsp() {
    }

    /**
     * @return a new empty instance of {@code FinishFirstTalkNpcScRsp}
     */
    public static FinishFirstTalkNpcScRsp newInstance() {
      return new FinishFirstTalkNpcScRsp();
    }

    /**
     * <code>optional uint32 first_npc_id = 1;</code>
     * @return whether the firstNpcId field is set
     */
    public boolean hasFirstNpcId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 first_npc_id = 1;</code>
     * @return this
     */
    public FinishFirstTalkNpcScRsp clearFirstNpcId() {
      bitField0_ &= ~0x00000001;
      firstNpcId = 0;
      return this;
    }

    /**
     * <code>optional uint32 first_npc_id = 1;</code>
     * @return the firstNpcId
     */
    public int getFirstNpcId() {
      return firstNpcId;
    }

    /**
     * <code>optional uint32 first_npc_id = 1;</code>
     * @param value the firstNpcId to set
     * @return this
     */
    public FinishFirstTalkNpcScRsp setFirstNpcId(final int value) {
      bitField0_ |= 0x00000001;
      firstNpcId = value;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return this
     */
    public FinishFirstTalkNpcScRsp clearRetcode() {
      bitField0_ &= ~0x00000002;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 12;</code>
     * @param value the retcode to set
     * @return this
     */
    public FinishFirstTalkNpcScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000002;
      retcode = value;
      return this;
    }

    @Override
    public FinishFirstTalkNpcScRsp copyFrom(final FinishFirstTalkNpcScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        firstNpcId = other.firstNpcId;
        retcode = other.retcode;
      }
      return this;
    }

    @Override
    public FinishFirstTalkNpcScRsp mergeFrom(final FinishFirstTalkNpcScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasFirstNpcId()) {
        setFirstNpcId(other.firstNpcId);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      return this;
    }

    @Override
    public FinishFirstTalkNpcScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      firstNpcId = 0;
      retcode = 0;
      return this;
    }

    @Override
    public FinishFirstTalkNpcScRsp clearQuick() {
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
      if (!(o instanceof FinishFirstTalkNpcScRsp)) {
        return false;
      }
      FinishFirstTalkNpcScRsp other = (FinishFirstTalkNpcScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasFirstNpcId() || firstNpcId == other.firstNpcId)
        && (!hasRetcode() || retcode == other.retcode);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 8);
        output.writeUInt32NoTag(firstNpcId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 96);
        output.writeUInt32NoTag(retcode);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(firstNpcId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public FinishFirstTalkNpcScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 8: {
            // firstNpcId
            firstNpcId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 96) {
              break;
            }
          }
          case 96: {
            // retcode
            retcode = input.readUInt32();
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
        output.writeUInt32(FieldNames.firstNpcId, firstNpcId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      output.endObject();
    }

    @Override
    public FinishFirstTalkNpcScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -176624884:
          case -74607704: {
            if (input.isAtField(FieldNames.firstNpcId)) {
              if (!input.trySkipNullValue()) {
                firstNpcId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1097936398: {
            if (input.isAtField(FieldNames.retcode)) {
              if (!input.trySkipNullValue()) {
                retcode = input.readUInt32();
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
    public FinishFirstTalkNpcScRsp clone() {
      return new FinishFirstTalkNpcScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static FinishFirstTalkNpcScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new FinishFirstTalkNpcScRsp(), data).checkInitialized();
    }

    public static FinishFirstTalkNpcScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new FinishFirstTalkNpcScRsp(), input).checkInitialized();
    }

    public static FinishFirstTalkNpcScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new FinishFirstTalkNpcScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating FinishFirstTalkNpcScRsp messages
     */
    public static MessageFactory<FinishFirstTalkNpcScRsp> getFactory() {
      return FinishFirstTalkNpcScRspFactory.INSTANCE;
    }

    private enum FinishFirstTalkNpcScRspFactory implements MessageFactory<FinishFirstTalkNpcScRsp> {
      INSTANCE;

      @Override
      public FinishFirstTalkNpcScRsp create() {
        return FinishFirstTalkNpcScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName firstNpcId = FieldName.forField("firstNpcId", "first_npc_id");

      static final FieldName retcode = FieldName.forField("retcode");
    }
  }
}
