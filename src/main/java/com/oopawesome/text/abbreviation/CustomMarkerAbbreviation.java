package com.oopawesome.text.abbreviation;

import com.google.common.base.Preconditions;
import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.text.Text;

final class CustomMarkerAbbreviation implements Text {

    private final Text textToAbbreviate;
    private final Text abbreviationMarker;
    private final IntNumber maxWidth;

    CustomMarkerAbbreviation(final Text textToAbbreviate, final Text abbreviationMarker, final IntNumber maxWidth) {
        Preconditions.checkNotNull(textToAbbreviate, "Argument 'textToAbbreviate' cannot be null");
        Preconditions.checkNotNull(abbreviationMarker, "Argument 'abbreviationMarker' cannot be null");
        Preconditions.checkNotNull(maxWidth, "Argument 'maxWidth' cannot be null");
        Preconditions.checkArgument(maxWidth.asInteger() >= abbreviationMarker.asString().length() + 1,
                "Argument 'maxWidth' must be at least abbreviationMarker.length + 1");
        this.textToAbbreviate = textToAbbreviate;
        this.abbreviationMarker = abbreviationMarker;
        this.maxWidth = maxWidth;
    }

    @Override
    public String asString() {
        if (isAbbreviationNeeded()) {
            return getAbbreviationWithPlaceForAbbreviationMarker() + abbreviationMarker.asString();
        }
        return textToAbbreviate.asString();
    }

    private boolean isAbbreviationNeeded() {
        return textToAbbreviate.asString().length() > maxWidth.asInteger();
    }

    private String getAbbreviationWithPlaceForAbbreviationMarker() {
        return textToAbbreviate.asString().substring(0, maxWidth.asInteger() - abbreviationMarker.asString().length());
    }
}
