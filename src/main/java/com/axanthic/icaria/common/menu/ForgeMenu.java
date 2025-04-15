package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;
import com.axanthic.icaria.common.handler.item.ForgeOutputSlotItemHandler;
import com.axanthic.icaria.common.registry.IcariaMenus;

import javax.annotation.ParametersAreNonnullByDefault;

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

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeMenu extends AbstractContainerMenu {
	public ForgeBlockEntity blockEntity;

	public ContainerData containerData;

	public ForgeMenu(int pContainerId, BlockPos pBlockPos, Inventory pInventory, Player pPlayer) {
		super(IcariaMenus.FORGE.get(), pContainerId);
		if (pPlayer.getCommandSenderWorld().getBlockEntity(pBlockPos) instanceof ForgeBlockEntity forgeBlockEntity) {
			this.blockEntity = forgeBlockEntity;
			this.containerData = forgeBlockEntity.getData();
			this.addDataSlots(this.containerData);
			this.addSlot(new SlotItemHandler(this.blockEntity.fuelHandler, 0, 54, 58));
			this.addSlot(new SlotItemHandler(this.blockEntity.inputHandlerA, 0, 36, 22));
			this.addSlot(new SlotItemHandler(this.blockEntity.inputHandlerB, 0, 54, 22));
			this.addSlot(new SlotItemHandler(this.blockEntity.inputHandlerC, 0, 72, 22));
			this.addSlot(new ForgeOutputSlotItemHandler(this.blockEntity.outputHandler, this.blockEntity, pPlayer, 0, 120, 54));
			this.addSlot(new ForgeOutputSlotItemHandler(this.blockEntity.outputHandler, this.blockEntity, pPlayer, 1, 120, 26));
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
			this.moveItemStackTo(pItemStack, 0, 4, false);
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
