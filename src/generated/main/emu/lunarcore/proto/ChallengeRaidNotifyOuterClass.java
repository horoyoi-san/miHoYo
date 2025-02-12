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

public final class ChallengeRaidNotifyOuterClass {
  /**
   * Protobuf type {@code ChallengeRaidNotify}
   */
  public static final class ChallengeRaidNotify extends ProtoMessage<ChallengeRaidNotify> implements Cloneable {
    private static final long serialVersionUID = 0L;

    /**
     * <code>optional .ChallengeRaid challenge_raid = 8;</code>
     */
    private final ChallengeRaidOuterClass.ChallengeRaid challengeRaid = ChallengeRaidOuterClass.ChallengeRaid.newInstance();

    private ChallengeRaidNotify() {
    }

    /**
     * @return a new empty instance of {@code ChallengeRaidNotify}
     */
    public static ChallengeRaidNotify newInstance() {
      return new ChallengeRaidNotify();
    }

    /**
     * <code>optional .ChallengeRaid challenge_raid = 8;</code>
     * @return whether the challengeRaid field is set
     */
    public boolean hasChallengeRaid() {
      return (bitField0_ & 0x00000001) != 0;
    }

    /**
     * <code>optional .ChallengeRaid challenge_raid = 8;</code>
     * @return this
     */
    public ChallengeRaidNotify clearChallengeRaid() {
      bitField0_ &= ~0x00000001;
      challengeRaid.clear();
      return this;
    }

    /**
     * <code>optional .ChallengeRaid challenge_raid = 8;</code>
     *
     * This method returns the internal storage object without modifying any has state.
     * The returned object should not be modified and be treated as read-only.
     *
     * Use {@link #getMutableChallengeRaid()} if you want to modify it.
     *
     * @return internal storage object for reading
     */
    public ChallengeRaidOuterClass.ChallengeRaid getChallengeRaid() {
      return challengeRaid;
    }

    /**
     * <code>optional .ChallengeRaid challenge_raid = 8;</code>
     *
     * This method returns the internal storage object and sets the corresponding
     * has state. The returned object will become part of this message and its
     * contents may be modified as long as the has state is not cleared.
     *
     * @return internal storage object for modifications
     */
    public ChallengeRaidOuterClass.ChallengeRaid getMutableChallengeRaid() {
      bitField0_ |= 0x00000001;
      return challengeRaid;
    }

    /**
     * <code>optional .ChallengeRaid challenge_raid = 8;</code>
     * @param value the challengeRaid to set
     * @return this
     */
    public ChallengeRaidNotify setChallengeRaid(final ChallengeRaidOuterClass.ChallengeRaid value) {
      bitField0_ |= 0x00000001;
      challengeRaid.copyFrom(value);
      return this;
    }

    @Override
    public ChallengeRaidNotify copyFrom(final ChallengeRaidNotify other) {
      cachedSize = other.cachedSize;
      if ((bitField0_ | other.bitField0_) != 0) {
        bitField0_ = other.bitField0_;
        challengeRaid.copyFrom(other.challengeRaid);
      }
      return this;
    }

    @Override
    public ChallengeRaidNotify mergeFrom(final ChallengeRaidNotify other) {
      if (other.isEmpty()) {
        return this;
      }
      cachedSize = -1;
      if (other.hasChallengeRaid()) {
        getMutableChallengeRaid().mergeFrom(other.challengeRaid);
      }
      return this;
    }

    @Override
    public ChallengeRaidNotify clear() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      challengeRaid.clear();
      return this;
    }

    @Override
    public ChallengeRaidNotify clearQuick() {
      if (isEmpty()) {
        return this;
      }
      cachedSize = -1;
      bitField0_ = 0;
      challengeRaid.clearQuick();
      return this;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof ChallengeRaidNotify)) {
        return false;
      }
      ChallengeRaidNotify other = (ChallengeRaidNotify) o;
      return bitField0_ == other.bitField0_
        && (!hasChallengeRaid() || challengeRaid.equals(other.challengeRaid));
    }

    @Override
    public void writeTo(final ProtoSink output) throws IOException {
      if ((bitField0_ & 0x00000001) != 0) {
        output.writeRawByte((byte) 66);
        output.writeMessageNoTag(challengeRaid);
      }
    }

    @Override
    protected int computeSerializedSize() {
      int size = 0;
      if ((bitField0_ & 0x00000001) != 0) {
        size += 1 + ProtoSink.computeMessageSizeNoTag(challengeRaid);
      }
      return size;
    }

    @Override
    @SuppressWarnings("fallthrough")
    public ChallengeRaidNotify mergeFrom(final ProtoSource input) throws IOException {
      // Enabled Fall-Through Optimization (QuickBuffers)
      int tag = input.readTag();
      while (true) {
        switch (tag) {
          case 66: {
            // challengeRaid
            input.readMessage(challengeRaid);
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
        output.writeMessage(FieldNames.challengeRaid, challengeRaid);
      }
      output.endObject();
    }

    @Override
    public ChallengeRaidNotify mergeFrom(final JsonSource input) throws IOException {
      if (!input.beginObject()) {
        return this;
      }
      while (!input.isAtEnd()) {
        switch (input.readFieldHash()) {
          case -812232051:
          case 603114982: {
            if (input.isAtField(FieldNames.challengeRaid)) {
              if (!input.trySkipNullValue()) {
                input.readMessage(challengeRaid);
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
    public ChallengeRaidNotify clone() {
      return new ChallengeRaidNotify().copyFrom(this);
    }

    @Override
    public boolean isEmpty() {
      return ((bitField0_) == 0);
    }

    public static ChallengeRaidNotify parseFrom(final byte[] data) throws
        InvalidProtocolBufferException {
      return ProtoMessage.mergeFrom(new ChallengeRaidNotify(), data).checkInitialized();
    }

    public static ChallengeRaidNotify parseFrom(final ProtoSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChallengeRaidNotify(), input).checkInitialized();
    }

    public static ChallengeRaidNotify parseFrom(final JsonSource input) throws IOException {
      return ProtoMessage.mergeFrom(new ChallengeRaidNotify(), input).checkInitialized();
    }

    /**
     * @return factory for creating ChallengeRaidNotify messages
     */
    public static MessageFactory<ChallengeRaidNotify> getFactory() {
      return ChallengeRaidNotifyFactory.INSTANCE;
    }

    private enum ChallengeRaidNotifyFactory implements MessageFactory<ChallengeRaidNotify> {
      INSTANCE;

      @Override
      public ChallengeRaidNotify create() {
        return ChallengeRaidNotify.newInstance();
      }
    }

    /**
     * Contains name constants used for serializing JSON
     */
    static class FieldNames {
      static final FieldName challengeRaid = FieldName.forField("challengeRaid", "challenge_raid");
    }
  }
}
