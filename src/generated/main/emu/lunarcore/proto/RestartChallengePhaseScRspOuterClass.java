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

public final class RestartChallengePhaseScRspOuterClass {
  /**
   * Protobuf type {@code RestartChallengePhaseScRsp}
   */
  public static final class RestartChallengePhaseScRsp extends ProtoMessage<RestartChallengePhaseScRsp> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 retcode = 8;</code>
     */
    private int retcode;

    /**
     * <code>optional .SceneInfo scene = 1;</code>
     */
    private final SceneInfoOuterClass.SceneInfo scene = SceneInfoOuterClass.SceneInfo.newInstance();

    private RestartChallengePhaseScRsp() {
    }

    /**
     * @return a new empty instance of {@code RestartChallengePhaseScRsp}
     */
    public static RestartChallengePhaseScRsp newInstance() {
      return new RestartChallengePhaseScRsp();
    }

    /**
     * <code>optional uint32 retcode = 8;</code>
     * @return whether the retcode field is set
     */
    public boolean hasRetcode() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 retcode = 8;</code>
     * @return this
     */
    public RestartChallengePhaseScRsp clearRetcode() {
      bitField0_ &= ~0x00000001;
      retcode = 0;
      return this;
    }

    /**
     * <code>optional uint32 retcode = 8;</code>
     * @return the retcode
     */
    public int getRetcode() {
      return retcode;
    }

    /**
     * <code>optional uint32 retcode = 8;</code>
     * @param value the retcode to set
     * @return this
     */
    public RestartChallengePhaseScRsp setRetcode(final int value) {
      bitField0_ |= 0x00000001;
      retcode = value;
      return this;
    }

    /**
     * <code>optional .SceneInfo scene = 1;</code>
     * @return whether the scene field is set
     */
    public boolean hasScene() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .SceneInfo scene = 1;</code>
     * @return this
     */
    public RestartChallengePhaseScRsp clearScene() {
      bitField0_ &= ~0x00000002;
      scene.clear();
      return this;
    }

    /**
     * <code>optional .SceneInfo scene = 1;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableScene()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public SceneInfoOuterClass.SceneInfo getScene() {
      return scene;
    }

    /**
     * <code>optional .SceneInfo scene = 1;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public SceneInfoOuterClass.SceneInfo getMutableScene() {
      bitField0_ |= 0x00000002;
      return scene;
    }

    /**
     * <code>optional .SceneInfo scene = 1;</code>
     * @param value the scene to set
     * @return this
     */
    public RestartChallengePhaseScRsp setScene(final SceneInfoOuterClass.SceneInfo value) {
      bitField0_ |= 0x00000002;
      scene.copyFrom(value);
      return this;
    }

    @Override
    public RestartChallengePhaseScRsp copyFrom(final RestartChallengePhaseScRsp other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        retcode = other.retcode;
        scene.copyFrom(other.scene);
      }
      return this;
    }

    @Override
    public RestartChallengePhaseScRsp mergeFrom(final RestartChallengePhaseScRsp other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRetcode()) {
        setRetcode(other.retcode);
      }
      if (other.hasScene()) {
        getMutableScene().mergeFrom(other.scene);
      }
      return this;
    }

    @Override
    public RestartChallengePhaseScRsp clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      retcode = 0;
      scene.clear();
      return this;
    }

    @Override
    public RestartChallengePhaseScRsp clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      scene.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof RestartChallengePhaseScRsp)) {
        return false;
      }
      RestartChallengePhaseScRsp other = (RestartChallengePhaseScRsp) o;
      return bitField0_ == other.bitField0_
        && (!hasRetcode() || retcode == other.retcode)
        && (!hasScene() || scene.equals(other.scene));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 64);
        output.writeUInt32NoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 10);
        output.writeMessageNoTag(scene);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(retcode);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(scene);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RestartChallengePhaseScRsp mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 64: {
            // retcode
            retcode = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 10) {
              break;
            }
          }
          case 10: {
            // scene
            input.readMessage(scene);
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
        output.writeMessage(FieldNames.scene, scene);
      }
      output.endObject();
    }

    @Override
    public RestartChallengePhaseScRsp mergeFrom(final JsonSource input) throws IOException {
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
          case 109254796: {
            if (input.isAtField(FieldNames.scene)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(scene);
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
    public RestartChallengePhaseScRsp clone() {
      return new RestartChallengePhaseScRsp().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RestartChallengePhaseScRsp parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RestartChallengePhaseScRsp(), data).checkInitialized();
    }

    public static RestartChallengePhaseScRsp parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RestartChallengePhaseScRsp(), input).checkInitialized();
    }

    public static RestartChallengePhaseScRsp parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new RestartChallengePhaseScRsp(), input).checkInitialized();
    }

    /**
     * @return factory for creating RestartChallengePhaseScRsp messages
     */
    public static MessageFactory<RestartChallengePhaseScRsp> getFactory() {
      return RestartChallengePhaseScRspFactory.INSTANCE;
    }

    private enum RestartChallengePhaseScRspFactory implements MessageFactory<RestartChallengePhaseScRsp> {
      INSTANCE;

      @Override
      public RestartChallengePhaseScRsp create() {
        return RestartChallengePhaseScRsp.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName retcode = FieldName.forField("retcode");

      static final FieldName scene = FieldName.forField("scene");
    }
  }
}
