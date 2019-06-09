package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.RecordRdr;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class RecordRdrTest extends RecordTest {

    @Test
    void testRtstBin() throws IOException {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        testListField(new FileBuilder().addRecord(RecordRdr.newInstance().setRtstBin(expected)),
                fileImage -> fileImage.getRdr().getRtstBins(), expected);
    }
}
