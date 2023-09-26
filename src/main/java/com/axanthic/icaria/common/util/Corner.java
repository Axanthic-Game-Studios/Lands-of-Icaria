package com.axanthic.icaria.common.util;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault

public enum Corner implements StringRepresentable {
    BOTTOM_FRONT_LEFT("bottom_front_left"),
    BOTTOM_FRONT_RIGHT("bottom_front_right"),
    BOTTOM_BACK_LEFT("bottom_back_left"),
    BOTTOM_BACK_RIGHT("bottom_back_right"),
    TOP_FRONT_LEFT("top_front_left"),
    TOP_FRONT_RIGHT("top_front_right"),
    TOP_BACK_LEFT("top_back_left"),
    TOP_BACK_RIGHT("top_back_right");

    public final String name;

    Corner(String pName) {
        this.name = pName;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
