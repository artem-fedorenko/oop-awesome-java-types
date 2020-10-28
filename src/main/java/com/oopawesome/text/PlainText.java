package com.oopawesome.text;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@Getter(AccessLevel.NONE)
public class PlainText implements Text {

    @NonNull String text;

    @Override
    public String asString() {
        return text;
    }
}
