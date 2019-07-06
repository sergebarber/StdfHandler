package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TypeR4 extends Type<Float> {

    public static final float DEFAULT_VALUE = 0.0f;

    TypeR4(String name) {
        super(name, DEFAULT_VALUE);
    }

    TypeR4(String name, Supplier<Boolean> isNull) {
        super(name, isNull, DEFAULT_VALUE);
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
