package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseSettings;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaNoiseSettings {
	public static final ResourceKey<NoiseGeneratorSettings> ICARIA = ResourceKey.create(Registries.NOISE_SETTINGS, new ResourceLocation(IcariaInfo.ID, "icaria"));

	public static void bootstrap(BootstapContext<NoiseGeneratorSettings> pContext) {
		var full = Climate.Parameter.span(-1.0F, 1.0F);
		var zero = Climate.Parameter.point(0.0F);
		pContext.register(IcariaNoiseSettings.ICARIA, new NoiseGeneratorSettings(new NoiseSettings(-64, 384, 1, 2), IcariaBlocks.YELLOWSTONE.get().defaultBlockState(), Blocks.AIR.defaultBlockState(), NoiseGeneratorSettings.overworld(pContext, false, false).noiseRouter(), SurfaceRuleData.air(), List.of(new Climate.ParameterPoint(full, full, full, zero, zero, zero, 0L)), 63, false, false, false, false));
	}
}
