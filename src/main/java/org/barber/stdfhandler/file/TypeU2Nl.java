package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeU2Nl extends TypeU2 {

    private static final int NULL_VALUE = 65535;

    @Override
    void setValue(ByteArrayInputStream stream) {
        int value = (int) byteStreamToNumber(stream, BYTE_LENGTH);
        this.value = value == NULL_VALUE ? null : value;
    }

    @Override
    void setValue(Object value) {
        int actualValue = TYPE.cast(value);
        if (actualValue < MIN_VALUE || actualValue > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, actualValue, MIN_VALUE, MAX_VALUE));
        }
        this.value = actualValue == NULL_VALUE ? null : actualValue;
    }
}
