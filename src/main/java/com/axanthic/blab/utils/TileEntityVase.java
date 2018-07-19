package com.axanthic.blab.utils;

import com.axanthic.blab.gui.ContainerVase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.NonNullList;

public class TileEntityVase extends TileEntityLockableLoot {
	private NonNullList<ItemStack> vaseContents = NonNullList.<ItemStack>withSize(32, ItemStack.EMPTY);

	public TileEntityVase() {
	}

	@Override
	public int getSizeInventory() {
		return 32;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.vaseContents)
			if (!itemstack.isEmpty())
				return false;

		return true;
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.vase";
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.vaseContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (!this.checkLootAndRead(compound))
			ItemStackHelper.loadAllItems(compound, this.vaseContents);

		if (compound.hasKey("CustomName", 8))
			this.customName = compound.getString("CustomName");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		if (!this.checkLootAndWrite(compound))
			ItemStackHelper.saveAllItems(compound, this.vaseContents);

		if (this.hasCustomName())
			compound.setString("CustomName", this.customName);

		return compound;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void invalidate() {
		super.invalidate();
		this.updateContainingBlockInfo();
	}

	@Override
	public String getGuiID() {
		return "blab:vase";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		this.fillWithLoot(playerIn);
		return new ContainerVase(playerInventory, this);
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.vaseContents;
	}
}
