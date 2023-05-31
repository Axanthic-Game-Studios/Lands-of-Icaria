package com.axanthic.icaria.common.registry;

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
	public static final ResourceKey<Biome> STEPPE = IcariaBiomes.registerKey("steppe");
	public static final ResourceKey<Biome> SCRUBLAND = IcariaBiomes.registerKey("scrubland");
	public static final ResourceKey<Biome> DESERT = IcariaBiomes.registerKey("desert");
	public static final ResourceKey<Biome> VOID = IcariaBiomes.registerKey("void");

	public static ResourceKey<Biome> registerKey(String pName) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(IcariaInfo.ID, pName));
	}

	public static void bootstrapBiomes(BootstapContext<Biome> pContext) {
		var configuredCarvers = pContext.lookup(Registries.CONFIGURED_CARVER);
		var placedFeatures = pContext.lookup(Registries.PLACED_FEATURE);

		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.FOREST, IcariaBiomes.forestBiome(placedFeatures, configuredCarvers));
		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.STEPPE, IcariaBiomes.steppeBiome(placedFeatures, configuredCarvers));
		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.SCRUBLAND, IcariaBiomes.scrublandBiome(placedFeatures, configuredCarvers));
		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.DESERT, IcariaBiomes.desertBiome(placedFeatures, configuredCarvers));
		IcariaBiomes.registerBootstrap(pContext, IcariaBiomes.VOID, IcariaBiomes.voidBiome(placedFeatures, configuredCarvers));
	}

	public static void registerBootstrap(BootstapContext<Biome> pContext, ResourceKey<Biome> pKey, Biome pBiome) {
		pContext.register(pKey, pBiome);
	}

	public static Map<ResourceKey<Biome>, BiomeConfiguration> configurations = Map.of(IcariaBiomes.FOREST, new BiomeConfiguration(-0.5D, 1.0D), IcariaBiomes.STEPPE, new BiomeConfiguration(1.0D, 1.0D), IcariaBiomes.SCRUBLAND, new BiomeConfiguration(1.0D, 4.5D), IcariaBiomes.DESERT, new BiomeConfiguration(4.0D, 12.5D), IcariaBiomes.VOID, new BiomeConfiguration(1.0D, 1.0D));

	// FOREST

	public static Biome forestBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.forestGenerationSettings(generationSettings);
		IcariaBiomes.forestMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.forestSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	public static void forestGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.FOREST_TB_KEY);
	}

	public static void forestMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 1, 3));
	}

	public static void forestSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	// STEPPE

	public static Biome steppeBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.steppeGenerationSettings(generationSettings);
		IcariaBiomes.steppeMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.steppeSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	public static void steppeGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.STEPPE_TB_KEY);
	}

	public static void steppeMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 1, 3));
	}

	public static void steppeSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	// SCRUBLAND

	public static Biome scrublandBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.scrublandGenerationSettings(generationSettings);
		IcariaBiomes.scrublandMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.scrublandSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	public static void scrublandGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.SCRUBLAND_TB_KEY);
	}

	public static void scrublandMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 1, 3));
	}

	public static void scrublandSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	// DESERT

	public static Biome desertBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.desertGenerationSettings(generationSettings);
		IcariaBiomes.desertMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.desertSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	public static void desertGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.DESERT_TB_KEY);
	}

	public static void desertMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.AETERNAE.get(), 100, 1, 3));
	}

	public static void desertSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	// VOID

	public static Biome voidBiome(HolderGetter<PlacedFeature> pFeatures, HolderGetter<ConfiguredWorldCarver<?>> pCarvers) {
		var generationSettings = new BiomeGenerationSettings.Builder(pFeatures, pCarvers);
		var mobSpawnSettings = new MobSpawnSettings.Builder();
		var specialEffects = new BiomeSpecialEffects.Builder();

		IcariaBiomes.voidGenerationSettings(generationSettings);
		IcariaBiomes.voidMobSpawnSettings(mobSpawnSettings);
		IcariaBiomes.voidSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().downfall(0.0F).hasPrecipitation(false).temperature(1.0F).temperatureAdjustment(Biome.TemperatureModifier.NONE).generationSettings(generationSettings.build()).mobSpawnSettings(mobSpawnSettings.build()).specialEffects(specialEffects.build()).build();
	}

	public static void voidGenerationSettings(BiomeGenerationSettings.Builder pBuilder) {
		pBuilder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.VOID_TB_KEY);
	}

	public static void voidMobSpawnSettings(MobSpawnSettings.Builder pBuilder) {
		pBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(IcariaEntityTypes.ENDER_JELLYFISH.get(), 10, 1, 3));
	}

	public static void voidSpecialEffects(BiomeSpecialEffects.Builder pBuilder) {
		pBuilder.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).fogColor(10518688).skyColor(0).waterColor(4159204).waterFogColor(329011);
	}

	public record BiomeConfiguration(double pDensity, double pCraziness) {

	}
}
