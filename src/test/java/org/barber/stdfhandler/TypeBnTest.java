package org.barber.stdfhandler;

import org.barber.stdfhandler.file.Record;
import org.barber.stdfhandler.file.RecordPrr;
import org.barber.stdfhandler.file.TypeBn;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class TypeBnTest extends TypeTest {

    static byte[] TEST_VALUE = {123, 123, 123};

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testPrrPartFix() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordPrr::newInstance, (r, v) -> ((RecordPrr)r).setPartFix(v), r -> ((RecordPrr)r).getPartFix());
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testMaxLength() throws IOException {
        byte[] testValue = new byte[TypeBn.MAX_LENGTH];
        RecordPrr recordPrr = RecordPrr.newInstance().setPartFix(testValue);
        testValueFild(recordPrr, record -> recordPrr.getPartFix(), testValue);
    }

    @Test
    void testMoreThanMaxLengthThrows() {
        byte[] testValue = new byte[TypeBn.MAX_LENGTH + 1];
        RecordPrr recordPrr = RecordPrr.newInstance();
        testIllegalValue(
                recordPrr, testValue, (r, v) -> recordPrr.setPartFix(v),
                String.format(TypeBn.ILLEGAL_LENGTH_MESSAGE, testValue.length));
    }

    private void callTestOptionalResultWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, byte[], Record> setter,
            Function<Record, Optional<byte[]>> getter) throws IOException {

        testValueFieldWithNullValue(emptyRecord, setter, TEST_VALUE, getter, TypeBn.getDefaultValue());
    }

}
