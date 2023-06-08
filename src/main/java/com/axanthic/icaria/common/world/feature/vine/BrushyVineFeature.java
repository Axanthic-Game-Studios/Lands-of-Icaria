package com.axanthic.icaria.common.world.feature.vine;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BrushyVineFeature extends IcariaVineFeature {
    public BrushyVineFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.BRUSHY_VINE.get());
    }
}
