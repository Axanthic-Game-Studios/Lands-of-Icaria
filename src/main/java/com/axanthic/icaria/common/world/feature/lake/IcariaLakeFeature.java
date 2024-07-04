package com.axanthic.icaria.common.world.feature.lake;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

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
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();

        if (origin.getY() <= level.getMinBuildHeight() + 4) {
            return false;
        } else {
            var a = random.nextInt(4) + 4;
            var booleans = new boolean[2048];

            var block = this.block.defaultBlockState();
            var fluid = this.fluid.defaultBlockState();

            for (int b = 0; b < a; b++) {
                double n = random.nextDouble() * 6.0D + 3.0D;
                double o = random.nextDouble() * 4.0D + 2.0D;
                double p = random.nextDouble() * 6.0D + 3.0D;
                double q = random.nextDouble() * (16.0D - n - 2.0D) + 1.0D + n / 2.0D;
                double r = random.nextDouble() * (8.0D - o - 4.0D) + 2.0D + o / 2.0D;
                double s = random.nextDouble() * (16.0D - p - 2.0D) + 1.0D + p / 2.0D;
                for (int c = 1; c < 15; c++) {
                    for (int d = 1; d < 15; d++) {
                        for (int e = 1; e < 7; e++) {
                            double t = (c - q) / (n / 2.0D);
                            double u = (e - r) / (o / 2.0D);
                            double v = (d - s) / (p / 2.0D);
                            double w = t * t + u * u + v * v;
                            if (w < 1.0D) {
                                booleans[(c * 16 + d) * 8 + e] = true;
                            }
                        }
                    }
                }
            }

            origin = origin.below(4);

            for (int f = 0; f < 16; f++) {
                for (int g = 0; g < 16; g++) {
                    for (int h = 0; h < 8; h++) {
                        var blockState = level.getBlockState(origin.offset(f, h, g));
                        if (!booleans[(f * 16 + g) * 8 + h] && (f < 15 && booleans[((f + 1) * 16 + g) * 8 + h] || f > 0 && booleans[((f - 1) * 16 + g) * 8 + h] || g < 15 && booleans[(f * 16 + g + 1) * 8 + h] || g > 0 && booleans[(f * 16 + (g - 1)) * 8 + h] || h < 7 && booleans[(f * 16 + g) * 8 + h + 1] || h > 0 && booleans[(f * 16 + g) * 8 + (h - 1)])) {
                            if (h >= 4 && blockState.liquid()) {
                                return false;
                            }

                            if (h < 4 && !blockState.isSolid() && level.getBlockState(origin.offset(f, h, g)) != fluid) {
                                return false;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    for (int k = 0; k < 8; k++) {
                        var blockPos = origin.offset(i, k, j);
                        if (booleans[(i * 16 + j) * 8 + k]) {
                            var flag = k >= 4;
                            if (this.isReplaced(level, blockPos)) {
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

            for (int j2 = 0; j2 < 16; j2++) {
                for (int j3 = 0; j3 < 16; j3++) {
                    for (int l3 = 0; l3 < 8; l3++) {
                        boolean flag = !booleans[(j2 * 16 + j3) * 8 + l3] && (j2 < 15 && booleans[((j2 + 1) * 16 + j3) * 8 + l3] || j2 > 0 && booleans[((j2 - 1) * 16 + j3) * 8 + l3] || j3 < 15 && booleans[(j2 * 16 + j3 + 1) * 8 + l3] || j3 > 0 && booleans[(j2 * 16 + (j3 - 1)) * 8 + l3] || l3 < 7 && booleans[(j2 * 16 + j3) * 8 + l3 + 1] || l3 > 0 && booleans[(j2 * 16 + j3) * 8 + (l3 - 1)]);
                        if (flag && (l3 < 4 || random.nextInt(2) != 0)) {
                            var blockPos = origin.offset(j2, l3, j3);
                            if (level.getBlockState(origin.offset(j2, l3, j3)).isSolid() && this.isReplaced(level, origin.offset(j2, l3, j3))) {
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

    public boolean isReplaced(WorldGenLevel pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos).canBeReplaced() || pLevel.getBlockState(pPos).is(BlockTags.DIRT);
    }
}
