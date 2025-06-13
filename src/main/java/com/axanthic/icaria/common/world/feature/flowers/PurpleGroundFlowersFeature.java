package com.axanthic.icaria.common.world.feature.flowers;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PurpleGroundFlowersFeature extends IcariaGroundFlowersFeature {
	public PurpleGroundFlowersFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
	}
}
