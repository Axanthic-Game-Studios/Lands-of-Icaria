package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAnimalHurtByTargetGoal extends HurtByTargetGoal {
	public double speedModifier;

	public IcariaAnimalHurtByTargetGoal(IcariaAnimalEntity pMob, double pSpeedModifier) {
		super(pMob);
		this.speedModifier = pSpeedModifier;
	}

	@Override
	public void alertOther(Mob pMob, LivingEntity pTarget) {
		if (pMob instanceof IcariaAnimalEntity) {
			double random = pTarget.getRandom().nextInt(16) - 8;
			pMob.getNavigation().moveTo(pTarget.getX() + random, 0.0D, pTarget.getZ() + random, this.speedModifier);
		}
	}
}
