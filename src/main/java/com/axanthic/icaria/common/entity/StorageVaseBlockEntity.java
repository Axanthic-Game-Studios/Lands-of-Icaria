package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
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
	public void load(CompoundTag pTag) {
		super.load(pTag);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(pTag)) {
			ContainerHelper.loadAllItems(pTag, this.items);
		}
	}

	@Override
	public void saveAdditional(CompoundTag pTag) {
		super.saveAdditional(pTag);
		if (!this.trySaveLootTable(pTag)) {
			ContainerHelper.saveAllItems(pTag, this.items);
		}
	}

	@Override
	public void setItems(NonNullList<ItemStack> pItems) {
		this.items = pItems;
	}

	@Override
	public AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
		return new StorageVaseMenu(pId, this.worldPosition, pPlayer, pPlayer.player);
	}

	@Override
	public Component getDefaultName() {
		return Component.translatable("menu" + "." + IcariaInfo.ID + "." + "storage_vase");
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.items;
	}
}
