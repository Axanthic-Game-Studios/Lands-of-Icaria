package com.axanthic.icaria.common.properties;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Moss implements StringRepresentable {
	NONE("none"),
	FOREST("forest"),
	SCRUBLAND("scrubland"),
	STEPPE("steppe");

	public final String name;

	Moss(String pName) {
		this.name = pName;
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
