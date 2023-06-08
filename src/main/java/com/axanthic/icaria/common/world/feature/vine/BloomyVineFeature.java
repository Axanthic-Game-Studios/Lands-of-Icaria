package com.axanthic.icaria.common.world.feature.vine;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BloomyVineFeature extends IcariaVineFeature {
    public BloomyVineFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.BLOOMY_VINE.get());
    }
}
