package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.feature.TestFeature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;

public class IcariaFeatures {
	public static final DeferredRegister<Feature<?>> FEATURE_REGISTER = DeferredRegister.create(Registries.FEATURE,
			IcariaInfo.ID);

	/***********************************************************************************************/
	// REGISTER
	/***********************************************************************************************/

	public static final Feature<NoneFeatureConfiguration> TEST = register("test",
			new TestFeature(NoneFeatureConfiguration.CODEC));

	private static <C extends FeatureConfiguration, F extends Feature<C>> F register(final String key, final F value) {
		IcariaFeatures.FEATURE_REGISTER.register(key, () -> value);
		return value;
	}

	/***********************************************************************************************/
	// KEYS
	/***********************************************************************************************/

	public static final ResourceKey<ConfiguredFeature<?, ?>> TEST_KEY = createKey("test");

	public static ResourceKey<ConfiguredFeature<?, ?>> createKey(final String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(IcariaInfo.ID, name));
	}

	public static void bootstrapFeatures(final BootstapContext<ConfiguredFeature<?, ?>> context) {
		// For custom configured features.
		context.register(IcariaFeatures.TEST_KEY,
				new ConfiguredFeature<>(IcariaFeatures.TEST, NoneFeatureConfiguration.INSTANCE));
	}
}
