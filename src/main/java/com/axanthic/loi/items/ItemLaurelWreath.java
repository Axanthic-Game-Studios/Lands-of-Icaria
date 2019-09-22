package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemLaurelWreath extends ItemArmor {

	public ItemLaurelWreath() {
		super(EnumHelper.addArmorMaterial("laurel", ModInformation.ID + ":" + "armor_laurel", 0, new int[]{0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F), 0, EntityEquipmentSlot.HEAD);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("laurel_wreath");
		this.setRegistryName(ModInformation.ID, "laurel_wreath");
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		return HashMultimap.<String, AttributeModifier>create();
	}
}
