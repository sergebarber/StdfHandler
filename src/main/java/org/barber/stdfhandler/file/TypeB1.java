package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class TypeB1 extends Type<boolean[]> {

    private static final int LENGTH = 8;
    private static final int BYTE_LENGTH = 1;
    private static final String TRUE_BIT_VALUE = "0";
    private static final String FALSE_BIT_VALUE = "1";

    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 7;

//    public static final boolean[] DEFAULT_VALUE = new boolean[8];

    private static final String ILLEGAL_LENGTH_MESSAGE =
        "Illegal value length %d for type StdfB1. The max length is " + LENGTH;

    public static final String ILLEGAL_POSITION_MESSAGE =
            "Illegal position argument %d for type StdfB1. Should be between " + MIN_POSITION + " and " + MAX_POSITION;

    TypeB1(String name) {
        super(name, new boolean[8]);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) {
        String bitString = ByteConverter.signedToBinaryString(stream.read(), BYTE_LENGTH);
        boolean[] value = new boolean[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            value[i] = bitString.substring(i, i + 1).equals(TRUE_BIT_VALUE);
        }
        setValue(value);
    }

    @Override
    void setValueFromUser(boolean[] value) {
        if (value.length != LENGTH) {
            throw new IllegalArgumentException(String.format(ILLEGAL_LENGTH_MESSAGE, value.length));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        StringBuilder bitString = new StringBuilder();
        for (boolean bit : getActualValue()) {
            bitString.append(bit ? TRUE_BIT_VALUE : FALSE_BIT_VALUE);
        }
        return new byte[]{(byte)Integer.parseInt(bitString.toString(), 2)};
    }

    boolean getBitInPosition(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException(String.format(ILLEGAL_POSITION_MESSAGE, position));
        }
        return getActualValue()[position];
    }

    void setBitInPosition(boolean value, int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException(String.format(ILLEGAL_POSITION_MESSAGE, position));
        }
        getActualValue()[position] = value;
    }

    @Override
    public String toString() {
        return Arrays.toString(getActualValue());
    }
}
