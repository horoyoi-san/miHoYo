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

public final class GroupStateChangeScNotifyOuterClass {
  /**
   * Protobuf type {@code GroupStateChangeScNotify}
   */
  public static final class GroupStateChangeScNotify extends ProtoMessage<GroupStateChangeScNotify> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional .GroupStateInfo group_state_info = 13;</code>
     */
    private final GroupStateInfoOuterClass.GroupStateInfo groupStateInfo = GroupStateInfoOuterClass.GroupStateInfo.newInstance();

    private GroupStateChangeScNotify() {
    }

    /**
     * @return a new empty instance of {@code GroupStateChangeScNotify}
     */
    public static GroupStateChangeScNotify newInstance() {
      return new GroupStateChangeScNotify();
    }

    /**
     * <code>optional .GroupStateInfo group_state_info = 13;</code>
     * @return whether the groupStateInfo field is set
     */
    public boolean hasGroupStateInfo() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional .GroupStateInfo group_state_info = 13;</code>
     * @return this
     */
    public GroupStateChangeScNotify clearGroupStateInfo() {
      bitField0_ &= ~0x00000001;
      groupStateInfo.clear();
      return this;
    }

    /**
     * <code>optional .GroupStateInfo group_state_info = 13;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableGroupStateInfo()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public GroupStateInfoOuterClass.GroupStateInfo getGroupStateInfo() {
      return groupStateInfo;
    }

    /**
     * <code>optional .GroupStateInfo group_state_info = 13;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public GroupStateInfoOuterClass.GroupStateInfo getMutableGroupStateInfo() {
      bitField0_ |= 0x00000001;
      return groupStateInfo;
    }

    /**
     * <code>optional .GroupStateInfo group_state_info = 13;</code>
     * @param value the groupStateInfo to set
     * @return this
     */
    public GroupStateChangeScNotify setGroupStateInfo(
        final GroupStateInfoOuterClass.GroupStateInfo value) {
      bitField0_ |= 0x00000001;
      groupStateInfo.copyFrom(value);
      return this;
    }

    @Override
    public GroupStateChangeScNotify copyFrom(final GroupStateChangeScNotify other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        groupStateInfo.copyFrom(other.groupStateInfo);
      }
      return this;
    }

    @Override
    public GroupStateChangeScNotify mergeFrom(final GroupStateChangeScNotify other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasGroupStateInfo()) {
        getMutableGroupStateInfo().mergeFrom(other.groupStateInfo);
      }
      return this;
    }

    @Override
    public GroupStateChangeScNotify clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      groupStateInfo.clear();
      return this;
    }

    @Override
    public GroupStateChangeScNotify clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      groupStateInfo.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof GroupStateChangeScNotify)) {
        return false;
      }
      GroupStateChangeScNotify other = (GroupStateChangeScNotify) o;
      return bitField0_ == other.bitField0_
        && (!hasGroupStateInfo() || groupStateInfo.equals(other.groupStateInfo));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 106);
        output.writeMessageNoTag(groupStateInfo);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(groupStateInfo);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public GroupStateChangeScNotify mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 106: {
            // groupStateInfo
            input.readMessage(groupStateInfo);
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
        output.writeMessage(FieldNames.groupStateInfo, groupStateInfo);
      }
      output.endObject();
    }

    @Override
    public GroupStateChangeScNotify mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1415312672:
          case 1198732636: {
            if (input.isAtField(FieldNames.groupStateInfo)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(groupStateInfo);
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
    public GroupStateChangeScNotify clone() {
      return new GroupStateChangeScNotify().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static GroupStateChangeScNotify parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new GroupStateChangeScNotify(), data).checkInitialized();
    }

    public static GroupStateChangeScNotify parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GroupStateChangeScNotify(), input).checkInitialized();
    }

    public static GroupStateChangeScNotify parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new GroupStateChangeScNotify(), input).checkInitialized();
    }

    /**
     * @return factory for creating GroupStateChangeScNotify messages
     */
    public static MessageFactory<GroupStateChangeScNotify> getFactory() {
      return GroupStateChangeScNotifyFactory.INSTANCE;
    }

    private enum GroupStateChangeScNotifyFactory implements MessageFactory<GroupStateChangeScNotify> {
      INSTANCE;

      @Override
      public GroupStateChangeScNotify create() {
        return GroupStateChangeScNotify.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName groupStateInfo = FieldName.forField("groupStateInfo", "group_state_info");
    }
  }
}
