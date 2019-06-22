package org.barber.stdfhandler.file;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.barber.stdfhandler.StdfTest;
import org.junit.jupiter.api.BeforeEach;

abstract class TypeTest extends StdfTest {

    FileBuilder fileBuilder;
    private FileHandler fileHandler;

    @BeforeEach
    void setUp() {
        fileHandler = FileHandler.newInstance();
        fileBuilder = fileHandler.getBuilder();
    }

    private FileImage readStream() throws IOException {
        ByteArrayOutputStream outputStream = fileBuilder.toStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return fileHandler.read(inputStream);
    }

    <T> void testValue(RecordTst recordTst, Function<RecordTst, Optional<T>> getter, T expected) throws IOException {
        fileBuilder = fileBuilder.addRecord(recordTst);
        assertThat(getter.apply(readStream().getTest()).orElseThrow()).isEqualTo(expected);
    }

    <T> void testOptionalThrows(RecordTst recordTst, Function<RecordTst, Optional<T>> getter) {
        fileBuilder = fileBuilder.addRecord(recordTst);
        assertThatThrownBy(() -> getter.apply(readStream().getTest()).orElseThrow());
    }

    void testIllegalValue(Supplier<RecordTst> setter, String message) {
        assertThatThrownBy(() -> fileBuilder.addRecord(setter.get()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }
}
