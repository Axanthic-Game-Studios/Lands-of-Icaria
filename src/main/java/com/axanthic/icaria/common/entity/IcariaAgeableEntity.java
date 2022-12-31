package com.axanthic.icaria.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public abstract class IcariaAgeableEntity extends PathfinderMob {
    public int maxSize = 4;
    public int maxTick = 48000;
    public int minSize = 1;
    public int minTick = 0;

    public float bboxMult;
    public float eyesMult;
    public float sizeMult;

    public static EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(IcariaAgeableEntity.class, EntityDataSerializers.INT);
    public static EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(IcariaAgeableEntity.class, EntityDataSerializers.INT);

    public IcariaAgeableEntity(EntityType<? extends IcariaAgeableEntity> pEntityType, Level pLevel, float bboxMult, float eyesMult, float sizeMult) {
        super(pEntityType, pLevel);
        this.bboxMult = bboxMult;
        this.eyesMult = eyesMult;
        this.sizeMult = sizeMult;
    }

    @Override
    public boolean isBaby() {
        return this.getSize() < this.maxSize;
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
    public float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
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
        this.entityData.define(SIZE, this.minSize);
        this.entityData.define(TICK, this.minTick);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        super.onSyncedDataUpdated(pKey);
        if (SIZE.equals(pKey)) {
            this.refreshDimensions();
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setSize(pCompound.getInt("Size"));
        this.setTick(pCompound.getInt("Tick"));
    }

    public void setSize(int pSize) {
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        this.refreshDimensions();
        this.entityData.set(SIZE, size);
        this.xpReward = size + 1;
    }

    public void setTick(int pSize) {
        int tick = Mth.clamp(pSize, this.minTick, this.maxTick);
        this.entityData.set(TICK, tick);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.setSize(this.maxSize);
        this.setTick(this.maxTick);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
}
