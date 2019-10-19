package com.axanthic.loi.compatibility.jei;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.axanthic.loi.utils.GrinderFuel;
import com.google.common.base.Preconditions;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class GrinderFuelWrapper implements IRecipeWrapper {

	private final List<List<ItemStack>> inputs;
	private final String grindCountString;
	//private final IDrawableAnimated flame;

	public GrinderFuelWrapper(GrinderFuel recipe) {
		Preconditions.checkArgument(recipe.burnTime > 0, "burn time must be greater than 0");
		List<ItemStack> inputList = new ArrayList<>(Collections.singletonList(recipe.fuelItem));
		this.inputs = Collections.singletonList(inputList);

		if (recipe.burnTime == 200) {
			this.grindCountString = Translator.translateToLocal("gui.jei.category.grindfuel.grindCount.single");
		} else {
			NumberFormat numberInstance = NumberFormat.getNumberInstance();
			numberInstance.setMaximumFractionDigits(2);
			String smeltCount = numberInstance.format(recipe.burnTime / 200F);
			this.grindCountString = Translator.translateToLocalFormatted("gui.jei.category.grindfuel.grindCount", smeltCount);
		}
		//this.flame = guiHelper.drawableBuilder(Constants.RECIPE_GUI_VANILLA, 82, 114, 14, 14).buildAnimated(recipe.burnTime, IDrawableAnimated.StartDirection.TOP, true);
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputLists(VanillaTypes.ITEM, inputs);
	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		//flame.draw(minecraft, 1, 0);
		minecraft.fontRenderer.drawString(grindCountString, 24, 13, Color.gray.getRGB());
	}
}
