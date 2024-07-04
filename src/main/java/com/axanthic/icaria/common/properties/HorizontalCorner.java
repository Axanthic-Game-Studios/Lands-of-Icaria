package com.axanthic.icaria.common.properties;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum HorizontalCorner implements StringRepresentable {
    FRONT_LEFT("front_left"),
    FRONT_RIGHT("front_right"),
    BACK_LEFT("back_left"),
    BACK_RIGHT("back_right");

    public final String name;

    HorizontalCorner(String pName) {
        this.name = pName;
    }

    public HorizontalCorner getOpposite() {
        return switch (this) {
            case FRONT_LEFT -> FRONT_RIGHT;
            case FRONT_RIGHT -> FRONT_LEFT;
            case BACK_LEFT -> BACK_RIGHT;
            case BACK_RIGHT -> BACK_LEFT;
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
