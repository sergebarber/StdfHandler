package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

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
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
        setValue(byteConverter.bytesToUnsignedInt(stream, BYTE_LENGTH));
    }

    @Override
    void setValueFromUser(Integer value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        return byteConverter.unsignedIntegerToBytes(getActualValue(), ByteConverter.L2BYTES_BINARY_STRING_FORMAT);
    }
}
