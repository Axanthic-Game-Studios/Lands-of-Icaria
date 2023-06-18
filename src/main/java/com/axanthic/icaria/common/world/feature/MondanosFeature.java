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

public class MondanosFeature extends Feature<NoneFeatureConfiguration> {
    public MondanosFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int size = 2;

        var list = level.getBlockStates(new AABB(origin).inflate(size)).toList();

        boolean sand = list.contains(IcariaBlocks.GRAINEL.get().defaultBlockState()) || list.contains(IcariaBlocks.SILKSAND.get().defaultBlockState());
        boolean test = list.contains(IcariaBlocks.LOAM.get().defaultBlockState()) && sand;

        for (int x = -size; x <= size; x++) {
            for (int y = -size; y <= size; y++) {
                for (int z = -size; z <= size; z++) {
                    if (test) {
                        this.placeHerb(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
                        this.placeRubble(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
                    }
                }
            }
        }

        return true;
    }

    public void placeRubble(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeRubble(pLevel, pPos);
        }
    }

    public void placeRubble(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(IcariaBlocks.LOAM.get())) {
            this.setBlock(pLevel, pPos, IcariaBlocks.RELICSTONE_RUBBLE.get().defaultBlockState());
        } else if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(IcariaBlocks.GRAINEL.get())) {
            this.setBlock(pLevel, pPos, IcariaBlocks.GRAINITE_RUBBLE.get().defaultBlockState());
        } else if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(IcariaBlocks.SILKSAND.get())) {
            this.setBlock(pLevel, pPos, IcariaBlocks.SILKSTONE_RUBBLE.get().defaultBlockState());
        }
    }

    public void placeHerb(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeHerb(pLevel, pPos);
        }
    }

    public void placeHerb(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.SAND)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.MONDANOS.get().defaultBlockState());
        }
    }
}
