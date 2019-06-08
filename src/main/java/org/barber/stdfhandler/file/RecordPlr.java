package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecordPlr extends Record {

    private static final String NAME = "PLR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 63;

    private static final String GRP_INDX = "GRP_INDX_";
    private static final String GRP_MODE = "GRP_MODE_";
    private static final String GRP_RADX = "GRP_RADX_";
    private static final String PGM_CHAR = "PGM_CHAR_";
    private static final String RTN_CHAR = "RTN_CHAR_";
    private static final String PGM_CHAL = "PGM_CHAL_";
    private static final String RTN_CHAL = "RTN_CHAL_";

    private final Type<Integer> grpCnt = new TypeU2("GRP_CNT", null);
    private List<TypeU2> grpIndx = new ArrayList<>();
    private List<TypeU2> grpMode = new ArrayList<>();
    private List<TypeU1> grpRadx = new ArrayList<>();
    private List<TypeCn> pgmChar = new ArrayList<>();
    private List<TypeCn> rtnChar = new ArrayList<>();
    private List<TypeCn> pgmChal = new ArrayList<>();
    private List<TypeCn> rtnChal = new ArrayList<>();

    RecordPlr() {
        super(NAME, TYPE, SUBTYPE);
        fields.add(grpCnt);
    }

    public static RecordPlr newInstance() {
        return new RecordPlr();
    }

    @Override
    void fill(ByteArrayInputStream bytes, FileImage fileImage) {
        grpCnt.setValueFromStream(bytes);
        createLists();
        grpIndx.forEach(field -> field.setValueFromStream(bytes));
        grpMode.forEach(field -> field.setValueFromStream(bytes));
        grpRadx.forEach(field -> field.setValueFromStream(bytes));
        pgmChar.forEach(field -> field.setValueFromStream(bytes));
        rtnChar.forEach(field -> field.setValueFromStream(bytes));
        pgmChal.forEach(field -> field.setValueFromStream(bytes));
        rtnChal.forEach(field -> field.setValueFromStream(bytes));
        setFields();
        addToImage(fileImage);
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addPlr(this);
    }

    public List<Integer> getGrpIndx() {
        return grpIndx.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public List<Integer> getGrpMode() {
        return grpMode.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public List<Integer> getGrpRadx() {
        return grpRadx.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public List<String> getPgmChar() {
        return pgmChar.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public List<String> getRtnChar() {
        return rtnChar.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public List<String> getPgmChal() {
        return pgmChal.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public List<String> getRtnChal() {
        return rtnChal.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public RecordPlr setValues(List<Integer> grpIndxs, List<Integer> grpModes, List<Integer> grpRadxs,
                          List<String> pgmChars, List<String> rtnChars, List<String> pgmChals, List<String> rtnChals) {
        int size = grpIndxs.size();
        if (grpModes.size() != size || grpRadxs.size() != size || pgmChars.size() != size || rtnChars.size() != size
                || pgmChals.size() != size || rtnChals.size() != size) {
            throw new IllegalArgumentException(
                    "Error while setting values to PLR record: all value lists should be the of the same size");
        }
        grpCnt.setValue(size);
        createLists();
        for (int i = 0; i < size; i++) {
            grpIndx.get(i).setValueFromUser(grpIndxs.get(i));
            grpMode.get(i).setValueFromUser(grpModes.get(i));
            grpRadx.get(i).setValueFromUser(grpRadxs.get(i));
            pgmChar.get(i).setValueFromUser(pgmChars.get(i));
            rtnChar.get(i).setValueFromUser(rtnChars.get(i));
            pgmChal.get(i).setValueFromUser(pgmChals.get(i));
            rtnChal.get(i).setValueFromUser(rtnChals.get(i));
        }
        setFields();
        return this;
    }

    private void createLists() {
        int size = grpCnt.getValue();
        grpIndx = new ArrayList<>(size);
        grpMode = new ArrayList<>(size);
        grpRadx = new ArrayList<>(size);
        pgmChar = new ArrayList<>(size);
        rtnChar = new ArrayList<>(size);
        pgmChal = new ArrayList<>(size);
        rtnChal = new ArrayList<>(size);
        for (int i = 1; i < size + 1; i++) {
            grpIndx.add(new TypeU2(GRP_INDX + i, null));
            grpMode.add(new TypeU2(GRP_MODE + i, 0));
            grpRadx.add(new TypeU1(GRP_RADX + i, 0));
            pgmChar.add(new TypeCn(PGM_CHAR + i, ""));
            rtnChar.add(new TypeCn(RTN_CHAR + i, ""));
            pgmChal.add(new TypeCn(PGM_CHAL + i, ""));
            rtnChal.add(new TypeCn(RTN_CHAL + i, ""));
        }
    }

    private void setFields() {
        fields = new ArrayList<>();
        fields.add(grpCnt);
        fields.addAll(grpIndx);
        fields.addAll(grpMode);
        fields.addAll(grpRadx);
        fields.addAll(pgmChar);
        fields.addAll(rtnChar);
        fields.addAll(pgmChal);
        fields.addAll(rtnChal);
    }
}
