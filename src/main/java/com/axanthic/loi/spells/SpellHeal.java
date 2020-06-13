package com.axanthic.loi.spells;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.proxy.CommonProxy;
import com.axanthic.loi.utils.KettleRecipe;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SpellHeal extends AbstractSpell {

	@Override
	public KettleRecipe getRecipe() {
		return (KettleRecipe) CommonProxy.kettleRecipeRegistry.getValue(new ResourceLocation(ModInformation.ID, "recipe_molybdenumsteel"));
	}

	@Override
	public ActionResult<ItemStack> castSpell(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.heal(3.0f);
		if (!playerIn.isCreative())
			playerIn.getHeldItem(handIn).shrink(1);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	@Override
	public void drinkConcoction(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		entityLiving.heal(3.0f);
	}
}
