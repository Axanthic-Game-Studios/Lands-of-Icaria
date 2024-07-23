package com.axanthic.icaria.common.world.feature.vine;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ReedyVineFeature extends IcariaVineFeature {
	public ReedyVineFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.REEDY_VINE.get());
	}
}
