package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import com.google.common.collect.ImmutableList;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import net.minecraftforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPlacedFeatures {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, IcariaInfo.ID);

	public static final ResourceKey<PlacedFeature> TEST = IcariaPlacedFeatures.registerKey("test");

	public static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> pContext) {
		HolderGetter<ConfiguredFeature<?, ?>> features = pContext.lookup(Registries.CONFIGURED_FEATURE);
		pContext.register(IcariaPlacedFeatures.TEST, new PlacedFeature(features.getOrThrow(IcariaConfiguredFeatures.TEST), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()).build()));
	}

	public static ResourceKey<PlacedFeature> registerKey(String pName) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
