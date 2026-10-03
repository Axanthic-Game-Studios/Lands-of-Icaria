package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;
import com.axanthic.icaria.common.variant.FeeshVariant;
import com.axanthic.icaria.common.variant.FicheVariant;
import com.axanthic.icaria.common.variant.FisshhVariant;
import com.axanthic.icaria.common.variant.FyshVariant;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRegistryIds {
	public static final ResourceKey<Registry<EquipmentAsset>> EQUIPMENT_ASSET = IcariaRegistryIds.create("equipment_asset");
	public static final ResourceKey<Registry<FeeshVariant>> FEESH_VARIANT = IcariaRegistryIds.create("feesh_variant");
	public static final ResourceKey<Registry<FicheVariant>> FICHE_VARIANT = IcariaRegistryIds.create("fiche_variant");
	public static final ResourceKey<Registry<FisshhVariant>> FISSHH_VARIANT = IcariaRegistryIds.create("fisshh_variant");
	public static final ResourceKey<Registry<FyshVariant>> FYSH_VARIANT = IcariaRegistryIds.create("fysh_variant");

	public static <T> ResourceKey<Registry<T>> create(String pName) {
		return ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath(IcariaIds.MC, pName));
	}
}
