package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.FileHandler;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

abstract class TypeTest {

    FileBuilder fileBuilder;
    FileHandler fileHandler;

    @BeforeEach
    void setUp() {
        fileHandler = FileHandler.newInstance();
        fileBuilder = fileHandler.getBuilder();
    }

    ByteArrayInputStream getInputStream() {
        ByteArrayOutputStream outputStream = fileBuilder.toStream();
        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
