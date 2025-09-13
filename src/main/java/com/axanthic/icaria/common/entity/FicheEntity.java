package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityDataSerializers;
import com.axanthic.icaria.common.variant.FicheVariant;
import com.axanthic.icaria.data.registry.IcariaFicheVariants;
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

public class FicheEntity extends FishEntity {
	public static final EntityDataAccessor<Holder<FicheVariant>> FICHE_VARIANT = SynchedEntityData.defineId(FicheEntity.class, IcariaEntityDataSerializers.FICHE_VARIANT.get());

	public FicheEntity(EntityType<? extends FicheEntity> pEntityType, Level pLevel) {
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
		pBuilder.define(FicheEntity.FICHE_VARIANT, VariantUtils.getDefaultOrAny(this.registryAccess(), IcariaFicheVariants.BLUE_RED));
	}

	@Override
	public void dropFromLootTable(ServerLevel pServerLevel, DamageSource pDamageSource, boolean pPlayerKill) {
		super.dropFromLootTable(pServerLevel, pDamageSource, pPlayerKill);
		this.spawnAtLocation(pServerLevel, this.getVariant().value().itemStack());
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		VariantUtils.readVariant(pValueInput, IcariaRegistries.FICHE_VARIANT).ifPresent(this::setVariant);
	}

	public void setVariant(Holder<FicheVariant> pVariant) {
		this.entityData.set(FicheEntity.FICHE_VARIANT, pVariant);
	}

	public Holder<FicheVariant> getVariant() {
		return this.entityData.get(FicheEntity.FICHE_VARIANT);
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor pServerLevelAccessor, DifficultyInstance pDifficultyInstance, EntitySpawnReason pEntitySpawnReason, @Nullable SpawnGroupData pSpawnGroupData) {
		var registry = pServerLevelAccessor.registryAccess().lookupOrThrow(IcariaRegistries.FICHE_VARIANT);
		var variants = registry.listElements().toList();
		var bound = variants.size();
		var index = pServerLevelAccessor.getRandom().nextInt(bound);
		var variant = variants.get(index);
		this.setVariant(variant);
		return super.finalizeSpawn(pServerLevelAccessor, pDifficultyInstance, pEntitySpawnReason, pSpawnGroupData);
	}
}
