package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.variant.VariantUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RugEntity extends HangingEntity {
	public static final EntityDataAccessor<Direction> PLACEMENT_DIRECTION = SynchedEntityData.defineId(RugEntity.class, EntityDataSerializers.DIRECTION);
	public static final EntityDataAccessor<Holder<PaintingVariant>> PAINTING_VARIANT = SynchedEntityData.defineId(RugEntity.class, EntityDataSerializers.PAINTING_VARIANT);
	public static final EntityDataAccessor<ItemStack> ITEM_STACK = SynchedEntityData.defineId(RugEntity.class, EntityDataSerializers.ITEM_STACK);

	public RugEntity(EntityType<? extends HangingEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public RugEntity(BlockPos pBlockPos, Direction pHorizontalDirection, ItemStack pItemStack, Level pLevel) {
		super(IcariaEntityTypes.RUG.get(), pLevel);
		this.setItemStack(pItemStack);
		this.setPlacementDirection(pHorizontalDirection);
		this.setPos(pBlockPos.getX(), pBlockPos.getY(), pBlockPos.getZ());
	}

	@Override
	public boolean survives() {
		return this.level().getBlockStates(this.calculateSupportBox()).allMatch(BlockBehaviour.BlockStateBase::isSolid) && this.level().getEntities(this, this.getBoundingBox()).stream().noneMatch(entity -> entity instanceof HangingEntity) && this.level().noCollision(this);
	}

	public static int variantArea(Holder<PaintingVariant> pPaintingVariant) {
		return pPaintingVariant.value().area();
	}

	@Override
	public void addAdditionalSaveData(ValueOutput pValueOutput) {
		super.addAdditionalSaveData(pValueOutput);
		pValueOutput.store("Direction", Direction.CODEC, this.getDirection());
		pValueOutput.store("PlacementDirection", Direction.CODEC, this.getPlacementDirection());
		pValueOutput.store("ItemStack", ItemStack.CODEC, this.getItemStack());
		VariantUtils.writeVariant(pValueOutput, this.getPaintingVariant());
	}

	public static void area(ArrayList<Holder<PaintingVariant>> pPaintingVariants) {
		pPaintingVariants.removeIf(paintingVariant -> RugEntity.variantArea(paintingVariant) < pPaintingVariants.stream().mapToInt(RugEntity::variantArea).max().orElse(0));
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		super.defineSynchedData(pBuilder);
		pBuilder.define(RugEntity.PLACEMENT_DIRECTION, Direction.NORTH);
		pBuilder.define(RugEntity.ITEM_STACK, ItemStack.EMPTY);
		pBuilder.define(RugEntity.PAINTING_VARIANT, VariantUtils.getAny(this.registryAccess(), Registries.PAINTING_VARIANT));
	}

	@Override
	public void dropItem(ServerLevel pServerLevel, @Nullable Entity pEntity) {
		var flag = pEntity instanceof Player player && player.hasInfiniteMaterials();
		if (pServerLevel.getGameRules().get(GameRules.ENTITY_DROPS)) {
			this.playSound(SoundEvents.WOOL_BREAK, 1.0F, 1.0F);
			if (!flag) {
				this.spawnAtLocation(pServerLevel, this.getItemStack());
			}
		}
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> pEntityDataAccessor) {
		super.onSyncedDataUpdated(pEntityDataAccessor);
		if (pEntityDataAccessor.equals(RugEntity.PLACEMENT_DIRECTION)) {
			this.setPlacementDirection(this.getPlacementDirection());
		}

		if (pEntityDataAccessor.equals(RugEntity.ITEM_STACK)) {
			this.setItemStack(this.getItemStack());
		}

		if (pEntityDataAccessor.equals(RugEntity.PAINTING_VARIANT)) {
			this.recalculateBoundingBox();
		}
	}

	@Override
	public void playPlacementSound() {
		this.playSound(SoundEvents.WOOL_PLACE, 1.0F, 1.0F);
	}

	@Override
	public void readAdditionalSaveData(ValueInput pValueInput) {
		super.readAdditionalSaveData(pValueInput);
		this.setDirection(pValueInput.read("Direction", Direction.CODEC).orElse(Direction.NORTH));
		this.setPlacementDirection(pValueInput.read("PlacementDirection", Direction.CODEC).orElse(Direction.NORTH));
		this.setItemStack(pValueInput.read("ItemStack", ItemStack.CODEC).orElse(ItemStack.EMPTY));
		VariantUtils.readVariant(pValueInput, Registries.PAINTING_VARIANT).ifPresent(this::setPaintingVariant);
	}

	@Override
	public void setDirection(Direction pDirection) {
		super.setDirectionRaw(pDirection);
		if (pDirection.getAxis().isHorizontal()) {
			this.setYRot(pDirection.toYRot());
		} else {
			this.setXRot(-90.0F);
		}
	}

	public void setItemStack(ItemStack pItemStack) {
		this.entityData.set(RugEntity.ITEM_STACK, pItemStack);
	}

	public void setPaintingVariant(Holder<PaintingVariant> pPaintingVariant) {
		this.entityData.set(RugEntity.PAINTING_VARIANT, pPaintingVariant);
	}

	public void setPlacementDirection(Direction pDirection) {
		this.entityData.set(RugEntity.PLACEMENT_DIRECTION, pDirection);
	}

	public static void survives(ArrayList<Holder<PaintingVariant>> pPaintingVariants, RugEntity pRugEntity) {
		pPaintingVariants.removeIf(
			paintingVariant -> {
				pRugEntity.setPaintingVariant(paintingVariant);
				return !pRugEntity.survives();
			}
		);
	}

	@Override
	public AABB calculateBoundingBox(BlockPos pBlockPos, Direction pDirection) {
		var paintingVariant = this.getPaintingVariant().value();
		if (pDirection.getAxis().isHorizontal()) {
			return this.calculateBoundingBox(pBlockPos, pDirection, paintingVariant);
		} else {
			return this.calculatePlacementBoundingBox(pBlockPos, paintingVariant);
		}
	}

	public AABB calculateBoundingBox(BlockPos pBlockPos, Direction pDirection, PaintingVariant pPaintingVariant) {
		var x = pDirection.getAxis() == Direction.Axis.X ? 0.0625F : pPaintingVariant.width();
		var y = pPaintingVariant.height();
		var z = pDirection.getAxis() == Direction.Axis.Z ? 0.0625F : pPaintingVariant.width();
		if (pDirection.getAxisDirection() == Direction.AxisDirection.NEGATIVE) {
			return new AABB(pBlockPos.getX() + 1.0F, pBlockPos.getY() + 1.0F, pBlockPos.getZ() + 1.0F, pBlockPos.getX() - x + 1.0F, pBlockPos.getY() - y + 1.0F, pBlockPos.getZ() - z + 1.0F);
		} else {
			return new AABB(pBlockPos.getX(), pBlockPos.getY() + 1.0F, pBlockPos.getZ(), pBlockPos.getX() + x, pBlockPos.getY() - y + 1.0F, pBlockPos.getZ() + z);
		}
	}

	public AABB calculatePlacementBoundingBox(BlockPos pBlockPos, PaintingVariant pPaintingVariant) {
		var x = this.getPlacementDirection().getAxis() == Direction.Axis.X ? pPaintingVariant.height() : pPaintingVariant.width();
		var z = this.getPlacementDirection().getAxis() == Direction.Axis.Z ? pPaintingVariant.height() : pPaintingVariant.width();
		if (this.getPlacementDirection() == Direction.NORTH) {
			return new AABB(pBlockPos.getX(), pBlockPos.getY(), pBlockPos.getZ() + 1.0F, pBlockPos.getX() + x, pBlockPos.getY() + 0.0625F, pBlockPos.getZ() - z + 1.0F);
		} else if (this.getPlacementDirection() == Direction.EAST) {
			return new AABB(pBlockPos.getX(), pBlockPos.getY(), pBlockPos.getZ(), pBlockPos.getX() + x, pBlockPos.getY() + 0.0625F, pBlockPos.getZ() + z);
		} else if (this.getPlacementDirection() == Direction.SOUTH) {
			return new AABB(pBlockPos.getX() + 1.0F, pBlockPos.getY(), pBlockPos.getZ(), pBlockPos.getX() - x + 1.0F, pBlockPos.getY() + 0.0625F, pBlockPos.getZ() + z);
		} else {
			return new AABB(pBlockPos.getX() + 1.0F, pBlockPos.getY(), pBlockPos.getZ() + 1.0F, pBlockPos.getX() - x + 1.0F, pBlockPos.getY() + 0.0625F, pBlockPos.getZ() - z + 1.0F);
		}
	}

	public Direction getPlacementDirection() {
		return this.entityData.get(RugEntity.PLACEMENT_DIRECTION);
	}

	public Holder<PaintingVariant> getPaintingVariant() {
		return this.entityData.get(RugEntity.PAINTING_VARIANT);
	}

	public ItemStack getItemStack() {
		return this.entityData.get(RugEntity.ITEM_STACK);
	}

	@Override
	public ItemStack getPickResult() {
		return this.getItemStack();
	}

	public static Optional<RugEntity> create(BlockPos pBlockPos, Direction pDirection, Direction pHorizontalDirection, ItemStack pItemStack, Level pLevel, TagKey<PaintingVariant> pTagKey) {
		var arrayList = new ArrayList<Holder<PaintingVariant>>();
		var rugEntity = new RugEntity(pBlockPos, pHorizontalDirection, pItemStack, pLevel);
		pLevel.registryAccess().lookupOrThrow(Registries.PAINTING_VARIANT).getTagOrEmpty(pTagKey).forEach(arrayList::add);
		if (arrayList.isEmpty()) {
			return Optional.empty();
		} else {
			rugEntity.setDirection(pDirection);
			RugEntity.survives(arrayList, rugEntity);
			RugEntity.area(arrayList);
			var optional = Util.getRandomSafe(arrayList, rugEntity.getRandom());
			if (optional.isEmpty()) {
				return Optional.empty();
			} else {
				rugEntity.setPaintingVariant(optional.get());
				return Optional.of(rugEntity);
			}
		}
	}

	@Override
	public Vec3 trackingPosition() {
		var blockPos = this.getPos();
		return Vec3.atLowerCornerOf(blockPos);
	}
}
