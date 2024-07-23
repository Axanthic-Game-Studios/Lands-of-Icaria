package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDimensions {
	public static final ResourceKey<Level> ICARIA = IcariaDimensions.createKey("icaria");

	public static ResourceKey<Level> createKey(String pName) {
		return ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}