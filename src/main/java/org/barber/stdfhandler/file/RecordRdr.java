package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RecordRdr extends Record {

    private static final String NAME = "RDR";
    private static final byte TYPE = 1;
    private static final byte CODE = 70;

    private static final String RTST_BIN = "RTST_BIN_";

    private TypeU2 numBins = new TypeU2("NUM_BINS");
    private TypeU2[] rtstBin = new TypeU2[0];

    RecordRdr() {
        super(NAME, TYPE, CODE);
    }

    public static RecordRdr newInstance() {
        return new RecordRdr();
    }

    @Override
    void fill(ByteArrayInputStream bytes, FileImage fileImage) {
        numBins.setValue(bytes);
        int binLength = numBins.getValue();
        rtstBin = new TypeU2[binLength];
        for (int i = 0; i < binLength; i++) {
            rtstBin[i] = new TypeU2(RTST_BIN + i);
            rtstBin[i].setValue(bytes);
        }
        addToImage(fileImage);
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setRdr(this);
    }

    @Override
    ByteArrayOutputStream toBytes() {
        ByteArrayOutputStream fieldsBytes = new ByteArrayOutputStream();
        fieldsBytes.writeBytes(numBins.toBytes());
        for (TypeU2 bin : rtstBin) {
            fieldsBytes.writeBytes(bin.toBytes());
        }
        return addHeader(fieldsBytes);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(fieldAsString(numBins.getName(), numBins.toString()));
        for (int i = 0; i < rtstBin.length; i++) {
            builder.append(fieldAsString(rtstBin[i].getName(), rtstBin[i].toString()));
        }
        return builder.toString();
    }

    public List<Integer> getRtstBins() {
        return Stream.of(rtstBin).map(TypeU2::getValue).collect(Collectors.toList());
    }

    public RecordRdr setRtstBin(List<Integer> bins) {
        numBins.setValue(bins.size());
        rtstBin = new TypeU2[bins.size()];
        for (int i = 0; i < rtstBin.length; i++) {
            rtstBin[i] = new TypeU2(RTST_BIN + + i);
            rtstBin[i].setValue(bins.get(i));
        }
        return this;
    }
}
