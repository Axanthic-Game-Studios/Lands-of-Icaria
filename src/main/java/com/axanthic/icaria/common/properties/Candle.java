package com.axanthic.icaria.common.properties;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.StringRepresentable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Candle implements StringRepresentable {
	NONE("none"),
	CANDLE("candle"),
	WHITE_CANDLE("white_candle"),
	LIGHT_GRAY_CANDLE("light_gray_candle"),
	GRAY_CANDLE("gray_candle"),
	BLACK_CANDLE("black_candle"),
	BROWN_CANDLE("brown_candle"),
	RED_CANDLE("red_candle"),
	ORANGE_CANDLE("orange_candle"),
	YELLOW_CANDLE("yellow_candle"),
	LIME_CANDLE("lime_candle"),
	GREEN_CANDLE("green_candle"),
	CYAN_CANDLE("cyan_candle"),
	LIGHT_BLUE_CANDLE("light_blue_candle"),
	BLUE_CANDLE("blue_candle"),
	PURPLE_CANDLE("purple_candle"),
	MAGENTA_CANDLE("magenta_candle"),
	PINK_CANDLE("pink_candle");

	public final String name;

	Candle(String pName) {
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
