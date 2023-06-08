package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeadPopulusTreeFeature extends IcariaDeadTreeFeature {
    public DeadPopulusTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.DEAD_POPULUS_LOG.get(), Blocks.AIR, IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.POPULUS_TWIGS.get());
    }
}
