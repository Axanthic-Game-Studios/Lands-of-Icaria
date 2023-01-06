package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.IcariaBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.event.ForgeEventFactory;

import java.util.EnumSet;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaEatBlockGoal extends Goal {
    public int eatAnimationTick;

    public IcariaAnimalEntity animal;
    public Level level;

    public IcariaEatBlockGoal(IcariaAnimalEntity pAnimal) {
        this.animal = pAnimal;
        this.level = pAnimal.level;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    @Override
    public boolean canContinueToUse() {
        return this.eatAnimationTick > 0;
    }

    @Override
    public boolean canUse() {
        BlockPos blockPos = this.animal.blockPosition();
        if (this.animal.getRandom().nextInt(this.animal.isBaby() ? 50 : 1000) != 0) {
            return false;
        } else {
            if (this.level.getBlockState(blockPos).is(IcariaBlockTags.ICARIA_GRASS_BLOCKS)) {
                return true;
            } else {
                return this.level.getBlockState(blockPos.below()).is(IcariaBlocks.MARL_GRASS.get());
            }
        }
    }

    public int getEatAnimationTick() {
        return this.eatAnimationTick;
    }

    @Override
    public void start() {
        this.eatAnimationTick = this.adjustedTickDelay(40);
        this.level.broadcastEntityEvent(this.animal, (byte) 10);
        this.animal.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.eatAnimationTick = 0;
    }

    @Override
    public void tick() {
        this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        if (this.eatAnimationTick == this.adjustedTickDelay(4)) {
            BlockPos blockPos = this.animal.blockPosition();
            if (this.level.getBlockState(blockPos).is(IcariaBlockTags.ICARIA_GRASS_BLOCKS)) {
                if (ForgeEventFactory.getMobGriefingEvent(this.level, this.animal)) {
                    this.level.destroyBlock(blockPos, false);
                }

                this.animal.ate();
            } else {
                BlockPos below = blockPos.below();
                if (this.level.getBlockState(below).is(IcariaBlocks.MARL_GRASS.get())) {
                    if (ForgeEventFactory.getMobGriefingEvent(this.level, this.animal)) {
                        this.level.levelEvent(2001, below, Block.getId(IcariaBlocks.MARL_GRASS.get().defaultBlockState()));
                        this.level.setBlock(below, IcariaBlocks.MARL.get().defaultBlockState(), 2);
                    }

                    this.animal.ate();
                }
            }
        }
    }
}
