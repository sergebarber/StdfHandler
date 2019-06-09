package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.RecordFar;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordFarTest extends RecordTest {

    @Test
    void testFarCpuTyp() throws IOException {
        testOptionalField(new FileBuilder(), fileImage -> fileImage.getFar().getCpuTyp(), FileBuilder.DEFAULT_CPU_TYP);

        int expected = 7;
        testOptionalField(new FileBuilder().addRecord(RecordFar.newInstance().setCpuTyp(expected)),
                fileImage -> fileImage.getFar().getCpuTyp(), expected);
    }

    @Test
    void testFarStdfVer() throws IOException {
        testOptionalField(new FileBuilder(), fileImage -> fileImage.getFar().getStdfVer(), FileBuilder.DEFAULT_STDF_VER);

        int expected = 3;
        testOptionalField(new FileBuilder().addRecord(RecordFar.newInstance().setStdfVer(expected)),
                fileImage -> fileImage.getFar().getStdfVer(), expected);
    }
}
