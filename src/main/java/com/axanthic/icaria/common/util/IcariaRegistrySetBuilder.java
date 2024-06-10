package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.registry.*;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class IcariaRegistrySetBuilder extends RegistrySetBuilder {
    public IcariaRegistrySetBuilder() {
        this.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, IcariaBiomeModifiers::bootstrap).add(Registries.BIOME, IcariaBiomes::bootstrap).add(Registries.CONFIGURED_FEATURE, IcariaConfiguredFeatures::bootstrap).add(Registries.DIMENSION_TYPE, IcariaDimensionTypes::bootstrap).add(Registries.LEVEL_STEM, IcariaLevelStems::bootstrap).add(Registries.NOISE_SETTINGS, IcariaNoiseSettings::bootstrap).add(Registries.PLACED_FEATURE, IcariaPlacedFeatures::bootstrap).add(Registries.PROCESSOR_LIST, IcariaProcessorLists::bootstrap).add(Registries.STRUCTURE, IcariaStructures::bootstrap).add(Registries.STRUCTURE_SET, IcariaStructureSets::bootstrap).add(Registries.TEMPLATE_POOL, IcariaTemplatePools::bootstrap);
    }
}
