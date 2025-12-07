package com.axanthic.icaria.data.map;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record Pottable(Block block) {
	public static final Codec<Pottable> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			BuiltInRegistries.BLOCK.byNameCodec().fieldOf("block").forGetter(Pottable::block)
		).apply(instance, Pottable::new)
	);
}
