package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;

import java.util.Objects;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneEntity extends ArachneEntity {
    public int maxSize = 4;
    public int maxTick = 48000;
    public int minSize = 1;
    public int minTick = 0;

    public float bboxMult;
    public float eyesMult;
    public float sizeMult;

    public static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.BYTE);
    public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(ArachneDroneEntity.class, EntityDataSerializers.INT);

    public ArachneDroneEntity(EntityType<? extends ArachneDroneEntity> pType, Level pLevel) {
        super(pType, pLevel);
        this.bboxMult = 0.25F;
        this.eyesMult = 0.1F;
        this.sizeMult = 0.25F;
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

    @Override
    public boolean isBaby() {
        return this.getSize() < this.maxSize;
    }

    public boolean isClimbing() {
        return (this.entityData.get(CLIMBING) & 1) != 0;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    public float getInverseSize() {
        return (this.getSize() * -1.0F) + 5.0F;
    }

    @Override
    public float getScale() {
        return this.getScaleFromSize() * this.bboxMult;
    }

    public float getScaleFromSize() {
        return (this.getSize() + (this.getInverseSize() * this.sizeMult)) - 0.5F;
    }

    @Override
    public float getStandingEyeHeight(Pose pPose, EntityDimensions pDimensions) {
        return this.getScaleFromSize() * this.eyesMult;
    }

    @Override
    public float getVoicePitch() {
        return (this.getInverseSize() * 0.25F) + 0.75F;
    }

    public int getSize() {
        return this.entityData.get(SIZE);
    }

    public int getTick() {
        return this.entityData.get(TICK);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Size", this.getSize());
        pCompound.putInt("Tick", this.getTick());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            int tick = this.getTick();
            if (tick < 16000) {
                ++tick;
                this.setTick(tick);
                this.setSize(1);
            } else if (tick < 32000) {
                ++tick;
                this.setTick(tick);
                this.setSize(2);
            } else if (tick < 48000) {
                ++tick;
                this.setTick(tick);
                this.setSize(3);
            } else {
                ++tick;
                this.setTick(tick);
                this.setSize(4);
            }
        }
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CLIMBING, (byte) 0);
        this.entityData.define(SIZE, this.minSize);
        this.entityData.define(TICK, this.minTick);
    }

    @Override
    public void makeStuckInBlock(BlockState pState, Vec3 pMotionMultiplier) {
        if (!pState.is(Blocks.COBWEB)) { // TODO: replace with Arachne web
            super.makeStuckInBlock(pState, pMotionMultiplier);
        }
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (SIZE.equals(pKey)) {
            this.refreshDimensions();
        }
    }

    @Override
    public void playStepSound(BlockPos pPos, BlockState pState) {
        this.playSound(SoundEvents.SPIDER_STEP, 0.1F, 1.0F);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setSize(pCompound.getInt("Size"));
        this.setTick(pCompound.getInt("Tick"));
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LeapAtTargetGoal(this, 0.25F));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D, 0.001F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 5.0F, 0.025F, false));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public void setClimbing(boolean pClimbing) {
        byte b = this.entityData.get(CLIMBING);
        if (pClimbing) {
            b = (byte) (b | 1);
        } else {
            b = (byte) (b & -2);
        }

        this.entityData.set(CLIMBING, b);
    }

    public void setSize(int pSize) {
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        this.refreshDimensions();
        Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(size);
        Objects.requireNonNull(this.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(size * size);
        Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue((size * 0.04D) + 0.1D);
        this.entityData.set(SIZE, size);
        this.xpReward = size + 1;
    }

    public void setTick(int pSize) {
        int tick = Mth.clamp(pSize, this.minTick, this.maxTick);
        this.entityData.set(TICK, tick);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.MAX_HEALTH, 16.0D).add(Attributes.MOVEMENT_SPEED, 0.1D);
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
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.setSize(this.maxSize);
        this.setTick(this.maxTick);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
}
