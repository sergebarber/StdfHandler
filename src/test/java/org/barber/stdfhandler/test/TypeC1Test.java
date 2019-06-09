package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.RecordHbr;
import org.barber.stdfhandler.file.TypeC1;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeC1Test extends TypeTest {

    @Test
    void testReturnsNullWhenNullValueNotNull() {
        fileBuilder = fileBuilder.addRecord(RecordHbr.newInstance());
        assertThatThrownBy(() -> fileReader.read(getInputStream()).getHbrs().get(0).getHbinPf().orElseThrow());
    }

    @Test
    void testReturnsNullWhenNullValueSet() {
        fileBuilder = fileBuilder.addRecord(RecordHbr.newInstance().setHbinPf(" "));
        assertThatThrownBy(() -> fileReader.read(getInputStream()).getHbrs().get(0).getHbinPf().orElseThrow());
    }

    @Test
    void testTooLongThrows() {
        String value = "A".repeat(TypeC1.MAX_LENGTH + 1);
        assertThatThrownBy(() -> fileBuilder.addRecord(RecordHbr.newInstance().setHbinPf(value)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeC1.ILLEGAL_VALUE_MESSAGE, value.length()));
    }
}
