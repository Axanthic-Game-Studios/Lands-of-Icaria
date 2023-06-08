package com.axanthic.icaria.common.world.feature.shrooms;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BrownGroundShroomsFeature extends IcariaGroundShroomsFeature {
    public BrownGroundShroomsFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.BROWN_GROUND_SHROOMS.get());
    }
}
