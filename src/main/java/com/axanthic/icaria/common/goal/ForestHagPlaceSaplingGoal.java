package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.ForgeEventFactory;

public class ForestHagPlaceSaplingGoal extends Goal {
    public ForestHagEntity entity;

    public ForestHagPlaceSaplingGoal(ForestHagEntity pEntity) {
        this.entity = pEntity;
    }

    @Override
    public boolean canUse() {
        return this.entity.getRandom().nextInt(Goal.reducedTickDelay(5000)) == 0 && !this.entity.isAggressive() && ForgeEventFactory.getMobGriefingEvent(this.entity.level, this.entity);
    }

    @Override
    public void tick() {
        Block sapling = null;
        var level = this.entity.level;
        var blockPos = BlockPos.containing(this.entity.getX(), this.entity.getY(), this.entity.getZ());
        var belowPos = blockPos.below();
        if (this.entity.getType() == IcariaEntityTypes.CYPRESS_FOREST_HAG.get()) {
            sapling = IcariaBlocks.CYPRESS_SAPLING.get();
        } else if (this.entity.getType() == IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get()) {
            sapling = IcariaBlocks.DROUGHTROOT_SAPLING.get();
        } else if (this.entity.getType() == IcariaEntityTypes.FIR_FOREST_HAG.get()) {
            sapling = IcariaBlocks.FIR_SAPLING.get();
        } else if (this.entity.getType() == IcariaEntityTypes.LAUREL_FOREST_HAG.get()) {
            sapling = IcariaBlocks.LAUREL_SAPLING.get();
        } else if (this.entity.getType() == IcariaEntityTypes.OLIVE_FOREST_HAG.get()) {
            sapling = IcariaBlocks.OLIVE_SAPLING.get();
        } else if (this.entity.getType() == IcariaEntityTypes.PLANE_FOREST_HAG.get()) {
            sapling = IcariaBlocks.PLANE_SAPLING.get();
        } else if (this.entity.getType() == IcariaEntityTypes.POPULUS_FOREST_HAG.get()) {
            sapling = IcariaBlocks.POPULUS_SAPLING.get();
        }

        if (sapling != null) {
            if (level.getBlockState(blockPos).isAir() && level.getBlockState(belowPos).canSustainPlant(this.entity.level, belowPos, Direction.UP, (IPlantable) sapling)) {
                this.entity.level.playSound(null, this.entity, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                this.entity.level.setBlock(blockPos, sapling.defaultBlockState(), 2);
            }
        }
    }
}
