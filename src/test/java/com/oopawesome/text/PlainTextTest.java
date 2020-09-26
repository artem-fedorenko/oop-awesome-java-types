package com.oopawesome.text;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.oopawesome.text.PlainText.plainText;

class PlainTextTest {

    @Test
    void shouldThrowExceptionIfNullString() {
        // when
        final Throwable throwable = Assertions.catchThrowable(() -> plainText(null));

        // then
        Assertions.assertThat(throwable).isNotNull().hasMessageContaining("cannot be null");
    }

    @Test
    void shouldReturnUnchangedString() {
        // given
        String originalString = "some string";

        // when
        String actualString = plainText(originalString).asString();

        // then
        Assertions.assertThat(actualString).isEqualTo(originalString);
    }
}
