package com.axanthic.loi.compatibility.jei;

import javax.annotation.Nullable;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.config.Constants;
import mezz.jei.util.Translator;
import net.minecraft.item.ItemStack;

public class GrinderFuelCategory implements IRecipeCategory<GrinderFuelWrapper> {

	protected static final int fuelSlot = 1;

	private final IDrawableStatic background;
	private final IDrawable icon;
	private final String localizedName;

	public GrinderFuelCategory(IGuiHelper guiHelper) {
		background = guiHelper.drawableBuilder(Constants.RECIPE_GUI_VANILLA, 0, 134, 18, 34) .addPadding(0, 0, 0, 88).build();
		icon = guiHelper.createDrawableIngredient(new ItemStack(Resources.renderAddon));
		localizedName = Translator.translateToLocal("gui.jei.category.landsoficaria.grindfuel");
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public String getUid() {
		return "landsoficaria.grindfuel";
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	@Override
	public String getModName() {
		return ModInformation.NAME;
	}

	@Nullable
	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, GrinderFuelWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(fuelSlot, true, 0, 16);
		guiItemStacks.set(ingredients);
	}
}
