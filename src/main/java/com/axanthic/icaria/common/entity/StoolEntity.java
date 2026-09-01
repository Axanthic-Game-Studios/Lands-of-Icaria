package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.StoolBlock;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StoolEntity extends Entity {
	public StoolEntity(EntityType<? extends StoolEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pAmount) {
		return false;
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		return;
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		return;
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		return;
	}

	@Override
	public void tick() {
		super.tick();
		var blockPos = this.blockPosition();
		var blockState = this.level().getBlockState(blockPos);
		var flag = blockState.getBlock() instanceof StoolBlock;
		if (this.getPassengers().isEmpty() || !flag) {
			this.discard();
			this.level().setBlockAndUpdate(blockPos, blockState.setValue(IcariaBlockStateProperties.STOOL_TAKEN, false));
		}
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity pLivingEntity) {
		var vec3 = DismountHelper.findSafeDismountLocation(pLivingEntity.getType(), this.level(), this.blockPosition().relative(pLivingEntity.getDirection()), false);
		if (vec3 != null) {
			return vec3;
		} else {
			return super.getDismountLocationForPassenger(pLivingEntity);
		}
	}
}
