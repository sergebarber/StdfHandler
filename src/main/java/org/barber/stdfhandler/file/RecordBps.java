package org.barber.stdfhandler.file;

import java.util.Optional;

public class RecordBps extends Record {

  private static final String NAME = "BPS";
  private static final int TYPE = 20;
  private static final int SUBTYPE = 10;

  private final Type<String> seqName = new TypeCn("SEQ_NAME", TypeCn.DEFAULT_VALUE);

  private RecordBps() {
    super(NAME, TYPE, SUBTYPE);
    addFields(seqName);
  }

  public static RecordBps newInstance() {
    return new RecordBps();
  }

  public Optional<String> getSeqName() {
    return Optional.ofNullable(seqName.getValue());
  }

  public RecordBps setSeqName(String seqName) {
    this.seqName.setValueFromUser(seqName);
    return this;
  }
}
