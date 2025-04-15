package com.axanthic.icaria.common.goal;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArachnidTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
	public IcariaArachnidTargetGoal(Mob pMob, Class<T> pTarget, boolean pMustSee, boolean pMustReach) {
		super(pMob, pTarget, pMustSee, pMustReach);
	}

	@Override
	public boolean canUse() {
		return super.canUse() && this.mob.getLightLevelDependentMagicValue() < 0.5F;
	}
}
