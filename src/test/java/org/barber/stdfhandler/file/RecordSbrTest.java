package org.barber.stdfhandler.file;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class RecordSbrTest extends RecordTest {


  @Test
  void testHeadNum() throws IOException {
    int expected = "HEAD_NUM".substring(0, 1).codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordSbr.newInstance().setHeadNum(expected)),
        fileImage -> fileImage.getSbrs().get(0).getHeadNum(), expected);
  }

  @Test
  void testSiteNum() throws IOException {
    int expected = "SITE_NUM".substring(0, 1).codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordSbr.newInstance().setSiteNum(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSiteNum(), expected);
  }

  @Test
  void testSbinNum() throws IOException {
    int expected = "SBIN_NUM".codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordSbr.newInstance().setSbinNum(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSbinNum(), expected);
  }

  @Test
  void testSbinCnt() throws IOException {
    long expected = "SBIN_NUM".codePoints().sum();
    testOptionalField(new FileBuilder().addRecord(RecordSbr.newInstance().setSbinCnt(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSbinCnt(), expected);
  }

  @Test
  void testSbinPf() throws IOException {
    String expected = "SBIN_PF".substring(0, 1);
    testOptionalField(new FileBuilder().addRecord(RecordSbr.newInstance().setSbinPf(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSbinPf(), expected);
  }

  @Test
  void testSbinNam() throws IOException {
    String expected = "SBIN_NAM".substring(0, 1);
    testOptionalField(new FileBuilder().addRecord(RecordSbr.newInstance().setSbinNam(expected)),
        fileImage -> fileImage.getSbrs().get(0).getSbinNam(), expected);
  }
}
