package com.axanthic.icaria.common.registry;

import com.mojang.datafixers.util.Pair;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLevelStems {
	public static final Climate.Parameter VERY_COLD = Climate.Parameter.span(-1.0F, -0.5F);
	public static final Climate.Parameter COLD = Climate.Parameter.span(-0.5F, 0.0F);
	public static final Climate.Parameter WARM = Climate.Parameter.span(0.0F, 0.5F);
	public static final Climate.Parameter VERY_WARM = Climate.Parameter.span(0.5F, 1.0F);

	public static final Climate.Parameter FULL = Climate.Parameter.span(-1.0F, 1.0F);

	public static final Climate.Parameter LAND = Climate.Parameter.span(0.0F, 0.75F);
	public static final Climate.Parameter VOID = Climate.Parameter.span(-1.0F, 0.0F);

	public static final Climate.Parameter BASE = Climate.Parameter.span(0.5F, 1.0F);
	public static final Climate.Parameter LUSH = Climate.Parameter.span(0.0F, 0.5F);
	public static final Climate.Parameter LOST = Climate.Parameter.span(-0.5F, 0.0F);
	public static final Climate.Parameter DEEP = Climate.Parameter.span(-1.0F, -0.5F);

	public static final Climate.Parameter ZERO = Climate.Parameter.point(0.0F);

	public static final ResourceKey<LevelStem> ICARIA = IcariaLevelStems.createKey("icaria");

	public static void bootstrap(BootstrapContext<LevelStem> pContext) {
		var biomes = pContext.lookup(Registries.BIOME);
		pContext.register(IcariaLevelStems.ICARIA, new LevelStem(pContext.lookup(Registries.DIMENSION_TYPE).getOrThrow(IcariaDimensionTypes.ICARIA), new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(IcariaLevelStems.forestParameters(biomes), IcariaLevelStems.lushForestParameters(biomes), IcariaLevelStems.lostForestParameters(biomes), IcariaLevelStems.deepForestParameters(biomes), IcariaLevelStems.scrublandParameters(biomes), IcariaLevelStems.lushScrublandParameters(biomes), IcariaLevelStems.lostScrublandParameters(biomes), IcariaLevelStems.deepScrublandParameters(biomes), IcariaLevelStems.steppeParameters(biomes), IcariaLevelStems.lushSteppeParameters(biomes), IcariaLevelStems.lostSteppeParameters(biomes), IcariaLevelStems.deepSteppeParameters(biomes), IcariaLevelStems.desertParameters(biomes), IcariaLevelStems.lushDesertParameters(biomes), IcariaLevelStems.lostDesertParameters(biomes), IcariaLevelStems.deepDesertParameters(biomes), IcariaLevelStems.voidParameters(biomes)))), pContext.lookup(Registries.NOISE_SETTINGS).getOrThrow(IcariaNoiseSettings.ICARIA))));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> forestParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.BASE, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.FOREST));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> lushForestParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.LUSH, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.LUSH_FOREST));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> lostForestParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.LOST, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.LOST_FOREST));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> deepForestParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.DEEP, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.DEEP_FOREST));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> scrublandParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.BASE, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.SCRUBLAND));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> lushScrublandParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.LUSH, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.LUSH_SCRUBLAND));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> lostScrublandParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.LOST, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.LOST_SCRUBLAND));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> deepScrublandParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.DEEP, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.DEEP_SCRUBLAND));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> steppeParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.BASE, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.STEPPE));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> lushSteppeParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.LUSH, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.LUSH_STEPPE));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> lostSteppeParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.LOST, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.LOST_STEPPE));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> deepSteppeParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.DEEP, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.DEEP_STEPPE));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> desertParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.BASE, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.DESERT));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> lushDesertParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.LUSH, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.LUSH_DESERT));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> lostDesertParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.LOST, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.LOST_DESERT));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> deepDesertParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.DEEP, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.DEEP_DESERT));
	}

	public static Pair<Climate.ParameterPoint, Holder<Biome>> voidParameters(HolderGetter<Biome> pBiomes) {
		return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.FULL, IcariaLevelStems.ZERO, IcariaLevelStems.VOID, IcariaLevelStems.ZERO, IcariaLevelStems.FULL, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.VOID));
	}

	public static ResourceKey<LevelStem> createKey(String pName) {
		return ResourceKey.create(Registries.LEVEL_STEM, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
