package com.axanthic.icaria.common.entity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellEntity extends ThrowableProjectile {
	public int color;

	public static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(SpellEntity.class, EntityDataSerializers.INT);

	public SpellEntity(EntityType<? extends SpellEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean isInWater() {
		return false;
	}

	@Override
	public double getDefaultGravity() {
		return 0.005D;
	}

	public int getColor() {
		return this.getEntityData().get(SpellEntity.COLOR);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompoundTag) {
		super.addAdditionalSaveData(pCompoundTag);
		pCompoundTag.putInt("Color", this.getColor());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(SpellEntity.COLOR, 0);
	}

	@Override
	public void onHitBlock(BlockHitResult pBlockHitResult) {
		super.onHitBlock(pBlockHitResult);
		this.discard();
	}

	@Override
	public void onHitEntity(EntityHitResult pEntityHitResult) {
		super.onHitEntity(pEntityHitResult);
		this.discard();
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompoundTag) {
		super.readAdditionalSaveData(pCompoundTag);
		this.setColor(pCompoundTag.getInt("Color"));
	}

	public void setColor(int pColor) {
		this.getEntityData().set(SpellEntity.COLOR, pColor);
	}
}
