package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.time.Instant;

class TypeTime extends Type<Instant> {

    private static final long MAX_VALUE = 4_294_967_295L;
    private static final long MIN_VALUE = 0;
    private static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal amount of seconds %d for type StdfTime. Should be %d <= seconds <= %d";

    private static final int BYTE_LENGTH = 4;
    private static final int NULL_VALUE = 0;

    static final Class<Instant> TYPE = Instant.class;

    @Override
    void setValue(ByteArrayInputStream stream) {
        this.value = Instant.ofEpochSecond(byteStreamToNumber(stream, BYTE_LENGTH));
    }

    @Override
    void setValue(Object value) {
        Instant actualValue = TYPE.cast(value);
        long epochSecond = actualValue.getEpochSecond();
        if (epochSecond < MIN_VALUE || epochSecond > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, epochSecond, MIN_VALUE, MAX_VALUE));
        }
        this.value = Instant.ofEpochSecond(epochSecond);
    }

    @Override
    byte[] toBytes() {
        long value = this.value == null ? NULL_VALUE : this.value.getEpochSecond();
        return toBytes(value, U4_BINARY_STRING_FORMAT);
    }

    @Override
    String asString() {
        return value.toString();
    }
}
