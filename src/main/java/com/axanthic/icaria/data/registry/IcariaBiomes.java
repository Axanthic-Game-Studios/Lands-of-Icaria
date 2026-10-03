package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaBiomeIds;
import com.axanthic.icaria.common.ids.IcariaPlacedFeatureIds;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomes {
	public static void bootstrap(BootstrapContext<Biome> pBootstrapContext) {
		pBootstrapContext.register(IcariaBiomeIds.FOREST, IcariaBiomes.forestBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.LUSH_FOREST, IcariaBiomes.lushForestBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.LOST_FOREST, IcariaBiomes.lostForestBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.DEEP_FOREST, IcariaBiomes.deepForestBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));

		pBootstrapContext.register(IcariaBiomeIds.SCRUBLAND, IcariaBiomes.scrublandBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.LUSH_SCRUBLAND, IcariaBiomes.lushScrublandBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.LOST_SCRUBLAND, IcariaBiomes.lostScrublandBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.DEEP_SCRUBLAND, IcariaBiomes.deepScrublandBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));

		pBootstrapContext.register(IcariaBiomeIds.STEPPE, IcariaBiomes.steppeBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.LUSH_STEPPE, IcariaBiomes.lushSteppeBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.LOST_STEPPE, IcariaBiomes.lostSteppeBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.DEEP_STEPPE, IcariaBiomes.deepSteppeBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));

		pBootstrapContext.register(IcariaBiomeIds.DESERT, IcariaBiomes.desertBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.LUSH_DESERT, IcariaBiomes.lushDesertBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.LOST_DESERT, IcariaBiomes.lostDesertBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
		pBootstrapContext.register(IcariaBiomeIds.DEEP_DESERT, IcariaBiomes.deepDesertBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));

		pBootstrapContext.register(IcariaBiomeIds.VOID, IcariaBiomes.voidBiome(pBootstrapContext.lookup(Registries.PLACED_FEATURE), pBootstrapContext.lookup(Registries.CONFIGURED_CARVER)));
	}

	public static Biome forestBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.forestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.forestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.forestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4227157).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void forestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.CHALKOS_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CALCITE_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLOOMY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BRANCHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CHARMONDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LIONFANGS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPEARDROPS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MOTH_AGARIC);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WHITE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ORANGE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.STRAWBERRY_BUSH);
	}

	public static void forestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(8427853).waterColor(4227157);
	}

	public static void forestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CAPELLA.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CATOBLEPAS.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.THOG.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CROCOTTA.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIR_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), 1, 1));
	}

	public static Biome lushForestBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lushForestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lushForestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lushForestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4227157).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lushForestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.DOLOMITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.HALITE_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LUSH_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LUSH_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLOOMY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BRANCHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CHARMONDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LIONFANGS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPEARDROPS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MOTH_AGARIC);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WHITE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ORANGE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.STRAWBERRY_BUSH);
	}

	public static void lushForestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(8427853).waterColor(4227157);
	}

	public static void lushForestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CLUSTER_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FOREST_SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIR_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 1, 3));
	}

	public static Biome lostForestBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lostForestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lostForestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lostForestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4227157).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lostForestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.ANTHRACITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.JASPER_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLOOMY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BRANCHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CHARMONDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LIONFANGS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPEARDROPS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MOTH_AGARIC);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WHITE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ORANGE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.STRAWBERRY_BUSH);
	}

	public static void lostForestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(8427853).waterColor(4227157);
	}

	public static void lostForestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARACHNE_DRONE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIR_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 1, 1));
	}

	public static Biome deepForestBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.deepForestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.deepForestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.deepForestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4227157).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void deepForestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ZIRCON_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLOOMY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BRANCHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CHARMONDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LIONFANGS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPEARDROPS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MOTH_AGARIC);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WHITE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ORANGE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PINK_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.STRAWBERRY_BUSH);
	}

	public static void deepForestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(8427853).waterColor(4227157);
	}

	public static void deepForestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CLUSTER_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FOREST_SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 1, 1));
	}

	public static Biome scrublandBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.scrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.scrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.scrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4623442).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void scrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.CHALKOS_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_BOULDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CALCITE_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.REEDY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SWIRLY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPARSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPARSE_GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLINDWEED);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FIREHILT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void scrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(10793817).waterColor(4623442);
	}

	public static void scrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CAPELLA.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CATOBLEPAS.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.THOG.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CROCOTTA.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.PLANE_FOREST_HAG.get(), 1, 1));
	}

	public static Biome lushScrublandBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lushScrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lushScrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lushScrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4623442).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lushScrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.DOLOMITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.HALITE_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LUSH_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LUSH_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.REEDY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SWIRLY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPARSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPARSE_GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLINDWEED);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FIREHILT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void lushScrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(10793817).waterColor(4623442);
	}

	public static void lushScrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CLUSTER_SLUG.get(), 1, 35));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.PLANE_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 1, 3));
	}

	public static Biome lostScrublandBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lostScrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lostScrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lostScrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4623442).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lostScrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.ANTHRACITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.JASPER_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.REEDY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SWIRLY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPARSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPARSE_GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLINDWEED);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FIREHILT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void lostScrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(10793817).waterColor(4623442);
	}

	public static void lostScrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARACHNE_DRONE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.PLANE_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 1, 1));
	}

	public static Biome deepScrublandBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.deepScrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.deepScrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.deepScrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 4623442).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void deepScrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ZIRCON_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.REEDY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SWIRLY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPARSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SPARSE_GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLINDWEED);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FIREHILT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BLUE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void deepScrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(10793817).waterColor(4623442);
	}

	public static void deepScrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CLUSTER_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 1, 1));
	}

	public static Biome steppeBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.steppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.steppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.steppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 5085517).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void steppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.CHALKOS_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_BOULDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CALCITE_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BRUSHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.THORNY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CHAMEOMILE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CLOVER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOW_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void steppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(13421670).waterColor(5085517);
	}

	public static void steppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CAPELLA.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CATOBLEPAS.get(), 1, 35));
		pBuilder.addSpawn(MobCategory.CREATURE, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.THOG.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CROCOTTA.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), 1, 1));
	}

	public static Biome lushSteppeBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lushSteppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lushSteppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lushSteppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 5085517).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lushSteppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.DOLOMITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.HALITE_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LUSH_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LUSH_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BRUSHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.THORNY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CHAMEOMILE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CLOVER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOW_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void lushSteppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(13421670).waterColor(5085517);
	}

	public static void lushSteppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CLUSTER_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 1, 3));
	}

	public static Biome lostSteppeBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lostSteppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lostSteppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lostSteppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 5085517).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lostSteppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.ANTHRACITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.JASPER_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BRUSHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.THORNY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CHAMEOMILE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CLOVER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOW_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void lostSteppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(13421670).waterColor(5085517);
	}

	public static void lostSteppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARACHNE_DRONE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 1, 1));
	}

	public static Biome deepSteppeBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.deepSteppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.deepSteppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.deepSteppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 5085517).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void deepSteppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatureIds.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ZIRCON_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BRUSHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.THORNY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DENSE_GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CHAMEOMILE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CLOVER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PURPLE_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOW_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void deepSteppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(13421670).waterColor(5085517);
	}

	public static void deepSteppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CLUSTER_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 1, 1));
	}

	public static Biome desertBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.desertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.desertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.desertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 6399571).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void desertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.CHALKOS_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINITE_SPIKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINITE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CALCITE_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNKETTLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNSPONGE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BOLBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CARDON_CACTUS);
	}

	public static void desertBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(15127155).waterColor(6399571);
	}

	public static void desertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CROCOTTA.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), 1, 1));
	}

	public static Biome lushDesertBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lushDesertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lushDesertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lushDesertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 6399571).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lushDesertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.DOLOMITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINITE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.HALITE_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LUSH_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNKETTLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNSPONGE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BOLBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CARDON_CACTUS);
	}

	public static void lushDesertBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(15127155).waterColor(6399571);
	}

	public static void lushDesertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 1, 3));
	}

	public static Biome lostDesertBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lostDesertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lostDesertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lostDesertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 6399571).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lostDesertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.ANTHRACITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINITE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.JASPER_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.FALLEN_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SMALL_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNKETTLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNSPONGE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BOLBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CARDON_CACTUS);
	}

	public static void lostDesertBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(15127155).waterColor(6399571);
	}

	public static void lostDesertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARACHNE_DRONE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 1, 1));
	}

	public static Biome deepDesertBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.deepDesertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.deepDesertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.deepDesertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, true).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 6399571).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void deepDesertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatureIds.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GRAINITE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.ZIRCON_CLUSTER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNKETTLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.SUNSPONGE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BOLBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatureIds.CARDON_CACTUS);
	}

	public static void deepDesertBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(15127155).waterColor(6399571);
	}

	public static void deepDesertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 1, 1));
	}

	public static Biome voidBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.voidBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.voidBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.voidMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).setAttribute(EnvironmentAttributes.SNOW_GOLEM_MELTS, false).setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 5083986).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void voidBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatureIds.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatureIds.RUIN);
	}

	public static void voidBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.grassColorOverride(11909984).waterColor(5083986);
	}

	public static void voidMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FEESH.get(), 5, 15));
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FICHE.get(), 5, 15));
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FISSHH.get(), 5, 15));
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FYSH.get(), 5, 15));
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 80, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 80, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 80, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.NATURE_JELLYFISH.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 80, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VOID_JELLYFISH.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.WATER_AMBIENT, 80, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.WATER_JELLYFISH.get(), 1, 3));
	}
}
