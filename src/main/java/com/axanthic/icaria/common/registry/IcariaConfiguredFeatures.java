package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import net.minecraftforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConfiguredFeatures {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, IcariaInfo.ID);

	public static final ResourceKey<ConfiguredFeature<?, ?>> TEST = IcariaConfiguredFeatures.registerKey("test");

	public static void bootstrapConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
		pContext.register(IcariaConfiguredFeatures.TEST, new ConfiguredFeature<>(Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(IcariaBlocks.GRAIN_0.get().defaultBlockState(), 1).add(IcariaBlocks.GRAIN_1.get().defaultBlockState(), 1).add(IcariaBlocks.GRAIN_2.get().defaultBlockState(), 1).add(IcariaBlocks.GRAIN_3.get().defaultBlockState(), 1)), 64)));
	}

	public static RandomPatchConfiguration grassPatch(BlockStateProvider pProvider, int pTries) {
		return FeatureUtils.simpleRandomPatchConfiguration(pTries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(pProvider)));
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String pName) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
