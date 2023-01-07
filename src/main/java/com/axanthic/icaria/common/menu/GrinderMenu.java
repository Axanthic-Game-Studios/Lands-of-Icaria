package com.axanthic.icaria.common.menu;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaMenus;
import com.axanthic.icaria.common.util.GrinderFuelSlots;
import com.axanthic.icaria.common.util.IcariaOutputSlot;

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

public class GrinderMenu extends AbstractContainerMenu {
	public final ContainerData data;
	public GrinderBlockEntity entity;
	public IItemHandler inventory;
	public Player player;

	public GrinderMenu(int pContainerId, BlockPos pPos, Inventory pInventory, Player pPlayer) {
		super(IcariaMenus.GRINDER.get(), pContainerId);
		this.entity = (GrinderBlockEntity) pPlayer.getCommandSenderWorld().getBlockEntity(pPos);
		this.inventory = new InvWrapper(pInventory);
		this.player = pPlayer;
		this.data = entity.getData();		
		this.addDataSlots(data);
		
		if (entity != null) {
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
				this.addSlot(new SlotItemHandler(handler, 0, 37, 20)); // input
				this.addSlot(new GrinderFuelSlots(handler, 1, 37, 56)); // Fuel
				this.addSlot(new SlotItemHandler(handler, 2, 97, 47)); // Gear
				this.addSlot(new IcariaOutputSlot(handler, 3, 123, 20)); // Output 1
				this.addSlot(new IcariaOutputSlot(handler, 4, 123, 38)); // Output 2
				this.addSlot(new IcariaOutputSlot(handler, 5, 123, 56)); // Output 3
			});
		}

		layoutPlayerInventorySlots(8, 91 - 18);
	}

	@Override
	public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
		//TODO add quickMove
		return ItemStack.EMPTY;
	}

	public int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
		for (int i = 0; i < amount; i++) {
			addSlot(new SlotItemHandler(handler, index, x, y));
			x += dx;
			index++;
		}

		return index;
	}

	public void addSlotBox(IItemHandler handler, int index, int x, int y, int xAmount, int dx, int yAmount, int dy) {
		for (int j = 0; j < yAmount; j++) {
			y += dy;
			index = addSlotRange(handler, index, x, y, xAmount, dx);
		}
	}

	public void layoutPlayerInventorySlots(int leftColumn, int topRow) {
		addSlotBox(inventory, 9, leftColumn, topRow, 9, 18, 3, 18);
		topRow += 76;
		addSlotRange(inventory, 0, leftColumn, topRow, 9, 18);
	}

	@Override
	public boolean stillValid(Player pPlayer) {
		return !entity.isRemoved();
	}
	
	public int getTotalFuelTime() {
		return data.get(0);
	}
	
	public int getCurrentFuelTime() {
		return data.get(1);
	}
	
	public int getTotalProgressTime() {
		return data.get(2);
	}
	
	public int getCurrentProgressTime() {
		return data.get(3);
	}

}
