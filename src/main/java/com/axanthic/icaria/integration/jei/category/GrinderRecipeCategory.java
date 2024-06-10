//package com.axanthic.icaria.integration.jei.category;
//
//import com.axanthic.icaria.common.recipe.GrindingRecipe;
//import com.axanthic.icaria.common.registry.IcariaItems;
//import com.axanthic.icaria.common.registry.IcariaResourceLocations;
//import com.axanthic.icaria.common.util.IcariaInfo;
//
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
//import mezz.jei.api.gui.drawable.IDrawable;
//import mezz.jei.api.gui.drawable.IDrawableAnimated;
//import mezz.jei.api.gui.drawable.IDrawableStatic;
//import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
//import mezz.jei.api.helpers.IGuiHelper;
//import mezz.jei.api.recipe.IFocusGroup;
//import mezz.jei.api.recipe.RecipeIngredientRole;
//import mezz.jei.api.recipe.RecipeType;
//import mezz.jei.api.recipe.category.IRecipeCategory;
//
//import net.minecraft.MethodsReturnNonnullByDefault;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.item.ItemStack;
//
//import java.util.List;
//
//import javax.annotation.ParametersAreNonnullByDefault;
//
//@MethodsReturnNonnullByDefault
//@ParametersAreNonnullByDefault
//
//public class GrinderRecipeCategory implements IRecipeCategory<GrindingRecipe> {
//    public IDrawable background;
//    public IDrawable icon;
//    public IDrawableStatic staticArrow;
//    public IDrawableAnimated animatedArrow;
//    public IDrawableStatic staticFlame;
//    public IDrawableAnimated animatedFlame;
//
//    public GrinderRecipeCategory(IGuiHelper pHelper) {
//        this.background = pHelper.createDrawable(IcariaResourceLocations.GRINDER_CATEGORY, 0, 0, 154, 54);
//        this.icon = pHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(IcariaItems.GRINDER.get()));
//        this.staticArrow = pHelper.createDrawable(IcariaResourceLocations.GRINDER_CATEGORY, 154, 0, 22, 16);
//        this.animatedArrow = pHelper.createAnimatedDrawable(this.staticArrow, 300, IDrawableAnimated.StartDirection.LEFT, false);
//        this.staticFlame = pHelper.createDrawable(IcariaResourceLocations.GRINDER_CATEGORY, 154, 16, 4, 48);
//        this.animatedFlame = pHelper.createAnimatedDrawable(this.staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
//    }
//
//    @Override
//    public void draw(GrindingRecipe pRecipe, IRecipeSlotsView pView, GuiGraphics pGraphics, double pMouseX, double pMouseY) {
//        this.animatedArrow.draw(pGraphics, 84, 5);
//        this.animatedFlame.draw(pGraphics, 71, 3);
//    }
//
//    @Override
//    public void setRecipe(IRecipeLayoutBuilder pBuilder, GrindingRecipe pRecipe, IFocusGroup pGroup) {
//        pBuilder.addSlot(RecipeIngredientRole.CATALYST, 87, 28).addIngredients(pRecipe.getGear());
//        pBuilder.addSlot(RecipeIngredientRole.CATALYST, 25, 37).addItemStacks(List.of(new ItemStack(IcariaItems.SLIVER.get()), new ItemStack(IcariaItems.SLIVER_BLOCK.get())));
//        pBuilder.addSlot(RecipeIngredientRole.INPUT, 25, 1).addIngredients(pRecipe.getIngredients().get(0));
//        pBuilder.addSlot(RecipeIngredientRole.OUTPUT, 113, 1).addItemStack(pRecipe.getResultItem(null));
//    }
//
//    @Override
//    public Component getTitle() {
//        return Component.translatable("category" + "." + IcariaInfo.ID + "." + "grinding");
//    }
//
//    @Override
//    public IDrawable getBackground() {
//        return this.background;
//    }
//
//    @Override
//    public IDrawable getIcon() {
//        return this.icon;
//    }
//
//    @Override
//    public RecipeType<GrindingRecipe> getRecipeType() {
//        return RecipeType.create(IcariaInfo.ID, "grinding", GrindingRecipe.class);
//    }
//}
//