package com.axanthic.icaria.common.recipe;

import net.minecraft.world.item.crafting.RecipeType;

public class GrindingRecipeType implements RecipeType<GrindingRecipe> {
    public static final GrindingRecipeType INSTANCE = new GrindingRecipeType();

    public GrindingRecipeType() {
        // NOOP
    }
}
