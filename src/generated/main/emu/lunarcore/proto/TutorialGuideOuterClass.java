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

public final class TutorialGuideOuterClass {
  /**
   * Protobuf type {@code TutorialGuide}
   */
  public static final class TutorialGuide extends ProtoMessage<TutorialGuide> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 id = 3;</code>
     */
    private int id;

    /**
     * <code>optional .TutorialStatus status = 8;</code>
     */
    private int status;

    private TutorialGuide() {
    }

    /**
     * @return a new empty instance of {@code TutorialGuide}
     */
    public static TutorialGuide newInstance() {
      return new TutorialGuide();
    }

    /**
     * <code>optional uint32 id = 3;</code>
     * @return whether the id field is set
     */
    public boolean hasId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 id = 3;</code>
     * @return this
     */
    public TutorialGuide clearId() {
      bitField0_ &= ~0x00000001;
      id = 0;
      return this;
    }

    /**
     * <code>optional uint32 id = 3;</code>
     * @return the id
     */
    public int getId() {
      return id;
    }

    /**
     * <code>optional uint32 id = 3;</code>
     * @param value the id to set
     * @return this
     */
    public TutorialGuide setId(final int value) {
      bitField0_ |= 0x00000001;
      id = value;
      return this;
    }

    /**
     * <code>optional .TutorialStatus status = 8;</code>
     * @return whether the status field is set
     */
    public boolean hasStatus() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .TutorialStatus status = 8;</code>
     * @return this
     */
    public TutorialGuide clearStatus() {
      bitField0_ &= ~0x00000002;
      status = 0;
      return this;
    }

    /**
     * <code>optional .TutorialStatus status = 8;</code>
     * @return the status
     */
    public TutorialStatusOuterClass.TutorialStatus getStatus() {
      return TutorialStatusOuterClass.TutorialStatus.forNumber(status);
    }

    /**
     * Gets the value of the internal enum store. The result is
     * equivalent to {@link TutorialGuide#getStatus()}.getNumber().
     *
     * @return numeric wire representation
     */
    public int getStatusValue() {
      return status;
    }

    /**
     * Sets the value of the internal enum store. This does not
     * do any validity checks, so be sure to use appropriate value
     * constants from {@link TutorialStatusOuterClass.TutorialStatus}. Setting an invalid value
     * can cause {@link TutorialGuide#getStatus()} to return null
     *
     * @param value the numeric wire value to set
     * @return this
     */
    public TutorialGuide setStatusValue(final int value) {
      bitField0_ |= 0x00000002;
      status = value;
      return this;
    }

    /**
     * <code>optional .TutorialStatus status = 8;</code>
     * @param value the status to set
     * @return this
     */
    public TutorialGuide setStatus(final TutorialStatusOuterClass.TutorialStatus value) {
      bitField0_ |= 0x00000002;
      status = value.getNumber();
      return this;
    }

    @Override
    public TutorialGuide copyFrom(final TutorialGuide other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        id = other.id;
        status = other.status;
      }
      return this;
    }

    @Override
    public TutorialGuide mergeFrom(final TutorialGuide other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasId()) {
        setId(other.id);
      }
      if (other.hasStatus()) {
        setStatusValue(other.status);
      }
      return this;
    }

    @Override
    public TutorialGuide clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      id = 0;
      status = 0;
      return this;
    }

    @Override
    public TutorialGuide clearQuick() {
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
      if (!(o instanceof TutorialGuide)) {
        return false;
      }
      TutorialGuide other = (TutorialGuide) o;
      return bitField0_ == other.bitField0_
        && (!hasId() || id == other.id)
        && (!hasStatus() || status == other.status);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 24);
        output.writeUInt32NoTag(id);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 64);
        output.writeEnumNoTag(status);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(id);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeEnumSizeNoTag(status);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public TutorialGuide mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 24: {
            // id
            id = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 64) {
              break;
            }
          }
          case 64: {
            // status
            final int value = input.readInt32();
            if (TutorialStatusOuterClass.TutorialStatus.forNumber(value) != null) {
              status = value;
              bitField0_ |= 0x00000002;
            }
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
        output.writeUInt32(FieldNames.id, id);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeEnum(FieldNames.status, status, TutorialStatusOuterClass.TutorialStatus.converter());
      }
      output.endObject();
    }

    @Override
    public TutorialGuide mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 3355: {
            if (input.isAtField(FieldNames.id)) {
              if (!input.trySkipNullValue()) {
                id = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -892481550: {
            if (input.isAtField(FieldNames.status)) {
              if (!input.trySkipNullValue()) {
                final TutorialStatusOuterClass.TutorialStatus value = input.readEnum(TutorialStatusOuterClass.TutorialStatus.converter());
                if (value != null) {
                  status = value.getNumber();
                  bitField0_ |= 0x00000002;
                } else {
                  input.skipUnknownEnumValue();
                }
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
    public TutorialGuide clone() {
      return new TutorialGuide().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static TutorialGuide parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new TutorialGuide(), data).checkInitialized();
    }

    public static TutorialGuide parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new TutorialGuide(), input).checkInitialized();
    }

    public static TutorialGuide parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new TutorialGuide(), input).checkInitialized();
    }

    /**
     * @return factory for creating TutorialGuide messages
     */
    public static MessageFactory<TutorialGuide> getFactory() {
      return TutorialGuideFactory.INSTANCE;
    }

    private enum TutorialGuideFactory implements MessageFactory<TutorialGuide> {
      INSTANCE;

      @Override
      public TutorialGuide create() {
        return TutorialGuide.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName id = FieldName.forField("id");

      static final FieldName status = FieldName.forField("status");
    }
  }
}
