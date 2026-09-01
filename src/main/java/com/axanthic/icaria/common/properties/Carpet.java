package com.axanthic.icaria.common.properties;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.util.StringRepresentable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum Carpet implements StringRepresentable {
	ARACHNE_STRING_CARPET("arachne_string_carpet"),
	WHITE_ARACHNE_STRING_CARPET("white_arachne_string_carpet"),
	LIGHT_GRAY_ARACHNE_STRING_CARPET("light_gray_arachne_string_carpet"),
	GRAY_ARACHNE_STRING_CARPET("gray_arachne_string_carpet"),
	BLACK_ARACHNE_STRING_CARPET("black_arachne_string_carpet"),
	BROWN_ARACHNE_STRING_CARPET("brown_arachne_string_carpet"),
	RED_ARACHNE_STRING_CARPET("red_arachne_string_carpet"),
	ORANGE_ARACHNE_STRING_CARPET("orange_arachne_string_carpet"),
	YELLOW_ARACHNE_STRING_CARPET("yellow_arachne_string_carpet"),
	LIME_ARACHNE_STRING_CARPET("lime_arachne_string_carpet"),
	GREEN_ARACHNE_STRING_CARPET("green_arachne_string_carpet"),
	CYAN_ARACHNE_STRING_CARPET("cyan_arachne_string_carpet"),
	LIGHT_BLUE_ARACHNE_STRING_CARPET("light_blue_arachne_string_carpet"),
	BLUE_ARACHNE_STRING_CARPET("blue_arachne_string_carpet"),
	PURPLE_ARACHNE_STRING_CARPET("purple_arachne_string_carpet"),
	MAGENTA_ARACHNE_STRING_CARPET("magenta_arachne_string_carpet"),
	PINK_ARACHNE_STRING_CARPET("pink_arachne_string_carpet");

	public final String name;

	Carpet(String pName) {
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
