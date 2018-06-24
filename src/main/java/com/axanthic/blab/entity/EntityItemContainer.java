package com.axanthic.blab.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class EntityItemContainer extends EntityLivingBase {

	public ItemStack contained = ItemStack.EMPTY;

	public EntityItemContainer(World worldIn) {
		super(worldIn);
	}

	public EntityItemContainer(World worldIn, ItemStack item) {
		super(worldIn);
		contained = item;
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		return NonNullList.<ItemStack>withSize(1, contained);
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
		return contained;
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
		contained = stack;
	}

	@Override
	public EnumHandSide getPrimaryHand() {
		return EnumHandSide.RIGHT;
	}

	@Override
	public ItemStack getActiveItemStack() {
		return contained;
	}

	@Override
	public ItemStack getHeldItemMainhand() {
		return contained;
	}

	@Override
	public ItemStack getHeldItemOffhand() {
		return contained;
	}

	@Override
	public ItemStack getHeldItem(EnumHand hand) {
		return contained;
	}
}
