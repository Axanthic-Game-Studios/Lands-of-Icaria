package com.axanthic.icaria.client.outline;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;
import java.util.Map;

import net.minecraft.util.random.WeightedList;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record Outline(Map<String, WeightedList<List<List<Float>>>> variants) {
	public static final Codec<Outline> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			Codec.unboundedMap(Codec.STRING, WeightedList.nonEmptyCodec(Codec.FLOAT.listOf(6, 6).listOf().fieldOf("outlines"))).fieldOf("variants").forGetter(Outline::variants)
		).apply(instance, Outline::new)
	);
}
