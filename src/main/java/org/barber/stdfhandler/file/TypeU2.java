package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeU2 extends Type<Integer> {

    private static final int MAX_VALUE = 65535;
    private static final int MIN_VALUE = 0;
    static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument size %d for type StdfU2. Should be " + "%d <= size <= %d";

    static final int BYTE_LENGTH = 2;
    private static final int NULL_VALUE = 0;

    TypeU2(String name) {
        super(name);
    }

    @Override
    void setValue(ByteArrayInputStream stream) {
        this.value = (int) byteStreamToNumber(stream, BYTE_LENGTH);
    }

    @Override
    void setValue(Integer value) {
        checkValue(value);
        this.value = value;
    }

    @Override
    byte[] toBytes() {
        int value = this.value == null ? NULL_VALUE : this.value;
        return toBytes(value, U2_BINARY_STRING_FORMAT);
    }

    static void checkValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value, MIN_VALUE, MAX_VALUE));
        }
    }
}
