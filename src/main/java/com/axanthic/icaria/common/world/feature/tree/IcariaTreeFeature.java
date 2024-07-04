package com.axanthic.icaria.common.world.feature.tree;

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

public class IcariaTreeFeature extends Feature<NoneFeatureConfiguration> {
    public Block fallen;
    public Block leaves;
    public Block log;
    public Block shrooms;
    public Block twigs;

    public IcariaTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pFallen, Block pLeaves, Block pLog, Block pShrooms, Block pTwigs) {
        super(pCodec);
        this.fallen = pFallen;
        this.leaves = pLeaves;
        this.log = pLog;
        this.shrooms = pShrooms;
        this.twigs = pTwigs;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        return true;
    }

    public void placeFallenPatch(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        this.placeFallen(pLevel, pPos.north(1), 1, pChance);
        this.placeFallen(pLevel, pPos.north(1).east(1), 1, pChance);
        this.placeFallen(pLevel, pPos.east(1), 1, pChance);
        this.placeFallen(pLevel, pPos.east(1).south(1), 1, pChance);
        this.placeFallen(pLevel, pPos.south(1), 1, pChance);
        this.placeFallen(pLevel, pPos.south(1).west(1), 1, pChance);
        this.placeFallen(pLevel, pPos.west(1), 1, pChance);
        this.placeFallen(pLevel, pPos.west(1).north(1), 1, pChance);

        this.placeFallen(pLevel, pPos.north(2), 2, pChance);
        this.placeFallen(pLevel, pPos.north(2).east(1), 2, pChance);
        this.placeFallen(pLevel, pPos.north(2).east(2), 1, pChance);
        this.placeFallen(pLevel, pPos.north(1).east(2), 2, pChance);
        this.placeFallen(pLevel, pPos.east(2), 2, pChance);
        this.placeFallen(pLevel, pPos.east(2).south(1), 2, pChance);
        this.placeFallen(pLevel, pPos.east(2).south(2), 1, pChance);
        this.placeFallen(pLevel, pPos.east(1).south(2), 2, pChance);
        this.placeFallen(pLevel, pPos.south(2), 2, pChance);
        this.placeFallen(pLevel, pPos.south(2).west(1), 2, pChance);
        this.placeFallen(pLevel, pPos.south(2).west(2), 1, pChance);
        this.placeFallen(pLevel, pPos.south(1).west(2), 2, pChance);
        this.placeFallen(pLevel, pPos.west(2), 2, pChance);
        this.placeFallen(pLevel, pPos.west(2).north(1), 2, pChance);
        this.placeFallen(pLevel, pPos.west(2).north(2), 1, pChance);
        this.placeFallen(pLevel, pPos.west(1).north(2), 2, pChance);

        this.placeFallen(pLevel, pPos.north(3), 1, pChance);
        this.placeFallen(pLevel, pPos.north(3).east(1), 1, pChance);
        this.placeFallen(pLevel, pPos.north(1).east(3), 1, pChance);
        this.placeFallen(pLevel, pPos.east(3), 1, pChance);
        this.placeFallen(pLevel, pPos.east(3).south(1), 1, pChance);
        this.placeFallen(pLevel, pPos.east(1).south(3), 1, pChance);
        this.placeFallen(pLevel, pPos.south(3), 1, pChance);
        this.placeFallen(pLevel, pPos.south(3).west(1), 1, pChance);
        this.placeFallen(pLevel, pPos.south(1).west(3), 1, pChance);
        this.placeFallen(pLevel, pPos.west(3), 1, pChance);
        this.placeFallen(pLevel, pPos.west(3).north(1), 1, pChance);
        this.placeFallen(pLevel, pPos.west(1).north(3), 1, pChance);
    }

    public void placeFallen(WorldGenLevel pLevel, BlockPos pPos, int pHeight, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeFallen(pLevel, pPos, pHeight);
        }
    }

    public void placeFallen(WorldGenLevel pLevel, BlockPos pPos, int pHeight) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT)) {
            this.setBlock(pLevel, pPos, this.fallen.defaultBlockState().setValue(BlockStateProperties.LAYERS, pHeight));
        }
    }

    public void placeLeaves(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeLeaves(pLevel, pPos);
        }
    }

    public void placeLeaves(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir()) {
            this.setBlock(pLevel, pPos, this.leaves.defaultBlockState().setValue(BlockStateProperties.DISTANCE, 1));
        }
    }

    public void placeLog(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeLog(pLevel, pPos, pAxis);
        }
    }

    public void placeLog(WorldGenLevel pLevel, BlockPos pPos, Direction.Axis pAxis) {
        if (pLevel.getBlockState(pPos).isAir() || pLevel.getBlockState(pPos).is(BlockTags.LEAVES)) {
            this.setBlock(pLevel, pPos, this.log.defaultBlockState().setValue(BlockStateProperties.AXIS, pAxis));
        }
    }

    public void placeShroomsPatch(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        this.placeShrooms(pLevel, pPos.north().above(1), Direction.NORTH, pChance);
        this.placeShrooms(pLevel, pPos.east().above(1), Direction.EAST, pChance);
        this.placeShrooms(pLevel, pPos.south().above(1), Direction.SOUTH, pChance);
        this.placeShrooms(pLevel, pPos.west().above(1), Direction.WEST, pChance);
        this.placeShrooms(pLevel, pPos.north().above(2), Direction.NORTH, pChance);
        this.placeShrooms(pLevel, pPos.east().above(2), Direction.EAST, pChance);
        this.placeShrooms(pLevel, pPos.south().above(2), Direction.SOUTH, pChance);
        this.placeShrooms(pLevel, pPos.west().above(2), Direction.WEST, pChance);
    }

    public void placeShrooms(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeShrooms(pLevel, pPos, pDirection);
        }
    }

    public void placeShrooms(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.relative(pDirection.getOpposite())).is(BlockTags.LOGS)) {
            this.setBlock(pLevel, pPos, this.shrooms.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pDirection));
        }
    }

    public void placeTwigsPatch(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        this.placeTwigs(pLevel, pPos.north(1), pChance);
        this.placeTwigs(pLevel, pPos.north(1).east(1), pChance);
        this.placeTwigs(pLevel, pPos.east(1), pChance);
        this.placeTwigs(pLevel, pPos.east(1).south(1), pChance);
        this.placeTwigs(pLevel, pPos.south(1), pChance);
        this.placeTwigs(pLevel, pPos.south(1).west(1), pChance);
        this.placeTwigs(pLevel, pPos.west(1), pChance);
        this.placeTwigs(pLevel, pPos.west(1).north(1), pChance);

        this.placeTwigs(pLevel, pPos.north(2), pChance);
        this.placeTwigs(pLevel, pPos.north(2).east(1), pChance);
        this.placeTwigs(pLevel, pPos.north(2).east(2), pChance);
        this.placeTwigs(pLevel, pPos.north(1).east(2), pChance);
        this.placeTwigs(pLevel, pPos.east(2), pChance);
        this.placeTwigs(pLevel, pPos.east(2).south(1), pChance);
        this.placeTwigs(pLevel, pPos.east(2).south(2), pChance);
        this.placeTwigs(pLevel, pPos.east(1).south(2), pChance);
        this.placeTwigs(pLevel, pPos.south(2), pChance);
        this.placeTwigs(pLevel, pPos.south(2).west(1), pChance);
        this.placeTwigs(pLevel, pPos.south(2).west(2), pChance);
        this.placeTwigs(pLevel, pPos.south(1).west(2), pChance);
        this.placeTwigs(pLevel, pPos.west(2), pChance);
        this.placeTwigs(pLevel, pPos.west(2).north(1), pChance);
        this.placeTwigs(pLevel, pPos.west(2).north(2), pChance);
        this.placeTwigs(pLevel, pPos.west(1).north(2), pChance);

        this.placeTwigs(pLevel, pPos.north(3), pChance);
        this.placeTwigs(pLevel, pPos.north(3).east(1), pChance);
        this.placeTwigs(pLevel, pPos.north(1).east(3), pChance);
        this.placeTwigs(pLevel, pPos.east(3), pChance);
        this.placeTwigs(pLevel, pPos.east(3).south(1), pChance);
        this.placeTwigs(pLevel, pPos.east(1).south(3), pChance);
        this.placeTwigs(pLevel, pPos.south(3), pChance);
        this.placeTwigs(pLevel, pPos.south(3).west(1), pChance);
        this.placeTwigs(pLevel, pPos.south(1).west(3), pChance);
        this.placeTwigs(pLevel, pPos.west(3), pChance);
        this.placeTwigs(pLevel, pPos.west(3).north(1), pChance);
        this.placeTwigs(pLevel, pPos.west(1).north(3), pChance);
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
