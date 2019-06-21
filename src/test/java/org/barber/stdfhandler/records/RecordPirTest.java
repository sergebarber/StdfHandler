package org.barber.stdfhandler.records;

import java.io.IOException;
import org.barber.stdfhandler.file.PartData;
import org.barber.stdfhandler.file.RecordPir;
import org.junit.jupiter.api.Test;

class RecordPirTest extends RecordTest {

  @Test
  void testHeadNum() throws IOException {
    int expected = 123;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPir(RecordPir.newInstance().setHeadNum(expected)).setPrr()),
        fileImage -> fileImage.getPartData().get(0).getPir().getHeadNum(),
        expected);
  }

  @Test
  void testSiteNum() throws IOException {
    int expected = 123;
    testOptionalField(fileHandler.getBuilder().addPart(
        PartData.newInstance().setPir(RecordPir.newInstance().setSiteNum(expected)).setPrr()),
        fileImage -> fileImage.getPartData().get(0).getPir().getSiteNum(),
        expected);
  }
}
