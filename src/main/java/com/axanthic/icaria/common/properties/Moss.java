package com.axanthic.icaria.common.properties;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault

public enum Moss implements StringRepresentable {
    NONE("none"),
    FOREST("forest"),
    SCRUBLAND("scrubland"),
    STEPPE("steppe");

    public final String name;

    Moss(String pName) {
        this.name = pName;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
