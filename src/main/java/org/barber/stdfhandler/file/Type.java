package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

abstract class Type<T> {

    static final String STRING_DEFAULT_VALUE = "";
    static final Integer INT_DEFAULT_VALUE = 0;
    static final Long LONG_DEFAULT_VALUE = 0L;
    static final Float FLOAT_DEFAULT_VALUE = 0f;

    private T value;
    private T nullValue;
    private String name;

    Type(String name, T nullValue, T defaultValue){
        this.name = name;
        this.nullValue = nullValue;
        this.value = this.nullValue != null ? this.nullValue : defaultValue;
    }

    abstract void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException;
    abstract void setValueFromUser(T value);
    abstract byte[] toBytes(ByteConverter byteConverter);

    public String getName() {
        return name;
    }

    public T getValue() {
        return this.value.equals(this.nullValue) ? null : value;
    }

    T getActualValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
