package org.barber.stdfhandler.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordVurTest extends RecordTest {

    @Test
    void testUpdNam() throws IOException {
        String expected = "Test UPD_NAM";
        testField(new FileBuilder().addRecord(RecordVur.newInstance().setUpdNam(expected)),
                fileImage -> fileImage.getVur().getUpdNam(), expected);
    }
}
