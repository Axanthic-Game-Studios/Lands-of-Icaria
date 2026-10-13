package com.axanthic.icaria.common.enums;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum HeightPair implements StringRepresentable {
	BOTTOM("bottom"),
	TOP("top");

	public final String name;

	HeightPair(String pName) {
		this.name = pName;
	}

	public HeightPair getOpposite() {
		return switch (this) {
			case BOTTOM -> TOP;
			case TOP -> BOTTOM;
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
