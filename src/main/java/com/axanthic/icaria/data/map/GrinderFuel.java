package com.axanthic.icaria.data.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record GrinderFuel(int burnTime) {
	public static final Codec<GrinderFuel> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			Codec.INT.fieldOf("burnTime").forGetter(GrinderFuel::burnTime)
		).apply(instance, GrinderFuel::new)
	);
}
