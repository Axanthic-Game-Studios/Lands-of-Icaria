package com.axanthic.icaria.common.world.feature.shrooms;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class GreenGroundShroomsFeature extends IcariaGroundShroomsFeature {
    public GreenGroundShroomsFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.GREEN_GROUND_SHROOMS.get());
    }
}
