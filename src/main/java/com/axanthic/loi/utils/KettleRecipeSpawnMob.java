package com.axanthic.loi.utils;

import javax.annotation.Nullable;

import com.axanthic.loi.ModInformation;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KettleRecipeSpawnMob extends KettleRecipe {

	public Class entitySpawn;

	public KettleRecipeSpawnMob(ResourceLocation name, Class mob, int color, Ingredient... inputs) {
		this.setRegistryName(name);
		this.fluidcost = 1000;
		this.color = color;
		this.entitySpawn = mob;
		this.recipeInputs = NonNullList.from(Ingredient.EMPTY, inputs);
		for (Ingredient input : inputs) {
			if (!allInputs.contains(input))
				allInputs.add(input);
		}
		for (int i = 0; i < recipeInputs.size(); ++i) {
			this.order.add(i);
		}
	}

	public KettleRecipeSpawnMob(String name, Class mob, int color, Ingredient... inputs) {
		this(new ResourceLocation(ModInformation.ID, name), mob, color, inputs);
	}

	public ItemStack getOutput(ItemStack... input) {
		return ItemStack.EMPTY;
	}

	public void performRecipe(World worldIn, BlockPos pos, @Nullable EntityPlayer playerIn) {
		Entity entity = EntityList.newEntity(entitySpawn, worldIn);
		entity.setPosition(pos.getX() + 0.5D, pos.getY() + 1, pos.getZ() + 0.5D);
		worldIn.spawnEntity(entity);
	}
}
