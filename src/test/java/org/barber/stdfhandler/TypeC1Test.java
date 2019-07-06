package org.barber.stdfhandler;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

class TypeC1Test extends TypeTest {

    static final char TEST_VALUE = 'A';

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testHbrHbinPf() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordHbr::newInstance, (r, v) -> ((RecordHbr) r).setHbinPf(v), r -> ((RecordHbr) r).getHbinPf());
    }

    @Test
    void testMirModeCod() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordMir::newInstance, (r, v) -> ((RecordMir) r).setModeCod(v), r -> ((RecordMir) r).getModeCod());
    }

    @Test
    void testMirRtstCod() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordMir::newInstance, (r, v) -> ((RecordMir) r).setRtstCod(v), r -> ((RecordMir) r).getRtstCod());
    }

    @Test
    void testMirProtCod() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordMir::newInstance, (r, v) -> ((RecordMir) r).setProtCod(v), r -> ((RecordMir) r).getProtCod());
    }

    @Test
    void testMirCmodCod() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordMir::newInstance, (r, v) -> ((RecordMir) r).setCmodCod(v), r -> ((RecordMir) r).getCmodCod());
    }

    @Test
    void testMrrDispCod() throws IOException {
        callTestOptionalResultWithNullValue(
                RecordMrr::newInstance, (r, v) -> ((RecordMrr) r).setDispCod(v), r -> ((RecordMrr) r).getDispCod());
    }


    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testMaxValue() throws IOException {
        char expected = TypeC1.MAX_VALUE;
        RecordHbr recordHbr = RecordHbr.newInstance().setHbinPf(expected);
        testValueFild(recordHbr, record -> recordHbr.getHbinPf(), expected);
    }

    @Test
    void testMoreThanMaxValueThrows() {
        char expected = TypeC1.MAX_VALUE + 1;
        RecordHbr recordHbr = RecordHbr.newInstance();
        testIllegalValue(recordHbr, expected, (record, integer) -> recordHbr.setHbinPf(integer),
                String.format(TypeC1.ILLEGAL_VALUE_MESSAGE, expected));
    }

    private void callTestOptionalResultWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, Character, Record> setter,
            Function<Record, Optional<Character>> getter) throws IOException {

        testValueFieldWithNullValue(emptyRecord, setter, TEST_VALUE, getter, TypeC1.DEFAULT_VALUE);
    }
}
