package com.axanthic.icaria.common.world.feature.dead;

import com.axanthic.icaria.common.properties.Moss;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDeadTreeFeature extends Feature<NoneFeatureConfiguration> {
    public Block dead;
    public Block log;
    public Block moss;
    public Block twigs;

    public Moss property;

    public IcariaDeadTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pDead, Block pLog, Block pMoss, Block pTwigs, Moss pProperty) {
        super(pCodec);
        this.dead = pDead;
        this.log = pLog;
        this.moss = pMoss;
        this.twigs = pTwigs;
        this.property = pProperty;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int length = random.nextIntBetweenInclusive(2, 4);
        int offset = 2;

        this.placeMoss(level, origin.relative(direction, -2), 1, 4);
        this.placeMoss(level, origin.relative(direction, -2).relative(direction.getClockWise(), 1), 1, 4);
        this.placeMoss(level, origin.relative(direction, -2).relative(direction.getClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, -2).relative(direction.getCounterClockWise(), 1), 1, 4);
        this.placeMoss(level, origin.relative(direction, -2).relative(direction.getCounterClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, -1), 2, 4);
        this.placeMoss(level, origin.relative(direction, -1).relative(direction.getClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, -1).relative(direction.getClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, -1).relative(direction.getCounterClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, -1).relative(direction.getCounterClockWise(), 2), 1, 4);

        this.placeLog(level, origin, Direction.Axis.Y);

        this.placeDead(level, origin.above(), Direction.Axis.Y);

        this.placeMoss(level, origin.relative(direction.getClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction.getClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction.getCounterClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction.getCounterClockWise(), 2), 1, 4);

        this.placeMoss(level, origin.relative(direction, 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, 1).relative(direction.getClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, 1).relative(direction.getClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, 1).relative(direction.getCounterClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, 1).relative(direction.getCounterClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, 2), 2, 4);
        this.placeMoss(level, origin.relative(direction, 2).relative(direction.getClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, 2).relative(direction.getClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, 2).relative(direction.getCounterClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, 2).relative(direction.getCounterClockWise(), 2), 1, 4);

        this.placeTwigs(level, origin.relative(direction), 4);
        this.placeTwigs(level, origin.relative(direction).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 2), 4);
        this.placeTwigs(level, origin.relative(direction, 2).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 2).relative(direction.getCounterClockWise()), 4);

        for (int i = 1; i <= length; ++i) {
            ++offset;
            this.placeDead(level, origin.relative(direction, offset), direction.getAxis());
            this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 1), 2, 4);
            this.placeMoss(level, origin.relative(direction, offset).relative(direction.getClockWise(), 2), 1, 4);
            this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 1), 2, 4);
            this.placeMoss(level, origin.relative(direction, offset).relative(direction.getCounterClockWise(), 2), 1, 4);
        }

        this.placeMoss(level, origin.relative(direction, 3 + length), 2, 4);
        this.placeMoss(level, origin.relative(direction, 3 + length).relative(direction.getClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, 3 + length).relative(direction.getClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, 3 + length).relative(direction.getCounterClockWise(), 1), 2, 4);
        this.placeMoss(level, origin.relative(direction, 3 + length).relative(direction.getCounterClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, 4 + length), 1, 4);
        this.placeMoss(level, origin.relative(direction, 4 + length).relative(direction.getClockWise(), 1), 1, 4);
        this.placeMoss(level, origin.relative(direction, 4 + length).relative(direction.getClockWise(), 2), 1, 4);
        this.placeMoss(level, origin.relative(direction, 4 + length).relative(direction.getCounterClockWise(), 1), 1, 4);
        this.placeMoss(level, origin.relative(direction, 4 + length).relative(direction.getCounterClockWise(), 2), 1, 4);

        this.placeTwigs(level, origin.relative(direction, 3 + length), 4);
        this.placeTwigs(level, origin.relative(direction, 3 + length).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 3 + length).relative(direction.getClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 3 + length).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 3 + length).relative(direction.getCounterClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 4 + length), 4);
        this.placeTwigs(level, origin.relative(direction, 4 + length).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 4 + length).relative(direction.getClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 4 + length).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 4 + length).relative(direction.getCounterClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 5 + length), 4);
        this.placeTwigs(level, origin.relative(direction, 5 + length).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 5 + length).relative(direction.getClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 5 + length).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 5 + length).relative(direction.getCounterClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 6 + length), 4);
        this.placeTwigs(level, origin.relative(direction, 6 + length).relative(direction.getClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 6 + length).relative(direction.getClockWise(), 2), 4);
        this.placeTwigs(level, origin.relative(direction, 6 + length).relative(direction.getCounterClockWise()), 4);
        this.placeTwigs(level, origin.relative(direction, 6 + length).relative(direction.getCounterClockWise(), 2), 4);

        return true;
    }

    public void placeDead(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeDead(pLevel, pPos, pAxis);
        }
    }

    public void placeDead(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis) {
        if (pLevel.getBlockState(pPos).isAir() && (pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT) || pLevel.getBlockState(pPos.below()).is(BlockTags.LOGS))) {
            this.setBlock(pLevel, pPos, this.dead.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
        }
    }

    public void placeLog(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeLog(pLevel, pPos, pAxis);
        }
    }

    public void placeLog(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT)) {
            this.setBlock(pLevel, pPos, this.log.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
        }
    }

    public void placeMoss(WorldGenLevel pLevel, BlockPos pPos, int pHeight, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeMoss(pLevel, pPos, pHeight);
        }
    }

    public void placeMoss(WorldGenLevel pLevel, BlockPos pPos, int pHeight) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT) && this.moss.defaultBlockState().hasProperty(BlockStateProperties.LAYERS)) {
            this.setBlock(pLevel, pPos, this.moss.defaultBlockState().setValue(BlockStateProperties.LAYERS, pHeight));
            if (pLevel.getBlockState(pPos.below()).is(IcariaBlocks.GRASSY_MARL.get())) {
                this.setBlock(pLevel, pPos.below(), IcariaBlocks.GRASSY_MARL.get().defaultBlockState().setValue(IcariaBlockStateProperties.MOSS, this.property));
            }
        }
    }

    public void placeTwigs(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeTwigs(pLevel, pPos);
        }
    }

    public void placeTwigs(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT)) {
            this.setBlock(pLevel, pPos, this.twigs.defaultBlockState());
        }
    }
}
