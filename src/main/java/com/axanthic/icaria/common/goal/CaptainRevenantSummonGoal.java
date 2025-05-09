package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.CaptainRevenantEntity;
import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.goal.Goal;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantSummonGoal extends Goal {
	public CaptainRevenantEntity entity;

	public CaptainRevenantSummonGoal(CaptainRevenantEntity pEntity) {
		super();
		this.entity = pEntity;
	}

	@Override
	public boolean canUse() {
		return !this.entity.onUnequips() && this.entity.onRallying() && this.entity.onReequips() && this.entity.level() instanceof ServerLevel serverLevel && this.entity.getLastHurtByPlayerTime() > 0 && serverLevel.getNearbyEntities(CrawlerRevenantEntity.class, this.entity.targetingConditions, this.entity, this.entity.getBoundingBox().inflate(16.0D)).size() <= 2;
	}

	@Override
	public void start() {
		this.entity.playSound(IcariaSoundEvents.CAPTAIN_REVENANT_RALLY);
	}

	@Override
	public void tick() {
		var randomSource = this.entity.getRandom();
		var level = this.entity.level();
		var entity = IcariaEntityTypes.CRAWLER_REVENANT.get().create(level, EntitySpawnReason.MOB_SUMMONED);
		var blockPos = this.entity.blockPosition().offset(randomSource.nextInt(16) - 8, 0, randomSource.nextInt(16) - 8);
		for (var i = 0; i < randomSource.nextIntBetweenInclusive(6, 8); ++i) {
			if (entity != null) {
				if (level.getBlockState(blockPos).canBeReplaced()) {
					if (level.getBlockState(blockPos.below()).is(IcariaBlockTagsProvider.SOILS)) {
						entity.moveTo(blockPos, 0.0F, 0.0F);
						level.addFreshEntity(entity);
					}
				}
			}
		}
	}
}
