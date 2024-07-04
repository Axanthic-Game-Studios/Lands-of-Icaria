package com.axanthic.icaria.common.world.feature.shrooms;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaGroundShroomsFeature extends Feature<NoneFeatureConfiguration> {
    public Block shrooms;

    public IcariaGroundShroomsFeature(Codec<NoneFeatureConfiguration> pCodec, Block pShrooms) {
        super(pCodec);
        this.shrooms = pShrooms;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int size = 2;

        for (int x = -size; x <= size; x++) {
            for (int y = -size; y <= size; y++) {
                for (int z = -size; z <= size; z++) {
                    this.placeShrooms(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
                }
            }
        }

        return true;
    }

    public void placeShrooms(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeShrooms(pLevel, pPos);
        }
    }

    public void placeShrooms(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT) && pLevel.getBrightness(LightLayer.BLOCK, pPos) <= 12) {
            this.setBlock(pLevel, pPos, this.shrooms.defaultBlockState());
        }
    }
}
