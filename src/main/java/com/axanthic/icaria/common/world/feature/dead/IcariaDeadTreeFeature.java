package com.axanthic.icaria.common.world.feature.dead;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaDeadTreeFeature extends Feature<NoneFeatureConfiguration> {
    public Block dead;
    public Block herb;
    public Block log;
    public Block twigs;

    public IcariaDeadTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pDead, Block pHerb, Block pLog, Block pTwigs) {
        super(pCodec);
        this.dead = pDead;
        this.herb = pHerb;
        this.log = pLog;
        this.twigs = pTwigs;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int length = random.nextIntBetweenInclusive(2, 4);
        int offset = 2;

        this.placeLog(level, origin, Direction.Axis.Y);
        this.placeDead(level, origin.above(), Direction.Axis.Y);

        this.placeTwigs(level, origin.relative(direction), 4);
        this.placeTwigs(level, origin.relative(direction).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 2), 4);
        this.placeTwigs(level, origin.relative(direction, 2).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 2).relative(direction.getCounterClockWise()), 4);

        this.placeHerb(level, origin.relative(direction), 16);
        this.placeHerb(level, origin.relative(direction).relative(direction.getClockWise()), 16);
        this.placeHerb(level, origin.relative(direction).relative(direction.getCounterClockWise()), 164);
        this.placeHerb(level, origin.relative(direction, 2), 16);
        this.placeHerb(level, origin.relative(direction, 2).relative(direction.getClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 2).relative(direction.getCounterClockWise()), 16);

        for (int i = 1; i <= length; ++i) {
            ++offset;
            this.placeDead(level, origin.relative(direction, offset), direction.getAxis());
        }

        this.placeTwigs(level, origin.relative(direction, 7), 4);
        this.placeTwigs(level, origin.relative(direction, 7).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 7).relative(direction.getClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 7).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 7).relative(direction.getCounterClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 8), 4);
        this.placeTwigs(level, origin.relative(direction, 8).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 8).relative(direction.getClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 8).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 8).relative(direction.getCounterClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 9), 4);
        this.placeTwigs(level, origin.relative(direction, 9).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 9).relative(direction.getClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 9).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 9).relative(direction.getCounterClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 10), 4);
        this.placeTwigs(level, origin.relative(direction, 10).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 10).relative(direction.getClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 10).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 10).relative(direction.getCounterClockWise(), 2), 4);

        this.placeHerb(level, origin.relative(direction, 7), 16);
        this.placeHerb(level, origin.relative(direction, 7).relative(direction.getClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 7).relative(direction.getClockWise(), 2), 16);
        this.placeHerb(level, origin.relative(direction, 7).relative(direction.getCounterClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 7).relative(direction.getCounterClockWise(), 2), 16);
        this.placeHerb(level, origin.relative(direction, 8), 16);
        this.placeHerb(level, origin.relative(direction, 8).relative(direction.getClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 8).relative(direction.getClockWise(), 2), 16);
        this.placeHerb(level, origin.relative(direction, 8).relative(direction.getCounterClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 8).relative(direction.getCounterClockWise(), 2), 16);
        this.placeHerb(level, origin.relative(direction, 9), 16);
        this.placeHerb(level, origin.relative(direction, 9).relative(direction.getClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 9).relative(direction.getClockWise(), 2), 16);
        this.placeHerb(level, origin.relative(direction, 9).relative(direction.getCounterClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 9).relative(direction.getCounterClockWise(), 2), 16);
        this.placeHerb(level, origin.relative(direction, 10), 16);
        this.placeHerb(level, origin.relative(direction, 10).relative(direction.getClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 10).relative(direction.getClockWise(), 2), 16);
        this.placeHerb(level, origin.relative(direction, 10).relative(direction.getCounterClockWise()), 16);
        this.placeHerb(level, origin.relative(direction, 10).relative(direction.getCounterClockWise(), 2), 16);

        return true;
    }

    public void placeDead(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeDead(pLevel, pPos, pAxis);
        }
    }

    public void placeDead(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis) {
        if (pLevel.getBlockState(pPos).canBeReplaced() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, this.dead.defaultBlockState().setValue(RotatedPillarBlock.AXIS, pAxis));
        }
    }

    public void placeHerb(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeHerb(pLevel, pPos);
        }
    }

    public void placeHerb(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).canBeReplaced() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, this.herb.defaultBlockState());
        }
    }

    public void placeLog(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeLog(pLevel, pPos, pAxis);
        }
    }

    public void placeLog(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis) {
        if (pLevel.getBlockState(pPos).canBeReplaced() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, this.log.defaultBlockState().setValue(RotatedPillarBlock.AXIS, pAxis));
        }
    }

    public void placeTwigs(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeTwigs(pLevel, pPos);
        }
    }

    public void placeTwigs(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).canBeReplaced() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, this.twigs.defaultBlockState());
        }
    }
}
