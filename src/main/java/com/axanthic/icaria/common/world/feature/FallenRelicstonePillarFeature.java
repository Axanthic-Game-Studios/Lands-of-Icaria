package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class FallenRelicstonePillarFeature extends Feature<NoneFeatureConfiguration> {
    public FallenRelicstonePillarFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int length = random.nextIntBetweenInclusive(1, 3);
        int offset = 2;

        this.placeHead(level, origin, Direction.UP);
        this.placePillar(level, origin.above(), Direction.UP);

        for (int i = 1; i <= length; ++i) {
            ++offset;
            this.placePillar(level, origin.relative(direction, offset), direction);
        }

        this.placeRubble(level, origin.relative(direction), 4);
        this.placeRubble(level, origin.relative(direction).relative(direction.getClockWise()), 4);
        this.placeRubble(level, origin.relative(direction).relative(direction.getCounterClockWise()), 4);
        this.placeRubble(level, origin.relative(direction, 2), 4);
        this.placeRubble(level, origin.relative(direction, 2).relative(direction.getClockWise()), 4);
        this.placeRubble(level, origin.relative(direction, 2).relative(direction.getCounterClockWise()), 4);

        ++offset;
        this.placeHead(level, origin.relative(direction, offset), direction.getOpposite());

        return true;
    }

    public void placeHead(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeHead(pLevel, pPos, pDirection);
        }
    }

    public void placeHead(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection) {
        if (pLevel.getBlockState(pPos).canBeReplaced() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.RELICSTONE_PILLAR_HEAD.get().defaultBlockState().setValue(DirectionalBlock.FACING, pDirection));
        }
    }

    public void placePillar(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placePillar(pLevel, pPos, pDirection);
        }
    }

    public void placePillar(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection) {
        if (pLevel.getBlockState(pPos).canBeReplaced() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.RELICSTONE_PILLAR.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, pDirection.getAxis()));
        }
    }

    public void placeRubble(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeRubble(pLevel, pPos);
        }
    }

    public void placeRubble(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).canBeReplaced() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.RELICSTONE_RUBBLE.get().defaultBlockState());
        }
    }
}
