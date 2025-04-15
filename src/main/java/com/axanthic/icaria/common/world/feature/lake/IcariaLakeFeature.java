package com.axanthic.icaria.common.world.feature.lake;

import com.mojang.serialization.Codec;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLakeFeature extends Feature<NoneFeatureConfiguration> {
	public Block block;
	public Block fluid;

	public IcariaLakeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pBlock, Block pFluid) {
		super(pCodec);
		this.block = pBlock;
		this.fluid = pFluid;
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pFeaturePlaceContext) {
		var level = pFeaturePlaceContext.level();
		var origin = pFeaturePlaceContext.origin();
		var random = pFeaturePlaceContext.random();

		if (origin.getY() <= level.getMinY() + 4) {
			return false;
		} else {
			var a = random.nextInt(4) + 4;
			var booleans = new boolean[2048];

			var block = this.block.defaultBlockState();
			var fluid = this.fluid.defaultBlockState();

			for (var b = 0; b < a; b++) {
				var n = random.nextDouble() * 6.0D + 3.0D;
				var o = random.nextDouble() * 4.0D + 2.0D;
				var p = random.nextDouble() * 6.0D + 3.0D;
				var q = random.nextDouble() * (16.0D - n - 2.0D) + 1.0D + n / 2.0D;
				var r = random.nextDouble() * (8.0D - o - 4.0D) + 2.0D + o / 2.0D;
				var s = random.nextDouble() * (16.0D - p - 2.0D) + 1.0D + p / 2.0D;
				for (var c = 1; c < 15; c++) {
					for (var d = 1; d < 15; d++) {
						for (var e = 1; e < 7; e++) {
							var t = (c - q) / (n / 2.0D);
							var u = (e - r) / (o / 2.0D);
							var v = (d - s) / (p / 2.0D);
							var w = t * t + u * u + v * v;
							if (w < 1.0D) {
								booleans[(c * 16 + d) * 8 + e] = true;
							}
						}
					}
				}
			}

			origin = origin.below(4);

			for (var f = 0; f < 16; f++) {
				for (var g = 0; g < 16; g++) {
					for (var h = 0; h < 8; h++) {
						var blockState = level.getBlockState(origin.offset(f, h, g));
						if (!booleans[(f * 16 + g) * 8 + h] && (f < 15 && booleans[((f + 1) * 16 + g) * 8 + h] || f > 0 && booleans[((f - 1) * 16 + g) * 8 + h] || g < 15 && booleans[(f * 16 + g + 1) * 8 + h] || g > 0 && booleans[(f * 16 + (g - 1)) * 8 + h] || h < 7 && booleans[(f * 16 + g) * 8 + h + 1] || h > 0 && booleans[(f * 16 + g) * 8 + (h - 1)])) {
							if (h >= 4 && blockState.liquid()) {
								return false;
							}

							if (h < 4 && !blockState.isSolidRender() && level.getBlockState(origin.offset(f, h, g)) != fluid) {
								return false;
							}
						}
					}
				}
			}

			for (var i = 0; i < 16; i++) {
				for (var j = 0; j < 16; j++) {
					for (var k = 0; k < 8; k++) {
						var blockPos = origin.offset(i, k, j);
						if (booleans[(i * 16 + j) * 8 + k]) {
							var flag = k >= 4;
							if (this.isChangeable(level, blockPos)) {
								level.setBlock(blockPos, flag ? Blocks.AIR.defaultBlockState() : fluid, 2);
								if (flag) {
									level.scheduleTick(blockPos, Blocks.AIR.defaultBlockState().getBlock(), 0);
									this.markAboveForPostProcessing(level, blockPos);
								}
							}
						}
					}
				}
			}

			for (var j2 = 0; j2 < 16; j2++) {
				for (var j3 = 0; j3 < 16; j3++) {
					for (var l3 = 0; l3 < 8; l3++) {
						var flag = !booleans[(j2 * 16 + j3) * 8 + l3] && (j2 < 15 && booleans[((j2 + 1) * 16 + j3) * 8 + l3] || j2 > 0 && booleans[((j2 - 1) * 16 + j3) * 8 + l3] || j3 < 15 && booleans[(j2 * 16 + j3 + 1) * 8 + l3] || j3 > 0 && booleans[(j2 * 16 + (j3 - 1)) * 8 + l3] || l3 < 7 && booleans[(j2 * 16 + j3) * 8 + l3 + 1] || l3 > 0 && booleans[(j2 * 16 + j3) * 8 + (l3 - 1)]);
						if (flag && (l3 < 4 || random.nextInt(2) != 0)) {
							var blockPos = origin.offset(j2, l3, j3);
							if (level.getBlockState(origin.offset(j2, l3, j3)).isSolidRender() && this.isChangeable(level, origin.offset(j2, l3, j3))) {
								level.setBlock(blockPos, block, 2);
								this.markAboveForPostProcessing(level, blockPos);
							}
						}
					}
				}
			}

			return true;
		}
	}

	public boolean isChangeable(WorldGenLevel pWorldGenLevel, BlockPos pBlockPos) {
		return pWorldGenLevel.getBlockState(pBlockPos).canBeReplaced() || pWorldGenLevel.getBlockState(pBlockPos).is(BlockTags.DIRT);
	}
}
