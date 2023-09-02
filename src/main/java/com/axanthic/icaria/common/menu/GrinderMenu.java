package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaMenus;
import com.axanthic.icaria.common.slot.GrinderFuelSlot;
import com.axanthic.icaria.common.slot.GrinderGearSlot;
import com.axanthic.icaria.common.slot.GrinderOutputSlot;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderMenu extends AbstractContainerMenu {
	public GrinderBlockEntity blockEntity;

	public ContainerData containerData;

	public IItemHandler itemHandler;

	public GrinderMenu(int pContainerId, BlockPos pPos, Inventory pInventory, Player pPlayer) {
		super(IcariaMenus.GRINDER.get(), pContainerId);
		this.blockEntity = (GrinderBlockEntity) pPlayer.getCommandSenderWorld().getBlockEntity(pPos);
		this.itemHandler = new InvWrapper(pInventory);
		if (this.blockEntity != null) {
			this.containerData = this.blockEntity.getData();
			this.addDataSlots(this.containerData);
			this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(pItemHandler -> {
				this.addSlot(new SlotItemHandler(pItemHandler, 0, 36, 22)); // INPUT
				this.addSlot(new GrinderFuelSlot(pItemHandler, 1, 36, 58)); // FUEL
				this.addSlot(new GrinderGearSlot(pItemHandler, 2, 98, 49)); // GEAR
				this.addSlot(new GrinderOutputSlot(pItemHandler, this.blockEntity, pPlayer, 3, 124, 22)); // OUTPUT
				this.addSlot(new GrinderOutputSlot(pItemHandler, this.blockEntity, pPlayer, 4, 124, 40)); // OUTPUT
				this.addSlot(new GrinderOutputSlot(pItemHandler, this.blockEntity, pPlayer, 5, 124, 58)); // OUTPUT
			});
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
			if (pIndex < 6) {
				this.moveItemStackTo(itemStack, 6, 42, true);
			} else {
				this.moveItemStackTo(itemStack, 0, 6, false);
			}

			if (pIndex > 5 && pIndex < 33) {
				this.moveItemStackTo(itemStack, 33, 42, true);
			} else {
				this.moveItemStackTo(itemStack, 6, 33, false);
			}

			slot.onTake(pPlayer, itemStack);
		}

		return emptyStack;
	}
}
