package com.axanthic.icaria.common.world.feature.shrooms;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class LargeBrownGroundShroomsFeature extends IcariaGroundShroomsFeature {
    public LargeBrownGroundShroomsFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get());
    }
}
