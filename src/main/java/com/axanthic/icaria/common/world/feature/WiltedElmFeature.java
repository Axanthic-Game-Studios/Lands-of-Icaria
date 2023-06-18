package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.AABB;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class WiltedElmFeature extends Feature<NoneFeatureConfiguration> {
    public WiltedElmFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int size = 2;

        var list = level.getBlockStates(new AABB(origin).inflate(4)).toList();

        boolean leavesA = list.contains(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get().defaultBlockState()) || list.contains(IcariaBlocks.FALLEN_FIR_LEAVES.get().defaultBlockState()) || list.contains(IcariaBlocks.FALLEN_LAUREL_LEAVES.get().defaultBlockState());
        boolean leavesB = list.contains(IcariaBlocks.FALLEN_OLIVE_LEAVES.get().defaultBlockState()) || list.contains(IcariaBlocks.FALLEN_PLANE_LEAVES.get().defaultBlockState()) || list.contains(IcariaBlocks.FALLEN_POPULUS_LEAVES.get().defaultBlockState());
        boolean leaves = leavesA && leavesB;
        boolean moss = list.contains(IcariaBlocks.FOREST_MOSS.get().defaultBlockState()) || list.contains(IcariaBlocks.SCRUBLAND_MOSS.get().defaultBlockState()) || list.contains(IcariaBlocks.STEPPE_MOSS.get().defaultBlockState());
        boolean test = leaves && moss;

        for (int x = -size; x <= size; x++) {
            for (int y = -size; y <= size; y++) {
                for (int z = -size; z <= size; z++) {
                    if (test) {
                        this.placeHerb(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 4);
                    }
                }
            }
        }

        return true;
    }

    public void placeHerb(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeHerb(pLevel, pPos);
        }
    }

    public void placeHerb(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.WILTED_ELM.get().defaultBlockState());
        }
    }
}
