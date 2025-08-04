package com.axanthic.icaria.common.properties;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Bathtub implements StringRepresentable {
	NONE("none"),
	POWDER_SNOW("powder_snow"),
	WATER("water"),
	MEDITERRANEAN_WATER("mediterranean_water");

	public final String name;

	Bathtub(String pName) {
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
