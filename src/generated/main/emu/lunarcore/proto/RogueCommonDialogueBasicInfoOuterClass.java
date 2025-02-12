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

public final class RogueCommonDialogueBasicInfoOuterClass {
  /**
   * Protobuf type {@code RogueCommonDialogueBasicInfo}
   */
  public static final class RogueCommonDialogueBasicInfo extends ProtoMessage<RogueCommonDialogueBasicInfo> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 rogue_npc_id = 2;</code>
     */
    private int rogueNpcId;

    /**
     * <code>optional uint32 dialogue_id = 12;</code>
     */
    private int dialogueId;

    private RogueCommonDialogueBasicInfo() {
    }

    /**
     * @return a new empty instance of {@code RogueCommonDialogueBasicInfo}
     */
    public static RogueCommonDialogueBasicInfo newInstance() {
      return new RogueCommonDialogueBasicInfo();
    }

    /**
     * <code>optional uint32 rogue_npc_id = 2;</code>
     * @return whether the rogueNpcId field is set
     */
    public boolean hasRogueNpcId() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 rogue_npc_id = 2;</code>
     * @return this
     */
    public RogueCommonDialogueBasicInfo clearRogueNpcId() {
      bitField0_ &= ~0x00000001;
      rogueNpcId = 0;
      return this;
    }

    /**
     * <code>optional uint32 rogue_npc_id = 2;</code>
     * @return the rogueNpcId
     */
    public int getRogueNpcId() {
      return rogueNpcId;
    }

    /**
     * <code>optional uint32 rogue_npc_id = 2;</code>
     * @param value the rogueNpcId to set
     * @return this
     */
    public RogueCommonDialogueBasicInfo setRogueNpcId(final int value) {
      bitField0_ |= 0x00000001;
      rogueNpcId = value;
      return this;
    }

    /**
     * <code>optional uint32 dialogue_id = 12;</code>
     * @return whether the dialogueId field is set
     */
    public boolean hasDialogueId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 dialogue_id = 12;</code>
     * @return this
     */
    public RogueCommonDialogueBasicInfo clearDialogueId() {
      bitField0_ &= ~0x00000002;
      dialogueId = 0;
      return this;
    }

    /**
     * <code>optional uint32 dialogue_id = 12;</code>
     * @return the dialogueId
     */
    public int getDialogueId() {
      return dialogueId;
    }

    /**
     * <code>optional uint32 dialogue_id = 12;</code>
     * @param value the dialogueId to set
     * @return this
     */
    public RogueCommonDialogueBasicInfo setDialogueId(final int value) {
      bitField0_ |= 0x00000002;
      dialogueId = value;
      return this;
    }

    @Override
    public RogueCommonDialogueBasicInfo copyFrom(final RogueCommonDialogueBasicInfo other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        rogueNpcId = other.rogueNpcId;
        dialogueId = other.dialogueId;
      }
      return this;
    }

    @Override
    public RogueCommonDialogueBasicInfo mergeFrom(final RogueCommonDialogueBasicInfo other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasRogueNpcId()) {
        setRogueNpcId(other.rogueNpcId);
      }
      if (other.hasDialogueId()) {
        setDialogueId(other.dialogueId);
      }
      return this;
    }

    @Override
    public RogueCommonDialogueBasicInfo clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      rogueNpcId = 0;
      dialogueId = 0;
      return this;
    }

    @Override
    public RogueCommonDialogueBasicInfo clearQuick() {
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
      if (!(o instanceof RogueCommonDialogueBasicInfo)) {
        return false;
      }
      RogueCommonDialogueBasicInfo other = (RogueCommonDialogueBasicInfo) o;
      return bitField0_ == other.bitField0_
        && (!hasRogueNpcId() || rogueNpcId == other.rogueNpcId)
        && (!hasDialogueId() || dialogueId == other.dialogueId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 16);
        output.writeUInt32NoTag(rogueNpcId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 96);
        output.writeUInt32NoTag(dialogueId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(rogueNpcId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(dialogueId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public RogueCommonDialogueBasicInfo mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 16: {
            // rogueNpcId
            rogueNpcId = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 96) {
              break;
            }
          }
          case 96: {
            // dialogueId
            dialogueId = input.readUInt32();
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
        output.writeUInt32(FieldNames.rogueNpcId, rogueNpcId);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.dialogueId, dialogueId);
      }
      output.endObject();
    }

    @Override
    public RogueCommonDialogueBasicInfo mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1140086238:
          case 1751967038: {
            if (input.isAtField(FieldNames.rogueNpcId)) {
              if (!input.trySkipNullValue()) {
                rogueNpcId = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1384067821:
          case 43591906: {
            if (input.isAtField(FieldNames.dialogueId)) {
              if (!input.trySkipNullValue()) {
                dialogueId = input.readUInt32();
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
    public RogueCommonDialogueBasicInfo clone() {
      return new RogueCommonDialogueBasicInfo().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static RogueCommonDialogueBasicInfo parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new RogueCommonDialogueBasicInfo(), data).checkInitialized();
    }

    public static RogueCommonDialogueBasicInfo parseFrom(final ProtoSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new RogueCommonDialogueBasicInfo(), input).checkInitialized();
    }

    public static RogueCommonDialogueBasicInfo parseFrom(final JsonSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new RogueCommonDialogueBasicInfo(), input).checkInitialized();
    }

    /**
     * @return factory for creating RogueCommonDialogueBasicInfo messages
     */
    public static MessageFactory<RogueCommonDialogueBasicInfo> getFactory() {
      return RogueCommonDialogueBasicInfoFactory.INSTANCE;
    }

    private enum RogueCommonDialogueBasicInfoFactory implements MessageFactory<RogueCommonDialogueBasicInfo> {
      INSTANCE;

      @Override
      public RogueCommonDialogueBasicInfo create() {
        return RogueCommonDialogueBasicInfo.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName rogueNpcId = FieldName.forField("rogueNpcId", "rogue_npc_id");

      static final FieldName dialogueId = FieldName.forField("dialogueId", "dialogue_id");
    }
  }
}
