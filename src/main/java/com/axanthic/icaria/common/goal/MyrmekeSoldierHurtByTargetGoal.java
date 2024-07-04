package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierHurtByTargetGoal extends MyrmekeDroneHurtByTargetGoal {
    public MyrmekeSoldierHurtByTargetGoal(MyrmekeSoldierEntity pEntity) {
        super(pEntity);
    }
}
