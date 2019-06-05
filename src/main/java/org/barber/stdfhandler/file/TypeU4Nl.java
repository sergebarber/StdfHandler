package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeU4Nl extends TypeU4 {

    TypeU4Nl(String name) {
        super(name);
    }

    private static final long NULL_VALUE = 4_294_967_295L;

    @Override
    void setValue(ByteArrayInputStream stream) {
        long value = byteStreamToNumber(stream, BYTE_LENGTH);
        this.value = value == NULL_VALUE ? null : value;
    }

    @Override
    void setValue(Long value) {
        checkValue(value);
        this.value = value == NULL_VALUE ? null : value;
    }

    @Override
    byte[] toBytes() {
        long value = this.value == null ? NULL_VALUE : this.value;
        return toBytes(value, U4_BINARY_STRING_FORMAT);
    }
}
