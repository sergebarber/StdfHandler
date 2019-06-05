package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeU2Nl extends TypeU2 {

    private static final int NULL_VALUE = 65535;

    TypeU2Nl(String name) {
        super(name);
    }

    @Override
    void setValue(ByteArrayInputStream stream) {
        int value = (int) byteStreamToNumber(stream, BYTE_LENGTH);
        this.value = value == NULL_VALUE ? null : value;
    }

    @Override
    void setValue(Integer value) {
        checkValue(value);
        this.value = value == NULL_VALUE ? null : value;
    }
}
