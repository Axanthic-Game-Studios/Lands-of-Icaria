package com.axanthic.icaria.common.properties;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

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

	public Corner getOpposite() {
		return switch (this) {
			case BOTTOM_FRONT_LEFT -> BOTTOM_FRONT_RIGHT;
			case BOTTOM_FRONT_RIGHT -> BOTTOM_FRONT_LEFT;
			case BOTTOM_BACK_LEFT -> BOTTOM_BACK_RIGHT;
			case BOTTOM_BACK_RIGHT -> BOTTOM_BACK_LEFT;
			case TOP_FRONT_LEFT -> TOP_FRONT_RIGHT;
			case TOP_FRONT_RIGHT -> TOP_FRONT_LEFT;
			case TOP_BACK_LEFT -> TOP_BACK_RIGHT;
			case TOP_BACK_RIGHT -> TOP_BACK_LEFT;
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
