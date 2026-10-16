package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.config.IcariaConfig;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class FortifyingSpellEntity extends SpellEntity {
    public FortifyingSpellEntity(EntityType<? extends SpellEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (pResult.getEntity() instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, IcariaConfig.FORTIFYING_DURATION.get(), IcariaConfig.FORTIFYING_LEVEL.get()));
        }
    }
}
