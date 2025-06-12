package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
	public static final ResourceKey<Biome> FOREST = IcariaBiomes.createKey("forest");
	public static final ResourceKey<Biome> LUSH_FOREST = IcariaBiomes.createKey("lush_forest");
	public static final ResourceKey<Biome> LOST_FOREST = IcariaBiomes.createKey("lost_forest");
	public static final ResourceKey<Biome> DEEP_FOREST = IcariaBiomes.createKey("deep_forest");

	public static final ResourceKey<Biome> SCRUBLAND = IcariaBiomes.createKey("scrubland");
	public static final ResourceKey<Biome> LUSH_SCRUBLAND = IcariaBiomes.createKey("lush_scrubland");
	public static final ResourceKey<Biome> LOST_SCRUBLAND = IcariaBiomes.createKey("lost_scrubland");
	public static final ResourceKey<Biome> DEEP_SCRUBLAND = IcariaBiomes.createKey("deep_scrubland");

	public static final ResourceKey<Biome> STEPPE = IcariaBiomes.createKey("steppe");
	public static final ResourceKey<Biome> LUSH_STEPPE = IcariaBiomes.createKey("lush_steppe");
	public static final ResourceKey<Biome> LOST_STEPPE = IcariaBiomes.createKey("lost_steppe");
	public static final ResourceKey<Biome> DEEP_STEPPE = IcariaBiomes.createKey("deep_steppe");

	public static final ResourceKey<Biome> DESERT = IcariaBiomes.createKey("desert");
	public static final ResourceKey<Biome> LUSH_DESERT = IcariaBiomes.createKey("lush_desert");
	public static final ResourceKey<Biome> LOST_DESERT = IcariaBiomes.createKey("lost_desert");
	public static final ResourceKey<Biome> DEEP_DESERT = IcariaBiomes.createKey("deep_desert");

	public static final ResourceKey<Biome> VOID = IcariaBiomes.createKey("void");

	public static void bootstrap(BootstrapContext<Biome> pBootstrapContext) {
		var configuredCarvers = pBootstrapContext.lookup(Registries.CONFIGURED_CARVER);
		var placedFeatures = pBootstrapContext.lookup(Registries.PLACED_FEATURE);

		pBootstrapContext.register(IcariaBiomes.FOREST, IcariaBiomes.forestBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.LUSH_FOREST, IcariaBiomes.lushForestBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.LOST_FOREST, IcariaBiomes.lostForestBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.DEEP_FOREST, IcariaBiomes.deepForestBiome(placedFeatures, configuredCarvers));

		pBootstrapContext.register(IcariaBiomes.SCRUBLAND, IcariaBiomes.scrublandBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.LUSH_SCRUBLAND, IcariaBiomes.lushScrublandBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.LOST_SCRUBLAND, IcariaBiomes.lostScrublandBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.DEEP_SCRUBLAND, IcariaBiomes.deepScrublandBiome(placedFeatures, configuredCarvers));

		pBootstrapContext.register(IcariaBiomes.STEPPE, IcariaBiomes.steppeBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.LUSH_STEPPE, IcariaBiomes.lushSteppeBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.LOST_STEPPE, IcariaBiomes.lostSteppeBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.DEEP_STEPPE, IcariaBiomes.deepSteppeBiome(placedFeatures, configuredCarvers));

		pBootstrapContext.register(IcariaBiomes.DESERT, IcariaBiomes.desertBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.LUSH_DESERT, IcariaBiomes.lushDesertBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.LOST_DESERT, IcariaBiomes.lostDesertBiome(placedFeatures, configuredCarvers));
		pBootstrapContext.register(IcariaBiomes.DEEP_DESERT, IcariaBiomes.deepDesertBiome(placedFeatures, configuredCarvers));

		pBootstrapContext.register(IcariaBiomes.VOID, IcariaBiomes.voidBiome(placedFeatures, configuredCarvers));
	}

	public static void forestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CALCITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLOOMY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BRANCHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CHARMONDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LIONFANGS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SPEARDROPS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MOTH_AGARIC);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ORANGE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.STRAWBERRY_BUSH);
	}

	public static void forestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(8427853).skyColor(8301300).waterColor(4227157).waterFogColor(4227157);
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

	public static Biome forestBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.forestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.forestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.forestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lushForestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.DOLOMITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.HALITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LUSH_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LUSH_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLOOMY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BRANCHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CHARMONDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LIONFANGS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SPEARDROPS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MOTH_AGARIC);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ORANGE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.STRAWBERRY_BUSH);
	}

	public static void lushForestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(8427853).skyColor(8301300).waterColor(4227157).waterFogColor(4227157);
	}

	public static void lushForestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FOREST_SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIR_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 1, 3));
	}

	public static Biome lushForestBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lushForestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lushForestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lushForestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lostForestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatures.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.JASPER_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLOOMY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BRANCHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CHARMONDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LIONFANGS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SPEARDROPS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MOTH_AGARIC);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ORANGE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.STRAWBERRY_BUSH);
	}

	public static void lostForestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(8427853).skyColor(8301300).waterColor(4227157).waterFogColor(4227157);
	}

	public static void lostForestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARACHNE_DRONE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIR_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 1, 1));
	}

	public static Biome lostForestBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lostForestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lostForestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lostForestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void deepForestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ZIRCON_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_POPULUS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLOOMY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BRANCHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CHARMONDER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_STORMCOTTON);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LIONFANGS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SPEARDROPS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MOTH_AGARIC);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ORANGE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_BROMELIA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.STRAWBERRY_BUSH);
	}

	public static void deepForestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(8427853).skyColor(8301300).waterColor(4227157).waterFogColor(4227157);
	}

	public static void deepForestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FOREST_SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 1, 1));
	}

	public static Biome deepForestBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.deepForestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.deepForestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.deepForestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void scrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.YELLOWSTONE_BOULDER);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CALCITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.REEDY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SWIRLY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLINDWEED);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FIREHILT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void scrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(10793817).skyColor(8301300).waterColor(4623442).waterFogColor(4623442);
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

	public static Biome scrublandBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.scrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.scrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.scrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lushScrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.DOLOMITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.HALITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LUSH_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LUSH_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.REEDY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SWIRLY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLINDWEED);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FIREHILT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void lushScrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(10793817).skyColor(8301300).waterColor(4623442).waterFogColor(4623442);
	}

	public static void lushScrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 1, 35));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.PLANE_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 1, 3));
	}

	public static Biome lushScrublandBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lushScrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lushScrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lushScrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lostScrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatures.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.JASPER_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.REEDY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SWIRLY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLINDWEED);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FIREHILT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void lostScrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(10793817).skyColor(8301300).waterColor(4623442).waterFogColor(4623442);
	}

	public static void lostScrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARACHNE_DRONE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.PLANE_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 1, 1));
	}

	public static Biome lostScrublandBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lostScrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lostScrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lostScrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void deepScrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ZIRCON_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_PLANE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.REEDY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SWIRLY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLINDWEED);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FIREHILT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_HYDRACINTH);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void deepScrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(10793817).skyColor(8301300).waterColor(4623442).waterFogColor(4623442);
	}

	public static void deepScrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 1, 1));
	}

	public static Biome deepScrublandBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.deepScrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.deepScrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.deepScrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void steppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.YELLOWSTONE_BOULDER);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CALCITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BRUSHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.THORNY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CHAMEOMILE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CLOVER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOW_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void steppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(13421670).skyColor(8301300).waterColor(5085517).waterFogColor(5085517);
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

	public static Biome steppeBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.steppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.steppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.steppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lushSteppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.DOLOMITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.HALITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LUSH_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LUSH_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BRUSHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.THORNY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CHAMEOMILE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CLOVER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOW_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void lushSteppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(13421670).skyColor(8301300).waterColor(5085517).waterFogColor(5085517);
	}

	public static void lushSteppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 1, 3));
	}

	public static Biome lushSteppeBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lushSteppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lushSteppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lushSteppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lostSteppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatures.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.JASPER_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BRUSHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.THORNY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CHAMEOMILE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CLOVER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOW_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void lostSteppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(13421670).skyColor(8301300).waterColor(5085517).waterFogColor(5085517);
	}

	public static void lostSteppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARACHNE_DRONE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 1, 1));
	}

	public static Biome lostSteppeBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lostSteppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lostSteppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lostSteppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void deepSteppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.MEDITERRANEAN_WATER_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ZIRCON_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_OLIVE_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BRUSHY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.THORNY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRASS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAIN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CHAMEOMILE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CLOVER);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOW_STAGHORN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.NAMDRAKE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PSILOCYBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ROWAN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WILTED_ELM);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BLUE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYAN_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PINK_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PURPLE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RED_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.WHITE_GROUND_FLOWERS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PALM_FERN);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
	}

	public static void deepSteppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(13421670).skyColor(8301300).waterColor(5085517).waterFogColor(5085517);
	}

	public static void deepSteppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 1, 3));

		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 1, 1));
	}

	public static Biome deepSteppeBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.deepSteppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.deepSteppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.deepSteppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void desertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.GRAINITE_SPIKE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CALCITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNKETTLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSPONGE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BOLBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CARDON_CACTUS);
	}

	public static void desertBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(15127155).skyColor(8301300).waterColor(6399571).waterFogColor(6399571);
	}

	public static void desertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CROCOTTA.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), 1, 1));
	}

	public static Biome desertBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.desertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.desertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.desertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lushDesertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.DOLOMITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.HALITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LUSH_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNKETTLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSPONGE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BOLBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CARDON_CACTUS);
	}

	public static void lushDesertBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(15127155).skyColor(8301300).waterColor(6399571).waterFogColor(6399571);
	}

	public static void lushDesertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 10, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 1, 3));
	}

	public static Biome lushDesertBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lushDesertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lushDesertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lushDesertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void lostDesertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, IcariaPlacedFeatures.RUIN);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.JASPER_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FALLEN_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNKETTLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSPONGE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BOLBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CARDON_CACTUS);
	}

	public static void lostDesertBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(15127155).skyColor(8301300).waterColor(6399571).waterFogColor(6399571);
	}

	public static void lostDesertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARACHNE_DRONE.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, 1, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 1, 1));
	}

	public static Biome lostDesertBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.lostDesertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.lostDesertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.lostDesertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void deepDesertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ZIRCON_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNKETTLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSPONGE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BOLBOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DATHULLA);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CARDON_CACTUS);
	}

	public static void deepDesertBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(15127155).skyColor(8301300).waterColor(6399571).waterFogColor(6399571);
	}

	public static void deepDesertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 1, 1));
	}

	public static Biome deepDesertBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.deepDesertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.deepDesertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.deepDesertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static void voidBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {

	}

	public static void voidBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(11909984).skyColor(8301300).waterColor(5083986).waterFogColor(5083986);
	}

	public static void voidMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ENDER_JELLYFISH.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIRE_JELLYFISH.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.NATURE_JELLYFISH.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VOID_JELLYFISH.get(), 1, 3));
		pBuilder.addSpawn(MobCategory.AMBIENT, 100, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.WATER_JELLYFISH.get(), 1, 3));
	}

	public static Biome voidBiome(HolderGetter<PlacedFeature> pPlacedFeatures, HolderGetter<ConfiguredWorldCarver<?>> pConfiguredWorldCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pPlacedFeatures, pConfiguredWorldCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.voidBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.voidBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.voidMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().hasPrecipitation(false).downfall(0.0F).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static ResourceKey<Biome> createKey(String pName) {
		return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
