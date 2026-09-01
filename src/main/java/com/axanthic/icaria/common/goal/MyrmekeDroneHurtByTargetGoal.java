package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.MyrmekeDroneEntity;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeDroneHurtByTargetGoal extends MyrmekeQueenHurtByTargetGoal {
	public MyrmekeDroneHurtByTargetGoal(MyrmekeDroneEntity pEntity) {
		super(pEntity);
	}

	@Override
	public void alertOther(Mob pMob, LivingEntity pLivingEntity) {
		if (pMob instanceof MyrmekeSoldierEntity) {
			pMob.setTarget(pLivingEntity);
		}
	}
}
