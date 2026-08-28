package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.KilnBlockEntity;
import com.axanthic.icaria.common.registry.IcariaMenus;
import com.axanthic.icaria.common.slot.KilnSlot;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
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

public class KilnMenu extends AbstractContainerMenu {
	public KilnBlockEntity blockEntity;

	public ContainerData containerData;

	public KilnMenu(int pContainerId, @Nullable KilnBlockEntity pBlockEntity, @Nullable Player pPlayer, ContainerData pContainerData, Inventory pInventory, ItemStacksResourceHandler pHandler) {
		super(IcariaMenus.KILN.get(), pContainerId);
		this.setBlockEntity(pBlockEntity);
		this.setContainerData(pContainerData);
		this.addDataSlots(pContainerData);
		this.addSlot(new ResourceHandlerSlot(pHandler, pHandler::set, 0, 45, 58));
		this.addSlot(new ResourceHandlerSlot(pHandler, pHandler::set, 1, 45, 22));
		this.addSlot(new KilnSlot(pBlockEntity, pPlayer, pHandler, pHandler::set, 2, 111, 40));
		this.addSlots(pInventory, 9, 9, 3, 8, 94);
		this.addSlots(pInventory, 0, 9, 1, 8, 152);
	}

	public KilnMenu(int pContainerId, Inventory pInventory) {
		this(pContainerId, null, null, new SimpleContainerData(4), pInventory, new ItemStacksResourceHandler(3));
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
		if (pIndex < 3) {
			this.moveItemStackTo(pItemStack, 3, 39, true);
		} else {
			this.moveItemStackTo(pItemStack, 0, 2, false);
		}
	}

	public void hotbarPlayer(ItemStack pItemStack, int pIndex) {
		if (pIndex > 2 && pIndex < 30) {
			this.moveItemStackTo(pItemStack, 30, 39, true);
		} else {
			this.moveItemStackTo(pItemStack, 3, 30, false);
		}
	}

	public void setBlockEntity(@Nullable KilnBlockEntity pBlockEntity) {
		this.blockEntity = pBlockEntity;
	}

	public void setContainerData(ContainerData pContainerData) {
		this.containerData = pContainerData;
	}

	public KilnBlockEntity getBlockEntity() {
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
