package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadPopulusTreeFeature extends IcariaDeadTreeFeature {
	public DeadPopulusTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_POPULUS_LOG.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.FOREST_MOSS.get(), IcariaBlocks.POPULUS_TWIGS.get(), Moss.FOREST);
	}
}
