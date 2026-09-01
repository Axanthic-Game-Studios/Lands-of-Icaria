package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.CrocottaEntity;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrocottaTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
	public CrocottaTargetGoal(Mob pMob, Class<T> pTarget, boolean pMustSee, boolean pMustReach) {
		super(pMob, pTarget, pMustSee, pMustReach);
	}

	@Override
	public boolean canUse() {
		return super.canUse() && this.mob.level() instanceof ServerLevel serverLevel && !serverLevel.getNearbyEntities(CrocottaEntity.class, TargetingConditions.forCombat().range(16.0D), this.mob, this.mob.getBoundingBox().inflate(16.0D)).isEmpty();
	}
}
