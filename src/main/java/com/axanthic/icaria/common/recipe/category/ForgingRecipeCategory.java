package com.axanthic.icaria.common.recipe.category;

import com.axanthic.icaria.common.recipe.ForgingRecipe;
import com.axanthic.icaria.common.recipe.display.ForgingRecipeDisplay;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.placement.HorizontalAlignment;
import mezz.jei.api.gui.placement.VerticalAlignment;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeHolderType;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.RecipeHolder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgingRecipeCategory extends AbstractRecipeCategory<RecipeHolder<ForgingRecipe>> {
	public IDrawable background;
	public IDrawableAnimated flameAnimated;
	public IDrawableStatic flameStatic;

	public ForgingRecipeCategory(Component pComponent, IDrawable pDrawable, IGuiHelper pGuiHelper, IRecipeHolderType<ForgingRecipe> pRecipeType) {
		super(pRecipeType, pComponent, pDrawable, 154, 54);
		this.background = pGuiHelper.createDrawable(IcariaResourceLocations.FORGING_RECIPE_CATEGORY, 0, 0, 154, 54);
		this.flameStatic = pGuiHelper.createDrawable(IcariaResourceLocations.FORGING_RECIPE_CATEGORY, 154, 0, 16, 14);
		this.flameAnimated = pGuiHelper.createAnimatedDrawable(this.flameStatic, 300, IDrawableAnimated.StartDirection.TOP, true);
	}

	@Override
	public void createRecipeExtras(IRecipeExtrasBuilder pRecipeLayoutBuilder, RecipeHolder<ForgingRecipe> pRecipeHolder, IFocusGroup pFocusGroup) {
		if (pRecipeHolder.value().display().getFirst() instanceof ForgingRecipeDisplay recipeDisplay) {
			pRecipeLayoutBuilder.addAnimatedRecipeArrow(recipeDisplay.time()).setPosition(71, 19);
			pRecipeLayoutBuilder.addText(Component.translatable("gui.jei.category.smelting.experience", recipeDisplay.experience()), this.getWidth(), this.getHeight()).setColor(-8355712).setPosition(-51, 37).setTextAlignment(HorizontalAlignment.RIGHT).setTextAlignment(VerticalAlignment.TOP);
			pRecipeLayoutBuilder.addText(Component.translatable("gui.jei.category.smelting.time.seconds", recipeDisplay.time() * 0.05F + " "), this.getWidth(), this.getHeight()).setColor(-8355712).setPosition(-51, 0).setTextAlignment(HorizontalAlignment.RIGHT).setTextAlignment(VerticalAlignment.BOTTOM);
		}
	}

	@Override
	public void draw(RecipeHolder<ForgingRecipe> pRecipeHolder, IRecipeSlotsView pRecipeSlotsView, GuiGraphics pGuiGraphics, double pX, double pY) {
		this.background.draw(pGuiGraphics, 0, 0);
		this.flameAnimated.draw(pGuiGraphics, 42, 20);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder pRecipeLayoutBuilder, RecipeHolder<ForgingRecipe> pRecipeHolder, IFocusGroup pFocusGroup) {
		if (pRecipeHolder.value().display().getFirst() instanceof ForgingRecipeDisplay recipeDisplay) {
			pRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT).add(recipeDisplay.ingredient()).setPosition(25, 1);
			pRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT).add(recipeDisplay.ingredientB()).setPosition(43, 1);
			pRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT).add(recipeDisplay.ingredientC()).setPosition(61, 1);
			pRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT).add(recipeDisplay.result()).setPosition(109, 5);
			pRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY).add(recipeDisplay.fuel()).setPosition(43, 37);
		}
	}
}
