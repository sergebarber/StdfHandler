package org.barber.stdfhandler.file;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

abstract class TypeTest {

    FileBuilder fileBuilder;
    FileReader fileReader;

    @BeforeEach
    void setUp() {
        fileBuilder = new FileBuilder();
        fileReader = new FileReader();
    }

    ByteArrayInputStream getInputStream() {
        ByteArrayOutputStream outputStream = fileBuilder.toStream();
        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
