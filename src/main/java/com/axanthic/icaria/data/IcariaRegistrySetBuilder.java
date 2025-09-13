package com.axanthic.icaria.data;

import com.axanthic.icaria.data.registry.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.NeoForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRegistrySetBuilder extends RegistrySetBuilder {
	public IcariaRegistrySetBuilder() {
		this.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, IcariaBiomeModifiers::bootstrap).add(Registries.BIOME, IcariaBiomes::bootstrap).add(Registries.CONFIGURED_FEATURE, IcariaConfiguredFeatures::bootstrap).add(Registries.DIMENSION_TYPE, IcariaDimensionTypes::bootstrap).add(IcariaRegistries.FEESH_VARIANT, IcariaFeeshVariants::bootstrap).add(IcariaRegistries.FICHE_VARIANT, IcariaFicheVariants::bootstrap).add(IcariaRegistries.FISSHH_VARIANT, IcariaFisshhVariants::bootstrap).add(IcariaRegistries.FYSH_VARIANT, IcariaFyshVariants::bootstrap).add(Registries.INSTRUMENT, IcariaInstruments::bootstrap).add(Registries.LEVEL_STEM, IcariaLevelStems::bootstrap).add(Registries.NOISE_SETTINGS, IcariaNoiseSettings::bootstrap).add(Registries.PAINTING_VARIANT, IcariaPaintingVariants::bootstrap).add(Registries.PLACED_FEATURE, IcariaPlacedFeatures::bootstrap).add(Registries.PROCESSOR_LIST, IcariaProcessorLists::bootstrap).add(Registries.STRUCTURE, IcariaStructures::bootstrap).add(Registries.STRUCTURE_SET, IcariaStructureSets::bootstrap).add(Registries.TEMPLATE_POOL, IcariaTemplatePools::bootstrap);
	}
}
