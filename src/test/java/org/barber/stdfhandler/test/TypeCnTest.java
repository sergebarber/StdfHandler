package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.RecordAtr;
import org.barber.stdfhandler.file.RecordHbr;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeCnTest extends TypeTest {

    @Test
    void testDefaultNullValue() throws IOException {
        String expected = "";
        fileBuilder = fileBuilder.addRecord(RecordAtr.newInstance());
        assertThat(fileHandler.read(getInputStream()).getAtrs().get(0).getCmdLine().orElseThrow()).isEqualTo(expected);
    }

    @Test
    void testDefaultNullValueSet() throws IOException {
        String expected = "";
        fileBuilder = fileBuilder.addRecord(RecordAtr.newInstance().setCmdLine(expected));
        assertThat(fileHandler.read(getInputStream()).getAtrs().get(0).getCmdLine().orElseThrow()).isEqualTo(expected);
    }

    @Test
    void testTooLongValueShortened() throws IOException {
        String value = "A".repeat(256);
        fileBuilder = fileBuilder.addRecord(RecordAtr.newInstance().setCmdLine(value));
        assertThat(fileHandler.read(getInputStream()).getAtrs().get(0).getCmdLine().orElseThrow())
                .isEqualTo("A".repeat(255));
    }

    @Test
    void testReturnsNullWhenNullValueNotNull() {
        fileBuilder = fileBuilder.addRecord(RecordHbr.newInstance());
        assertThatThrownBy(() -> fileHandler.read(getInputStream()).getHbrs().get(0).getHbinNam().orElseThrow());
    }

    @Test
    void testReturnsNullWhenNullValueSet() {
        fileBuilder = fileBuilder.addRecord(RecordHbr.newInstance().setHbinPf(""));
        assertThatThrownBy(() -> fileHandler.read(getInputStream()).getHbrs().get(0).getHbinNam().orElseThrow());
    }
}
