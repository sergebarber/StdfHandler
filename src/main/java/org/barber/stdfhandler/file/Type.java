package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

abstract class Type<T> {

    static final String U1_BINARY_STRING_FORMAT = "%8s";
    static final String U2_BINARY_STRING_FORMAT = "%16s";
    static final String U4_BINARY_STRING_FORMAT = "%32s";

    static final String STRING_DEFAULT_VALUE = "";
    static final Integer INT_DEFAULT_VALUE = 0;
    static final Long LONG_DEFAULT_VALUE = 0L;

    private T value;
    private T nullValue;
    private String name;

    Type(String name, T nullValue, T defaultValue){
        this.name = name;
        this.nullValue = nullValue;
        this.value = this.nullValue != null ? this.nullValue : defaultValue;
    }

    abstract void setValueFromStream(ByteArrayInputStream stream);
    abstract void setValueFromUser(T value);
    abstract byte[] toBytes();

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

    private static byte[] readBytes(ByteArrayInputStream stream, int length) {
        try {
            return stream.readNBytes(length);
        } catch (IOException e) {
            throw new IllegalStateException("Error while reading from stream", e);
        }
    }

    // Converting numeric value to byte array

    static byte[] toBytes(long value, String format) {
        String binary = toBinaryString(value, format);
        return splitToBytes(binary);
    }

    private static byte[] splitToBytes(String bitString) {
        if (bitString.length() % 8 != 0) {
            throw new IllegalArgumentException(String.format(
                    "The bit string length %d is not divisible by 8", bitString.length()));
        }
        byte[] res = new byte[bitString.length() / 8];
        int position = 0;

        while (bitString.length() > 0) {
            String bits = bitString.substring(bitString.length() - 8);
            res[position++] = (byte)Integer.parseInt(bits, 2);
            bitString = bitString.substring(0, bitString.length() - 8);
        }
        return res;
    }


    // Converting byte stream to numeric value

    static long byteStreamToNumber(ByteArrayInputStream stream, int length) {
        return bytesToValue(readBytes(stream, length));
    }

    static long bytesToValue(byte[] bytes) {
        StringBuilder builder = new StringBuilder();

        for (int i = bytes.length - 1; i > -1; i--) {
            int unsigned = Byte.toUnsignedInt(bytes[i]);
            builder.append(toBinaryString(unsigned, U1_BINARY_STRING_FORMAT));
        }
        return Long.parseLong(builder.toString(), 2);
    }


    // Converting byte stream to string

    static String byteStreamToString(ByteArrayInputStream stream, int length) {
        return new String(readBytes(stream, length));
    }


    // Converting value to binary string

    private static String toBinaryString(long value, String format) {
        return String.format(format, Long.toBinaryString(value)).replace(' ', '0');
    }
}
