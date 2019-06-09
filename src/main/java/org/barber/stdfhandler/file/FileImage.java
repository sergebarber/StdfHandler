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

    private RecordMrr mrr;


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

    void addWaferData(WaferData waferData) {
        this.waferData.add(waferData);
    }

    void setWir(RecordWir wir) {
        this.wafer = wafer == null ? WaferData.newInstance() : wafer;
        this.wafer.setWir(wir);
    }

    void setWrr(RecordWrr wrr) {
        if (this.wafer == null) {
            throw new StdfFileIntegrityException("Attempt to set WRR record without corresponding WIR record.");
        }
        this.wafer.setWrr(wrr);
        this.waferData.add(wafer);
        this.wafer = null;
    }

    void setMrr(RecordMrr mrr) {
        this.mrr = mrr;
    }

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

        builder.append(mrr != null ? mrr : "");
        return builder.toString();
    }

    ByteArrayOutputStream toStream() {
        List<ByteArrayOutputStream> outputStreams = new LinkedList<>();
        outputStreams.add(far.toBytes());
        atrs.forEach(atr -> outputStreams.add(atr.toBytes()));
        if (vur != null) {
            outputStreams.add(vur.toBytes());
        }
        if (mir != null) {
            outputStreams.add(mir.toBytes());
        }
        if (rdr != null) {
            outputStreams.add(rdr.toBytes());
        }
        sdrs.forEach(sdr -> outputStreams.add(sdr.toBytes()));
        pcrs.forEach(atr -> outputStreams.add(atr.toBytes()));
        hbrs.forEach(hbr -> outputStreams.add(hbr.toBytes()));
        sbrs.forEach(sbr -> outputStreams.add(sbr.toBytes()));
        pmrs.forEach(pmr -> outputStreams.add(pmr.toBytes()));
        pgrs.forEach(pgr -> outputStreams.add(pgr.toBytes()));
        plrs.forEach(plr -> outputStreams.add(plr.toBytes()));
        waferData.forEach(wd -> wd.getRecords().forEach(record -> outputStreams.add(record.toBytes())));

        if (mrr != null) {
            outputStreams.add(mrr.toBytes());
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

    public RecordMrr getMrr() {
        return mrr;
    }
}
