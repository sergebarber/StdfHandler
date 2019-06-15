package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.RecordHbr;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class RecordHbrTest extends RecordTest {

  @Test
  void testHeadNum() throws IOException {
    int expected = "HEAD_NUM".substring(0, 1).codePoints().sum();
    testOptionalField(fileHandler.getBuilder().addRecord(RecordHbr.newInstance().setHeadNum(expected)),
        fileImage -> fileImage.getHbrs().get(0).getHeadNum(), expected);
  }

  @Test
  void testSiteNum() throws IOException {
    int expected = "SITE_NUM".substring(0, 1).codePoints().sum();
    testOptionalField(fileHandler.getBuilder().addRecord(RecordHbr.newInstance().setSiteNum(expected)),
        fileImage -> fileImage.getHbrs().get(0).getSiteNum(), expected);
  }

  @Test
  void testHbinNum() throws IOException {
    int expected = "HBIN_NUM".codePoints().sum();
    testOptionalField(fileHandler.getBuilder().addRecord(RecordHbr.newInstance().setHbinNum(expected)),
        fileImage -> fileImage.getHbrs().get(0).getHbinNum(), expected);
  }

  @Test
  void testHbinCnt() throws IOException {
    long expected = "HBIN_CNT".codePoints().sum();
    testOptionalField(fileHandler.getBuilder().addRecord(RecordHbr.newInstance().setHbinCnt(expected)),
        fileImage -> fileImage.getHbrs().get(0).getHbinCnt(), expected);
  }

  @Test
  void testHbinPf() throws IOException {
    String expected = "HBIN_PF".substring(0, 1);
    testOptionalField(fileHandler.getBuilder().addRecord(RecordHbr.newInstance().setHbinPf(expected)),
        fileImage -> fileImage.getHbrs().get(0).getHbinPf(), expected);
  }

  @Test
  void testHbinNam() throws IOException {
    String expected = "HBIN_NAM";
    testOptionalField(fileHandler.getBuilder().addRecord(RecordHbr.newInstance().setHbinNam(expected)),
        fileImage -> fileImage.getHbrs().get(0).getHbinNam(), expected);
  }
}
