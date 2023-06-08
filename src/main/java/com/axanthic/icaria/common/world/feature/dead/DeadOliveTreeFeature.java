package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeadOliveTreeFeature extends IcariaDeadTreeFeature {
    public DeadOliveTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.DEAD_OLIVE_LOG.get(), Blocks.AIR, IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.OLIVE_TWIGS.get());
    }
}
