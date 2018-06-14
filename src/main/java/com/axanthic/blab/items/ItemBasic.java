package com.axanthic.blab.items;

import com.axanthic.blab.Blab;

import net.minecraft.item.Item;

public class ItemBasic extends Item {

	public ItemBasic(String name) {
		super();
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName(name);
		this.setRegistryName("blab", name);
	}
}
