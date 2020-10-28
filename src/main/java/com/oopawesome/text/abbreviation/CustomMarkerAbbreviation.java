package com.oopawesome.text.abbreviation;

import com.google.common.base.Preconditions;
import com.oopawesome.number.integer.IntNumber;
import com.oopawesome.text.Text;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@Getter(AccessLevel.NONE)
public class CustomMarkerAbbreviation implements Text {

    @NonNull Text textToAbbreviate;
    @NonNull Text abbreviationMarker;
    @NonNull IntNumber maxWidth;

    @Override
    public String asString() {
        checkPreconditions();
        if (isAbbreviationNeeded()) {
            return getAbbreviationWithPlaceForAbbreviationMarker() + abbreviationMarker.asString();
        }
        return textToAbbreviate.asString();
    }

    private void checkPreconditions() {
        Preconditions.checkArgument(
                maxWidth.asInteger() >= abbreviationMarker.asString().length() + 1,
                "Argument 'maxWidth' must be at least abbreviationMarker.length + 1"
        );
    }

    private boolean isAbbreviationNeeded() {
        return textToAbbreviate.asString().length() > maxWidth.asInteger();
    }

    private String getAbbreviationWithPlaceForAbbreviationMarker() {
        return textToAbbreviate.asString().substring(0, maxWidth.asInteger() - abbreviationMarker.asString().length());
    }
}
