package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.goal.ForestHagPlaceSaplingGoal;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForestHagEntity extends Monster {
    public int targetChangeTime;
    public int targetSoundsTime = Integer.MIN_VALUE;

    public static final EntityDataAccessor<Boolean> TARGETING = SynchedEntityData.defineId(ForestHagEntity.class, EntityDataSerializers.BOOLEAN);

    public ForestHagEntity(EntityType<? extends ForestHagEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 10;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        boolean flag = pEntity.hurt(this.damageSources().mobAttack(this), (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE));
        this.level().broadcastEntityEvent(this, (byte) 4);
        if (pEntity instanceof LivingEntity livingEntity) {
            double knockback = this.getAttributeValue(Attributes.ATTACK_KNOCKBACK) - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
            if (flag) {
                if (knockback > 0.0D) {
                    pEntity.push(0.0D, knockback * 0.5D, 0.0D);
                }
            }
        }

        return pEntity instanceof LivingEntity && flag;
    }

    public boolean isTargeting() {
        return this.entityData.get(ForestHagEntity.TARGETING);
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    @Override
    public void actuallyHurt(DamageSource pDamageSource, float pDamageAmount) {
        if (pDamageSource.getEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity.getMainHandItem().getItem() instanceof AxeItem) {
                pDamageAmount *= 2;
            }
        }

        if (pDamageSource.is(DamageTypes.ON_FIRE)) {
            pDamageAmount *= 2;
        }

        super.actuallyHurt(pDamageSource, pDamageAmount);
    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(ForestHagEntity.TARGETING, false);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (ForestHagEntity.TARGETING.equals(pKey)) {
            if (this.isTargeting()) {
                if (this.level().isClientSide()) {
                    this.playTargetSounds();
                }
            }
        }
    }

    public void playTargetSounds() {
        if (this.tickCount >= this.targetSoundsTime + 400) {
            this.targetSoundsTime = this.tickCount;
            if (!this.isSilent()) {
                this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENDERMAN_STARE, SoundSource.HOSTILE, 1.0F, 1.0F, false);
            }
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

    @Override
    public void setTarget(@Nullable LivingEntity pTarget) {
        super.setTarget(pTarget);
        if (pTarget == null) {
            this.targetChangeTime = 0;
            this.entityData.set(ForestHagEntity.TARGETING, false);
        } else {
            this.targetChangeTime = this.tickCount;
            this.entityData.set(ForestHagEntity.TARGETING, true);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 16.0D).add(Attributes.ATTACK_KNOCKBACK, 1.0D).add(Attributes.FOLLOW_RANGE, 64.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D).add(Attributes.MAX_HEALTH, 48.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return this.isTargeting() ? SoundEvents.ENDERMAN_SCREAM : SoundEvents.ENDERMAN_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ENDERMAN_HURT;
    }
}
