package com.axanthic.icaria.common.world.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaTreeFeature extends Feature<NoneFeatureConfiguration> {
    public Block leaves;
    public Block log;
    public Block sapling;

    public IcariaTreeFeature(Codec<NoneFeatureConfiguration> pCodec, Block pLeaves, Block pLog, Block pSapling) {
        super(pCodec);
        this.leaves = pLeaves;
        this.log = pLog;
        this.sapling = pSapling;
    }

    public boolean isSoil(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var below = pContext.origin().below();
        var level = pContext.level();
        var state = level.getBlockState(below);
        return state.getBlock().canSustainPlant(state, level, below, Direction.UP, (SaplingBlock) this.sapling);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        return false;
    }

    public void placeLeaves(FeaturePlaceContext<NoneFeatureConfiguration> pContext, BlockPos pPos) {
        this.placeLeaves(pContext, pPos, 1);
    }

    public void placeLog(FeaturePlaceContext<NoneFeatureConfiguration> pContext, BlockPos pPos) {
        this.placeLog(pContext, pPos, Direction.Axis.Y);
    }

    public void placeLeaves(FeaturePlaceContext<NoneFeatureConfiguration> pContext, BlockPos pPos, int pChance) {
        var level = pContext.level();
        if (level.getBlockState(pPos).isAir() && level.getRandom().nextInt(pChance) == 0) {
            this.setBlock(level, pPos, this.leaves.defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
        }
    }

    public void placeLog(FeaturePlaceContext<NoneFeatureConfiguration> pContext, BlockPos pPos, Direction.Axis pAxis) {
        var level = pContext.level();
        if (level.getBlockState(pPos).canBeReplaced() || level.getBlockState(pPos).is(BlockTags.LEAVES)) {
            this.setBlock(level, pPos, this.log.defaultBlockState().setValue(RotatedPillarBlock.AXIS, pAxis));
        }
    }
}
