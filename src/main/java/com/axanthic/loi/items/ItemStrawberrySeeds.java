package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class ItemStrawberrySeeds extends ItemSeeds {
	public ItemStrawberrySeeds(String name, Block crops, Block soil) {
		super(crops, soil);
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
}
