package com.axanthic.icaria.data.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record Freezable(Block block) {
	public static final Codec<Freezable> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(Freezable::block)
		).apply(instance, Freezable::new)
	);
}
