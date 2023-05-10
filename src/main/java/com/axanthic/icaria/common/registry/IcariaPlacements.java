package com.axanthic.icaria.common.registry;

import java.util.List;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;

public class IcariaPlacements {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURE_REGISTER = DeferredRegister
			.create(Registries.PLACED_FEATURE, IcariaInfo.ID);

	public static final ResourceKey<PlacedFeature> TEST = createKey("test");

	public static ResourceKey<PlacedFeature> createKey(final String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(IcariaInfo.ID, name));
	}

	public static void bootstrapPlacements(final BootstapContext<PlacedFeature> context) {
		final HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context
				.lookup(Registries.CONFIGURED_FEATURE);
		registerTest(context, configuredFeatureGetter);
	}

	// TODO: remove this feature, example of feature for later...
	public static void registerTest(final BootstapContext<PlacedFeature> context,
			final HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter) {
		final Holder<ConfiguredFeature<?, ?>> holder = configuredFeatureGetter.getOrThrow(IcariaFeatures.TEST_KEY);
		final List<PlacementModifier> modifiers = List.of(BiomeFilter.biome());
		IcariaPlacements.register(context, IcariaPlacements.TEST, holder, modifiers);
	}

	protected static void register(final BootstapContext<PlacedFeature> context,
			final ResourceKey<PlacedFeature> placedFeatureKey, final Holder<ConfiguredFeature<?, ?>> configuredFeature,
			final List<PlacementModifier> modifiers) {
		context.register(placedFeatureKey, new PlacedFeature(configuredFeature, modifiers));
	}
}
