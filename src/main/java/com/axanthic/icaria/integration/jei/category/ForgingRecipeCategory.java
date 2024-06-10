//package com.axanthic.icaria.integration.jei.category;
//
//import com.axanthic.icaria.common.recipe.ForgingRecipe;
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
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.GuiGraphics;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.item.ItemStack;
//
//import javax.annotation.ParametersAreNonnullByDefault;
//
//@MethodsReturnNonnullByDefault
//@ParametersAreNonnullByDefault
//
//public class ForgingRecipeCategory implements IRecipeCategory<ForgingRecipe> {
//    public IDrawable background;
//    public IDrawable icon;
//    public IDrawableStatic staticArrow;
//    public IDrawableAnimated animatedArrow;
//    public IDrawableStatic staticFlame;
//    public IDrawableAnimated animatedFlame;
//
//    public ForgingRecipeCategory(IGuiHelper pHelper) {
//        this.background = pHelper.createDrawable(IcariaResourceLocations.FORGE_CATEGORY, 0, 0, 154, 54);
//        this.icon = pHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(IcariaItems.FORGE.get()));
//        this.staticArrow = pHelper.createDrawable(IcariaResourceLocations.FORGE_CATEGORY, 154, 0, 22, 16);
//        this.animatedArrow = pHelper.createAnimatedDrawable(this.staticArrow, 300, IDrawableAnimated.StartDirection.LEFT, false);
//        this.staticFlame = pHelper.createDrawable(IcariaResourceLocations.FORGE_CATEGORY, 154, 16, 16, 14);
//        this.animatedFlame = pHelper.createAnimatedDrawable(this.staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
//    }
//
//    @Override
//    public void draw(ForgingRecipe pRecipe, IRecipeSlotsView pView, GuiGraphics pGraphics, double pMouseX, double pMouseY) {
//        this.animatedArrow.draw(pGraphics, 71, 19);
//        this.animatedFlame.draw(pGraphics, 42, 20);
//        this.drawBurnTime(pRecipe, pGraphics, 52, 1);
//        this.drawExperience(pRecipe, pGraphics, 52, 46);
//    }
//
//    public void drawBurnTime(ForgingRecipe pRecipe, GuiGraphics pGraphics, int pX, int pY) {
//        int burnTime = pRecipe.getBurnTime();
//        if (burnTime > 0) {
//            var font = Minecraft.getInstance().font;
//            var burnTimeText = Component.translatable("gui.jei.category.smelting.time.seconds", burnTime / 20);
//            pGraphics.drawString(font, burnTimeText, this.getWidth() - font.width(burnTimeText) - pX, pY, -8355712, false);
//        }
//    }
//
//    public void drawExperience(ForgingRecipe pRecipe, GuiGraphics pGraphics, int pX, int pY) {
//        float experience = pRecipe.getExperience();
//        if (experience > 0.0F) {
//            var font = Minecraft.getInstance().font;
//            var experienceText = Component.translatable("gui.jei.category.smelting.experience", experience);
//            pGraphics.drawString(font, experienceText, this.getWidth() - font.width(experienceText) - pX, pY, -8355712, false);
//        }
//    }
//
//    @Override
//    public void setRecipe(IRecipeLayoutBuilder pBuilder, ForgingRecipe pRecipe, IFocusGroup pGroup) {
//        pBuilder.addSlot(RecipeIngredientRole.INPUT, 25, 1).addIngredients(pRecipe.getIngredients().get(0));
//        pBuilder.addSlot(RecipeIngredientRole.INPUT, 43, 1).addIngredients(pRecipe.getIngredients().get(1));
//        pBuilder.addSlot(RecipeIngredientRole.INPUT, 61, 1).addIngredients(pRecipe.getIngredients().get(2));
//        pBuilder.addSlot(RecipeIngredientRole.OUTPUT, 109, 5).addItemStack(pRecipe.getResultItem(null));
//    }
//
//    @Override
//    public Component getTitle() {
//        return Component.translatable("category" + "." + IcariaInfo.ID + "." + "forging");
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
//    public RecipeType<ForgingRecipe> getRecipeType() {
//        return RecipeType.create(IcariaInfo.ID, "forging", ForgingRecipe.class);
//    }
//}
//