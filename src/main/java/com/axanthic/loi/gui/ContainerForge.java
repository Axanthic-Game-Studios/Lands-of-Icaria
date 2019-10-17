package com.axanthic.loi.gui;

import com.axanthic.loi.tileentity.TileEntityForge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerForge extends Container {
	private final IInventory tileFurnace;
	private int cookTime;
	private int totalCookTime;
	private int furnaceBurnTime;
	private int currentItemBurnTime;

	public ContainerForge(InventoryPlayer playerInventory, IInventory furnaceInventory) {
		this.tileFurnace = furnaceInventory;
		this.addSlotToContainer(new Slot(furnaceInventory, 0, 38, 17));
		this.addSlotToContainer(new Slot(furnaceInventory, 1, 56, 17));
		this.addSlotToContainer(new Slot(furnaceInventory, 2, 74, 17));
		this.addSlotToContainer(new SlotFurnaceFuel(furnaceInventory, 3, 56, 53));
		this.addSlotToContainer(new SlotForgeOutput(playerInventory.player, furnaceInventory, 4, 116, 21));
		this.addSlotToContainer(new SlotForgeOutput(playerInventory.player, furnaceInventory, 5, 116, 49));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileFurnace);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i) {
			IContainerListener icontainerlistener = this.listeners.get(i);

			if (this.cookTime != this.tileFurnace.getField(2)) {
				icontainerlistener.sendWindowProperty(this, 2, this.tileFurnace.getField(2));
			}

			if (this.furnaceBurnTime != this.tileFurnace.getField(0)) {
				icontainerlistener.sendWindowProperty(this, 0, this.tileFurnace.getField(0));
			}

			if (this.currentItemBurnTime != this.tileFurnace.getField(1)) {
				icontainerlistener.sendWindowProperty(this, 1, this.tileFurnace.getField(1));
			}

			if (this.totalCookTime != this.tileFurnace.getField(3)) {
				icontainerlistener.sendWindowProperty(this, 3, this.tileFurnace.getField(3));
			}
		}

		this.cookTime = this.tileFurnace.getField(2);
		this.furnaceBurnTime = this.tileFurnace.getField(0);
		this.currentItemBurnTime = this.tileFurnace.getField(1);
		this.totalCookTime = this.tileFurnace.getField(3);
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		this.tileFurnace.setField(id, data);
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileFurnace.isUsableByPlayer(playerIn);
	}

	/**
	 * Handle when the stack in slot {@code index} is shift-clicked. Normally this
	 * moves the stack between the player inventory and the other inventory(s).
	 */
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index == 4 || index == 5) {
				if (!this.mergeItemStack(itemstack1, 6, 42, true)) {
					return ItemStack.EMPTY;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (index != 3 && index != 0 && index != 1 && index != 2) {
				if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty()) {
					if (!this.mergeItemStack(itemstack1, 0, 3, false)) {
						return ItemStack.EMPTY;
					}
				} else if (TileEntityFurnace.isItemFuel(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 3, 4, false)) {
						return ItemStack.EMPTY;
					}
				} else if (TileEntityForge.hasAlloyResult(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 0, 3, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 6 && index < 33) {
					if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 33 && index < 42 && !this.mergeItemStack(itemstack1, 6, 33, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 6, 42, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}
}