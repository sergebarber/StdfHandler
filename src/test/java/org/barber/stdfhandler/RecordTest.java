package org.barber.stdfhandler;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.FileImage;
import org.barber.stdfhandler.file.FileReader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

abstract class RecordTest {

    private FileReader fileReader = new FileReader();

    private FileImage readFile(ByteArrayOutputStream outputStream) throws IOException {
        return fileReader.read(new ByteArrayInputStream(outputStream.toByteArray()));
    }

    <T> void testField(FileBuilder builder, Function<FileImage, Optional<T>> getter, T expected) throws IOException {
        ByteArrayOutputStream outputStream = builder.toStream();
        FileImage image = readFile(outputStream);
        assertThat(getter.apply(image).orElseThrow()).isEqualTo(expected);
    }
}
