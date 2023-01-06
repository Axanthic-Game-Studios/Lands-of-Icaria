package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.IcariaAnimalEntity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.level.Level;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaBreedGoal extends Goal {
    public double speedModifier;

    public int loveTime;

    public Class<? extends IcariaAnimalEntity> partnerClass;
    public IcariaAnimalEntity animal;
    public IcariaAnimalEntity partner;
    public Level level;
    public static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();

    public IcariaBreedGoal(IcariaAnimalEntity pAnimal, double pSpeedModifier) {
        this(pAnimal, pSpeedModifier, pAnimal.getClass());
    }

    public IcariaBreedGoal(IcariaAnimalEntity pAnimal, double pSpeedModifier, Class<? extends IcariaAnimalEntity> pPartnerClass) {
        this.animal = pAnimal;
        this.level = pAnimal.level;
        this.partnerClass = pPartnerClass;
        this.speedModifier = pSpeedModifier;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    @Override
    public boolean canContinueToUse() {
        return this.partner.isAlive() && this.partner.inLove() && this.loveTime < 60;
    }

    @Override
    public boolean canUse() {
        if (!this.animal.inLove()) {
            return false;
        } else {
            this.partner = this.getFreePartner();
            return this.partner != null;
        }
    }

    public void breed() {
        this.animal.spawnChildFromBreeding((ServerLevel) this.level, this.partner);
    }

    @Override
    public void stop() {
        this.partner = null;
        this.loveTime = 0;
    }

    @Override
    public void tick() {
        this.animal.getLookControl().setLookAt(this.partner, 10.0F, this.animal.getMaxHeadXRot());
        this.animal.getNavigation().moveTo(this.partner, this.speedModifier);
        ++this.loveTime;
        if (this.loveTime >= 60 && this.animal.distanceToSqr(this.partner) <= 8.0D) {
            this.breed();
        }
    }

    public IcariaAnimalEntity getFreePartner() {
        double d = Double.MAX_VALUE;
        IcariaAnimalEntity animal = null;
        List<? extends IcariaAnimalEntity> list = this.level.getNearbyEntities(this.partnerClass, PARTNER_TARGETING, this.animal, this.animal.getBoundingBox().inflate(8.0D));
        for (IcariaAnimalEntity partner : list) {
            if (this.animal.canMate(partner) && this.animal.distanceToSqr(partner) < d) {
                animal = partner;
                d = this.animal.distanceToSqr(partner);
            }
        }

        return animal;
    }
}
