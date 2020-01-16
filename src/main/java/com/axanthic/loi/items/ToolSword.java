package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources.CompleteToolMaterial;
import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.translation.I18n;

public class ToolSword extends ItemSword {
	
	public CompleteToolMaterial material;

	public ToolSword(CompleteToolMaterial material) {
		super(material.material);
		this.material = material;
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("generic.sword");
		this.setRegistryName(ModInformation.ID, "sword_" + material.material.name().substring(ModInformation.ID.length() + 1));
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (I18n.canTranslate("item.sword_" + material.material.name().substring(ModInformation.ID.length() + 1) + ".name"))
			return I18n.translateToLocal("item.sword_" + material.material.name().substring(ModInformation.ID.length() + 1) + ".name");
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + material.material.name().substring(ModInformation.ID.length() + 1) + ".name"));
		} catch (Exception e) {
			return I18n.translateToLocal(this.getUnlocalizedName() + ".name");
		}
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.material.material.getAttackDamage() + 3.0D, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.material.attackSpeed - 1.4D, 0));
		}
		return multimap;
	}
}
