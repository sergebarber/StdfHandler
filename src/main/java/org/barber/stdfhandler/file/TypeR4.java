package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

public class TypeR4 extends Type<Float> {

    TypeR4(String name, Float nullValue) {
        super(name, nullValue, FLOAT_DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) {
        setValue(byteConverter.bytesToFloat(stream));
    }

    @Override
    void setValueFromUser(Float value) {
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        return byteConverter.floatToBytes(getActualValue());
    }
}
