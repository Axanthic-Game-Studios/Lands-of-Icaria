package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemLaurelWreath extends ItemArmor {

	public ItemLaurelWreath() {
		super(EnumHelper.addArmorMaterial("laurel", "blab:armor_laurel", 0, new int[]{0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F), 0, EntityEquipmentSlot.HEAD);
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("laurel_wreath");
		this.setRegistryName(ModInformation.ID, "laurel_wreath");
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		return HashMultimap.<String, AttributeModifier>create();
	}
}
