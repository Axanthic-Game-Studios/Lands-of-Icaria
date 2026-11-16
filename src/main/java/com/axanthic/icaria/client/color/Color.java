package com.axanthic.icaria.client.color;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record Color(int color) {
	public static final Codec<Color> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			Codec.INT.fieldOf("color").forGetter(Color::color)
		).apply(instance, Color::new)
	);
}
