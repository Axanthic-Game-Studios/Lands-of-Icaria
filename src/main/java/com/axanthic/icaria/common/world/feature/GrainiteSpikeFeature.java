package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrainiteSpikeFeature extends Feature<NoneFeatureConfiguration> {
    public GrainiteSpikeFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();

        int length = 3;
        int height = 4;

        for (int x = 1; x <= length - 2; ++x) {
            for (int y = 1; y <= height - 2; ++y) {
                for (int z = 1; z <= length - 2; ++z) {
                    this.placeGrainite(level, origin.below().north(x + 7).above(y + 18).east(z + 7));
                }
            }
        }

        this.placeUpperRing(level, origin, 9, 19, 7, 1, 2);
        this.placeUpperRing(level, origin, 9, 20, 7, 2, 1);

        for (int x = 1; x <= length - 1; ++x) {
            for (int y = 1; y <= height - 1; ++y) {
                for (int z = 1; z <= length - 1; ++z) {
                    this.placeGrainite(level, origin.below().north(x + 4).above(y + 12).east(z + 4));
                    this.placeGrainite(level, origin.below().north(x + 5).above(y + 15).east(z + 5));
                }
            }
        }

        this.placeInnerRing(level, origin, 7, 13, 4, 1, 3);
        this.placeInnerRing(level, origin, 7, 14, 4, 1, 1);
        this.placeInnerRing(level, origin, 7, 15, 4, 3, 1);
        this.placeInnerRing(level, origin, 8, 16, 5, 1, 3);
        this.placeInnerRing(level, origin, 8, 17, 5, 1, 1);
        this.placeInnerRing(level, origin, 8, 18, 5, 3, 1);

        for (int x = 1; x <= length; ++x) {
            for (int y = 1; y <= height; ++y) {
                for (int z = 1; z <= length; ++z) {
                    this.placeGrainite(level, origin.below().north(x).above(y).east(z));
                    this.placeGrainite(level, origin.below().north(x + 1).above(y + 4).east(z + 1));
                    this.placeGrainite(level, origin.below().north(x + 2).above(y + 8).east(z + 2));
                }
            }
        }

        this.placeLowerRing(level, origin, 4, 1, 0, 1, 4);
        this.placeLowerRing(level, origin, 4, 2, 0, 1, 2);
        this.placeLowerRing(level, origin, 4, 3, 0, 2, 1);
        this.placeLowerRing(level, origin, 4, 4, 0, 4, 1);
        this.placeLowerRing(level, origin, 5, 5, 1, 1, 4);
        this.placeLowerRing(level, origin, 5, 6, 1, 1, 2);
        this.placeLowerRing(level, origin, 5, 7, 1, 2, 1);
        this.placeLowerRing(level, origin, 5, 8, 1, 4, 1);
        this.placeLowerRing(level, origin, 6, 9, 2, 1, 4);
        this.placeLowerRing(level, origin, 6, 10, 2, 1, 2);
        this.placeLowerRing(level, origin, 6, 11, 2, 2, 1);
        this.placeLowerRing(level, origin, 6, 12, 2, 4, 1);

        return true;
    }

    public void placeUpperRing(WorldGenLevel pLevel, BlockPos pPos, int pX, int pY, int pZ, int pChanceSouthWest, int pChanceNorthEast) {
        this.placeGrainite(pLevel, pPos.below().north(pX).above(pY).east(pZ + 1), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ).above(pY).east(pZ + 1), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 1).above(pY).east(pX), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 1).above(pY).east(pZ), pChanceSouthWest);
    }

    public void placeInnerRing(WorldGenLevel pLevel, BlockPos pPos, int pX, int pY, int pZ, int pChanceSouthWest, int pChanceNorthEast) {
        this.placeGrainite(pLevel, pPos.below().north(pX).above(pY).east(pZ + 1), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pX).above(pY).east(pZ + 2), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ).above(pY).east(pZ + 1), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ).above(pY).east(pZ + 1), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 1).above(pY).east(pX), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 1).above(pY).east(pX), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 1).above(pY).east(pZ), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 1).above(pY).east(pZ), pChanceSouthWest);
    }

    public void placeLowerRing(WorldGenLevel pLevel, BlockPos pPos, int pX, int pY, int pZ, int pChanceSouthWest, int pChanceNorthEast) {
        this.placeGrainite(pLevel, pPos.below().north(pX).above(pY).east(pZ + 1), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pX).above(pY).east(pZ + 2), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pX).above(pY).east(pZ + 3), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ).above(pY).east(pZ + 1), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ).above(pY).east(pZ + 2), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ).above(pY).east(pZ + 3), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 1).above(pY).east(pX), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 2).above(pY).east(pX), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 3).above(pY).east(pX), pChanceNorthEast);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 1).above(pY).east(pZ), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 2).above(pY).east(pZ), pChanceSouthWest);
        this.placeGrainite(pLevel, pPos.below().north(pZ + 3).above(pY).east(pZ), pChanceSouthWest);
    }

    public void placeGrainite(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeGrainite(pLevel, pPos);
        }
    }

    public void placeGrainite(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir()) {
            this.setBlock(pLevel, pPos, IcariaBlocks.GRAINITE.get().defaultBlockState());
        }
    }
}
