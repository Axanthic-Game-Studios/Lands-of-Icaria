package com.axanthic.icaria.common.registry;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import net.minecraftforge.registries.ForgeRegistries;

public class IcariaRegistrySetBuilder extends RegistrySetBuilder {
    public IcariaRegistrySetBuilder() {
        this.add(ForgeRegistries.Keys.BIOME_MODIFIERS, IcariaBiomeModifier::bootstrap).add(Registries.BIOME, IcariaBiomes::bootstrapBiomes).add(Registries.CONFIGURED_CARVER, IcariaCarvers::bootstrap).add(Registries.CONFIGURED_FEATURE, IcariaConfiguredFeatures::bootstrapConfiguredFeatures).add(Registries.DIMENSION_TYPE, IcariaDimensions::bootstrapType).add(Registries.LEVEL_STEM, IcariaDimensions::bootstrapDimension).add(Registries.NOISE_SETTINGS, IcariaDimensions::bootstrapNoiseSettings).add(Registries.PLACED_FEATURE, IcariaPlacedFeatures::bootstrapPlacedFeatures);
    }
}
