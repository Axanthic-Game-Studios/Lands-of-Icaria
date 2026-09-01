package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.variant.FeeshVariant;
import com.axanthic.icaria.common.variant.FicheVariant;
import com.axanthic.icaria.common.variant.FisshhVariant;
import com.axanthic.icaria.common.variant.FyshVariant;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRegistries {
	public static final ResourceKey<Registry<EquipmentAsset>> EQUIPMENT_ASSET = ResourceKey.createRegistryKey(IcariaIdentifiers.EQUIPMENT_ASSET_REGISTRY_KEY);
	public static final ResourceKey<Registry<FeeshVariant>> FEESH_VARIANT = ResourceKey.createRegistryKey(IcariaIdentifiers.FEESH_VARIANT_REGISTRY_KEY);
	public static final ResourceKey<Registry<FicheVariant>> FICHE_VARIANT = ResourceKey.createRegistryKey(IcariaIdentifiers.FICHE_VARIANT_REGISTRY_KEY);
	public static final ResourceKey<Registry<FisshhVariant>> FISSHH_VARIANT = ResourceKey.createRegistryKey(IcariaIdentifiers.FISSHH_VARIANT_REGISTRY_KEY);
	public static final ResourceKey<Registry<FyshVariant>> FYSH_VARIANT = ResourceKey.createRegistryKey(IcariaIdentifiers.FYSH_VARIANT_REGISTRY_KEY);
}
