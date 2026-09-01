package com.axanthic.icaria.common.properties;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Ladder implements StringRepresentable {
	NONE("none"),
	CRACKED("cracked"),
	DAMAGED("damaged");

	public final String name;

	Ladder(String pName) {
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
