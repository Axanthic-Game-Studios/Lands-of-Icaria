package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.CaptainRevenantEntity;
import com.axanthic.icaria.common.spell.IcariaSummonSpell;
import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.Goal;

public class CaptainRevenantSummonGoal extends Goal {
    public CaptainRevenantEntity entity;

    public CaptainRevenantSummonGoal(CaptainRevenantEntity pEntity) {
        super();
        this.entity = pEntity;
    }

    @Override
    public boolean canUse() {
        if (this.entity.getTarget() != this.entity.getLastHurtByMob()) {
            return false;
        } else if (this.entity.onUnequips()) {
            return false;
        } else if (!this.entity.onRallying()) {
            return false;
        }  else if (!this.entity.getBlockStateOn().is(IcariaBlockTags.CAPTAIN_SUMMONS_ON)) {
            return false;
        } else {
            return this.entity.level().getNearbyEntities(CrawlerRevenantEntity.class, this.entity.targetingConditions, this.entity, this.entity.getBoundingBox().inflate(16.0D)).size() <= 2;
        }
    }

    @Override
    public void start() {
        this.entity.playSound(IcariaSoundEvents.CAPTAIN_REVENANT_RALLY);
        this.entity.setCasting(IcariaSummonSpell.SUMMON);
    }

    @Override
    public void tick() {
        var serverLevel = (ServerLevel) this.entity.level();
        for (int i = 0; i < this.entity.getRandom().nextIntBetweenInclusive(6, 8); ++i) {
            var blockPos = this.entity.blockPosition().offset(-8 + this.entity.getRandom().nextInt(16), 0, -8 + this.entity.getRandom().nextInt(16));
            var entity = IcariaEntityTypes.CRAWLER_REVENANT.get().create(this.entity.level());
            if (entity != null) {
                entity.moveTo(blockPos, 0.0F, 0.0F);
                entity.finalizeSpawn(serverLevel, this.entity.level().getCurrentDifficultyAt(blockPos), MobSpawnType.MOB_SUMMONED, null, null);
                serverLevel.addFreshEntityWithPassengers(entity);
            }
        }
    }
}
