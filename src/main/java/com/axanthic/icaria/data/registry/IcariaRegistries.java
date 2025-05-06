package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRegistries {
	public static final ResourceKey<Registry<EquipmentAsset>> EQUIPMENT_ASSET = ResourceKey.createRegistryKey(IcariaResourceLocations.EQUIPMENT_ASSET_REGISTRY_KEY);
}
