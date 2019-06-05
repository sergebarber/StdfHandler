package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeU4 extends Type<Long> {

    private static final long MAX_VALUE = 4_294_967_295L;
    private static final int MIN_VALUE = 0;
    static final String ILLEGAL_VALUE_MESSAGE = "Illegal argument size %d for type StdfU4. Should be %d <= size <= %d";

    static final int BYTE_LENGTH = 4;
    private static final int NULL_VALUE = 0;

    TypeU4(String name) {
        super(name);
    }

    @Override
    void setValue(ByteArrayInputStream stream) {
        this.value = byteStreamToNumber(stream, BYTE_LENGTH);
    }

    @Override
    void setValue(Long value) {
        checkValue(value);
        this.value = value;
    }

    @Override
    byte[] toBytes() {
        long value = this.value == null ? NULL_VALUE : this.value;
        return toBytes(value, U4_BINARY_STRING_FORMAT);
    }

    static void checkValue(long value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value, MIN_VALUE, MAX_VALUE));
        }
    }
}
