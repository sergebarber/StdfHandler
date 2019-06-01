package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeU1 extends Type<Integer> {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 255;
    private static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument size %d for type StdfU1. Should be %d <= size <= %d";

    private static final int BYTE_LENGTH = 1;
    private static final int NULL_VALUE = 0;

    static final Class<Integer> TYPE = Integer.class;

    @Override
    void setValue(ByteArrayInputStream stream) {
        this.value = (int) byteStreamToNumber(stream, BYTE_LENGTH);
    }

    @Override
    void setValue(Object value) {
        int actualValue = TYPE.cast(value);
        if (actualValue < MIN_VALUE || actualValue > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, actualValue, MIN_VALUE, MAX_VALUE));
        }
        this.value = actualValue;
    }

    @Override
    byte[] toBytes() {
        int value = this.value == null ? NULL_VALUE : this.value;
        return toBytes(value, U1_BINARY_STRING_FORMAT);
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }
}
