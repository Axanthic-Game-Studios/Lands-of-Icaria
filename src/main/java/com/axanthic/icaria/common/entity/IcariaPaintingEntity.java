package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.data.tags.IcariaPaintingVariantTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingEntity extends Painting {
	public IcariaPaintingEntity(EntityType<? extends Painting> pType, Level pLevel) {
		super(pType, pLevel);
	}

	public IcariaPaintingEntity(Level pLevel, BlockPos pPos) {
		super(IcariaEntityTypes.PAINTING.get(), pLevel);
		this.pos = pPos;
	}

	public static int variantArea(Holder<PaintingVariant> pHolder) {
		return pHolder.value().area();
	}

	@Override
	public void setDirection(Direction pDirection) {
		Objects.requireNonNull(pDirection);
		Validate.isTrue(pDirection.getAxis().isHorizontal());
		this.direction = pDirection;
		this.setYRot(this.getDirection().get2DDataValue() * 90.0F);
		this.yRotO = this.getYRot();
		this.recalculateBoundingBox();
	}

	@Override
	public ItemEntity spawnAtLocation(ItemLike pItem) {
		return super.spawnAtLocation(IcariaItems.PAINTING.get());
	}

	@Override
	public ItemStack getPickResult() {
		return IcariaItems.PAINTING.get().getDefaultInstance();
	}

	public static Optional<Painting> create(Level pLevel, BlockPos pPos, Direction pDirection) {
		var list = new ArrayList<Holder<PaintingVariant>>();
		var painting = new IcariaPaintingEntity(pLevel, pPos);
		pLevel.registryAccess().registryOrThrow(Registries.PAINTING_VARIANT).getTagOrEmpty(IcariaPaintingVariantTags.PLACEABLE).forEach(list::add);
		if (list.isEmpty()) {
			return Optional.empty();
		} else {
			painting.setDirection(pDirection);
			list.removeIf(
					holder -> {
						painting.setVariant(holder);
						return !painting.survives();
					}
			);

			if (list.isEmpty()) {
				return Optional.empty();
			} else {
				list.removeIf(holder -> IcariaPaintingEntity.variantArea(holder) < list.stream().mapToInt(IcariaPaintingEntity::variantArea).max().orElse(0));
				var optional = Util.getRandomSafe(list, painting.getRandom());
				if (optional.isEmpty()) {
					return Optional.empty();
				} else {
					painting.setDirection(pDirection);
					painting.setVariant(optional.get());
					return Optional.of(painting);
				}
			}
		}
	}
}
