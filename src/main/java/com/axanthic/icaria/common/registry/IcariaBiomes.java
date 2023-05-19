package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class IcariaBiomes {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registries.BIOME, IcariaInfo.ID);

	public static final ResourceKey<Biome> VOID = makeKey("void");
	public static final ResourceKey<Biome> SCRUBLAND = makeKey("scrubland");
	public static final ResourceKey<Biome> DESERT = makeKey("desert");
	public static final ResourceKey<Biome> FOREST = makeKey("forest");
	public static final ResourceKey<Biome> STEPPE = makeKey("steppe");

	private static ResourceKey<Biome> makeKey(final String name) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(IcariaInfo.ID, name));
	}

	public static void bootstrapBiomes(final BootstapContext<Biome> context) {
		final HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);
		final HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

		// Register all biomes here.
		registerBootstrap(context, IcariaBiomes.SCRUBLAND,
				IcariaBiomes.makeScrublandBiome(placedFeatureGetter, carverGetter));
		registerBootstrap(context, IcariaBiomes.DESERT,
				IcariaBiomes.makeDesertBiome(placedFeatureGetter, carverGetter));
		registerBootstrap(context, IcariaBiomes.VOID, IcariaBiomes.makeVoidBiome(placedFeatureGetter, carverGetter));
		registerBootstrap(context, IcariaBiomes.FOREST,
				IcariaBiomes.makeForestBiome(placedFeatureGetter, carverGetter));
		registerBootstrap(context, IcariaBiomes.STEPPE,
				IcariaBiomes.makeSteppeBiome(placedFeatureGetter, carverGetter));
	}

	private static void registerBootstrap(final BootstapContext<Biome> context, final ResourceKey<Biome> key,
			final Biome biome) {
		context.register(key, biome);
	}

	public static Map<ResourceKey<Biome>, BiomeConfiguration> configurations = Map.of(IcariaBiomes.SCRUBLAND,
			new BiomeConfiguration(1.0, 4.5), IcariaBiomes.DESERT, new BiomeConfiguration(4d, 12.5d), IcariaBiomes.VOID,
			new BiomeConfiguration(1.0, 1.0), IcariaBiomes.FOREST, new BiomeConfiguration(-0.5, 1.0),
			IcariaBiomes.STEPPE, new BiomeConfiguration(1.0, 1.0));

	/*****************************************************************************/
	// VOID
	/*****************************************************************************/

	public static Biome makeVoidBiome(final HolderGetter<PlacedFeature> placedFeatures,
			final HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		final MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		IcariaBiomes.voidSpawns(mobSpawnSettings);

		final BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures,
				worldCarvers);
		IcariaBiomes.voidGenerationSettings(generationSettings);

		final BiomeSpecialEffects.Builder specialEffects = new BiomeSpecialEffects.Builder();
		IcariaBiomes.voidSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(0F).downfall(0F)
				.specialEffects(specialEffects.build()).mobSpawnSettings(mobSpawnSettings.build())
				.generationSettings(generationSettings.build()).build();
	}

	public static void voidSpawns(final MobSpawnSettings.Builder builder) {
		// TODO
	}

	public static void voidGenerationSettings(final BiomeGenerationSettings.Builder builder) {
		// Note: new features might need to modify chunk generator...
		builder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.VOID_TB_KEY);
	}

	public static void voidSpecialEffects(final BiomeSpecialEffects.Builder builder) {
		// TODO: these are random values for now.
		builder.waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0)
				.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
	}

	/*****************************************************************************/
	// SCRUBLAND
	/*****************************************************************************/

	public static Biome makeScrublandBiome(final HolderGetter<PlacedFeature> placedFeatures,
			final HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		final MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		IcariaBiomes.scrublandSpawns(mobSpawnSettings);

		final BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures,
				worldCarvers);
		IcariaBiomes.scrublandGenerationSettings(generationSettings);

		final BiomeSpecialEffects.Builder specialEffects = new BiomeSpecialEffects.Builder();
		IcariaBiomes.scrublandSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(1.2F).downfall(0.5F)
				.specialEffects(specialEffects.build()).mobSpawnSettings(mobSpawnSettings.build())
				.generationSettings(generationSettings.build()).build();
	}

	public static void scrublandSpawns(final MobSpawnSettings.Builder builder) {
		// TODO
	}

	public static void scrublandGenerationSettings(final BiomeGenerationSettings.Builder builder) {
		// Note: new features might need to modify chunk generator...
		builder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.SCRUBLAND_TB_KEY);
	}

	public static void scrublandSpecialEffects(final BiomeSpecialEffects.Builder builder) {
		// TODO: these are random values for now.
		builder.waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0)
				.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
	}

	/*****************************************************************************/
	// DESERT
	/*****************************************************************************/

	public static Biome makeDesertBiome(final HolderGetter<PlacedFeature> placedFeatures,
			final HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		final MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		IcariaBiomes.desertSpawns(mobSpawnSettings);

		final BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures,
				worldCarvers);
		IcariaBiomes.desertGenerationSettings(generationSettings);

		final BiomeSpecialEffects.Builder specialEffects = new BiomeSpecialEffects.Builder();
		IcariaBiomes.desertSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(1.2F).downfall(0.5F)
				.specialEffects(specialEffects.build()).mobSpawnSettings(mobSpawnSettings.build())
				.generationSettings(generationSettings.build()).build();
	}

	public static void desertSpawns(final MobSpawnSettings.Builder builder) {
		// TODO
	}

	public static void desertGenerationSettings(final BiomeGenerationSettings.Builder builder) {
		// Note: new features might need to modify chunk generator...
		builder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.DESERT_TB_KEY);
	}

	public static void desertSpecialEffects(final BiomeSpecialEffects.Builder builder) {
		// TODO: these are random values for now.
		builder.waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0)
				.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
	}

	/*****************************************************************************/
	// FOREST
	/*****************************************************************************/

	public static Biome makeForestBiome(final HolderGetter<PlacedFeature> placedFeatures,
			final HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		final MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		IcariaBiomes.forestSpawns(mobSpawnSettings);

		final BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures,
				worldCarvers);
		IcariaBiomes.forestGenerationSettings(generationSettings);

		final BiomeSpecialEffects.Builder specialEffects = new BiomeSpecialEffects.Builder();
		IcariaBiomes.forestSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(1.2F).downfall(0.5F)
				.specialEffects(specialEffects.build()).mobSpawnSettings(mobSpawnSettings.build())
				.generationSettings(generationSettings.build()).build();
	}

	public static void forestSpawns(final MobSpawnSettings.Builder builder) {
		// TODO
	}

	public static void forestGenerationSettings(final BiomeGenerationSettings.Builder builder) {
		// Note: new features might need to modify chunk generator...
		builder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.FOREST_TB_KEY);
	}

	public static void forestSpecialEffects(final BiomeSpecialEffects.Builder builder) {
		// TODO: these are random values for now.
		builder.waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0)
				.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
	}

	/*****************************************************************************/
	// STEPPE
	/*****************************************************************************/

	public static Biome makeSteppeBiome(final HolderGetter<PlacedFeature> placedFeatures,
			final HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
		final MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
		IcariaBiomes.steppeSpawns(mobSpawnSettings);

		final BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures,
				worldCarvers);
		IcariaBiomes.steppeGenerationSettings(generationSettings);

		final BiomeSpecialEffects.Builder specialEffects = new BiomeSpecialEffects.Builder();
		IcariaBiomes.steppeSpecialEffects(specialEffects);

		return new Biome.BiomeBuilder().hasPrecipitation(false).temperature(1.2F).downfall(0.5F)
				.specialEffects(specialEffects.build()).mobSpawnSettings(mobSpawnSettings.build())
				.generationSettings(generationSettings.build()).build();
	}

	public static void steppeSpawns(final MobSpawnSettings.Builder builder) {
		// TODO
	}

	public static void steppeGenerationSettings(final BiomeGenerationSettings.Builder builder) {
		// Note: new features might need to modify chunk generator...
		builder.addCarver(GenerationStep.Carving.AIR, IcariaCarvers.STEPPE_TB_KEY);
	}

	public static void steppeSpecialEffects(final BiomeSpecialEffects.Builder builder) {
		// TODO: these are random values for now.
		builder.waterColor(4159204).waterFogColor(329011).fogColor(10518688).skyColor(0)
				.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);
	}

	public record BiomeConfiguration(double density, double craziness) {

	}
}
