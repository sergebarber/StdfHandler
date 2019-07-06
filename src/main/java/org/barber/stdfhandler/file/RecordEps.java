package org.barber.stdfhandler.file;

public class RecordEps extends Record {

  private static final String NAME = "EPS";
  private static final int TYPE = 20;
  private static final int SUBTYPE = 20;

  private RecordEps() {
    super(NAME, TYPE, SUBTYPE);
  }

  public static RecordEps newInstance() {
    return new RecordEps();
  }
}
