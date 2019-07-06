package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.function.Predicate;

public class TypeCn extends Type<String> {

    public static final int MAX_LENGTH = 255;
    public static final String DEFAULT_VALUE = "";

    TypeCn(String name) {
        super(name, DEFAULT_VALUE);
    }

    TypeCn(String name, String nullValue) {
        super(name, nullValue, DEFAULT_VALUE);
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
