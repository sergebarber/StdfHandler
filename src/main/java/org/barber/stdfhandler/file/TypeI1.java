package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class TypeI1 extends Type<Byte> {

    private static final int BYTE_LENGTH = 1;

    TypeI1(String name, Byte nullValue) {
        super(name, nullValue, BYTE_DEFAULT_VALUE);
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
