package com.axanthic.loi.compatibility.jei;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.util.Translator;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ForgeAlloyingCategory implements IRecipeCategory<ForgeRecipeWrapper> {

	protected static final int inputSlot0 = 0;
	protected static final int inputSlot1 = 1;
	protected static final int inputSlot2 = 2;
	protected static final int outputSlot = 4;

	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedFlame;
	protected final IDrawableAnimated arrow;
	
	private final IDrawable background;
	private final IDrawable icon;
	private final String localizedName;

	public ForgeAlloyingCategory(IGuiHelper guiHelper) {
		staticFlame = guiHelper.createDrawable(new ResourceLocation(ModInformation.ID, "textures/gui/jei_crafting.png"), 100, 54, 14, 14);
		animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

		arrow = guiHelper.drawableBuilder(new ResourceLocation(ModInformation.ID, "textures/gui/jei_crafting.png"), 100, 68, 32, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
		
		background = guiHelper.createDrawable(new ResourceLocation(ModInformation.ID, "textures/gui/jei_crafting.png"), 0, 54, 100, 54);
		icon = guiHelper.createDrawableIngredient(new ItemStack(Resources.forge));
		localizedName = Translator.translateToLocal("gui.jei.category.landsoficaria.alloying");
	}
	
	@Override
	public String getUid() {
		return "landsoficaria.alloying";
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
		animatedFlame.draw(minecraft, 20, 20);
		arrow.draw(minecraft, 37, 18);
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ForgeRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(inputSlot0, true, 0, 0);
		guiItemStacks.init(inputSlot1, true, 18, 0);
		guiItemStacks.init(inputSlot2, true, 36, 0);
		guiItemStacks.init(outputSlot, false, 78, 18);

		guiItemStacks.set(ingredients);
	}
}
