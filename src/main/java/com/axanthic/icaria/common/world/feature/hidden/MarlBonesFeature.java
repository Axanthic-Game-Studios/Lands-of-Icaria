package com.axanthic.icaria.common.world.feature.hidden;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MarlBonesFeature extends IcariaHiddenFeature {
    public MarlBonesFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.MARL_BONES.get(), IcariaBlocks.SURFACE_BONES.get());
    }
}
