package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.RecordPgr;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class RecordPgrTest extends RecordTest {

    @Test
    void testGrpIndx() throws IOException {
        int expected = "GRP_INDX".codePoints().sum();
        testOptionalField(new FileBuilder().addRecord(RecordPgr.newInstance().setGrpIndx(expected)),
                fileImage -> fileImage.getPgrs().get(0).getGrpIndx(), expected);
    }

    @Test
    void testGrpNam() throws IOException {
        String expected = "GRP_NAM";
        testOptionalField(new FileBuilder().addRecord(RecordPgr.newInstance().setGrpNam(expected)),
                fileImage -> fileImage.getPgrs().get(0).getGrpNam(), expected);
    }

    @Test
    void testPmrIndx() throws IOException {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        testListField(new FileBuilder().addRecord(RecordPgr.newInstance().setPmrIndx(expected)),
                fileImage -> fileImage.getPgrs().get(0).getPmrIndx(), expected);
    }
}
