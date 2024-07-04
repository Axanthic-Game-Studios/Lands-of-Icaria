package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
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

        this.placeCactus(level, origin.above(4), IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(BlockStateProperties.DOWN, true));

        return true;
    }

    public void placeArm(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pOffset, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeArm(pLevel, pPos, pDirection, pOffset);
        }
    }

    public void placeArm(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pOffset) {
        var posOx = pPos.above(pOffset).relative(pDirection);
        var posOy = pPos.above(pOffset + 1).relative(pDirection);
        var check = pLevel.getBlockState(posOx.below()).is(BlockTags.SAND);

        if (pLevel.getBlockState(posOx).isAir() && pLevel.getBlockState(posOy).isAir()) {
            this.placeCactus(pLevel, posOx, IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(BlockStateProperties.UP, true).setValue(BlockStateProperties.DOWN, check).setValue(BlockStateProperties.NORTH, pDirection.equals(Direction.SOUTH) && !check).setValue(BlockStateProperties.EAST, pDirection.equals(Direction.WEST) && !check).setValue(BlockStateProperties.SOUTH, pDirection.equals(Direction.NORTH) && !check).setValue(BlockStateProperties.WEST, pDirection.equals(Direction.EAST) && !check));
            this.placeCactus(pLevel, posOy, IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(BlockStateProperties.DOWN, true));
        }
    }

    public void placeTrunk(WorldGenLevel pLevel, BlockPos pPos, int pOffset, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeTrunk(pLevel, pPos, pOffset);
        }
    }

    public void placeTrunk(WorldGenLevel pLevel, BlockPos pPos, int pOffset) {
        var checkN = !pLevel.getBlockState(pPos.above(pOffset).below()).is(BlockTags.SAND) && !pLevel.getBlockState(pPos.above(pOffset).below()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset).north()).is(IcariaBlocks.CARDON_CACTUS.get());
        var checkBelowN = !pLevel.getBlockState(pPos.above(pOffset).below().north()).is(BlockTags.SAND) && !pLevel.getBlockState(pPos.above(pOffset).below().north()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset).north()).is(IcariaBlocks.CARDON_CACTUS.get());
        var checkE = !pLevel.getBlockState(pPos.above(pOffset).below()).is(BlockTags.SAND) && !pLevel.getBlockState(pPos.above(pOffset).below()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset).east()).is(IcariaBlocks.CARDON_CACTUS.get());
        var checkBelowE = !pLevel.getBlockState(pPos.above(pOffset).below().east()).is(BlockTags.SAND) && !pLevel.getBlockState(pPos.above(pOffset).below().east()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset).east()).is(IcariaBlocks.CARDON_CACTUS.get());
        var checkS = !pLevel.getBlockState(pPos.above(pOffset).below().south()).is(BlockTags.SAND) && !pLevel.getBlockState(pPos.above(pOffset).below().south()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset).south()).is(IcariaBlocks.CARDON_CACTUS.get());
        var checkBelowS = !pLevel.getBlockState(pPos.above(pOffset).below()).is(BlockTags.SAND) && !pLevel.getBlockState(pPos.above(pOffset).below()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset).south()).is(IcariaBlocks.CARDON_CACTUS.get());
        var checkW = !pLevel.getBlockState(pPos.above(pOffset).below().west()).is(BlockTags.SAND) && !pLevel.getBlockState(pPos.above(pOffset).below().west()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset).west()).is(IcariaBlocks.CARDON_CACTUS.get());
        var checkBelowW = !pLevel.getBlockState(pPos.above(pOffset).below()).is(BlockTags.SAND) && !pLevel.getBlockState(pPos.above(pOffset).below()).is(IcariaBlocks.CARDON_CACTUS.get()) && pLevel.getBlockState(pPos.above(pOffset).west()).is(IcariaBlocks.CARDON_CACTUS.get());

        this.placeCactus(pLevel, pPos.above(pOffset), IcariaBlocks.CARDON_CACTUS.get().defaultBlockState().setValue(BlockStateProperties.UP, true).setValue(BlockStateProperties.DOWN, true).setValue(BlockStateProperties.NORTH, checkN || checkBelowN).setValue(BlockStateProperties.EAST, checkE || checkBelowE).setValue(BlockStateProperties.SOUTH, checkS || checkBelowS).setValue(BlockStateProperties.WEST, checkW || checkBelowW));
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
}
