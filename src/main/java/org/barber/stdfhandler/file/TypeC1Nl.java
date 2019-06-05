package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeC1Nl extends Type<String> {

    private static final int MAX_LENGTH = 1;
    private static final String NULL_VALUE = " ";
    static final String ILLEGAL_VALUE_MESSAGE = "Illegal argument length %d for type StdfC1. Cannot be longer than %d";

    private static final int BYTE_LENGTH = 1;

    TypeC1Nl(String name) {
        super(name);
    }

    @Override
    void setValue(ByteArrayInputStream stream) {
        String value = byteStreamToString(stream, BYTE_LENGTH);
        this.value = value.equals(NULL_VALUE) ? null : value;
    }

    @Override
    void setValue(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value.length(), MAX_LENGTH));
        }
        this.value = value.equals(NULL_VALUE) ? null : value;
    }

    @Override
    byte[] toBytes() {
        String value = this.value == null ? NULL_VALUE : this.value;
        return value.getBytes();
    }
}
