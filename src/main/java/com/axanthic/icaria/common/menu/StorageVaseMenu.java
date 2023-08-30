package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.StorageVaseBlockEntity;
import com.axanthic.icaria.common.registry.IcariaMenus;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseMenu extends AbstractContainerMenu {
	public StorageVaseBlockEntity blockEntity;

	public IItemHandler itemHandler;

	public StorageVaseMenu(int pId, BlockPos pPos, Inventory pInventory, Player pPlayer) {
		super(IcariaMenus.STORAGE_VASE.get(), pId);
		this.blockEntity = (StorageVaseBlockEntity) pPlayer.getCommandSenderWorld().getBlockEntity(pPos);
		this.itemHandler = new InvWrapper(pInventory);
		if (this.blockEntity != null) {
			this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> this.layoutVaseInventorySlots(handler, 26, 22));
		}

		this.layoutPlayerInventorySlots(8, 130);
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return !this.blockEntity.isRemoved();
	}

	public void addSlotBox(IItemHandler pItemHandler, int pIndex, int pX, int pY, int pCountX, int pDeltaX, int pCountY, int pDeltaY) {
		for (int j = 0; j < pCountY; j++) {
			pY += pDeltaY;
			pIndex = this.addSlotRange(pItemHandler, pIndex, pX, pY, pCountX, pDeltaX);
		}
	}

	public int addSlotRange(IItemHandler pItemHandler, int pIndex, int pX, int pY, int pCount, int pDeltaX) {
		for (int i = 0; i < pCount; i++) {
			this.addSlot(new SlotItemHandler(pItemHandler, pIndex, pX, pY));
			pX += pDeltaX;
			pIndex++;
		}

		return pIndex;
	}

	public void layoutPlayerInventorySlots(int pLeftColumn, int pTopRow) {
		this.addSlotBox(this.itemHandler, 9, pLeftColumn, pTopRow, 9, 18, 3, 18);
		pTopRow += 76;
		this.addSlotRange(this.itemHandler, 0, pLeftColumn, pTopRow, 9, 18);
	}

	public void layoutVaseInventorySlots(IItemHandler pItemHandler, int pLeftColumn, int pTopRow) {
		this.addSlotRange(pItemHandler, 0, pLeftColumn + 18, pTopRow, 5, 18);
		this.addSlotRange(pItemHandler, 5, pLeftColumn, pTopRow + 18, 7, 18);
		this.addSlotRange(pItemHandler, 12, pLeftColumn, pTopRow + 36, 7, 18);
		this.addSlotRange(pItemHandler, 19, pLeftColumn + 18, pTopRow + 54, 5, 18);
		this.addSlotRange(pItemHandler, 24, pLeftColumn + 36, pTopRow + 72, 3, 18);
		this.addSlotRange(pItemHandler, 27, pLeftColumn + 18, pTopRow + 90, 5, 18);
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
		}

		return emptyStack;
	}
}
