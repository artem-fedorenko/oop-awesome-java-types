package com.oopawesome.number.integer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@Getter(AccessLevel.NONE)
public class SimpleIntNumber implements IntNumber {

    @NonNull Integer intNumber;

    @Override
    public Integer asInteger() {
        return intNumber;
    }
}
