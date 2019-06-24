package org.barber.stdfhandler.file;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileImage {

    private RecordFar far;
    private List<RecordAtr> atrs = new ArrayList<>();
    private RecordVur vur;
    private RecordMir mir;
    private RecordRdr rdr;
    private List<RecordSdr> sdrs = new ArrayList<>();
    private List<RecordPcr> pcrs = new ArrayList<>();
    private List<RecordHbr> hbrs = new ArrayList<>();
    private List<RecordSbr> sbrs = new ArrayList<>();
    private List<RecordPmr> pmrs = new ArrayList<>();
    private List<RecordPgr> pgrs = new ArrayList<>();
    private List<RecordPlr> plrs = new ArrayList<>();

    private List<WaferData> waferData = new ArrayList<>();
    private WaferData wafer;

    private List<PartData> partData = new ArrayList<>();
    private PartData part;

    private List<RecordTsr> tsrs = new ArrayList<>();
    private RecordMrr mrr;

    private RecordTst test;


    FileImage() {
        this.far = RecordFar.newInstance();
    }

    void setFar(RecordFar far) {
        this.far = far;
    }

    void addAtr(RecordAtr atr) {
        this.atrs.add(atr);
    }

    void setVur(RecordVur vur) {
        this.vur = vur;
    }

    void setMir(RecordMir mir) {
        this.mir = mir;
    }

    void setRdr(RecordRdr rdr) {
        this.rdr = rdr;
    }

    void addSdr(RecordSdr sdr) {
        this.sdrs.add(sdr);
    }

    void addPcr(RecordPcr pcr) {
        this.pcrs.add(pcr);
    }

    void addHbr(RecordHbr hbr) {
        this.hbrs.add(hbr);
    }

    void addSbr(RecordSbr sbr) {
        this.sbrs.add(sbr);
    }

    void addPmr(RecordPmr pmr) {
        this.pmrs.add(pmr);
    }

    void addPgr(RecordPgr pgr) {
        this.pgrs.add(pgr);
    }

    void addPlr(RecordPlr plr) {
        this.plrs.add(plr);
    }

    void addWafer(WaferData wafer) {
        this.waferData.add(wafer);
    }

    void addWir(RecordWir wir) {
        if (this.wafer != null) {
            throw new StdfFileIntegrityException("Attempt to set WIR record without previous WRR record.");
        }
        wafer = WaferData.newInstance().setWir(wir);
        this.wafer.setWir(wir);
    }

    void addWcr(RecordWcr wcr) {
        if (this.wafer == null) {
            throw new StdfFileIntegrityException("Attempt to set WCR record without corresponding WIR record.");
        }
        this.wafer.setWcr(wcr);
    }

    void addWrr(RecordWrr wrr) {
        if (this.wafer == null) {
            throw new StdfFileIntegrityException("Attempt to set WRR record without corresponding WIR record.");
        }
        this.wafer.setWrr(wrr);
        this.waferData.add(wafer);
        this.wafer = null;
    }

    void addPart(PartData part) {
        this.partData.add(part);
    }

    void addPir(RecordPir pir) {
        if (this.wafer != null) {
            wafer.addPir(pir);
            return;
        }
        if (this.part != null) {
            this.partData.add(part);
        }
        this.part = PartData.newInstance().setPir(pir);
    }

    void addMpr(RecordMpr mpr) {
        if (this.wafer != null) {
            wafer.addMpr(mpr);
            return;
        }
        if (this.part == null) {
            this.part = PartData.newInstance();
        }
        this.part.setMpr(mpr);
    }

    void addPrr(RecordPrr prr) {
        if (this.wafer != null) {
            this.wafer.addPrr(prr);
            return;
        }
        if (this.part == null) {
            this.part = PartData.newInstance();
        }
        this.partData.add(this.part.setPrr(prr));
        this.part = null;
    }

    void addPtr(RecordPtr ptr) {
        if (this.wafer != null) {
            wafer.addPtr(ptr);
            return;
        }
        if (this.part != null) {
            part.addPtr(ptr);
            return;
        }
        this.part = PartData.newInstance().addPtr(ptr);
    }

    void addTsr(RecordTsr tsr) {
        this.tsrs.add(tsr);
    }

    void setMrr(RecordMrr mrr) {
        this.mrr = mrr;
    }

    void setTest(RecordTst test) {this.test = test;}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(far != null ? far : "");
        atrs.forEach(builder::append);
        builder.append(vur != null ? vur : "");
        builder.append(mir != null ? mir : "");
        builder.append(rdr != null ? rdr : "");
        sdrs.forEach(builder::append);
        pcrs.forEach(builder::append);
        hbrs.forEach(builder::append);
        sbrs.forEach(builder::append);
        pmrs.forEach(builder::append);
        pgrs.forEach(builder::append);
        plrs.forEach(builder::append);
        waferData.forEach(wd -> wd.getRecords().forEach(builder::append));

        tsrs.forEach(builder::append);
        builder.append(mrr != null ? mrr : "");
        return builder.toString();
    }

    ByteArrayOutputStream toStream(ByteConverter byteConverter) {
        List<ByteArrayOutputStream> outputStreams = new LinkedList<>();
        outputStreams.add(far.toBytes(byteConverter));
        atrs.forEach(atr -> outputStreams.add(atr.toBytes(byteConverter)));
        if (vur != null) {
            outputStreams.add(vur.toBytes(byteConverter));
        }
        if (mir != null) {
            outputStreams.add(mir.toBytes(byteConverter));
        }
        if (rdr != null) {
            outputStreams.add(rdr.toBytes(byteConverter));
        }
        sdrs.forEach(sdr -> outputStreams.add(sdr.toBytes(byteConverter)));
        pcrs.forEach(atr -> outputStreams.add(atr.toBytes(byteConverter)));
        hbrs.forEach(hbr -> outputStreams.add(hbr.toBytes(byteConverter)));
        sbrs.forEach(sbr -> outputStreams.add(sbr.toBytes(byteConverter)));
        pmrs.forEach(pmr -> outputStreams.add(pmr.toBytes(byteConverter)));
        pgrs.forEach(pgr -> outputStreams.add(pgr.toBytes(byteConverter)));
        plrs.forEach(plr -> outputStreams.add(plr.toBytes(byteConverter)));
        waferData.forEach(wd -> wd.getRecords().forEach(record -> outputStreams.add(record.toBytes(byteConverter))));
        partData.forEach(pd -> pd.getRecords().forEach(record -> outputStreams.add(record.toBytes(byteConverter))));

        tsrs.forEach(tsr -> outputStreams.add(tsr.toBytes(byteConverter)));
        if (mrr != null) {
            outputStreams.add(mrr.toBytes(byteConverter));
        }
        if (test != null) {
            outputStreams.add(test.toBytes(byteConverter));
        }
        int length = outputStreams.stream().mapToInt(ByteArrayOutputStream::size).sum();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(length);
        outputStreams.forEach(stream -> outputStream.writeBytes(stream.toByteArray()));
        return outputStream;
    }

    public RecordFar getFar() {
        return this.far;
    }

    public List<RecordAtr> getAtrs() {
        return atrs;
    }

    public RecordVur getVur() {
        return vur;
    }

    public RecordMir getMir() {
        return mir;
    }

    public RecordRdr getRdr() {
        return rdr;
    }

    public List<RecordSdr> getSdrs() {
        return sdrs;
    }

    public List<RecordPcr> getPcrs() {
        return pcrs;
    }

    public List<RecordHbr> getHbrs() {
        return hbrs;
    }

    public List<RecordSbr> getSbrs() {
        return sbrs;
    }

    public List<RecordPmr> getPmrs() {
        return pmrs;
    }

    public List<RecordPgr> getPgrs() {
        return pgrs;
    }

    public List<RecordPlr> getPlrs() {
        return plrs;
    }

    public List<WaferData> getWaferData() {
        return waferData;
    }

    public List<PartData> getPartData() {
        return this.partData;
    }

    public List<RecordTsr> getTsrs() {
        return tsrs;
    }

    public RecordMrr getMrr() {
        return mrr;
    }

    public RecordTst getTest() {
        return test;
    }
}
