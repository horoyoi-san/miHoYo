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

public final class SyncServerSceneChangeNotifyOuterClass {
  /**
   * Protobuf type {@code SyncServerSceneChangeNotify}
   */
  public static final class SyncServerSceneChangeNotify extends ProtoMessage<SyncServerSceneChangeNotify> implements Cloneable {
    private static final long serialVersionUID = 0L;

    private SyncServerSceneChangeNotify() {
    }

    /**
     * @return a new empty instance of {@code SyncServerSceneChangeNotify}
     */
    public static SyncServerSceneChangeNotify newInstance() {
      return new SyncServerSceneChangeNotify();
    }

    @Override
    public SyncServerSceneChangeNotify copyFrom(final SyncServerSceneChangeNotify other) {
      cachedSize = other.cachedSize;
      return this;
    }

    @Override
    public SyncServerSceneChangeNotify mergeFrom(final SyncServerSceneChangeNotify other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      return this;
    }

    @Override
    public SyncServerSceneChangeNotify clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      return this;
    }

    @Override
    public SyncServerSceneChangeNotify clearQuick() {
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
      if (!(o instanceof SyncServerSceneChangeNotify)) {
        return false;
      }
      SyncServerSceneChangeNotify other = (SyncServerSceneChangeNotify) o;
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
    public SyncServerSceneChangeNotify mergeFrom(final ProtoSource input) throws IOException {
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
    public SyncServerSceneChangeNotify mergeFrom(final JsonSource input) throws IOException {
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
    public SyncServerSceneChangeNotify clone() {
      return new SyncServerSceneChangeNotify().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SyncServerSceneChangeNotify parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SyncServerSceneChangeNotify(), data).checkInitialized();
    }

    public static SyncServerSceneChangeNotify parseFrom(final ProtoSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new SyncServerSceneChangeNotify(), input).checkInitialized();
    }

    public static SyncServerSceneChangeNotify parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new SyncServerSceneChangeNotify(), input).checkInitialized();
    }

    /**
     * @return factory for creating SyncServerSceneChangeNotify messages
     */
    public static MessageFactory<SyncServerSceneChangeNotify> getFactory() {
      return SyncServerSceneChangeNotifyFactory.INSTANCE;
    }

    private enum SyncServerSceneChangeNotifyFactory implements MessageFactory<SyncServerSceneChangeNotify> {
      INSTANCE;

      @Override
      public SyncServerSceneChangeNotify create() {
        return SyncServerSceneChangeNotify.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
    }
  }
}
