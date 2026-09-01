package com.axanthic.icaria.common.properties;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Olives implements StringRepresentable {
	NONE("none"),
	GREEN("green"),
	BLACK("black"),
	LEAVES("leaves");

	public final String name;

	Olives(String pName) {
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
