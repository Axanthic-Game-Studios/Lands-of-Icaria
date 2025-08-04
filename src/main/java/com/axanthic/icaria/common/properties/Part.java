package com.axanthic.icaria.common.properties;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Part implements StringRepresentable {
	HEAD("head"),
	FOOT("foot");

	public final String name;

	Part(String pName) {
		this.name = pName;
	}

	public Part getOpposite() {
		return switch (this) {
			case HEAD -> FOOT;
			case FOOT -> HEAD;
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
