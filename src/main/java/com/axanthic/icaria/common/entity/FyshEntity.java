package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityDataSerializers;
import com.axanthic.icaria.common.variant.FyshVariant;
import com.axanthic.icaria.data.registry.IcariaFyshVariants;
import com.axanthic.icaria.data.registry.IcariaRegistries;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.variant.VariantUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FyshEntity extends FishEntity {
	public static final EntityDataAccessor<Holder<FyshVariant>> FYSH_VARIANT = SynchedEntityData.defineId(FyshEntity.class, IcariaEntityDataSerializers.FYSH_VARIANT.get());

	public FyshEntity(EntityType<? extends FyshEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		VariantUtils.writeVariant(pValueOutput, this.getVariant());
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(FyshEntity.FYSH_VARIANT, VariantUtils.getDefaultOrAny(this.registryAccess(), IcariaFyshVariants.BLUE));
	}

	@Override
	public void dropFromLootTable(ServerLevel pServerLevel, DamageSource pDamageSource, boolean pPlayerKill) {
		super.dropFromLootTable(pServerLevel, pDamageSource, pPlayerKill);
		this.spawnAtLocation(pServerLevel, this.getVariant().value().itemStack());
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		VariantUtils.readVariant(pValueInput, IcariaRegistries.FYSH_VARIANT).ifPresent(this::setVariant);
	}

	public void setVariant(Holder<FyshVariant> pVariant) {
		this.entityData.set(FyshEntity.FYSH_VARIANT, pVariant);
	}

	public Holder<FyshVariant> getVariant() {
		return this.entityData.get(FyshEntity.FYSH_VARIANT);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		var registry = pServerLevelAccessor.registryAccess().lookupOrThrow(IcariaRegistries.FYSH_VARIANT);
		var variants = registry.listElements().toList();
		var bound = variants.size();
		var index = pServerLevelAccessor.getRandom().nextInt(bound);
		var variant = variants.get(index);
		this.setVariant(variant);
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
