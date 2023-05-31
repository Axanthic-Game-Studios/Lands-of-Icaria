package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import net.minecraftforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConfiguredFeatures {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, IcariaInfo.ID);

	public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE = IcariaConfiguredFeatures.registerKey("cypress_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> DROUGHTROOT_TREE = IcariaConfiguredFeatures.registerKey("droughtroot_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> FIR_TREE = IcariaConfiguredFeatures.registerKey("fir_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LAUREL_TREE = IcariaConfiguredFeatures.registerKey("laurel_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE_TREE = IcariaConfiguredFeatures.registerKey("olive_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PLANE_TREE = IcariaConfiguredFeatures.registerKey("plane_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> POPULUS_TREE = IcariaConfiguredFeatures.registerKey("populus_tree");

	public static void bootstrapConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
		pContext.register(IcariaConfiguredFeatures.CYPRESS_TREE, new ConfiguredFeature<>(IcariaFeatures.CYPRESS_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.DROUGHTROOT_TREE, new ConfiguredFeature<>(IcariaFeatures.DROUGHTROOT_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.FIR_TREE, new ConfiguredFeature<>(IcariaFeatures.FIR_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.LAUREL_TREE, new ConfiguredFeature<>(IcariaFeatures.LAUREL_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.OLIVE_TREE, new ConfiguredFeature<>(IcariaFeatures.OLIVE_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.PLANE_TREE, new ConfiguredFeature<>(IcariaFeatures.PLANE_TREE.get(), NoneFeatureConfiguration.NONE));
		pContext.register(IcariaConfiguredFeatures.POPULUS_TREE, new ConfiguredFeature<>(IcariaFeatures.POPULUS_TREE.get(), NoneFeatureConfiguration.NONE));
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String pName) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
