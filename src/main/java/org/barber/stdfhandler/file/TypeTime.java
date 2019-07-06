package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.function.Predicate;

public class TypeTime extends Type<Instant> {

    public static final long MAX_VALUE = 4_294_967_295L;
    public static final long MIN_VALUE = 0;
    public static final Instant DEFAULT_VALUE = Instant.ofEpochSecond(0L);

    public static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal amount of seconds %d for type StdfTime. Should be "+ MIN_VALUE + " <= seconds <= " + MAX_VALUE;

    private static final int BYTE_LENGTH = 4;

    TypeTime(String name) {
        super(name, DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
        Instant value = Instant.ofEpochSecond(byteConverter.bytesToUnsignedLong(stream, BYTE_LENGTH));
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
    byte[] toBytes(ByteConverter byteConverter) {
        return byteConverter.unsignedIntegerToBytes(getActualValue().getEpochSecond(),
                ByteConverter.L4BYTES_BINARY_STRING_FORMAT);
    }
}
