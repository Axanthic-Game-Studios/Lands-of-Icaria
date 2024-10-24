package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DeadDroughtrootTreeFeature extends IcariaDeadTreeFeature {
	public DeadDroughtrootTreeFeature(Codec<NoneFeatureConfiguration> pCodec) {
		super(pCodec, IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.DROUGHTROOT_LOG.get(), Blocks.AIR, IcariaBlocks.DROUGHTROOT_TWIGS.get(), Moss.NONE);
	}
}
