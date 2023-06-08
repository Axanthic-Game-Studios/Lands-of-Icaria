package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DeadDroughtrootTreeFeature extends IcariaDeadTreeFeature {
    public DeadDroughtrootTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec, IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), Blocks.AIR, IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_TWIGS.get());
    }
}
