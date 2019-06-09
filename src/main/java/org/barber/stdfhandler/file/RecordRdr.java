package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecordRdr extends Record {

    private static final String NAME = "RDR";
    private static final byte TYPE = 1;
    private static final byte SUBTYPE = 70;

    private static final String RTST_BIN = "RTST_BIN_";

    private TypeU2 numBins = new TypeU2("NUM_BINS", null);
    private List<TypeU2> rtstBin = new ArrayList<>();

    private RecordRdr() {
        super(NAME, TYPE, SUBTYPE);
        setFields();
    }

    @Override
    void fill(ByteArrayInputStream bytes, FileImage fileImage) {
        numBins.setValueFromStream(bytes);
        int size = numBins.getValue();
        rtstBin = createList(size);
        rtstBin.forEach(e -> e.setValueFromStream(bytes));
        setFields();
        addToImage(fileImage);
    }

    public static RecordRdr newInstance() {
        return new RecordRdr();
    }

    @Override
    protected void addToImage(FileImage image) {
        image.setRdr(this);
    }



    public List<Integer> getRtstBins() {
        return rtstBin.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public RecordRdr setRtstBin(List<Integer> bins) {
        int size = bins.size();
        numBins.setValueFromUser(size);
        rtstBin = createList(size);
        for (int i = 0; i < size; i++) {
            rtstBin.get(i).setValueFromUser(bins.get(i));
        }
        setFields();
        return this;
    }

    private List<TypeU2> createList(int size) {
        List<TypeU2> list = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            list.add(new TypeU2(RTST_BIN + i, null));
        }
        return list;
    }

    private void setFields() {
        fields = new ArrayList<>();
        fields.add(numBins);
        fields.addAll(rtstBin);
    }
}
