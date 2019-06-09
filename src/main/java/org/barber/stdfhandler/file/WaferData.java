package org.barber.stdfhandler.file;

import java.util.Arrays;
import java.util.List;

public class WaferData {

    private RecordWir wir;

    private RecordWrr wrr;

    private WaferData() {}

    public static WaferData newInstance() {
        WaferData waferData = new WaferData();
        waferData.setWir(RecordWir.newInstance());
        waferData.setWrr(RecordWrr.newInstance());
        return waferData;
    }

    List<Record> getRecords() {
        return Arrays.asList(wir, wrr);
    }

    public RecordWir getWir() {
        return wir;
    }

    public RecordWrr getWrr() {
        return wrr;
    }

    public WaferData setWir(RecordWir wir) {
        this.wir = wir;
        return this;
    }

    public WaferData setWrr(RecordWrr wrr) {
        this.wrr = wrr;
        return this;
    }
}
