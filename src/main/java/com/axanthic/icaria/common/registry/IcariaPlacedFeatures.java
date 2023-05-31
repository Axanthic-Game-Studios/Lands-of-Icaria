package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.minecraftforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPlacedFeatures {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, IcariaInfo.ID);

	public static final ResourceKey<PlacedFeature> CYPRESS_TREE = IcariaPlacedFeatures.registerKey("cypress_tree");
	public static final ResourceKey<PlacedFeature> DROUGHTROOT_TREE = IcariaPlacedFeatures.registerKey("droughtroot_tree");
	public static final ResourceKey<PlacedFeature> FIR_TREE = IcariaPlacedFeatures.registerKey("fir_tree");
	public static final ResourceKey<PlacedFeature> LAUREL_TREE = IcariaPlacedFeatures.registerKey("laurel_tree");
	public static final ResourceKey<PlacedFeature> OLIVE_TREE = IcariaPlacedFeatures.registerKey("olive_tree");
	public static final ResourceKey<PlacedFeature> PLANE_TREE = IcariaPlacedFeatures.registerKey("plane_tree");
	public static final ResourceKey<PlacedFeature> POPULUS_TREE = IcariaPlacedFeatures.registerKey("populus_tree");

	public static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> pContext) {
		var configuredFeatures = pContext.lookup(Registries.CONFIGURED_FEATURE);

		pContext.register(IcariaPlacedFeatures.CYPRESS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.CYPRESS_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1F, 2))));
		pContext.register(IcariaPlacedFeatures.DROUGHTROOT_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.DROUGHTROOT_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1F, 2))));
		pContext.register(IcariaPlacedFeatures.FIR_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.FIR_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1F, 2))));
		pContext.register(IcariaPlacedFeatures.LAUREL_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.LAUREL_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1F, 2))));
		pContext.register(IcariaPlacedFeatures.OLIVE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.OLIVE_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1F, 2))));
		pContext.register(IcariaPlacedFeatures.PLANE_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.PLANE_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1F, 2))));
		pContext.register(IcariaPlacedFeatures.POPULUS_TREE, new PlacedFeature(configuredFeatures.getOrThrow(IcariaConfiguredFeatures.POPULUS_TREE), VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1F, 2))));
	}

	public static ResourceKey<PlacedFeature> registerKey(String pName) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
