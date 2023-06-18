package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaMenus;
import com.axanthic.icaria.common.slot.GrinderFuelSlot;
import com.axanthic.icaria.common.slot.GrinderGearSlot;
import com.axanthic.icaria.common.slot.IcariaOutputSlot;

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
	public ContainerData data;

	public GrinderBlockEntity entity;

	public IItemHandler handler;

	public Player player;

	public GrinderMenu(int pContainerId, BlockPos pPos, Inventory pInventory, Player pPlayer) {
		super(IcariaMenus.GRINDER.get(), pContainerId);
		this.entity = (GrinderBlockEntity) pPlayer.getCommandSenderWorld().getBlockEntity(pPos);
		this.handler = new InvWrapper(pInventory);
		this.player = pPlayer;
		if (this.entity != null) {
			this.data = this.entity.getData();
			this.addDataSlots(this.data);
			this.entity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(pItemHandler -> {
				this.addSlot(new SlotItemHandler(pItemHandler, 0, 37, 20)); // INPUT
				this.addSlot(new GrinderFuelSlot(pItemHandler, 1, 37, 56)); // FUEL
				this.addSlot(new GrinderGearSlot(pItemHandler, 2, 97, 47)); // GEAR
				this.addSlot(new IcariaOutputSlot(pItemHandler, 3, 123, 20)); // OUTPUT
				this.addSlot(new IcariaOutputSlot(pItemHandler, 4, 123, 38)); // OUTPUT
				this.addSlot(new IcariaOutputSlot(pItemHandler, 5, 123, 56)); // OUTPUT
			});
		}

		this.layoutPlayerInventorySlots(8, 73);
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return !this.entity.isRemoved();
	}

	public int getMaxFuel() {
		return this.data.get(0);
	}

	public int getFuel() {
		return this.data.get(1);
	}

	public int getMaxProgress() {
		return this.data.get(2);
	}

	public int getProgress() {
		return this.data.get(3);
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
		this.addSlotBox(this.handler, 9, pLeftColumn, pTopRow, 9, 18, 3, 18);
		pTopRow += 76;
		this.addSlotRange(this.handler, 0, pLeftColumn, pTopRow, 9, 18);
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
		}

		return emptyStack;
	}
}
