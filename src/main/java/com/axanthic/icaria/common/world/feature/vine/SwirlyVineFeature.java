package com.axanthic.icaria.common.world.feature.vine;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class SwirlyVineFeature extends IcariaVineFeature {
    public SwirlyVineFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.SWIRLY_VINE.get());
    }
}
