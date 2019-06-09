package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.FileReader;
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
