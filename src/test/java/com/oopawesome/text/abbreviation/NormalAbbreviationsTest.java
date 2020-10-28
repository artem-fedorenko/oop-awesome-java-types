package com.oopawesome.text.abbreviation;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.number.integer.SimpleIntNumber;
import com.oopawesome.text.PlainText;
import com.oopawesome.text.Text;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class NormalAbbreviationsTest {

    @ParameterizedTest
    @MethodSource("getShouldThrowExceptionOnInvalidParametersTestCases")
    void shouldThrowExceptionOnInvalidParameters(Text textToAbbreviate, IntNumber maxWidth) {
        // when
        final Throwable actualException = catchThrowable(() -> new NormalAbbreviation(textToAbbreviate, maxWidth).asString());

        // then
        assertThat(actualException).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("getShouldAbbreviateTextTestCases")
    void shouldAbbreviateText(Text textToAbbreviate, IntNumber maxWidth, Text expectedResult) {
        // when
        final Text actualResult = new NormalAbbreviation(textToAbbreviate, maxWidth);

        // then
        assertThat(actualResult.asString()).isEqualTo(expectedResult.asString());
    }

    private static Stream<Arguments> getShouldThrowExceptionOnInvalidParametersTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(null, new SimpleIntNumber(4)),
                Arguments.of(new PlainText("some text"), null),
                Arguments.of(new PlainText("some text"), new SimpleIntNumber(3))
        );
        //@formatter:on
    }

    private static Stream<Arguments> getShouldAbbreviateTextTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(new PlainText(""), new SimpleIntNumber(4), new PlainText("")),
                Arguments.of(new PlainText("abcdefg"), new SimpleIntNumber(6), new PlainText("abc...")),
                Arguments.of(new PlainText("abcdefg"), new SimpleIntNumber(7), new PlainText("abcdefg")),
                Arguments.of(new PlainText("abcdefg"), new SimpleIntNumber(8), new PlainText("abcdefg")),
                Arguments.of(new PlainText("abcdefg"), new SimpleIntNumber(4), new PlainText("a..."))
        );
        //@formatter:on
    }
}
