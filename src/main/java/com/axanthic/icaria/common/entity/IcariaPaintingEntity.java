package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.provider.tags.IcariaPaintingTagsProvider;

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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingEntity extends Painting {
	public IcariaPaintingEntity(EntityType<? extends Painting> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public IcariaPaintingEntity(Level pLevel, BlockPos pBlockPos) {
		super(IcariaEntityTypes.PAINTING.get(), pLevel);
		this.pos = pBlockPos;
	}

	public static int variantArea(Holder<PaintingVariant> pHolder) {
		return pHolder.value().area();
	}

	public static void area(ArrayList<Holder<PaintingVariant>> pPaintingVariants) {
		pPaintingVariants.removeIf((holder) -> IcariaPaintingEntity.variantArea(holder) < pPaintingVariants.stream().mapToInt(IcariaPaintingEntity::variantArea).max().orElse(0));
	}

	public static void survives(ArrayList<Holder<PaintingVariant>> pPaintingVariants, IcariaPaintingEntity pEntity) {
		pPaintingVariants.removeIf(
			(holder) -> {
				pEntity.setVariant(holder);
				return !pEntity.survives();
			}
		);
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
		pLevel.registryAccess().lookupOrThrow(Registries.PAINTING_VARIANT).getTagOrEmpty(IcariaPaintingTagsProvider.PLACEABLE).forEach(arrayList::add);
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
