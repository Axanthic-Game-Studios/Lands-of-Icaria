package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;
import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.event.EventHooks;

import java.util.EnumSet;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEatGoal extends Goal {
	public int eatAnimationTick;

	public IcariaAnimalEntity entity;

	public Level level;

	public Trough trough;

	public IcariaEatGoal(IcariaAnimalEntity pEntity, Trough pTrough) {
		this.entity = pEntity;
		this.level = pEntity.level();
		this.trough = pTrough;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
	}

	@Override
	public boolean canContinueToUse() {
		return this.eatAnimationTick > 0;
	}

	@Override
	public boolean canUse() {
		var blockPos = this.entity.blockPosition();
		var direction = this.entity.getDirection();
		var checkTrough = this.level.getBlockState(blockPos.relative(direction)).is(IcariaBlockTags.TROUGHS) && this.level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH) == this.trough && this.level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) > 0;
		var checkBlocks = this.level.getBlockState(blockPos.below()).is(IcariaBlocks.GRASSY_MARL.get()) || this.level.getBlockState(blockPos).is(IcariaBlockTags.GRASS_BLOCKS) || checkTrough;
		return this.entity.getRandom().nextInt(this.entity.isBaby() ? 50 : 1000) == 0 && checkBlocks;
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
		var blockPos = this.entity.blockPosition();
		var direction = this.entity.getDirection();
		if (EventHooks.canEntityGrief(this.level, this.entity)) {
			if (this.eatAnimationTick == this.adjustedTickDelay(4)) {
				if (this.level.getBlockState(blockPos).is(IcariaBlockTags.GRASS_BLOCKS)) {
					this.entity.ate();
					this.level.destroyBlock(blockPos, false);
				} else if (this.level.getBlockState(blockPos.below()).is(IcariaBlocks.GRASSY_MARL.get())) {
					this.entity.ate();
					this.level.levelEvent(2001, blockPos.below(), Block.getId(IcariaBlocks.MARL.get().defaultBlockState()));
					this.level.setBlockAndUpdate(blockPos.below(), IcariaBlocks.MARL.get().defaultBlockState());
				} else if (this.level.getBlockState(blockPos.relative(direction)).is(IcariaBlockTags.TROUGHS) && this.level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH) == this.trough) {
					if (this.level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) > 1) {
						this.entity.ate();
						this.level.playSound(null, blockPos.relative(direction), IcariaSoundEvents.TROUGH_EMPTY, SoundSource.BLOCKS);
						this.level.setBlockAndUpdate(blockPos.relative(direction), this.level.getBlockState(blockPos.relative(direction)).setValue(IcariaBlockStateProperties.TROUGH, this.trough).setValue(IcariaBlockStateProperties.TROUGH_FILL, this.level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) - 1));
					} else if (this.level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) > 0) {
						this.entity.ate();
						this.level.playSound(null, blockPos.relative(direction), IcariaSoundEvents.TROUGH_EMPTY, SoundSource.BLOCKS);
						this.level.setBlockAndUpdate(blockPos.relative(direction), this.level.getBlockState(blockPos.relative(direction)).setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, this.level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) - 1));
					}
				}
			}
		}
	}
}
