package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.gen.IcariaChunkGenerator;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.OptionalLong;

public class IcariaDimensions {
	/*****************************************************************************/
	// DIMENSION TYPE
	/*****************************************************************************/

	public static final ResourceKey<DimensionType> ICARIA_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
			new ResourceLocation(IcariaInfo.ID, "icaria"));

	public static void bootstrapType(final BootstapContext<DimensionType> context) {
		context.register(ICARIA_DIM_TYPE, dimensionType());
	}

	private static DimensionType dimensionType() {
		return new DimensionType(OptionalLong.of(13000L), // fixed time
				true, // skylight
				false, // ceiling
				false, // ultrawarm
				true, // natural
				1D, // coordinate scale
				true, // bed works
				true, // respawn anchor works
				-64, // Minimum Y Level
				384, // Height + Min Y = Max Y
				384, // Logical Height
				BlockTags.INFINIBURN_OVERWORLD, // infiburn
				BuiltinDimensionTypes.OVERWORLD_EFFECTS, // DimensionRenderInfo
				0f, // ambient light
				new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 7));
	}

	public static List<Climate.ParameterPoint> spawnTarget() {
		final Climate.Parameter temperature = FULL_RANGE;
		final Climate.Parameter humidity = FULL_RANGE;
		final Climate.Parameter continentalness = Climate.Parameter.span(Climate.Parameter.span(-0.11F, 0.55F),
				FULL_RANGE);
		final Climate.Parameter erosion = FULL_RANGE;
		final Climate.Parameter depth = Climate.Parameter.point(0.0F);
		final Climate.Parameter weirdness1 = Climate.Parameter.span(-1.0F, -0.16F);
		final Climate.Parameter weirdness2 = Climate.Parameter.span(0.16F, 1.0F);

		return List.of(
				new Climate.ParameterPoint(temperature, humidity, continentalness, erosion, depth, weirdness1, 0L),
				new Climate.ParameterPoint(temperature, humidity, continentalness, erosion, depth, weirdness2, 0L));
	}

	/*****************************************************************************/
	// DIMENSION
	/*****************************************************************************/

	public static final ResourceKey<Level> ICARIA = ResourceKey.create(Registries.DIMENSION,
			new ResourceLocation(IcariaInfo.ID, "icaria"));

	public static final ResourceKey<LevelStem> ICARIA_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM,
			new ResourceLocation(IcariaInfo.ID, "icaria"));

	public static final DeferredRegister<Codec<? extends ChunkGenerator>> CHUNK_GENERATORS = DeferredRegister
			.create(Registries.CHUNK_GENERATOR, IcariaInfo.ID);

	public static final RegistryObject<Codec<? extends ChunkGenerator>> ICARIA_CHUNKGEN = CHUNK_GENERATORS
			.register("chunkgen", () -> IcariaChunkGenerator.CODEC);

	public static final ResourceKey<NoiseGeneratorSettings> ICARIA_NOISE_SETTINGS = ResourceKey
			.create(Registries.NOISE_SETTINGS, new ResourceLocation(IcariaInfo.ID, "noise_settings"));

	public static void bootstrapNoiseSettings(final BootstapContext<NoiseGeneratorSettings> context) {
		final BlockState defaultBlock = IcariaBlocks.MARL.get().defaultBlockState();
		final BlockState defaultFluid = Blocks.AIR.defaultBlockState();
		final NoiseRouter noiseRouter = NoiseGeneratorSettings.overworld(context, false, false).noiseRouter();
		final SurfaceRules.RuleSource surfaceRule = SurfaceRuleData.air();
		final List<Climate.ParameterPoint> spawnTarget = spawnTarget();
		final int seaLevel = 63;
		final boolean disableMobGeneration = false;
		final boolean aquifersEnabled = false;
		final boolean oreVeinsEnabled = false;
		final boolean useLegacyRandomSource = false;
		final NoiseGeneratorSettings noiseSettings = new NoiseGeneratorSettings(new NoiseSettings(-64, 384, 1, 2),
				defaultBlock, defaultFluid, noiseRouter, surfaceRule, spawnTarget, seaLevel, disableMobGeneration,
				aquifersEnabled, oreVeinsEnabled, useLegacyRandomSource);
		context.register(ICARIA_NOISE_SETTINGS, noiseSettings);
	}

	public static void bootstrapDimension(final BootstapContext<LevelStem> context) {
		final HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
		final HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
		final HolderGetter<NoiseGeneratorSettings> noiseSettings = context.lookup(Registries.NOISE_SETTINGS);
		final IcariaChunkGenerator chunkGenerator = new IcariaChunkGenerator(
				MultiNoiseBiomeSource.createFromList(biomeList(biomeRegistry)),
				noiseSettings.getOrThrow(ICARIA_NOISE_SETTINGS));
		final LevelStem stem = new LevelStem(dimTypes.getOrThrow(ICARIA_DIM_TYPE), chunkGenerator);

		context.register(ICARIA_LEVEL_STEM, stem);
	}

	private static Climate.ParameterList<Holder<Biome>> biomeList(final HolderGetter<Biome> biomeRegistry) {
		final List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = List.of(voidParameters(biomeRegistry),
				scrublandParameters(biomeRegistry), desertParameters(biomeRegistry), forestParameters(biomeRegistry),
				steppeParameters(biomeRegistry));
		return new Climate.ParameterList<Holder<Biome>>(parameters);
	}

	private final static Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);

	// Continentalness: to separate the void from "continents".
	private final static Climate.Parameter CONTINENTAL = Climate.Parameter.span(0.19F, 1.05F);
	private final static Climate.Parameter VOID = Climate.Parameter.span(-1.05F, -0.19F);

	// Temperatures TODO: add more options than just HOT/COLD like WARM
	private final static Climate.Parameter COLD = Climate.Parameter.span(-1F, 0F);
	private final static Climate.Parameter HOT = Climate.Parameter.span(0F, 1F);

	// Humidities TODO: add more options than just DRY/WET
	private final static Climate.Parameter DRY = Climate.Parameter.span(-1F, 0F);
	private final static Climate.Parameter WET = Climate.Parameter.span(0F, 1F);

	private static Pair<Climate.ParameterPoint, Holder<Biome>> voidParameters(final HolderGetter<Biome> biomeRegistry) {
		final Climate.Parameter temperature = FULL_RANGE;
		final Climate.Parameter humidity = FULL_RANGE;
		final Climate.Parameter continentalness = VOID;
		final Climate.Parameter erosion = FULL_RANGE;
		final Climate.Parameter depth = FULL_RANGE;
		final Climate.Parameter weirdness = Climate.Parameter.point(0.0f);
		final Climate.ParameterPoint parameters = new Climate.ParameterPoint(temperature, humidity, continentalness,
				erosion, depth, weirdness, 0);
		return new Pair<>(parameters, biomeRegistry.getOrThrow(IcariaBiomes.VOID));
	}

	private static Pair<Climate.ParameterPoint, Holder<Biome>> scrublandParameters(
			final HolderGetter<Biome> biomeRegistry) {
		final Climate.Parameter temperature = FULL_RANGE;
		final Climate.Parameter humidity = DRY;
		final Climate.Parameter continentalness = CONTINENTAL;
		final Climate.Parameter erosion = Climate.Parameter.point(0.0f);
		final Climate.Parameter depth = Climate.Parameter.point(0.0f);
		final Climate.Parameter weirdness = Climate.Parameter.point(0.0f);
		final Climate.ParameterPoint parameters = new Climate.ParameterPoint(temperature, humidity, continentalness,
				erosion, depth, weirdness, 0);
		return new Pair<>(parameters, biomeRegistry.getOrThrow(IcariaBiomes.SCRUBLAND));
	}

	private static Pair<Climate.ParameterPoint, Holder<Biome>> desertParameters(
			final HolderGetter<Biome> biomeRegistry) {
		final Climate.Parameter temperature = HOT;
		final Climate.Parameter humidity = DRY;
		final Climate.Parameter continentalness = CONTINENTAL;
		final Climate.Parameter erosion = Climate.Parameter.point(0.0f);
		final Climate.Parameter depth = Climate.Parameter.point(0.0f);
		final Climate.Parameter weirdness = Climate.Parameter.point(0.0f);
		final Climate.ParameterPoint parameters = new Climate.ParameterPoint(temperature, humidity, continentalness,
				erosion, depth, weirdness, 0);
		return new Pair<>(parameters, biomeRegistry.getOrThrow(IcariaBiomes.DESERT));
	}

	private static Pair<Climate.ParameterPoint, Holder<Biome>> forestParameters(
			final HolderGetter<Biome> biomeRegistry) {
		final Climate.Parameter temperature = FULL_RANGE;
		final Climate.Parameter humidity = WET;
		final Climate.Parameter continentalness = CONTINENTAL;
		final Climate.Parameter erosion = Climate.Parameter.point(0.0f);
		final Climate.Parameter depth = Climate.Parameter.point(0.0f);
		final Climate.Parameter weirdness = Climate.Parameter.point(0.0f);
		final Climate.ParameterPoint parameters = new Climate.ParameterPoint(temperature, humidity, continentalness,
				erosion, depth, weirdness, 0);
		return new Pair<>(parameters, biomeRegistry.getOrThrow(IcariaBiomes.FOREST));
	}

	private static Pair<Climate.ParameterPoint, Holder<Biome>> steppeParameters(
			final HolderGetter<Biome> biomeRegistry) {
		final Climate.Parameter temperature = COLD;
		final Climate.Parameter humidity = DRY;
		final Climate.Parameter continentalness = CONTINENTAL;
		final Climate.Parameter erosion = Climate.Parameter.point(0.0f);
		final Climate.Parameter depth = Climate.Parameter.point(0.0f);
		final Climate.Parameter weirdness = Climate.Parameter.point(0.0f);
		final Climate.ParameterPoint parameters = new Climate.ParameterPoint(temperature, humidity, continentalness,
				erosion, depth, weirdness, 0);
		return new Pair<>(parameters, biomeRegistry.getOrThrow(IcariaBiomes.DESERT));
	}
}
