package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaNoiseSettings {
	public static final Climate.Parameter ZERO = Climate.Parameter.point(0.0F);

	public static final ResourceKey<NoiseGeneratorSettings> ICARIA = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(IcariaInfo.ID, "icaria"));

	public static void bootstrap(BootstapContext<NoiseGeneratorSettings> pContext) {
		pContext.register(IcariaNoiseSettings.ICARIA, new NoiseGeneratorSettings(new NoiseSettings(0, 96, 1, 1), Blocks.STONE.defaultBlockState(), Blocks.AIR.defaultBlockState(), IcariaNoiseSettings.noiseRouter(pContext), IcariaNoiseSettings.surfaceRules(), List.of(new Climate.ParameterPoint(Climate.Parameter.span(-1.0F, 1.0F), IcariaNoiseSettings.ZERO, Climate.Parameter.point(1.0F), IcariaNoiseSettings.ZERO, IcariaNoiseSettings.ZERO, IcariaNoiseSettings.ZERO, 0L)), -1, false, false, false, false));
	}

	public static NoiseRouter noiseRouter(BootstapContext<NoiseGeneratorSettings> pContext) {
		var noises = pContext.lookup(Registries.NOISE);
		var densityFunctionA = DensityFunctions.noise(noises.getOrThrow(Noises.TEMPERATURE), 1.0D, 0.0D);
		var densityFunctionB = DensityFunctions.noise(noises.getOrThrow(Noises.CONTINENTALNESS), 3.0D, 1.5D);
		var densityFunctionC = DensityFunctions.noise(noises.getOrThrow(Noises.CONTINENTALNESS), 3.0D, 1.5D);
		var densityFunctionD = DensityFunctions.yClampedGradient(0, 12, -1.0D, 0.0D);
		var densityFunctionE = DensityFunctions.add(densityFunctionD, densityFunctionC);
		var densityFunctionF = DensityFunctions.yClampedGradient(12, 24, 0.0D, -0.5D);
		var densityFunctionG = DensityFunctions.add(densityFunctionF, densityFunctionE);
		var densityFunctionH = DensityFunctions.yClampedGradient(24, 36, 0.0D, 0.5D);
		var densityFunctionI = DensityFunctions.add(densityFunctionH, densityFunctionG);
		var densityFunctionJ = DensityFunctions.yClampedGradient(36, 48, 0.0D, -0.5D);
		var densityFunctionK = DensityFunctions.add(densityFunctionJ, densityFunctionI);
		var densityFunctionL = DensityFunctions.yClampedGradient(48, 60, 0.0D, 0.5D);
		var densityFunctionM = DensityFunctions.add(densityFunctionL, densityFunctionK);
		var densityFunctionN = DensityFunctions.yClampedGradient(60, 72, 0.0D, -0.5D);
		var densityFunctionO = DensityFunctions.add(densityFunctionN, densityFunctionM);
		var densityFunctionP = DensityFunctions.yClampedGradient(72, 84, 0.0D, 0.5D);
		var densityFunctionQ = DensityFunctions.add(densityFunctionP, densityFunctionO);
		var densityFunctionR = DensityFunctions.yClampedGradient(84, 96, 0.0D, -1.0D);
		var densityFunctionS = DensityFunctions.add(densityFunctionR, densityFunctionQ);
		return new NoiseRouter(DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), densityFunctionA, DensityFunctions.zero(), densityFunctionB, DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero(), densityFunctionS, DensityFunctions.zero(), DensityFunctions.zero(), DensityFunctions.zero());
	}

	public static SurfaceRules.RuleSource surfaceRules() {
		var surfaceRuleA = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(IcariaBiomes.FOREST, IcariaBiomes.FOREST_PLATEAU), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, 0.5D, 2.0D), SurfaceRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -2.0D, 0.5D), SurfaceRules.state(IcariaBlocks.GRASSY_MARL.get().defaultBlockState())))));
		var surfaceRuleB = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(IcariaBiomes.FOREST, IcariaBiomes.FOREST_PLATEAU), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, 0.5D, 2.0D), SurfaceRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -2.0D, 0.5D), SurfaceRules.state(IcariaBlocks.MARL.get().defaultBlockState())))));
		var surfaceRuleC = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(IcariaBiomes.SCRUBLAND, IcariaBiomes.SCRUBLAND_PLATEAU, IcariaBiomes.STEPPE, IcariaBiomes.STEPPE_PLATEAU), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, 0.2D, 2.0D), SurfaceRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.2D, 0.2D), SurfaceRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -2.0D, -0.2D), SurfaceRules.state(IcariaBlocks.GRASSY_MARL.get().defaultBlockState())))));
		var surfaceRuleD = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(IcariaBiomes.SCRUBLAND, IcariaBiomes.SCRUBLAND_PLATEAU, IcariaBiomes.STEPPE, IcariaBiomes.STEPPE_PLATEAU), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, 0.2D, 2.0D), SurfaceRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.2D, 0.2D), SurfaceRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -2.0D, -0.2D), SurfaceRules.state(IcariaBlocks.MARL.get().defaultBlockState())))));
		var surfaceRuleE = SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(SurfaceRules.isBiome(IcariaBiomes.DESERT, IcariaBiomes.DESERT_PLATEAU), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, 0.2D, 2.0D), SurfaceRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -0.2D, 0.2D), SurfaceRules.state(IcariaBlocks.SILKSAND.get().defaultBlockState())), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SURFACE, -2.0D, -0.2D), SurfaceRules.state(IcariaBlocks.GRAINEL.get().defaultBlockState())))));
		var surfaceRuleF = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 0), SurfaceRules.ifTrue(SurfaceRules.isBiome(IcariaBiomes.VOID), SurfaceRules.state(Blocks.AIR.defaultBlockState())));
		var surfaceRuleG = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(64), 2), SurfaceRules.state(IcariaBlocks.YELLOWSTONE.get().defaultBlockState()));
		var surfaceRuleH = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(48), 2), SurfaceRules.state(IcariaBlocks.SILKSTONE.get().defaultBlockState()));
		var surfaceRuleI = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(32), 2), SurfaceRules.state(IcariaBlocks.SUNSTONE.get().defaultBlockState()));
		var surfaceRuleJ = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(16), 2), SurfaceRules.state(IcariaBlocks.VOIDSHALE.get().defaultBlockState()));
		var surfaceRuleK = SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(0), 0), SurfaceRules.state(IcariaBlocks.BAETYL.get().defaultBlockState()));
		return SurfaceRules.sequence(surfaceRuleA, surfaceRuleB, surfaceRuleC, surfaceRuleD, surfaceRuleE, surfaceRuleF, surfaceRuleG, surfaceRuleH, surfaceRuleI, surfaceRuleJ, surfaceRuleK);
	}
}
