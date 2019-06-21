package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.RecordRdr;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class RecordRdrTest extends RecordTest {

    @Test
    void testRtstBin() throws IOException {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        testListField(fileHandler.getBuilder().addRecord(RecordRdr.newInstance().setRtstBin(expected)),
                fileImage -> fileImage.getRdr().getRtstBins(), expected);
    }
}
