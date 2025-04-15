package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenSummonGoal extends Goal {
	public MyrmekeQueenEntity entity;

	public MyrmekeQueenSummonGoal(MyrmekeQueenEntity pEntity) {
		super();
		this.entity = pEntity;
	}

	@Override
	public boolean canUse() {
		return this.entity.level() instanceof ServerLevel serverLevel && serverLevel.getNearbyEntities(MyrmekeSoldierEntity.class, TargetingConditions.forNonCombat().ignoreInvisibilityTesting().ignoreLineOfSight().range(16.0D), this.entity, this.entity.getBoundingBox().inflate(16.0D)).size() <= 2;
	}

	@Override
	public void tick() {
		var randomSource = this.entity.getRandom();
		var level = this.entity.level();
		var entity = IcariaEntityTypes.MYRMEKE_SOLDIER.get().create(level, EntitySpawnReason.MOB_SUMMONED);
		var blockPos = this.entity.blockPosition().offset(randomSource.nextInt(8) - 4, 0, randomSource.nextInt(8) - 4);
		for (var i = 0; i < randomSource.nextIntBetweenInclusive(3, 4); ++i) {
			if (entity != null) {
				if (level.getBlockState(blockPos).canBeReplaced()) {
					if (this.entity.getBlockStateOn().is(IcariaBlockTagsProvider.SOILS)) {
						entity.moveTo(blockPos, 0.0F, 0.0F);
						level.addFreshEntity(entity);
					}
				}
			}
		}
	}
}
