package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierHurtByTargetGoal extends MyrmekeDroneHurtByTargetGoal {
	public MyrmekeSoldierHurtByTargetGoal(MyrmekeSoldierEntity pEntity) {
		super(pEntity);
	}
}
