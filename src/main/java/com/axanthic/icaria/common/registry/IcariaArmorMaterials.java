package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;

import java.util.EnumMap;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArmorMaterials {
	public static final ArmorMaterial AETERNAE_HIDE = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), map -> {
		map.put(ArmorType.BOOTS, 1);
		map.put(ArmorType.LEGGINGS, 2);
		map.put(ArmorType.CHESTPLATE, 3);
		map.put(ArmorType.HELMET, 1);
		map.put(ArmorType.BODY, 3);
	}), 15, Holder.direct(IcariaSoundEvents.AETERNAE_HIDE_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_AETERNAE_HIDE_ARMOR, IcariaResourceLocations.AETERNAE_HIDE);

	public static final ArmorMaterial CHALKOS = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), map -> {
		map.put(ArmorType.BOOTS, 1);
		map.put(ArmorType.LEGGINGS, 3);
		map.put(ArmorType.CHESTPLATE, 4);
		map.put(ArmorType.HELMET, 1);
		map.put(ArmorType.BODY, 4);
	}), 15, Holder.direct(IcariaSoundEvents.CHALKOS_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_CHALKOS_ARMOR, IcariaResourceLocations.CHALKOS);

	public static final ArmorMaterial KASSITEROS = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), map -> {
		map.put(ArmorType.BOOTS, 2);
		map.put(ArmorType.LEGGINGS, 3);
		map.put(ArmorType.CHESTPLATE, 5);
		map.put(ArmorType.HELMET, 1);
		map.put(ArmorType.BODY, 5);
	}), 15, Holder.direct(IcariaSoundEvents.KASSITEROS_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_KASSITEROS_ARMOR, IcariaResourceLocations.KASSITEROS);

	public static final ArmorMaterial ORICHALCUM = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), map -> {
		map.put(ArmorType.BOOTS, 2);
		map.put(ArmorType.LEGGINGS, 4);
		map.put(ArmorType.CHESTPLATE, 6);
		map.put(ArmorType.HELMET, 2);
		map.put(ArmorType.BODY, 6);
	}), 19, Holder.direct(IcariaSoundEvents.ORICHALCUM_ARMOR_EQUIP), 1.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_ORICHALCUM_ARMOR, IcariaResourceLocations.ORICHALCUM);

	public static final ArmorMaterial VANADIUMSTEEL = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), map -> {
		map.put(ArmorType.BOOTS, 3);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.CHESTPLATE, 7);
		map.put(ArmorType.HELMET, 3);
		map.put(ArmorType.BODY, 7);
	}), 11, Holder.direct(IcariaSoundEvents.VANADIUMSTEEL_ARMOR_EQUIP), 1.5F, 0.0F, IcariaItemTagsProvider.REPAIRS_VANADIUMSTEEL_ARMOR, IcariaResourceLocations.VANADIUMSTEEL);

	public static final ArmorMaterial LAUREL = new ArmorMaterial(21, Util.make(new EnumMap<>(ArmorType.class), map -> {
		map.put(ArmorType.BOOTS, 0);
		map.put(ArmorType.LEGGINGS, 0);
		map.put(ArmorType.CHESTPLATE, 0);
		map.put(ArmorType.HELMET, 0);
		map.put(ArmorType.BODY, 0);
	}), 15, Holder.direct(IcariaSoundEvents.LAUREL_WREATH_EQUIP), 0.0F, 0.0F, IcariaItemTagsProvider.REPAIRS_LAUREL_WREATH, IcariaResourceLocations.LAUREL);
}
