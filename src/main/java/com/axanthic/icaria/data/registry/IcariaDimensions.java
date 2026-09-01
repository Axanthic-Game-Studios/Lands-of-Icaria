package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaKeys;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDimensions {
	public static final ResourceKey<Level> ICARIA = IcariaDimensions.createKey("icaria");

	public static ResourceKey<Level> createKey(String pName) {
		return ResourceKey.create(Registries.DIMENSION, Identifier.fromNamespaceAndPath(IcariaKeys.ID, pName));
	}
}