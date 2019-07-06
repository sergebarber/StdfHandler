package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;

public enum  FloatingPointConverter {

    IEEE754b32 {

        @Override
        float bytesToFloat(ByteArrayInputStream stream) {
            StringBuilder binaryBuilder = new StringBuilder();
            for (int i = 0; i < Float.BYTES; i++) {
                String bits = ByteConverter.unsignedToBinaryString(
                        stream.read(), ByteConverter.L1BYTE_BINARY_STRING_FORMAT);
                binaryBuilder.append(bits.substring(bits.length() - Float.BYTES * 2));
            }
            return Float.intBitsToFloat((int)Long.parseLong(binaryBuilder.toString(), 2));
        }

        @Override
        byte[] floatToBytes(Float value) {
            String bits = ByteConverter.unsignedToBinaryString(Float.floatToRawIntBits(value),
                    ByteConverter.L4BYTES_BINARY_STRING_FORMAT);
            return splitToBytes(bits, Float.BYTES);
        }
    };

    abstract float bytesToFloat(ByteArrayInputStream stream);
    abstract byte[] floatToBytes(Float actualValue);

    private static byte[] splitToBytes(String bits, int length) {
        bits = bits.substring(bits.length() - length * 8);
        byte[] res = new byte[length];
        for (int i = 0; i < length; i++) {
            String sByte = bits.substring(0, 8);
            res[i] = (byte) Integer.parseInt(sByte, 2);
            bits = bits.substring(8);
        }
        return res;
    }
}
