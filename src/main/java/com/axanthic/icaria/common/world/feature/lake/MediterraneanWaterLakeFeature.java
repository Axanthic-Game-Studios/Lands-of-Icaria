package com.axanthic.icaria.common.world.feature.lake;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class MediterraneanWaterLakeFeature extends IcariaLakeFeature {
    public MediterraneanWaterLakeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.GRASSY_MARL.get(), IcariaBlocks.MEDITERRANEAN_WATER.get());
    }
}
