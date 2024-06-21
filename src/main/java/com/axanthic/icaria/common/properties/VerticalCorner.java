package com.axanthic.icaria.common.properties;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault

public enum VerticalCorner implements StringRepresentable {
    BOTTOM_LEFT("bottom_left"),
    BOTTOM_RIGHT("bottom_right"),
    TOP_LEFT("top_left"),
    TOP_RIGHT("top_right");

    public final String name;

    VerticalCorner(String pName) {
        this.name = pName;
    }

    public VerticalCorner getOpposite() {
        return switch (this) {
            case BOTTOM_LEFT -> BOTTOM_RIGHT;
            case BOTTOM_RIGHT -> BOTTOM_LEFT;
            case TOP_LEFT -> TOP_RIGHT;
            case TOP_RIGHT -> TOP_LEFT;
        };
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
