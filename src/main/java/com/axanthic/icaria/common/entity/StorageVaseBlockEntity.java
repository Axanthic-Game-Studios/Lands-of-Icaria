package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.handler.StorageVaseItemStackHandler;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseBlockEntity extends BlockEntity {
	public int size = 32;

	public ItemStackHandler stackHandler = new StorageVaseItemStackHandler(this.size, this);

	public LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> this.stackHandler);

	public SimpleContainer simpleContainer = new SimpleContainer(this.size);

	public StorageVaseBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.STORAGE_VASE.get(), pPos, pState);
	}

	public int getComparatorInput() {
		return this.itemHandler.map(ItemHandlerHelper::calcRedstoneFromInventory).orElse(0);
	}

	public void drops(Level pLevel) {
		for (int i = 0; i < this.size; i++) {
			this.simpleContainer.setItem(i, stackHandler.getStackInSlot(i));
		}

		Containers.dropContents(pLevel, this.worldPosition, this.simpleContainer);
	}

	@Override
	public void load(CompoundTag pTag) {
		super.load(pTag);
		if (pTag.contains("Inventory")) {
			this.stackHandler.deserializeNBT(pTag.getCompound("Inventory"));
		}
	}

	@Override
	public void saveAdditional(CompoundTag pTag) {
		super.saveAdditional(pTag);
		pTag.put("Inventory", this.stackHandler.serializeNBT());
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		this.itemHandler.invalidate();
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> pCapability, @Nullable Direction pDirection) {
		return pCapability == ForgeCapabilities.ITEM_HANDLER ? this.itemHandler.cast() : super.getCapability(pCapability, pDirection);
	}
}
