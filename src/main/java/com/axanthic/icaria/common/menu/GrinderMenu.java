package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.handler.item.GrinderOutputSlotItemHandler;
import com.axanthic.icaria.common.registry.IcariaMenus;

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

import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderMenu extends AbstractContainerMenu {
	public GrinderBlockEntity blockEntity;

	public ContainerData containerData;

	public GrinderMenu(int pContainerId, Inventory pInventory) {
		this(pContainerId, pInventory, new SimpleContainerData(4), new ItemStackHandler(1), new ItemStackHandler(1), new ItemStackHandler(1), new ItemStackHandler(3), null, null);
	}

	public GrinderMenu(int pContainerId, Inventory pInventory, ContainerData pContainerData, ItemStackHandler pFuel, ItemStackHandler pGear, ItemStackHandler pInput, ItemStackHandler pOutput, @Nullable GrinderBlockEntity pBlockEntity, @Nullable Player pPlayer) {
		super(IcariaMenus.GRINDER.get(), pContainerId);
		this.blockEntity = pBlockEntity;
		this.containerData = pContainerData;
		this.addDataSlots(pContainerData);
		this.addSlot(new SlotItemHandler(pFuel, 0, 36, 58));
		this.addSlot(new SlotItemHandler(pGear, 0, 98, 49));
		this.addSlot(new SlotItemHandler(pInput, 0, 36, 22));
		this.addSlot(new GrinderOutputSlotItemHandler(pOutput, pBlockEntity, pPlayer, 0, 124, 58));
		this.addSlot(new GrinderOutputSlotItemHandler(pOutput, pBlockEntity, pPlayer, 1, 124, 40));
		this.addSlot(new GrinderOutputSlotItemHandler(pOutput, pBlockEntity, pPlayer, 2, 124, 22));
		this.addSlots(pInventory, 9, 9, 3, 8, 94);
		this.addSlots(pInventory, 0, 9, 1, 8, 152);
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return !this.blockEntity.isRemoved();
	}

	public int getMaxFuel() {
		return this.containerData.get(0);
	}

	public int getFuel() {
		return this.containerData.get(1);
	}

	public int getMaxProgress() {
		return this.containerData.get(2);
	}

	public int getProgress() {
		return this.containerData.get(3);
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
