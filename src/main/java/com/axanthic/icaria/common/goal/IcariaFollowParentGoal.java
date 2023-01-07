package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;

import net.minecraft.world.entity.ai.goal.Goal;

import java.util.List;

public class IcariaFollowParentGoal extends Goal {
    public double speedModifier;

    public int timeToRecalcPath;

    public IcariaAnimalEntity animal;
    public IcariaAnimalEntity parent;

    public IcariaFollowParentGoal(IcariaAnimalEntity pAnimal, double pSpeedModifier) {
        this.animal = pAnimal;
        this.speedModifier = pSpeedModifier;
    }

    @Override
    public boolean canContinueToUse() {
        if (!this.animal.isBaby()) {
            return false;
        } else if (!this.parent.isAlive()) {
            return false;
        } else {
            double d = this.animal.distanceToSqr(this.parent);
            return !(d <= 8.0D) && !(d >= 256.0D);
        }
    }

    @Override
    public boolean canUse() {
        if (!this.animal.isBaby()) {
            return false;
        } else {
            double d0 = Double.MAX_VALUE;
            IcariaAnimalEntity animal = null;
            List<? extends IcariaAnimalEntity> list = this.animal.level.getEntitiesOfClass(this.animal.getClass(), this.animal.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
            for (IcariaAnimalEntity parent : list) {
                if (!parent.isBaby()) {
                    double d1 = this.animal.distanceToSqr(parent);
                    if (!(d1 > d0)) {
                        d0 = d1;
                        animal = parent;
                    }
                }
            }

            if (animal == null) {
                return false;
            } else if (d0 <= 8.0D) {
                return false;
            } else {
                this.parent = animal;
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
            this.animal.getNavigation().moveTo(this.parent, this.speedModifier);
        }
    }
}
