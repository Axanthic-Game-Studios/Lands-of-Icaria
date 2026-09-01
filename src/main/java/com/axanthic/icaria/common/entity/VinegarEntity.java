package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VinegarEntity extends ThrowableItemProjectile {
	public VinegarEntity(EntityType<? extends VinegarEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public VinegarEntity(Level pLevel, LivingEntity pLivingEntity, ItemStack pItemStack) {
		super(IcariaEntityTypes.VINEGAR.get(), pLivingEntity, pLevel, pItemStack);
	}

	@Override
	public void onHit(HitResult pHitResult) {
		super.onHit(pHitResult);
		if (!this.level().isClientSide()) {
			this.discard();
		}
	}

	@Override
	public void onHitEntity(EntityHitResult pEntityHitResult) {
		var mobEffectInstance = new MobEffectInstance(MobEffects.POISON, 120, 0);
		if (pEntityHitResult.getEntity() instanceof LivingEntity entity) {
			if (this.getOwner() instanceof LivingEntity owner) {
				entity.addEffect(mobEffectInstance);
				IcariaCommonHelper.hurt(this.damageSources().mobProjectile(this, owner), entity, 2.0F);
			}
		}
	}

	@Override
	public Item getDefaultItem() {
		return IcariaItems.VINEGAR.get();
	}
}
