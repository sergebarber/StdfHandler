package org.barber.stdfhandler.file;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecordSdr extends Record {

    private static final String NAME = "SDR";
    private static final int TYPE = 1;
    private static final int SUBTYPE = 80;

    private static final String SITE_NUM = "SITE_NUM_";

    private final Type<Integer> headNum = new TypeU1("HEAD_NUM", null);
    private final Type<Integer> siteGrp = new TypeU1("SITE_GRP", null);
    private final Type<Integer> siteCnt = new TypeU1("SITE_CNT", null);
    private List<TypeU1> siteNum = new ArrayList<>();
    private final Type<String> handTyp = new TypeCn("HAND_TYP", "");
    private final Type<String> handId = new TypeCn("HAND_ID", "");
    private final Type<String> cardTyp = new TypeCn("CARD_TYP", "");
    private final Type<String> cardId = new TypeCn("CARD_ID", "");
    private final Type<String> loadTyp = new TypeCn("LOAD_TYP", "");
    private final Type<String> loadId = new TypeCn("LOAD_ID", "");
    private final Type<String> dibTyp = new TypeCn("DIB_TYP", "");
    private final Type<String> dibId = new TypeCn("DIB_ID", "");
    private final Type<String> cablTyp = new TypeCn("CABL_TYP", "");
    private final Type<String> cablId = new TypeCn("CABL_ID", "");
    private final Type<String> contTyp = new TypeCn("CONT_TYP", "");
    private final Type<String> contId = new TypeCn("CONT_ID", "");
    private final Type<String> lasrTyp = new TypeCn("LASR_TYP", "");
    private final Type<String> lasrId = new TypeCn("LASR_ID", "");
    private final Type<String> extrTyp = new TypeCn("EXTR_TYP", "");
    private final Type<String> extrId = new TypeCn("EXTR_ID", "");

    private RecordSdr() {
        super(NAME, TYPE, SUBTYPE);
        setFields();
    }

    public static RecordSdr newInstance() {
        return new RecordSdr();
    }

    @Override
    void fill(ByteArrayInputStream bytes, FileImage fileImage) {
        for (Type field : fields) {
            if (field != siteCnt) {
                field.setValueFromStream(bytes);
            }
            else {
                siteCnt.setValueFromStream(bytes);
                createList(siteCnt.getValue());
                siteNum.forEach(f -> f.setValueFromStream(bytes));
            }
        }
        setFields();
        addToImage(fileImage);
    }

    @Override
    protected void addToImage(FileImage image) {
        image.addSdr(this);
    }

    public Optional<Integer> getHeadNum() {
        return Optional.ofNullable(headNum.getValue());
    }

    public Optional<Integer> getSiteGrp() {
        return Optional.ofNullable(siteGrp.getValue());
    }

    public List<Integer> getSiteNum() {
        return siteNum.stream().map(Type::getValue).collect(Collectors.toList());
    }

    public Optional<String> getHandTyp() {
        return Optional.ofNullable(handTyp.getValue());
    }

    public Optional<String> getHandId() {
        return Optional.ofNullable(handId.getValue());
    }

    public Optional<String> getCardTyp() {
        return Optional.ofNullable(cardTyp.getValue());
    }

    public Optional<String> getCardId() {
        return Optional.ofNullable(cardId.getValue());
    }

    public Optional<String> getLoadTyp() {
        return Optional.ofNullable(loadTyp.getValue());
    }

    public Optional<String> getLoadId() {
        return Optional.ofNullable(loadId.getValue());
    }

    public Optional<String> getDibTyp() {
        return Optional.ofNullable(dibTyp.getValue());
    }

    public Optional<String> getDibId() {
        return Optional.ofNullable(dibId.getValue());
    }

    public Optional<String> getCablTyp() {
        return Optional.ofNullable(cablTyp.getValue());
    }

    public Optional<String> getCablId() {
        return Optional.ofNullable(cablId.getValue());
    }

    public Optional<String> getContTyp() {
        return Optional.ofNullable(contTyp.getValue());
    }

    public Optional<String> getContId() {
        return Optional.ofNullable(contId.getValue());
    }

    public Optional<String> getLasrTyp() {
        return Optional.ofNullable(lasrTyp.getValue());
    }

    public Optional<String> getLasrId() {
        return Optional.ofNullable(lasrId.getValue());
    }

    public Optional<String> getExtrTyp() {
        return Optional.ofNullable(extrTyp.getValue());
    }

    public Optional<String> getExtrId() {
        return Optional.ofNullable(extrId.getValue());
    }

    public RecordSdr setHeadNum(int value) {
        headNum.setValueFromUser(value);
        return this;
    }

    public RecordSdr setSiteGrp(int value) {
        siteGrp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setSiteNum(List<Integer> siteNums) {
        int size = siteNums.size();
        siteCnt.setValueFromUser(size);
        siteNum = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            TypeU1 num = new TypeU1(SITE_NUM + i, null);
            num.setValueFromUser(siteNums.get(i - 1));
            siteNum.add(num);
        }
        setFields();
        return this;
    }

    public RecordSdr setHandTyp(String value) {
        handTyp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setHandId(String value) {
        handId.setValueFromUser(value);
        return this;
    }

    public RecordSdr setCardTyp(String value) {
        cardTyp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setCardId(String value) {
        cardId.setValueFromUser(value);
        return this;
    }

    public RecordSdr setLoadTyp(String value) {
        loadTyp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setLoadId(String value) {
        loadId.setValueFromUser(value);
        return this;
    }

    public RecordSdr setDibTyp(String value) {
        dibTyp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setDibId(String value) {
        dibId.setValueFromUser(value);
        return this;
    }

    public RecordSdr setCablTyp(String value) {
        cablTyp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setCablId(String value) {
        cablId.setValueFromUser(value);
        return this;
    }

    public RecordSdr setContTyp(String value) {
        contTyp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setContId(String value) {
        contId.setValueFromUser(value);
        return this;
    }

    public RecordSdr setLasrTyp(String value) {
        lasrTyp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setLasrId(String value) {
        lasrId.setValueFromUser(value);
        return this;
    }

    public RecordSdr setExtrTyp(String value) {
        extrTyp.setValueFromUser(value);
        return this;
    }

    public RecordSdr setExtrId(String value) {
        extrId.setValueFromUser(value);
        return this;
    }

    private void createList(Integer size) {
        siteNum = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            siteNum.add(new TypeU1(SITE_NUM + i, null));
        }
    }

    private void setFields() {
        fields = new ArrayList<>();
        fields.addAll(asList(headNum, siteGrp, siteCnt));
        fields.addAll(siteNum);
        fields.addAll(asList(handTyp, handId, cardTyp, cardId, loadTyp, loadId, dibTyp, dibId, cablTyp, cablId,
                contTyp, contId, lasrTyp, lasrId, extrTyp, extrId));
    }
}
