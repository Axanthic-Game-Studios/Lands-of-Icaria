package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.BiomeConfiguration;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registries.BIOME, IcariaInfo.ID);

	public static final ResourceKey<Biome> FOREST = IcariaBiomes.registerKey("forest");
	public static final ResourceKey<Biome> SCRUBLAND = IcariaBiomes.registerKey("scrubland");
	public static final ResourceKey<Biome> STEPPE = IcariaBiomes.registerKey("steppe");
	public static final ResourceKey<Biome> DESERT = IcariaBiomes.registerKey("desert");
	public static final ResourceKey<Biome> VOID = IcariaBiomes.registerKey("void");

	public static final Map<ResourceKey<Biome>, BiomeConfiguration> CONFIGURATIONS = Map.of(IcariaBiomes.FOREST, new BiomeConfiguration(-0.5D, 1.0D), IcariaBiomes.SCRUBLAND, new BiomeConfiguration(1.0D, 4.5D), IcariaBiomes.STEPPE, new BiomeConfiguration(1.0D, 1.0D), IcariaBiomes.DESERT, new BiomeConfiguration(4.0D, 12.5D), IcariaBiomes.VOID, new BiomeConfiguration(1.0D, 1.0D));

	public static void bootstrapBiomes(BootstapContext<Biome> pContext) {
		var configuredCarvers = pContext.lookup(Registries.CONFIGURED_CARVER);
		var placedFeatures = pContext.lookup(Registries.PLACED_FEATURE);

		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.FOREST, IcariaBiomes.forestBiome(placedFeatures, configuredCarvers));
		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.SCRUBLAND, IcariaBiomes.scrublandBiome(placedFeatures, configuredCarvers));
		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.STEPPE, IcariaBiomes.steppeBiome(placedFeatures, configuredCarvers));
		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.DESERT, IcariaBiomes.desertBiome(placedFeatures, configuredCarvers));
		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.VOID, IcariaBiomes.voidBiome(placedFeatures, configuredCarvers));
	}

	public static void registerBootstrap(BootstapContext<Biome> pContext, ResourceKey<Biome> pKey, Biome pBiome) {
		pContext.register(pKey, pBiome);
	}

	public static ResourceKey<Biome> registerKey(String pName) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(IcariaInfo.ID, pName));
	}

	// FOREST

	public static void forestGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.FOREST_TB_KEY);
	}

	public static void forestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 1, 3));
	}

	public static void forestSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	public static Biome forestBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.forestGenerationSettings(generationSettings);
		IcariaBiomes.forestMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.forestSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	// SCRUBLAND

	public static void scrublandGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.SCRUBLAND_TB_KEY);

		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.LAKE);
		pBuilder.addFeature(GenerationStep.Decoration.LAKES, IcariaPlacedFeatures.DRY_LAKE);

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
	}

	public static void scrublandSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	public static Biome scrublandBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.scrublandGenerationSettings(generationSettings);
		IcariaBiomes.scrublandMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.scrublandSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	// STEPPE

	public static void steppeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.STEPPE_TB_KEY);
	}

	public static void steppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 1, 3));
	}

	public static void steppeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	public static Biome steppeBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.steppeGenerationSettings(generationSettings);
		IcariaBiomes.steppeMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.steppeSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	// DESERT

	public static void desertGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.DESERT_TB_KEY);

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
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.MONDANOS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.GREEN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.LARGE_BROWN_GROUND_SHROOMS);
		pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, IcariaPlacedFeatures.CARDON_CACTUS);
	}

	public static void desertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ARGAN_HOUND.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.CERVER.get(), 100, 1, 3));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), 10, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SCORPION.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.SOLIFUGAE.get(), 100, 1, 1));
		pBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.VINEGAROON.get(), 10, 1, 1));
	}

	public static void desertSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	public static Biome desertBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.desertGenerationSettings(generationSettings);
		IcariaBiomes.desertMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.desertSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	// VOID

	public static void voidGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.VOID_TB_KEY);
	}

	public static void voidMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ENDER_JELLYFISH.get(), 10, 1, 3));
	}

	public static void voidSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	public static Biome voidBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.voidGenerationSettings(generationSettings);
		IcariaBiomes.voidMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.voidSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}
}
