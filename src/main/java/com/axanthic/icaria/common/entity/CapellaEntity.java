package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CapellaEntity extends IcariaAnimalEntity {
	public CapellaEntity(EntityType<? extends CapellaEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel, 0.25F, 0.25F, 0.15F);
	}

	@Override
	public void playStepSound(BlockPos pBlockPos, BlockState pBlockState) {
		this.playSound(IcariaSoundEvents.CAPELLA_STEP, 0.1F, 1.0F);
	}

	@Nullable
	@Override
	public IcariaAnimalEntity getBreedOffspring(ServerLevel pServerLevel) {
		return IcariaEntityTypes.CAPELLA.get().create(pServerLevel, EntitySpawnReason.BREEDING);
	}

	@Override
	public Item getFood() {
		return IcariaItems.VINEBERRIES.get();
	}

	@Override
	public SoundEvent getAmbientSound() {
		return IcariaSoundEvents.CAPELLA_AMBIENT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return IcariaSoundEvents.CAPELLA_DEATH;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource pDamageSource) {
		return IcariaSoundEvents.CAPELLA_HURT;
	}

	@Override
	public Trough getTrough() {
		return Trough.VINEBERRIES;
	}
}
