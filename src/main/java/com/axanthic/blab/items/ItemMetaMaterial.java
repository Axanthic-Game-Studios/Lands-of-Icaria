package com.axanthic.blab.items;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ItemMetaMaterial extends ItemMeta {

	public ItemMetaMaterial(String name, String[] names) {
		super(name, names);
		this.setUnlocalizedName("generic." + name);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + names[stack.getItemDamage()] + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}
}
