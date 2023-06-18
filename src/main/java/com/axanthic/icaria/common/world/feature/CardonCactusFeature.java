package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.block.CardonCactusBlock;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class CardonCactusFeature extends Feature<NoneFeatureConfiguration> {
    public CardonCactusFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        this.placeArm(level, origin, direction, 1, 2);
        this.placeArm(level, origin, direction.getClockWise(), 1, 2);
        this.placeArm(level, origin, direction.getOpposite(), 1, 2);
        this.placeArm(level, origin, direction.getCounterClockWise(), 1, 2);

        this.placeArm(level, origin, direction, 2, 8);
        this.placeArm(level, origin, direction.getClockWise(), 2, 8);
        this.placeArm(level, origin, direction.getOpposite(), 2, 8);
        this.placeArm(level, origin, direction.getCounterClockWise(), 2, 8);

        this.placeTrunk(level, origin, 0);
        this.placeTrunk(level, origin, 1);
        this.placeTrunk(level, origin, 2);
        this.placeTrunk(level, origin, 3);

        this.placeCactus(level, origin.above(4), IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(CardonCactusBlock.DOWN, true));

        return true;
    }

    public void placeArm(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pOffset, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeArm(pLevel, pPos, pDirection, pOffset);
        }
    }

    public void placeArm(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pOffset) {
        if (pLevel.getBlockState(pPos.above(pOffset).relative(pDirection)).isAir()) {
            this.placeCactus(pLevel, pPos.above(pOffset).relative(pDirection), IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(CardonCactusBlock.NORTH, pDirection.equals(Direction.SOUTH)).setValue(CardonCactusBlock.EAST, pDirection.equals(Direction.WEST)).setValue(CardonCactusBlock.SOUTH, pDirection.equals(Direction.NORTH)).setValue(CardonCactusBlock.WEST, pDirection.equals(Direction.EAST)).setValue(CardonCactusBlock.UP, true));
            this.placeCactus(pLevel, pPos.above(pOffset + 1).relative(pDirection), IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(CardonCactusBlock.DOWN, true));
        }
    }

    public void placeCactus(WorldGenLevel pLevel, BlockPos pPos, BlockState pState, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeCactus(pLevel, pPos, pState);
        }
    }

    public void placeCactus(WorldGenLevel pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel.getBlockState(pPos).isAir()) {
            this.setBlock(pLevel, pPos, pState);
        }
    }

    public void placeTrunk(WorldGenLevel pLevel, BlockPos pPos, int pOffset, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeTrunk(pLevel, pPos, pOffset);
        }
    }

    public void placeTrunk(WorldGenLevel pLevel, BlockPos pPos, int pOffset) {
        boolean north = pLevel.getBlockState(pPos.above(pOffset).north()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset + 1).north()).is(IcariaBlocks.CARDON_CACTUS.get());
        boolean east = pLevel.getBlockState(pPos.above(pOffset).east()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset + 1).east()).is(IcariaBlocks.CARDON_CACTUS.get());
        boolean south = pLevel.getBlockState(pPos.above(pOffset).south()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset + 1).south()).is(IcariaBlocks.CARDON_CACTUS.get());
        boolean west = pLevel.getBlockState(pPos.above(pOffset).west()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset + 1).west()).is(IcariaBlocks.CARDON_CACTUS.get());

        this.placeCactus(pLevel, pPos.above(pOffset), IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(CardonCactusBlock.NORTH, north).setValue(CardonCactusBlock.EAST, east).setValue(CardonCactusBlock.SOUTH, south).setValue(CardonCactusBlock.WEST, west).setValue(CardonCactusBlock.UP, true).setValue(CardonCactusBlock.DOWN, true));
    }
}
