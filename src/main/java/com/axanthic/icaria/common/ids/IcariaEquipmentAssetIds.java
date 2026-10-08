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
	public static final ResourceKey<EquipmentAsset> TERRY_MAT = IcariaEquipmentAssetIds.create("terry_mat");
	public static final ResourceKey<EquipmentAsset> WHITE_TERRY_MAT = IcariaEquipmentAssetIds.create("white_terry_mat");
	public static final ResourceKey<EquipmentAsset> LIGHT_GRAY_TERRY_MAT = IcariaEquipmentAssetIds.create("light_gray_terry_mat");
	public static final ResourceKey<EquipmentAsset> GRAY_TERRY_MAT = IcariaEquipmentAssetIds.create("gray_terry_mat");
	public static final ResourceKey<EquipmentAsset> BLACK_TERRY_MAT = IcariaEquipmentAssetIds.create("black_terry_mat");
	public static final ResourceKey<EquipmentAsset> BROWN_TERRY_MAT = IcariaEquipmentAssetIds.create("brown_terry_mat");
	public static final ResourceKey<EquipmentAsset> RED_TERRY_MAT = IcariaEquipmentAssetIds.create("red_terry_mat");
	public static final ResourceKey<EquipmentAsset> ORANGE_TERRY_MAT = IcariaEquipmentAssetIds.create("orange_terry_mat");
	public static final ResourceKey<EquipmentAsset> YELLOW_TERRY_MAT = IcariaEquipmentAssetIds.create("yellow_terry_mat");
	public static final ResourceKey<EquipmentAsset> LIME_TERRY_MAT = IcariaEquipmentAssetIds.create("lime_terry_mat");
	public static final ResourceKey<EquipmentAsset> GREEN_TERRY_MAT = IcariaEquipmentAssetIds.create("green_terry_mat");
	public static final ResourceKey<EquipmentAsset> CYAN_TERRY_MAT = IcariaEquipmentAssetIds.create("cyan_terry_mat");
	public static final ResourceKey<EquipmentAsset> LIGHT_BLUE_TERRY_MAT = IcariaEquipmentAssetIds.create("light_blue_terry_mat");
	public static final ResourceKey<EquipmentAsset> BLUE_TERRY_MAT = IcariaEquipmentAssetIds.create("blue_terry_mat");
	public static final ResourceKey<EquipmentAsset> PURPLE_TERRY_MAT = IcariaEquipmentAssetIds.create("purple_terry_mat");
	public static final ResourceKey<EquipmentAsset> MAGENTA_TERRY_MAT = IcariaEquipmentAssetIds.create("magenta_terry_mat");
	public static final ResourceKey<EquipmentAsset> PINK_TERRY_MAT = IcariaEquipmentAssetIds.create("pink_terry_mat");

	public static ResourceKey<EquipmentAsset> create(String pName) {
		return ResourceKey.create(IcariaRegistryIds.EQUIPMENT_ASSET, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
