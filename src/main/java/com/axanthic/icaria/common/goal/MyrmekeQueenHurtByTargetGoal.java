package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.MyrmekeDroneEntity;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenHurtByTargetGoal extends HurtByTargetGoal {
	public MyrmekeQueenHurtByTargetGoal(MyrmekeQueenEntity pEntity) {
		super(pEntity);
	}

	@Override
	public void alertOther(Mob pMob, LivingEntity pTarget) {
		if (pMob instanceof MyrmekeDroneEntity) {
			pMob.setTarget(pTarget);
		}
	}
}
