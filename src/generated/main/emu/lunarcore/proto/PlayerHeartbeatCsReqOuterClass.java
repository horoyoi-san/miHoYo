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

public final class PlayerHeartbeatCsReqOuterClass {
  /**
   * Protobuf type {@code PlayerHeartbeatCsReq}
   */
  public static final class PlayerHeartbeatCsReq extends ProtoMessage<PlayerHeartbeatCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint64 client_time_ms = 15;</code>
     */
    private long clientTimeMs;

    private PlayerHeartbeatCsReq() {
    }

    /**
     * @return a new empty instance of {@code PlayerHeartbeatCsReq}
     */
    public static PlayerHeartbeatCsReq newInstance() {
      return new PlayerHeartbeatCsReq();
    }

    /**
     * <code>optional uint64 client_time_ms = 15;</code>
     * @return whether the clientTimeMs field is set
     */
    public boolean hasClientTimeMs() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint64 client_time_ms = 15;</code>
     * @return this
     */
    public PlayerHeartbeatCsReq clearClientTimeMs() {
      bitField0_ &= ~0x00000001;
      clientTimeMs = 0L;
      return this;
    }

    /**
     * <code>optional uint64 client_time_ms = 15;</code>
     * @return the clientTimeMs
     */
    public long getClientTimeMs() {
      return clientTimeMs;
    }

    /**
     * <code>optional uint64 client_time_ms = 15;</code>
     * @param value the clientTimeMs to set
     * @return this
     */
    public PlayerHeartbeatCsReq setClientTimeMs(final long value) {
      bitField0_ |= 0x00000001;
      clientTimeMs = value;
      return this;
    }

    @Override
    public PlayerHeartbeatCsReq copyFrom(final PlayerHeartbeatCsReq other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        clientTimeMs = other.clientTimeMs;
      }
      return this;
    }

    @Override
    public PlayerHeartbeatCsReq mergeFrom(final PlayerHeartbeatCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasClientTimeMs()) {
        setClientTimeMs(other.clientTimeMs);
      }
      return this;
    }

    @Override
    public PlayerHeartbeatCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      clientTimeMs = 0L;
      return this;
    }

    @Override
    public PlayerHeartbeatCsReq clearQuick() {
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
      if (!(o instanceof PlayerHeartbeatCsReq)) {
        return false;
      }
      PlayerHeartbeatCsReq other = (PlayerHeartbeatCsReq) o;
      return bitField0_ == other.bitField0_
        && (!hasClientTimeMs() || clientTimeMs == other.clientTimeMs);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt64NoTag(clientTimeMs);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt64SizeNoTag(clientTimeMs);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public PlayerHeartbeatCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 120: {
            // clientTimeMs
            clientTimeMs = input.readUInt64();
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
        output.writeUInt64(FieldNames.clientTimeMs, clientTimeMs);
      }
      output.endObject();
    }

    @Override
    public PlayerHeartbeatCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1414301442:
          case 1123200996: {
            if (input.isAtField(FieldNames.clientTimeMs)) {
              if (!input.trySkipNullValue()) {
                clientTimeMs = input.readUInt64();
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
    public PlayerHeartbeatCsReq clone() {
      return new PlayerHeartbeatCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static PlayerHeartbeatCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new PlayerHeartbeatCsReq(), data).checkInitialized();
    }

    public static PlayerHeartbeatCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new PlayerHeartbeatCsReq(), input).checkInitialized();
    }

    public static PlayerHeartbeatCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new PlayerHeartbeatCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating PlayerHeartbeatCsReq messages
     */
    public static MessageFactory<PlayerHeartbeatCsReq> getFactory() {
      return PlayerHeartbeatCsReqFactory.INSTANCE;
    }

    private enum PlayerHeartbeatCsReqFactory implements MessageFactory<PlayerHeartbeatCsReq> {
      INSTANCE;

      @Override
      public PlayerHeartbeatCsReq create() {
        return PlayerHeartbeatCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName clientTimeMs = FieldName.forField("clientTimeMs", "client_time_ms");
    }
  }
}
