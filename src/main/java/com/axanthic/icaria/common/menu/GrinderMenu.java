package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.handler.item.GrinderOutputSlotItemHandler;
import com.axanthic.icaria.common.registry.IcariaMenus;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.SlotItemHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderMenu extends AbstractContainerMenu {
	public GrinderBlockEntity blockEntity;

	public ContainerData containerData;

	public GrinderMenu(int pContainerId, BlockPos pPos, Inventory pInventory, Player pPlayer) {
		super(IcariaMenus.GRINDER.get(), pContainerId);
		if (pPlayer.getCommandSenderWorld().getBlockEntity(pPos) instanceof GrinderBlockEntity grinderBlockEntity) {
			this.blockEntity = grinderBlockEntity;
			this.containerData = grinderBlockEntity.getData();
			this.addDataSlots(this.containerData);
			this.addSlot(new SlotItemHandler(this.blockEntity.fuelHandler, 0, 36, 58));
			this.addSlot(new SlotItemHandler(this.blockEntity.gearHandler, 0, 98, 49));
			this.addSlot(new SlotItemHandler(this.blockEntity.inputHandler, 0, 36, 22));
			this.addSlot(new GrinderOutputSlotItemHandler(this.blockEntity.outputHandler, this.blockEntity, pPlayer, 0, 124, 58));
			this.addSlot(new GrinderOutputSlotItemHandler(this.blockEntity.outputHandler, this.blockEntity, pPlayer, 1, 124, 40));
			this.addSlot(new GrinderOutputSlotItemHandler(this.blockEntity.outputHandler, this.blockEntity, pPlayer, 2, 124, 22));
			this.addSlots(pInventory, 9, 9, 3, 8, 94);
			this.addSlots(pInventory, 0, 9, 1, 8, 152);
		}
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
			if (pIndex < 6) {
				this.moveItemStackTo(itemStack, 6, 42, true);
			} else {
				this.moveItemStackTo(itemStack, 0, 3, false);
			}

			if (pIndex > 5 && pIndex < 33) {
				this.moveItemStackTo(itemStack, 33, 42, true);
			} else {
				this.moveItemStackTo(itemStack, 6, 33, false);
			}

			if (itemStack.getCount() == emptyStack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(pPlayer, itemStack);
		}

		return emptyStack;
	}
}
