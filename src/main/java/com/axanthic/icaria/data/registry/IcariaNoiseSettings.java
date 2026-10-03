package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaBiomeIds;
import com.axanthic.icaria.common.ids.IcariaNoiseSettingIds;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaNoiseSettings {
	public static final Climate.Parameter NIL = Climate.Parameter.point(0.0F);
	public static final Climate.Parameter ONE = Climate.Parameter.point(1.0F);

	public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> pBootstrapContext) {
		pBootstrapContext.register(IcariaNoiseSettingIds.ICARIA, new NoiseGeneratorSettings(new NoiseSettings(0, 96, 1, 1), Blocks.STONE.defaultBlockState(), Blocks.AIR.defaultBlockState(), IcariaNoiseSettings.noiseRouter(pBootstrapContext), IcariaNoiseSettings.ruleSource(pBootstrapContext), List.of(new Climate.ParameterPoint(Climate.Parameter.span(-1.0F, 1.0F), IcariaNoiseSettings.NIL, IcariaNoiseSettings.ONE, IcariaNoiseSettings.NIL, IcariaNoiseSettings.ONE, IcariaNoiseSettings.NIL, 0L)), -1, false, false, false, false));
	}

	public static NoiseRouter noiseRouter(BootstrapContext<NoiseGeneratorSettings> pBootstrapContext) {
		var noises = pBootstrapContext.lookup(Registries.NOISE);
		var densityFunctionA = DensityFunctions.noise(noises.getOrThrow(Noises.TEMPERATURE), 1.0D, 0.0D);
		var densityFunctionB = DensityFunctions.noise(noises.getOrThrow(Noises.CONTINENTALNESS), 3.0D, 1.5D);
		var densityFunctionC = DensityFunctions.yClampedGradient(0, 12, -1.0D, 0.0D);
		var densityFunctionD = DensityFunctions.add(densityFunctionC, densityFunctionB);
		var densityFunctionE = DensityFunctions.yClampedGradient(12, 24, 0.0D, -0.5D);
		var densityFunctionF = DensityFunctions.add(densityFunctionE, densityFunctionD);
		var densityFunctionG = DensityFunctions.yClampedGradient(24, 36, 0.0D, 0.5D);
		var densityFunctionH = DensityFunctions.add(densityFunctionG, densityFunctionF);
		var densityFunctionI = DensityFunctions.yClampedGradient(36, 48, 0.0D, -0.5D);
		var densityFunctionJ = DensityFunctions.add(densityFunctionI, densityFunctionH);
		var densityFunctionK = DensityFunctions.yClampedGradient(48, 60, 0.0D, 0.5D);
		var densityFunctionL = DensityFunctions.add(densityFunctionK, densityFunctionJ);
		var densityFunctionM = DensityFunctions.yClampedGradient(60, 72, 0.0D, -0.5D);
		var densityFunctionN = DensityFunctions.add(densityFunctionM, densityFunctionL);
		var densityFunctionO = DensityFunctions.yClampedGradient(72, 84, 0.0D, 0.5D);
		var densityFunctionP = DensityFunctions.add(densityFunctionO, densityFunctionN);
		var densityFunctionQ = DensityFunctions.yClampedGradient(84, 96, 0.0D, -1.0D);
		var densityFunctionR = DensityFunctions.add(densityFunctionQ, densityFunctionP);
		var densityFunctionS = DensityFunctions.yClampedGradient(0, 96, -1.0D, 1.0D);
		return new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), densityFunctionA, DensityFunctions.zero(), densityFunctionB, DensityFunctions.zero(), densityFunctionS, DensityFunctions.zero(), DensityFunctions.zero(), densityFunctionR, DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
	}

	public static SurfaceRules.RuleSource ruleSource(BootstrapContext<NoiseGeneratorSettings> pBootstrapContext) {
		var biomes = pBootstrapContext.lookup(Registries.BIOME);
		var ruleSourceA = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(biomes, IcariaBiomeIds.FOREST, IcariaBiomeIds.LUSH_FOREST, IcariaBiomeIds.LOST_FOREST, IcariaBiomeIds.DEEP_FOREST), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, 0.5D, 2.0D), SurfaceRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -2.0D, 0.5D), SurfaceRules.state(IcariaBlocks.GRASSY_MARL.get().defaultBlockState())))));
		var ruleSourceB = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(biomes, IcariaBiomeIds.FOREST, IcariaBiomeIds.LUSH_FOREST, IcariaBiomeIds.LOST_FOREST, IcariaBiomeIds.DEEP_FOREST), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, 0.5D, 2.0D), SurfaceRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -2.0D, 0.5D), SurfaceRules.state(IcariaBlocks.MARL.get().defaultBlockState())))));
		var ruleSourceC = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(biomes, IcariaBiomeIds.SCRUBLAND, IcariaBiomeIds.LUSH_SCRUBLAND, IcariaBiomeIds.LOST_SCRUBLAND, IcariaBiomeIds.DEEP_SCRUBLAND, IcariaBiomeIds.STEPPE, IcariaBiomeIds.LUSH_STEPPE, IcariaBiomeIds.LOST_STEPPE, IcariaBiomeIds.DEEP_STEPPE), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, 0.2D, 2.0D), SurfaceRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -0.2D, 0.2D), SurfaceRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -2.0D, -0.2D), SurfaceRules.state(IcariaBlocks.GRASSY_MARL.get().defaultBlockState())))));
		var ruleSourceD = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(biomes, IcariaBiomeIds.SCRUBLAND, IcariaBiomeIds.LUSH_SCRUBLAND, IcariaBiomeIds.LOST_SCRUBLAND, IcariaBiomeIds.DEEP_SCRUBLAND, IcariaBiomeIds.STEPPE, IcariaBiomeIds.LUSH_STEPPE, IcariaBiomeIds.LOST_STEPPE, IcariaBiomeIds.DEEP_STEPPE), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, 0.2D, 2.0D), SurfaceRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -0.2D, 0.2D), SurfaceRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -2.0D, -0.2D), SurfaceRules.state(IcariaBlocks.MARL.get().defaultBlockState())))));
		var ruleSourceE = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(biomes, IcariaBiomeIds.DESERT, IcariaBiomeIds.LUSH_DESERT, IcariaBiomeIds.LOST_DESERT, IcariaBiomeIds.DEEP_DESERT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, 0.2D, 2.0D), SurfaceRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -0.2D, 0.2D), SurfaceRules.state(IcariaBlocks.SILKSAND.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition2d(Noises.SURFACE, -2.0D, -0.2D), SurfaceRules.state(IcariaBlocks.GRAINEL.get().defaultBlockState())))));
		var ruleSourceF = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 0), SurfaceRules.ifTrue(SurfaceRules.isBiome(biomes, IcariaBiomeIds.VOID), SurfaceRules.state(Blocks.AIR.defaultBlockState())));
		var ruleSourceG = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(64), 2), SurfaceRules.state(IcariaBlocks.YELLOWSTONE.get().defaultBlockState()));
		var ruleSourceH = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(48), 2), SurfaceRules.state(IcariaBlocks.SILKSTONE.get().defaultBlockState()));
		var ruleSourceI = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(32), 2), SurfaceRules.state(IcariaBlocks.SUNSTONE.get().defaultBlockState()));
		var ruleSourceJ = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(16), 2), SurfaceRules.state(IcariaBlocks.VOIDSHALE.get().defaultBlockState()));
		var ruleSourceK = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 0), SurfaceRules.state(IcariaBlocks.BAETYL.get().defaultBlockState()));
		return SurfaceRules.sequence(ruleSourceA, ruleSourceB, ruleSourceC, ruleSourceD, ruleSourceE, ruleSourceF, ruleSourceG, ruleSourceH, ruleSourceI, ruleSourceJ, ruleSourceK);
	}
}
