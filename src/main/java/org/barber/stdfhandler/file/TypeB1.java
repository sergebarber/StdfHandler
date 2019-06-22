package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.util.regex.Pattern;

public class TypeB1 extends Type<String> {

    public static final int LENGTH = 8;
    private static final int BYTE_LENGTH = 1;

    private static final Pattern BIT_PATTERN = Pattern.compile("[01]+");

    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 7;

    public static final String ILLEGAL_LENGTH_MESSAGE =
            "Illegal argument length %s for type StdfB1. Should be exactly " + LENGTH + " characters long";
    public static final String ILLEGAL_VALUE_MESSAGE =
            "Illegal argument %s for type StdfB1. Should be a binary string";
    public static final String ILLEGAL_POSITION_MESSAGE =
            "Illegal position argument %d for type StdfB1. Should be between " + MIN_POSITION + " and " + MAX_POSITION;

    TypeB1(String name, String nullValue) {
        super(name, nullValue, TYPE_B1_DEFAULT_VALUE);
    }

    @Override
    void setValueFromStream(ByteArrayInputStream stream, ByteConverter byteConverter) {
        String value = ByteConverter.signedToBinaryString(stream.read(), BYTE_LENGTH);
        setValue(value);
    }

    @Override
    void setValueFromUser(String value) {
        if (value.length() != LENGTH) {
            throw new IllegalArgumentException(String.format(ILLEGAL_LENGTH_MESSAGE, value));
        }
        if (!BIT_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_MESSAGE, value));
        }
        setValue(value);
    }

    @Override
    byte[] toBytes(ByteConverter byteConverter) {
        return new byte[]{(byte)Integer.parseInt(getActualValue(), 2)};
    }

    boolean getBitInPosition(int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException(String.format(ILLEGAL_POSITION_MESSAGE, position));
        }
        return getActualValue().substring(position, position + 1).equals("0");
    }

    void setBitInPosition(boolean value, int position) {
        if (position < MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException(String.format(ILLEGAL_POSITION_MESSAGE, position));
        }
        String actualValue = getActualValue();
        int intValue = value ? 0 : 1;
        setValueFromUser(actualValue.substring(0, position) + intValue + actualValue.substring(position + 1));
    }
}
