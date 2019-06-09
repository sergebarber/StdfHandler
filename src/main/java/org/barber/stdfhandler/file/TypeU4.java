package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

public class TypeU4 extends Type<Long> {

    public static final long MAX_VALUE = 4_294_967_295L;
    public static final int MIN_VALUE = 0;
    public static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument size %d for type StdfU4. Should be " + MIN_VALUE + " <= size <= " + MAX_VALUE;

    private static final int BYTE_LENGTH = 4;

    TypeU4(String name, Long nullValue) {
        super(name, nullValue, LONG_DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream) {
         long value = byteStreamToNumber(stream, BYTE_LENGTH);
         setValue(value);
    }

    @Override
    void setValueFromUser(Long value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes() {
        long value = getActualValue();
        return toBytes(value, U4_BINARY_STRING_FORMAT);
    }
}
