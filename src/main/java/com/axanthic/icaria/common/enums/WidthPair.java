package com.axanthic.icaria.common.enums;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum WidthPair implements StringRepresentable {
	LEFT("left"),
	RIGHT("right");

	public final String name;

	WidthPair(String pName) {
		this.name = pName;
	}

	public WidthPair getOpposite() {
		return switch (this) {
			case LEFT -> RIGHT;
			case RIGHT -> LEFT;
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
