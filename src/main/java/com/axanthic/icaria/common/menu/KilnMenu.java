package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.KilnBlockEntity;
import com.axanthic.icaria.common.registry.IcariaMenus;
import com.axanthic.icaria.common.slot.KilnFuelSlot;
import com.axanthic.icaria.common.slot.KilnOutputSlot;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnMenu extends AbstractContainerMenu {
	public KilnBlockEntity blockEntity;

	public ContainerData containerData;

	public IItemHandler itemHandler;

	public KilnMenu(int pContainerId, BlockPos pPos, Inventory pInventory, Player pPlayer) {
		super(IcariaMenus.KILN.get(), pContainerId);
		this.blockEntity = (KilnBlockEntity) pPlayer.getCommandSenderWorld().getBlockEntity(pPos);
		this.itemHandler = new InvWrapper(pInventory);
		if (this.blockEntity != null) {
			this.containerData = this.blockEntity.getData();
			this.addDataSlots(this.containerData);
			this.blockEntity.getCapability(Capabilities.ITEM_HANDLER).ifPresent(
				pItemHandler -> {
					this.addSlot(new SlotItemHandler(pItemHandler, 0, 45, 22));
					this.addSlot(new KilnFuelSlot(pItemHandler, 1, 45, 58));
					this.addSlot(new KilnOutputSlot(pItemHandler, this.blockEntity, pPlayer, 2, 111, 40));
				}
			);
		}

		this.layoutPlayerInventorySlots(8, 76);
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

	public void addSlotBox(IItemHandler pItemHandler, int pIndex, int pX, int pY, int pCountX, int pDeltaX, int pCountY, int pDeltaY) {
		for (int j = 0; j < pCountY; j++) {
			pY += pDeltaY;
			pIndex = this.addSlotRange(pItemHandler, pIndex, pX, pY, pCountX, pDeltaX);
		}
	}

	public int addSlotRange(IItemHandler pItemHandler, int pIndex, int pX, int pY, int pCountX, int pDeltaX) {
		for (int i = 0; i < pCountX; i++) {
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

	@Override
	public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
		var emptyStack = ItemStack.EMPTY;
		var slot = this.slots.get(pIndex);
		if (slot.hasItem()) {
			var itemStack = slot.getItem();
			emptyStack = itemStack.copy();
			if (pIndex < 3) {
				this.moveItemStackTo(itemStack, 3, 39, true);
			} else {
				this.moveItemStackTo(itemStack, 0, 2, false);
			}

			if (pIndex > 2 && pIndex < 30) {
				this.moveItemStackTo(itemStack, 30, 39, true);
			} else {
				this.moveItemStackTo(itemStack, 3, 30, false);
			}

			if (itemStack.getCount() == emptyStack.getCount()) {
				return ItemStack.EMPTY;
			}
		}

		return emptyStack;
	}
}
