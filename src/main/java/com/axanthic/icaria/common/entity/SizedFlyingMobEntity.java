package com.axanthic.icaria.common.entity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SizedFlyingMobEntity extends Mob {
	public float hitboxMult;
	public float renderMult;
	public float shadowMult;

	public int maxSize = 4;
	public int minSize = 1;

	public static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(SizedFlyingMobEntity.class, EntityDataSerializers.INT);

	public SizedFlyingMobEntity(EntityType<? extends SizedFlyingMobEntity> pEntityType, Level pLevel, float pHitboxMult, float pRenderMult, float pShadowMult) {
		super(pEntityType, pLevel);
		this.hitboxMult = pHitboxMult;
		this.renderMult = pRenderMult;
		this.shadowMult = pShadowMult;
	}

	public static boolean checkMobSpawnRules(EntityType<? extends Mob> pEntityType, LevelAccessor pLevelAccessor, EntitySpawnReason pEntitySpawnReason, BlockPos pBlockPos, RandomSource pRandomSource) {
		return true;
	}

	@Override
	public boolean isBaby() {
		return this.getSize() < this.maxSize;
	}

	@Override
	public boolean shouldDropExperience() {
		return true;
	}

	@Override
	public boolean shouldDropLoot() {
		return true;
	}

	public float getSizeForHitbox() {
		return this.getSize() * this.hitboxMult;
	}

	public float getSizeForRender() {
		return this.getSize() * this.renderMult;
	}

	public float getSizeForShadow() {
		return this.getSize() * this.shadowMult;
	}

	public int getSize() {
		return this.getEntityData().get(SizedFlyingMobEntity.SIZE);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.putInt("Size", this.getSize());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(SizedFlyingMobEntity.SIZE, this.minSize);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> pEntityDataAccessor) {
		super.onSyncedDataUpdated(pEntityDataAccessor);
		this.refreshDimensions();
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setSize(pValueInput.getIntOr("Size", 0));
	}

	public void setSize(int pSize) {
		this.getEntityData().set(SizedFlyingMobEntity.SIZE, pSize);
		this.xpReward = pSize;
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pPose) {
		var size = this.getSizeForHitbox();
		return this.getType().getDimensions().scale(size);
	}
}
