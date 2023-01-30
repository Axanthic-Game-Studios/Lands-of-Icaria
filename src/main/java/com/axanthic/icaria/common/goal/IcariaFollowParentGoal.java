package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;

import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;

public class IcariaFollowParentGoal extends Goal {
    public double speedModifier;

    public int timeToRecalcPath;

    public IcariaAnimalEntity entity;
    public IcariaAnimalEntity parent;

    public IcariaFollowParentGoal(IcariaAnimalEntity pEntity, double pSpeedModifier) {
        this.entity = pEntity;
        this.speedModifier = pSpeedModifier;
    }

    @Override
    public boolean canContinueToUse() {
        if (!this.entity.isBaby()) {
            return false;
        } else if (!this.parent.isAlive()) {
            return false;
        } else {
            double d = this.entity.distanceToSqr(this.parent);
            return !(d <= 8.0D) && !(d >= 256.0D);
        }
    }

    @Override
    public boolean canUse() {
        if (!this.entity.isBaby()) {
            return false;
        } else {
            double d0 = Double.MAX_VALUE;
            IcariaAnimalEntity entity = null;
            List<? extends IcariaAnimalEntity> list = this.entity.level.getEntitiesOfClass(this.entity.getClass(), this.entity.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
            for (IcariaAnimalEntity parent : list) {
                if (!parent.isBaby()) {
                    double d1 = this.entity.distanceToSqr(parent);
                    if (!(d1 > d0)) {
                        d0 = d1;
                        entity = parent;
                    }
                }
            }

            if (entity == null) {
                return false;
            } else if (d0 <= 8.0D) {
                return false;
            } else {
                this.parent = entity;
                return true;
            }
        }
    }

    @Override
    public void start() {
        this.timeToRecalcPath = 0;
    }

    @Override
    public void stop() {
        this.parent = null;
    }

    @Override
    public void tick() {
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 10;
            this.entity.getNavigation().moveTo(this.parent, this.speedModifier);
        }
    }
}
