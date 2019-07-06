package org.barber.stdfhandler;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class TypeR4Test extends TypeTest {

    static final float TEST_VALUE = -1234.567f;

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testMprLoLimit() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setLlmScalAndLoLimit(TypeI1Test.TEST_VALUE, v),
                r -> ((RecordMpr)r).getLoLimit());
    }

    @Test
    void testMprHiLimit() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setHlmScalAndHiLimit(TypeI1Test.TEST_VALUE, v),
                r -> ((RecordMpr)r).getHiLimit());
    }

    @Test
    void testMprStartIn() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setStartInAndIncrIn(v, v),
                r -> ((RecordMpr)r).getStartIn());
    }

    @Test
    void testMprIncrIn() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setStartInAndIncrIn(v, v),
                r -> ((RecordMpr)r).getIncrIn());
    }

    @Test
    void testMprLoSpec() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setLoSpec(v), r -> ((RecordMpr)r).getLoSpec());
    }

    @Test
    void testMprHiSpec() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setHiSpec(v), r -> ((RecordMpr)r).getHiSpec());
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    private void callTestOptionalResultWithPredicate(
            Supplier<Record> emptyRecord, BiFunction<Record, Float, Record> setter,
            Function<Record, Optional<Float>> getter) throws IOException {

        testValueFieldWithPredicate(emptyRecord, setter, TEST_VALUE, getter);
    }
}
