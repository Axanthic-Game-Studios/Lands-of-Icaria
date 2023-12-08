package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.spell.IcariaSummonSpell;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;
import com.axanthic.icaria.common.entity.MyrmekeSoldierEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

public class MyrmekeQueenSummonGoal extends Goal {
    public MyrmekeQueenEntity entity;

    public TargetingConditions targetingConditions = TargetingConditions.forNonCombat().range(16.0D).ignoreLineOfSight().ignoreInvisibilityTesting();

    public MyrmekeQueenSummonGoal(MyrmekeQueenEntity pEntity) {
        super();
        this.entity = pEntity;
    }

    @Override
    public boolean canUse() {
        if (this.entity.getTarget() != this.entity.getLastHurtByMob()) {
            return false;
        } else if (!this.entity.getBlockStateOn().is(IcariaBlockTags.MYRMEKE_SUMMONS_ON)) {
            return false;
        } else {
            return this.entity.level().getNearbyEntities(MyrmekeSoldierEntity.class, this.targetingConditions, this.entity, this.entity.getBoundingBox().inflate(32.0D)).size() <= 2;
        }
    }

    @Override
    public void start() {
        this.entity.setCasting(IcariaSummonSpell.SUMMON);
    }

    @Override
    public void tick() {
        var entity = IcariaEntityTypes.MYRMEKE_SOLDIER.get().create(this.entity.level());
        for (int i = 0; i < this.entity.getRandom().nextIntBetweenInclusive(3,4); ++i) {
            if (entity != null) {
                int random = this.entity.getRandom().nextIntBetweenInclusive(-4, 4);
                this.entity.level().addFreshEntity(entity);
                this.entity.playSound(SoundEvents.EVOKER_PREPARE_SUMMON, 0.1F, 1.0F);
                entity.moveTo(this.entity.blockPosition().offset(random, 0, random), 0.0F, 0.0F);
            }
        }
    }
}
