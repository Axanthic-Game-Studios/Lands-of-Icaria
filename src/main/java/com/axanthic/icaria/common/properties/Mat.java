package com.axanthic.icaria.common.properties;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Mat implements StringRepresentable {
	TERRY_MAT("terry_mat"),
	WHITE_TERRY_MAT("white_terry_mat"),
	LIGHT_GRAY_TERRY_MAT("light_gray_terry_mat"),
	GRAY_TERRY_MAT("gray_terry_mat"),
	BLACK_TERRY_MAT("black_terry_mat"),
	BROWN_TERRY_MAT("brown_terry_mat"),
	RED_TERRY_MAT("red_terry_mat"),
	ORANGE_TERRY_MAT("orange_terry_mat"),
	YELLOW_TERRY_MAT("yellow_terry_mat"),
	LIME_TERRY_MAT("lime_terry_mat"),
	GREEN_TERRY_MAT("green_terry_mat"),
	CYAN_TERRY_MAT("cyan_terry_mat"),
	LIGHT_BLUE_TERRY_MAT("light_blue_terry_mat"),
	BLUE_TERRY_MAT("blue_terry_mat"),
	PURPLE_TERRY_MAT("purple_terry_mat"),
	MAGENTA_TERRY_MAT("magenta_terry_mat"),
	PINK_TERRY_MAT("pink_terry_mat");

	public final String name;

	Mat(String pName) {
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
