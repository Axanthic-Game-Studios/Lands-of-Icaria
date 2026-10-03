package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.DimensionType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDimensionTypeIds {
	public static final ResourceKey<DimensionType> ICARIA = IcariaDimensionTypeIds.create("icaria");

	public static ResourceKey<DimensionType> create(String pName) {
		return ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
