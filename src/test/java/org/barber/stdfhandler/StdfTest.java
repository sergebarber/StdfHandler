package org.barber.stdfhandler;

import java.time.Instant;

public abstract class StdfTest {

    protected static final int TYPE_U1_EXPECTED_VALUE = 123;
    protected static final int TYPE_U2_EXPECTED_VALUE = 12345;
    protected static final long TYPE_U4_EXPECTED_VALUE = 1234567890;
    protected static final byte TYPE_I1_EXPECTED_VALUE = -12;
    protected static final int TYPE_I2_EXPECTED_VALUE = -12345;
    protected static final Instant TYPE_TIME_EXPECTED_VALUE = Instant.ofEpochSecond(1234567890);
    protected static final float TYPE_R4_EXPECTED_VALUE = 1234.5678f;
    protected static final char TYPE_C1_EXPECTED_VALUE = 'A';
    protected static final String  TYPE_CN_EXPECTED_VALUE = "Test string for type Cn";
    protected static final String  TYPE_B1_EXPECTED_VALUE = "10101010";
    protected static final String  TYPE_B1_DEFAULT_VALUE = "11111111";
    protected static final byte[] TYPE_BN_EXPECTED_VALUE = {123, 124, 125, 126, 127};

}

