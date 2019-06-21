package org.barber.stdfhandler.file;

public enum IntegerConverter {



    LITTLE_ENDIAN{

        @Override
        String bytesToBitString(byte[] bytes) {
            StringBuilder builder = new StringBuilder();

            for (int i = bytes.length - 1; i > -1; i--) {
                int unsigned = Byte.toUnsignedInt(bytes[i]);
                builder.append(ByteConverter.unsignedToBinaryString(unsigned, ByteConverter.L1BYTE_BINARY_STRING_FORMAT));
            }
            return builder.toString();
        }

        @Override
        byte[] splitToBytes(String bitString) {
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
    },
    BIG_ENDIAN {

        @Override
        String bytesToBitString(byte[] bytes) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                int unsigned = Byte.toUnsignedInt(bytes[i]);
                builder.append(ByteConverter.unsignedToBinaryString(unsigned, ByteConverter.L1BYTE_BINARY_STRING_FORMAT));
            }
            return builder.toString();
        }

        @Override
        byte[] splitToBytes(String bitString) {
            if (bitString.length() % 8 != 0) {
                throw new IllegalArgumentException(String.format(
                        "The bit string length %d is not divisible by 8", bitString.length()));
            }
            byte[] res = new byte[bitString.length() / 8];
            int position = 0;

            while (bitString.length() > 0) {
                String bits = bitString.substring(0, 8);
                res[position++] = (byte)Integer.parseInt(bits, 2);
                bitString = bitString.substring(8);
            }
            return res;
        }
    };

    abstract String bytesToBitString(byte[] bytes);
    abstract byte[] splitToBytes(String bitString);
}
