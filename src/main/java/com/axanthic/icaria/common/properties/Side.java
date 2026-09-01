package com.axanthic.icaria.common.properties;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Side implements StringRepresentable {
	LEFT("left"),
	RIGHT("right");

	public final String name;

	Side(String pName) {
		this.name = pName;
	}

	public Side getOpposite() {
		return switch (this) {
			case LEFT -> RIGHT;
			case RIGHT -> LEFT;
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
