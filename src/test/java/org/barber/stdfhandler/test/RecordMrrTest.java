package org.barber.stdfhandler.test;

import java.io.IOException;
import java.time.Instant;

import org.barber.stdfhandler.file.FileBuilder;
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
    String expected = "D";
    testOptionalField(fileHandler.getBuilder().addRecord(RecordMrr.newInstance().setDispCod(expected)),
        fileImage -> fileImage.getMrr().getDispCod(), expected);
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
