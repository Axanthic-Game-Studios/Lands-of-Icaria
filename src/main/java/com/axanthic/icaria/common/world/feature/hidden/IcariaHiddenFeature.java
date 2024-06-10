package com.axanthic.icaria.common.world.feature.hidden;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation, unused")

@ParametersAreNonnullByDefault

public class IcariaHiddenFeature extends Feature<NoneFeatureConfiguration> {
    public Block hidden;
    public Block surface;

    public IcariaHiddenFeature(Codec<NoneFeatureConfiguration> pCodec, Block pHidden, Block pSurface) {
        super(pCodec);
        this.hidden = pHidden;
        this.surface = pSurface;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();

        this.placeHidden(level, origin.below(2));
        this.placeHidden(level, origin.below(2).north(), 4);
        this.placeHidden(level, origin.below(2).east(), 4);
        this.placeHidden(level, origin.below(2).south(), 4);
        this.placeHidden(level, origin.below(2).west(), 4);

        this.placeSurface(level, origin);

        return true;
    }

    public void placeHidden(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeHidden(pLevel, pPos);
        }
    }

    public void placeHidden(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos.above()).isSolid() && pLevel.getBlockState(pPos.below()).isSolid() && pLevel.getBlockState(pPos.north()).isSolid() && pLevel.getBlockState(pPos.east()).isSolid() && pLevel.getBlockState(pPos.south()).isSolid() && pLevel.getBlockState(pPos.west()).isSolid()) {
            this.setBlock(pLevel, pPos, this.hidden.defaultBlockState());
        }
    }

    public void placeSurface(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeSurface(pLevel, pPos);
        }
    }

    public void placeSurface(WorldGenLevel pLevel, BlockPos pPos) {
        if (pLevel.getBlockState(pPos).isAir()) {
            this.setBlock(pLevel, pPos, this.surface.defaultBlockState());
        }
    }
}
