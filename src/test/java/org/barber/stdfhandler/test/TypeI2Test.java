package org.barber.stdfhandler.test;

import org.barber.stdfhandler.file.RecordWcr;
import org.barber.stdfhandler.file.TypeI2;
import org.barber.stdfhandler.file.WaferData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TypeI2Test extends TypeTest {

    @Test
    void testNegativeValueThrows() {
        int expected = TypeI2.MIN_VALUE - 1;
        assertThatThrownBy(() -> fileBuilder.addWaferData(WaferData.newInstance().setWcr(
                RecordWcr.newInstance().setCenterY(expected))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeI2.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testTooLargeValueThrows() {
        int expected = TypeI2.MAX_VALUE + 1;
        assertThatThrownBy(() -> fileBuilder.addWaferData(WaferData.newInstance().setWcr(
                RecordWcr.newInstance().setCenterY(expected))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(TypeI2.ILLEGAL_VALUE_MESSAGE, expected));
    }

    @Test
    void testReturnsNullWhenNullValueNotNull() {
        fileBuilder = fileBuilder.addWaferData(WaferData.newInstance().setWcr(RecordWcr.newInstance()));
        assertThatThrownBy(() -> fileHandler.read(getInputStream()).getWaferData().get(0).getWcr()
                .getCenterX().orElseThrow());

    }

    @Test
    void testReturnsNullWhenNullValueSet() {
        int nullValue = TypeI2.MIN_VALUE;
        fileBuilder = fileBuilder.addWaferData(WaferData.newInstance().setWcr(RecordWcr.newInstance()
                .setCenterY(nullValue)));
        assertThatThrownBy(() -> fileHandler.read(getInputStream()).getWaferData().get(0).getWcr()
                .getCenterY().orElseThrow());
    }
}
