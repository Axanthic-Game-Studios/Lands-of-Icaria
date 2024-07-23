package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBreedGoal extends Goal {
	public double speedModifier;

	public int loveTime;

	public Class<? extends IcariaAnimalEntity> partnerClass;

	public IcariaAnimalEntity entity;
	public IcariaAnimalEntity partner;

	public Level level;

	public static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();

	public IcariaBreedGoal(IcariaAnimalEntity pEntity, double pSpeedModifier) {
		this(pEntity, pSpeedModifier, pEntity.getClass());
	}

	public IcariaBreedGoal(IcariaAnimalEntity pEntity, double pSpeedModifier, Class<? extends IcariaAnimalEntity> pPartnerClass) {
		this.entity = pEntity;
		this.level = pEntity.level();
		this.partnerClass = pPartnerClass;
		this.speedModifier = pSpeedModifier;
		this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
	}

	@Override
	public boolean canContinueToUse() {
		return this.partner.isAlive() && this.partner.inLove() && this.loveTime < 60;
	}

	@Override
	public boolean canUse() {
		if (this.entity.inLove()) {
			this.partner = this.getFreePartner();
			return this.partner != null;
		} else {
			return false;
		}
	}

	public void breed() {
		this.entity.spawnChildFromBreeding((ServerLevel) this.level, this.partner);
	}

	@Override
	public void stop() {
		this.partner = null;
		this.loveTime = 0;
	}

	@Override
	public void tick() {
		this.entity.getLookControl().setLookAt(this.partner, 10.0F, this.entity.getMaxHeadXRot());
		this.entity.getNavigation().moveTo(this.partner, this.speedModifier);
		++this.loveTime;
		if (this.loveTime >= 60 && this.entity.distanceToSqr(this.partner) <= 8.0D) {
			this.breed();
		}
	}

	public @Nullable IcariaAnimalEntity getFreePartner() {
		double d = Double.MAX_VALUE;
		IcariaAnimalEntity entity = null;
		for (var partner : this.level.getNearbyEntities(this.partnerClass, IcariaBreedGoal.PARTNER_TARGETING, this.entity, this.entity.getBoundingBox().inflate(8.0D))) {
			if (this.entity.canMate(partner) && this.entity.distanceToSqr(partner) < d) {
				entity = partner;
				d = this.entity.distanceToSqr(partner);
			}
		}

		return entity;
	}
}
