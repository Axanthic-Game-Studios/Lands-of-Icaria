package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityDataSerializers;
import com.axanthic.icaria.common.variant.FisshhVariant;
import com.axanthic.icaria.data.registry.IcariaFisshhVariants;
import com.axanthic.icaria.data.registry.IcariaRegistries;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
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

public class FisshhEntity extends FishEntity {
	public static final EntityDataAccessor<Holder<FisshhVariant>> FISSHH_VARIANT = SynchedEntityData.defineId(FisshhEntity.class, IcariaEntityDataSerializers.FISSHH_VARIANT.get());

	public FisshhEntity(EntityType<? extends FisshhEntity> pEntityType, Level pLevel) {
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
		pBuilder.define(FisshhEntity.FISSHH_VARIANT, VariantUtils.getDefaultOrAny(this.registryAccess(), IcariaFisshhVariants.BLUE_BROWN));
	}

	@Override
	public void dropFromLootTable(ServerLevel pServerLevel, DamageSource pDamageSource, boolean pPlayerKill) {
		super.dropFromLootTable(pServerLevel, pDamageSource, pPlayerKill);
		this.spawnAtLocation(pServerLevel, this.getVariant().value().itemStack());
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		VariantUtils.readVariant(pValueInput, IcariaRegistries.FISSHH_VARIANT).ifPresent(this::setVariant);
	}

	public void setVariant(Holder<FisshhVariant> pVariant) {
		this.entityData.set(FisshhEntity.FISSHH_VARIANT, pVariant);
	}

	public Holder<FisshhVariant> getVariant() {
		return this.entityData.get(FisshhEntity.FISSHH_VARIANT);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		var registry = pServerLevelAccessor.registryAccess().lookupOrThrow(IcariaRegistries.FISSHH_VARIANT);
		var variants = registry.listElements().toList();
		var bound = variants.size();
		var index = pServerLevelAccessor.getRandom().nextInt(bound);
		var variant = variants.get(index);
		this.setVariant(variant);
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
