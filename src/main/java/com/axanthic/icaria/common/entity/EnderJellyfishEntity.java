package com.axanthic.icaria.common.entity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractThrownPotion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class EnderJellyfishEntity extends JellyfishEntity {
	public EnderJellyfishEntity(EntityType<? extends EnderJellyfishEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pAmount) {
		if (pDamageSource.is(DamageTypeTags.IS_PROJECTILE)) {
			this.teleport();
			return pDamageSource.getDirectEntity() instanceof AbstractThrownPotion abstractThrownPotion && this.hurtWithCleanWater(pDamageSource, pServerLevel, abstractThrownPotion, pAmount);
		} else {
			this.teleport(10);
			return super.hurtServer(pServerLevel, pDamageSource, pAmount);
		}
	}

	public boolean hurtWithCleanWater(DamageSource pDamageSource, ServerLevel pServerLevel, AbstractThrownPotion pAbstractThrownPotion, float pAmount) {
		return super.hurtServer(pServerLevel, pDamageSource, pAmount) && pAbstractThrownPotion.getItem().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.WATER);
	}

	@Override
	public boolean isSensitiveToWater() {
		return true;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.level().isClientSide()) {
			for (var i = 0; i < 2; ++i) {
				this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5D), this.getRandomY() - 0.25D, this.getRandomZ(0.5D), (this.getRandom().nextDouble() - 0.5D) * 2.0D, -this.getRandom().nextDouble(), (this.getRandom().nextDouble() - 0.5D) * 2.0D);
			}
		}
	}

	@Override
	public void customServerAiStep(ServerLevel pServerLevel) {
		this.teleport(100);
	}

	public void teleport(int pChance) {
		if (this.getRandom().nextInt(pChance) == 0) {
			this.teleport();
		}
	}

	public void teleport() {
		var x = this.getBlockX() + this.getRandom().nextIntBetweenInclusive(-8, 8);
		var y = this.getBlockY() + this.getRandom().nextIntBetweenInclusive(-8, 8);
		var z = this.getBlockZ() + this.getRandom().nextIntBetweenInclusive(-8, 8);
		var blockPos = new BlockPos(x, y, z);
		if (this.level().getBlockState(blockPos).isAir()) {
			if (!this.level().isClientSide()) {
				this.teleportTo(x, y, z);
			}
		}
	}

	@Override
	public void touch(Player pPlayer) {
		var mobEffectInstance = new MobEffectInstance(MobEffects.WITHER, this.getSize() * 100, 0);
		pPlayer.addEffect(mobEffectInstance, this);
	}
}
