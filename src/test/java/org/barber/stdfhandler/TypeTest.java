package org.barber.stdfhandler;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.FileHandler;
import org.barber.stdfhandler.file.Record;
import org.barber.stdfhandler.file.RecordMpr;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

abstract class TypeTest {

    <T> void testValueFild(Record record, Function<Record, Optional<T>> getter, T expected) throws IOException {
        FileBuilder fileBuilder = FileHandler.newInstance().getBuilder().addRecord(record);
        assertThat(getter.apply(readStream(fileBuilder).get(1)).orElseThrow()).isEqualTo(expected);
    }

    <T> void testValueFieldWithNullValue(
            Supplier<Record> emptyRecord, BiFunction<Record, T, Record> setter, T expected,
            Function<Record, Optional<T>> getter, T nullValue) throws IOException {

        testValueFild(setter.apply(emptyRecord.get(), expected), getter, expected);
        testOptionalThrows(emptyRecord.get(), getter);
        testOptionalThrows(setter.apply(emptyRecord.get(), nullValue), getter);
    }

    <T> void testValueFieldWithPredicate(
            Supplier<Record> emptyRecord, BiFunction<Record, T, Record> setter, T expected,
            Function<Record, Optional<T>> getter) throws IOException {

        testValueFild(setter.apply(emptyRecord.get(), expected), getter, expected);
        Record record = emptyRecord.get();
        Record record1 = RecordMpr.newInstance();
        testOptionalThrows(record, getter);
    }

    private <T> void testOptionalThrows(Record record, Function<Record, Optional<T>> getter) throws IOException {
        FileBuilder fileBuilder = FileHandler.newInstance().getBuilder().addRecord(record);
        List<Record> records = readStream(fileBuilder);
        assertThatThrownBy(() -> getter.apply(readStream(fileBuilder).get(1)).orElseThrow());
    }

    <T> void testListField(
            Record record, Function<Record, List<T>> getter, List<T> expected,
            Supplier<Optional<Integer>> sizeGetter) throws IOException {

        FileBuilder fileBuilder = FileHandler.newInstance().getBuilder().addRecord(record);
        List<T> result = getter.apply(readStream(fileBuilder).get(1));
        assertThat(result).isEqualTo(expected);
        assertThat(sizeGetter.get().orElseThrow()).isEqualTo(result.size());
    }

    void testBitValue(Record record, Function<Record, Boolean> getter) throws IOException {
        FileBuilder fileBuilder = FileHandler.newInstance().getBuilder().addRecord(record);
        assertThat(getter.apply(readStream(fileBuilder).get(1))).isEqualTo(true);
    }

    <T> void testIllegalValue(Record record, T value, BiConsumer<Record, T> setter, String message) {
        assertThatThrownBy(() -> setter.accept(record, value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    private List<Record> readStream(FileBuilder fileBuilder) throws IOException {
        ByteArrayOutputStream outputStream = fileBuilder.toStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return FileHandler.newInstance().readAsRecordList(inputStream);
    }
}
