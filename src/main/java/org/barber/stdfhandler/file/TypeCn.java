package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeCn extends Type<String> {

    static final int MAX_LENGTH = 255;
    static final String NULL_VALUE = "";

    TypeCn(String name) {
        super(name);
    }

    @Override
    void setValue(ByteArrayInputStream stream) {
        int length = stream.read();
        this.value = byteStreamToString(stream, length);
    }

    @Override
    void setValue(String value) {
        this.value = value.length() > MAX_LENGTH ? value.substring(0, MAX_LENGTH) : value;
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
