package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

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
		this.add(IcariaIdentifiers.CHEST_RECIPE, 1);
		this.add(IcariaIdentifiers.CYPRESS_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaIdentifiers.DROUGHTROOT_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaIdentifiers.FIR_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaIdentifiers.LAUREL_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaIdentifiers.OLIVE_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaIdentifiers.PLANE_CRAFTING_TABLE_RECIPE, 1);
		this.add(IcariaIdentifiers.POPULUS_CRAFTING_TABLE_RECIPE, 1);
	}

	@Override
	public String getName() {
		return "Recipe Priorities";
	}
}
