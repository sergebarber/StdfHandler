package org.barber.stdfhandler.file;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaferData {

    private RecordWir wir;
    private RecordWcr wcr;
    private RecordWrr wrr;

    private WaferData() {}

    public static WaferData newInstance() {
        WaferData waferData = new WaferData();
        waferData.setWir(RecordWir.newInstance());
        waferData.setWrr(RecordWrr.newInstance());
        return waferData;
    }

    List<Record> getRecords() {
        List<Record> records = new ArrayList<>();
        records.add(wir);
        if (wcr != null) {
            records.add(wcr);
        }
        records.add(wrr);
        return records;
    }

    public RecordWir getWir() {
        return wir;
    }

    public RecordWrr getWrr() {
        return wrr;
    }

    public RecordWcr getWcr() {
        return wcr;
    }

    public WaferData setWir(RecordWir wir) {
        this.wir = wir;
        return this;
    }

    public WaferData setWcr(RecordWcr wcr) {
        this.wcr = wcr;
        return this;
    }

    public WaferData setWrr(RecordWrr wrr) {
        this.wrr = wrr;
        return this;
    }
}
