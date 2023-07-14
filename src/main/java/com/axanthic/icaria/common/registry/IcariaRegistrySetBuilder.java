package com.axanthic.icaria.common.registry;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import net.minecraftforge.registries.ForgeRegistries;

public class IcariaRegistrySetBuilder extends RegistrySetBuilder {
    public IcariaRegistrySetBuilder() {
        this.add(ForgeRegistries.Keys.BIOME_MODIFIERS, IcariaBiomeModifiers::bootstrap).add(Registries.BIOME, IcariaBiomes::bootstrap).add(Registries.CONFIGURED_CARVER, IcariaConfiguredCarvers::bootstrap).add(Registries.CONFIGURED_FEATURE, IcariaConfiguredFeatures::bootstrap).add(Registries.DIMENSION_TYPE, IcariaDimensionTypes::bootstrap).add(Registries.LEVEL_STEM, IcariaLevelStems::bootstrap).add(Registries.NOISE_SETTINGS, IcariaNoiseSettings::bootstrap).add(Registries.PLACED_FEATURE, IcariaPlacedFeatures::bootstrap);
    }
}
