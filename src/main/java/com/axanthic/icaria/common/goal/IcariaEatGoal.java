package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;
import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;

import java.util.EnumSet;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.event.EventHooks;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEatGoal extends Goal {
	public int eatAnimationTick;

	public IcariaAnimalEntity entity;

	public Trough trough;

	public IcariaEatGoal(IcariaAnimalEntity pEntity, Trough pTrough) {
		this.entity = pEntity;
		this.trough = pTrough;
		this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.LOOK, Goal.Flag.MOVE));
	}

	@Override
	public boolean canContinueToUse() {
		return this.eatAnimationTick < 20;
	}

	@Override
	public boolean canUse() {
		var blockPos = this.entity.blockPosition();
		var direction = this.entity.getDirection();
		var level = this.entity.level();
		var trough = level.getBlockState(blockPos.relative(direction)).is(IcariaBlockTagsProvider.TROUGHS) && level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH) == this.trough && level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) > 0;
		var blocks = level.getBlockState(blockPos.below()).is(IcariaBlocks.GRASSY_MARL.get()) || level.getBlockState(blockPos).is(IcariaBlockTagsProvider.GRASS_BLOCKS);
		var check = blocks || trough;
		return this.entity.getRandom().nextInt(this.entity.isBaby() ? 50 : 1000) == 0 && check;
	}

	@Override
	public void start() {
		this.entity.getNavigation().stop();
		this.entity.level().broadcastEntityEvent(this.entity, (byte) 10);
	}

	@Override
	public void stop() {
		this.eatAnimationTick = 0;
	}

	@Override
	public void tick() {
		var blockPos = this.entity.blockPosition();
		var direction = this.entity.getDirection();
		var level = this.entity.level();
		this.eatAnimationTick++;
		if (this.eatAnimationTick == 16) {
			if (level instanceof ServerLevel serverLevel) {
				if (EventHooks.canEntityGrief(serverLevel, this.entity)) {
					if (level.getBlockState(blockPos).is(IcariaBlockTagsProvider.GRASS_BLOCKS)) {
						level.destroyBlock(blockPos, false);
						this.entity.ate();
					} else if (level.getBlockState(blockPos.below()).is(IcariaBlocks.GRASSY_MARL.get())) {
						level.levelEvent(2001, blockPos.below(), Block.getId(IcariaBlocks.MARL.get().defaultBlockState()));
						level.setBlockAndUpdate(blockPos.below(), IcariaBlocks.MARL.get().defaultBlockState());
						this.entity.ate();
					} else if (level.getBlockState(blockPos.relative(direction)).is(IcariaBlockTagsProvider.TROUGHS) && level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH) == this.trough && level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) > 1) {
						level.playSound(null, blockPos.relative(direction), IcariaSoundEvents.TROUGH_EMPTY, SoundSource.BLOCKS);
						level.setBlockAndUpdate(blockPos.relative(direction), level.getBlockState(blockPos.relative(direction)).setValue(IcariaBlockStateProperties.TROUGH, this.trough).setValue(IcariaBlockStateProperties.TROUGH_FILL, level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) - 1));
						this.entity.ate();
					} else if (level.getBlockState(blockPos.relative(direction)).is(IcariaBlockTagsProvider.TROUGHS) && level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH) == this.trough && level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) > 0) {
						level.playSound(null, blockPos.relative(direction), IcariaSoundEvents.TROUGH_EMPTY, SoundSource.BLOCKS);
						level.setBlockAndUpdate(blockPos.relative(direction), level.getBlockState(blockPos.relative(direction)).setValue(IcariaBlockStateProperties.TROUGH, Trough.NONE).setValue(IcariaBlockStateProperties.TROUGH_FILL, level.getBlockState(blockPos.relative(direction)).getValue(IcariaBlockStateProperties.TROUGH_FILL) - 1));
						this.entity.ate();
					}
				}
			}
		}
	}
}
