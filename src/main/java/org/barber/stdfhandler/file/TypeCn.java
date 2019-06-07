package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeCn extends Type<String> {

    private static final int MAX_LENGTH = 255;

    TypeCn(String name, String nullValue) {
        super(name, nullValue, STRING_DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream) {
        int length = stream.read();
        String value = byteStreamToString(stream, length);
        setValue(value);
    }

    @Override
    void setValueFromUser(String value) {
        value = value.length() > MAX_LENGTH ? value.substring(0, MAX_LENGTH) : value;
        setValue(value);
    }

    @Override
    byte[] toBytes() {
        String value = getActualValue();
        int length = value.length();

        byte[] res = new byte[length + 1];
        res[0] = toBytes(length, U1_BINARY_STRING_FORMAT)[0];
        System.arraycopy(value.getBytes(), 0, res, 1, length);

        return res;
    }
}
