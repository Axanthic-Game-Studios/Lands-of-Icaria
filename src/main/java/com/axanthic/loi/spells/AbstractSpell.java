package com.axanthic.loi.spells;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntitySpellWisp;
import com.axanthic.loi.proxy.CommonProxy;
import com.axanthic.loi.utils.KettleRecipe;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public abstract class AbstractSpell {

	public String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public KettleRecipe getRecipe() {
		return (KettleRecipe) CommonProxy.kettleRecipeRegistry.getValue(new ResourceLocation(ModInformation.ID, "recipe_" + this.name));
	}

	public abstract int getColor();

	public abstract ActionResult<ItemStack> castSpell(World worldIn, EntityPlayer playerIn, EnumHand handIn);

	public ActionResult<ItemStack> castSpellFromWand(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		return this.castSpell(worldIn, playerIn, handIn);
	}

	public void drinkConcoction(ItemStack stack, World worldIn, EntityLivingBase entityLiving) { }

	public void spellHit(RayTraceResult result, EntitySpellWisp wisp) { }
}
