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

public final class EquipRelicOuterClass {
  /**
   * Protobuf type {@code EquipRelic}
   */
  public static final class EquipRelic extends ProtoMessage<EquipRelic> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional uint32 slot = 3;</code>
     */
    private int slot;

    /**
     * <code>optional uint32 relic_unique_id = 15;</code>
     */
    private int relicUniqueId;

    private EquipRelic() {
    }

    /**
     * @return a new empty instance of {@code EquipRelic}
     */
    public static EquipRelic newInstance() {
      return new EquipRelic();
    }

    /**
     * <code>optional uint32 slot = 3;</code>
     * @return whether the slot field is set
     */
    public boolean hasSlot() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional uint32 slot = 3;</code>
     * @return this
     */
    public EquipRelic clearSlot() {
      bitField0_ &= ~0x00000001;
      slot = 0;
      return this;
    }

    /**
     * <code>optional uint32 slot = 3;</code>
     * @return the slot
     */
    public int getSlot() {
      return slot;
    }

    /**
     * <code>optional uint32 slot = 3;</code>
     * @param value the slot to set
     * @return this
     */
    public EquipRelic setSlot(final int value) {
      bitField0_ |= 0x00000001;
      slot = value;
      return this;
    }

    /**
     * <code>optional uint32 relic_unique_id = 15;</code>
     * @return whether the relicUniqueId field is set
     */
    public boolean hasRelicUniqueId() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>optional uint32 relic_unique_id = 15;</code>
     * @return this
     */
    public EquipRelic clearRelicUniqueId() {
      bitField0_ &= ~0x00000002;
      relicUniqueId = 0;
      return this;
    }

    /**
     * <code>optional uint32 relic_unique_id = 15;</code>
     * @return the relicUniqueId
     */
    public int getRelicUniqueId() {
      return relicUniqueId;
    }

    /**
     * <code>optional uint32 relic_unique_id = 15;</code>
     * @param value the relicUniqueId to set
     * @return this
     */
    public EquipRelic setRelicUniqueId(final int value) {
      bitField0_ |= 0x00000002;
      relicUniqueId = value;
      return this;
    }

    @Override
    public EquipRelic copyFrom(final EquipRelic other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        slot = other.slot;
        relicUniqueId = other.relicUniqueId;
      }
      return this;
    }

    @Override
    public EquipRelic mergeFrom(final EquipRelic other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasSlot()) {
        setSlot(other.slot);
      }
      if (other.hasRelicUniqueId()) {
        setRelicUniqueId(other.relicUniqueId);
      }
      return this;
    }

    @Override
    public EquipRelic clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      slot = 0;
      relicUniqueId = 0;
      return this;
    }

    @Override
    public EquipRelic clearQuick() {
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
      if (!(o instanceof EquipRelic)) {
        return false;
      }
      EquipRelic other = (EquipRelic) o;
      return bitField0_ == other.bitField0_
        && (!hasSlot() || slot == other.slot)
        && (!hasRelicUniqueId() || relicUniqueId == other.relicUniqueId);
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 24);
        output.writeUInt32NoTag(slot);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRawByte((byte) 120);
        output.writeUInt32NoTag(relicUniqueId);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(slot);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += 1 + ProtoSink.computeUInt32SizeNoTag(relicUniqueId);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public EquipRelic mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 24: {
            // slot
            slot = input.readUInt32();
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 120) {
              break;
            }
          }
          case 120: {
            // relicUniqueId
            relicUniqueId = input.readUInt32();
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
        output.writeUInt32(FieldNames.slot, slot);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeUInt32(FieldNames.relicUniqueId, relicUniqueId);
      }
      output.endObject();
    }

    @Override
    public EquipRelic mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 3533310: {
            if (input.isAtField(FieldNames.slot)) {
              if (!input.trySkipNullValue()) {
                slot = input.readUInt32();
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1966200481:
          case 49648253: {
            if (input.isAtField(FieldNames.relicUniqueId)) {
              if (!input.trySkipNullValue()) {
                relicUniqueId = input.readUInt32();
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
    public EquipRelic clone() {
      return new EquipRelic().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static EquipRelic parseFrom(final byte[] data) throws InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new EquipRelic(), data).checkInitialized();
    }

    public static EquipRelic parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new EquipRelic(), input).checkInitialized();
    }

    public static EquipRelic parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new EquipRelic(), input).checkInitialized();
    }

    /**
     * @return factory for creating EquipRelic messages
     */
    public static MessageFactory<EquipRelic> getFactory() {
      return EquipRelicFactory.INSTANCE;
    }

    private enum EquipRelicFactory implements MessageFactory<EquipRelic> {
      INSTANCE;

      @Override
      public EquipRelic create() {
        return EquipRelic.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName slot = FieldName.forField("slot");

      static final FieldName relicUniqueId = FieldName.forField("relicUniqueId", "relic_unique_id");
    }
  }
}
