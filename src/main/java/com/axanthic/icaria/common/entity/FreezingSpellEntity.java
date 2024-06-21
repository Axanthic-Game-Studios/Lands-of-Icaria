package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.registry.IcariaMobEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class FreezingSpellEntity extends SpellEntity {
    public FreezingSpellEntity(EntityType<? extends SpellEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public boolean canSurvive(LevelReader pLevel, BlockPos pPos) {
        var belowPos = pPos.below();
        var blockState = pLevel.getBlockState(belowPos);
        if (blockState.is(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON)) {
            return false;
        } else if (blockState.is(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON)) {
            return true;
        } else {
            return Block.isFaceFull(blockState.getCollisionShape(pLevel, belowPos), Direction.UP) || blockState.is(Blocks.SNOW) && blockState.getValue(SnowLayerBlock.LAYERS) == 8;
        }
    }

    @Override
    public void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        var level = this.level();
        var blockPos = pResult.getBlockPos();
        var abovePos = blockPos.above();
        if (level.getBlockState(blockPos).is(Blocks.SNOW) && level.getBlockState(blockPos).getValue(SnowLayerBlock.LAYERS) < 8) {
            level.setBlockAndUpdate(blockPos, Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, Math.min(level.getBlockState(blockPos).getValue(SnowLayerBlock.LAYERS) + 1, 8)));
        } else if (level.getBlockState(abovePos).is(Blocks.SNOW) && level.getBlockState(abovePos).getValue(SnowLayerBlock.LAYERS) <= 2) {
            level.setBlockAndUpdate(abovePos, Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, 2));
        } else if (!level.getBlockState(abovePos).is(Blocks.SNOW) && level.getBlockState(abovePos).canBeReplaced() && this.canSurvive(level, abovePos)) {
            level.setBlockAndUpdate(abovePos, Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, 1));
        }
    }

    @Override
    public void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (pResult.getEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity.canFreeze()) {
                livingEntity.addEffect(new MobEffectInstance(IcariaMobEffects.FREEZING, 300));
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        var level = this.level();
        var blockPos = this.blockPosition();
        var blockState = level.getBlockState(blockPos);
        var fluidState = blockState.getFluidState();
        if (blockState.canBeReplaced() && fluidState.is(IcariaFluids.MEDITERRANEAN_WATER.get())) {
            level.setBlockAndUpdate(blockPos, IcariaBlocks.ARISTONE.get().defaultBlockState());
            this.discard();
        } else if (blockState.canBeReplaced() && fluidState.is(Fluids.WATER)) {
            level.setBlockAndUpdate(blockPos, Blocks.ICE.defaultBlockState());
            this.discard();
        }
    }
}
