package com.oopawesome.text;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@Getter(AccessLevel.NONE)
public class CapitalizedText implements Text {

    @NonNull Text textToCapitalize;

    @Override
    public String asString() {
        if (isEmptyText(textToCapitalize)) {
            return textToCapitalize.asString();
        }
        if (isOneCharText(textToCapitalize)) {
            return String.valueOf(getFirstCharCapitalized(textToCapitalize));
        }
        return getFirstCharCapitalized(textToCapitalize) + getTextAfterFirstChar(textToCapitalize);
    }

    private boolean isEmptyText(final Text textToCapitalize) {
        return "".equals(textToCapitalize.asString());
    }

    private boolean isOneCharText(final Text textToCapitalize) {
        return textToCapitalize.asString().length() == 1;
    }

    private char getFirstCharCapitalized(final Text textToCapitalize) {
        final char firstChar = textToCapitalize.asString().charAt(0);
        return Character.toTitleCase(firstChar);
    }

    private String getTextAfterFirstChar(final Text textToCapitalize) {
        return textToCapitalize.asString().substring(1);
    }
}
