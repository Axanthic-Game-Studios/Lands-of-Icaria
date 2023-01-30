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

    public IcariaAnimalEntity entity;
    public IcariaAnimalEntity partner;

    public Level level;

    public static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();

    public IcariaBreedGoal(IcariaAnimalEntity pEntity, double pSpeedModifier) {
        this(pEntity, pSpeedModifier, pEntity.getClass());
    }

    public IcariaBreedGoal(IcariaAnimalEntity pEntity, double pSpeedModifier, Class<? extends IcariaAnimalEntity> pPartnerClass) {
        this.entity = pEntity;
        this.level = pEntity.level;
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
        if (!this.entity.inLove()) {
            return false;
        } else {
            this.partner = this.getFreePartner();
            return this.partner != null;
        }
    }

    public void breed() {
        this.entity.spawnChildFromBreeding((ServerLevel) this.level, this.partner);
    }

    @Override
    public void stop() {
        this.partner = null;
        this.loveTime = 0;
    }

    @Override
    public void tick() {
        this.entity.getLookControl().setLookAt(this.partner, 10.0F, this.entity.getMaxHeadXRot());
        this.entity.getNavigation().moveTo(this.partner, this.speedModifier);
        ++this.loveTime;
        if (this.loveTime >= 60 && this.entity.distanceToSqr(this.partner) <= 8.0D) {
            this.breed();
        }
    }

    public IcariaAnimalEntity getFreePartner() {
        double d = Double.MAX_VALUE;
        IcariaAnimalEntity entity = null;
        List<? extends IcariaAnimalEntity> list = this.level.getNearbyEntities(this.partnerClass, PARTNER_TARGETING, this.entity, this.entity.getBoundingBox().inflate(8.0D));
        for (IcariaAnimalEntity partner : list) {
            if (this.entity.canMate(partner) && this.entity.distanceToSqr(partner) < d) {
                entity = partner;
                d = this.entity.distanceToSqr(partner);
            }
        }

        return entity;
    }
}
