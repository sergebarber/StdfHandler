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
//    private RecordRdr rdr;

//    private List<StdfRecordPcr> pcrs = new ArrayList<>();
//    private List<StdfRecordHbr> hbrs = new ArrayList<>();
//    private List<StdfRecordSbr> sbrs = new ArrayList<>();

//    private StdfRecordMrr mrr;

    FileImage() {
        this.far = new RecordFar();
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

//    void setRdr(RecordRdr rdr) {
//        this.rdr = rdr;
//    }

    //    public void addPcr(StdfRecordPcr pcr) {
//        this.pcrs.add(pcr);
//    }

//    public void addHbr(StdfRecordHbr hbr) { this.hbrs.add(hbr); }

//    public void addSbr(StdfRecordSbr sbr) { this.sbrs.add(sbr); }



//    public void setMrr(StdfRecordMrr mrr) {
//        this.mrr = mrr;
//    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(far != null ? far : "");
        atrs.forEach(builder::append);
        builder.append(vur != null ? vur : "");
        builder.append(mir != null ? mir : "");
//        builder.append(rdr != null ? rdr : "");
//        pcrs.forEach(builder::append);
//        hbrs.forEach(builder::append);
//        sbrs.forEach(builder::append);
//
//        builder.append(mrr != null ? mrr : "");

        return builder.toString();
    }

    ByteArrayOutputStream toStream() {
        List<ByteArrayOutputStream> outputStreams = new LinkedList<>();
        outputStreams.add(far.toBytes());
        atrs.forEach(atr -> outputStreams.add(atr.toBytes()));
        if (vur != null) outputStreams.add(vur.toBytes());
        if (mir != null) outputStreams.add(mir.toBytes());
//        if (rdr != null) bytes.addAll(rdr.getBytes());

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

//    RecordRdr getRdr() {
//        return rdr;
//    }
}
