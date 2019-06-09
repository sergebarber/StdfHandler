package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.FileBuilder;
import org.barber.stdfhandler.file.FileImage;
import org.barber.stdfhandler.file.FileReader;
import org.barber.stdfhandler.file.RecordPlr;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecordPlrTest extends RecordTest {

    private static final String PGM_CHAR = "PGM_CHAR_";
    private static final String RTN_CHAR = "RTN_CHAR_";
    private static final String PGM_CHAL = "PGM_CHAL_";
    private static final String RTN_CHAL = "RTN_CHAL_";

    @Test
    void testRecord() throws IOException {
        List<Integer> grpIndx = Arrays.asList(12345, 12346, 12347, 12348, 12349);
        List<Integer> grpMode = Arrays.asList(12345, 12346, 12347, 12348, 12349);
        List<Integer> grpRadx = Arrays.asList(123, 124, 125, 126, 127);
        List<String> pgmChar = Arrays.asList(PGM_CHAR + 1, PGM_CHAR + 2, PGM_CHAR + 3, PGM_CHAR + 4, PGM_CHAR + 5);
        List<String> rtnChar = Arrays.asList(RTN_CHAR + 1, RTN_CHAR + 2, RTN_CHAR + 3, RTN_CHAR + 4, RTN_CHAR + 5);
        List<String> pgmChal = Arrays.asList(PGM_CHAL + 1, PGM_CHAL + 2, PGM_CHAL + 3, PGM_CHAL + 4, PGM_CHAL + 5);
        List<String> rtnChal = Arrays.asList(RTN_CHAL + 1, RTN_CHAL + 2, RTN_CHAL + 3, RTN_CHAL + 4, RTN_CHAL + 5);

        ByteArrayOutputStream outputStream = new FileBuilder().addRecord(RecordPlr.newInstance().setValues(
                grpIndx, grpMode, grpRadx, pgmChar, rtnChar, pgmChal, rtnChal)).toStream();
        FileImage fileImage = new FileReader().read(new ByteArrayInputStream(outputStream.toByteArray()));

        assertThat(fileImage.getPlrs().get(0).getGrpIndx()).isEqualTo(grpIndx);
        assertThat(fileImage.getPlrs().get(0).getGrpMode()).isEqualTo(grpMode);
        assertThat(fileImage.getPlrs().get(0).getGrpRadx()).isEqualTo(grpRadx);
        assertThat(fileImage.getPlrs().get(0).getPgmChar()).isEqualTo(pgmChar);
        assertThat(fileImage.getPlrs().get(0).getRtnChar()).isEqualTo(rtnChar);
        assertThat(fileImage.getPlrs().get(0).getPgmChal()).isEqualTo(pgmChal);
        assertThat(fileImage.getPlrs().get(0).getRtnChal()).isEqualTo(rtnChal);
    }
}
