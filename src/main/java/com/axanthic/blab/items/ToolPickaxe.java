package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources.CompleteToolMaterial;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ToolPickaxe extends ItemPickaxe {

	public ToolPickaxe(CompleteToolMaterial material) {
		super(material.material);
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("pickaxe");
		this.setRegistryName(ModInformation.ID, "pickaxe_" + material.material.name().substring(ModInformation.ID.length() + 1));
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
