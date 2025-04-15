package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierHurtByTargetGoal extends MyrmekeDroneHurtByTargetGoal {
	public MyrmekeSoldierHurtByTargetGoal(MyrmekeSoldierEntity pEntity) {
		super(pEntity);
	}
}
