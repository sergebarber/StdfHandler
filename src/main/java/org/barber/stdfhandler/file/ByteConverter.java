package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class ByteConverter {

    static final String L1BYTE_BINARY_STRING_FORMAT = "%8s";
    static final String L2BYTES_BINARY_STRING_FORMAT = "%16s";
    static final String L4BYTES_BINARY_STRING_FORMAT = "%32s";
    static final String L8BYTES_BINARY_STRING_FORMAT = "%64s";

    private final IntegerConverter integerConverter;
    private final FloatingPointConverter floatingPointConverter;

    ByteConverter(IntegerConverter integerConverter, FloatingPointConverter floatingPointConverter) {
        this.integerConverter = integerConverter;
        this.floatingPointConverter = floatingPointConverter;
    }

    // Bytes to value

    Integer bytesToUnsignedInt(ByteArrayInputStream stream, int length) throws IOException {
        return Integer.parseUnsignedInt(bytesToBitString(stream, length), 2);
    }

    Integer bytesToSignedInt(ByteArrayInputStream stream, int length) throws IOException {
        StringBuilder bits = new StringBuilder(bytesToBitString(stream, length));
        if (bits.indexOf("1") != 0) {
            return Integer.parseInt(bits.toString(), 2);
        }
        bits.replace(0, 1, "0");
        return -(Integer.parseInt(bits.toString(), 2) + 1);
    }

    Long bytesToUnsignedLong(ByteArrayInputStream stream, int length) throws IOException {
        return Long.parseUnsignedLong(bytesToBitString(stream, length), 2);
    }

    String bytesToString(ByteArrayInputStream stream, int length) throws IOException {
        return new String(stream.readNBytes(length));
    }

    float bytesToFloat(ByteArrayInputStream stream) {
        return floatingPointConverter.bytesToFloat(stream);
    }

    private String bytesToBitString(ByteArrayInputStream stream, int length) throws IOException {
        return integerConverter.bytesToBitString(stream.readNBytes(length));
    }

    // Value to bytes

    byte[] stringToBytes(String value, boolean addLength) {
        if (!addLength) {
            byte[] res = new byte[1];
            res[0] = (byte) Byte.toUnsignedInt(value.getBytes()[0]);
            return res;
        }
        int length = value.length();

        byte[] res = new byte[length + 1];
        res[0] = toBytes(length, L1BYTE_BINARY_STRING_FORMAT)[0];

        byte[] valueBytes = value.getBytes();
        for (int i = 0; i < valueBytes.length; i++) {
            res[i + 1] = (byte) Byte.toUnsignedInt(valueBytes[i]);
        }
        return res;
    }

    byte[] unsignedIntegerToBytes(long value, String binaryStringFormat) {
        return toBytes(value, binaryStringFormat);
    }

    byte[] signedIntegerToBytes(long value, String binaryStringFormat, int byteLength) {
        if (value >= 0) {
            return unsignedIntegerToBytes(value, binaryStringFormat);
        }
        return integerConverter.splitToBytes(switchSign(value, byteLength));
    }


    byte[] floatToBytes(Float actualValue) {
        return floatingPointConverter.floatToBytes(actualValue);
    }


    // Helpers

    static String unsignedToBinaryString(long value, String format) {
        return String.format(format, Long.toBinaryString(value)).replace(' ', '0');
    }

    static String signedToBinaryString(long value, int byteLength) {
        String bits = unsignedToBinaryString(value, L8BYTES_BINARY_STRING_FORMAT);
        return bits.substring(bits.length() - (byteLength * 8));
    }

    private static String switchSign(long value, int byteLength) {
        StringBuilder bits = new StringBuilder(signedToBinaryString(value, byteLength));
        String[] split = bits.toString().split("");
        bits = new StringBuilder("1");
        for (int i = 1; i < split.length; i++) {
            bits.append(split[i].equals("1") ? "0" : "1");
        }
        return bits.toString();
    }

    byte[] toBytes(long value, String format) {
        String binary = unsignedToBinaryString(value, format);
        return integerConverter.splitToBytes(binary);
    }
}
