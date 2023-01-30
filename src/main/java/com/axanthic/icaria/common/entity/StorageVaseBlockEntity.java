package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class StorageVaseBlockEntity extends BlockEntity {
	public ItemStackHandler stackHandler = createHandler();

	public LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> this.stackHandler);

	public StorageVaseBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.STORAGE_VASE.get(), pPos, pState);
	}

	public int getComparatorInput() {
		return this.itemHandler.map(ItemHandlerHelper::calcRedstoneFromInventory).orElse(0);
	}

	@Override
	public void load(@Nonnull CompoundTag pTag) {
		super.load(pTag);
		if (pTag.contains("Inventory")) {
			this.stackHandler.deserializeNBT(pTag.getCompound("Inventory"));
		}
	}

	@Override
	public void saveAdditional(@Nonnull CompoundTag pTag) {
		super.saveAdditional(pTag);
		pTag.put("Inventory", this.stackHandler.serializeNBT());
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		this.itemHandler.invalidate();
	}

	public ItemStackHandler createHandler() {
		return new ItemStackHandler(32) {
			@Override
			public void onContentsChanged(int slot) {
				setChanged();
			}
		};
	}

	@Override
	public @Nonnull <T> LazyOptional<T> getCapability(@Nonnull Capability<T> pCapability, Direction pDirection) {
		if (pCapability == ForgeCapabilities.ITEM_HANDLER) {
			return this.itemHandler.cast();
		}

		return super.getCapability(pCapability, pDirection);
	}
}
