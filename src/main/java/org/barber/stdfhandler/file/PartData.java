package org.barber.stdfhandler.file;

import java.util.ArrayList;
import java.util.List;

public class PartData {

    private RecordPir pir;

    private RecordPrr prr;

    private PartData(){}

    public static PartData newInstance() {
        return new PartData();
    }

    List<Record> getRecords() {
        List<Record> records = new ArrayList<>();
        if (pir != null) {
            records.add(pir);
        }
        if (prr != null) {
            records.add(prr);
        }
        return records;
    }

    public RecordPir getPir() {
        return pir;
    }

    public RecordPrr getPrr() {
        return prr;
    }

    public PartData setPir() {
        this.pir = RecordPir.newInstance();
        return this;
    }

    public PartData setPir(RecordPir pir) {
        this.pir = pir;
        return this;
    }

    public PartData setPrr() {
        this.prr = RecordPrr.newInstance();
        return this;
    }

    public PartData setPrr(RecordPrr prr) {
        this.prr = prr;
        return this;
    }
}
