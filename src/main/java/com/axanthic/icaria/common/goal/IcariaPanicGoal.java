package com.axanthic.icaria.common.goal;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.PanicGoal;

public class IcariaPanicGoal extends PanicGoal {
    public IcariaPanicGoal(PathfinderMob pMob, double pSpeedModifier) {
        super(pMob, pSpeedModifier);
    }

    @Override
    public boolean shouldPanic() {
        return this.mob.isOnFire();
    }
}
