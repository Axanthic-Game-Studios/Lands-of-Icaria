package com.axanthic.icaria.data.bootstrap;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.data.provider.IcariaRecipeProvider;

import java.util.Set;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.MultiRegistryBootstrap;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeBootstrap implements MultiRegistryBootstrap {

	@Override
	public Set<ResourceKey<? extends Registry<?>>> requestedRegistries() {
		return Set.of(Registries.RECIPE, Registries.ADVANCEMENT);
	}

	@Override
	public void run(BootstrapGetter registries) {
		new IcariaRecipeProvider(registries.get(Registries.RECIPE), registries.get(Registries.ADVANCEMENT)).buildRecipes();
	}
}
