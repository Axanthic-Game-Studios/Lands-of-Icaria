package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaMenus;
import com.axanthic.icaria.common.slot.GrinderSlot;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderMenu extends AbstractContainerMenu {
	public GrinderBlockEntity blockEntity;

	public ContainerData containerData;

	public GrinderMenu(int pContainerId, @Nullable GrinderBlockEntity pBlockEntity, @Nullable Player pPlayer, ContainerData pContainerData, Inventory pInventory, ItemStacksResourceHandler pHandler) {
		super(IcariaMenus.GRINDER.get(), pContainerId);
		this.setBlockEntity(pBlockEntity);
		this.setContainerData(pContainerData);
		this.addDataSlots(pContainerData);
		this.addSlot(new ResourceHandlerSlot(pHandler, pHandler::set, 0, 36, 58));
		this.addSlot(new ResourceHandlerSlot(pHandler, pHandler::set, 1, 98, 49));
		this.addSlot(new ResourceHandlerSlot(pHandler, pHandler::set, 2, 36, 22));
		this.addSlot(new GrinderSlot(pBlockEntity, pPlayer, pHandler, pHandler::set, 3, 124, 58));
		this.addSlot(new GrinderSlot(pBlockEntity, pPlayer, pHandler, pHandler::set, 4, 124, 40));
		this.addSlot(new GrinderSlot(pBlockEntity, pPlayer, pHandler, pHandler::set, 5, 124, 22));
		this.addSlots(pInventory, 9, 9, 3, 8, 94);
		this.addSlots(pInventory, 0, 9, 1, 8, 152);
	}

	public GrinderMenu(int pContainerId, Inventory pInventory) {
		this(pContainerId, null, null, new SimpleContainerData(4), pInventory, new ItemStacksResourceHandler(6));
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return !this.getBlockEntity().isRemoved();
	}

	public int getFuel() {
		return this.getContainerData().get(0);
	}

	public int getMaxFuel() {
		return this.getContainerData().get(1);
	}

	public int getProgress() {
		return this.getContainerData().get(2);
	}

	public int getMaxProgress() {
		return this.getContainerData().get(3);
	}

	public void addSlots(Container pContainer, int pStartIndex, int pCountX, int pCountY, int pStartX, int pStartY) {
		for (var x = 0; x < pCountX; x++) {
			for (var y = 0; y < pCountY; y++) {
				this.addSlot(new Slot(pContainer, pStartIndex + x + y * pCountX, pStartX + x * 18, pStartY + y * 18));
			}
		}
	}

	public void entityPlayer(ItemStack pItemStack, int pIndex) {
		if (pIndex < 6) {
			this.moveItemStackTo(pItemStack, 6, 42, true);
		} else {
			this.moveItemStackTo(pItemStack, 0, 3, false);
		}
	}

	public void hotbarPlayer(ItemStack pItemStack, int pIndex) {
		if (pIndex > 5 && pIndex < 33) {
			this.moveItemStackTo(pItemStack, 33, 42, true);
		} else {
			this.moveItemStackTo(pItemStack, 6, 33, false);
		}
	}

	public void setBlockEntity(@Nullable GrinderBlockEntity pBlockEntity) {
		this.blockEntity = pBlockEntity;
	}

	public void setContainerData(ContainerData pContainerData) {
		this.containerData = pContainerData;
	}

	public GrinderBlockEntity getBlockEntity() {
		return this.blockEntity;
	}

	public ContainerData getContainerData() {
		return this.containerData;
	}

	@Override
	public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
		var slot = this.slots.get(pIndex);

		var itemStack = slot.getItem();

		this.entityPlayer(itemStack, pIndex);
		this.hotbarPlayer(itemStack, pIndex);

		slot.onTake(pPlayer, itemStack);

		return ItemStack.EMPTY;
	}
}
