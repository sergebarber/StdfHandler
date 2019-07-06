package org.barber.stdfhandler;

import org.barber.stdfhandler.file.Record;
import org.barber.stdfhandler.file.RecordFtr;
import org.barber.stdfhandler.file.TypeI4;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class TypeI4Test extends TypeTest{

    static final int TEST_VALUE = -12345;

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testFtrXfailAd() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordFtr::newInstance, (r, v) -> ((RecordFtr) r).setXfailAd(v),
                r -> ((RecordFtr) r).getXfailAd());
    }

    @Test
    void testFtrYfailAd() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordFtr::newInstance, (r, v) -> ((RecordFtr) r).setYfailAd(v),
                r -> ((RecordFtr) r).getYfailAd());
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testDefaultNullValueSet() throws IOException {
        int expected = TypeI4.DEFAULT_VALUE;
        RecordFtr recordFtr = RecordFtr.newInstance().setXfailAd(expected);
        testValueFild(recordFtr, record -> recordFtr.getXfailAd(), expected);
    }

    private void callTestOptionalResultWithPredicate(
            Supplier<Record> emptyRecord, BiFunction<Record, Integer, Record> setter,
            Function<Record, Optional<Integer>> getter) throws IOException {

        testValueFieldWithPredicate(emptyRecord, setter, TEST_VALUE, getter);
    }
}
