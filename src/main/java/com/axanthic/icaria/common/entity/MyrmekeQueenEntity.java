package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenEntity extends Monster {
    public static EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(MyrmekeQueenEntity.class, EntityDataSerializers.BYTE);

    public MyrmekeQueenEntity(EntityType<? extends Monster> pType, Level pLevel) {
        super(pType, pLevel);
        this.xpReward = 5;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance pEffectInstance) {
        if (pEffectInstance.getEffect() == MobEffects.POISON) {
            MobEffectEvent.Applicable event = new MobEffectEvent.Applicable(this, pEffectInstance);
            MinecraftForge.EVENT_BUS.post(event);
            return event.getResult() == Event.Result.ALLOW;
        }

        return super.canBeAffected(pEffectInstance);
    }

    public boolean isClimbing() {
        return (this.entityData.get(CLIMBING) & 1) != 0;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    @Override
    public double getPassengersRidingOffset() {
        return this.getBbHeight() * 0.5F;
    }

    @Override
    public float getEyeHeight(Pose pPose) {
        return 0.25F;
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CLIMBING, (byte)0);
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.15F, 1.0F);
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new MyrmekeQueenAttackGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new MyrmekeQueenTargetGoal<>(this, Player.class));
        this.targetSelector.addGoal(3, new MyrmekeQueenTargetGoal<>(this, IronGolem.class));
    }

    public void setClimbing(boolean pClimbing) {
        byte b = this.entityData.get(CLIMBING);
        if (pClimbing) {
            b = (byte)(b | 1);
        } else {
            b = (byte)(b & -2);
        }

        this.entityData.set(CLIMBING, b);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    @Override
    public PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.SPIDER_AMBIENT;
    }

    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.SPIDER_DEATH;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SPIDER_HURT;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pTag) {
        pSpawnData = super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnData, pTag);
        RandomSource randomSource = pLevel.getRandom();
        if (pSpawnData == null) {
            pSpawnData = new MyrmekeQueenEffectsGroupData();
            if (pLevel.getDifficulty() == Difficulty.HARD && randomSource.nextFloat() < 0.1F * pDifficulty.getSpecialMultiplier()) {
                ((MyrmekeQueenEffectsGroupData)pSpawnData).setRandomEffect(randomSource);
            }
        }

        if (pSpawnData instanceof MyrmekeQueenEffectsGroupData) {
            MobEffect mobEffect = ((MyrmekeQueenEffectsGroupData)pSpawnData).mobEffect;
            if (mobEffect != null) {
                this.addEffect(new MobEffectInstance(mobEffect, Integer.MAX_VALUE));
            }
        }

        return pSpawnData;
    }

    public static class MyrmekeQueenAttackGoal extends MeleeAttackGoal {
        public MyrmekeQueenAttackGoal(MyrmekeQueenEntity pEntity) {
            super(pEntity, 1.0D, true);
        }

        @Override
        public boolean canUse() {
            return super.canUse() && !this.mob.isVehicle();
        }

        @Override
        public boolean canContinueToUse() {
            float f = this.mob.getLightLevelDependentMagicValue();
            if (f >= 0.5F && this.mob.getRandom().nextInt(100) == 0) {
                this.mob.setTarget(null);
                return false;
            } else {
                return super.canContinueToUse();
            }
        }

        @Override
        public double getAttackReachSqr(LivingEntity pEntity) {
            return 4.0F + pEntity.getBbWidth();
        }
    }

    public static class MyrmekeQueenTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
        public MyrmekeQueenTargetGoal(MyrmekeQueenEntity pEntity, Class<T> pTarget) {
            super(pEntity, pTarget, true);
        }

        @Override
        public boolean canUse() {
            float f = this.mob.getLightLevelDependentMagicValue();
            return f >= 0.5F ? false : super.canUse();
        }
    }

    public static class MyrmekeQueenEffectsGroupData implements SpawnGroupData {
        public MobEffect mobEffect;

        public void setRandomEffect(RandomSource pRandomSource) {
            int i = pRandomSource.nextInt(5);
            if (i <= 1) {
                this.mobEffect = MobEffects.MOVEMENT_SPEED;
            } else if (i <= 2) {
                this.mobEffect = MobEffects.DAMAGE_BOOST;
            } else if (i <= 3) {
                this.mobEffect = MobEffects.REGENERATION;
            } else if (i <= 4) {
                this.mobEffect = MobEffects.INVISIBILITY;
            }
        }
    }
}
