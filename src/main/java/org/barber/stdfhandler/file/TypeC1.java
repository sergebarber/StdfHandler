package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeC1 extends Type<String> {

    static final int MAX_LENGTH = 1;
    static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument length %d for type StdfC1. Cannot be longer than " + MAX_LENGTH;

    private static final int BYTE_LENGTH = 1;

    TypeC1(String name, String nullValue) {
        super(name, nullValue, STRING_DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream) {
        String value = byteStreamToString(stream, BYTE_LENGTH);
        setValue(value);
    }

    @Override
    void setValueFromUser(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value.length()));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes() {
        byte[] bytes = getActualValue().getBytes();
        return toBytes(bytes[0], U1_BINARY_STRING_FORMAT);
    }
}
