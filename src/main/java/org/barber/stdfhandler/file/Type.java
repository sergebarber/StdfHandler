package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Type<T> {

    private T value;
    private T nullValue;
    private T defaultValue;
    private Supplier<Boolean> isNull;
    private String name;

    Type(String name, T defaultValue){
        this.value = defaultValue;
        this.name = name;
    }

    Type(String name, T nullValue, T defaultValue){
        this.name = name;
        this.nullValue = nullValue;
        this.value = nullValue;
        this.defaultValue = defaultValue;
    }

    Type(String name, Supplier<Boolean> isNull, T defaultValue){
        this.name = name;
        this.isNull = isNull;
        this.value = defaultValue;
    }

    abstract void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException;
    abstract void setValueFromUser(T value);
    abstract byte[] toBytes(ByteConverter byteConverter);

    public String getName() {
        return name;
    }

    public T getValue() {
        if (isNull != null) {
            return getValueByPredicate();
        }
        if (nullValue != null) {
            return getValueByNullValue();
        }
        return value;
    }

    private T getValueByNullValue() {
        if (nullValue instanceof byte[]) {
            return Arrays.equals((byte[])value, (byte[])nullValue) ? null : value;
        }
        else {
            return nullValue.equals(value) ? null : value;
        }
    }

    private T getValueByPredicate() {
        return isNull.get() ? null : value;
    }

    T getActualValue() {
        return value == null ? defaultValue : value;
    }

    void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
