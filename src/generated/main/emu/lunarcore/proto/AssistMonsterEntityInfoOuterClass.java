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
import us.hebi.quickbuf.RepeatedInt;

public final class AssistMonsterEntityInfoOuterClass {
  /**
   * Protobuf type {@code AssistMonsterEntityInfo}
   */
  public static final class AssistMonsterEntityInfo extends ProtoMessage<AssistMonsterEntityInfo> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>repeated uint32 entity_id_list = 12;</code>
     */
    private final RepeatedInt entityIdList = RepeatedInt.newEmptyInstance();

    private AssistMonsterEntityInfo() {
    }

    /**
     * @return a new empty instance of {@code AssistMonsterEntityInfo}
     */
    public static AssistMonsterEntityInfo newInstance() {
      return new AssistMonsterEntityInfo();
    }

    /**
     * <code>repeated uint32 entity_id_list = 12;</code>
     * @return whether the entityIdList field is set
     */
    public boolean hasEntityIdList() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>repeated uint32 entity_id_list = 12;</code>
     * @return this
     */
    public AssistMonsterEntityInfo clearEntityIdList() {
      bitField0_ &= ~0x00000001;
      entityIdList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 entity_id_list = 12;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableEntityIdList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getEntityIdList() {
      return entityIdList;
    }

    /**
     * <code>repeated uint32 entity_id_list = 12;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableEntityIdList() {
      bitField0_ |= 0x00000001;
      return entityIdList;
    }

    /**
     * <code>repeated uint32 entity_id_list = 12;</code>
     * @param value the entityIdList to add
     * @return this
     */
    public AssistMonsterEntityInfo addEntityIdList(final int value) {
      bitField0_ |= 0x00000001;
      entityIdList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 entity_id_list = 12;</code>
     * @param values the entityIdList to add
     * @return this
     */
    public AssistMonsterEntityInfo addAllEntityIdList(final int... values) {
      bitField0_ |= 0x00000001;
      entityIdList.addAll(values);
      return this;
    }

    @Override
    public AssistMonsterEntityInfo copyFrom(final AssistMonsterEntityInfo other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        entityIdList.copyFrom(other.entityIdList);
      }
      return this;
    }

    @Override
    public AssistMonsterEntityInfo mergeFrom(final AssistMonsterEntityInfo other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasEntityIdList()) {
        getMutableEntityIdList().addAll(other.entityIdList);
      }
      return this;
    }

    @Override
    public AssistMonsterEntityInfo clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      entityIdList.clear();
      return this;
    }

    @Override
    public AssistMonsterEntityInfo clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      entityIdList.clear();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof AssistMonsterEntityInfo)) {
        return false;
      }
      AssistMonsterEntityInfo other = (AssistMonsterEntityInfo) o;
      return bitField0_ == other.bitField0_
        && (!hasEntityIdList() || entityIdList.equals(other.entityIdList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        for (int i = 0; i < entityIdList.length(); i++) {
          output.writeRawByte((byte) 96);
          output.writeUInt32NoTag(entityIdList.array()[i]);
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += (1 * entityIdList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(entityIdList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public AssistMonsterEntityInfo mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 98: {
            // entityIdList [packed=true]
            input.readPackedUInt32(entityIdList, tag);
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
          case 96: {
            // entityIdList [packed=false]
            tag = input.readRepeatedUInt32(entityIdList, tag);
            bitField0_ |= 0x00000001;
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRepeatedUInt32(FieldNames.entityIdList, entityIdList);
      }
      output.endObject();
    }

    @Override
    public AssistMonsterEntityInfo mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 432358940:
          case -607564570: {
            if (input.isAtField(FieldNames.entityIdList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(entityIdList);
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
    public AssistMonsterEntityInfo clone() {
      return new AssistMonsterEntityInfo().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static AssistMonsterEntityInfo parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new AssistMonsterEntityInfo(), data).checkInitialized();
    }

    public static AssistMonsterEntityInfo parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new AssistMonsterEntityInfo(), input).checkInitialized();
    }

    public static AssistMonsterEntityInfo parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new AssistMonsterEntityInfo(), input).checkInitialized();
    }

    /**
     * @return factory for creating AssistMonsterEntityInfo messages
     */
    public static MessageFactory<AssistMonsterEntityInfo> getFactory() {
      return AssistMonsterEntityInfoFactory.INSTANCE;
    }

    private enum AssistMonsterEntityInfoFactory implements MessageFactory<AssistMonsterEntityInfo> {
      INSTANCE;

      @Override
      public AssistMonsterEntityInfo create() {
        return AssistMonsterEntityInfo.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName entityIdList = FieldName.forField("entityIdList", "entity_id_list");
    }
  }
}
