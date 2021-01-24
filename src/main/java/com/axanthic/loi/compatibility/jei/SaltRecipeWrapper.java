package com.axanthic.loi.compatibility.jei;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.loi.LOIConfig;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemSaltedFood;
import com.axanthic.loi.utils.RecipeSalt;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class SaltRecipeWrapper implements ICraftingRecipeWrapper {

	public final List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
	public final List<List<ItemStack>> outputs = new ArrayList<List<ItemStack>>();
	public ResourceLocation registryName = new ResourceLocation(ModInformation.ID, "recipe_food_salting");

	public SaltRecipeWrapper() {
		List<ItemStack> foods = new ArrayList<ItemStack>();
		List<ItemStack> output = new ArrayList<ItemStack>();
		for (Item item : GameRegistry.findRegistry(Item.class).getValues()) {
			if (!(item instanceof ItemFood) || item.getCreativeTab() == null || item instanceof ItemSaltedFood)
				continue;
			NonNullList<ItemStack> stacks = NonNullList.create();
			item.getSubItems(item.getCreativeTab(), stacks);
			for (ItemStack foodStack : stacks) {
				if (RecipeSalt.blacklistIngredient.apply(foodStack) != LOIConfig.misc.saltListIsWhite)
					continue;
				NBTTagCompound foodTag = null;
				if (foodStack.hasTagCompound()) {
					foodTag = foodStack.getTagCompound().copy();
				} else {
					foodTag = new NBTTagCompound();
				}
				foodTag.setTag("food", foodStack.serializeNBT());
				ItemStack saltedStack = new ItemStack(Resources.saltedFood);
				saltedStack.setTagCompound(foodTag);
				foods.add(foodStack);
				output.add(saltedStack);
			}
		}
		inputs.add(foods);

		List<ItemStack> salt = new ArrayList<ItemStack>();
		salt.addAll(OreDictionary.getOres("dustSalt"));
		inputs.add(salt);
		outputs.add(output);
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputLists(VanillaTypes.ITEM, inputs);
		ingredients.setOutputLists(VanillaTypes.ITEM, outputs);
	}

	@Override
	public ResourceLocation getRegistryName() {
		return registryName;
	}
}
