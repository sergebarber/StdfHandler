package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.function.Supplier;

public class TypeI1 extends Type<Byte> {

    private static final int BYTE_LENGTH = 1;
    public static final byte DEFAULT_VALUE = 0;

    TypeI1(String name) {
        super(name, DEFAULT_VALUE);
    }

    TypeI1(String name, Supplier<Boolean> isNull) {
        super(name, isNull, DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
        int value = byteConverter.bytesToSignedInt(stream, BYTE_LENGTH);
        setValue((byte)value);
    }

    @Override
    void setValueFromUser(Byte value) {
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        return byteConverter.signedIntegerToBytes(getActualValue(), ByteConverter.L1BYTE_BINARY_STRING_FORMAT,
                BYTE_LENGTH);
    }
}
