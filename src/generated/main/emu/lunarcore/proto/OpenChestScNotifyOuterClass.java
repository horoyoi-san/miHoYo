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

public final class OpenChestScNotifyOuterClass {
  /**
   * Protobuf type {@code OpenChestScNotify}
   */
  public static final class OpenChestScNotify extends ProtoMessage<OpenChestScNotify> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 chest_id = 12;</code>
     */
    private int chestId;

    private OpenChestScNotify() {
    }

    /**
     * @return a new empty instance of {@code OpenChestScNotify}
     */
    public static OpenChestScNotify newInstance() {
      return new OpenChestScNotify();
    }

    /**
     * <code>optional uint32 chest_id = 12;</code>
     * @return whether the chestId field is set
     */
    public boolean hasChestId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 chest_id = 12;</code>
     * @return this
     */
    public OpenChestScNotify clearChestId() {
      bitField0_ &= ~0x00000001;
      chestId = 0;
      return this;
    }

    /**
     * <code>optional uint32 chest_id = 12;</code>
     * @return the chestId
     */
    public int getChestId() {
      return chestId;
    }

    /**
     * <code>optional uint32 chest_id = 12;</code>
     * @param value the chestId to set
     * @return this
     */
    public OpenChestScNotify setChestId(final int value) {
      bitField0_ |= 0x00000001;
      chestId = value;
      return this;
    }

    @Override
    public OpenChestScNotify copyFrom(final OpenChestScNotify other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        chestId = other.chestId;
      }
      return this;
    }

    @Override
    public OpenChestScNotify mergeFrom(final OpenChestScNotify other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasChestId()) {
        setChestId(other.chestId);
      }
      return this;
    }

    @Override
    public OpenChestScNotify clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      chestId = 0;
      return this;
    }

    @Override
    public OpenChestScNotify clearQuick() {
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
      if (!(o instanceof OpenChestScNotify)) {
        return false;
      }
      OpenChestScNotify other = (OpenChestScNotify) o;
      return bitField0_ == other.bitField0_
        && (!hasChestId() || chestId == other.chestId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 96);
        output.writeUInt32NoTag(chestId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(chestId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public OpenChestScNotify mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 96: {
            // chestId
            chestId = input.readUInt32();
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
        output.writeUInt32(FieldNames.chestId, chestId);
      }
      output.endObject();
    }

    @Override
    public OpenChestScNotify mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 742798332:
          case 1551933209: {
            if (input.isAtField(FieldNames.chestId)) {
              if (!input.trySkipNullValue()) {
                chestId = input.readUInt32();
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
    public OpenChestScNotify clone() {
      return new OpenChestScNotify().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static OpenChestScNotify parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new OpenChestScNotify(), data).checkInitialized();
    }

    public static OpenChestScNotify parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new OpenChestScNotify(), input).checkInitialized();
    }

    public static OpenChestScNotify parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new OpenChestScNotify(), input).checkInitialized();
    }

    /**
     * @return factory for creating OpenChestScNotify messages
     */
    public static MessageFactory<OpenChestScNotify> getFactory() {
      return OpenChestScNotifyFactory.INSTANCE;
    }

    private enum OpenChestScNotifyFactory implements MessageFactory<OpenChestScNotify> {
      INSTANCE;

      @Override
      public OpenChestScNotify create() {
        return OpenChestScNotify.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName chestId = FieldName.forField("chestId", "chest_id");
    }
  }
}
