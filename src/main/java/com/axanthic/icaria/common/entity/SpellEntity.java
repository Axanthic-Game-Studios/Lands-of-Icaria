package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellEntity extends ThrowableProjectile {
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

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		return;
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
}
