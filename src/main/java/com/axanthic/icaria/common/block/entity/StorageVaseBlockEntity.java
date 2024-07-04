package com.axanthic.icaria.common.block.entity;

import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseBlockEntity extends RandomizableContainerBlockEntity {
	public int size = 32;

	public NonNullList<ItemStack> items = NonNullList.withSize(this.size, ItemStack.EMPTY);

	public StorageVaseBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.STORAGE_VASE.get(), pPos, pBlockState);
	}

	@Override
	public int getContainerSize() {
		return this.size;
	}

	@Override
	public void loadAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.loadAdditional(pTag, pProvider);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(pTag)) {
			ContainerHelper.loadAllItems(pTag, this.items, pProvider);
		}
	}

	@Override
	public void saveAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.saveAdditional(pTag, pProvider);
		if (!this.trySaveLootTable(pTag)) {
			ContainerHelper.saveAllItems(pTag, this.items, pProvider);
		}
	}

	@Override
	public void setItems(NonNullList<ItemStack> pItems) {
		this.items = pItems;
	}

	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
		return StorageVaseMenu.menu(pContainerId, pInventory, this);
	}

	@Override
	public Component getDefaultName() {
		return Component.translatable("menu" + "." + IcariaIdents.ID + "." + "storage_vase");
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.items;
	}
}
