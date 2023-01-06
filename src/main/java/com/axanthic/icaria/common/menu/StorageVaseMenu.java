package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.registry.IcariaMenus;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("SameParameterValue")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseMenu extends AbstractContainerMenu {
	public BlockEntity entity;
	public IItemHandler handler;
	public Player player;

	public StorageVaseMenu(int pId, BlockPos pPos, Inventory pInventory, Player pPlayer) {
		super(IcariaMenus.STORAGE_VASE.get(), pId);
		this.entity = pPlayer.getCommandSenderWorld().getBlockEntity(pPos);
		this.handler = new InvWrapper(pInventory);
		this.player = pPlayer;
		if (this.entity != null) {
			this.entity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> this.layoutVaseInventorySlots(handler, 26, -10));
		}

		this.layoutPlayerInventorySlots(8, 94);
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return !this.entity.isRemoved();
	}

	public int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
		for (int i = 0; i < amount; i++) {
			this.addSlot(new SlotItemHandler(handler, index, x, y));
			x += dx;
			index++;
		}

		return index;
	}

	public void addSlotBox(IItemHandler handler, int index, int x, int y, int xAmount, int dx, int yAmount, int dy) {
		for (int j = 0; j < yAmount; j++) {
			y += dy;
			index = this.addSlotRange(handler, index, x, y, xAmount, dx);
		}
	}

	public void layoutPlayerInventorySlots(int leftColumn, int topRow) {
		this.addSlotBox(this.handler, 9, leftColumn, topRow, 9, 18, 3, 18);
		topRow += 76;
		this.addSlotRange(this.handler, 0, leftColumn, topRow, 9, 18);
	}

	public void layoutVaseInventorySlots(IItemHandler handler, int leftCol, int topRow) {
		this.addSlotRange(handler, 0, leftCol + 18, topRow, 5, 18);
		this.addSlotRange(handler, 5, leftCol, topRow + 18, 7, 18);
		this.addSlotRange(handler, 12, leftCol, topRow + 36, 7, 18);
		this.addSlotRange(handler, 19, leftCol + 18, topRow + 54, 5, 18);
		this.addSlotRange(handler, 24, leftCol + 36, topRow + 72, 3, 18);
		this.addSlotRange(handler, 27, leftCol + 18, topRow + 90, 5, 18);
	}

	@Override
	public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
		ItemStack emptyStack = ItemStack.EMPTY;
		Slot slot = this.slots.get(pIndex);
		if (slot.hasItem()) {
			ItemStack itemStack = slot.getItem();
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
