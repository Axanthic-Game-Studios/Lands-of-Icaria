package com.axanthic.icaria.common.entity;

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

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellEntity extends ThrowableProjectile {
	public int color = 0;

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
		return this.entityData.get(SpellEntity.COLOR);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompound) {
		super.addAdditionalSaveData(pCompound);
		pCompound.putInt("Color", this.getColor());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(SpellEntity.COLOR, this.color);
	}

	@Override
	public void onHitBlock(BlockHitResult pResult) {
		super.onHitBlock(pResult);
		this.discard();
	}

	@Override
	public void onHitEntity(EntityHitResult pResult) {
		super.onHitEntity(pResult);
		this.discard();
	}

	@Override
	public void readAdditionalSaveData(CompoundTag pCompound) {
		super.readAdditionalSaveData(pCompound);
		this.setColor(pCompound.getInt("Color"));
	}

	public void setColor(int pColor) {
		this.entityData.set(SpellEntity.COLOR, pColor);
	}
}
