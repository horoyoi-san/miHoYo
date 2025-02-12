// Code generated by protocol buffer compiler. Do not edit!
package emu.lunarcore.proto;

import java.io.IOException;
import us.hebi.quickbuf.InvalidProtocolBufferException;
import us.hebi.quickbuf.JsonSink;
import us.hebi.quickbuf.JsonSource;
import us.hebi.quickbuf.MessageFactory;
import us.hebi.quickbuf.ProtoMessage;
import us.hebi.quickbuf.ProtoSink;
import us.hebi.quickbuf.ProtoSource;

public final class GetLineupAvatarDataCsReqOuterClass {
  /**
   * Protobuf type {@code GetLineupAvatarDataCsReq}
   */
  public static final class GetLineupAvatarDataCsReq extends ProtoMessage<GetLineupAvatarDataCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    private GetLineupAvatarDataCsReq() {
    }

    /**
     * @return a new empty instance of {@code GetLineupAvatarDataCsReq}
     */
    public static GetLineupAvatarDataCsReq newInstance() {
      return new GetLineupAvatarDataCsReq();
    }

    @Override
    public GetLineupAvatarDataCsReq copyFrom(final GetLineupAvatarDataCsReq other) {
      cachedSize = other.cachedSize;
      return this;
    }

    @Override
    public GetLineupAvatarDataCsReq mergeFrom(final GetLineupAvatarDataCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      return this;
    }

    @Override
    public GetLineupAvatarDataCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      return this;
    }

    @Override
    public GetLineupAvatarDataCsReq clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof GetLineupAvatarDataCsReq)) {
        return false;
      }
      GetLineupAvatarDataCsReq other = (GetLineupAvatarDataCsReq) o;
      return true;
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public GetLineupAvatarDataCsReq mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
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
      output.endObject();
    }

    @Override
    public GetLineupAvatarDataCsReq mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
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
    public GetLineupAvatarDataCsReq clone() {
      return new GetLineupAvatarDataCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static GetLineupAvatarDataCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new GetLineupAvatarDataCsReq(), data).checkInitialized();
    }

    public static GetLineupAvatarDataCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetLineupAvatarDataCsReq(), input).checkInitialized();
    }

    public static GetLineupAvatarDataCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetLineupAvatarDataCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating GetLineupAvatarDataCsReq messages
     */
    public static MessageFactory<GetLineupAvatarDataCsReq> getFactory() {
      return GetLineupAvatarDataCsReqFactory.INSTANCE;
    }

    private enum GetLineupAvatarDataCsReqFactory implements MessageFactory<GetLineupAvatarDataCsReq> {
      INSTANCE;

      @Override
      public GetLineupAvatarDataCsReq create() {
        return GetLineupAvatarDataCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
    }
  }
}
