package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class ItemCustomSeeds extends ItemSeeds {
	public ItemCustomSeeds(String name, Block crops) {
		super(crops, Resources.farmLand.getBlock());
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
}
