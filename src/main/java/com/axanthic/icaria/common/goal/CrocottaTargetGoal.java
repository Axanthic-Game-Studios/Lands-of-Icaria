package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.CrocottaEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrocottaTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
	public TargetingConditions targetingConditions = TargetingConditions.forCombat().range(16.0D);

	public CrocottaTargetGoal(Mob pMob, Class<T> pTargetType, boolean pMustSee, boolean pMustReach) {
		super(pMob, pTargetType, pMustSee, pMustReach);
	}

	@Override
	public boolean canUse() {
		var check = this.mob.level().getNearbyEntities(CrocottaEntity.class, this.targetingConditions, this.mob, this.mob.getBoundingBox().inflate(16.0D)).isEmpty();
		return super.canUse() && !check;
	}
}
