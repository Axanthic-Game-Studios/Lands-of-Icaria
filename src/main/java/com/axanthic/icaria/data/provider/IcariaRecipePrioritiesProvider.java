package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.RecipePrioritiesProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipePrioritiesProvider extends RecipePrioritiesProvider {
	public IcariaRecipePrioritiesProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void start() {
		this.add(IcariaResourceLocations.CHEST_RECIPE, 1);
		this.add(IcariaResourceLocations.CYPRESS_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaResourceLocations.DROUGHTROOT_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaResourceLocations.FIR_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaResourceLocations.LAUREL_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaResourceLocations.OLIVE_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaResourceLocations.PLANE_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaResourceLocations.POPULUS_CRAFTING_TABLE_RECIPE, 1);
	}

	@Override
	public String getName() {
		return "Recipe Priorities";
	}
}
