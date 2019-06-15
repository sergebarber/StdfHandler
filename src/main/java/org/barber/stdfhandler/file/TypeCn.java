package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class TypeCn extends Type<String> {

    private static final int MAX_LENGTH = 255;

    TypeCn(String name, String nullValue) {
        super(name, nullValue, STRING_DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
        int length = stream.read();
        setValue(byteConverter.bytesToString(stream, length));
    }

    @Override
    void setValueFromUser(String value) {
        value = value.length() > MAX_LENGTH ? value.substring(0, MAX_LENGTH) : value;
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        return byteConverter.stringToBytes(getActualValue(), true);
    }
}
