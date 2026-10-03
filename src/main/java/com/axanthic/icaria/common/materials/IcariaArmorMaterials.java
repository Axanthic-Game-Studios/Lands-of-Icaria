package com.axanthic.icaria.common.materials;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaEquipmentAssetIds;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.tags.IcariaItemTags;

import java.util.Map;

import net.minecraft.core.Holder;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArmorMaterials {
	public static final ArmorMaterial AETERNAE_HIDE = new ArmorMaterial(5, Map.of(ArmorType.BOOTS, 1, ArmorType.LEGGINGS, 2, ArmorType.CHESTPLATE, 3, ArmorType.HELMET, 1, ArmorType.BODY, 3), 5, Holder.direct(IcariaSoundEvents.AETERNAE_HIDE_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTags.REPAIRS_AETERNAE_HIDE_ARMOR, IcariaEquipmentAssetIds.AETERNAE_HIDE);
	public static final ArmorMaterial CHALKOS = new ArmorMaterial(11, Map.of(ArmorType.BOOTS, 1, ArmorType.LEGGINGS, 3, ArmorType.CHESTPLATE, 4, ArmorType.HELMET, 2, ArmorType.BODY, 4), 10, Holder.direct(IcariaSoundEvents.CHALKOS_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTags.REPAIRS_CHALKOS_ARMOR, IcariaEquipmentAssetIds.CHALKOS);
	public static final ArmorMaterial KASSITEROS = new ArmorMaterial(15, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 4, ArmorType.CHESTPLATE, 5, ArmorType.HELMET, 2, ArmorType.BODY, 5), 10, Holder.direct(IcariaSoundEvents.KASSITEROS_ARMOR_EQUIP), 0.0F, 0.0F, IcariaItemTags.REPAIRS_KASSITEROS_ARMOR, IcariaEquipmentAssetIds.KASSITEROS);
	public static final ArmorMaterial ORICHALCUM = new ArmorMaterial(26, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 3, ArmorType.BODY, 6), 15, Holder.direct(IcariaSoundEvents.ORICHALCUM_ARMOR_EQUIP), 1.5F, 0.0F, IcariaItemTags.REPAIRS_ORICHALCUM_ARMOR, IcariaEquipmentAssetIds.ORICHALCUM);
	public static final ArmorMaterial VANADIUMSTEEL = new ArmorMaterial(37, Map.of(ArmorType.BOOTS, 3, ArmorType.LEGGINGS, 6, ArmorType.CHESTPLATE, 7, ArmorType.HELMET, 3, ArmorType.BODY, 7), 15, Holder.direct(IcariaSoundEvents.VANADIUMSTEEL_ARMOR_EQUIP), 3.0F, 0.0F, IcariaItemTags.REPAIRS_VANADIUMSTEEL_ARMOR, IcariaEquipmentAssetIds.VANADIUMSTEEL);
	public static final ArmorMaterial LAUREL = new ArmorMaterial(5, Map.of(ArmorType.BOOTS, 1, ArmorType.LEGGINGS, 2, ArmorType.CHESTPLATE, 3, ArmorType.HELMET, 1, ArmorType.BODY, 3), 5, Holder.direct(IcariaSoundEvents.LAUREL_WREATH_EQUIP), 0.0F, 0.0F, IcariaItemTags.REPAIRS_LAUREL_WREATH, IcariaEquipmentAssetIds.LAUREL);
}
