package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.provider.tags.IcariaPaintingVariantTagsProvider;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.variant.VariantUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingEntity extends Painting {
	public static final EntityDataAccessor<Holder<PaintingVariant>> PAINTING_VARIANT = SynchedEntityData.defineId(IcariaPaintingEntity.class, EntityDataSerializers.PAINTING_VARIANT);

	public IcariaPaintingEntity(EntityType<? extends Painting> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public IcariaPaintingEntity(Level pLevel, BlockPos pBlockPos) {
		super(IcariaEntityTypes.PAINTING.get(), pLevel);
		this.pos = pBlockPos;
	}

	public static int variantArea(Holder<PaintingVariant> pVariant) {
		return pVariant.value().area();
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		VariantUtils.writeVariant(pValueOutput, this.getVariant());
	}

	public static void area(ArrayList<Holder<PaintingVariant>> pVariants) {
		pVariants.removeIf((variant) -> IcariaPaintingEntity.variantArea(variant) < pVariants.stream().mapToInt(IcariaPaintingEntity::variantArea).max().orElse(0));
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(IcariaPaintingEntity.PAINTING_VARIANT, VariantUtils.getAny(this.registryAccess(), Registries.PAINTING_VARIANT));
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> pEntityDataAccessor) {
		if (IcariaPaintingEntity.PAINTING_VARIANT.equals(pEntityDataAccessor)) {
			this.recalculateBoundingBox();
		}
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		VariantUtils.readVariant(pValueInput, Registries.PAINTING_VARIANT).ifPresent(this::setVariant);
	}

	public void setVariant(Holder<PaintingVariant> pVariant) {
		this.entityData.set(IcariaPaintingEntity.PAINTING_VARIANT, pVariant);
	}

	public static void survives(ArrayList<Holder<PaintingVariant>> pVariants, IcariaPaintingEntity pEntity) {
		pVariants.removeIf(
			(variant) -> {
				pEntity.setVariant(variant);
				return !pEntity.survives();
			}
		);
	}

	@Override
	public Holder<PaintingVariant> getVariant() {
		return this.entityData.get(IcariaPaintingEntity.PAINTING_VARIANT);
	}

	@Nullable
	@Override
	public ItemEntity spawnAtLocation(ServerLevel pServerLevel, ItemLike pItemLike) {
		return super.spawnAtLocation(pServerLevel, IcariaItems.PAINTING.get());
	}

	@Override
	public ItemStack getPickResult() {
		return new ItemStack(IcariaItems.PAINTING.get());
	}

	public static Optional<Painting> create(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		var arrayList = new ArrayList<Holder<PaintingVariant>>();
		var paintingEntity = new IcariaPaintingEntity(pLevel, pBlockPos);
		pLevel.registryAccess().lookupOrThrow(Registries.PAINTING_VARIANT).getTagOrEmpty(IcariaPaintingVariantTagsProvider.PLACEABLE).forEach(arrayList::add);
		if (arrayList.isEmpty()) {
			return Optional.empty();
		} else {
			paintingEntity.setDirection(pDirection);
			IcariaPaintingEntity.survives(arrayList, paintingEntity);
			IcariaPaintingEntity.area(arrayList);
			var optional = Util.getRandomSafe(arrayList, paintingEntity.getRandom());
			if (optional.isEmpty()) {
				return Optional.empty();
			} else {
				paintingEntity.setVariant(optional.get());
				return Optional.of(paintingEntity);
			}
		}
	}
}
