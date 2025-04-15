package com.axanthic.icaria.common.world.feature.hidden;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HiddenMarlBonesFeature extends IcariaHiddenFeature {
	public HiddenMarlBonesFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.MARL_BONES.get(), IcariaBlocks.SURFACE_BONES.get());
	}
}
