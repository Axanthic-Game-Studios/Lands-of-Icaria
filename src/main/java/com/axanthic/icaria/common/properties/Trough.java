package com.axanthic.icaria.common.properties;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Trough implements StringRepresentable {
	NONE("none"),
	POWDER_SNOW("powder_snow"),
	WATER("water"),
	MEDITERRANEAN_WATER("mediterranean_water"),
	ONION("onion"),
	SPELT("spelt"),
	VINEBERRIES("vineberries");

	public final String name;

	Trough(String pName) {
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
