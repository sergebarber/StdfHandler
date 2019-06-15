package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TypeC1 extends Type<String> {

    public static final int MAX_LENGTH = 1;
    public static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument length %d for type StdfC1. Cannot be longer than " + MAX_LENGTH;
    public static final String ILLEGAL_CHARACTER_MESSAGE =
            "Illegal character %s for type StdfC1. Character not supported";

    private static final int BYTE_LENGTH = 1;

    TypeC1(String name, String nullValue) {
        super(name, nullValue, STRING_DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
        setValue(byteConverter.bytesToString(stream, BYTE_LENGTH));
    }

    @Override
    void setValueFromUser(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value.length()));
        }
        if (value.getBytes().length > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(ILLEGAL_CHARACTER_MESSAGE, value));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        return byteConverter.stringToBytes(getActualValue(), false);
    }
}
