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

public final class SyncRogueCommonPendingActionScNotifyOuterClass {
  /**
   * Protobuf type {@code SyncRogueCommonPendingActionScNotify}
   */
  public static final class SyncRogueCommonPendingActionScNotify extends ProtoMessage<SyncRogueCommonPendingActionScNotify> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 rogue_version_id = 14;</code>
     */
    private int rogueVersionId;

    /**
     * <code>optional .RogueCommonPendingAction rogue_common_pending_action = 15;</code>
     */
    private final RogueCommonPendingActionOuterClass.RogueCommonPendingAction rogueCommonPendingAction = RogueCommonPendingActionOuterClass.RogueCommonPendingAction.newInstance();

    private SyncRogueCommonPendingActionScNotify() {
    }

    /**
     * @return a new empty instance of {@code SyncRogueCommonPendingActionScNotify}
     */
    public static SyncRogueCommonPendingActionScNotify newInstance() {
      return new SyncRogueCommonPendingActionScNotify();
    }

    /**
     * <code>optional uint32 rogue_version_id = 14;</code>
     * @return whether the rogueVersionId field is set
     */
    public boolean hasRogueVersionId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 rogue_version_id = 14;</code>
     * @return this
     */
    public SyncRogueCommonPendingActionScNotify clearRogueVersionId() {
      bitField0_ &= ~0x00000001;
      rogueVersionId = 0;
      return this;
    }

    /**
     * <code>optional uint32 rogue_version_id = 14;</code>
     * @return the rogueVersionId
     */
    public int getRogueVersionId() {
      return rogueVersionId;
    }

    /**
     * <code>optional uint32 rogue_version_id = 14;</code>
     * @param value the rogueVersionId to set
     * @return this
     */
    public SyncRogueCommonPendingActionScNotify setRogueVersionId(final int value) {
      bitField0_ |= 0x00000001;
      rogueVersionId = value;
      return this;
    }

    /**
     * <code>optional .RogueCommonPendingAction rogue_common_pending_action = 15;</code>
     * @return whether the rogueCommonPendingAction field is set
     */
    public boolean hasRogueCommonPendingAction() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional .RogueCommonPendingAction rogue_common_pending_action = 15;</code>
     * @return this
     */
    public SyncRogueCommonPendingActionScNotify clearRogueCommonPendingAction() {
      bitField0_ &= ~0x00000002;
      rogueCommonPendingAction.clear();
      return this;
    }

    /**
     * <code>optional .RogueCommonPendingAction rogue_common_pending_action = 15;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableRogueCommonPendingAction()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RogueCommonPendingActionOuterClass.RogueCommonPendingAction getRogueCommonPendingAction(
        ) {
      return rogueCommonPendingAction;
    }

    /**
     * <code>optional .RogueCommonPendingAction rogue_common_pending_action = 15;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RogueCommonPendingActionOuterClass.RogueCommonPendingAction getMutableRogueCommonPendingAction(
        ) {
      bitField0_ |= 0x00000002;
      return rogueCommonPendingAction;
    }

    /**
     * <code>optional .RogueCommonPendingAction rogue_common_pending_action = 15;</code>
     * @param value the rogueCommonPendingAction to set
     * @return this
     */
    public SyncRogueCommonPendingActionScNotify setRogueCommonPendingAction(
        final RogueCommonPendingActionOuterClass.RogueCommonPendingAction value) {
      bitField0_ |= 0x00000002;
      rogueCommonPendingAction.copyFrom(value);
      return this;
    }

    @Override
    public SyncRogueCommonPendingActionScNotify copyFrom(
        final SyncRogueCommonPendingActionScNotify other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        rogueVersionId = other.rogueVersionId;
        rogueCommonPendingAction.copyFrom(other.rogueCommonPendingAction);
      }
      return this;
    }

    @Override
    public SyncRogueCommonPendingActionScNotify mergeFrom(
        final SyncRogueCommonPendingActionScNotify other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRogueVersionId()) {
        setRogueVersionId(other.rogueVersionId);
      }
      if (other.hasRogueCommonPendingAction()) {
        getMutableRogueCommonPendingAction().mergeFrom(other.rogueCommonPendingAction);
      }
      return this;
    }

    @Override
    public SyncRogueCommonPendingActionScNotify clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      rogueVersionId = 0;
      rogueCommonPendingAction.clear();
      return this;
    }

    @Override
    public SyncRogueCommonPendingActionScNotify clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      rogueCommonPendingAction.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof SyncRogueCommonPendingActionScNotify)) {
        return false;
      }
      SyncRogueCommonPendingActionScNotify other = (SyncRogueCommonPendingActionScNotify) o;
      return bitField0_ == other.bitField0_
        && (!hasRogueVersionId() || rogueVersionId == other.rogueVersionId)
        && (!hasRogueCommonPendingAction() || rogueCommonPendingAction.equals(other.rogueCommonPendingAction));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 112);
        output.writeUInt32NoTag(rogueVersionId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 122);
        output.writeMessageNoTag(rogueCommonPendingAction);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(rogueVersionId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(rogueCommonPendingAction);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public SyncRogueCommonPendingActionScNotify mergeFrom(final ProtoSource input) throws
        IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 112: {
            // rogueVersionId
            rogueVersionId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 122) {
              break;
            }
          }
          case 122: {
            // rogueCommonPendingAction
            input.readMessage(rogueCommonPendingAction);
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
        output.writeUInt32(FieldNames.rogueVersionId, rogueVersionId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeMessage(FieldNames.rogueCommonPendingAction, rogueCommonPendingAction);
      }
      output.endObject();
    }

    @Override
    public SyncRogueCommonPendingActionScNotify mergeFrom(final JsonSource input) throws
        IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1457526951:
          case 1832096103: {
            if (input.isAtField(FieldNames.rogueVersionId)) {
              if (!input.trySkipNullValue()) {
                rogueVersionId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1199610440:
          case 327981581: {
            if (input.isAtField(FieldNames.rogueCommonPendingAction)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(rogueCommonPendingAction);
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
    public SyncRogueCommonPendingActionScNotify clone() {
      return new SyncRogueCommonPendingActionScNotify().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static SyncRogueCommonPendingActionScNotify parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new SyncRogueCommonPendingActionScNotify(), data).checkInitialized();
    }

    public static SyncRogueCommonPendingActionScNotify parseFrom(final ProtoSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new SyncRogueCommonPendingActionScNotify(), input).checkInitialized();
    }

    public static SyncRogueCommonPendingActionScNotify parseFrom(final JsonSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new SyncRogueCommonPendingActionScNotify(), input).checkInitialized();
    }

    /**
     * @return factory for creating SyncRogueCommonPendingActionScNotify messages
     */
    public static MessageFactory<SyncRogueCommonPendingActionScNotify> getFactory() {
      return SyncRogueCommonPendingActionScNotifyFactory.INSTANCE;
    }

    private enum SyncRogueCommonPendingActionScNotifyFactory implements MessageFactory<SyncRogueCommonPendingActionScNotify> {
      INSTANCE;

      @Override
      public SyncRogueCommonPendingActionScNotify create() {
        return SyncRogueCommonPendingActionScNotify.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName rogueVersionId = FieldName.forField("rogueVersionId", "rogue_version_id");

      static final FieldName rogueCommonPendingAction = FieldName.forField("rogueCommonPendingAction", "rogue_common_pending_action");
    }
  }
}
