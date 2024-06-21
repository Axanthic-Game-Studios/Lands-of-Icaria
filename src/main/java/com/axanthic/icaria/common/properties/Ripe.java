package com.axanthic.icaria.common.properties;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault

public enum Ripe implements StringRepresentable {
    NONE("none"),
    RIPE("ripe");

    public final String name;

    Ripe(String pName) {
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
