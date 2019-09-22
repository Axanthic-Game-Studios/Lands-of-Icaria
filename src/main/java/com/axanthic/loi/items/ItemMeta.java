package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMeta extends Item implements IItemMeta {

	public String[] names;

	public ItemMeta(String name, String[] names) {
		super();
		this.names = names;
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + names[stack.getMetadata()];
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (tab.equals(this.getCreativeTab()))
			for (int i = 0; i < names.length; i++) {
				items.add(new ItemStack(this, 1, i));
			}
	}

	@Override
	public String[] getNames() {
		return names;
	}
}
