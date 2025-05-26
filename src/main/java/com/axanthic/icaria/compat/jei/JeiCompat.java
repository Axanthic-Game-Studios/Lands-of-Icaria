package com.axanthic.icaria.compat.jei;

import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.recipe.ForgingRecipe;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.compat.jei.category.FiringRecipeCategory;
import com.axanthic.icaria.compat.jei.category.ForgingRecipeCategory;
import com.axanthic.icaria.compat.jei.category.GrindingRecipeCategory;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.common.Internal;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@JeiPlugin
public class JeiCompat implements IModPlugin {
	public static final Supplier<IRecipeHolderType<FiringRecipe>> FIRING = IRecipeHolderType.createDeferred(IcariaRecipeTypes.FIRING);
	public static final Supplier<IRecipeHolderType<ForgingRecipe>> FORGING = IRecipeHolderType.createDeferred(IcariaRecipeTypes.FORGING);
	public static final Supplier<IRecipeHolderType<GrindingRecipe>> GRINDING = IRecipeHolderType.createDeferred(IcariaRecipeTypes.GRINDING);

	@Override
	public void registerCategories(IRecipeCategoryRegistration pRegistration) {
		var guiHelper = pRegistration.getJeiHelpers().getGuiHelper();
		pRegistration.addRecipeCategories(new FiringRecipeCategory(Component.translatable("category" + "." + IcariaIdents.ID + "." + "firing"), guiHelper.createDrawableItemLike(IcariaItems.KILN.get()), guiHelper, JeiCompat.FIRING.get()));
		pRegistration.addRecipeCategories(new ForgingRecipeCategory(Component.translatable("category" + "." + IcariaIdents.ID + "." + "forging"), guiHelper.createDrawableItemLike(IcariaItems.FORGE.get()), guiHelper, JeiCompat.FORGING.get()));
		pRegistration.addRecipeCategories(new GrindingRecipeCategory(Component.translatable("category" + "." + IcariaIdents.ID + "." + "grinding"), guiHelper.createDrawableItemLike(IcariaItems.GRINDER.get()), guiHelper, JeiCompat.GRINDING.get()));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration pRegistration) {
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.CYPRESS_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.FIR_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.LAUREL_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.OLIVE_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.PLANE_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.POPULUS_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(JeiCompat.FIRING.get(), IcariaItems.KILN.get());
		pRegistration.addCraftingStation(JeiCompat.FORGING.get(), IcariaItems.FORGE.get());
		pRegistration.addCraftingStation(JeiCompat.GRINDING.get(), IcariaItems.GRINDER.get());
	}

	@Override
	public void registerRecipes(IRecipeRegistration pRegistration) {
		var recipeMap = Internal.getClientSyncedRecipes();

		var firingRecipes = recipeMap.byType(IcariaRecipeTypes.FIRING.get()).stream().toList();
		var forgingRecipes = recipeMap.byType(IcariaRecipeTypes.FORGING.get()).stream().toList();
		var grindingRecipes = recipeMap.byType(IcariaRecipeTypes.GRINDING.get()).stream().toList();

		pRegistration.addRecipes(IRecipeType.create(IcariaRecipeTypes.FIRING.get()), firingRecipes);
		pRegistration.addRecipes(IRecipeType.create(IcariaRecipeTypes.FORGING.get()), forgingRecipes);
		pRegistration.addRecipes(IRecipeType.create(IcariaRecipeTypes.GRINDING.get()), grindingRecipes);
	}

	@Override
	public ResourceLocation getPluginUid() {
		return IcariaResourceLocations.ICARIA;
	}
}
