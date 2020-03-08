package com.axanthic.loi.spells;

import com.axanthic.loi.utils.KettleRecipe;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public interface ISpell {

	public KettleRecipe getRecipe();

	public ActionResult<ItemStack> castSpell(World worldIn, EntityPlayer playerIn, EnumHand handIn);

	public void drinkConcoction(ItemStack stack, World worldIn, EntityLivingBase entityLiving);
}
