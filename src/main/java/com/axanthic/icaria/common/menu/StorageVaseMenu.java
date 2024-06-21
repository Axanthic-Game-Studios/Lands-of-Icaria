package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.registry.IcariaMenus;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseMenu extends AbstractContainerMenu {
	public Container container;

	public StorageVaseMenu(MenuType<?> pType, int pId, Inventory pInventory, Container pContainer) {
		super(pType, pId);
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

	public StorageVaseMenu(MenuType<?> pType, int pId, Inventory pInventory) {
		this(pType, pId, pInventory, new SimpleContainer(32));
	}

	public static StorageVaseMenu menu(int pId, Inventory pInventory) {
		return new StorageVaseMenu(IcariaMenus.STORAGE_VASE.get(), pId, pInventory);
	}

	public static StorageVaseMenu menu(int pId, Inventory pInventory, Container pContainer) {
		return new StorageVaseMenu(IcariaMenus.STORAGE_VASE.get(), pId, pInventory, pContainer);
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return this.container.stillValid(pPlayer);
	}

	public void addSlots(Container pContainer, int pStartIndex, int pCountX, int pCountY, int pStartX, int pStartY) {
		for (int x = 0; x < pCountX; x++) {
			for (int y = 0; y < pCountY; y++) {
				this.addSlot(new Slot(pContainer, pStartIndex + x + y * pCountX, pStartX + x * 18, pStartY + y * 18));
			}
		}
	}

	@Override
	public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
		var emptyStack = ItemStack.EMPTY;
		var slot = this.slots.get(pIndex);
		if (slot.hasItem()) {
			var itemStack = slot.getItem();
			emptyStack = itemStack.copy();
			if (pIndex < 32) {
				this.moveItemStackTo(itemStack, 32, 68, true);
			} else {
				this.moveItemStackTo(itemStack, 0, 32, false);
			}

			if (pIndex > 31 && pIndex < 59) {
				this.moveItemStackTo(itemStack, 59, 68, true);
			} else {
				this.moveItemStackTo(itemStack, 32, 59, false);
			}

			if (itemStack.getCount() == emptyStack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.setChanged();
		}

		return emptyStack;
	}
}
