package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.registry.IcariaMenus;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseMenu extends AbstractContainerMenu {
	public Container container;

	public StorageVaseMenu(MenuType<?> pMenuType, int pId, Inventory pInventory, Container pContainer) {
		super(pMenuType, pId);
		this.container = pContainer;
		this.addSlots(pContainer, 0, 5, 1, 44, 22);
		this.addSlots(pContainer, 5, 7, 1, 26, 40);
		this.addSlots(pContainer, 12, 7, 1, 26, 58);
		this.addSlots(pContainer, 19, 5, 1, 44, 76);
		this.addSlots(pContainer, 24, 3, 1, 62, 94);
		this.addSlots(pContainer, 27, 5, 1, 44, 112);
		this.addSlots(pInventory, 9, 9, 3, 8, 148);
		this.addSlots(pInventory, 0, 9, 1, 8, 206);
	}

	public StorageVaseMenu(MenuType<?> pMenuType, int pId, Inventory pInventory) {
		this(pMenuType, pId, pInventory, new SimpleContainer(32));
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return this.container.stillValid(pPlayer);
	}

	public void addSlots(Container pContainer, int pStartIndex, int pCountX, int pCountY, int pStartX, int pStartY) {
		for (var x = 0; x < pCountX; x++) {
			for (var y = 0; y < pCountY; y++) {
				this.addSlot(new Slot(pContainer, pStartIndex + x + y * pCountX, pStartX + x * 18, pStartY + y * 18));
			}
		}
	}

	public void entityPlayer(ItemStack pItemStack, int pIndex) {
		if (pIndex < 32) {
			this.moveItemStackTo(pItemStack, 32, 68, true);
		} else {
			this.moveItemStackTo(pItemStack, 0, 32, false);
		}
	}

	public void hotbarPlayer(ItemStack pItemStack, int pIndex) {
		if (pIndex > 31 && pIndex < 59) {
			this.moveItemStackTo(pItemStack, 59, 68, true);
		} else {
			this.moveItemStackTo(pItemStack, 32, 59, false);
		}
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

	public static StorageVaseMenu menu(int pId, Inventory pInventory, Container pContainer) {
		return new StorageVaseMenu(IcariaMenus.STORAGE_VASE.get(), pId, pInventory, pContainer);
	}

	public static StorageVaseMenu menu(int pId, Inventory pInventory) {
		return new StorageVaseMenu(IcariaMenus.STORAGE_VASE.get(), pId, pInventory);
	}
}
