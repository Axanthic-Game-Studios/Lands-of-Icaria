package com.axanthic.loi.utils;

import java.util.ArrayList;

import com.axanthic.loi.LOIConfig;
import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemSaltedFood;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreIngredient;

public class RecipeSalt extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

	public static Ingredient saltIngredient = new OreIngredient("dustSalt");
	public static Ingredient blacklistIngredient;

	public static void initBlacklist() {
		ArrayList<ItemStack> blacklist = new ArrayList<ItemStack>();
		for (String entry : LOIConfig.misc.saltBlacklist) {
			String[] entries = entry.split(":");
			if (entries.length != 3 || !(Loader.isModLoaded(entries[0]) || entries[0].equals("minecraft")))
				continue;
			Item item = Item.REGISTRY.getObject(new ResourceLocation(entries[0], entries[1]));
			if (item == null)
				continue;
				blacklist.add(new ItemStack(item, 1, Integer.parseInt(entries[2])));
		}
		blacklistIngredient = Ingredient.fromStacks(blacklist.toArray(new ItemStack[blacklist.size()]));
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		ItemStack foodStack = ItemStack.EMPTY;
		ItemStack saltStack = ItemStack.EMPTY;
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if (!stack.isEmpty()) {
				if (foodStack.isEmpty() && stack.getItem() instanceof ItemFood && !(stack.getItem() instanceof ItemSaltedFood))
					foodStack = stack;
				else if (saltStack.isEmpty() && saltIngredient.apply(stack))
					saltStack = stack;
				else
					return false;
			}
		}
		if (foodStack.isEmpty() || saltStack.isEmpty())
			return false;
		if (blacklistIngredient.apply(foodStack) != LOIConfig.misc.saltListIsWhite)
			return false;
		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack foodStack = ItemStack.EMPTY;
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (!inv.getStackInSlot(i).isEmpty() && inv.getStackInSlot(i).getItem() instanceof ItemFood) {
				foodStack = inv.getStackInSlot(i).copy();
				break;
			}
		}
		if (foodStack.isEmpty()) {
			return ItemStack.EMPTY;
		}

		foodStack.setCount(1);
		NBTTagCompound foodTag = null;
		if (foodStack.hasTagCompound()) {
			foodTag = foodStack.getTagCompound().copy();
		} else {
			foodTag = new NBTTagCompound();
		}
		foodTag.setTag("food", foodStack.serializeNBT());
		ItemStack saltedStack = new ItemStack(Resources.saltedFood);
		saltedStack.setTagCompound(foodTag);
		return saltedStack;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canFit(int width, int height) {
		return width * height >= 2;
	}

	@Override
	public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
		NonNullList items = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);
		return items;
	}

	@Override
	public boolean isDynamic() {
		return true;
	}
}
