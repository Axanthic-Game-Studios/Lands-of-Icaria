package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.IcariaBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.event.ForgeEventFactory;

import java.util.EnumSet;

public class IcariaEatBlockGoal extends Goal {
    public int eatAnimationTick;

    public final Level level;
    public final Mob mob;

    public IcariaEatBlockGoal(Mob pMob) {
        this.level = pMob.level;
        this.mob = pMob;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    @Override
    public boolean canContinueToUse() {
        return this.eatAnimationTick > 0;
    }

    @Override
    public boolean canUse() {
        BlockPos blockPos = this.mob.blockPosition();

        if (this.mob.getRandom().nextInt(this.mob.isBaby() ? 50 : 1000) != 0) {
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
        this.level.broadcastEntityEvent(this.mob, (byte)10);
        this.mob.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.eatAnimationTick = 0;
    }

    @Override
    public void tick() {
        this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        if (this.eatAnimationTick == this.adjustedTickDelay(4)) {
            BlockPos blockPos = this.mob.blockPosition();
            if (this.level.getBlockState(blockPos).is(IcariaBlockTags.ICARIA_GRASS_BLOCKS)) {
                if (ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
                    this.level.destroyBlock(blockPos, false);
                }

                this.mob.ate();
            } else {
                BlockPos below = blockPos.below();
                if (this.level.getBlockState(below).is(IcariaBlocks.MARL_GRASS.get())) {
                    if (ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
                        this.level.levelEvent(2001, below, Block.getId(IcariaBlocks.MARL_GRASS.get().defaultBlockState()));
                        this.level.setBlock(below, IcariaBlocks.MARL.get().defaultBlockState(), 2);
                    }

                    this.mob.ate();
                }
            }
        }
    }
}
