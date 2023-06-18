package com.axanthic.icaria.common.world.feature.hidden;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class MarlChertFeature extends IcariaHiddenFeature {
    public MarlChertFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.MARL_CHERT.get(), IcariaBlocks.SURFACE_CHERT.get());
    }
}
