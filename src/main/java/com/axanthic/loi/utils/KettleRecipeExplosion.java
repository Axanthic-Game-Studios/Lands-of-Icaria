package com.axanthic.loi.utils;

import com.axanthic.loi.ModInformation;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KettleRecipeExplosion extends KettleRecipe {

	public KettleRecipeExplosion(ResourceLocation name, int color, Ingredient... inputs) {
		this.setRegistryName(name);
		this.color = color;
		this.recipeInputs = NonNullList.from(Ingredient.EMPTY, inputs);
		for (Ingredient input : inputs) {
			if (!allInputs.contains(input))
				allInputs.add(input);
		}
		for (int i = 0; i < recipeInputs.size(); ++i) {
			this.order.add(i);
		}
	}

	public KettleRecipeExplosion(String name, int color, Ingredient... inputs) {
		this(new ResourceLocation(ModInformation.ID, name), color, inputs);
	}

	public ItemStack getOutput(ItemStack... input) {
		return ItemStack.EMPTY;
	}

	public void performRecipe(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.createExplosion(playerIn, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, 5.0f, true);
	}
}
