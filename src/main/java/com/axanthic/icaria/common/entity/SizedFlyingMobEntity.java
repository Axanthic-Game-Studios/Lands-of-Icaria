package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SizedFlyingMobEntity extends FlyingMob {
	public int maxSize = 4;
	public int minSize = 1;

	public float aabbMult;
	public float renderMult;
	public float shadowMult;
	public float sizeMult;
	public float sizeMultInverted;

	public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(SizedFlyingMobEntity.class, EntityDataSerializers.INT);

	public SizedFlyingMobEntity(EntityType<? extends SizedFlyingMobEntity> pType, Level pLevel, float pAabbMult, float pRenderMult, float pShadowMult, float pSizeMult, float pSizeMultInverted) {
		super(pType, pLevel);
		this.aabbMult = pAabbMult;
		this.renderMult = pRenderMult;
		this.shadowMult = pShadowMult;
		this.sizeMult = pSizeMult;
		this.sizeMultInverted = pSizeMultInverted;
	}

	public static boolean checkMobSpawnRules(EntityType<? extends Mob> pType, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
		return true;
	}

	@Override
	public boolean isBaby() {
		return this.getSize() < this.maxSize;
	}

	public float getSizeInverted() {
		return this.getSize() * -1.0F + 5.0F;
	}

	public float getScaleForRender() {
		return this.getScaleFromSize() * this.renderMult;
	}

	public float getScaleForShadow() {
		return this.getScaleFromSize() * this.shadowMult;
	}

	public float getScaleFromSize() {
		return this.getSizeWithMultInverted() + this.getSizeWithMult();
	}

	public float getSizeWithMult() {
		return this.getSize() * this.sizeMult;
	}

	public float getSizeWithMultInverted() {
		return this.getSizeInverted() * this.sizeMultInverted;
	}

	@Override
	public float getVoicePitch() {
		return this.getSizeWithMultInverted() + 0.75F;
	}

	public int getSize() {
		return this.entityData.get(SizedFlyingMobEntity.SIZE);
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
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(SizedFlyingMobEntity.SIZE, this.minSize);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
		super.onSyncedDataUpdated(pKey);
		if (SizedFlyingMobEntity.SIZE.equals(pKey)) {
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
		this.entityData.set(SizedFlyingMobEntity.SIZE, size);
		this.xpReward = size + 1;
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pPose) {
		float scale = this.getScaleFromSize() * this.aabbMult;
		return this.getType().getDimensions().scale(scale);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
		this.setSize(this.random.nextIntBetweenInclusive(0, 4));
		return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
	}
}
