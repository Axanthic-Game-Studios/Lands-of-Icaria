package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.EnumSet;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBreedGoal extends Goal {
	public double speedModifier;

	public int loveTime;

	public Class<? extends IcariaAnimalEntity> partnerClass;

	public IcariaAnimalEntity entity;
	public IcariaAnimalEntity partner;

	public IcariaBreedGoal(IcariaAnimalEntity pEntity, double pSpeedModifier) {
		this(pEntity, pSpeedModifier, pEntity.getClass());
	}

	public IcariaBreedGoal(IcariaAnimalEntity pEntity, double pSpeedModifier, Class<? extends IcariaAnimalEntity> pPartnerClass) {
		this.entity = pEntity;
		this.speedModifier = pSpeedModifier;
		this.partnerClass = pPartnerClass;
		this.setFlags(EnumSet.of(Flag.LOOK, Flag.MOVE));
	}

	@Override
	public boolean canContinueToUse() {
		return this.partner.isAlive() && this.partner.onDuration() && this.loveTime < 60;
	}

	@Override
	public boolean canUse() {
		if (this.entity.onDuration()) {
			this.partner = this.getPartner();
			return this.partner != null;
		} else {
			return false;
		}
	}

	@Override
	public void stop() {
		this.loveTime = 0;
		this.partner = null;
	}

	@Override
	public void tick() {
		this.entity.getLookControl().setLookAt(this.partner, 10.0F, this.entity.getMaxHeadXRot());
		this.entity.getNavigation().moveTo(this.partner, this.speedModifier);
		this.loveTime++;
		if (this.loveTime >= 60) {
			if (this.entity.distanceToSqr(this.partner) <= 8.0D) {
				if (this.entity.level() instanceof ServerLevel serverLevel) {
					this.entity.spawnChildFromBreeding(this.partner, serverLevel);
				}
			}
		}
	}

	@Nullable
	public IcariaAnimalEntity getPartner() {
		if (this.entity.level() instanceof ServerLevel serverLevel) {
			for (var partner : serverLevel.getNearbyEntities(this.partnerClass, TargetingConditions.forNonCombat().range(8.0D), this.entity, this.entity.getBoundingBox().inflate(8.0D))) {
				if (this.entity.canMate(partner)) {
					if (this.entity.distanceToSqr(partner) <= 8.0D) {
						return partner;
					}
				}
			}
		}

		return null;
	}
}
