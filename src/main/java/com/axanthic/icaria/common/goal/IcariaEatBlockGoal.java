package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.event.EventHooks;

import java.util.EnumSet;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaEatBlockGoal extends Goal {
    public int eatAnimationTick;

    public IcariaAnimalEntity entity;

    public Level level;

    public IcariaEatBlockGoal(IcariaAnimalEntity pEntity) {
        this.entity = pEntity;
        this.level = pEntity.level();
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    @Override
    public boolean canContinueToUse() {
        return this.eatAnimationTick > 0;
    }

    @Override
    public boolean canUse() {
        var blockPos = this.entity.blockPosition();
        if (this.entity.getRandom().nextInt(this.entity.isBaby() ? 50 : 1000) != 0) {
            return false;
        } else {
            if (this.level.getBlockState(blockPos).is(IcariaBlockTags.ICARIA_GRASS_BLOCKS)) {
                return true;
            } else {
                return this.level.getBlockState(blockPos.below()).is(IcariaBlocks.GRASSY_MARL.get());
            }
        }
    }

    public int getEatAnimationTick() {
        return this.eatAnimationTick;
    }

    @Override
    public void start() {
        this.eatAnimationTick = this.adjustedTickDelay(40);
        this.level.broadcastEntityEvent(this.entity, (byte) 10);
        this.entity.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.eatAnimationTick = 0;
    }

    @Override
    public void tick() {
        this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        if (this.eatAnimationTick == this.adjustedTickDelay(4)) {
            var blockPos = this.entity.blockPosition();
            if (this.level.getBlockState(blockPos).is(IcariaBlockTags.ICARIA_GRASS_BLOCKS)) {
                if (EventHooks.getMobGriefingEvent(this.level, this.entity)) {
                    this.level.destroyBlock(blockPos, false);
                }

                this.entity.ate();
            } else {
                var belowPos = blockPos.below();
                if (this.level.getBlockState(belowPos).is(IcariaBlocks.GRASSY_MARL.get())) {
                    if (EventHooks.getMobGriefingEvent(this.level, this.entity)) {
                        this.level.levelEvent(2001, belowPos, Block.getId(IcariaBlocks.GRASSY_MARL.get().defaultBlockState()));
                        this.level.setBlock(belowPos, IcariaBlocks.MARL.get().defaultBlockState(), 2);
                    }

                    this.entity.ate();
                }
            }
        }
    }
}
