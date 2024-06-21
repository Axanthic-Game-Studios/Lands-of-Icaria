package com.axanthic.icaria.common.properties;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault

public enum Olives implements StringRepresentable {
    NONE("none"),
    GREEN("green"),
    BLACK("black"),
    LEAVES("leaves");

    public final String name;

    Olives(String pName) {
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
