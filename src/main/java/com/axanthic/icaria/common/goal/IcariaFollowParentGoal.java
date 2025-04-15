package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.ai.goal.Goal;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFollowParentGoal extends Goal {
	public double speedModifier;

	public IcariaAnimalEntity entity;
	public IcariaAnimalEntity parent;

	public IcariaFollowParentGoal(IcariaAnimalEntity pEntity, double pSpeedModifier) {
		this.entity = pEntity;
		this.speedModifier = pSpeedModifier;
	}

	@Override
	public boolean canContinueToUse() {
		return this.parent.isAlive() && this.entity.isBaby() && this.entity.distanceToSqr(this.parent) <= 8.0D;
	}

	@Override
	public boolean canUse() {
		for (var parent : this.entity.level().getEntitiesOfClass(this.entity.getClass(), this.entity.getBoundingBox().inflate(8.0D, 8.0D, 8.0D))) {
			if (!parent.isBaby()) {
				if (this.entity.distanceToSqr(parent) <= 8.0D) {
					if (this.entity.isBaby()) {
						this.parent = parent;
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public void stop() {
		this.parent = null;
	}

	@Override
	public void tick() {
		this.entity.getNavigation().moveTo(this.parent, this.speedModifier);
	}
}
