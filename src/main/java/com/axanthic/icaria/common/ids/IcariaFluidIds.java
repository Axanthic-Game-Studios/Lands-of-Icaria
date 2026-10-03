package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.material.Fluid;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFluidIds {
	public static final ResourceKey<Fluid> FLOWING_MEDITERRANEAN_WATER = IcariaFluidIds.create("flowing_mediterranean_water");
	public static final ResourceKey<Fluid> MEDITERRANEAN_WATER = IcariaFluidIds.create("mediterranean_water");

	public static ResourceKey<Fluid> create(String pName) {
		return ResourceKey.create(Registries.FLUID, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
