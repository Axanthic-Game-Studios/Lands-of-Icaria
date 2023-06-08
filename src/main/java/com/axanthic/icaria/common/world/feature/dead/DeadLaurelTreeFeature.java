package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeadLaurelTreeFeature extends IcariaDeadTreeFeature {
    public DeadLaurelTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.DEAD_LAUREL_LOG.get(), Blocks.AIR, IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.LAUREL_TWIGS.get());
    }
}
