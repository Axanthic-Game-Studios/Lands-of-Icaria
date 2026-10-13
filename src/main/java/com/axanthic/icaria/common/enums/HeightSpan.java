package com.axanthic.icaria.common.enums;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum HeightSpan implements StringRepresentable {
	BOTTOM("bottom"),
	CENTER("center"),
	TOP("top");

	public final String name;

	HeightSpan(String pName) {
		this.name = pName;
	}

	public HeightSpan getOpposite() {
		return switch (this) {
			case BOTTOM -> TOP;
			case CENTER -> CENTER;
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
