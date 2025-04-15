package com.axanthic.icaria.common.properties;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Kettle implements StringRepresentable {
	EMPTY("empty"),
	FILLED("filled"),
	ACTIVE("active"),
	BREWING("brewing");

	public final String name;

	Kettle(String pName) {
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
