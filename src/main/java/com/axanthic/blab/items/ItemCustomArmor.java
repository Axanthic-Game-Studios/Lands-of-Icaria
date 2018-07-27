package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemCustomArmor extends ItemArmor {
	
	String materialName;

	public ItemCustomArmor(ItemArmor.ArmorMaterial material, EntityEquipmentSlot slot) {
		super(material, 0, slot);
		materialName = material.name().substring(ModInformation.ID.length() + 1);
		String type = "boots";
		if (slot.equals(EntityEquipmentSlot.HEAD))
			type = "helmet";
		else if (slot.equals(EntityEquipmentSlot.CHEST))
			type = "chestplate";
		else if (slot.equals(EntityEquipmentSlot.LEGS))
			type = "legs";
		this.setCreativeTab(Blab.modTabItems);
		this.setUnlocalizedName("generic." + type);
		this.setRegistryName(ModInformation.ID, type + "_" + materialName);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + materialName + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}
}
