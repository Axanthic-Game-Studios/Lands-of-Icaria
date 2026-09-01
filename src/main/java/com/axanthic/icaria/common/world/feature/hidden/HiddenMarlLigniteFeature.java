package com.axanthic.icaria.common.world.feature.hidden;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HiddenMarlLigniteFeature extends HiddenFeature {
	public HiddenMarlLigniteFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.MARL_LIGNITE.get(), IcariaBlocks.SURFACE_LIGNITE.get());
	}
}
