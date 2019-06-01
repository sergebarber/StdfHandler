package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeCn extends TypeString {

    static final int MAX_LENGTH = 255;
    static final String NULL_VALUE = "";

    @Override
    void setValue(ByteArrayInputStream stream) {
        int length = stream.read();
        this.value = byteStreamToString(stream, length);
    }

    @Override
    void setValue(Object value) {
        String actualValue = TYPE.cast(value);
        this.value = actualValue.length() > MAX_LENGTH ? actualValue.substring(0, MAX_LENGTH) : actualValue;
    }

    @Override
    byte[] toBytes() {
        String value = this.value == null ? NULL_VALUE : this.value;
        int length = value.length();

        byte[] res = new byte[length + 1];
        res[0] = toBytes(length, U1_BINARY_STRING_FORMAT)[0];
        System.arraycopy(value.getBytes(), 0, res, 1, length);

        return res;
    }
}
