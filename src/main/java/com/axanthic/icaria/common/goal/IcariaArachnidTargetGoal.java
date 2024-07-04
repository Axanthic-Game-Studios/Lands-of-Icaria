package com.axanthic.icaria.common.goal;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArachnidTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
	public IcariaArachnidTargetGoal(Mob pMob, Class<T> pTargetType, boolean pMustSee, boolean pMustReach) {
		super(pMob, pTargetType, pMustSee, pMustReach);
	}

	@Override
	public boolean canUse() {
		var check = this.mob.getLightLevelDependentMagicValue() >= 0.5F;
		return super.canUse() && !check;
	}
}
