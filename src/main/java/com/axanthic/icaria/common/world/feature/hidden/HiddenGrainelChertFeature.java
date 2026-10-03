package com.axanthic.icaria.common.world.feature.hidden;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HiddenGrainelChertFeature extends HiddenFeature {
	public HiddenGrainelChertFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.CHERT_ORE.get(), IcariaBlocks.CHERT_RUBBLE.get());
	}
}
