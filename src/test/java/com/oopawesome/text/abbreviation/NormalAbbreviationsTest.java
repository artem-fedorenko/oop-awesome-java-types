package com.oopawesome.text.abbreviation;

import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.text.Text;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.oopawesome.number.integer.SimpleIntNumber.simpleIntNumber;
import static com.oopawesome.text.PlainText.plainText;
import static com.oopawesome.text.abbreviation.Abbreviations.abbreviation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class NormalAbbreviationsTest {

    @ParameterizedTest
    @MethodSource("getShouldThrowExceptionOnInvalidParametersTestCases")
    void shouldThrowExceptionOnInvalidParameters(Text textToAbbreviate, IntNumber maxWidth) {
        // when
        final Throwable actualException = catchThrowable(() -> abbreviation(textToAbbreviate, maxWidth));

        // then
        assertThat(actualException).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("getShouldAbbreviateTextTestCases")
    void shouldAbbreviateText(Text textToAbbreviate, IntNumber maxWidth, Text expectedResult) {
        // when
        final Text actualResult = abbreviation(textToAbbreviate, maxWidth);

        // then
        assertThat(actualResult.asString()).isEqualTo(expectedResult.asString());
    }

    private static Stream<Arguments> getShouldThrowExceptionOnInvalidParametersTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(null, simpleIntNumber(4)),
                Arguments.of(plainText("some text"), null),
                Arguments.of(plainText("some text"), simpleIntNumber(3))
        );
        //@formatter:on
    }

    private static Stream<Arguments> getShouldAbbreviateTextTestCases() {
        //@formatter:off
        return Stream.of(
                Arguments.of(plainText(""), simpleIntNumber(4), plainText("")),
                Arguments.of(plainText("abcdefg"), simpleIntNumber(6), plainText("abc...")),
                Arguments.of(plainText("abcdefg"), simpleIntNumber(7), plainText("abcdefg")),
                Arguments.of(plainText("abcdefg"), simpleIntNumber(8), plainText("abcdefg")),
                Arguments.of(plainText("abcdefg"), simpleIntNumber(4), plainText("a..."))
        );
        //@formatter:on
    }
}
