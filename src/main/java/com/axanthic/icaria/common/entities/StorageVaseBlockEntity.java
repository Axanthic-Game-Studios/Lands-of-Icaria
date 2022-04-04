package com.axanthic.icaria.common.entities;

import com.axanthic.icaria.common.registry.IcariaBlockEntities;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseBlockEntity extends BlockEntity {
	public final ItemStackHandler itemStackHandler = createHandler();
	public final LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> itemStackHandler);

	public StorageVaseBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(IcariaBlockEntities.STORAGE_VASE.get(), pWorldPosition, pBlockState);
	}

	public int getComparatorInput() {
		return itemHandler.map(ItemHandlerHelper::calcRedstoneFromInventory).orElse(0);
	}

	@Override
	public void load(CompoundTag pTag) {
		if (pTag.contains("Inventory")) {
			itemStackHandler.deserializeNBT(pTag.getCompound("Inventory"));
		}

		super.load(pTag);
	}

	@Override
	public void saveAdditional(CompoundTag pTag) {
		pTag.put("Inventory", itemStackHandler.serializeNBT());
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		itemHandler.invalidate();
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
	public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return itemHandler.cast();
		}

		return super.getCapability(capability, direction);
	}
}
