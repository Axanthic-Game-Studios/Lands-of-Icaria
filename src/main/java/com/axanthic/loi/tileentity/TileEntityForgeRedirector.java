package com.axanthic.loi.tileentity;

import javax.annotation.Nullable;

import com.axanthic.loi.blocks.BlockForge;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IInteractionObject;

public class TileEntityForgeRedirector extends TileEntity implements IInteractionObject {

	public TileEntityForge original;

	public TileEntityForgeRedirector (TileEntityForge original) {
		super();
		this.original = original;
	}
	public TileEntityForgeRedirector () {
		super();
	}

	public void onLoad() {
		super.onLoad();
		TileEntity hopefullyAForge = this.world.getTileEntity(BlockForge.getTileLocation(this.pos, this.world.getBlockState(this.pos)));
		if (hopefullyAForge instanceof TileEntityForge)
			this.original = (TileEntityForge) hopefullyAForge;
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

	@Override
	public boolean hasCapability(net.minecraftforge.common.capabilities.Capability<?> capability, @Nullable net.minecraft.util.EnumFacing facing) {
		if (original == null)
			return false;
		return original.hasCapabilityForPos(capability, facing, this.pos);
	}

	@Override
	@javax.annotation.Nullable
	public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing) {
		if (original == null)
			return null;
		return original.getCapabilityForPos(capability, facing, this.pos);
	}
}