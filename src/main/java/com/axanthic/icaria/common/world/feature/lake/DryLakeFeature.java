package com.axanthic.icaria.common.world.feature.lake;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DryLakeFeature extends IcariaLakeFeature {
    public DryLakeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.DRY_LAKE_BED.get(), Blocks.AIR);
    }
}
