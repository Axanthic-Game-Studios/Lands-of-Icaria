package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

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
    public static final Climate.Parameter FULL = Climate.Parameter.span(-1.0F, 1.0F);

    public static final Climate.Parameter VERY_COLD = Climate.Parameter.span(-1.0F, -0.5F);
    public static final Climate.Parameter COLD = Climate.Parameter.span(-0.5F, 0.0F);
    public static final Climate.Parameter WARM = Climate.Parameter.span(0.0F, 0.5F);
    public static final Climate.Parameter VERY_WARM = Climate.Parameter.span(0.5F, 1.0F);

    public static final Climate.Parameter PLATEAU = Climate.Parameter.span(1.0F, 2.0F);

    public static final Climate.Parameter LAND = Climate.Parameter.span(0.0F, 0.75F);
    public static final Climate.Parameter VOID = Climate.Parameter.span(-1.0F, 0.0F);

    public static final Climate.Parameter ZERO = Climate.Parameter.point(0.0F);

    public static final ResourceKey<LevelStem> ICARIA = ResourceKey.create(Registries.LEVEL_STEM, ResourceLocation.fromNamespaceAndPath(IcariaInfo.ID, "icaria"));

    public static void bootstrap(BootstrapContext<LevelStem> pContext) {
        var biomes = pContext.lookup(Registries.BIOME);
        pContext.register(IcariaLevelStems.ICARIA, new LevelStem(pContext.lookup(Registries.DIMENSION_TYPE).getOrThrow(IcariaDimensionTypes.ICARIA), new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(IcariaLevelStems.forestParameters(biomes), IcariaLevelStems.forestPlateauParameters(biomes), IcariaLevelStems.scrublandParameters(biomes), IcariaLevelStems.scrublandPlateauParameters(biomes), IcariaLevelStems.steppeParameters(biomes), IcariaLevelStems.steppePlateauParameters(biomes), IcariaLevelStems.desertParameters(biomes), IcariaLevelStems.desertPlateauParameters(biomes), IcariaLevelStems.voidParameters(biomes)))), pContext.lookup(Registries.NOISE_SETTINGS).getOrThrow(IcariaNoiseSettings.ICARIA))));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> forestParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.FOREST));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> forestPlateauParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_COLD, IcariaLevelStems.ZERO, IcariaLevelStems.PLATEAU, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.FOREST_PLATEAU));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> scrublandParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.COLD, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.SCRUBLAND));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> scrublandPlateauParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.COLD, IcariaLevelStems.ZERO, IcariaLevelStems.PLATEAU, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.SCRUBLAND_PLATEAU));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> steppeParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.STEPPE));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> steppePlateauParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.WARM, IcariaLevelStems.ZERO, IcariaLevelStems.PLATEAU, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.STEPPE_PLATEAU));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> desertParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_WARM, IcariaLevelStems.ZERO, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.DESERT));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> desertPlateauParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_WARM, IcariaLevelStems.ZERO, IcariaLevelStems.PLATEAU, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.DESERT_PLATEAU));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> voidParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.FULL, IcariaLevelStems.ZERO, IcariaLevelStems.VOID, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.VOID));
    }
}
