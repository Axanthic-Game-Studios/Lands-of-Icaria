package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;
import com.axanthic.icaria.data.registry.IcariaEquipmentAssets;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.EnumMap;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Holder;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArmorMaterials {
	public static final ArmorMaterial AETERNAE_HIDE = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), (enumMap) -> {
		enumMap.put(ArmorType.BOOTS, 1);
		enumMap.put(ArmorType.LEGGINGS, 2);
		enumMap.put(ArmorType.CHESTPLATE, 3);
		enumMap.put(ArmorType.HELMET, 1);
		enumMap.put(ArmorType.BODY, 3);
	}), 15, Holder.direct(IcariaSoundEvents.AETERNAE_HIDE_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_AETERNAE_HIDE_ARMOR, IcariaEquipmentAssets.AETERNAE_HIDE);

	public static final ArmorMaterial CHALKOS = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), (enumMap) -> {
		enumMap.put(ArmorType.BOOTS, 1);
		enumMap.put(ArmorType.LEGGINGS, 3);
		enumMap.put(ArmorType.CHESTPLATE, 4);
		enumMap.put(ArmorType.HELMET, 1);
		enumMap.put(ArmorType.BODY, 4);
	}), 15, Holder.direct(IcariaSoundEvents.CHALKOS_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_CHALKOS_ARMOR, IcariaEquipmentAssets.CHALKOS);

	public static final ArmorMaterial KASSITEROS = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), (enumMap) -> {
		enumMap.put(ArmorType.BOOTS, 2);
		enumMap.put(ArmorType.LEGGINGS, 3);
		enumMap.put(ArmorType.CHESTPLATE, 5);
		enumMap.put(ArmorType.HELMET, 1);
		enumMap.put(ArmorType.BODY, 5);
	}), 15, Holder.direct(IcariaSoundEvents.KASSITEROS_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_KASSITEROS_ARMOR, IcariaEquipmentAssets.KASSITEROS);

	public static final ArmorMaterial ORICHALCUM = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), (enumMap) -> {
		enumMap.put(ArmorType.BOOTS, 2);
		enumMap.put(ArmorType.LEGGINGS, 4);
		enumMap.put(ArmorType.CHESTPLATE, 6);
		enumMap.put(ArmorType.HELMET, 2);
		enumMap.put(ArmorType.BODY, 6);
	}), 19, Holder.direct(IcariaSoundEvents.ORICHALCUM_ARMOR_EQUIP), 1.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_ORICHALCUM_ARMOR, IcariaEquipmentAssets.ORICHALCUM);

	public static final ArmorMaterial VANADIUMSTEEL = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), (enumMap) -> {
		enumMap.put(ArmorType.BOOTS, 3);
		enumMap.put(ArmorType.LEGGINGS, 5);
		enumMap.put(ArmorType.CHESTPLATE, 7);
		enumMap.put(ArmorType.HELMET, 3);
		enumMap.put(ArmorType.BODY, 7);
	}), 11, Holder.direct(IcariaSoundEvents.VANADIUMSTEEL_ARMOR_EQUIP), 1.5F, 0.0F, IcariaItemTagsProvider.REPAIRS_VANADIUMSTEEL_ARMOR, IcariaEquipmentAssets.VANADIUMSTEEL);

	public static final ArmorMaterial LAUREL = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), (enumMap) -> {
		enumMap.put(ArmorType.BOOTS, 0);
		enumMap.put(ArmorType.LEGGINGS, 0);
		enumMap.put(ArmorType.CHESTPLATE, 0);
		enumMap.put(ArmorType.HELMET, 0);
		enumMap.put(ArmorType.BODY, 0);
	}), 15, Holder.direct(IcariaSoundEvents.LAUREL_WREATH_EQUIP), 0.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_LAUREL_WREATH, IcariaEquipmentAssets.LAUREL);
}
