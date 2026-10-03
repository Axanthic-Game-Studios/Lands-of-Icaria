package com.axanthic.icaria.common.properties;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Fill implements StringRepresentable {
	NONE("none"),
	POWDER_SNOW("powder_snow"),
	WATER("water"),
	MEDITERRANEAN_WATER("mediterranean_water");

	public final String name;

	Fill(String pName) {
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
