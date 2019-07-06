package org.barber.stdfhandler;

import org.barber.stdfhandler.file.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class TypeI1Test extends TypeTest {

    static final byte TEST_VALUE = 123;

    // ************************************************************************************
    // Records tests
    // ************************************************************************************

    @Test
    void testMprResScal() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setResScal(v), r -> ((RecordMpr)r).getResScal());
    }

    @Test
    void testMprLlmScal() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr)r).setLlmScalAndLoLimit(v, TypeR4Test.TEST_VALUE),
                r -> ((RecordMpr)r).getLlmScal());
    }

    @Test
    void testMprHlmScal() throws IOException {
        callTestOptionalResultWithPredicate(
                RecordMpr::newInstance, (r, v) -> ((RecordMpr) r).setHlmScalAndHiLimit(v, TypeR4Test.TEST_VALUE),
                r -> ((RecordMpr) r).getHlmScal());
    }

    // ************************************************************************************
    // Type tests
    // ************************************************************************************

    @Test
    void testDefaultNullValueSet() throws IOException {
        byte expected = TypeI1.DEFAULT_VALUE;
        RecordMpr recordMpr = RecordMpr.newInstance().setResScal(expected);
        testValueFild(recordMpr, record -> recordMpr.getResScal(), expected);
    }

    private void callTestOptionalResultWithPredicate(
            Supplier<Record> emptyRecord, BiFunction<Record, Byte, Record> setter,
            Function<Record, Optional<Byte>> getter) throws IOException {

        testValueFieldWithPredicate(emptyRecord, setter, TEST_VALUE, getter);
    }
}

