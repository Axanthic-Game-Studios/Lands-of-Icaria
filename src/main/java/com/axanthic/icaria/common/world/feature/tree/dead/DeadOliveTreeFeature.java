package com.axanthic.icaria.common.world.feature.tree.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadOliveTreeFeature extends DeadIcariaTreeFeature {
	public DeadOliveTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_OLIVE_LOG.get(), IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.STEPPE_MOSS.get(), IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), IcariaBlocks.OLIVE_TWIGS.get(), Moss.STEPPE, 5, 5);
	}
}
