package com.axanthic.icaria.common.world.feature.hidden;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GrainelChertFeature extends IcariaHiddenFeature {
    public GrainelChertFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.GRAINEL_CHERT.get(), IcariaBlocks.SURFACE_CHERT.get());
    }
}
