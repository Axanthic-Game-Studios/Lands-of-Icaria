package com.axanthic.icaria.common.goal;

import com.axanthic.icaria.common.entity.CaptainRevenantEntity;
import com.axanthic.icaria.common.entity.CrawlerRevenantEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.spell.IcariaSummonSpell;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.world.entity.ai.goal.Goal;

public class CaptainRevenantSummonGoal extends Goal {
    public CaptainRevenantEntity entity;

    public CaptainRevenantSummonGoal(CaptainRevenantEntity pEntity) {
        super();
        this.entity = pEntity;
    }

    @Override
    public boolean canUse() {
        return !this.entity.onUnequips() && this.entity.onRallying() && this.entity.onReequips() && this.entity.getLastHurtByPlayerTime() > 0 && this.entity.level().getNearbyEntities(CrawlerRevenantEntity.class, this.entity.targetingConditions, this.entity, this.entity.getBoundingBox().inflate(16.0D)).size() <= 2;
    }

    @Override
    public void start() {
        this.entity.playSound(IcariaSoundEvents.CAPTAIN_REVENANT_RALLY, 0.1F, 1.0F);
        this.entity.setCasting(IcariaSummonSpell.SUMMON);
    }

    @Override
    public void tick() {
        for (int i = 0; i < this.entity.getRandom().nextIntBetweenInclusive(6, 8); ++i) {
            var level = this.entity.level();
            var entity = IcariaEntityTypes.CRAWLER_REVENANT.get().create(level);
            var blockPos = this.entity.blockPosition().offset(-8 + this.entity.getRandom().nextInt(16), 0, -8 + this.entity.getRandom().nextInt(16));
            if (entity != null) {
                if (level.getBlockState(blockPos).canBeReplaced()) {
                    if (this.entity.getBlockStateOn().is(IcariaBlockTags.DIRT_AND_SAND)) {
                        entity.moveTo(blockPos, 0.0F, 0.0F);
                        level.addFreshEntity(entity);
                    }
                }
            }
        }
    }
}
