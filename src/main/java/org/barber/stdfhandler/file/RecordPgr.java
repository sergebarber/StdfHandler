package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecordPgr extends Record {

    private static final String NAME = "PGR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 62;

    private static final String PMR_INDX = "PMR_INDX_";

    private final Type<Integer> grpIndx = new TypeU2("GRP_INDX", null);
    private final Type<String> grpNam = new TypeCn("GRP_NAM", "");
    private final Type<Integer> indxCnt = new TypeU2("INDX_CNT", null);
    private List<TypeU2> pmrIndx = new ArrayList<>();

    private RecordPgr() {
        super(NAME, TYPE, SUBTYPE);
        setFields();
    }

    public static RecordPgr newInstance() {
        return new RecordPgr();
    }

    @Override
    void fill(ByteArrayInputStream bytes, FileImage fileImage) {
        fields.forEach(field -> field.setValueFromStream(bytes));
        int size = indxCnt.getValue();
        pmrIndx = createList(size);
        pmrIndx.forEach(e -> e.setValueFromStream(bytes));
        setFields();
        addToImage(fileImage);
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addPgr(this);
    }

    public Optional<Integer> getGrpIndx() {
        return Optional.ofNullable(grpIndx.getValue());
    }

    public Optional<String> getGrpNam() {
        return Optional.ofNullable(grpNam.getValue());
    }

    public List<Integer> getPmrIndx() {
        return pmrIndx.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public RecordPgr setGrpIndx(Integer value) {
        grpIndx.setValueFromUser(value);
        return this;
    }

    public RecordPgr setGrpNam(String value) {
        grpNam.setValueFromUser(value);
        return this;
    }

    public RecordPgr setPmrIndx(List<Integer> pmrIndxs) {
        int size = pmrIndxs.size();
        indxCnt.setValueFromUser(size);
        pmrIndx = createList(size);
        for (int i = 0; i < size; i++) {
            pmrIndx.get(i).setValueFromUser(pmrIndxs.get(i));
        }
        setFields();
        return this;
    }

    private List<TypeU2> createList(int size) {
        List<TypeU2> list = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            list.add(new TypeU2(PMR_INDX + i, null));
        }
        return list;
    }

    private void setFields() {
        fields = new ArrayList<>();
        fields.addAll(asList(grpIndx, grpNam, indxCnt));
        fields.addAll(pmrIndx);
    }
}
