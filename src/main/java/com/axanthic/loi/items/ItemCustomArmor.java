package com.axanthic.loi.items;

import javax.annotation.Nullable;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.render.ModelArmorOrichalcum;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCustomArmor extends ItemArmor {

	@SideOnly(Side.CLIENT)
	public static ModelBiped orichalcumModel = new ModelArmorOrichalcum();

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
		this.setCreativeTab(LandsOfIcaria.modTabItems);
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

	@Override
	@SideOnly(Side.CLIENT)
	@Nullable
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped defaultModel) {
		if(!stack.isEmpty() && stack.getItem() instanceof ItemArmor) {
			if (((ItemArmor) stack.getItem()).getArmorMaterial().name().equals(ModInformation.ID + ":orichalcum") && slot != EntityEquipmentSlot.LEGS)
				return orichalcumModel;
		}
		return defaultModel;
	}
}
