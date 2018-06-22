package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources.CompleteToolMaterial;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.text.translation.I18n;

public class ToolSword extends ItemSword {
	
	public CompleteToolMaterial material;

	public ToolSword(CompleteToolMaterial material) {
		super(material.material);
		this.material = material;
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("sword");
		this.setRegistryName(ModInformation.ID, "sword_" + material.material.name().substring(ModInformation.ID.length() + 1));
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + material.material.name().substring(ModInformation.ID.length() + 1) + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}
}
