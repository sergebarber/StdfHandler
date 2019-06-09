package org.barber.stdfhandler.file;

import java.io.ByteArrayOutputStream;

public class FileBuilder {

  public static final int DEFAULT_CPU_TYP = 2;
  public static final int DEFAULT_STDF_VER = 4;

  private final FileImage image = new FileImage();

  public ByteArrayOutputStream toStream() {
    return image.toStream();
  }

  public FileBuilder() {
    RecordFar far = RecordFar.newInstance();
    far.setCpuTyp(DEFAULT_CPU_TYP);
    far.setStdfVer(DEFAULT_STDF_VER);
    image.setFar(far);
  }

  public FileBuilder addRecord(Record record) {
    record.addToImage(image);
    return this;
  }

  public FileBuilder addWaferData(WaferData waferData) {
    image.addWaferData(waferData);
    return this;
  }
}
