package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeCnNl extends TypeCn {

    @Override
    void setValue(ByteArrayInputStream stream) {
        int length = stream.read();
        this.value =  length > 0 ? byteStreamToString(stream, length) : null;
    }

    @Override
    void setValue(Object value) {
        String actualValue = TYPE.cast(value);
        if (!value.equals(NULL_VALUE)) {
            this.value = actualValue.length() > MAX_LENGTH ? actualValue.substring(0, MAX_LENGTH) : actualValue;
        }
    }
}
