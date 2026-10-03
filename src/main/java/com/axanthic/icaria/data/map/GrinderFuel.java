package com.axanthic.icaria.data.map;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record GrinderFuel(int burnTime) {
	public static final Codec<GrinderFuel> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			Codec.INT.fieldOf("burnTime").forGetter(GrinderFuel::burnTime)
		).apply(instance, GrinderFuel::new)
	);
}
