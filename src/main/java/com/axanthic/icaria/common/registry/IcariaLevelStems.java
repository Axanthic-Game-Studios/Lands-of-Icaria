package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.gen.IcariaChunkGenerator;

import com.mojang.datafixers.util.Pair;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.LevelStem;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLevelStems {
    public static final Climate.Parameter FULL = Climate.Parameter.span(-1.0F, 1.0F);

    public static final Climate.Parameter VERY_COLD = Climate.Parameter.span(-1.0F, -0.25F);
    public static final Climate.Parameter COLD = Climate.Parameter.span(-0.25F, 0.0F);
    public static final Climate.Parameter WARM = Climate.Parameter.span(0.0F, 0.25F);
    public static final Climate.Parameter VERY_WARM = Climate.Parameter.span(0.25F, 1.0F);

    public static final Climate.Parameter VERY_DAMP = Climate.Parameter.span(-1.0F, -0.25F);
    public static final Climate.Parameter DAMP = Climate.Parameter.span(-0.25F, 0.0F);
    public static final Climate.Parameter ARID = Climate.Parameter.span(0.0F, 0.25F);
    public static final Climate.Parameter VERY_ARID = Climate.Parameter.span(0.25F, 1.0F);

    public static final Climate.Parameter LAND = Climate.Parameter.span(0.0F, 1.0F);
    public static final Climate.Parameter VOID = Climate.Parameter.span(-1.0F, 0.0F);

    public static final Climate.Parameter ZERO = Climate.Parameter.point(0.0F);

    public static final ResourceKey<LevelStem> ICARIA = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(IcariaInfo.ID, "icaria"));

    public static void bootstrap(BootstapContext<LevelStem> pContext) {
        var biomes = pContext.lookup(Registries.BIOME);
        pContext.register(IcariaLevelStems.ICARIA, new LevelStem(pContext.lookup(Registries.DIMENSION_TYPE).getOrThrow(IcariaDimensionTypes.ICARIA), new IcariaChunkGenerator(MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(List.of(IcariaLevelStems.forestParameters(biomes), IcariaLevelStems.scrublandParameters(biomes), IcariaLevelStems.steppeParameters(biomes), IcariaLevelStems.desertParameters(biomes), IcariaLevelStems.voidParameters(biomes)))), pContext.lookup(Registries.NOISE_SETTINGS).getOrThrow(IcariaNoiseSettings.ICARIA))));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> forestParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_COLD, IcariaLevelStems.VERY_ARID, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.FOREST));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> scrublandParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.COLD, IcariaLevelStems.ARID, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.SCRUBLAND));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> steppeParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.WARM, IcariaLevelStems.DAMP, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.STEPPE));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> desertParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.VERY_WARM, IcariaLevelStems.VERY_DAMP, IcariaLevelStems.LAND, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.DESERT));
    }

    public static Pair<Climate.ParameterPoint, Holder<Biome>> voidParameters(HolderGetter<Biome> pBiomes) {
        return new Pair<>(new Climate.ParameterPoint(IcariaLevelStems.FULL, IcariaLevelStems.FULL, IcariaLevelStems.VOID, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, IcariaLevelStems.ZERO, 0L), pBiomes.getOrThrow(IcariaBiomes.VOID));
    }
}
