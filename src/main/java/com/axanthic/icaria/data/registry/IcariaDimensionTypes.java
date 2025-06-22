package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import java.util.Optional;
import java.util.OptionalLong;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDimensionTypes {
	public static final ResourceKey<DimensionType> ICARIA = IcariaDimensionTypes.createKey("icaria");

	public static void bootstrap(BootstrapContext<DimensionType> pBootstrapContext) {
		pBootstrapContext.register(IcariaDimensionTypes.ICARIA, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0D, false, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, IcariaResourceLocations.ICARIA, 0.0F, Optional.of(192), new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)));
	}

	public static ResourceKey<DimensionType> createKey(String pName) {
		return ResourceKey.create(Registries.DIMENSION_TYPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
