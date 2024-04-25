package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.AABB;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class VoidlilyFeature extends Feature<NoneFeatureConfiguration> {
    public VoidlilyFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int size = 2;

        var aabb = AABB.ofSize(origin.relative(direction).getCenter(), 0, 8, 0);

        boolean test = level.getBlockStates(aabb).allMatch((pState) -> pState.is(Blocks.AIR));

        for (int x = -size; x <= size; x++) {
            for (int y = -size; y <= size; y++) {
                for (int z = -size; z <= size; z++) {
                    if (test) {
                        this.placeFlower(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 4);
                    }
                }
            }
        }

        return true;
    }

    public void placeFlower(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeFlower(pLevel, pPos);
        }
    }

    public void placeFlower(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.VOIDLILY.get().defaultBlockState());
        }
    }
}
