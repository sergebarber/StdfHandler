package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.RecordVur;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordVurTest extends RecordTest {

    @Test
    void testUpdNam() throws IOException {
        String expected = "Test UPD_NAM";
        testOptionalField(fileHandler.getBuilder().addRecord(RecordVur.newInstance().setUpdNam(expected)),
                fileImage -> fileImage.getVur().getUpdNam(), expected);
    }
}
