package com.axanthic.icaria.common.enums;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum DepthSpan implements StringRepresentable {
	FRONT("front"),
	CENTER("center"),
	BACK("back");

	public final String name;

	DepthSpan(String pName) {
		this.name = pName;
	}

	public DepthSpan getOpposite() {
		return switch (this) {
			case FRONT -> BACK;
			case CENTER -> CENTER;
			case BACK -> FRONT;
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
