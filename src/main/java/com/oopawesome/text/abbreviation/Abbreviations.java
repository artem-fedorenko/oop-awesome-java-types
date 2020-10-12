package com.oopawesome.text.abbreviation;

import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.text.Text;

public final class Abbreviations {

    public static Text abbreviation(final Text textToAbbreviate, final IntNumber maxWidth) {
        return new NormalAbbreviation(textToAbbreviate, maxWidth);
    }

    public static Text abbreviation(final Text textToAbbreviate, final Text abbreviationMarker, final IntNumber maxWidth) {
        return new CustomMarkerAbbreviation(textToAbbreviate, abbreviationMarker, maxWidth);
    }
}
