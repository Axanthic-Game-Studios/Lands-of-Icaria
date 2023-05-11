package com.axanthic.icaria.common.world;

import java.util.Set;

import com.axanthic.icaria.common.registry.IcariaBiomeTags;
import com.axanthic.icaria.common.registry.IcariaBiomes;
import com.axanthic.icaria.common.registry.IcariaCarvers;
import com.axanthic.icaria.common.registry.IcariaDimensions;
import com.axanthic.icaria.common.registry.IcariaFeatures;
import com.axanthic.icaria.common.registry.IcariaPlacements;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = IcariaInfo.ID)
public class DataGenerationHandler {
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_CARVER, c -> IcariaCarvers.bootstrap(c))
			.add(Registries.BIOME, IcariaBiomes::bootstrapBiomes)
			.add(Registries.CONFIGURED_FEATURE, c -> IcariaFeatures.bootstrapFeatures(c))
			.add(Registries.NOISE_SETTINGS, c -> IcariaDimensions.bootstrapNoiseSettings(c))
			.add(Registries.DIMENSION_TYPE, c -> IcariaDimensions.bootstrapType(c))
			.add(Registries.LEVEL_STEM, c -> IcariaDimensions.bootstrapDimension(c))
			.add(Registries.PLACED_FEATURE, IcariaPlacements::bootstrapPlacements);

	@SubscribeEvent
	public static void onGatherData(final GatherDataEvent event) {
		final DataGenerator generator = event.getGenerator();
		final PackOutput output = generator.getPackOutput();
		final ExistingFileHelper helper = event.getExistingFileHelper();

		generator.addProvider(event.includeServer(),
				new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), BUILDER, Set.of(IcariaInfo.ID)));
		generator.addProvider(event.includeServer(),
				new IcariaBiomeTags(output, event.getLookupProvider().thenApply(r -> append(r, BUILDER)), helper));
	}

	private static HolderLookup.Provider append(final HolderLookup.Provider original,
			final RegistrySetBuilder builder) {
		return builder.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), original);
	}
}