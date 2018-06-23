package com.axanthic.blab.entity;

import javax.annotation.Nonnull;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityBident extends EntityArrow {

	public ItemStack bident = ItemStack.EMPTY;

	public EntityBident(World worldIn) {
		super(worldIn);
	}

	public EntityBident(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
		this.bident = shooter.getActiveItemStack();
	}

	public void setItemStack(ItemStack item) {
		this.bident = item;
	}

	@Override
	public ItemStack getArrowStack() {
		return bident;
	}

	@Override
	public void writeEntityToNBT(@Nonnull NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		NBTTagCompound stackTag = new NBTTagCompound();
		bident.writeToNBT(stackTag);
		compound.setTag("stack", stackTag);
	}

	@Override
	public void readEntityFromNBT(@Nonnull NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		NBTTagCompound stackTag = compound.getCompoundTag("stack");
		bident = new ItemStack(stackTag);
	}
}
