package com.axanthic.icaria.common.properties;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Trough implements StringRepresentable {
	NONE("none"),
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
