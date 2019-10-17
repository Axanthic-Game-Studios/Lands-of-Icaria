package com.axanthic.loi.compatibility.jei;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GrinderRecipeCategory implements IRecipeCategory<GrinderRecipeWrapper> {
	
	protected static final int inputSlot = 0;
	protected static final int outputSlot = 2;

	protected final IDrawableAnimated arrow;
	
	private final IDrawable background;
	private final IDrawable icon;
	private final String localizedName;

	public GrinderRecipeCategory(IGuiHelper guiHelper) {
		arrow = guiHelper.drawableBuilder(new ResourceLocation(ModInformation.ID, "textures/gui/jei_crafting.png"), 82, 0, 24, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
		
		background = guiHelper.createDrawable(new ResourceLocation(ModInformation.ID, "textures/gui/jei_crafting.png"), 0, 0, 82, 54);
		icon = guiHelper.createDrawableIngredient(new ItemStack(Resources.grinder));
		localizedName = Translator.translateToLocal("gui.jei.category.landsoficaria.grinding");
	}
	
	@Override
	public String getUid() {
		return "landsoficaria.grinding";
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	@Override
	public String getModName() {
		return ModInformation.NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void drawExtras(Minecraft minecraft) {
		arrow.draw(minecraft, 24, 8);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, GrinderRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(inputSlot, true, 0, 0);
		guiItemStacks.init(outputSlot, false, 60, 18);

		guiItemStacks.set(ingredients);
	}
}
