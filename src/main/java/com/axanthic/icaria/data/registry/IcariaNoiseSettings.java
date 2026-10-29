package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaMaterialRuleIds;
import com.axanthic.icaria.common.ids.IcariaNoiseSettingIds;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.densityfunction.DensityFunctions;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaNoiseSettings {
	public static final Climate.Parameter NIL = Climate.Parameter.point(0.0F);
	public static final Climate.Parameter ONE = Climate.Parameter.point(1.0F);

	public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> pBootstrapContext) {
		var densityFunctions = pBootstrapContext.lookup(Registries.DENSITY_FUNCTION);
		var materialRules = pBootstrapContext.lookup(Registries.MATERIAL_RULE);

		var overworldFunctionSet = NoiseRouterData.OVERWORLD_FUNCTIONS.map(densityFunctions::getOrThrow);

		pBootstrapContext.register(IcariaNoiseSettingIds.ICARIA, new NoiseGeneratorSettings(new NoiseSettings(0, 96), Blocks.STONE.defaultBlockState(), Blocks.AIR.defaultBlockState(), IcariaNoiseSettings.noiseRouter(pBootstrapContext), materialRules.getOrThrow(IcariaMaterialRuleIds.ICARIA), List.of(new SpawnTargetPoint(Map.of(overworldFunctionSet.temperature(), Climate.Parameter.span(-1.0F, 1.0F), overworldFunctionSet.vegetation(), IcariaNoiseSettings.NIL, overworldFunctionSet.continents(), IcariaNoiseSettings.ONE, overworldFunctionSet.erosion(), IcariaNoiseSettings.NIL, overworldFunctionSet.depth(), IcariaNoiseSettings.ONE, densityFunctions.getOrThrow(NoiseRouterData.RIDGES), IcariaNoiseSettings.NIL))), -1, false, Optional.empty(), false, new NoiseGeneratorSettings.DebugFunctions(List.of())));
	}

	public static NoiseRouter noiseRouter(BootstrapContext<NoiseGeneratorSettings> pBootstrapContext) {
		var noises = pBootstrapContext.lookup(Registries.NOISE);
		var densityFunctionA = DensityFunctions.noise(noises.getOrThrow(Noises.TEMPERATURE), 1.0D, 0.0D);
		var densityFunctionB = DensityFunctions.noise(noises.getOrThrow(Noises.CONTINENTALNESS), 3.0D, 1.5D);
		var densityFunctionC = DensityFunctions.yClampedGradient(0, 12, -1.0F, 0.0F);
		var densityFunctionD = DensityFunctions.add(densityFunctionC, densityFunctionB);
		var densityFunctionE = DensityFunctions.yClampedGradient(12, 24, 0.0F, -0.5F);
		var densityFunctionF = DensityFunctions.add(densityFunctionE, densityFunctionD);
		var densityFunctionG = DensityFunctions.yClampedGradient(24, 36, 0.0F, 0.5F);
		var densityFunctionH = DensityFunctions.add(densityFunctionG, densityFunctionF);
		var densityFunctionI = DensityFunctions.yClampedGradient(36, 48, 0.0F, -0.5F);
		var densityFunctionJ = DensityFunctions.add(densityFunctionI, densityFunctionH);
		var densityFunctionK = DensityFunctions.yClampedGradient(48, 60, 0.0F, 0.5F);
		var densityFunctionL = DensityFunctions.add(densityFunctionK, densityFunctionJ);
		var densityFunctionM = DensityFunctions.yClampedGradient(60, 72, 0.0F, -0.5F);
		var densityFunctionN = DensityFunctions.add(densityFunctionM, densityFunctionL);
		var densityFunctionO = DensityFunctions.yClampedGradient(72, 84, 0.0F, 0.5F);
		var densityFunctionP = DensityFunctions.add(densityFunctionO, densityFunctionN);
		var densityFunctionQ = DensityFunctions.yClampedGradient(84, 96, 0.0F, -1.0F);
		var densityFunctionR = DensityFunctions.add(densityFunctionQ, densityFunctionP);
		var densityFunctionS = DensityFunctions.yClampedGradient(0, 96, -1.0F, 1.0F);
		return new NoiseRouter(densityFunctionA, DensityFunctions.zero(), densityFunctionB, DensityFunctions.zero(), densityFunctionS, DensityFunctions.zero(), DensityFunctions.zero(), densityFunctionR);
	}
}
