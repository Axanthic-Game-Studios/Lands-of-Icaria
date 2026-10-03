package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLevelStemIds {
	public static final ResourceKey<LevelStem> ICARIA = IcariaLevelStemIds.create("icaria");

	public static ResourceKey<LevelStem> create(String pName) {
		return ResourceKey.create(Registries.LEVEL_STEM, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
