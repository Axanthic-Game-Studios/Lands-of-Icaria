package com.axanthic.icaria.common.world.feature.tree.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadLaurelTreeFeature extends DeadTreeFeature {
	public DeadLaurelTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_LAUREL_LOG.get(), IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.SCRUBLAND_MOSS.get(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaBlocks.LAUREL_TWIGS.get(), Moss.SCRUBLAND, 1, 3);
	}
}
