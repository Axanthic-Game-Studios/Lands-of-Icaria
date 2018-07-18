package com.axanthic.blab.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTab extends CreativeTabs {

	public ItemStack icon;

	public CreativeTab(String label) {
		super(label);
	}

	public void setTabIconItem(ItemStack icon) {
		this.icon = icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return icon;
	}

	@Override
	public ItemStack getTabIconItem() {
		return icon;
	}

	@Override
	public void displayAllRelevantItems(NonNullList<ItemStack> items) {
        super.displayAllRelevantItems(items);
	}
}
