package com.axanthic.icaria.data;

import com.axanthic.icaria.data.provider.IcariaRecipeProvider;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeRunner extends RecipeProvider.Runner {
	public IcariaRecipeRunner(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
		super(pPackOutput, pProvider);
	}

	@Override
	public RecipeProvider createRecipeProvider(HolderLookup.Provider pProvider, RecipeOutput pRecipeOutput) {
		return new IcariaRecipeProvider(pProvider, pRecipeOutput);
	}

	@Override
	public String getName() {
		return "Recipes";
	}
}
