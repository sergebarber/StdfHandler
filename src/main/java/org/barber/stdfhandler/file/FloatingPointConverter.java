package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

public enum  FloatingPointConverter {

    IEEE754 {

        @Override
        float bytesToFloat(ByteArrayInputStream stream) {
            StringBuilder binaryBuilder = new StringBuilder();
            for (int i = 0; i < SINGLE_PRECISION_BYTE_LENGTH; i++) {
                binaryBuilder.append(ByteConverter.toBinaryString(stream.read(), ByteConverter.L1BYTE_BINARY_STRING_FORMAT));
            }
            return Float.intBitsToFloat(Integer.parseInt(binaryBuilder.toString(), 2));
        }

        @Override
        byte[] floatToBytes(Float value) {
            String bits = ByteConverter.toBinaryString(Float.floatToRawIntBits(value),
                    ByteConverter.L4BYTES_BINARY_STRING_FORMAT);
            return splitToBytes(bits, SINGLE_PRECISION_BYTE_LENGTH);
        }
    };

    private static final int SINGLE_PRECISION_BYTE_LENGTH = 4;

    abstract float bytesToFloat(ByteArrayInputStream stream);
    abstract byte[] floatToBytes(Float actualValue);

    private static byte[] splitToBytes(String bits, int length) {
        byte[] res = new byte[length];
        for (int i = 0; i < length; i++) {
            String sByte = bits.substring(0, 8);
            res[i] = (byte) Integer.parseInt(sByte, 2);
            bits = bits.substring(8);
        }
        return res;
    }
}
