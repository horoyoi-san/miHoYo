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

public final class GetEraFlipperDataScRspOuterClass {
  /**
   * Protobuf type {@code GetEraFlipperDataScRsp}
   */
  public static final class GetEraFlipperDataScRsp extends ProtoMessage<GetEraFlipperDataScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 10;</code>
     */
    private int retcode;

    /**
     * <code>optional .EraFlipperDataTypeInfo data = 1;</code>
     */
    private final EraFlipperDataTypeInfoOuterClass.EraFlipperDataTypeInfo data = EraFlipperDataTypeInfoOuterClass.EraFlipperDataTypeInfo.newInstance();

    private GetEraFlipperDataScRsp() {
    }

    /**
     * @return a new empty instance of {@code GetEraFlipperDataScRsp}
     */
    public static GetEraFlipperDataScRsp newInstance() {
      return new GetEraFlipperDataScRsp();
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return this
     */
    public GetEraFlipperDataScRsp clearRetcode() {
      bitField0_ &= ~0x00000001;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 10;</code>
     * @param value the retcode to set
     * @return this
     */
    public GetEraFlipperDataScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>optional .EraFlipperDataTypeInfo data = 1;</code>
     * @return whether the data field is set
     */
    public boolean hasData() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .EraFlipperDataTypeInfo data = 1;</code>
     * @return this
     */
    public GetEraFlipperDataScRsp clearData() {
      bitField0_ &= ~0x00000002;
      data.clear();
      return this;
    }

    /**
     * <code>optional .EraFlipperDataTypeInfo data = 1;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableData()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public EraFlipperDataTypeInfoOuterClass.EraFlipperDataTypeInfo getData() {
      return data;
    }

    /**
     * <code>optional .EraFlipperDataTypeInfo data = 1;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public EraFlipperDataTypeInfoOuterClass.EraFlipperDataTypeInfo getMutableData() {
      bitField0_ |= 0x00000002;
      return data;
    }

    /**
     * <code>optional .EraFlipperDataTypeInfo data = 1;</code>
     * @param value the data to set
     * @return this
     */
    public GetEraFlipperDataScRsp setData(
        final EraFlipperDataTypeInfoOuterClass.EraFlipperDataTypeInfo value) {
      bitField0_ |= 0x00000002;
      data.copyFrom(value);
      return this;
    }

    @Override
    public GetEraFlipperDataScRsp copyFrom(final GetEraFlipperDataScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        data.copyFrom(other.data);
      }
      return this;
    }

    @Override
    public GetEraFlipperDataScRsp mergeFrom(final GetEraFlipperDataScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasData()) {
        getMutableData().mergeFrom(other.data);
      }
      return this;
    }

    @Override
    public GetEraFlipperDataScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      data.clear();
      return this;
    }

    @Override
    public GetEraFlipperDataScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      data.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof GetEraFlipperDataScRsp)) {
        return false;
      }
      GetEraFlipperDataScRsp other = (GetEraFlipperDataScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasData() || data.equals(other.data));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 80);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 10);
        output.writeMessageNoTag(data);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(data);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public GetEraFlipperDataScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 80: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 10) {
              break;
            }
          }
          case 10: {
            // data
            input.readMessage(data);
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
        output.writeMessage(FieldNames.data, data);
      }
      output.endObject();
    }

    @Override
    public GetEraFlipperDataScRsp mergeFrom(final JsonSource input) throws IOException {
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
          case 3076010: {
            if (input.isAtField(FieldNames.data)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(data);
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
    public GetEraFlipperDataScRsp clone() {
      return new GetEraFlipperDataScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static GetEraFlipperDataScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new GetEraFlipperDataScRsp(), data).checkInitialized();
    }

    public static GetEraFlipperDataScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetEraFlipperDataScRsp(), input).checkInitialized();
    }

    public static GetEraFlipperDataScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetEraFlipperDataScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating GetEraFlipperDataScRsp messages
     */
    public static MessageFactory<GetEraFlipperDataScRsp> getFactory() {
      return GetEraFlipperDataScRspFactory.INSTANCE;
    }

    private enum GetEraFlipperDataScRspFactory implements MessageFactory<GetEraFlipperDataScRsp> {
      INSTANCE;

      @Override
      public GetEraFlipperDataScRsp create() {
        return GetEraFlipperDataScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName data = FieldName.forField("data");
    }
  }
}
