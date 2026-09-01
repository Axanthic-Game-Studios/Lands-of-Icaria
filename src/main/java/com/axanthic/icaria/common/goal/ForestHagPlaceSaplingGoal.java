package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.ForestHagEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.event.EventHooks;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForestHagPlaceSaplingGoal extends Goal {
	public ForestHagEntity entity;

	public ForestHagPlaceSaplingGoal(ForestHagEntity pEntity) {
		this.entity = pEntity;
	}

	@Override
	public boolean canUse() {
		return this.entity.level() instanceof ServerLevel serverLevel && this.entity.getRandom().nextInt(5000) == 0 && !this.entity.isAggressive() && EventHooks.canEntityGrief(serverLevel, this.entity);
	}

	@Override
	public void tick() {
		var level = this.entity.level();
		var entityType = this.entity.getType();
		var blockPos = this.entity.blockPosition();
		var block = this.block(entityType);
		if (block.defaultBlockState().canSurvive(level, blockPos)) {
			if (level.getBlockState(blockPos).isAir()) {
				level.playSound(null, blockPos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS);
				level.setBlockAndUpdate(blockPos, block.defaultBlockState());
			}
		}
	}

	public Block block(EntityType<?> pEntityType) {
		if (pEntityType == IcariaEntityTypes.CYPRESS_FOREST_HAG.get()) {
			return IcariaBlocks.CYPRESS_SAPLING.get();
		} else if (pEntityType == IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get()) {
			return IcariaBlocks.DROUGHTROOT_SAPLING.get();
		} else if (pEntityType == IcariaEntityTypes.FIR_FOREST_HAG.get()) {
			return IcariaBlocks.FIR_SAPLING.get();
		} else if (pEntityType == IcariaEntityTypes.LAUREL_FOREST_HAG.get()) {
			return IcariaBlocks.LAUREL_SAPLING.get();
		} else if (pEntityType == IcariaEntityTypes.OLIVE_FOREST_HAG.get()) {
			return IcariaBlocks.OLIVE_SAPLING.get();
		} else if (pEntityType == IcariaEntityTypes.PLANE_FOREST_HAG.get()) {
			return IcariaBlocks.PLANE_SAPLING.get();
		} else {
			return IcariaBlocks.POPULUS_SAPLING.get();
		}
	}
}
