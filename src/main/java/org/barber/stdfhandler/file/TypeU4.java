package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TypeU4 extends Type<Long> {

    public static final long MAX_VALUE = 4_294_967_295L;
    public static final long MIN_VALUE = 0;
    public static final long DEFAULT_VALUE = 0L;

    public static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument size %d for type StdfU4. Should be " + MIN_VALUE + " <= size <= " + MAX_VALUE;

    private static final int BYTE_LENGTH = 4;

    TypeU4(String name) {
        super(name, DEFAULT_VALUE);
    }

    TypeU4(String name, long nullValue) {
        super(name, nullValue, DEFAULT_VALUE);
    }

    TypeU4(String name, Supplier<Boolean> isNull) {
        super(name, isNull, DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
         setValue(byteConverter.bytesToUnsignedLong(stream, BYTE_LENGTH));
    }

    @Override
    void setValueFromUser(Long value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        return byteConverter.unsignedIntegerToBytes(getActualValue(), ByteConverter.L4BYTES_BINARY_STRING_FORMAT);
    }
}
