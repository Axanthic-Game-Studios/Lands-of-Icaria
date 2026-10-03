package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaNoiseSettingIds {
	public static final ResourceKey<NoiseGeneratorSettings> ICARIA = IcariaNoiseSettingIds.create("icaria");

	public static ResourceKey<NoiseGeneratorSettings> create(String pName) {
		return ResourceKey.create(Registries.NOISE_SETTINGS, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
