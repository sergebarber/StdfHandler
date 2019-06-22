package org.barber.stdfhandler.records;

import org.barber.stdfhandler.StdfTest;
import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.FileImage;
import org.barber.stdfhandler.file.FileHandler;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

abstract class RecordTest extends StdfTest {

    protected FileHandler fileHandler;

    FileImage readFile(ByteArrayOutputStream outputStream) throws IOException {
        return fileHandler.read(new ByteArrayInputStream(outputStream.toByteArray()));
    }

    @BeforeEach
    void setUp() {
        fileHandler =  FileHandler.newInstance();
    }

    <T> void testOptionalField(FileBuilder builder, Function<FileImage, Optional<T>> getter, T expected)
            throws IOException {
        ByteArrayOutputStream outputStream = builder.toStream();
        FileImage image = readFile(outputStream);
        assertThat(getter.apply(image).orElseThrow()).isEqualTo(expected);
    }

    <T> void testListField(FileBuilder builder, Function<FileImage, List<T>> getter, List<T> expected)
            throws IOException {
        ByteArrayOutputStream outputStream = builder.toStream();
        FileImage image = readFile(outputStream);
        assertThat(getter.apply(image)).isEqualTo(expected);
    }

}
