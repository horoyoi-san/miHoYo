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

public final class GetMarkChestCsReqOuterClass {
  /**
   * Protobuf type {@code GetMarkChestCsReq}
   */
  public static final class GetMarkChestCsReq extends ProtoMessage<GetMarkChestCsReq> implements Cloneable {
    private static final long serialVersionUID = 0L;

    private GetMarkChestCsReq() {
    }

    /**
     * @return a new empty instance of {@code GetMarkChestCsReq}
     */
    public static GetMarkChestCsReq newInstance() {
      return new GetMarkChestCsReq();
    }

    @Override
    public GetMarkChestCsReq copyFrom(final GetMarkChestCsReq other) {
      cachedSize = other.cachedSize;
      return this;
    }

    @Override
    public GetMarkChestCsReq mergeFrom(final GetMarkChestCsReq other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      return this;
    }

    @Override
    public GetMarkChestCsReq clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      return this;
    }

    @Override
    public GetMarkChestCsReq clearQuick() {
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
      if (!(o instanceof GetMarkChestCsReq)) {
        return false;
      }
      GetMarkChestCsReq other = (GetMarkChestCsReq) o;
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
    public GetMarkChestCsReq mergeFrom(final ProtoSource input) throws IOException {
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
    public GetMarkChestCsReq mergeFrom(final JsonSource input) throws IOException {
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
    public GetMarkChestCsReq clone() {
      return new GetMarkChestCsReq().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static GetMarkChestCsReq parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new GetMarkChestCsReq(), data).checkInitialized();
    }

    public static GetMarkChestCsReq parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetMarkChestCsReq(), input).checkInitialized();
    }

    public static GetMarkChestCsReq parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GetMarkChestCsReq(), input).checkInitialized();
    }

    /**
     * @return factory for creating GetMarkChestCsReq messages
     */
    public static MessageFactory<GetMarkChestCsReq> getFactory() {
      return GetMarkChestCsReqFactory.INSTANCE;
    }

    private enum GetMarkChestCsReqFactory implements MessageFactory<GetMarkChestCsReq> {
      INSTANCE;

      @Override
      public GetMarkChestCsReq create() {
        return GetMarkChestCsReq.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
    }
  }
}
