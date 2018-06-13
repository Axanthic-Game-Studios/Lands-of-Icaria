package com.axanthic.blab.items;

import com.axanthic.blab.Blab;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;

public class ItemBasic extends Item {

	public ItemBasic(String name) {
		super();
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName(name);
		this.setRegistryName("blab", name);
	}
}
