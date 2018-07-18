package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources.CompleteToolMaterial;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ToolAxe extends ItemAxe {

	public ToolAxe(CompleteToolMaterial material) {
		super(material.material, material.material.getAttackDamage() + 6.0F, material.attackSpeed - 2.0F);
		this.setCreativeTab(Blab.modTabItems);
		this.setUnlocalizedName("generic.axe");
		this.setRegistryName(ModInformation.ID, "axe_" + material.material.name().substring(ModInformation.ID.length() + 1));
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + toolMaterial.name().substring(ModInformation.ID.length() + 1) + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}
}
