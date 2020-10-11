package com.oopawesome.number.integer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.oopawesome.number.integer.SimpleIntNumber.simpleIntNumber;

class SimpleIntNumberTest {

    @Test
    void shouldReturnUnchangedInteger() {
        // given
        int originalInteger = 23;

        // when
        int actualInteger = simpleIntNumber(originalInteger).asInteger();

        // then
        Assertions.assertThat(actualInteger).isEqualTo(originalInteger);
    }
}
