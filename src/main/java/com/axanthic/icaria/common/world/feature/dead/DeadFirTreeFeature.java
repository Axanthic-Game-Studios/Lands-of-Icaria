package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadFirTreeFeature extends IcariaDeadTreeFeature {
	public DeadFirTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_FIR_LOG.get(), IcariaBlocks.FIR_LOG.get(), IcariaBlocks.FOREST_MOSS.get(), IcariaBlocks.FIR_TWIGS.get(), Moss.FOREST);
	}
}
