package com.axanthic.icaria.common.world.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TestFeature extends Feature<NoneFeatureConfiguration> {

	public TestFeature(final Codec<NoneFeatureConfiguration> deserializer) {
		super(deserializer);
	}

	@Override
	public boolean place(final FeaturePlaceContext<NoneFeatureConfiguration> context) {
		final WorldGenLevel world = context.level();
		final BlockPos startPos = context.origin();
		final BlockPos pos = startPos.above();
		for (int x = 1; x < 4; x++) {
			for (int y = 0; y < 5; y++) {
				for (int z = 1; z < 4; z++) {
					this.setBlock(world, pos.offset(x, y, z), Blocks.PUMPKIN.defaultBlockState());
				}
			}
		}
		return true;
	}
}