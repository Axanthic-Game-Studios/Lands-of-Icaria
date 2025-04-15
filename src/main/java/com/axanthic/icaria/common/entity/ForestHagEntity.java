package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.ForestHagPlaceSaplingGoal;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForestHagEntity extends Monster {
	public int tick;

	public ForestHagEntity(EntityType<? extends ForestHagEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean doHurtTarget(ServerLevel pServerLevel, Entity pEntity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		this.sling(pEntity, pServerLevel);
		return super.doHurtTarget(pServerLevel, pEntity);
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pAmount) {
		var damage = this.damage(pDamageSource, pAmount);
		return super.hurtServer(pServerLevel, pDamageSource, damage);
	}

	public float damage(DamageSource pDamageSource, float pAmount) {
		if (pDamageSource.getEntity() instanceof LivingEntity livingEntity && livingEntity.getMainHandItem().getItem() instanceof AxeItem) {
			return pAmount * 2;
		} else if (pDamageSource.is(DamageTypes.ON_FIRE)) {
			return pAmount * 2;
		} else {
			return pAmount;
		}
	}

	@Override
	public void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 10.0F, 0.025F, false));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new ForestHagPlaceSaplingGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	}

	public void sling(Entity pEntity, ServerLevel pServerLevel) {
		pEntity.hurtServer(pServerLevel, this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
		if (pEntity instanceof LivingEntity livingEntity) {
			var d = this.getAttributeValue(Attributes.ATTACK_KNOCKBACK) - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
			if (d > 0.0D) {
				livingEntity.push(0.0D, d * 0.5D, 0.0D);
			}
		}
	}

	@Override
	public void tick() {
		super.tick();
		this.tickPlay();
		this.tickTick();
	}

	public void tickPlay() {
		if (this.isAggressive()) {
			if (this.tick == 0) {
				this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), IcariaSoundEvents.FOREST_HAG_TARGET, SoundSource.HOSTILE, 1.0F, 1.0F, false);
			}
		}
	}

	public void tickTick() {
		if (this.isAggressive()) {
			this.tick++;
		} else {
			this.tick = -1;
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 16.0D).add(Attributes.ATTACK_KNOCKBACK, 1.0D).add(Attributes.FOLLOW_RANGE, 64.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D).add(Attributes.MAX_HEALTH, 48.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return this.isAggressive() ? IcariaSoundEvents.FOREST_HAG_SCREAM : IcariaSoundEvents.FOREST_HAG_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.FOREST_HAG_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.FOREST_HAG_HURT;
	}
}
