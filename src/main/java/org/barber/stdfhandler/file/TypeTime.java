package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.time.Instant;

class TypeTime extends Type<Instant> {

    private static final long MAX_VALUE = 4_294_967_295L;
    private static final long MIN_VALUE = 0;
    static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal amount of seconds %d for type StdfTime. Should be "+ MIN_VALUE + " <= seconds <= " + MAX_VALUE;

    private static final int BYTE_LENGTH = 4;

    TypeTime(String name, Instant nullValue) {
        super(name, nullValue, Instant.ofEpochSecond(LONG_DEFAULT_VALUE));
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream) {
        Instant value = Instant.ofEpochSecond(byteStreamToNumber(stream, BYTE_LENGTH));
        setValue(value);
    }

    @Override
    void setValueFromUser(Instant value) {
        long epochSecond = value.getEpochSecond();
        if (epochSecond < MIN_VALUE || epochSecond > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, epochSecond));
        }
        value = Instant.ofEpochSecond(epochSecond);
        setValue(value);
    }

    @Override
    byte[] toBytes() {
        long value = getActualValue().getEpochSecond();
        return toBytes(value, U4_BINARY_STRING_FORMAT);
    }
}
