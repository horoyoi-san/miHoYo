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

public final class UseItemScRspOuterClass {
  /**
   * Protobuf type {@code UseItemScRsp}
   */
  public static final class UseItemScRsp extends ProtoMessage<UseItemScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 use_item_id = 7;</code>
     */
    private int useItemId;

    /**
     * <code>optional uint32 retcode = 11;</code>
     */
    private int retcode;

    /**
     * <code>optional uint32 use_item_count = 15;</code>
     */
    private int useItemCount;

    /**
     * <code>optional .ItemList return_data = 10;</code>
     */
    private final ItemListOuterClass.ItemList returnData = ItemListOuterClass.ItemList.newInstance();

    private UseItemScRsp() {
    }

    /**
     * @return a new empty instance of {@code UseItemScRsp}
     */
    public static UseItemScRsp newInstance() {
      return new UseItemScRsp();
    }

    /**
     * <code>optional uint32 use_item_id = 7;</code>
     * @return whether the useItemId field is set
     */
    public boolean hasUseItemId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 use_item_id = 7;</code>
     * @return this
     */
    public UseItemScRsp clearUseItemId() {
      bitField0_ &= ~0x00000001;
      useItemId = 0;
      return this;
    }

    /**
     * <code>optional uint32 use_item_id = 7;</code>
     * @return the useItemId
     */
    public int getUseItemId() {
      return useItemId;
    }

    /**
     * <code>optional uint32 use_item_id = 7;</code>
     * @param value the useItemId to set
     * @return this
     */
    public UseItemScRsp setUseItemId(final int value) {
      bitField0_ |= 0x00000001;
      useItemId = value;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 11;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 retcode = 11;</code>
     * @return this
     */
    public UseItemScRsp clearRetcode() {
      bitField0_ &= ~0x00000002;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 11;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 11;</code>
     * @param value the retcode to set
     * @return this
     */
    public UseItemScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000002;
      retcode = value;
      return this;
    }

    /**
     * <code>optional uint32 use_item_count = 15;</code>
     * @return whether the useItemCount field is set
     */
    public boolean hasUseItemCount() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>optional uint32 use_item_count = 15;</code>
     * @return this
     */
    public UseItemScRsp clearUseItemCount() {
      bitField0_ &= ~0x00000004;
      useItemCount = 0;
      return this;
    }

    /**
     * <code>optional uint32 use_item_count = 15;</code>
     * @return the useItemCount
     */
    public int getUseItemCount() {
      return useItemCount;
    }

    /**
     * <code>optional uint32 use_item_count = 15;</code>
     * @param value the useItemCount to set
     * @return this
     */
    public UseItemScRsp setUseItemCount(final int value) {
      bitField0_ |= 0x00000004;
      useItemCount = value;
      return this;
    }

    /**
     * <code>optional .ItemList return_data = 10;</code>
     * @return whether the returnData field is set
     */
    public boolean hasReturnData() {
      return (bitField0_ & 0x00000008) != 0;
    }

    /**
     * <code>optional .ItemList return_data = 10;</code>
     * @return this
     */
    public UseItemScRsp clearReturnData() {
      bitField0_ &= ~0x00000008;
      returnData.clear();
      return this;
    }

    /**
     * <code>optional .ItemList return_data = 10;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableReturnData()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public ItemListOuterClass.ItemList getReturnData() {
      return returnData;
    }

    /**
     * <code>optional .ItemList return_data = 10;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public ItemListOuterClass.ItemList getMutableReturnData() {
      bitField0_ |= 0x00000008;
      return returnData;
    }

    /**
     * <code>optional .ItemList return_data = 10;</code>
     * @param value the returnData to set
     * @return this
     */
    public UseItemScRsp setReturnData(final ItemListOuterClass.ItemList value) {
      bitField0_ |= 0x00000008;
      returnData.copyFrom(value);
      return this;
    }

    @Override
    public UseItemScRsp copyFrom(final UseItemScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        useItemId = other.useItemId;
        retcode = other.retcode;
        useItemCount = other.useItemCount;
        returnData.copyFrom(other.returnData);
      }
      return this;
    }

    @Override
    public UseItemScRsp mergeFrom(final UseItemScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasUseItemId()) {
        setUseItemId(other.useItemId);
      }
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasUseItemCount()) {
        setUseItemCount(other.useItemCount);
      }
      if (other.hasReturnData()) {
        getMutableReturnData().mergeFrom(other.returnData);
      }
      return this;
    }

    @Override
    public UseItemScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      useItemId = 0;
      retcode = 0;
      useItemCount = 0;
      returnData.clear();
      return this;
    }

    @Override
    public UseItemScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      returnData.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof UseItemScRsp)) {
        return false;
      }
      UseItemScRsp other = (UseItemScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasUseItemId() || useItemId == other.useItemId)
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasUseItemCount() || useItemCount == other.useItemCount)
        && (!hasReturnData() || returnData.equals(other.returnData));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 56);
        output.writeUInt32NoTag(useItemId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 88);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(useItemCount);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeRawByte((byte) 82);
        output.writeMessageNoTag(returnData);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(useItemId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(useItemCount);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(returnData);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public UseItemScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 56: {
            // useItemId
            useItemId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 88) {
              break;
            }
          }
          case 88: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
            // useItemCount
            useItemCount = input.readUInt32();
            bitField0_ |= 0x00000004;
            tag = input.readTag();
            if (tag != 82) {
              break;
            }
          }
          case 82: {
            // returnData
            input.readMessage(returnData);
            bitField0_ |= 0x00000008;
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
        output.writeUInt32(FieldNames.useItemId, useItemId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.retcode, retcode);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeUInt32(FieldNames.useItemCount, useItemCount);
      }
      if ((bitField0_ & 0x00000008) != 0) {
        output.writeMessage(FieldNames.returnData, returnData);
      }
      output.endObject();
    }

    @Override
    public UseItemScRsp mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -815318027:
          case 1396027151: {
            if (input.isAtField(FieldNames.useItemId)) {
              if (!input.trySkipNullValue()) {
                useItemId = input.readUInt32();
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
          case -1104380939:
          case 871430811: {
            if (input.isAtField(FieldNames.useItemCount)) {
              if (!input.trySkipNullValue()) {
                useItemCount = input.readUInt32();
                bitField0_ |= 0x00000004;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1336707322:
          case -1486739111: {
            if (input.isAtField(FieldNames.returnData)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(returnData);
                bitField0_ |= 0x00000008;
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
    public UseItemScRsp clone() {
      return new UseItemScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static UseItemScRsp parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new UseItemScRsp(), data).checkInitialized();
    }

    public static UseItemScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new UseItemScRsp(), input).checkInitialized();
    }

    public static UseItemScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new UseItemScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating UseItemScRsp messages
     */
    public static MessageFactory<UseItemScRsp> getFactory() {
      return UseItemScRspFactory.INSTANCE;
    }

    private enum UseItemScRspFactory implements MessageFactory<UseItemScRsp> {
      INSTANCE;

      @Override
      public UseItemScRsp create() {
        return UseItemScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName useItemId = FieldName.forField("useItemId", "use_item_id");

      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName useItemCount = FieldName.forField("useItemCount", "use_item_count");

      static final FieldName returnData = FieldName.forField("returnData", "return_data");
    }
  }
}
