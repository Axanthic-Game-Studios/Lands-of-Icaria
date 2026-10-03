package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDimensionIds {
	public static final ResourceKey<Level> ICARIA = IcariaDimensionIds.create("icaria");

	public static ResourceKey<Level> create(String pName) {
		return ResourceKey.create(Registries.DIMENSION, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
