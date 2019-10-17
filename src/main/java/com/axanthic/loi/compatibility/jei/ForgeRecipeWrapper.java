package com.axanthic.loi.compatibility.jei;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.axanthic.loi.utils.ForgeRecipe;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class ForgeRecipeWrapper implements IRecipeWrapper {

	private final List<List<ItemStack>> inputs;
	private final ItemStack output;
	private final ForgeRecipe recipe;

	public ForgeRecipeWrapper(ForgeRecipe recipe) {
		List<List<ItemStack>> inputsList = new ArrayList<List<ItemStack>>();
		for (Ingredient ingredient : recipe.recipeInputs) {

			List<ItemStack> inputList = new ArrayList<ItemStack>();
			for (ItemStack stack : ingredient.getMatchingStacks())
				inputList.add(stack);
			inputsList.add(inputList);
		}

		this.inputs = inputsList;
		this.output = recipe.recipeOutput;
		this.recipe = recipe;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputLists(VanillaTypes.ITEM, inputs);
		ingredients.setOutput(VanillaTypes.ITEM, output);
	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		float experience = recipe.experience;
		if (experience > 0) {
			String experienceString = Translator.translateToLocalFormatted("gui.jei.category.smelting.experience", experience);
			FontRenderer fontRenderer = minecraft.fontRenderer;
			int stringWidth = fontRenderer.getStringWidth(experienceString);
			fontRenderer.drawString(experienceString, recipeWidth - stringWidth, 0, Color.gray.getRGB());
		}
	}
}
