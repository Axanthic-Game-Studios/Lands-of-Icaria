package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.properties.Carpet;
import com.axanthic.icaria.common.registry.IcariaIdents;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEquipmentAssets {
	public static final ResourceKey<EquipmentAsset> AETERNAE_HIDE = IcariaEquipmentAssets.createKey("aeternae_hide");
	public static final ResourceKey<EquipmentAsset> CHALKOS = IcariaEquipmentAssets.createKey("chalkos");
	public static final ResourceKey<EquipmentAsset> KASSITEROS = IcariaEquipmentAssets.createKey("kassiteros");
	public static final ResourceKey<EquipmentAsset> ORICHALCUM = IcariaEquipmentAssets.createKey("orichalcum");
	public static final ResourceKey<EquipmentAsset> VANADIUMSTEEL = IcariaEquipmentAssets.createKey("vanadiumsteel");
	public static final ResourceKey<EquipmentAsset> LAUREL = IcariaEquipmentAssets.createKey("laurel");

	public static final Map<Carpet, ResourceKey<EquipmentAsset>> CARPET = Util.makeEnumMap(Carpet.class, carpet -> IcariaEquipmentAssets.createKey(carpet.getSerializedName()));

	public static ResourceKey<EquipmentAsset> createKey(String pName) {
		return ResourceKey.create(IcariaRegistries.EQUIPMENT_ASSET, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
