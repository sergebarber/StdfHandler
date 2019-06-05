package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

class TypeCnNl extends TypeCn {

    TypeCnNl(String name) {
        super(name);
    }

    @Override
    void setValue(ByteArrayInputStream stream) {
        int length = stream.read();
        this.value =  length > 0 ? byteStreamToString(stream, length) : null;
    }

    @Override
    void setValue(String value) {
        if (!value.equals(NULL_VALUE)) {
            this.value = value.length() > MAX_LENGTH ? value.substring(0, MAX_LENGTH) : value;
        }
    }
}
