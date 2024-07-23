package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.MyrmekeDroneEntity;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeDroneHurtByTargetGoal extends MyrmekeQueenHurtByTargetGoal {
	public MyrmekeDroneHurtByTargetGoal(MyrmekeDroneEntity pEntity) {
		super(pEntity);
	}

	@Override
	public void alertOther(Mob pMob, LivingEntity pTarget) {
		if (pMob instanceof MyrmekeSoldierEntity) {
			pMob.setTarget(pTarget);
		}
	}
}
