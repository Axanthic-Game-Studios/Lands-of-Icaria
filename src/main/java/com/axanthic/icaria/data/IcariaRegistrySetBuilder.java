package com.axanthic.icaria.data;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaRegistryIds;
import com.axanthic.icaria.data.registry.*;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.NeoForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRegistrySetBuilder extends RegistrySetBuilder {
	public IcariaRegistrySetBuilder() {
		this.add(Registries.BIOME, IcariaBiomes::bootstrap);
		this.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, IcariaBiomeModifiers::bootstrap);
		this.add(Registries.CONFIGURED_FEATURE, IcariaConfiguredFeatures::bootstrap);
		this.add(Registries.DIMENSION_TYPE, IcariaDimensionTypes::bootstrap);
		this.add(IcariaRegistryIds.FEESH_VARIANT, IcariaFeeshVariants::bootstrap);
		this.add(IcariaRegistryIds.FICHE_VARIANT, IcariaFicheVariants::bootstrap);
		this.add(IcariaRegistryIds.FISSHH_VARIANT, IcariaFisshhVariants::bootstrap);
		this.add(IcariaRegistryIds.FYSH_VARIANT, IcariaFyshVariants::bootstrap);
		this.add(Registries.INSTRUMENT, IcariaInstruments::bootstrap);
		this.add(Registries.LEVEL_STEM, IcariaLevelStems::bootstrap);
		this.add(Registries.NOISE_SETTINGS, IcariaNoiseSettings::bootstrap);
		this.add(Registries.PAINTING_VARIANT, IcariaPaintingVariants::bootstrap);
		this.add(Registries.PLACED_FEATURE, IcariaPlacedFeatures::bootstrap);
		this.add(Registries.PROCESSOR_LIST, IcariaProcessorLists::bootstrap);
		this.add(Registries.STRUCTURE, IcariaStructures::bootstrap);
		this.add(Registries.STRUCTURE_SET, IcariaStructureSets::bootstrap);
		this.add(Registries.TEMPLATE_POOL, IcariaTemplatePools::bootstrap);
	}
}
