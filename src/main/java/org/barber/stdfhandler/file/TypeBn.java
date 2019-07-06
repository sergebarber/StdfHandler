package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;

public class TypeBn extends Type<byte[]> {

    public static final int MAX_LENGTH = 255;
    public static final String ILLEGAL_LENGTH_MESSAGE =
            "Illegal length %d of the argument array. Should be no more then " + MAX_LENGTH;

    TypeBn(String name, byte[] nullValue) {
        super(name, nullValue, getDefaultValue());
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) throws IOException {
        int length = stream.read();
        setValue(stream.readNBytes(length));
    }

    @Override
    void setValueFromUser(byte[] value) {
        if (value.length > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(ILLEGAL_LENGTH_MESSAGE, value.length));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        byte[] value = getActualValue();
        byte[] res = new byte[value.length + 1];
        res[0] = (byte)value.length;
        System.arraycopy(value, 0, res, 1, value.length);
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(getActualValue());
    }

    public static byte[] getDefaultValue() {
        return new byte[0];
    }
}
