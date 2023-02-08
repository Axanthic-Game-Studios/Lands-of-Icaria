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

public class SizedFlyingMobEntity extends FlyingMob {
    public int maxSize = 4;
    public int minSize = 1;

    public float bboxMult;
    public float eyesMult;
    public float sizeMult;

    public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(SizedFlyingMobEntity.class, EntityDataSerializers.INT);

    public SizedFlyingMobEntity(EntityType<? extends SizedFlyingMobEntity> pType, Level pLevel, float pBboxMult, float pEyesMult, float pSizeMult) {
        super(pType, pLevel);
        this.bboxMult = pBboxMult;
        this.eyesMult = pEyesMult;
        this.sizeMult = pSizeMult;
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

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Size", this.getSize());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            this.setSize(this.getSize());
        }
    }

    @Override
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SIZE, this.minSize);
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
    }

    public void setSize(int pSize) {
        int size = Mth.clamp(pSize, this.minSize, this.maxSize);
        this.refreshDimensions();
        this.entityData.set(SIZE, size);
        this.xpReward = size + 1;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        this.setSize(this.maxSize);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }
}
