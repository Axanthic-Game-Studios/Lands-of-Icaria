package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeadPlaneTreeFeature extends IcariaDeadTreeFeature {
    public DeadPlaneTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.DEAD_PLANE_LOG.get(), IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.SCRUBLAND_MOSS.get(), IcariaBlocks.PLANE_TWIGS.get(), Moss.SCRUBLAND);
    }
}
