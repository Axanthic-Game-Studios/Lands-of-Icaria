package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.Goal;

import net.neoforged.neoforge.event.EventHooks;

public class ForestHagPlaceSaplingGoal extends Goal {
    public ForestHagEntity entity;

    public ForestHagPlaceSaplingGoal(ForestHagEntity pEntity) {
        this.entity = pEntity;
    }

    @Override
    public boolean canUse() {
        return this.entity.getRandom().nextInt(Goal.reducedTickDelay(5000)) == 0 && !this.entity.isAggressive() && EventHooks.canEntityGrief(this.entity.level(), this.entity);
    }

    @Override
    public void tick() {
        var blockPos = this.entity.blockPosition();
        var level = this.entity.level();
        var type = this.entity.getType();
        var block = IcariaBlocks.CYPRESS_SAPLING.get();
        if (type == IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get()) {
            block = IcariaBlocks.DROUGHTROOT_SAPLING.get();
        } else if (type == IcariaEntityTypes.FIR_FOREST_HAG.get()) {
            block = IcariaBlocks.FIR_SAPLING.get();
        } else if (type == IcariaEntityTypes.LAUREL_FOREST_HAG.get()) {
            block = IcariaBlocks.LAUREL_SAPLING.get();
        } else if (type == IcariaEntityTypes.OLIVE_FOREST_HAG.get()) {
            block = IcariaBlocks.OLIVE_SAPLING.get();
        } else if (type == IcariaEntityTypes.PLANE_FOREST_HAG.get()) {
            block = IcariaBlocks.PLANE_SAPLING.get();
        } else if (type == IcariaEntityTypes.POPULUS_FOREST_HAG.get()) {
            block = IcariaBlocks.POPULUS_SAPLING.get();
        }

        if (level.getBlockState(blockPos).isAir() && block.defaultBlockState().canSurvive(level, blockPos.below())) {
            level.playSound(null, blockPos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS);
            level.setBlockAndUpdate(blockPos, block.defaultBlockState());
        }
    }
}
