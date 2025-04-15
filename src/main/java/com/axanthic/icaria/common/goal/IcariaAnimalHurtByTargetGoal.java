package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAnimalHurtByTargetGoal extends HurtByTargetGoal {
	public double speedModifier;

	public IcariaAnimalHurtByTargetGoal(IcariaAnimalEntity pEntity, double pSpeedModifier) {
		super(pEntity);
		this.speedModifier = pSpeedModifier;
	}

	@Override
	public void alertOther(Mob pMob, LivingEntity pLivingEntity) {
		var randomSource = pLivingEntity.getRandom();
		if (pMob instanceof IcariaAnimalEntity) {
			pMob.getNavigation().moveTo(pLivingEntity.getX() + randomSource.nextInt(16) - 8, 0.0D, pLivingEntity.getZ() + randomSource.nextInt(16) - 8, this.speedModifier);
		}
	}
}
