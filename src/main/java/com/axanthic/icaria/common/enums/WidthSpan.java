package com.axanthic.icaria.common.enums;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum WidthSpan implements StringRepresentable {
	LEFT("left"),
	CENTER("center"),
	RIGHT("right");

	public final String name;

	WidthSpan(String pName) {
		this.name = pName;
	}

	public WidthSpan getOpposite() {
		return switch (this) {
			case LEFT -> RIGHT;
			case CENTER -> CENTER;
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
