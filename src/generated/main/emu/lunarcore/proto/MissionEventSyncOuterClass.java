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
import us.hebi.quickbuf.RepeatedMessage;

public final class MissionEventSyncOuterClass {
  /**
   * Protobuf type {@code MissionEventSync}
   */
  public static final class MissionEventSync extends ProtoMessage<MissionEventSync> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>repeated uint32 NOININCHJKJ = 1;</code>
     */
    private final RepeatedInt nOININCHJKJ = RepeatedInt.newEmptyInstance();

    /**
     * <code>repeated uint32 PIMONIABIKO = 10;</code>
     */
    private final RepeatedInt pIMONIABIKO = RepeatedInt.newEmptyInstance();

    /**
     * <code>repeated .Mission mission_event_list = 5;</code>
     */
    private final RepeatedMessage<MissionOuterClass.Mission> missionEventList = RepeatedMessage.newEmptyInstance(MissionOuterClass.Mission.getFactory());

    private MissionEventSync() {
    }

    /**
     * @return a new empty instance of {@code MissionEventSync}
     */
    public static MissionEventSync newInstance() {
      return new MissionEventSync();
    }

    /**
     * <code>repeated uint32 NOININCHJKJ = 1;</code>
     * @return whether the nOININCHJKJ field is set
     */
    public boolean hasNOININCHJKJ() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>repeated uint32 NOININCHJKJ = 1;</code>
     * @return this
     */
    public MissionEventSync clearNOININCHJKJ() {
      bitField0_ &= ~0x00000001;
      nOININCHJKJ.clear();
      return this;
    }

    /**
     * <code>repeated uint32 NOININCHJKJ = 1;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableNOININCHJKJ()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getNOININCHJKJ() {
      return nOININCHJKJ;
    }

    /**
     * <code>repeated uint32 NOININCHJKJ = 1;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableNOININCHJKJ() {
      bitField0_ |= 0x00000001;
      return nOININCHJKJ;
    }

    /**
     * <code>repeated uint32 NOININCHJKJ = 1;</code>
     * @param value the nOININCHJKJ to add
     * @return this
     */
    public MissionEventSync addNOININCHJKJ(final int value) {
      bitField0_ |= 0x00000001;
      nOININCHJKJ.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 NOININCHJKJ = 1;</code>
     * @param values the nOININCHJKJ to add
     * @return this
     */
    public MissionEventSync addAllNOININCHJKJ(final int... values) {
      bitField0_ |= 0x00000001;
      nOININCHJKJ.addAll(values);
      return this;
    }

    /**
     * <code>repeated uint32 PIMONIABIKO = 10;</code>
     * @return whether the pIMONIABIKO field is set
     */
    public boolean hasPIMONIABIKO() {
      return (bitField0_ & 0x00000002) != 0;
    }

    /**
     * <code>repeated uint32 PIMONIABIKO = 10;</code>
     * @return this
     */
    public MissionEventSync clearPIMONIABIKO() {
      bitField0_ &= ~0x00000002;
      pIMONIABIKO.clear();
      return this;
    }

    /**
     * <code>repeated uint32 PIMONIABIKO = 10;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutablePIMONIABIKO()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getPIMONIABIKO() {
      return pIMONIABIKO;
    }

    /**
     * <code>repeated uint32 PIMONIABIKO = 10;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutablePIMONIABIKO() {
      bitField0_ |= 0x00000002;
      return pIMONIABIKO;
    }

    /**
     * <code>repeated uint32 PIMONIABIKO = 10;</code>
     * @param value the pIMONIABIKO to add
     * @return this
     */
    public MissionEventSync addPIMONIABIKO(final int value) {
      bitField0_ |= 0x00000002;
      pIMONIABIKO.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 PIMONIABIKO = 10;</code>
     * @param values the pIMONIABIKO to add
     * @return this
     */
    public MissionEventSync addAllPIMONIABIKO(final int... values) {
      bitField0_ |= 0x00000002;
      pIMONIABIKO.addAll(values);
      return this;
    }

    /**
     * <code>repeated .Mission mission_event_list = 5;</code>
     * @return whether the missionEventList field is set
     */
    public boolean hasMissionEventList() {
      return (bitField0_ & 0x00000004) != 0;
    }

    /**
     * <code>repeated .Mission mission_event_list = 5;</code>
     * @return this
     */
    public MissionEventSync clearMissionEventList() {
      bitField0_ &= ~0x00000004;
      missionEventList.clear();
      return this;
    }

    /**
     * <code>repeated .Mission mission_event_list = 5;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableMissionEventList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedMessage<MissionOuterClass.Mission> getMissionEventList() {
      return missionEventList;
    }

    /**
     * <code>repeated .Mission mission_event_list = 5;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedMessage<MissionOuterClass.Mission> getMutableMissionEventList() {
      bitField0_ |= 0x00000004;
      return missionEventList;
    }

    /**
     * <code>repeated .Mission mission_event_list = 5;</code>
     * @param value the missionEventList to add
     * @return this
     */
    public MissionEventSync addMissionEventList(final MissionOuterClass.Mission value) {
      bitField0_ |= 0x00000004;
      missionEventList.add(value);
      return this;
    }

    /**
     * <code>repeated .Mission mission_event_list = 5;</code>
     * @param values the missionEventList to add
     * @return this
     */
    public MissionEventSync addAllMissionEventList(final MissionOuterClass.Mission... values) {
      bitField0_ |= 0x00000004;
      missionEventList.addAll(values);
      return this;
    }

    @Override
    public MissionEventSync copyFrom(final MissionEventSync other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        nOININCHJKJ.copyFrom(other.nOININCHJKJ);
        pIMONIABIKO.copyFrom(other.pIMONIABIKO);
        missionEventList.copyFrom(other.missionEventList);
      }
      return this;
    }

    @Override
    public MissionEventSync mergeFrom(final MissionEventSync other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasNOININCHJKJ()) {
        getMutableNOININCHJKJ().addAll(other.nOININCHJKJ);
      }
      if (other.hasPIMONIABIKO()) {
        getMutablePIMONIABIKO().addAll(other.pIMONIABIKO);
      }
      if (other.hasMissionEventList()) {
        getMutableMissionEventList().addAll(other.missionEventList);
      }
      return this;
    }

    @Override
    public MissionEventSync clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      nOININCHJKJ.clear();
      pIMONIABIKO.clear();
      missionEventList.clear();
      return this;
    }

    @Override
    public MissionEventSync clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      nOININCHJKJ.clear();
      pIMONIABIKO.clear();
      missionEventList.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof MissionEventSync)) {
        return false;
      }
      MissionEventSync other = (MissionEventSync) o;
      return bitField0_ == other.bitField0_
        && (!hasNOININCHJKJ() || nOININCHJKJ.equals(other.nOININCHJKJ))
        && (!hasPIMONIABIKO() || pIMONIABIKO.equals(other.pIMONIABIKO))
        && (!hasMissionEventList() || missionEventList.equals(other.missionEventList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        for (int i = 0; i < nOININCHJKJ.length(); i++) {
          output.writeRawByte((byte) 8);
          output.writeUInt32NoTag(nOININCHJKJ.array()[i]);
        }
      }
      if ((bitField0_ & 0x00000002) != 0) {
        for (int i = 0; i < pIMONIABIKO.length(); i++) {
          output.writeRawByte((byte) 80);
          output.writeUInt32NoTag(pIMONIABIKO.array()[i]);
        }
      }
      if ((bitField0_ & 0x00000004) != 0) {
        for (int i = 0; i < missionEventList.length(); i++) {
          output.writeRawByte((byte) 42);
          output.writeMessageNoTag(missionEventList.get(i));
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += (1 * nOININCHJKJ.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(nOININCHJKJ);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        size += (1 * pIMONIABIKO.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(pIMONIABIKO);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        size += (1 * missionEventList.length()) + ProtoSink.computeRepeatedMessageSizeNoTag(missionEventList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public MissionEventSync mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 10: {
            // nOININCHJKJ [packed=true]
            input.readPackedUInt32(nOININCHJKJ, tag);
            bitField0_ |= 0x00000001;
            tag = input.readTag();
            if (tag != 82) {
              break;
            }
          }
          case 82: {
            // pIMONIABIKO [packed=true]
            input.readPackedUInt32(pIMONIABIKO, tag);
            bitField0_ |= 0x00000002;
            tag = input.readTag();
            if (tag != 42) {
              break;
            }
          }
          case 42: {
            // missionEventList
            tag = input.readRepeatedMessage(missionEventList, tag);
            bitField0_ |= 0x00000004;
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
          case 8: {
            // nOININCHJKJ [packed=false]
            tag = input.readRepeatedUInt32(nOININCHJKJ, tag);
            bitField0_ |= 0x00000001;
            break;
          }
          case 80: {
            // pIMONIABIKO [packed=false]
            tag = input.readRepeatedUInt32(pIMONIABIKO, tag);
            bitField0_ |= 0x00000002;
            break;
          }
        }
      }
    }

    @Override
    public void writeTo(final JsonSink output) throws IOException {
      output.beginObject();
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRepeatedUInt32(FieldNames.nOININCHJKJ, nOININCHJKJ);
      }
      if ((bitField0_ & 0x00000002) != 0) {
        output.writeRepeatedUInt32(FieldNames.pIMONIABIKO, pIMONIABIKO);
      }
      if ((bitField0_ & 0x00000004) != 0) {
        output.writeRepeatedMessage(FieldNames.missionEventList, missionEventList);
      }
      output.endObject();
    }

    @Override
    public MissionEventSync mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case 1292540217: {
            if (input.isAtField(FieldNames.nOININCHJKJ)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(nOININCHJKJ);
                bitField0_ |= 0x00000001;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case 1978024214: {
            if (input.isAtField(FieldNames.pIMONIABIKO)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(pIMONIABIKO);
                bitField0_ |= 0x00000002;
              }
            } else {
              input.skipUnknownField();
            }
            break;
          }
          case -1451600340:
          case 1384393654: {
            if (input.isAtField(FieldNames.missionEventList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedMessage(missionEventList);
                bitField0_ |= 0x00000004;
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
    public MissionEventSync clone() {
      return new MissionEventSync().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static MissionEventSync parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new MissionEventSync(), data).checkInitialized();
    }

    public static MissionEventSync parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new MissionEventSync(), input).checkInitialized();
    }

    public static MissionEventSync parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new MissionEventSync(), input).checkInitialized();
    }

    /**
     * @return factory for creating MissionEventSync messages
     */
    public static MessageFactory<MissionEventSync> getFactory() {
      return MissionEventSyncFactory.INSTANCE;
    }

    private enum MissionEventSyncFactory implements MessageFactory<MissionEventSync> {
      INSTANCE;

      @Override
      public MissionEventSync create() {
        return MissionEventSync.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName nOININCHJKJ = FieldName.forField("NOININCHJKJ");

      static final FieldName pIMONIABIKO = FieldName.forField("PIMONIABIKO");

      static final FieldName missionEventList = FieldName.forField("missionEventList", "mission_event_list");
    }
  }
}
