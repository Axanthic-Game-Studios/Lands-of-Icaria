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

public class HorizontalRelicstonePillarFeature extends Feature<NoneFeatureConfiguration> {
    public HorizontalRelicstonePillarFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int length = random.nextIntBetweenInclusive(2, 4);
        int offset = 0;

        this.placeHead(level, origin, direction);

        for (int i = 1; i <= length; ++i) {
            ++offset;
            this.placePillar(level, origin.relative(direction, offset), direction);
        }

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
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.RELICSTONE_PILLAR_HEAD.get().defaultBlockState().setValue(DirectionalBlock.FACING, pDirection));
        }
    }

    public void placePillar(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placePillar(pLevel, pPos, pDirection);
        }
    }

    public void placePillar(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).isFaceSturdy(pLevel, pPos, Direction.UP)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.RELICSTONE_PILLAR.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, pDirection.getAxis()));
        }
    }
}
