package com.axanthic.icaria.common.world.feature.tree.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadFirTreeFeature extends DeadTreeFeature {
	public DeadFirTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_FIR_LOG.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FOREST_MOSS.get(), IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaBlocks.FIR_TWIGS.get(), Moss.FOREST, 8, 10);
	}
}
