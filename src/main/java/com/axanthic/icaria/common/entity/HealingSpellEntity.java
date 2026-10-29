package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;

import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HealingSpellEntity extends SpellEntity {
	public HealingSpellEntity(EntityType<? extends SpellEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public void onHitEntity(EntityHitResult pEntityHitResult) {
		super.onHitEntity(pEntityHitResult);
		if (pEntityHitResult.getEntity() instanceof LivingEntity livingEntity) {
			if (livingEntity.is(EntityTypeTags.UNDEAD)) {
				IcariaCommonHelper.hurt(this.damageSources().indirectMagic(this, this.getOwner()), pEntityHitResult.getEntity(), IcariaConfig.HEALTH_HEALING_SPELL.get().floatValue());
			} else {
				livingEntity.heal(IcariaConfig.HEALTH_HEALING_SPELL.get().floatValue());
			}
		}
	}
}
