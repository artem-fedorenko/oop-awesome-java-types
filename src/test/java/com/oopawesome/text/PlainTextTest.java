package com.oopawesome.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlainTextTest {

    @Test
    void shouldThrowExceptionIfNullString() {
        // when
        final Throwable throwable = Assertions.catchThrowable(() -> new PlainText(null));

        // then
        Assertions.assertThat(throwable).isNotNull();
    }

    @Test
    void shouldReturnUnchangedString() {
        // given
        String originalString = "some string";

        // when
        String actualString = new PlainText(originalString).asString();

        // then
        Assertions.assertThat(actualString).isEqualTo(originalString);
    }
}
