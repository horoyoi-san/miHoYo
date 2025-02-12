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

public final class SwitchLineupIndexScRspOuterClass {
  /**
   * Protobuf type {@code SwitchLineupIndexScRsp}
   */
  public static final class SwitchLineupIndexScRsp extends ProtoMessage<SwitchLineupIndexScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 index = 7;</code>
     */
    private int index;

    /**
     * <code>optional uint32 retcode = 15;</code>
     */
    private int retcode;

    private SwitchLineupIndexScRsp() {
    }

    /**
     * @return a new empty instance of {@code SwitchLineupIndexScRsp}
     */
    public static SwitchLineupIndexScRsp newInstance() {
      return new SwitchLineupIndexScRsp();
    }

    /**
     * <code>optional uint32 index = 7;</code>
     * @return whether the index field is set
     */
    public boolean hasIndex() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 index = 7;</code>
     * @return this
     */
    public SwitchLineupIndexScRsp clearIndex() {
      bitField0_ &= ~0x00000001;
      index = 0;
      return this;
    }

    /**
     * <code>optional uint32 index = 7;</code>
     * @return the index
     */
    public int getIndex() {
      return index;
    }

    /**
     * <code>optional uint32 index = 7;</code>
     * @param value the index to set
     * @return this
     */
    public SwitchLineupIndexScRsp setIndex(final int value) {
      bitField0_ |= 0x00000001;
      index = value;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 15;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 retcode = 15;</code>
     * @return this
     */
    public SwitchLineupIndexScRsp clearRetcode() {
      bitField0_ &= ~0x00000002;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 15;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 15;</code>
     * @param value the retcode to set
     * @return this
     */
    public SwitchLineupIndexScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000002;
      retcode = value;
      return this;
    }

    @Override
    public SwitchLineupIndexScRsp copyFrom(final SwitchLineupIndexScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        index = other.index;
        retcode = other.retcode;
      }
      return this;
    }

    @Override
    public SwitchLineupIndexScRsp mergeFrom(final SwitchLineupIndexScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasIndex()) {
        setIndex(other.index);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      return this;
    }

    @Override
    public SwitchLineupIndexScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      index = 0;
      retcode = 0;
      return this;
    }

    @Override
    public SwitchLineupIndexScRsp clearQuick() {
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
      if (!(o instanceof SwitchLineupIndexScRsp)) {
        return false;
      }
      SwitchLineupIndexScRsp other = (SwitchLineupIndexScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasIndex() || index == other.index)
        && (!hasRetcode() || retcode == other.retcode);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 56);
        output.writeUInt32NoTag(index);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(retcode);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(index);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public SwitchLineupIndexScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 56: {
            // index
            index = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
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
        output.writeUInt32(FieldNames.index, index);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      output.endObject();
    }

    @Override
    public SwitchLineupIndexScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 100346066: {
            if (input.isAtField(FieldNames.index)) {
              if (!input.trySkipNullValue()) {
                index = input.readUInt32();
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
    public SwitchLineupIndexScRsp clone() {
      return new SwitchLineupIndexScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SwitchLineupIndexScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SwitchLineupIndexScRsp(), data).checkInitialized();
    }

    public static SwitchLineupIndexScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SwitchLineupIndexScRsp(), input).checkInitialized();
    }

    public static SwitchLineupIndexScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SwitchLineupIndexScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating SwitchLineupIndexScRsp messages
     */
    public static MessageFactory<SwitchLineupIndexScRsp> getFactory() {
      return SwitchLineupIndexScRspFactory.INSTANCE;
    }

    private enum SwitchLineupIndexScRspFactory implements MessageFactory<SwitchLineupIndexScRsp> {
      INSTANCE;

      @Override
      public SwitchLineupIndexScRsp create() {
        return SwitchLineupIndexScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName index = FieldName.forField("index");

      static final FieldName retcode = FieldName.forField("retcode");
    }
  }
}
