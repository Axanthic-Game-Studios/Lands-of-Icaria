package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.JellyfishEntity;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.Goal;

public class JellyfishRandomMovementGoal extends Goal {
    public final JellyfishEntity entity;

    public JellyfishRandomMovementGoal(JellyfishEntity pEntity) {
        this.entity = pEntity;
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        if (this.entity.getNoActionTime() > 100) {
            this.entity.setMovementVector(0.0F, 0.0F, 0.0F);
        } else if (this.entity.getRandom().nextInt(reducedTickDelay(50)) == 0 || !this.entity.hasMovementVector()) {
            float random = this.entity.getRandom().nextFloat() * (Mth.PI * 2.0F);
            this.entity.setMovementVector(Mth.cos(random) * 0.2F, this.entity.getRandom().nextFloat() * 0.2F - 0.1F, Mth.sin(random) * 0.2F);
        }
    }
}
