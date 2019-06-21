package org.barber.stdfhandler.records;

import org.barber.stdfhandler.file.RecordSbr;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordSbrTest extends RecordTest {


  @Test
  void testHeadNum() throws IOException {
    int expected = "HEAD_NUM".substring(0, 1).codePoints().sum();
    testOptionalField(fileHandler.getBuilder().addRecord(RecordSbr.newInstance().setHeadNum(expected)),
        fileImage -> fileImage.getSbrs().get(0).getHeadNum(), expected);
  }

  @Test
  void testSiteNum() throws IOException {
    int expected = "SITE_NUM".substring(0, 1).codePoints().sum();
    testOptionalField(fileHandler.getBuilder().addRecord(RecordSbr.newInstance().setSiteNum(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSiteNum(), expected);
  }

  @Test
  void testSbinNum() throws IOException {
    int expected = "SBIN_NUM".codePoints().sum();
    testOptionalField(fileHandler.getBuilder().addRecord(RecordSbr.newInstance().setSbinNum(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSbinNum(), expected);
  }

  @Test
  void testSbinCnt() throws IOException {
    long expected = "SBIN_NUM".codePoints().sum();
    testOptionalField(fileHandler.getBuilder().addRecord(RecordSbr.newInstance().setSbinCnt(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSbinCnt(), expected);
  }

  @Test
  void testSbinPf() throws IOException {
    testOptionalField(fileHandler.getBuilder().addRecord(RecordSbr.newInstance().setSbinPf(CHAR_EXPECTED)),
        fileImage -> fileImage.getSbrs().get(0).getSbinPf(), CHAR_EXPECTED);
  }

  @Test
  void testSbinNam() throws IOException {
    String expected = "SBIN_NAM";
    testOptionalField(fileHandler.getBuilder().addRecord(RecordSbr.newInstance().setSbinNam(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSbinNam(), expected);
  }
}
