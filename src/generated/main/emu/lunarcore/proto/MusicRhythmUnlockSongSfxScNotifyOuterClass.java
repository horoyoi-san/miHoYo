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

public final class MusicRhythmUnlockSongSfxScNotifyOuterClass {
  /**
   * Protobuf type {@code MusicRhythmUnlockSongSfxScNotify}
   */
  public static final class MusicRhythmUnlockSongSfxScNotify extends ProtoMessage<MusicRhythmUnlockSongSfxScNotify> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>repeated uint32 music_unlock_list = 14;</code>
     */
    private final RepeatedInt musicUnlockList = RepeatedInt.newEmptyInstance();

    private MusicRhythmUnlockSongSfxScNotify() {
    }

    /**
     * @return a new empty instance of {@code MusicRhythmUnlockSongSfxScNotify}
     */
    public static MusicRhythmUnlockSongSfxScNotify newInstance() {
      return new MusicRhythmUnlockSongSfxScNotify();
    }

    /**
     * <code>repeated uint32 music_unlock_list = 14;</code>
     * @return whether the musicUnlockList field is set
     */
    public boolean hasMusicUnlockList() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>repeated uint32 music_unlock_list = 14;</code>
     * @return this
     */
    public MusicRhythmUnlockSongSfxScNotify clearMusicUnlockList() {
      bitField0_ &= ~0x00000001;
      musicUnlockList.clear();
      return this;
    }

    /**
     * <code>repeated uint32 music_unlock_list = 14;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableMusicUnlockList()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public RepeatedInt getMusicUnlockList() {
      return musicUnlockList;
    }

    /**
     * <code>repeated uint32 music_unlock_list = 14;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public RepeatedInt getMutableMusicUnlockList() {
      bitField0_ |= 0x00000001;
      return musicUnlockList;
    }

    /**
     * <code>repeated uint32 music_unlock_list = 14;</code>
     * @param value the musicUnlockList to add
     * @return this
     */
    public MusicRhythmUnlockSongSfxScNotify addMusicUnlockList(final int value) {
      bitField0_ |= 0x00000001;
      musicUnlockList.add(value);
      return this;
    }

    /**
     * <code>repeated uint32 music_unlock_list = 14;</code>
     * @param values the musicUnlockList to add
     * @return this
     */
    public MusicRhythmUnlockSongSfxScNotify addAllMusicUnlockList(final int... values) {
      bitField0_ |= 0x00000001;
      musicUnlockList.addAll(values);
      return this;
    }

    @Override
    public MusicRhythmUnlockSongSfxScNotify copyFrom(final MusicRhythmUnlockSongSfxScNotify other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        musicUnlockList.copyFrom(other.musicUnlockList);
      }
      return this;
    }

    @Override
    public MusicRhythmUnlockSongSfxScNotify mergeFrom(
        final MusicRhythmUnlockSongSfxScNotify other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasMusicUnlockList()) {
        getMutableMusicUnlockList().addAll(other.musicUnlockList);
      }
      return this;
    }

    @Override
    public MusicRhythmUnlockSongSfxScNotify clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      musicUnlockList.clear();
      return this;
    }

    @Override
    public MusicRhythmUnlockSongSfxScNotify clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      musicUnlockList.clear();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof MusicRhythmUnlockSongSfxScNotify)) {
        return false;
      }
      MusicRhythmUnlockSongSfxScNotify other = (MusicRhythmUnlockSongSfxScNotify) o;
      return bitField0_ == other.bitField0_
        && (!hasMusicUnlockList() || musicUnlockList.equals(other.musicUnlockList));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        for (int i = 0; i < musicUnlockList.length(); i++) {
          output.writeRawByte((byte) 112);
          output.writeUInt32NoTag(musicUnlockList.array()[i]);
        }
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += (1 * musicUnlockList.length()) + ProtoSink.computeRepeatedUInt32SizeNoTag(musicUnlockList);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public MusicRhythmUnlockSongSfxScNotify mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 114: {
            // musicUnlockList [packed=true]
            input.readPackedUInt32(musicUnlockList, tag);
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
          case 112: {
            // musicUnlockList [packed=false]
            tag = input.readRepeatedUInt32(musicUnlockList, tag);
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
        output.writeRepeatedUInt32(FieldNames.musicUnlockList, musicUnlockList);
      }
      output.endObject();
    }

    @Override
    public MusicRhythmUnlockSongSfxScNotify mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -1584930297:
          case 1438691743: {
            if (input.isAtField(FieldNames.musicUnlockList)) {
              if (!input.trySkipNullValue()) {
                input.readRepeatedUInt32(musicUnlockList);
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
    public MusicRhythmUnlockSongSfxScNotify clone() {
      return new MusicRhythmUnlockSongSfxScNotify().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static MusicRhythmUnlockSongSfxScNotify parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new MusicRhythmUnlockSongSfxScNotify(), data).checkInitialized();
    }

    public static MusicRhythmUnlockSongSfxScNotify parseFrom(final ProtoSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new MusicRhythmUnlockSongSfxScNotify(), input).checkInitialized();
    }

    public static MusicRhythmUnlockSongSfxScNotify parseFrom(final JsonSource input) throws
        IOException {
      return ProtoMessage.mergeFrom(new MusicRhythmUnlockSongSfxScNotify(), input).checkInitialized();
    }

    /**
     * @return factory for creating MusicRhythmUnlockSongSfxScNotify messages
     */
    public static MessageFactory<MusicRhythmUnlockSongSfxScNotify> getFactory() {
      return MusicRhythmUnlockSongSfxScNotifyFactory.INSTANCE;
    }

    private enum MusicRhythmUnlockSongSfxScNotifyFactory implements MessageFactory<MusicRhythmUnlockSongSfxScNotify> {
      INSTANCE;

      @Override
      public MusicRhythmUnlockSongSfxScNotify create() {
        return MusicRhythmUnlockSongSfxScNotify.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName musicUnlockList = FieldName.forField("musicUnlockList", "music_unlock_list");
    }
  }
}
