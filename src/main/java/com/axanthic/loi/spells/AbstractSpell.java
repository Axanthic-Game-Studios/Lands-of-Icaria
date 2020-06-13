package com.axanthic.loi.spells;

import com.axanthic.loi.utils.KettleRecipe;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class AbstractSpell {

	public abstract KettleRecipe getRecipe();

	public abstract ActionResult<ItemStack> castSpell(World worldIn, EntityPlayer playerIn, EnumHand handIn);

	public ActionResult<ItemStack> castSpellFromWand(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		return this.castSpell(worldIn, playerIn, handIn);
	}

	public abstract void drinkConcoction(ItemStack stack, World worldIn, EntityLivingBase entityLiving);
}
