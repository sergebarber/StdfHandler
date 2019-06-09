package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

public class TypeU1 extends Type<Integer> {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 255;
    public static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument size %d for type StdfU1. Should be " + MIN_VALUE + " <= size <= " + MAX_VALUE;

    private static final int BYTE_LENGTH = 1;

    TypeU1(String name, Integer nullValue) {
        super(name, nullValue, INT_DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream) {
        int value = (int) byteStreamToNumber(stream, BYTE_LENGTH);
        setValue(value);
    }

    @Override
    void setValueFromUser(Integer value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes() {
        int value = getActualValue();
        return toBytes(value, U1_BINARY_STRING_FORMAT);
    }
}
