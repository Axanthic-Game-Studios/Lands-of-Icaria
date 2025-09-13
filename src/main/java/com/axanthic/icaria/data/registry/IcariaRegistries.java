package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.variant.FeeshVariant;
import com.axanthic.icaria.common.variant.FicheVariant;
import com.axanthic.icaria.common.variant.FisshhVariant;
import com.axanthic.icaria.common.variant.FyshVariant;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRegistries {
	public static final ResourceKey<Registry<EquipmentAsset>> EQUIPMENT_ASSET = ResourceKey.createRegistryKey(IcariaResourceLocations.EQUIPMENT_ASSET_REGISTRY_KEY);
	public static final ResourceKey<Registry<FeeshVariant>> FEESH_VARIANT = ResourceKey.createRegistryKey(IcariaResourceLocations.FEESH_VARIANT_REGISTRY_KEY);
	public static final ResourceKey<Registry<FicheVariant>> FICHE_VARIANT = ResourceKey.createRegistryKey(IcariaResourceLocations.FICHE_VARIANT_REGISTRY_KEY);
	public static final ResourceKey<Registry<FisshhVariant>> FISSHH_VARIANT = ResourceKey.createRegistryKey(IcariaResourceLocations.FISSHH_VARIANT_REGISTRY_KEY);
	public static final ResourceKey<Registry<FyshVariant>> FYSH_VARIANT = ResourceKey.createRegistryKey(IcariaResourceLocations.FYSH_VARIANT_REGISTRY_KEY);
}
