package org.barber.stdfhandler.records;

import java.io.IOException;
import java.time.Instant;

import org.barber.stdfhandler.file.RecordMrr;
import org.junit.jupiter.api.Test;

public class RecordMrrTest extends RecordTest {

  @Test
  void testFinishT() throws IOException {
    Instant expected = Instant.ofEpochSecond(1234567890);
    testOptionalField(fileHandler.getBuilder().addRecord(RecordMrr.newInstance().setFinishT(expected)),
        fileImage -> fileImage.getMrr().getFinishT(), expected);
  }

  @Test
  void testDispCod() throws IOException {
    testOptionalField(fileHandler.getBuilder().addRecord(RecordMrr.newInstance().setDispCod(CHAR_EXPECTED)),
        fileImage -> fileImage.getMrr().getDispCod(), CHAR_EXPECTED);
  }

  @Test
  void testUsrDesc() throws IOException {
    String expected = "USR_DESC";
    testOptionalField(fileHandler.getBuilder().addRecord(RecordMrr.newInstance().setUsrDesc(expected)),
        fileImage -> fileImage.getMrr().getUsrDesc(), expected);
  }

  @Test
  void testExcDesc() throws IOException {
    String expected = "EXC_DESC";
    testOptionalField(fileHandler.getBuilder().addRecord(RecordMrr.newInstance().setExcDesc(expected)),
        fileImage -> fileImage.getMrr().getExcDesc(), expected);
  }
}
