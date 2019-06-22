package org.barber.stdfhandler.file;

import java.util.ArrayList;
import java.util.List;

public class WaferData {

    private RecordWir wir;
    private RecordWcr wcr;
    private List<PartData> partData = new ArrayList<>();
    private PartData part;
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
        partData.forEach(part -> records.addAll(part.getRecords()));
        records.add(wrr);
        return records;
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

    public WaferData addPart(PartData part) {
        this.partData.add(part);
        return this;
    }

    public WaferData addPir(RecordPir pir) {
        if (this.part != null) {
            this.partData.add(part);
        }
        this.part = PartData.newInstance().setPir(pir);
        return this;
    }

    public void addPtr(RecordPtr ptr) {
        if (this.part != null) {
            part.addPtr(ptr);
            return;
        }
        this.part = PartData.newInstance().addPtr(ptr);
    }

    public void addPrr(RecordPrr prr) {
        if (this.part == null) {
            this.part = PartData.newInstance();
        }
        this.partData.add(this.part.setPrr(prr));
        this.part = null;
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

    public List<PartData> getPartData() {
        return partData;
    }

}
