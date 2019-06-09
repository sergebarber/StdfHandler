package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

public class TypeU2 extends Type<Integer> {

    public static final int MAX_VALUE = 65535;
    public static final int MIN_VALUE = 0;
    public static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument size %d for type StdfU2. Should be " + MIN_VALUE + " <= size <= " + MAX_VALUE;

    private static final int BYTE_LENGTH = 2;

    TypeU2(String name, Integer nullValue) {
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
        return toBytes(value, U2_BINARY_STRING_FORMAT);
    }
}
