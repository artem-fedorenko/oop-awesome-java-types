package com.oopawesome.number.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.oopawesome.number.medium.SimpleMediumNumber.simpleMediumNumber;

class SimpleMediumNumberTest {

    @Test
    void shouldReturnUnchangedInteger() {
        // given
        int originalInteger = 23;

        // when
        int actualInteger = simpleMediumNumber(originalInteger).asInteger();

        // then
        Assertions.assertThat(actualInteger).isEqualTo(originalInteger);
    }
}
