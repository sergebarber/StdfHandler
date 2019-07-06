package org.barber.stdfhandler;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class TypeDnTest extends TypeTest {

    static final byte[] TEST_VALUE = {123, 123, 123, 123, 123};

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testFtrFailPin() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setFailPin(v), r -> ((RecordFtr)r).getFailPin());
    }

    @Test
    void testFtrSpinMap() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordFtr::newInstance, (r, v) -> ((RecordFtr)r).setSpinMap(v), r -> ((RecordFtr)r).getSpinMap());
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testMaxLength() {
        byte[] tooLarge = new byte[TypeDn.MAX_LENGTH + 1];
        RecordFtr recordFtr = RecordFtr.newInstance();
        testIllegalValue(
                recordFtr, tooLarge, (r, v) -> recordFtr.setFailPin(tooLarge),
                String.format(TypeDn.ILLEGAL_LENGTH_MESSAGE, tooLarge.length));
    }

    @Test
    void testMoreThanMaxLengthThrows() {
        byte[] tooLarge = new byte[TypeDn.MAX_LENGTH + 1];
        RecordFtr recordFtr = RecordFtr.newInstance();
        testIllegalValue(
                recordFtr, tooLarge, (r, v) -> recordFtr.setFailPin(tooLarge),
                String.format(TypeDn.ILLEGAL_LENGTH_MESSAGE, tooLarge.length));
    }

    private void callTestOptionalResultWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, byte[], Record> setter,
            Function<Record, Optional<byte[]>> getter) throws IOException {

        testValueFieldWithNullValue(emptyRecord, setter, TEST_VALUE, getter, TypeDn.DEFAULT_VALUE);
    }
}
