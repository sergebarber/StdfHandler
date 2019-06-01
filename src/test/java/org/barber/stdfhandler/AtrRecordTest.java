package org.barber.stdfhandler;

import org.barber.stdfhandler.file.FileBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.Instant;

class AtrRecordTest extends RecordTest {

    @Test
    void testAtrModTim() throws IOException {
        Instant value = Instant.ofEpochSecond(1234567890);
        testField(new FileBuilder().addAtr(value), fileImage -> fileImage.getAtrs().get(0).getModTim(), value);
    }

    @Test
    void testAtrCmdLine() throws IOException {
        String value = "Test CMD_LINE $%$^&&";
        testField(new FileBuilder().addAtr(value), fileImage -> fileImage.getAtrs().get(0).getCmdLine(), value);
    }
}
