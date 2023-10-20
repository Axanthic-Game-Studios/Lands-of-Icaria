package com.axanthic.icaria.common.util;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault

public enum Side implements StringRepresentable {
    LEFT("left"),
    RIGHT("right");

    public final String name;

    Side(String pName) {
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
