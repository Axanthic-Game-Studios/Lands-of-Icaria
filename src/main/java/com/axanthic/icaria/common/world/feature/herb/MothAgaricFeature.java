package com.axanthic.icaria.common.world.feature.herb;

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

public class MothAgaricFeature extends Feature<NoneFeatureConfiguration> {
    public MothAgaricFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int size = 2;

        var aabb = AABB.ofSize(origin.getCenter(), 16, 0, 16);
        var list = level.getBlockStates(aabb).toList();

        boolean test = list.contains(IcariaBlocks.DEAD_POPULUS_LOG.get().defaultBlockState());

        for (int x = -size; x <= size; x++) {
            for (int y = -size; y <= size; y++) {
                for (int z = -size; z <= size; z++) {
                    if (test) {
                        this.placeHerb(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
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
            this.setBlock(pLevel, pPos, IcariaBlocks.MOTH_AGARIC.get().defaultBlockState());
        }
    }
}
