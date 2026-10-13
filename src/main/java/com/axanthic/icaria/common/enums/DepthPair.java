package com.axanthic.icaria.common.enums;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum DepthPair implements StringRepresentable {
	FRONT("front"),
	BACK("back");

	public final String name;

	DepthPair(String pName) {
		this.name = pName;
	}

	public DepthPair getOpposite() {
		return switch (this) {
			case FRONT -> BACK;
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
