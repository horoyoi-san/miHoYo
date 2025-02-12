// Code generated by protocol buffer compiler. Do not edit!
import java.io.IOException;
import us.hebi.quickbuf.FieldName;
import us.hebi.quickbuf.InvalidProtocolBufferException;
import us.hebi.quickbuf.JsonSink;
import us.hebi.quickbuf.JsonSource;
import us.hebi.quickbuf.MessageFactory;
import us.hebi.quickbuf.ProtoMessage;
import us.hebi.quickbuf.ProtoSink;
import us.hebi.quickbuf.ProtoSource;

public final class RogueTournExpNotifyOuterClass {
  /**
   * Protobuf type {@code RogueTournExpNotify}
   */
  public static final class RogueTournExpNotify extends ProtoMessage<RogueTournExpNotify> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 exp = 4;</code>
     */
    private int exp;

    private RogueTournExpNotify() {
    }

    /**
     * @return a new empty instance of {@code RogueTournExpNotify}
     */
    public static RogueTournExpNotify newInstance() {
      return new RogueTournExpNotify();
    }

    /**
     * <code>optional uint32 exp = 4;</code>
     * @return whether the exp field is set
     */
    public boolean hasExp() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 exp = 4;</code>
     * @return this
     */
    public RogueTournExpNotify clearExp() {
      bitField0_ &= ~0x00000001;
      exp = 0;
      return this;
    }

    /**
     * <code>optional uint32 exp = 4;</code>
     * @return the exp
     */
    public int getExp() {
      return exp;
    }

    /**
     * <code>optional uint32 exp = 4;</code>
     * @param value the exp to set
     * @return this
     */
    public RogueTournExpNotify setExp(final int value) {
      bitField0_ |= 0x00000001;
      exp = value;
      return this;
    }

    @Override
    public RogueTournExpNotify copyFrom(final RogueTournExpNotify other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        exp = other.exp;
      }
      return this;
    }

    @Override
    public RogueTournExpNotify mergeFrom(final RogueTournExpNotify other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasExp()) {
        setExp(other.exp);
      }
      return this;
    }

    @Override
    public RogueTournExpNotify clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      exp = 0;
      return this;
    }

    @Override
    public RogueTournExpNotify clearQuick() {
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
      if (!(o instanceof RogueTournExpNotify)) {
        return false;
      }
      RogueTournExpNotify other = (RogueTournExpNotify) o;
      return bitField0_ == other.bitField0_
        && (!hasExp() || exp == other.exp);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 32);
        output.writeUInt32NoTag(exp);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(exp);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RogueTournExpNotify mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 32: {
            // exp
            exp = input.readUInt32();
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
        output.writeUInt32(FieldNames.exp, exp);
      }
      output.endObject();
    }

    @Override
    public RogueTournExpNotify mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 100893: {
            if (input.isAtField(FieldNames.exp)) {
              if (!input.trySkipNullValue()) {
                exp = input.readUInt32();
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
    public RogueTournExpNotify clone() {
      return new RogueTournExpNotify().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RogueTournExpNotify parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RogueTournExpNotify(), data).checkInitialized();
    }

    public static RogueTournExpNotify parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RogueTournExpNotify(), input).checkInitialized();
    }

    public static RogueTournExpNotify parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RogueTournExpNotify(), input).checkInitialized();
    }

    /**
     * @return factory for creating RogueTournExpNotify messages
     */
    public static MessageFactory<RogueTournExpNotify> getFactory() {
      return RogueTournExpNotifyFactory.INSTANCE;
    }

    private enum RogueTournExpNotifyFactory implements MessageFactory<RogueTournExpNotify> {
      INSTANCE;

      @Override
      public RogueTournExpNotify create() {
        return RogueTournExpNotify.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName exp = FieldName.forField("exp");
    }
  }
}
