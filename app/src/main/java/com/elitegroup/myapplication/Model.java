package com.elitegroup.myapplication;

import androidx.annotation.Nullable;

public class Model {
    @Nullable
    String firstReactive,secondReactive;

    public Model(@Nullable String firstReactive, @Nullable String secondReactive) {
        this.firstReactive = firstReactive;
        this.secondReactive = secondReactive;
    }

    @Nullable
    public String getFirstReactive() {
        return firstReactive;
    }

    public void setFirstReactive(@Nullable String firstReactive) {
        this.firstReactive = firstReactive;
    }

    @Nullable
    public String getSecondReactive() {
        return secondReactive;
    }

    public void setSecondReactive(@Nullable String secondReactive) {
        this.secondReactive = secondReactive;
    }
}
