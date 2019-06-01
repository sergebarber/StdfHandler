package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeC1Nl extends TypeString {

    private static final int MAX_LENGTH = 1;
    private static final String NULL_VALUE = " ";
    static final String ILLEGAL_VALUE_MESSAGE = "Illegal argument length %d for type StdfC1. Cannot be longer than %d";

    private static final int BYTE_LENGTH = 1;

    TypeC1Nl() { }

    @Override
    void setValue(ByteArrayInputStream stream) {
        String value = byteStreamToString(stream, BYTE_LENGTH);
        this.value = value.equals(NULL_VALUE) ? null : value;
    }

    @Override
    void setValue(Object value) {
        String actualValue = TYPE.cast(value);
        if (actualValue.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, actualValue.length(), MAX_LENGTH));
        }
        this.value = actualValue.equals(NULL_VALUE) ? null : actualValue;
    }

    @Override
    byte[] toBytes() {
        String value = this.value == null ? NULL_VALUE : this.value;
        return value.getBytes();
    }
}
