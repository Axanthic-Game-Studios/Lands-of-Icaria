package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
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

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

// TODO MC-186626
// set temperatures to zero

public class IcariaBiomes {
	public static final ResourceKey<Biome> FOREST = IcariaBiomes.registerKey("forest");
	public static final ResourceKey<Biome> FOREST_PLATEAU = IcariaBiomes.registerKey("forest_plateau");
	public static final ResourceKey<Biome> SCRUBLAND = IcariaBiomes.registerKey("scrubland");
	public static final ResourceKey<Biome> SCRUBLAND_PLATEAU = IcariaBiomes.registerKey("scrubland_plateau");
	public static final ResourceKey<Biome> STEPPE = IcariaBiomes.registerKey("steppe");
	public static final ResourceKey<Biome> STEPPE_PLATEAU = IcariaBiomes.registerKey("steppe_plateau");
	public static final ResourceKey<Biome> DESERT = IcariaBiomes.registerKey("desert");
	public static final ResourceKey<Biome> DESERT_PLATEAU = IcariaBiomes.registerKey("desert_plateau");
	public static final ResourceKey<Biome> VOID = IcariaBiomes.registerKey("void");

	public static void bootstrap(BootstapContext<Biome> pContext) {
		var configuredCarvers = pContext.lookup(Registries.CONFIGURED_CARVER);
		var placedFeatures = pContext.lookup(Registries.PLACED_FEATURE);

		pContext.register(IcariaBiomes.FOREST, IcariaBiomes.forestBiome(placedFeatures, configuredCarvers));
		pContext.register(IcariaBiomes.FOREST_PLATEAU, IcariaBiomes.forestBiome(placedFeatures, configuredCarvers));
		pContext.register(IcariaBiomes.SCRUBLAND, IcariaBiomes.scrublandBiome(placedFeatures, configuredCarvers));
		pContext.register(IcariaBiomes.SCRUBLAND_PLATEAU, IcariaBiomes.scrublandBiome(placedFeatures, configuredCarvers));
		pContext.register(IcariaBiomes.STEPPE, IcariaBiomes.steppeBiome(placedFeatures, configuredCarvers));
		pContext.register(IcariaBiomes.STEPPE_PLATEAU, IcariaBiomes.steppeBiome(placedFeatures, configuredCarvers));
		pContext.register(IcariaBiomes.DESERT, IcariaBiomes.desertBiome(placedFeatures, configuredCarvers));
		pContext.register(IcariaBiomes.DESERT_PLATEAU, IcariaBiomes.desertBiome(placedFeatures, configuredCarvers));
		pContext.register(IcariaBiomes.VOID, IcariaBiomes.voidBiome(placedFeatures, configuredCarvers));
	}

	// FOREST

	public static void forestBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.DOLOMITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CALCITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.HALITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.JASPER_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ZIRCON_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_FIR_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.POPULUS_TREE);
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

	public static void forestBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(8427853).skyColor(8301300).waterColor(4227157).waterFogColor(4227157);
	}

	public static void forestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CATOBLEPAS.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FOREST_SNULL.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOW.get(), 100, 3, 5));

		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIR_FOREST_HAG.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 10, 1, 1));
	}

	public static Biome forestBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.forestBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.forestBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.forestMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	// SCRUBLAND

	public static void scrublandBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.YELLOWSTONE_BOULDER);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.DOLOMITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CALCITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.HALITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.JASPER_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ZIRCON_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_LAUREL_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.PLANE_TREE);
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

	public static void scrublandBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(10793817).skyColor(8301300).waterColor(4623442).waterFogColor(4623442);
	}

	public static void scrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CATOBLEPAS.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOW.get(), 100, 3, 5));

		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.PLANE_FOREST_HAG.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 10, 1, 1));
	}

	public static Biome scrublandBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.scrublandBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.scrublandBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.scrublandMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	// STEPPE

	public static void steppeBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);

		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.YELLOWSTONE_BOULDER);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.DOLOMITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_BONES);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MARL_LIGNITE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.YELLOWSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDSHALE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BAETYL_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CALCITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.HALITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.JASPER_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ZIRCON_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_CYPRESS_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.OLIVE_TREE);
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

	public static void steppeBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(13421670).skyColor(8301300).waterColor(5085517).waterFogColor(5085517);
	}

	public static void steppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CATOBLEPAS.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRYSTAL_SLUG.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SNULL.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOW.get(), 100, 3, 5));

		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 10, 1, 1));
	}

	public static Biome steppeBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.steppeBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.steppeBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.steppeMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	// DESERT

	public static void desertBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VILLAGE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.GRAINITE_SPIKE);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.FALLEN_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.HORIZONTAL_RELICSTONE_PILLAR);
		pBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, IcariaPlacedFeatures.VERTICAL_RELICSTONE_PILLAR);

		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.LIGNITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.CHALKOS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.KASSITEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.DOLOMITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.VANADIUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SLIVER_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.SIDEROS_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.ANTHRACITE_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.MOLYBDENUM_ORE);
		pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, IcariaPlacedFeatures.HYLIASTRUM_ORE);

		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAINEL_CHERT);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GRAINITE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DESERT_SILKSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.RELICSTONE_RUBBLE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CALCITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.HALITE_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.JASPER_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.ZIRCON_CRYSTAL);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DEAD_DROUGHTROOT_TREE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.DRY_VINE);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.SUNKETTLE);
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
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.MYRMEKE_DRONE.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CRAWLER_REVENANT.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.OVERGROWN_REVENANT.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 10, 1, 1));
	}

	public static Biome desertBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.desertBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.desertBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.desertMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	// VOID

	public static void voidBiomeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.VOIDLILY);
	}

	public static void voidBiomeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.fogColor(14470514).grassColorOverride(11909984).skyColor(8301300).waterColor(5083986).waterFogColor(5083986);
	}

	public static void voidMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ENDER_JELLYFISH.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.FIRE_JELLYFISH.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.NATURE_JELLYFISH.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VOID_JELLYFISH.get(), 100, 3, 5));
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.WATER_JELLYFISH.get(), 100, 3, 5));
	}

	public static Biome voidBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var biomeGenerationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var biomeSpecialEffects = new BiomeSpecialEffects.Builder();
		var mobSpawnSettings = new MobSpawnSettings.Builder();

		IcariaBiomes.voidBiomeGenerationSettings(biomeGenerationSettings);
		IcariaBiomes.voidBiomeSpecialEffects(biomeSpecialEffects);
		IcariaBiomes.voidMobSpawnSettings(mobSpawnSettings);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(biomeGenerationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(biomeSpecialEffects.build()).build();
	}

	public static ResourceKey<Biome> registerKey(String pName) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
