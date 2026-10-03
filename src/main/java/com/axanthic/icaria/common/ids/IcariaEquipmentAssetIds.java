package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEquipmentAssetIds {
	public static final ResourceKey<EquipmentAsset> AETERNAE_HIDE = IcariaEquipmentAssetIds.create("aeternae_hide");
	public static final ResourceKey<EquipmentAsset> CHALKOS = IcariaEquipmentAssetIds.create("chalkos");
	public static final ResourceKey<EquipmentAsset> KASSITEROS = IcariaEquipmentAssetIds.create("kassiteros");
	public static final ResourceKey<EquipmentAsset> ORICHALCUM = IcariaEquipmentAssetIds.create("orichalcum");
	public static final ResourceKey<EquipmentAsset> VANADIUMSTEEL = IcariaEquipmentAssetIds.create("vanadiumsteel");
	public static final ResourceKey<EquipmentAsset> LAUREL = IcariaEquipmentAssetIds.create("laurel");

	public static final ResourceKey<EquipmentAsset> ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> WHITE_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("white_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> LIGHT_GRAY_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("light_gray_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> GRAY_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("gray_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> BLACK_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("black_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> BROWN_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("brown_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> RED_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("red_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> ORANGE_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("orange_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> YELLOW_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("yellow_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> LIME_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("lime_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> GREEN_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("green_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> CYAN_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("cyan_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> LIGHT_BLUE_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("light_blue_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> BLUE_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("blue_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> PURPLE_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("purple_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> MAGENTA_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("magenta_arachne_string_carpet");
	public static final ResourceKey<EquipmentAsset> PINK_ARACHNE_STRING_CARPET = IcariaEquipmentAssetIds.create("pink_arachne_string_carpet");

	public static ResourceKey<EquipmentAsset> create(String pName) {
		return ResourceKey.create(IcariaRegistryIds.EQUIPMENT_ASSET, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
