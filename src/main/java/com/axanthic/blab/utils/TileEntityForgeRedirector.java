package com.axanthic.blab.utils;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;

public class TileEntityForgeRedirector extends TileEntityLockable implements ISidedInventory {

	public TileEntityForge original;

	public TileEntityForgeRedirector (TileEntityForge original) {
		super();
		this.original = original;
	}
	public TileEntityForgeRedirector () {
		super();
	}

	public int getSizeInventory() {
		if (original == null)
			return 0;
		return original.getSizeInventory();
	}

	public boolean isEmpty() {
		if (original == null)
			return false;
		return original.isEmpty();
	}

	public ItemStack getStackInSlot(int index) {
		if (original == null)
			return ItemStack.EMPTY;
		return original.getStackInSlot(index);
	}

	/**
	 * Removes up to a specified number of items from an inventory slot and returns
	 * them in a new stack.
	 */
	public ItemStack decrStackSize(int index, int count) {
		if (original == null)
			return ItemStack.EMPTY;
		return original.decrStackSize(index, count);
	}

	/**
	 * Removes a stack from the given slot and returns it.
	 */
	public ItemStack removeStackFromSlot(int index) {
		if (original == null)
			return ItemStack.EMPTY;
		return original.removeStackFromSlot(index);
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections).
	 */
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (original == null)
			return;
		original.setInventorySlotContents(index, stack);
	}

	/**
	 * Get the name of this object. For players this returns their username
	 */
	public String getName() {
		if (original == null)
			return "";
		return original.getName();
	}

	/**
	 * Returns true if this thing is named
	 */
	public boolean hasCustomName() {
		if (original == null)
			return false;
		return original.hasCustomName();
	}

	public void setCustomInventoryName(String p_145951_1_) {
		if (original == null)
			return;
		original.setCustomInventoryName(p_145951_1_);
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64,
	 * possibly will be extended.
	 */
	public int getInventoryStackLimit() {
		if (original == null)
			return 64;
		return original.getInventoryStackLimit();
	}

	public boolean isBurning() {
		if (original == null)
			return false;
		return original.isBurning();
	}

	public int getCookTime(ItemStack stack) {
		if (original == null)
			return 0;
		return original.getCookTime(stack);
	}

	/**
	 * Don't rename this method to canInteractWith due to conflicts with Container
	 */
	public boolean isUsableByPlayer(EntityPlayer player) {
		return false;
	}

	public void openInventory(EntityPlayer player) {
	}

	public void closeInventory(EntityPlayer player) {
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot. For guis use Slot.isItemValid
	 */
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (original == null)
			return false;
		return original.isItemValidForSlot(index, stack);
	}

	public int[] getSlotsForFace(EnumFacing side) {
		if (original == null)
			return new int[] { 0 };
		return original.getSlotsForFace(side);
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from
	 * the given side.
	 */
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		if (original == null)
			return false;
		return original.canInsertItem(index, itemStackIn, direction);
	}

	/**
	 * Returns true if automation can extract the given item in the given slot from
	 * the given side.
	 */
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		if (original == null)
			return false;
		return original.canExtractItem(index, stack, direction);
	}

	public String getGuiID() {
		if (original == null)
			return "";
		return original.getGuiID();
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		if (original == null)
			return null;
		return original.createContainer(playerInventory, playerIn);
	}

	public int getField(int id) {
		if (original == null)
			return 0;
		return original.getField(id);
	}

	public void setField(int id, int value) {
		if (original == null)
			return;
		original.setField(id, value);
	}

	public int getFieldCount() {
		if (original == null)
			return 0 ;
		return original.getFieldCount();
	}

	public void clear() {
		if (original == null)
			return;
		original.clear();
	}

	@Override
	public boolean hasCapability(net.minecraftforge.common.capabilities.Capability<?> capability, @Nullable net.minecraft.util.EnumFacing facing) {
		if (original == null)
			return false;
		return original.hasCapability(capability, facing);
	}

	@Override
	@javax.annotation.Nullable
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
		if (original == null)
			return null;
		return original.getCapability(capability, facing);
	}
}