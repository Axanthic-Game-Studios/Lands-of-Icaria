package com.axanthic.icaria.common.world.feature.tree.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadPopulusTreeFeature extends DeadTreeFeature {
	public DeadPopulusTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_POPULUS_LOG.get(), IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.FOREST_MOSS.get(), IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), IcariaBlocks.POPULUS_TWIGS.get(), Moss.FOREST, 6, 8);
	}
}
